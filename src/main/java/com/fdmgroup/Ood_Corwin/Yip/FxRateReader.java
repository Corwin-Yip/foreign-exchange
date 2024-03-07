package com.fdmgroup.Ood_Corwin.Yip;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FxRateReader {
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static Map<String, FxRate> read(String File) throws StreamReadException, DatabindException, IOException {
		File jsonFile = new File(File);

		Map<String, FxRate> fxRateList = objectMapper.readValue(jsonFile, new TypeReference<Map<String, FxRate>>() {
		});

		return fxRateList;
	}
}
