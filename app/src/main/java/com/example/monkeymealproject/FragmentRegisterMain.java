package com.example.monkeymealproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentRegisterMain extends Fragment implements View.OnClickListener {

    FragmentRegisterSub fragRegisterSub;
    CustomerInfo inputCustomerInfo;

    //Fragment to FragmentSub Activity
    Button registerFragBtn;

    //Register Information
    EditText emailEditText;
    EditText nameEditText;
    EditText passwordEditText;

    //Input data to next Fragment
    Bundle dataSendBundle;
    //InputKey
    final static String bundleKey="CustomerInfo";




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.register_main,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitRegisterMainUi(view);
        setBtnClickedAction();

    }

    public void InitRegisterMainUi(View view) {

        fragRegisterSub = new FragmentRegisterSub();
        registerFragBtn = view.findViewById(R.id.btn_register_next);

        emailEditText = view.findViewById(R.id.et_registermain_email);
        nameEditText = view.findViewById(R.id.et_registermain_name);
        passwordEditText = view.findViewById(R.id.et_registermain_password);

        dataSendBundle = new Bundle();
        inputCustomerInfo= new CustomerInfo();
    }

    public void setBtnClickedAction(){

        registerFragBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(proveEmptyEditText(emailEditText,nameEditText,passwordEditText)) {

            inputCustomerInfo.setCustomerEmail(emailEditText.getText().toString());
            inputCustomerInfo.setCustomerName(nameEditText.getText().toString());
            inputCustomerInfo.setCustomerPassword(passwordEditText.getText().toString());

            dataSendBundle.putSerializable(bundleKey,inputCustomerInfo);
            fragRegisterSub.setArguments(dataSendBundle);
            //Fragment to fragRegisterSub Page
            ((MainActivity) getActivity()).getReplaceFragment(fragRegisterSub);

        }

    }

    public boolean proveEmptyEditText(EditText...edit){

        for(EditText etloop : edit){

            if(!etloop.getText().toString().equals("")){

                switch(etloop.getId()){

                    case(R.id.et_registermain_email):


                        inputCustomerInfo.setCustomerEmail(etloop.getText().toString());
                        break;

                    case(R.id.et_registermain_password):

                        inputCustomerInfo.setCustomerPassword(etloop.getText().toString());
                        break;

                    case(R.id.et_registermain_name):

                        inputCustomerInfo.setCustomerName(etloop.getText().toString());
                        break;

                }

            }

            else{

                Toast.makeText(getContext(),"빈칸을 채워주세요",Toast.LENGTH_SHORT).show();
                return false;

            }

        }
        return true;

    }
}
