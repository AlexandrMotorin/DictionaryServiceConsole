package Service;

import java.util.Map;

public interface DictionaryService {
    Map<String, String> getAllWords();
    Map<String, String> getWordByKey(String word);
    void deleteWord(String word);
    void addEntry(String word,String translate);
}
