package com.example.student.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText tenkhach, soluongsach;
    CheckBox khachVIP;
    TextView thanhtien, tongkhach, tongKVip, tongdoanhthu;
    Button tinhtien, tiep, thongke;
    ImageButton thoat;

    DanhSachKhachHang danhsach = new DanhSachKhachHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tenkhach = (EditText) findViewById(R.id.txtTenKH);
        soluongsach = (EditText) findViewById(R.id.txtSLSach);

        khachVIP = (CheckBox) findViewById(R.id.chkVIP);

        thanhtien = (TextView) findViewById(R.id.txtThanhTien);
        tongkhach = (TextView) findViewById(R.id.txtTongKH);
        tongKVip = (TextView) findViewById(R.id.txtKHVIP);
        tongdoanhthu = (TextView) findViewById(R.id.txtTongDT);

        tinhtien = (Button) findViewById(R.id.btnTinh);
        tiep = (Button) findViewById(R.id.btnTiep);
        thongke = (Button) findViewById(R.id.btnThongke);

        thoat = (ImageButton) findViewById(R.id.btnThoat);

        addEvent();
    }

    private void addEvent()
    {
        tinhtien.setOnClickListener(new ProcessMyEvent());
        tiep.setOnClickListener(new ProcessMyEvent());
        thongke.setOnClickListener(new ProcessMyEvent());
        thoat.setOnClickListener(new ProcessMyEvent());
    }

    private void doTinhTien()
    {
        KhachHang kh = new KhachHang();
        kh.setTenKH(tenkhach.getText()+"");
        kh.setSlMua(Integer.parseInt(soluongsach.getText()+""));
        kh.setKhachVIP(khachVIP.isChecked());
        thanhtien.setText(kh.tinhThanhTien()+"");
        danhsach.addKhachHang(kh);
    }

    private void doTiep()
    {
        tenkhach.setText("");
        soluongsach.setText("");
        thanhtien.setText("");
        tenkhach.requestFocus();
    }

    private void doThongke ()
    {
        tongkhach.setText(danhsach.tongKhachHang()+"");
        tongKVip.setText(danhsach.tongKHVIP()+"");
        tongdoanhthu.setText(danhsach.tongDoanhThu()+"");
    }

    private void doThoat()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hỏi thoát chương trình");
        builder.setMessage("Bạn muốn thoát khỏi chương trình?");
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();
            }
        });
        builder.create().show();
    }
    private class ProcessMyEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btnTinh:
                    doTinhTien();
                    break;
                case R.id.btnTiep:
                    doTiep();
                    break;
                case R.id.btnThongke:
                    doThongke();
                    break;
                case R.id.btnThoat:
                    doThoat();
                    break;
            }
        }
    }
}
