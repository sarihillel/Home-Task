=============================================
Private Investigation - Home Assigment Solution
=============================================

My project include 4 files:
  * Main - basically parameters and Calling to action services
  * ReaderService - get file path and return the file content
  * MapperReaser- aloritmic service that scan all sentence and map them into hashMap by logic
  * WriterService - over on result of mapperSrvice and print to output file.

In order to run Project:
  * Set the pathes parameters in Main class to location input file in your desktop
  * Run Main class for execute the program

Complexity code:
The program stores all values in hashMap in order to access them directly in low runtime.

Algoritm Scale:
The program read file and looping over the sentences one by one.
The program uses with two hashMaps:
  * MainHashMap holds mapping for all senetence combination with one missing word.
  * SubHashMap holds all the diffrent Words and orignal sentences by the same sentence combination (that displayed as key of MainHashMap)
  
Each sentence seperated to words list and over them done mapping into HashMap like that:
Key - string that contains sentence missing current word
Value - subHashMap stores the different words to this sentence.
SubHashMap contains : 
SubKey ->  string of current word.
SubValue- string of original sentence
				
For Each sentence combination we look for the same key/sentence in mainHashmap. if is exists we add the different word and org sentence to the HashMap 
Finnaly we go over the main hash and get all entries that have 2 different words or more and print them to output file.

Extentions for Program:
  * Find similar sentences by multiple diffrent words.
  * Save Results for using the data for merge file that upload in future.

