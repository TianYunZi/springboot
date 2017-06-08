package com.boot.convert;

import com.boot.model.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Admin on 2017/6/8.
 * 自定义HttpMessageConvert
 */
public class MyMesageConvert extends AbstractHttpMessageConverter<DemoObj> {

    /**
     * 自定义媒体类型：application/x-wisely
     */
    public MyMesageConvert() {
        super(new MediaType("application", "x-wisely", Charset.forName("utf-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("utf-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]), tempArr[1]);
    }

    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = obj.getId() + "-" + obj.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}
