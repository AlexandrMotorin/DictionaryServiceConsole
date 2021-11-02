package Service;

import Config.DictionaryConnector;
import Config.DictionaryTypes;
import DAO.DictionaryDAO;
import DAO.DictionaryDAOImpl;
import Exceptions.MyException;

import java.nio.file.Paths;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService{

    private DictionaryDAO dictionaryDAO;
    private DictionaryTypes type;

    public DictionaryServiceImpl(DictionaryTypes type){
        this.type = type;
        String path = DictionaryConnector.getDictPath(type);
        dictionaryDAO = new DictionaryDAOImpl(Paths.get(path));
    }

    private void checkValid(String word){
        switch (type){
            case NUMERIC_DICTIONARY -> {
                if (!word.matches("\\d{5}")) throw new MyException("Введено некорректное значение");
            }
            case ENGLISH_DICTIONARY -> {
                if (!word.toLowerCase().matches("[a-z]{4}")) throw new MyException("Введено не корректное значение");
            }
        }
    }

    @Override
    public Map<String, String> getAllWords() {
        return dictionaryDAO.getAllWords();
    }

    @Override
    public Map<String, String> getWordByKey(String word) {
        checkValid(word);
        return dictionaryDAO.getWordByKey(word);
    }

    @Override
    public void deleteWord(String word) {
        checkValid(word);
        dictionaryDAO.deleteWord(word);
    }

    @Override
    public void addEntry(String word, String translate) {
        checkValid(word);
        dictionaryDAO.addEntry(word,translate);
    }

}
