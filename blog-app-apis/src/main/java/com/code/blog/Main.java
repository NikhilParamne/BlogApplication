package com.code.blog;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        // Set up Confluence API endpoint and credentials
        String apiEndpoint = "https://nikhilparamne.atlassian.net/wiki/rest/api";
        String username = "Nikhil Paramne";
        String password = "48678212";

        // Define the page ID of the Confluence page you want to attach the file to
        String pageId = "33068";

        // Write CSV data to a ByteArrayOutputStream
        ByteArrayOutputStream csvOutput = new ByteArrayOutputStream();
        try (OutputStreamWriter writer = new OutputStreamWriter(csvOutput, StandardCharsets.UTF_8)) {
            // write your csv data using writer.write() method

            writer.write("header1,header2,header3\n");
            writer.write("data1,data2,data3\n");
            writer.write("data4,data5,data6\n");
            writer.close();
        }
        byte[] csvBytes = csvOutput.toByteArray();

        // Set up HTTP client with authentication
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiEndpoint + "/content/" + pageId + "/child/attachment");
        httpPost.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

        // Set up multipart/form-data with CSV file bytes
        ByteArrayBody fileBody = new ByteArrayBody(csvBytes, ContentType.create("text/csv"), "output.csv");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("file", fileBody);
        httpPost.setEntity(builder.build());

        // Set HTTP headers with Content-Type and X-Atlassian-Token
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "multipart/form-data");
        httpPost.setHeader("X-Atlassian-Token", "no-check");

        // Execute the HTTP POST request to attach the file to the Confluence page
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // Print the response to confirm file was attached successfully
        System.out.println("File output.csv attached to Confluence page " + pageId + ". Response: " + response.getStatusLine().getStatusCode());

        // Close the HTTP client and response
        response.close();
        httpClient.close();
    }
}


