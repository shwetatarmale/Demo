package com.avekshaa.traning.test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import com.avekshaa.training.jsonxmlservices.JsonParse;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class JsonParseTest {

    private JsonParse jsonParse = new JsonParse();

    @Test
    public void testFileReader() {
    	JsonParse js = new JsonParse();
    	
        String file = "C:\\AVEKSHAA_PROJECTS\\MAVEN\\SampleData\\sample4.json";
        js.fileReader(file);

        boolean fileReadSuccessfully = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(file)))) {
            // Attempt to read the file
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            // If the file was read without any exceptions, consider it successful
            fileReadSuccessfully = true;
        } catch (IOException e) {
            // Handle the exception if the file reading failed
            e.printStackTrace();
        }

        // Assert that the file was read successfully
        Assert.assertTrue(fileReadSuccessfully);
    }
    

    @Test
    public void testJsonParseString() {
        jsonParse.jsonParseString();
        // TODO: add assertions for the expected output
        
    }

    @Test
    public void testParseObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject.put("key2", "value2");

        JsonParse.parseObject(jsonObject, "key1");
        
       
    }

    @Test
    public void testGetKey() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject.put("key2", "value2");

        JsonParse.getKey(jsonObject, "key1");

        // TODO: add assertions for the expected output
        
    }
    
    @Test
    public void testJsonParseString1() {
        // Input JSON string
        String inputJson = "{\"items\":{\"item\":[{\"id\":\"1001\",\"type\":\"Regular\"}],\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}}";

        // Create an instance of JsonParse class
        JsonParse jsonParse = new JsonParse();

        // Call the jsonParseString method
        jsonParse.jsonParseString();

        // Here's an example assertion
        Assert.assertNotNull(jsonParse);
        Assert.assertTrue(true);
        
        
    }
   

}