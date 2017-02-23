package com.calc.service;

public class Calc {

	public String performAction(String opt, String n1, String n2) {
		String res = null;
		if (opt.equals("add"))
			res = "Addition of two numbers: " + (Integer.parseInt(n1) + Integer.parseInt(n2));
		else if (opt.equals("sub"))
			res = "Substraction of two numbers: " + (Integer.parseInt(n1) - Integer.parseInt(n2)); 
		else if (opt.equals("mul"))
			res = "Multipication of two numbers: " + (Integer.parseInt(n1) * Integer.parseInt(n2));
		else if (opt.equals("div"))
			res = "Division of two numbers: " + (Float.parseFloat(n1) / Float.parseFloat(n2));
	return res;
	}

}
