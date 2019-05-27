package com.test.unit;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.task.utils.LogicException;
import com.task.view.Digit;

/**
 * Unit test for Digit
 * @author Kong Lingming
 * @date May 27, 2019
 */

public class DigitExamples {
	static Logger log = Logger.getLogger(DigitExamples.class);

	@Test
	public void testUnitDigit() {
		try {
			Digit digit = new Digit();
			Integer[] arr = { 2 , 3 };        // correct
		//	Integer[] arr = { 9 };            // correct
		//	Integer[] arr = { 2 , 3 , 4 };    // correct
		//	Integer[] arr = { 9 , 3 , 7 , 5 };// correct
		//	Integer[] arr = { 2 , 2 };        // correct
		//	Integer[] arr = { 2 , 0 };        // correct
		//	Integer[] arr = { 2 , 1 };        // correct
		//	Integer[] arr = { 0 , 1 };        // correct
		//	Integer[] arr = { 2 , 999 };      // throw exception
		//	Integer[] arr = { -2 , 2 };       // throw exception
			List<String> result = digit.inputUnitDigit(arr);
			log.info(result);
		} catch (LogicException e) {
			log.error(e);
		}
	}
	
	@Test
	public void testTensDigit() {
		try {
			Digit digit = new Digit();
			Integer[] arr = { 9 , 36 };              // correct
		//	Integer[] arr = { 2 , 0 };               // correct
		//	Integer[] arr = { 2 , 33, 22, 43, 90 };  // correct
	    //	Integer[] arr = { 2 , 999 };             // throw exception
		//	Integer[] arr = { -2 , 2 };              // throw exception
			List<String> result = digit.inputTensDigit(arr);
			log.info(result);
		} catch (LogicException e) {
			log.error(e);
		}
	}

}
