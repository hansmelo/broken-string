package br.com.ita;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringToolTest {
	
	StringTool stringTool;
	
	@Before
	public void setup() {
		stringTool = new StringTool();
	}

	@Test
	public void testConverterCamelCaseStringDownCase() {
		String input = "nome";
		String expected = "nome";
		assertEquals(expected, stringTool.converterCamelCase(input)[0]);
	}
	
	@Test
	public void testConverterCamelCaseStringSimpleCase() {
		String input = "Nome";
		String expected = "nome";
		assertEquals(expected, stringTool.converterCamelCase(input)[0]);
	}
	
	@Test
	public void testConverterCamelCaseStringComposed() {
		String input = "nomeComposto";
		String expected1 = "nome";
		String expected2 = "composto";
		assertEquals(expected1, stringTool.converterCamelCase(input)[0]);
		assertEquals(expected2, stringTool.converterCamelCase(input)[1]);
	}
	
	@Test
	public void testConverterCamelCaseStringComposed2() {
		String input = "NomeComposto";
		String expected1 = "nome";
		String expected2 = "composto";
		assertEquals(expected1, stringTool.converterCamelCase(input)[0]);
		assertEquals(expected2, stringTool.converterCamelCase(input)[1]);
	}
	
	@Test
	public void testConverterCamelCaseStringAllUpcase() {
		String input = "CPF";
		String expected = "CPF";
		assertEquals(expected, stringTool.converterCamelCase(input)[0]);
	}
	
	@Test
	public void testConverterCamelCaseStringWithUpcaseFollow() {
		String input = "numeroCPF";
		String expected1 = "numero";
		String expected2 = "CPF";
		assertEquals(expected1, stringTool.converterCamelCase(input)[0]);
		assertEquals(expected2, stringTool.converterCamelCase(input)[1]);
	}
	
	@Test
	public void testConverterCamelCaseStringComplex() {
		String input = "numeroCPFContribuinte";
		String expected1 = "numero";
		String expected2 = "CPF";
		String expected3 = "contribuinte";
		assertEquals(expected1, stringTool.converterCamelCase(input)[0]);
		assertEquals(expected2, stringTool.converterCamelCase(input)[1]);
		assertEquals(expected3, stringTool.converterCamelCase(input)[2]);
	}
	
	@Test
	public void testConverterCamelCaseStringWithNumber() {
		String input = "recupera10Primeiros";
		String expected1 = "recupera";
		String expected2 = "10";
		String expected3 = "primeiros";
		assertEquals(expected1, stringTool.converterCamelCase(input)[0]);
		assertEquals(expected2, stringTool.converterCamelCase(input)[1]);
		assertEquals(expected3, stringTool.converterCamelCase(input)[2]);
	}
	
	@Test(expected = InvalidInitialWithNumberException.class)
	public void testConverterCamelCaseStringInitialWithNumber() {
		stringTool.converterCamelCase("10Primeiros");
	}
	
	@Test(expected = InvalidCharacterException.class) 
	public void testConverterCamelCaseStringCharEspecial() {
		stringTool.converterCamelCase("nome#Composto");
	}
}
