package com.kali.xml.propInj.colltions;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
    //注入多种datatype
    private String[] arr;
    private List<String> list;
    private Map<String, String> maps;
    private Set<String> sets;

    //设置set
    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void getAll(){
        System.out.println(arr + "\n" + list + "\n" + maps + "\n" + sets);
    }
}
