package com.example.repository.impl;

import com.example.model.Dictionary;
import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static List<Dictionary> dictionaryList = new ArrayList<>();
    static {
        dictionaryList.add(new Dictionary("dog","con chó"));
        dictionaryList.add(new Dictionary("pig","con heo"));
        dictionaryList.add(new Dictionary("mickey","con chuột "));
        dictionaryList.add(new Dictionary("bear"," con gấu"));
        dictionaryList.add(new Dictionary("chicken","con gà "));
    }


    @Override
    public String search(String name) {
        for (Dictionary dictionary : dictionaryList){
            if(name.toLowerCase().equals(dictionary.getEng())){
                return dictionary.getVie();
            }
        }
         return "Not found";
    }
}
