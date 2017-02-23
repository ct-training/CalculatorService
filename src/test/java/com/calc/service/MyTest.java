package com.calc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.calc.service.Calculator;

import org.junit.Test;


public class MyTest {
	
	@Test
	public void ArithmeticOperationofNumbersShouldReturnValue()
	{
		Calculator cobj = new Calculator();
		
		float result = cobj.performAction("add","10", "20");
		String res = Float.toString(result);
		//assert statements
		assertEquals("30.0", res);
	}
	
/*	@Test
	public void testObject()
	{
		Calculator cobj = null;
		assertNotNull(cobj);
	}
*/
}
