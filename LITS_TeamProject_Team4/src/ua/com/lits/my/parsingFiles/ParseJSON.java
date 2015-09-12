package ua.com.lits.my.parsingFiles;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olesia on 12.09.15.
 */
public class ParseJSON {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // path to file
        InputStream input = new FileInputStream("footballTeams.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        List<MapJSON> fileValues = objectMapper.readValue(input,
                typeFactory.constructCollectionType(ArrayList.class, MapJSON.class));
        System.out.println(fileValues.get(0).getId());
    }
}
