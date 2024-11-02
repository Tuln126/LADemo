package com.example.lademo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BaiTapTinhActivity extends AppCompatActivity {
    private TextView kq;
    private EditText edit1, edit2;
    private Button btAdd;
    private Spinner sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap_tinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView() {
        kq = findViewById(R.id.kq);
        edit1 = findViewById(R.id.e1);
        edit1 = findViewById(R.id.e2);

    }

    public void add(View v) {
        String nn1=edit1.getText().toString();
        String nn2=edit2.getText().toString();
        double n1,n2;
        try {
            n1=Double.parseDouble(nn1);
            n1=Double.parseDouble(nn2);
            String kk=tinhtoan(n1,n2, p:"+");
            kq.setText(kk);
            Toast.makeText( context: this,kk,Toast.LENGTH_LONG).show();
        }catch (NumberFormatException e){

    }

    private String tinhtoan(double x, double y, String p) {
        String s = "";
        switch (p) {
            case "+":
                s = "Tong:" + (x + y);
                break;
            case "-":
                s = "Hieu:" + (x - y);
                break;
            case "x":
                s = "Tich:" + (x * y);
                break;
            case ":":
                if (y == 0)
                    s = "Khong chia het cho 0";
                else
                    s = "Thuong:" + (x / y);
                break;
        }
        return s;
    }
}