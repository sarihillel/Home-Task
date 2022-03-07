/*
 * User: sarih
 * Date: 06/03/2022
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * IMPORTANT : write your javadoc here or delete this section
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String inputPath = "C:/Users/sarih/Documents/investigateReport.txt";
		String outputPath = "C:/Users/sarih/Documents/output.txt";
		List<String> linesStream = ReaderService.readFile(inputPath);
		HashMap<String, HashMap<String, String>> linesMap = MapperService.mapLinesToSentences(linesStream);
		WriterService.writeFile(linesMap,outputPath);
	}
}