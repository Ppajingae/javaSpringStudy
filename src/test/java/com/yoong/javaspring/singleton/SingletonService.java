package com.yoong.javaspring.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        
    }
    public void logic(){
        System.out.println("싱글톤 객체 생성");
    }


}
