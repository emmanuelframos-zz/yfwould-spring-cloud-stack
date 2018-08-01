package com.partytime.rest;

import com.partytime.exception.ExceptionMessages;
import com.partytime.exception.TechnicalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/** Pay attention on code below **/
public final class UnderratedRestClient<E> {

    private Logger logger = LoggerFactory.getLogger(UnderratedRestClient.class);

    private String baseUrl;

    private String resource;

    private HttpMethod method;

    private HttpHeaders headers;

    private E payload;

    private List<ClientHttpRequestInterceptor> interceptors;

    private Collection<HttpMessageConverter> messageConverters;

    private UnderratedRestClient(){
        this.headers = new HttpHeaders();
        this.baseUrl = StringUtils.EMPTY;
        this.resource = StringUtils.EMPTY;
        this.interceptors = new ArrayList<>();
        this.messageConverters = new ArrayList<>();
    }

    public static UnderratedRestClient build(){
        return new UnderratedRestClient();
    }

    public UnderratedRestClient baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public UnderratedRestClient method(HttpMethod method) {
        this.method = method;
        return this;
    }

    public UnderratedRestClient resource(String resource) {
        this.resource = resource;
        return this;
    }

    public UnderratedRestClient payload(E payload) {
        this.payload = payload;
        return this;
    }

    public UnderratedRestClient addHeader(String name, String value) {
        this.headers.add(name, value);
        return this;
    }

    public UnderratedRestClient addInterceptor(ClientHttpRequestInterceptor interceptor){
        this.interceptors.add(interceptor);
        return this;
    }

    public UnderratedRestClient addMessageConverter(HttpMessageConverter messageConverter){
        this.messageConverters.add(messageConverter);
        return this;
    }

    private HttpEntity getEntity(){
        return Objects.isNull(this.payload )
                ? new HttpEntity<>(this.headers)
                : new HttpEntity<>(this.payload, this.headers);
    }
    public <T> ResponseEntity<T> execute(Class<T> responseType) {

        HttpEntity entity = this.getEntity();

        String requestUrl = this.baseUrl + this.resource;

        RestTemplate restTemplate = RestTemplateBuilder.build();
        restTemplate.getInterceptors().addAll(interceptors);

        try{
            return restTemplate.exchange(requestUrl, method, entity, responseType);
        }catch(RestClientException ex){
            logger.error(((HttpClientErrorException)ex).getResponseBodyAsString(), ex);
            throw new TechnicalException(ExceptionMessages.ERROR_ON_SPOTIFY);
        }
    }
}