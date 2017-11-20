/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datanoid;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author lylejw
 */
public class DatanoidFolders extends Observable {
    
    private static DatanoidFolders instance = null;
    private final ArrayList<String> folders = new ArrayList<>();
    
    protected DatanoidFolders() {   
        folders.add("Hello 1");
        folders.add("Hello 2");
    }
            
    public synchronized static DatanoidFolders getInstance() {
        if (instance == null)
            instance = new DatanoidFolders();
        return instance;
    }
    
    private void changed() {
        this.setChanged();
        this.notifyObservers(this);
    }
    
    public int size() {return folders.size();}
    public String get(int i) {return folders.get(i);}
    public int indexOf(String s) {return folders.indexOf(s);}
    public boolean add(String s) {
        boolean b = folders.add(s);
        changed();
        return b;
    }
    public void add(int i, String s) {folders.add(i, s);}
    public boolean remove(String s) {
        boolean b = folders.remove(s);
        if (b) changed();
        return b;
    }
    public String remove(int i) {
        String s = folders.remove(i);
        changed();
        return s;
    }
    
}
