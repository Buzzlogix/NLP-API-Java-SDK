/*
 * BuzzlogixTextAnalysisAPILib
 *
 * This file was automatically generated for buzzlogix by APIMATIC BETA v2.0 on 11/25/2015
 */
package com.buzzlogix.http.client;

import com.buzzlogix.http.request.HttpRequest;
import com.buzzlogix.http.response.HttpResponse;

public class HttpContext {
    private HttpRequest _request;
    private HttpResponse _response;

    public HttpContext(HttpRequest request, HttpResponse response) {
        _request = request;
        _response = response;
    }

    /**
     * GETTER for the Http Request
     * @return HttpRequest request
     */
    public HttpRequest getRequest() {
        return _request;
    }

    /**
     * GETTER for the Http Response
     * @return HttpResponse response
     */
    public HttpResponse getRespone() {
        return _response;
    }
}