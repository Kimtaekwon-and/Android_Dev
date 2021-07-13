package com.example.monkeymealproject.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.monkeymealproject.CustomerInfo;

@Dao
public interface customerDao {

    //@Query("SELECT * FROM customerInfo")
    //public abstract List<CustomerInfo> getALL();

    @Query("SELECT * FROM CustomerInfo WHERE CustomerInfo.Email== (:writeEmail)")
    public abstract CustomerInfo loadUserBySameEmail(String writeEmail);

    //Find Same Email
    @Query("SELECT COUNT(*) FROM CustomerInfo WHERE CustomerInfo.Email == (:writeEmail)")
    public abstract boolean sameEmailProve(String writeEmail);

    @Query("SELECT COUNT(*) FROM CustomerInfo WHERE (CustomerInfo.NickName == (:NickName))")
    public abstract int sameNicknameProve(String NickName);


    @Query("SELECT CustomerInfo.Password FROM CustomerInfo WHERE CustomerInfo.Email == (:writeEmail)")
    public abstract String loadPassword(String writeEmail);

    @Insert
    public abstract void insertAll(CustomerInfo... userData);

    @Insert
    public abstract void insertRegisterInput(CustomerInfo userData);


    @Delete
    public abstract void delete(CustomerInfo userData);


}
