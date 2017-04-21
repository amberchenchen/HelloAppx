package com.appx;

public class LetterSort {

	public void doSort(String input) {

		String[] inputArr = input.split("");
		String[] result = new String[inputArr.length];

		int idx = 0;
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i] != "") {
				result[idx] = inputArr[i];
				for (int j = i + 1; j < inputArr.length; j++) {
					if (inputArr[i].equals(inputArr[j])) {
						result[idx + 1] = inputArr[j];
						idx = idx + 1;
						inputArr[j] = "";
					}
				}
				idx++;
			}
		}

		for (String s : result) {
			System.out.print(s);
		}

	}
}
