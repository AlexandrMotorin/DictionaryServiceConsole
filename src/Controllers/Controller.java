package Controllers;

import Config.DictionaryTypes;
import Exceptions.MyException;
import Service.DictionaryService;
import Service.DictionaryServiceImpl;
import View.View;

import java.util.Map;

public class Controller {

    private DictionaryService dictionaryService;
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void getAllData(){
        Map<String, String> map = dictionaryService.getAllWords();
        if (map.size() != 0) view.returnData(map);
        else view.returnMassage("Словарь пуст");
    }

    public void getWordByKey(String key) {
        Map<String,String> map;
        try{
            map = dictionaryService.getWordByKey(key);
            if (map.size() != 0) view.returnData(map);
            else view.returnMassage("Такого слова нет в словаре");
        }catch (MyException e){
            view.returnMassage(e.getMessage());
        }
    }

    public void deleteWord(String word) {
        try {
            dictionaryService.deleteWord(word);
            view.returnMassage("запись успешно удалена");
        }catch (MyException e){
            view.returnMassage(e.getMessage());
        }
    }

    public void add(String s, String word) {
        try{
            dictionaryService.addEntry(s, word);
            view.returnMassage("Слово успешно добавлено");
        }catch (MyException e){
            view.returnMassage(e.getMessage());
        }
    }

    public void createDictionaryService(DictionaryTypes type) {
        this.dictionaryService = new DictionaryServiceImpl(type);
    }

}
