/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datanoid;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author lylejw
 */
public class DatanoidFoldersComboBoxModel implements ComboBoxModel<String>, Observer {
    
    private DatanoidFolders datanoidFolders = null;
    private final ArrayList<ListDataListener> listeners = new ArrayList<>();
    private int selected = 0;
    
    public DatanoidFoldersComboBoxModel() {
        datanoidFolders = DatanoidFolders.getInstance();
        // register as an Observer of any DatanoidFolders changes so GUI ListDataListeners get notified
        datanoidFolders.addObserver(this);
    }
    
    @Override
    public String getElementAt(int index) {
        if (index == datanoidFolders.size())
            return "Add a new folder...";
        return datanoidFolders.get(index).toString();
    }

    @Override
    public void setSelectedItem(Object o) {
        if (o.toString() == "Add a new folder...")
            selected = datanoidFolders.size();
        else
            selected = datanoidFolders.indexOf((String)o);
    }

    @Override
    public Object getSelectedItem() {
        if (selected == datanoidFolders.size())
            return "Add a new folder...";
        return datanoidFolders.get(selected);
    }

    @Override
    public int getSize() {
        return datanoidFolders.size()+1;
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
        listeners.add(ll);
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        listeners.remove(ll);
    }

    /**
     * This ComboBoxModel is an Observer for updates in singleton DatanoidFolders.
     * @param obs
     * @param obj
     */
    @Override
    public void update(Observable obs, Object obj) {
        for (ListDataListener listener:listeners) {
            listener.contentsChanged(
                new ListDataEvent( this, ListDataEvent.CONTENTS_CHANGED, 0, ((DatanoidFolders)obj).size()-1 )
            );
        }
    }

}
