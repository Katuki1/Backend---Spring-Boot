package com.iso.iso8583.Mine;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping("/new")
public class ObjectToJson {

//    @GetMapping("/object-json")
    public EntityResponse<Employee> toJson(){

        // Create an object
        Employee employee = new Employee(1, "Faith");

        // Convert object to JSON
        Gson gson = new Gson();
        String json = gson.toJson(employee);

        //print Json
        EntityResponse response = new EntityResponse<>();
        response.setMessage("Converted to json successfully");
        response.setStatusCode(HttpStatus.OK.value());
        response.setEntity(json);
        log.info(json);
        return response;
    }

//    @GetMapping("/json-object")
    public EntityResponse<Employee> fromJson() {

        String json = "{\"id\":1,\"name\":\"Faith\"}";
//        String json = "{\"key\": \"value\"}"; // Your JSON string

        //create an instance on Gson
        Gson gson = new Gson();

        //Parse Json string to Object
        Employee employee = gson.fromJson(json, Employee.class);

        //print obj which is an instance on Employee class
        EntityResponse response = new EntityResponse<>();
        response.setMessage("Converted to object successfully");
        response.setStatusCode(HttpStatus.OK.value());
        response.setEntity(employee);
        log.info(json);
        return response;
    }



}

@Data
@AllArgsConstructor
@ToString
class Employee{
    private int id;
    private String name;
}

