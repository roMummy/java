package com.example.redis.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object> {

    /*序列化*/
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    /*反序列化*/
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];


    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return EMPTY_ARRAY;
        }
        try{
            return  serializer.convert(o);
        }catch (Exception e) {
            return EMPTY_ARRAY;
        }

    }

    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {

        }
        try {
            return deserializer.convert(bytes);
        }catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
    }


    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
