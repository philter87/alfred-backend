package com.alfred.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;

/**
 * Created by phili on 05-12-2015.
 */
public class HeaderUtils {
    public static HttpHeaders createHeader(final String username,final String password){
        return new HttpHeaders(){
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")) );
                String authHeader = "Basic " + new String( encodedAuth );
                set( "Authorization", authHeader );

            }
        };
    }
}
