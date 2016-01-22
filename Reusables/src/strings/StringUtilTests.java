package strings;

import org.junit.Test;

import org.junit.Assert;

public class StringUtilTests {
	StringUtil stringUtil;
	public StringUtilTests() {
		stringUtil = new StringUtil();
	}

	@Test
	public void testCapitalizeString() {
		Assert.assertEquals("Cool", stringUtil.capitalizeFirstChar("cool"));
	}
	
	@Test
	public void testGetterString() {
		Assert.assertEquals("getCool", stringUtil.getGetterString("cool"));
		Assert.assertEquals("getCa$hc0w", stringUtil.getGetterString("ca$hc0w"));
	}
	
	@Test
	public void testPrefixZeroToInt() {
		
		Assert.assertEquals("0123", stringUtil.prefixZeroToInteger(123));
		Assert.assertEquals("01000", stringUtil.prefixZeroToInteger(1000));
	}
}
