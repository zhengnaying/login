package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button)findViewById(R.id.b1);
        bt.setOnClickListener(this);
        Button tip = (Button)findViewById(R.id.tip);
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("提示对话框")
                        .setMessage("提示！")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();

            }
        });
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.customdialog,null,false);
        builder.setTitle("登录对话框")
                .setView(viewDialog)
                .setPositiveButton("确定", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText User_id = viewDialog.findViewById(R.id.editText_User_id);
                        EditText User_pw = viewDialog.findViewById(R.id.editText_User_pw);
                        String id = User_id.getText().toString();
                        String pw = User_pw.getText().toString();
                        if(id.equals("abc")  && pw.equals("123"))
                            Toast.makeText(MainActivity.this,"登录成功！",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"登录失败!",Toast.LENGTH_LONG).show();

                    }
                });
        builder.create().show();

    }
}