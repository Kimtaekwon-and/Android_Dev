package com.example.monkeymealproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.monkeymealproject.MainActivity.customerDb;

public class FragmentRegisterSub extends Fragment implements View.OnClickListener {

    Bundle dataRecieveBundle;
    CustomerInfo inputCustomerInfo;

    // EditText
    EditText nicknameEditText;
    //Intent : FregmentSub -> Main
    Intent convertToMainIntent;

    Button registerSubConfilmButton;

    Thread dbInputThread;



    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.register_sub,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        initRegisterSubUi(view);
        setclickedAction();

    }

    public void initRegisterSubUi(View view){

        getDataToprevius();
        nicknameEditText = view.findViewById(R.id.et_registersub_nickname);
        convertToMainIntent = new Intent(getActivity(),MainActivity.class);
        registerSubConfilmButton = view.findViewById(R.id.btn_registersub_confilm);

    }

    public void setclickedAction(){

        registerSubConfilmButton.setOnClickListener(this);

    }

    public void getDataToprevius(){


        dataRecieveBundle = getArguments();

        if(dataRecieveBundle != null){

            inputCustomerInfo= (CustomerInfo) dataRecieveBundle.getSerializable("CustomerInfo");

        }





    }

    public boolean proveEmptyEditText(){

            if(!nicknameEditText.getText().toString().equals("")){

                Log.d("TAG","dd");
                inputCustomerInfo.setCustomerNickName(nicknameEditText.getText().toString());

                //dbInputThread = new Thread(()->{

                    Log.d("TAG","dd");

                //prove Same Nickname in DB
                if(customerDb.infoDao().sameNicknameProve(nicknameEditText.getText().toString()) == 0){

                    Log.d("TAG","dd111");

                    customerDb.infoDao().insertRegisterInput(inputCustomerInfo);

                }
               // });

            }

            else{

                Toast.makeText(getContext(),"빈칸을 채워주세요",Toast.LENGTH_SHORT).show();
                return false;

            }

        return true;

    }

    @Override
    public void onClick(View v) {

        if(proveEmptyEditText()){

            Toast.makeText(getContext(),"계정 등록이 완료되었습니다",Toast.LENGTH_SHORT).show();
            startActivity(convertToMainIntent);

        }

    }

}
