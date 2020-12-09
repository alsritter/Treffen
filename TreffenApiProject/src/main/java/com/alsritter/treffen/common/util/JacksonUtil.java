package com.alsritter.treffen.common.util;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.common.exception.MyErrorException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于转换对象为 JSON 或者反过来
 *
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
public final  class JacksonUtil {
    private JacksonUtil() {}

    public static ObjectMapper objectMapper;

    /**
     * 使用泛型方法，把 json 字符串转换为相应的 JavaBean 对象。
     * (1)转换为普通 JavaBean：readValue(json,Student.class)
     * (2)转换为 List,如 List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     *
     * @param jsonStr json
     * @param valueType 目标类型
     * @return
     */
    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new MyErrorException(ServiceErrorResultEnum.JSON_TO_OBJECT_ERROR);
        }
    }

    /**
     * json 数组转 List
     * @param jsonStr json
     * @param valueTypeRef 目标类型
     * @return
     */
    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef){
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new MyErrorException(ServiceErrorResultEnum.JSON_TO_LIST_ERROR);
        }
    }

    /**
     * 把 JavaBean 转换为 json 字符串
     *
     * @param object 目标对象
     * @return json
     */
    public static String toJSon(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new MyErrorException(ServiceErrorResultEnum.OBJECT_TO_JSON_ERROR);
        }
    }
}
