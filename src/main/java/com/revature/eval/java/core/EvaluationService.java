package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i=0; i<string.length(); i++) {
			reversed[string.length()-i-1] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		int acronymLength = 1;
		char [] acronym = new char[100];
		
		// Sets first letter of phrase to first letter of acronym
		acronym[0]=phrase.charAt(0);
		
		// Calculates acronym length, stores first letters
		for(int i=0; i<phrase.length(); i++) {
			if(phrase.charAt(i)==' ' || phrase.charAt(i)=='-') {
				acronym[acronymLength] = phrase.charAt(i+1);
				acronymLength++;
			}
		}
		
		char[] trueAcro = new char[acronymLength];
		
		for(int i=0; i<acronymLength; i++) {
			if(acronym[i]!=0)
				trueAcro[i] = Character.toUpperCase(acronym[i]);
		}
		return new String(trueAcro);
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne == sideTwo && sideTwo == sideThree)
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			if(sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree)
				return true;
			else
				return false;
		}

		public boolean isScalene() {
			if(sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree)
				return true;
			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		String upperString = string.toUpperCase();
		int score = 0;
		
		for(int i=0; i<string.length(); i++) {
			switch(upperString.charAt(i)) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				score += 1;
				break;
			case 'D':
			case 'G':
				score += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J':
			case 'X':
				score += 8;
				break;
			case 'Q':
			case 'Z':
				score += 10;
				break;
			default:
				System.out.println("Impossible!");
			}
			
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {

		int counter = -1;
		char [] finalNumber = new char[10];

		for(int i = 0; i<string.length(); i++) {
			char temp = string.charAt(i);
			
			if(temp >= '0' && temp <= '9') {
				counter++;
				if(counter>9) {
					throw new IllegalArgumentException("Number too big!");
				}
				finalNumber[counter] = string.charAt(i);
			}
			if(temp < '0' && temp != '-' && temp != '.' && temp != ' ' && temp != '(' && temp != ')') {
				throw new IllegalArgumentException("Invalid characters!");
			}
			if(temp > '9' && temp != '-' && temp != '.' && temp != ' ' && temp != '(' && temp != ')') {
				throw new IllegalArgumentException("Invalid characters!");
			}
		}
		
		return new String(finalNumber);
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] strArr = string.split("[,. \n]+");
		
		for(int i = 0; i < strArr.length; i++) {
			
			String tempString = strArr[i];
			int tempcount = 0;
			
			// Counts how many times a given string appears
			for(int j = i; j < strArr.length; j++) {
				if(tempString.equals(strArr[j])) {
					tempcount++;
				}
			}
			
			// If not already in map
			if(map.get(strArr[i])==null)			
				map.put(strArr[i], tempcount);
		}
		
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
        int first = 0;
        int last = sortedList.size() - 1;
        int middle = 0;
        
        int number = Integer.parseInt(t.toString());
        int[] input = new int[sortedList.size()];
        
        // A ton of nonsense in an attempt to figure out which class the inputted generic is
    	for(int i = 0; i < sortedList.size(); i++) {
    		 if(sortedList.get(0) instanceof String) {
    			input[i] = Integer.parseInt((String) sortedList.get(i));
    		 }
	        if(sortedList.get(0) instanceof Integer) {
	        	input[i] = (int) sortedList.get(i);
	        }
    	}

    	// Main loop
        while (first <= last) {
        	
        	// Calculate middle
        	middle = (first + last) / 2;
        	
        	// If middle value is less than desired number
            if (input[middle] < number) {
                first = middle + 1;			// first is now middle
            } else if (input[middle] == number) {
                return middle;				// Found it, return
            } else {
                last = middle - 1;			// Else it's greater than, so last becomes middle
            }
            
        }
        
        return -1;		// Not found
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		
		// Convert string sentence to string array
		String[] strArr = string.split("[,. ]+");
		
		// loop through each string in the string array
		for(int i = 0; i < strArr.length; i++) {
			
			String temp = strArr[i];
			
			// Use substrings to move letters around until they're where you want them to be
			while(true) {
				if(Character.isAlphabetic(temp.charAt(0)) && temp.charAt(0)!='a' && temp.charAt(0)!='e' && temp.charAt(0)!='i' && temp.charAt(0)!='o' && temp.charAt(0)!='u' && temp.charAt(0)!='q') {
					temp = temp.substring(1) + temp.charAt(0);
				}
				else if(temp.charAt(0)=='q' && temp.charAt(1)=='u')
					temp = temp.substring(2) + temp.charAt(0) + temp.charAt(1);
				else if(temp.charAt(0)=='q' && temp.charAt(1)!='u')
					temp = temp.substring(1) + temp.charAt(0);
				else
					break;
			}
			strArr[i] = temp + "ay";
		}
		
		String full = strArr[0];
		for(int i = 1; i < strArr.length; i++) {
			full = full + " " + strArr[i];
		}
		
		return full;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {

		// Convert from integer to string
		String str = String.valueOf(input);
		int total = 0;
		
		// Split string into its characters
		for(int i = 0; i < str.length(); i++) {
			// Turn character into int
			int backToInt = Character.getNumericValue(str.charAt(i));
			// Calculate appropriate power of that number, then add to total.
			total += (int) Math.pow(backToInt, str.length());
		}
		
		// Determine if it's the same number, return result
		return (total==input);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> longList = new ArrayList<>();
		
		while(l % 2 == 0) {
			longList.add(2L);
			l /= 2;
		}
		
		for(int i = 3; i <= Math.sqrt(l); i += 2) {
			while(l % i == 0) {
				longList.add((long)i);
				l /= i;
			}
		}
		
		if(l>2)
			longList.add(l);
		
		return longList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuilder rString = new StringBuilder();
			rString.append(string);
			
			// create loop that:
			// Looks at each letter, and shifts based on cipher, loops if Z or z, does nothing for numbers and punctuation
			for(int i = 0; i < string.length(); i++) {
				char tempChar = string.charAt(i);
				for(int j = 1; j <= key; j++) {
					if(Character.isAlphabetic(tempChar)&&tempChar!='Z'&&tempChar!='z') {
						tempChar++;
					} else if(tempChar=='Z') {
						tempChar='A';
					} else if(tempChar=='z') {
						tempChar='a';
					}
				}
				rString.setCharAt(i, tempChar);
			}
			
			return rString.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if(i <= 0) {
			throw new IllegalArgumentException();
		}
		
		int num=1;
		int foundPrime = 0;
		
		// Loop that finds and tests each prime number starting from 1, until it reaches
		// the number given by the user
		int j;
		while(foundPrime < i) {
			num+=1;
			for(j=2; j < num; j++) {
				if(num % j == 0) {
					break;
				}
			}
			
			// When a prime is found that matches the number given, stop
			if(j == num) {
				foundPrime++;
			}
		}
		
		return num;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			// Force string into lowercase
			String temp = string.toLowerCase();
			StringBuilder sb = new StringBuilder();
			int counter = 0;
			
			// Look at each index in string, change letters as neccessary
			for(int i = 0; i < string.length(); i++) {
				char tempChar = temp.charAt(i);
				// Check if letter, ignore if not
				if(Character.isLetter(tempChar)) {
					tempChar = (char) ('a' + ('z' - tempChar));
					sb.append(tempChar);
					counter++;
				} else if(Character.isDigit(tempChar)) {
					sb.append(tempChar);
					counter++;
				} else {
					continue;
				}
				
				// Every 5 letters/numbers, append a space
				if((counter%5)==0)
					sb.append(" ");
			}
			
			return sb.toString().trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// Remove whitespace
			String temp = string.replaceAll("\\s+","");
			StringBuilder sb = new StringBuilder();
			
			// Look at each index in string, change letters as neccessary
			for(int i = 0; i < temp.length(); i++) {
				char tempChar = temp.charAt(i);
				// Check if letter, ignore if not
				if(Character.isLetter(tempChar)) {
					tempChar = (char) ('z' + ('a' - tempChar));
					sb.append(tempChar);
					} else if(Character.isDigit(tempChar)) {
					sb.append(tempChar);
					} else {
					continue;
					}

				}
						
			return sb.toString().trim();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		int result = 0;
		int counter = 0;
		
		for(int i = 0; i < 12; i++) {
			
			if(!Character.isDigit(string.charAt(i))&&string.charAt(i)!='-') {
				return false;
			} else if (string.charAt(i)=='-') {
				continue;
			} else {
				int x = Character.getNumericValue(string.charAt(i));
				result += x*(10-counter);
				counter++;
			}
		}
		
		if(Character.isDigit(string.charAt(12))) {
			result += Character.getNumericValue(string.charAt(12));
		} else if(!Character.isDigit(string.charAt(12))&&string.charAt(12)!='X') {
			return false;
		} else if(string.charAt(12)=='X') {
			result += 10;
		}
		
		return ((result%11)==0);
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		char[] storage = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		for(int i = 0; i < string.length(); i++) {
			// See if whitespace
			if(string.charAt(i)==' ')
				continue;
			
			// Check if character is missing from array, else delete
			for(int j = 0; j < 26; j++) {
				if(storage[j]==string.charAt(i)) {
					storage[j] = '1';
				}
			}
			
		}
		// If character array was filled all the way
		for(int i = 0; i < 26; i++) {
			if(storage[i]=='1')
				continue;
			else
				return false;
		}
		
		return true;

	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		LocalDateTime temp;
		
		// If given object is of type LocalDateTime
		if(given instanceof LocalDateTime) {
			temp = ((LocalDateTime) given).plusSeconds(1000000000);
		} else { // Otherwise it's LocalDate
			LocalDateTime otherTemp = ((LocalDate)given).atStartOfDay();
			temp = otherTemp.plusSeconds(1000000000);
		}

		return temp;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		// We use a set because it cannot have duplicates
		Set<Integer> multiples = new HashSet<Integer>();
		
		// Get all multiples of each number in the set up until i, not inclusive
		for(int x : set) {
			for(int y = x; y < i; y+=x) {
				multiples.add(y);
			}
		}
		
		// Now, simply convert set into an array to be iterated through, then find sum
		int sum = 0;
		
		for(int s : multiples) {
			sum+=s;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		// If 1 or fewer characters, invalid
		if(string.length()<=1)
			return false;
		
		// If it contains anything other than numbers or whitespaces, invalid. Also, trim string in the process.
		StringBuilder trimmed = new StringBuilder();
		for(int i = 0; i < string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))&&string.charAt(i)!=' ')
				return false;
			else if(string.charAt(i)==' ')
				continue;
			else
				trimmed.append(string.charAt(i));
		}
		
		// Go through every second number from the right, double it, subtract 9 if more than 9.
		for(int i = (trimmed.length()-2); i >=0; i-=2) {
			int temp = Integer.parseInt(String.valueOf(trimmed.charAt(i)));
			temp *= 2;
			if(temp>9)
				temp-=9;
			trimmed.replace(i, i+1, Integer.toString(temp));
		}
		
		// Sum all numbers, mod by 10, return true if %10 = 0
		int sum = 0;
		for(int i = 0; i<trimmed.length(); i++) {
			sum+=Integer.parseInt(String.valueOf(trimmed.substring(i, i+1)));
		}
		
		if((sum%10)==0)
			return true;
		else
			return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		String[] str = string.split("[ ?]+");
		String operation = "";
		int[] nums = new int[2];
		int index = 0;
		
		// Determine which operation to perform
		for(String s : str) {
			if(s.equals("plus"))
				operation = s;
			if(s.equals("minus"))
				operation = s;
			if(s.equals("multiplied"))
				operation = s;
			if(s.equals("divided"))
				operation = s;
		}
		
		// Locate two numbers to be used
		for(String s : str) {
			try {
				nums[index] = Integer.parseInt(s);
				index++;
			} catch(NumberFormatException e) {
				continue;
			}
			
		}
		
		switch(operation) {
		case "plus":
			return (nums[0]+nums[1]);
		case "minus":
			return (nums[0]-nums[1]);
		case "multiplied":
			return (nums[0]*nums[1]);
		case "divided":
			return (nums[0]/nums[1]);
			default:
				return -1;
		}

	}

}
