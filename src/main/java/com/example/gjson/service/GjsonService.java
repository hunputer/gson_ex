package com.example.gjson.service;

import com.example.gjson.dto.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GjsonService {

    Gson gson = new Gson();
    Gson gsonNullObejct = new GsonBuilder().serializeNulls().create();

    public String jsonToString(JsonObject jsonObject){
        return gson.toJson(jsonObject);
    }

    public String objectToJson(Object object){
        return gson.toJson(object);
    }

    public Customer jsonToObject(String str){
        return gson.fromJson(str, Customer.class);
    }

    public String mapToJson(Map map){
        return gson.toJson(map);
    }

    public Map jsonToMap(String json){
        return gson.fromJson(json, Map.class);
    }

    public String jsonToStringNullObejct(JsonObject json){
        return gsonNullObejct.toJson(json);
    }

}
