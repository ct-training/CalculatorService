package com.calc.service;

public class Calculator {
	public float performAction(String opt, String n1, String n2) {
		float res = 0.0f;
		if (opt.equals("add"))
			res = Float.parseFloat(n1) + Float.parseFloat(n2);
		else if (opt.equals("sub"))
			res = Float.parseFloat(n1) - Float.parseFloat(n2);
		else if (opt.equals("mul"))
			res = Float.parseFloat(n1) * Float.parseFloat(n2);
		else if (opt.equals("div"))
			res = Float.parseFloat(n1) / Float.parseFloat(n2);
		return res;
	}
}
