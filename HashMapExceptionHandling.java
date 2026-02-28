package assignment.feb28;

import java.util.HashMap;

class UsernameExistsException
	extends RuntimeException
{
	public UsernameExistsException(String message) {
		super(message);
	}
}

class UserCredentialsMap
	extends HashMap<String, String>
{
	@Override
	public String put(String key, String value) {
		if (this.containsKey(key)) {
			String message = "Username(%s) already exists!".formatted(key);
			throw new UsernameExistsException(message);
		}
		
		return super.put(key, value);
	}
}

public class HashMapExceptionHandling {
	public static void main(String[] args) {
		UserCredentialsMap ucMap = new UserCredentialsMap();
		
		try {
			ucMap.put("admin", "pass123");
			System.out.println("Username(admin) added successfully.");
			
			ucMap.put("admin", "newpass123");
		} catch (UsernameExistsException e) {
			System.out.println("KeyExists Error: " + e.getMessage());
		}
	}
}
