/*
 * User: sarih
 * Date: 07/03/2022
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
   @param sentencesMap - hashMap contains: key-> sentence for compare, value -> sub hashMap contains : key -> diffWord, value-> original sentence.
   @param sentenceKey - use for key in sentencesMap, include all sentence word except for current word
   @param addToDiffWordList - add current word to sub hashMap as DiffWords
   @throws IOException
 */
public class MapperService {

	public static HashMap<String,HashMap<String,String>> mapLinesToSentences(List<String> linesStream) {

		HashMap<String,HashMap<String,String>> sentencesMap= new HashMap<>();
		for(String line: linesStream){
			// remove date from sentence and split to words list
			String lineWithoutDate = line.replaceAll("[[0-9],/:,/-]", "");
			List<String> lineWords = Arrays.stream(lineWithoutDate.trim().split(" ")).collect(Collectors.toList());
			lineWords.stream().forEach(word -> {
				String sentenceKey = lineWithoutDate.replace(word,"");
				sentencesMap.put(sentenceKey,addWordToDiffWordList(sentencesMap.get(sentenceKey),word, line));
			});
		}
		return sentencesMap;
	}

	private static HashMap<String,String> addWordToDiffWordList(HashMap<String, String> diffWordsAndOrgSentence, String word, String line) {
		if(diffWordsAndOrgSentence == null)
			return new HashMap<String, String>() {{put(word, line);}};
		diffWordsAndOrgSentence.put(word,line);
		return diffWordsAndOrgSentence;
	}
}