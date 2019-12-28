package com.portfolio.contactlist;

import java.util.List;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface ContactDao
{
    @Insert
    void insertContact(Contact product);

    @Query("SELECT * FROM contact_list WHERE contactName LIKE ('%'||:name||'%') ORDER BY contactName")
    List<Contact> findContact(String name);

    @Query("DELETE FROM contact_list WHERE contactName = :name")
    void deleteContact(String name);

    @Query("SELECT * FROM contact_list ORDER BY contactName")
    LiveData<List<Contact>> getAllContacts();
}