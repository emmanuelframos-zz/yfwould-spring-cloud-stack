package com.partytime.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RestClient<E> {

    private String baseUrl;

    private String resource;

    private HttpMethod method;

    private HttpHeaders headers;

    private E payload;

    private List<ClientHttpRequestInterceptor> interceptors;

    private Collection<HttpMessageConverter> messageConverters;

    private RestClient(){
        this.headers = new HttpHeaders();
        this.baseUrl = StringUtils.EMPTY;
        this.resource = StringUtils.EMPTY;
        this.interceptors = new ArrayList<>();
        this.messageConverters = new ArrayList<>();
    }

    public static RestClient build(){
        return new RestClient();
    }

    public RestClient baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public RestClient method(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RestClient resource(String resource) {
        this.resource = resource;
        return this;
    }

    public RestClient payload(E payload) {
        this.payload = payload;
        return this;
    }

    public RestClient addHeader(String name, String value) {
        if (this.headers == null)
            this.headers = new HttpHeaders();

        this.headers.add(name, value);

        return this;
    }

    public RestClient addInterceptor(ClientHttpRequestInterceptor interceptor){
        this.interceptors.add(interceptor);
        return this;
    }

    public RestClient addMessageConverter(HttpMessageConverter messageConverter){
        this.messageConverters.add(messageConverter);
        return this;
    }

    private HttpEntity getEntity(){
        return Objects.isNull(payload )
                ? new HttpEntity<>(headers)
                : new HttpEntity<>(payload, headers);
    }
    public <T> ResponseEntity<T> execute(Class<T> responseType) {

        HttpEntity entity = this.getEntity();

        String requestUrl = this.baseUrl + this.resource;

        RestTemplate restTemplate = RestTemplateBuilder.build();
        restTemplate.getInterceptors().addAll(interceptors);

        return restTemplate.exchange(requestUrl, method, entity, responseType);
    }
}