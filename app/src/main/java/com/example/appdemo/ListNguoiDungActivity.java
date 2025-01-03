package com.example.appdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.Adapter.AdapterNguoiDung;
import com.example.appdemo.DAO.NguoiDungDAO;
import com.example.appdemo.DataBase.DataBase;
import com.example.appdemo.Model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    ListView list_nguoidung;
    NguoiDungDAO nguoiDungDAO;
    AdapterNguoiDung adapterNguoiDung;
    DataBase dataBase;
    List<NguoiDung> nguoiDungList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_nguoidung);

        list_nguoidung =findViewById(R.id.lvNguoiDung);
        dataBase = new DataBase(this);
        nguoiDungDAO = new NguoiDungDAO(dataBase);
        nguoiDungList = nguoiDungDAO.getAllND();
        adapterNguoiDung = new AdapterNguoiDung(ListNguoiDungActivity.this,nguoiDungList);
        list_nguoidung.setAdapter(adapterNguoiDung);

    }
}
