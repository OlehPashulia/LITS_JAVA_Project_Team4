package ua.com.lits.my.parsingFiles;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by olesia on 12.09.15.
 */
public class ParseJSON {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// path to file
		try {
			InputStream input = new FileInputStream("footballTeams.json");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			TypeFactory typeFactory = TypeFactory.defaultInstance();
			List<MapJSON> fileValues = objectMapper.readValue(input,
					typeFactory.constructCollectionType(ArrayList.class, MapJSON.class));
			Collections.sort(fileValues, new YearComparator());
			System.out.println("LIST OF FOOTBALL CLUBS SORTED BY FOUNDATION YEAR:");
			for (MapJSON i : fileValues) {
				System.out.println("Id: " + i.getId() + ";");
				System.out.println("Team Name: " + i.getTeam_name() + ";");
				System.out.println("Foundation Year: " + i.getFounded() + ";");
				System.out.println("Head Coach: " + i.getHead_coach() + ";");
				System.out.println("City: " + i.getCity_based() + ";");
				System.out.println("---------------------------------------------");
			}
		}

		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (JsonParseException e) {
			System.err.println("The input is not valid JSON. " + e.getMessage());
		} catch (JsonMappingException e) {
			System.err.println("The input JSON doesn't match. " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO error while reading the JSON. " + e.getMessage());
		}
	}
}
