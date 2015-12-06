/*
 * BuzzlogixTextAnalysisAPILib
 *
 * This file was automatically generated for buzzlogix by APIMATIC BETA v2.0 on 12/06/2015
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

public class SentimentController extends BaseController {

    //private fields for configuration

   /** Supply your API Key.  */
    private String xMashapeKey;

   /**
    * Constructor with authentication and configuration parameters */
    public SentimentController (String xMashapeKey) {
        this.xMashapeKey = xMashapeKey;
    }

   /**
    * Constructor with authentication and configuration parameters */
    public SentimentController (HttpClient _client, String xMashapeKey) {
        super(_client);
        this.xMashapeKey = xMashapeKey;
    }

    /**
     * The text should be provided as text/plain in the body
     * @param    body    Required parameter: Supply text to be classified.
	 * @return	Returns the LinkedHashMap<String, Object> response from the API call*/
    public void createReturnEnglishGeneralSentimentPlaintextAsync(
            final String body,
            final APICallBack<LinkedHashMap<String, Object>> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/sentiment");
        //validate and preprocess url
        String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5577417982066904950L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-Mashape-Key", xMashapeKey );
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
                            if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
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
     * The text should be provided as multipart/form-data with the key 'text'. Files can be uploaded.
     * @param    text    Required parameter: Supply text to be classified.
	 * @return	Returns the LinkedHashMap<String, Object> response from the API call*/
    public void createReturnEnglishGeneralSentimentMultipartFormAsync(
            final File text,
            final APICallBack<LinkedHashMap<String, Object>> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/sentiment");
        //validate and preprocess url
        String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5120493593272139569L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-Mashape-Key", xMashapeKey );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5608969398536201097L;
            {
                    put( "text", text );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest request = clientInstance.post(queryUrl, headers, APIHelper.prepareFormFields(parameters));

        //invoke request and get response
        Runnable responseTask = new Runnable() {
            public void run() {
                //make the API call
                clientInstance.executeAsStringAsync(request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext context, HttpResponse response) {
                        try {
                            //Error handling using HTTP status codes
                            int responseCode = response.getStatusCode();
                            if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
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
     * Return the sentiment of an English text supplied in an encoded form using key 'text'.
     * @param    text    Required parameter: Supply the text to be classified.
	 * @return	Returns the LinkedHashMap<String, Object> response from the API call*/
    public void createReturnEnglishGeneralSentimentEncodedFormAsync(
            final String text,
            final APICallBack<LinkedHashMap<String, Object>> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/sentiment");
        //validate and preprocess url
        String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4756731401855773310L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-Mashape-Key", xMashapeKey );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5237890445798067396L;
            {
                    put( "text", text );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest request = clientInstance.post(queryUrl, headers, APIHelper.prepareFormFields(parameters));

        //invoke request and get response
        Runnable responseTask = new Runnable() {
            public void run() {
                //make the API call
                clientInstance.executeAsStringAsync(request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext context, HttpResponse response) {
                        try {
                            //Error handling using HTTP status codes
                            int responseCode = response.getStatusCode();
                            if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
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