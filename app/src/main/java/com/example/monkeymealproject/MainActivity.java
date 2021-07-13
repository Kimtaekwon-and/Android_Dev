package com.example.monkeymealproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.monkeymealproject.room.customerInfoDB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Fragment to Login Activity
    Button loginFragBtn;
    //Fragment to Register Activity
    Button registerFragbtn;

    //declare login,regster Activity
    FragmentLogin fragLogin;
    FragmentRegisterMain fragRegisterMain;

    static customerInfoDB customerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        getFragActionBtnClicked();
    }

    public void initUi() {

        loginFragBtn = (Button) findViewById(R.id.btn_main_login);
        registerFragbtn = (Button) findViewById(R.id.btn_main_register);

        fragLogin = new FragmentLogin();
        fragRegisterMain = new FragmentRegisterMain();
        customerDb = customerInfoDB.getInstance(this);

    }

    //Add Action of Btn cliked
    public void getFragActionBtnClicked() {

        loginFragBtn.setOnClickListener(this);
        registerFragbtn.setOnClickListener(this);
        // MotionEvent Intercept 방법
        // 함수로 정의 해당 방법은 나중에 따로 공부 후 게시물 게제 예정

    }

    @Override
    //If button is clicked, activity can convert to registerActivity and loginActivity

    public void onClick(View v) {


        switch (v.getId()) {

            case (R.id.btn_main_login):

                getReplaceFragment(fragLogin);
                break;

            case (R.id.btn_main_register):

                getReplaceFragment(fragRegisterMain);
                break;

        }
    }
    public void getReplaceFragment(Fragment fragment){

        FragmentManager fragMangaer = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragMangaer.beginTransaction();
        fragTransaction.replace(R.id.frame_frag_main,fragment)
        .addToBackStack(null)
        .commit();

    }
}