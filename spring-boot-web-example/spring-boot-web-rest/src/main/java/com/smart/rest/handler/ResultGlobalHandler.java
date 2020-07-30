package com.smart.rest.handler;

import com.smart.rest.annotation.ResultNoHandler;
import com.smart.rest.vo.RespEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
//  如何写出符合企业规范代码
//  返回的结果集统一处理

/**
 * 新建一个统一结果处理的类
 *
 * @RestControllerAdvice 实现ResponseBodyAdvice<T>
 * supports  是否执行beforeBodyWrite方法   true 表示执行  false
 */

@RestControllerAdvice
@Slf4j
public class ResultGlobalHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //1
        log.info("supports");
        return true;
    }

    /**
     * 全局异常处理
     * 全局的结果集处理
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        AnnotatedElement annotatedElement = returnType.getAnnotatedElement();
        ResultNoHandler annotation = AnnotationUtils.findAnnotation(annotatedElement, ResultNoHandler.class);
        return annotation == null ? RespEntity.success(body) : body;
    }
}

