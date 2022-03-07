/*
 * User: sarih
 * Date: 06/03/2022
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 @read file by path and return all lines
 */
public class ReaderService {

	public static List<String> readFile(String path) throws IOException {
		File file = new File(path);
		try (Stream<String> linesStream = Files.lines(file.toPath())) {
			return linesStream.collect(Collectors.toList());
		} catch (IOException e) {
		}
		return null;
	}

}