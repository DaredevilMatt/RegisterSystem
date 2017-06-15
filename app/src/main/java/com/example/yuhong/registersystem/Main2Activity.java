package com.example.yuhong.registersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText mEdtRegAccount,mEdtRegScode, mEdtRegScodeAgain,mERegName;
    private EditText mERegEmail,mERegAddress,mERegPhone;
    private TextView mTxtWAccount, mTxtWCode, mTxtWCodeAgain, mTxtWName
            , mTxtWEmail, mTxtWAddress, mTxtWPhone, mTxtWSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best

                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule

                    break;
        }
    }

    public void initView(){
        mEdtRegAccount=(EditText)findViewById(R.id.ERegAccount);
        mEdtRegAccount.addTextChangedListener(new ClassOfTextWatcher(mEdtRegAccount));
        mEdtRegScode=(EditText)findViewById(R.id.ERegScode);
        mEdtRegScode.addTextChangedListener(new ClassOfTextWatcher(mEdtRegScode));
        mEdtRegScodeAgain =(EditText)findViewById(R.id.ERegScodeAgain);
        mEdtRegScodeAgain.addTextChangedListener(new ClassOfTextWatcher(mEdtRegScodeAgain));
        mERegName=(EditText)findViewById(R.id.ERegName);
        mERegName.addTextChangedListener(new ClassOfTextWatcher(mERegName));
        mERegEmail=(EditText)findViewById(R.id.ERegEmail);
        mERegEmail.addTextChangedListener(new ClassOfTextWatcher(mERegEmail));
        mERegAddress=(EditText)findViewById(R.id.ERegAddress);
        mERegAddress.addTextChangedListener(new ClassOfTextWatcher(mERegAddress));
        mERegPhone=(EditText)findViewById(R.id.ERegPhone);
        mERegPhone.addTextChangedListener(new ClassOfTextWatcher(mERegPhone));

        mTxtWAccount =(TextView)findViewById(R.id.TwarningAccount);
        mTxtWCode =(TextView)findViewById(R.id.TwarningCode);
        mTxtWCodeAgain =(TextView)findViewById(R.id.TwarningCodeAgain);
        mTxtWName =(TextView)findViewById(R.id.TwarningName);

        mTxtWEmail =(TextView)findViewById(R.id.TwarningEmail);
        mTxtWAddress =(TextView)findViewById(R.id.TwarningAddress);
        mTxtWPhone =(TextView)findViewById(R.id.TwarningPhone);
    }
    private class ClassOfTextWatcher implements TextWatcher {

        private TextView view;

        public ClassOfTextWatcher(View view) {

            if (view instanceof TextView)
                this.view = (TextView) view;
            else
                throw new ClassCastException(
                        "view must be an instance Of TextView");
        }

        @Override
        public void afterTextChanged(Editable s) {
            String string;
            String warning;
            warning="";


            switch (view.getId()) {
                case R.id.ERegAccount:
                    if(s.length()<6)warning+="帳號長度須大於6個字元";
                    mTxtWAccount.setText(warning);
                    break;
                case R.id.ERegScode:
                    if(s.length()<6)warning+="密碼長度須大於6個字元";
                    mTxtWCode.setText(warning);
                    mEdtRegScodeAgain.setText("");
                    mTxtWCodeAgain.setText("");
                    break;
                case R.id.ERegScodeAgain:
                    if(s.length()<6)warning+="密碼長度須大於6個字元";
                    if(mEdtRegScode.toString().compareTo(mEdtRegScodeAgain.toString())!=0)
                        warning+="、與輸入密碼不符";
                    mTxtWCodeAgain.setText(warning);
                    break;
                case R.id.ERegName:
                    //if(s.length()>20)warning+="姓名字元不可超過20";
                    mTxtWName.setText(warning);
                    break;

                case R.id.ERegEmail:
                    string = mERegEmail.getText().toString();
                    if( !string.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$"))
                        warning+="格式錯誤";
                    mTxtWEmail.setText(warning);
                    break;
                case R.id.ERegAddress:


                    mTxtWAddress.setText(warning);
                    break;
                case R.id.ERegPhone:
                    if(s.length()<9)warning+="長度不足";
                    string= mERegPhone.getText().toString();
                    if(!string.matches("^-?\\d+$"))warning+="、勿輸入非法字元";
                    mTxtWPhone.setText(warning);
                    break;
            }

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }

    }
}
