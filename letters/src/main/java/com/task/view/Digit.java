package com.task.view;

import java.util.List;

import org.apache.log4j.Logger;

import com.task.interfaces.IDigit;
import com.task.service.DigitService;
import com.task.utils.HandlerUtil;
import com.task.utils.LogicException;

public class Digit {
	static Logger log = Logger.getLogger(Digit.class);

	static IDigit iDigit = HandlerUtil.createProxy(IDigit.class, DigitService.class);

	/*
	 * @desc range 0 ~ 9
	 * 
	 * @param unitDigitArr  Integer array
	 */
	public List<String> inputUnitDigit(Integer[] unitDigitArr) throws LogicException {
		if (unitDigitArr.length == 0) {
			throw new LogicException("The integer array should not be empty");
		}
		for (Integer uda : unitDigitArr) {
			if (uda > 9 || uda < 0) {
				throw new LogicException("The integer array should only contain digits from 0 ~ 9");
			}
		}
		return iDigit.inputUnitDigit(unitDigitArr);
	}

	/*
	 * @desc range 0 ~ 99
	 * 
	 * @param tensDigitArr   Integer array
	 */
	public List<String> inputTensDigit(Integer[] tensDigitArr) throws LogicException {
		if (tensDigitArr.length == 0) {
			throw new LogicException("The integer array should not be empty");
		}
		for (Integer tdr : tensDigitArr) {
			if (tdr > 99 || tdr < 0) {
				throw new LogicException("The integer array should only contain digits from 0 ~ 99");
			}
		}
		return iDigit.inputTensDigit(tensDigitArr);
	}
}
