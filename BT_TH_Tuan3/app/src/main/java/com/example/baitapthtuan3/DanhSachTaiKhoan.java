package com.example.baitapthtuan3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DanhSachTaiKhoan extends AppCompatActivity {
    ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<>();
    ListView listViewTaiKhoan;
    EditText edtNhapTaiKhoan,edtNhapMatKhau;
    Button btnthem,btnSua,btnXoa;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_tai_khoan);
        listViewTaiKhoan=(ListView) findViewById(R.id.listViewTaiKhoan);
        edtNhapTaiKhoan=(EditText) findViewById(R.id.edtNhapTaiKhoan);
        edtNhapMatKhau = (EditText) findViewById(R.id.edtNhapMatKhau);
        btnthem =(Button) findViewById(R.id.btnThem);
        btnSua =(Button) findViewById(R.id.btnSua);
        btnXoa =(Button) findViewById(R.id.btnXoa);
        Cursor dataAccount = MainActivity.database.GetData("SELECT * FROM DuLieuTaiKhoan");
        while (dataAccount.moveToNext()){
            String userName =dataAccount.getString(0);
            String password =dataAccount.getString(1);
            TaiKhoan tk= new TaiKhoan(userName,password);
            listTaiKhoan.add(tk);
        }
        ArrayAdapter arrayAdapter= new ArrayAdapter(DanhSachTaiKhoan.this,android.R.layout.simple_list_item_1,listTaiKhoan);
        listViewTaiKhoan.setAdapter(arrayAdapter);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean status=false;
                if(edtNhapTaiKhoan.getText().length()!=0 && edtNhapMatKhau.getText().length()!=0){
                    Cursor dataAccount = MainActivity.database.GetData("SELECT * FROM DuLieuTaiKhoan");
                    while (dataAccount.moveToNext()){
                        String userName =dataAccount.getString(0);
                        String password =dataAccount.getString(1);
                        if(userName.equals(edtNhapTaiKhoan.getText().toString())){
                            Toast.makeText(DanhSachTaiKhoan.this, "Ten tai khoan da co nguoi su dung", Toast.LENGTH_SHORT).show();
                            status= true;
                        }
                    }
                    if(!dataAccount.moveToNext()&& !status){
                        TaiKhoan tk = new TaiKhoan();
                        tk.setUserName(edtNhapTaiKhoan.getText().toString());
                        tk.setPassword(edtNhapMatKhau.getText().toString());
                        MainActivity.database.insertTaiKhoan(tk);
                        Toast.makeText(DanhSachTaiKhoan.this, "Them moi tai khoan thanh cong", Toast.LENGTH_SHORT).show();
                        edtNhapTaiKhoan.setText("");
                        edtNhapMatKhau.setText("");
                        listTaiKhoan.add(tk);
                        listViewTaiKhoan.setAdapter(arrayAdapter);
                    }
                }else{
                    Toast.makeText(DanhSachTaiKhoan.this, "Nhap day du thong tin vao", Toast.LENGTH_SHORT).show();
                }
            }
        });
        listViewTaiKhoan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtNhapTaiKhoan.setText(listTaiKhoan.get(i).getUserName());
                edtNhapMatKhau.setText(listTaiKhoan.get(i).getPassword());
                vitri=i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( arrayAdapter.isEmpty()){
                    Toast.makeText(DanhSachTaiKhoan.this, "Danh sach tai khoan rong!!", Toast.LENGTH_SHORT).show();
                }else{
                    AlertDialog.Builder  builder = new AlertDialog.Builder(DanhSachTaiKhoan.this, android.R.style.Theme_DeviceDefault_Dialog);
                    builder.setTitle("Ban co chac muon cap nhat");
                    builder.setMessage("hay lua chon ben duoi de xac nhan");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            boolean status =false;
                            Cursor dataAccount = MainActivity.database.GetData("SELECT * FROM DuLieuTaiKhoan");
                            while (dataAccount.moveToNext()){
                                String userName =dataAccount.getString(0);
                                String password =dataAccount.getString(1);
                                if(userName.equals(edtNhapTaiKhoan.getText().toString())){
                                    Toast.makeText(DanhSachTaiKhoan.this, "Ten tai khoan da co nguoi su dung", Toast.LENGTH_SHORT).show();
                                    status= true;
                                }
                            }
                            if(!dataAccount.moveToNext()&& !status){
                                TaiKhoan tk = new TaiKhoan();
                                tk.setUserName(edtNhapTaiKhoan.getText().toString());
                                tk.setPassword(edtNhapMatKhau.getText().toString());
                                MainActivity.database.updateTK(edtNhapTaiKhoan.getText().toString(),edtNhapMatKhau.getText().toString());
                                listTaiKhoan.set(vitri,tk);
                                arrayAdapter.notifyDataSetChanged();
                                Toast.makeText(DanhSachTaiKhoan.this, "Ban da cap nhat thanh cong!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( arrayAdapter.isEmpty()){
                    Toast.makeText(DanhSachTaiKhoan.this, "Danh sach tai khoan rong!!", Toast.LENGTH_SHORT).show();
                }else if(edtNhapTaiKhoan.getText().length()==0){
                    Toast.makeText(DanhSachTaiKhoan.this, "Chon tai khoan can xoa!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder  builder = new AlertDialog.Builder(DanhSachTaiKhoan.this, android.R.style.Theme_DeviceDefault_Dialog);
                    builder.setTitle("Ban co chac muon xoa");
                    builder.setMessage("hay lua chon ben duoi de xac nhan");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.database.deleteUser(edtNhapTaiKhoan.getText().toString());
                            listTaiKhoan.remove(vitri);
                            arrayAdapter.notifyDataSetChanged();
                            edtNhapTaiKhoan.setText("");
                            edtNhapMatKhau.setText("");
                            Toast.makeText(DanhSachTaiKhoan.this, "Ban da xoa thanh cong!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                }

            }
        });
    }
}