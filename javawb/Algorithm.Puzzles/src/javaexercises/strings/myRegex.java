package javaexercises.strings;

import java.util.regex.Pattern;


public class myRegex {
    public String pattern = Pattern.compile(
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."+
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."+
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."+
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").toString();    
    public static void main(String[] args){
        
    }
}