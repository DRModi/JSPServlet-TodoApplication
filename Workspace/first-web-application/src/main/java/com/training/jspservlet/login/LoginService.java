package com.training.jspservlet.login;


// Create function to validate the username and password, this can be replaced by LDAP 
public class LoginService {
	
	public boolean isUserValid(String userName, String password){
		
		if((userName.equalsIgnoreCase("JayMataji") || userName.equalsIgnoreCase("aaradhy"))&& (password.equalsIgnoreCase("JayMataji") || password.equalsIgnoreCase("aaradhy") ))
		{
			return true;
		}
		else
			{
				return false;
			}
		
		
	}
	

}
