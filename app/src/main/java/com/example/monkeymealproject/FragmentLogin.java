package com.example.monkeymealproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.monkeymealproject.MainActivity.customerDb;


public class FragmentLogin extends Fragment implements View.OnClickListener{
    //Btn
    Button loginConfilmBtn;
    //EditText
    EditText loginIdEditText;
    EditText loginPasswordEditText;

    Thread dbConfilmThread;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.login_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        loginInitUi(view);
        getBtnClicked();

    }


    public void loginInitUi(View view){

        loginConfilmBtn = view.findViewById(R.id.btn_login_confilm);
        loginIdEditText = view.findViewById(R.id.et_login_email);
        loginPasswordEditText = view.findViewById(R.id.et_login_password);

    }

    public void getBtnClicked(){

        loginConfilmBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //confilm btn click 확인 및 Id & Password가 DB 확인
        //CustomInfo class에 해당 고객 정보 담아서 Intent

        if(v.getId() == (R.id.btn_login_confilm)){
            // Go NextPage
               proveIdentifyInform();


        }

    }

    // TODO: Validate, Validation
    public void proveIdentifyInform(){
    //DB에 ID 검색 후 해당 ID 발견
     //발견-> cutomerinfo Instance 해당 정보 받아서 Id/password 받아서 비교 후 맞을때 Pass
     // 발견X -> ToastMessage Id 혹은 비번 오류 메시지 띄우기
     //사용자 입력값 비교 하여 True false

        if(customerDb.infoDao().sameEmailProve(loginIdEditText.getText().toString())!=0){

            //Email에 해당하는 비밀번호
            Log.d("태그","아이디있음");


            String comparePassword = customerDb.infoDao().loadPassword(loginIdEditText.getText().toString());

            if(loginPasswordEditText.getText().toString().equals(comparePassword)){

                //Toast.makeText(getContext(),"로그인에 성공하셨습니다",Toast.LENGTH_SHORT).show();
                //Log.d("태그","로그인성공");

            }
            else{

                //Toast.makeText(getContext(),"비밀번호가 틀렸습니다",Toast.LENGTH_SHORT).show();
                Log.d("태그","로그인실패->비번틀림");
            }

        }
        else {

           //Toast.makeText(getContext(),"해당하는 Email이 없습니다",Toast.LENGTH_SHORT).show();
            Log.d("태그","로그인실패->아이디없음");

        }
    }
}
