package com.example.appdemo.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.appdemo.Adapter.AdapterViewPager;
import com.example.appdemo.DAO.KhoanThuDAO;
import com.example.appdemo.DataBase.DataBase;
import com.example.appdemo.MainActivity;
import com.example.appdemo.Model.KhoanThu;
import com.example.appdemo.R;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ThongKeFragment extends Fragment {
    KhoanThuDAO khoanThuDAO;
    DataBase dataBase;
    List<KhoanThu> thuList;
    TabLayout tablayout;
    ViewPager viewpager;

    public ThongKeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thong_ke, container, false);
        tablayout = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);
        AdapterViewPager adapterViewPager = new AdapterViewPager(getParentFragmentManager());
        adapterViewPager.addFragment(new NgayFragment(), "Ngày");
        adapterViewPager.addFragment(new ThangFragment(), "Tháng");
        adapterViewPager.addFragment(new NamFragment(), "Năm");
        viewpager.setAdapter(adapterViewPager);
        tablayout.setupWithViewPager(viewpager);
        return view;

    }
}
