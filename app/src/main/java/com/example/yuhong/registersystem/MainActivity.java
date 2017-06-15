package com.example.yuhong.registersystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private EditText eAccount, eSecret_code;
    private Button button;
    private String strAcount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.register);
        eAccount=(EditText)findViewById(R.id.edit_account);
        eSecret_code = (EditText) findViewById(R.id.secret_code);
        strAcount = eAccount.getText().toString();
        String strSecret_code = eSecret_code.getText().toString();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //初始化Intent物件
                Intent intent = new Intent();
                //從MainActivity 到Main2Activity
                intent.setClass(MainActivity.this , Main2Activity.class);
                //開啟Activity
                startActivity(intent);
            }
        });
    }
}
