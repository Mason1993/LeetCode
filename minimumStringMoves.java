public class MinimumStringMoveTest {

	public int getMove(String beginWord, String endWord) {
      int distance = 0;
      if (beginWord.equals(endWord)) {
      	return distance;
      }

      Set<String> currentBegin = new HashSet<String>();
      currentBegin.add(beginWord);
      Set<String> visited = new HashSet<String>();
      visited.add(beginWord);

      while (!currentBegin.isEmpty()) {
          Set<String> next = new HashSet<String> ();
          for (String word:currentBegin) {
        	  Set<String> neighbors = getNeighbors(word);
        	  for (String str:neighbors) {
                      if (str.equals(endWord)) {
                        return distance + 1;
                      }
                      if (!visited.contains(str)) {
                          next.add(str);
                          visited.add(str);
                      }                  
              }
          }
          currentBegin = next;
          distance++;
      }
      return distance;
  }

  public Set<String> getNeighbors(String word) {
      Set<String>res = new HashSet<String>();
      char tempChar;
      String tempWord;
      for (int i = 0; i < word.length() - 1; i++) {
          tempChar = word.charat(i);
          tempWord = word;
          if (i == 0) {
            tempWord.replace(word.charat(i), word.charat(word.length - 1));
            tempWord.replace(word.charat(i + 1), tempChar);
            res.add(tempWord);
            continue;
          }
          tempWord.replace(word.charat(i), word.charat(i + 1));
          tempWord.replace(word.charat(i + 1), tempChar);
          res.add(tempWord);
      }
      return res;
  }