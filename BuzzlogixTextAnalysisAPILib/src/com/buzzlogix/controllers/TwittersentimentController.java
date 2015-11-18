/*
 * BuzzlogixTextAnalysisAPILib
 *
 * This file was automatically generated for Buzzlogix by APIMATIC BETA v2.0 on 11/18/2015
 */
package com.buzzlogix.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.buzzlogix.http.client.HttpClient;
import com.buzzlogix.http.client.HttpContext;
import com.buzzlogix.http.request.HttpRequest;
import com.buzzlogix.http.response.HttpResponse;
import com.buzzlogix.http.response.HttpStringResponse;
import com.buzzlogix.http.client.APICallBack;
import com.buzzlogix.*;

public class TwittersentimentController extends BaseController {

    //private fields for configuration

   /** Supply your API Key.  */
    private String apikey;

   /**
    * Constructor with authentication and configuration parameters */
    public TwittersentimentController (String apikey) {
        this.apikey = apikey;
    }

   /**
    * Constructor with authentication and configuration parameters */
    public TwittersentimentController (HttpClient _client, String apikey) {
        super(_client);
        this.apikey = apikey;
    }

    /**
     * The Tweet should be provided as text/plain in the body
     * @param    body    Required parameter: Supply text to be classified.
	 * @return	Returns the LinkedHashMap<String, Object> response from the API call*/
    public void createReturnEnglishTwitterSentimentAsync(
            final String body,
            final APICallBack<LinkedHashMap<String, Object>> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/twittersentiment");
        //validate and preprocess url
        String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4855427687122907047L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "apikey", apikey );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest request = clientInstance.postBody(queryUrl, headers, body);

        //invoke request and get response
        Runnable responseTask = new Runnable() {
            public void run() {
                //make the API call
                clientInstance.executeAsStringAsync(request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext context, HttpResponse response) {
                        try {
                            //Error handling using HTTP status codes
                            int responseCode = response.getStatusCode();
                            if (responseCode == 401)
                                throw new APIException("No API Key found in headers, body or querystring", 401, response.getRawBody());

                            else if (responseCode == 403)
                                throw new APIException("Invalid authentication credentials", 403, response.getRawBody());

                            else if (responseCode == 429)
                                throw new APIException("API rate limit exceeded", 429, response.getRawBody());

                            else if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
                                throw new APIException("HTTP Response Not OK", responseCode, response.getRawBody());

                            //extract result from the http response
                            LinkedHashMap<String, Object> result = APIHelper.deserialize(((HttpStringResponse)response).getBody());

                            //let the caller know of the success
                            callBack.onSuccess(context, result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(context, exception);
                        }
                    }
                    public void onFailure(HttpContext context, Throwable error) {
                        //let the caller know of the failure
                        callBack.onFailure(context, error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(responseTask);
    }
        
    /**
     * The Tweet should be provided as multipart/form-data with the key 'text'. Files can be uploaded.
     * @param    body    Required parameter: Supply text to be classified.
	 * @return	Returns the LinkedHashMap<String, Object> response from the API call*/
    public void createReturnEnglishTwitterSentimentFormAsync(
            final String body,
            final APICallBack<LinkedHashMap<String, Object>> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/twittersentiment/form");
        //validate and preprocess url
        String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5096036281374262877L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "apikey", apikey );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest request = clientInstance.postBody(queryUrl, headers, body);

        //invoke request and get response
        Runnable responseTask = new Runnable() {
            public void run() {
                //make the API call
                clientInstance.executeAsStringAsync(request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext context, HttpResponse response) {
                        try {
                            //Error handling using HTTP status codes
                            int responseCode = response.getStatusCode();
                            if (responseCode == 401)
                                throw new APIException("No API Key found in headers, body or querystring", 401, response.getRawBody());

                            else if (responseCode == 403)
                                throw new APIException("Invalid authentication credentials", 403, response.getRawBody());

                            else if (responseCode == 429)
                                throw new APIException("API rate limit exceeded", 429, response.getRawBody());

                            else if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
                                throw new APIException("HTTP Response Not OK", responseCode, response.getRawBody());

                            //extract result from the http response
                            LinkedHashMap<String, Object> result = APIHelper.deserialize(((HttpStringResponse)response).getBody());

                            //let the caller know of the success
                            callBack.onSuccess(context, result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(context, exception);
                        }
                    }
                    public void onFailure(HttpContext context, Throwable error) {
                        //let the caller know of the failure
                        callBack.onFailure(context, error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(responseTask);
    }
        
}