package com.fdmgroup.Ood_Corwin.Yip;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserListHandler {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static User[] read(String File) throws StreamReadException, DatabindException, IOException {

		User[] UsereList = objectMapper.readValue(new File(File), User[].class);

		return UsereList;
	}

	public static void write(User[] userList, String userFile)
			throws StreamWriteException, DatabindException, IOException {

		objectMapper.writeValue(new File(userFile), userList);
	}
}
