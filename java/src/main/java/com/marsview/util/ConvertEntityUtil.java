package com.marsview.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class ConvertEntityUtil<T, U> implements Serializable {

    /**
     * 将源对象的字段转换为目标对象所需的格式（如将下划线命名的字段转换为驼峰命名）并赋值给目标对象，返回目标对象实例。
     *
     * @param source 源对象
     * @param targetClass 目标对象的类类型
     * @return 转换并赋值完成后的目标对象实例
     */
    public static <T, U> U ConvertToDto(T source, Class<U> targetClass) {
        try {
            U target = targetClass.newInstance();

            // 获取源对象的所有字段名（包括父类字段）
            Set<String> sourceFieldNames = getCurrentClassFieldNames(source);
            Set<String> targetFieldNames = getCurrentClassFieldNames(target);

            for (String sourceFieldName : sourceFieldNames) {
                if(sourceFieldName.equals("serialVersionUID")){
                    continue;
                }
                // 将源对象字段名转换为目标对象所需的格式（这里以转换为驼峰命名为例）
                String convertFieldName = StrUtil.toCamelCase(sourceFieldName);

                // 获取源对象字段的值
                Object sourceFieldValue = BeanUtil.getFieldValue(source, sourceFieldName);
                for (String targetFieldName : targetFieldNames) {
                    if(targetFieldName.equals(convertFieldName)) {
                        System.out.println("convertFieldName: "+convertFieldName);
                        System.out.println("sourceFieldValue: "+sourceFieldValue);
                        // 将转换后的字段名和获取到的值赋值给目标对象
                        BeanUtil.setFieldValue(target, convertFieldName, sourceFieldValue);
                    }
                }
                BeanUtil.setFieldValue(target, sourceFieldName, sourceFieldValue);
            }

            return target;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 只获取指定对象当前类的字段名，不包括父类字段名。
     *
     * @param object 指定对象
     * @return 该对象当前类的字段名集合
     */
    public static Set<String> getCurrentClassFieldNames(Object object) {
        Set<String> fieldNames = new HashSet<>();
        for (Field field : ReflectUtil.getFields(object.getClass())) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }

    /**
     * 根据字段名获取指定对象的字段值。
     *
     * @param object 指定对象
     * @param fieldName 字段名
     * @return 指定对象中该字段名对应的字段值
     */
    public static Object getFieldValue(Object object, String fieldName) {
        return BeanUtil.getFieldValue(object, fieldName);
    }

    /**
     * 根据字段名设置指定对象的字段值。
     *
     * @param object 指定对象
     * @param fieldName 字段名
     * @param value 要设置的值
     */
    public static void setFieldValue(Object object, String fieldName, Object value) {
        BeanUtil.setFieldValue(object, fieldName, value);
    }

    /**
     * 检查指定对象是否包含指定的字段名（包括父类字段）。
     *
     * @param object 指定对象
     * @param fieldName 字段名
     * @return 如果对象包含该字段名则返回 true，否则返回 false
     */
    public static boolean containsFieldName(Object object, String fieldName) {
        Set<String> fieldNames = getCurrentClassFieldNames(object);

        return fieldNames.contains(fieldName);
    }

    /**
     * 检查指定对象当前类是否包含指定的字段名，不包括父类字段。
     *
     * @param object 指定对象
     * @param fieldName 字段名
     * @return 如果对象当前类包含该字段名则返回 true，否则返回 false
     */
    public static boolean containsCurrentClassFieldName(Object object, String fieldName) {
        Set<String> fieldNames = getCurrentClassFieldNames(object);
        return fieldNames.contains(fieldName);
    }

    /**
     * 获取指定类的所有字段（包括父类字段）。
     *
     * @param clazz 指定类
     * @return 该类的所有字段集合
     */
    public static Field[] getFields(Class<?> clazz) {
        return ReflectUtil.getFields(clazz);
    }

    /**
     * 获取指定类当前类的所有字段，不包括父类字段。
     *
     * @param clazz 指定类
     * @return 该类当前类的所有字段集合
     */
    public static Field[] getCurrentClassFields(Class<?> clazz) {
        return ReflectUtil.getFields(clazz);
    }
}
