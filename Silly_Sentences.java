
public class Silly_Sentences {
	static final String[] conjunction = { "and", "or", "but", "because" };
	
	static final String[] properNoun = { "Fred", "Jane", "Richard Nixon", "Miss America" };
	
	static final String[] commonNoun = { "man", "woman", "fish", "elephant", "unicorn" };  
	
	static final String[] determiner = { "a", "the", "every", "some" };  
	
	static final String[] adjective = { "big", "tiny", "pretty", "bald" };
	
	static final String[] intransitiveVerb = { "runs", "jumps", "talks", "sleeps" };  
	
	static final String[] transitiveVerb = { "loves", "hates", "sees", "knows", "looks for", "finds" }; 
	
	
	public static void main(String[] args) {                  
		
	      while (true) {
	 	     sentence();
	 	     System.out.println(".\n\n");
	          try {
	              Thread.sleep(3000);
	          }
	          catch (InterruptedException e) {
	          }
	       }
	      
	}// end main
	
	static void sentence() {
		simpleSentence();
		
		int randomNumber = (int) (Math.random() * 100) + 1;
		
		if (randomNumber <= 20) {
			addToSentence(randomItem(conjunction));
			sentence();
		}
		
	}// end sentence
	
	static void simpleSentence() {
		nounPhrase();
		verbPhrase();
	}// end simpleSentence
	
	
	static void nounPhrase() {
		int randomNumber = (int) (Math.random() * 100) + 1;
		
		if (randomNumber > 50) {
			addToSentence(randomItem(properNoun));
		} else {
			addToSentence(randomItem(determiner));
			
			while (randomNumber < 25 && randomNumber > 0) {
				addToSentence(randomItem(adjective));
				randomNumber -= 10;
			}//randomNumber is surely less than zero
			
			addToSentence(randomItem(commonNoun));
			
			if (randomNumber < -2) {
				addToSentence("who");
				verbPhrase();
			}
		}// end if/else condition
	}// end nounPhrase
	
	static void verbPhrase() {
		int randomNumber = (int) (Math.random() * 4);
		
		switch (randomNumber) {
			case 0:
				addToSentence(randomItem(intransitiveVerb));
				break;
			case 1:
				addToSentence(randomItem(transitiveVerb));
				nounPhrase();
				break;
			case 2:
				addToSentence("is");
				addToSentence(randomItem(adjective));
				break;
			case 3:
				addToSentence("believes that");
				simpleSentence();
		}
	}// end verbPhrase
	
	static void addToSentence(String phrase) {
		System.out.print(" " + phrase);
	}
	
	static String randomItem(String[] listOfStrings) {
		String item;
		int index;
		int lengthOfList;
		
		lengthOfList = listOfStrings.length;
		index = (int) (Math.random() * lengthOfList);
		item = listOfStrings[index];
		
		return item;
	}
	
}// end class Silly_Sentences


//Some nice ones :)  Miss America is bald. every woman is big. the unicorn is pretty. Jane looks for Jane.  Richard Nixon jumps and the man sees Richard Nixon.
