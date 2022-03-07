/*
 * User: sarih
 * Date: 06/03/2022
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @Param linesMap - all combinations of lines mapped by mapperService
 * @Param logStr - uses for concat content for output file
 * @Param diffWordsStr -  uses for concat all different words in sentence
 */

class WriterService {

	public static void writeFile(HashMap<String, HashMap<String, String>> linesMap, String outputPath) {
		StringBuilder logStr = new StringBuilder();
		for (Map.Entry<String, HashMap<String, String>> entry : linesMap.entrySet()) {
			StringBuilder diffWordsStr = new StringBuilder();
			if (entry.getValue().entrySet().size() > 1) {
				for (Map.Entry<String, String> diffWords : entry.getValue().entrySet()) {
					logStr.append(diffWords.getValue());
					logStr.append("\n");
					diffWordsStr.append(diffWords.getKey().concat(","));
				}
				String wordsStr = diffWordsStr.substring( 0, diffWordsStr.length() - 1);
				logStr.append("The changing word was: ").append(wordsStr);
				logStr.append("\n");
			}
		}
		try {
			Files.write(Paths.get(outputPath), String.valueOf(logStr).getBytes());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}