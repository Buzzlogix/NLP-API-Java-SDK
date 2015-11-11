/*
 * BuzzlogixTextAnalysisAPILib
 *
 * This file was automatically generated for Buzzlogix by APIMATIC BETA v2.0 on 11/09/2015
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

public class ObjectivityController extends BaseController {
    /**
     * Initialize the base controller using the given http client
     */
    public ObjectivityController() {
        super();
    }

    /**
     * Initialize the base controller using the given http client
     *
     * @param _client The given http client */
    public ObjectivityController(HttpClient _client) {
        super(_client);
    }

    /**
     * Use this endpoint to retrieve whether the provided text is subjective or objective.
     * @param    body    Required parameter: Supply text to be classified.
	 * @return	Returns the void response from the API call*/
    public void createReturnObjectivityAsync(
            final String body,
            final APICallBack<Object> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/objectivity");

        //validate and preprocess url
        String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5070456715930083234L;
            {
                    put( "user-agent", "APIMATIC 2.0" );                    put( "apikey", Configuration.apikey );

            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest request = clientInstance.postBody(queryUrl, headers, body);

        //Custom Authentication to be added for authorization
        CustomAuthUtility.appendCustomAuthParams(request);

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

                            //let the caller know of the success
                            callBack.onSuccess(context, context);
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