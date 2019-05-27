package com.task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.task.interfaces.IDigit;

/**
 * Digit's service implementation class
 *
 * @author Kong Lingming
 * @date May 27, 2019
 */
public class DigitService implements IDigit {
	Logger log = Logger.getLogger(DigitService.class);

	/*
	 * Build dictionary
	 */
	static Map<Integer, String[]> letterMap = new HashMap<Integer, String[]>();
	static {
		letterMap.put(0, new String[] { "" });
		letterMap.put(1, new String[] { "" });
		letterMap.put(2, new String[] { "a", "b", "c" });
		letterMap.put(3, new String[] { "d", "e", "f" });
		letterMap.put(4, new String[] { "g", "h", "i" });
		letterMap.put(5, new String[] { "j", "k", "l" });
		letterMap.put(6, new String[] { "m", "n", "o" });
		letterMap.put(7, new String[] { "p", "q", "r", "s" });
		letterMap.put(8, new String[] { "t", "u", "v" });
		letterMap.put(9, new String[] { "w", "x", "y", "z" });
	}

	/*
	 * The range of inputs is 0-9
	 */
	@Override
	public List<String> inputUnitDigit(Integer[] input) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String[] arr1 = null;
		String[] arr2 = null;

		if (input.length == 1) {
			input = Arrays.copyOf(input, 2);
			input[1] = 0;
		}

		for (int i = 0; i < input.length - 1; i++) {
			if (i == 0) {
				arr1 = letterMap.get(input[i]);
			} else {
				arr1 = (String[]) list.toArray(new String[list.size()]);
			}
			arr2 = letterMap.get(input[i + 1]);
			list = combine(arr1, arr2);
		}
		return list;
	};

	/*
	 * The range of inputs is 0-99
	 */
	@Override
	public List<String> inputTensDigit(Integer[] arr) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (Integer i : arr) {
			list.add(i / 10);
			list.add(i % 10);
		}
		return inputUnitDigit((Integer[]) list.toArray(new Integer[list.size()]));
	}
	
	/*
	 * crossing two arrays
	 */
	private List<String> combine(String[] arr1, String[] arr2) {
		List<String> list = new ArrayList<String>();
		for (String str1 : arr1) {
			for (String str2 : arr2) {
				list.add(str1 + str2);
			}
		}
		return list;
	}
}