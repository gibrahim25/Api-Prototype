package com.csc340Assignment2.demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ApiController {

    @GetMapping("/videogames")
    public Object getVideoGameStatus (@RequestParam(value = "name", defaultValue = "o")String vg) throws JsonProcessingException {
        try {
            String url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15" + vg;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            videogames vg1 = new videogames(root.get("name").asText(), root.get("storeID").asInt(), root.get("salePrice").asInt());
            return vg1;

        } catch  (JsonProcessingException ex) {
            Logger.getLogger(ApiController.class.getName()).log(Level.SEVERE, null, ex);
            return "error in /videogames";
        }


    }

}
