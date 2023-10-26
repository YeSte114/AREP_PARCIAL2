/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.arep_parcialt2.services;

import static co.edu.escuelaing.arep_parcialt2.services.SecuenciaLucas.lucas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.jose4j.json.internal.json_simple.JSONObject;

/**
 *
 * @author jeison.barreto
 */
public class MathServices {

    private static JSONObject makeJson(String operation, int input, String output) {
        JSONObject json = new JSONObject();
        json.put("operation", operation);
        json.put("input", input);
        json.put("output", output);
        return json;
    }

    public static JSONObject lucas(int input) throws JsonProcessingException {
        ArrayList<Integer> lucasNumbers = new ArrayList<>();
        lucasNumbers.add(2);
        lucasNumbers.add(1);
        for (int i = 2; i <= input; i++) {
            lucasNumbers.add(lucasNumbers.get(i - 1) + lucasNumbers.get(i - 2));
        }
        // Convertir la lista a JSON
        String json = toJson(lucasNumbers);
        return makeJson("Secuencia de Lucas", input, json.replace("[","").replace("]",""));
    }

    public static String toJson(List<Integer> numbers) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(numbers);
    }
}
