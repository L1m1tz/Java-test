package com.andrew.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJson {

        @SuppressWarnings("unchecked")
        public void writeJava( UserRepository repository) {
            //First user
            JSONObject userDetails = new JSONObject();
            userDetails.put("firstName", "Brian");
            userDetails.put("lastName", "James");
            userDetails.put("contactNumber", "0662188654");

            JSONObject userObject = new JSONObject();
            userObject.put("user", userDetails);

            //Second user
            JSONObject userDetails2 = new JSONObject();
            userDetails2.put("firstName", "John");
            userDetails2.put("lastName", "Doe");
            userDetails2.put("contactNumber", "0662188654");

            JSONObject userObject2 = new JSONObject();
            userObject2.put("user", userDetails2);

            //Add user to list
            JSONArray userList = new JSONArray();
            userList.add(userObject);
            userList.add(userObject2);

            //Write JSON file
            try (FileWriter file = new FileWriter("user.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(userList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
