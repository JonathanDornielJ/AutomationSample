package com.banking.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


public class Utilities {
	public List<HashMap<String,String>> convertJSONToMap(String filePath) throws IOException {
		// convert JSON to string variable which will hold the entire JSON content
		String jsonContent = FileUtils.readFileToString(
				new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap conversion using Jackson Databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
		
		return data;
		}
        

}
