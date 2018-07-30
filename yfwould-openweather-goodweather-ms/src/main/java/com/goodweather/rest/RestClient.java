package com.goodweather.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RestClient<E> {

    private String baseUrl;

    private String resource;

    private HttpMethod method;

    private HttpHeaders headers;

    private E payload;

    private Map<String, String> params;

    private Map<String, String> extraParams;

    private List<ClientHttpRequestInterceptor> interceptors;

    private Collection<HttpMessageConverter> messageConverters;

    private RestClient(){
        this.headers = new HttpHeaders();
        this.baseUrl = StringUtils.EMPTY;
        this.resource = StringUtils.EMPTY;
        this.interceptors = new ArrayList<>();
        this.messageConverters = new ArrayList<>();
        this.params = new HashMap<>();
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
        this.headers.add(name, value);
        return this;
    }

    public RestClient addParam(String name, String value) {
        this.params.put(name, value);
        return this;
    }

    public RestClient addExtraParams(Map<String, String> extraParams) {
        this.extraParams = extraParams;
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

        if (!CollectionUtils.isEmpty(params)){
            requestUrl += mountParamsInRequestUrl(requestUrl);
        }

        RestTemplate restTemplate = RestTemplateBuilder.build();
        restTemplate.getInterceptors().addAll(interceptors);

        return restTemplate.exchange(requestUrl, method, entity, responseType);
    }

    private String mountParamsInRequestUrl(String requestUrl) {
        String queryString = "?" + this.params
                .keySet()
                .stream()
                .map(k -> k + "=" + this.params.get(k))
                .collect(Collectors.joining("&"));

        if (!CollectionUtils.isEmpty(this.extraParams)){
            queryString+= "&" + this.extraParams
                    .keySet()
                    .stream()
                    .map(k -> k + "=" + this.extraParams.get(k))
                    .collect(Collectors.joining("&"));
        }
        return queryString;
    }
}