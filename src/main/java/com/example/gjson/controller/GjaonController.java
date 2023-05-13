package com.example.gjson.controller;

import com.example.gjson.dto.Customer;
import com.example.gjson.service.GjsonService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GjaonController {

    private final GjsonService gjsonService;

    @GetMapping("/jsontostring")
    public String jsontostring(Model model){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "hello");
        jsonObject.addProperty("id", 1234);

        String result = gjsonService.jsonToString(jsonObject);
        System.out.println(result);

        return "home";
    }

    @GetMapping("/objecttojson")
    public String objecttojson(Model model){

        Customer customer = new Customer();
        customer.setAge(3);
        customer.setCustname("jh");

        String result = gjsonService.objectToJson(customer);
        System.out.println(result);

        return "home";
    }

    @GetMapping("/jsontoobject")
    public String jsontoobject(Model model){

        String json = "{age:1,custname:jh}";

        Customer customer = gjsonService.jsonToObject(json);

        System.out.println(customer.getAge());
        System.out.println(customer.getCustname());

        return "home";
    }

    @GetMapping("/maptojson")
    public String maptojson(Model model){
        Map<String, String> map = new HashMap<>();
        map.put("name","jh");
        map.put("age", "123");

        String result = gjsonService.mapToJson(map);
        System.out.println(result);

        return "home";
    }

    @GetMapping("/jsontomap")
    public String jsontomap(Model model){
        String json = "{'age':'1','custname':'jh'}";

        Map<String, Object> map = gjsonService.jsonToMap(json);

        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        return "home";
    }

    @GetMapping("/nullObject")
    public String nullObject(Model model){
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", null);
        jsonObject.addProperty("age", 9);

        String result = gjsonService.jsonToStringNullObejct(jsonObject);

        System.out.println(result);

        return "home";
    }


}
