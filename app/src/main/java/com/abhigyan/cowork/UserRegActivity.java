package com.abhigyan.cowork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abhigyan.cowork.Welcome.WelcomeMainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegActivity extends AppCompatActivity {

    Button btRegUser;
    String mCompId;
    EditText etUserId;
    EditText etUserName;
    EditText etUserPass;
    EditText etUserPhone;
    EditText etUserEmail;
    EditText etUserAddr;
    EditText etRegDate;
    EditText etStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);

        mCompId=getIntent().getExtras().getString("CompId");
//        Toast.makeText(UserRegActivity.this,mCompId,Toast.LENGTH_SHORT).show();

        etUserId=findViewById(R.id.etUserId);
        etUserName=findViewById(R.id.etUserName);
        etUserPass=findViewById(R.id.etUserPass);
        etUserPhone=findViewById(R.id.etUserPhone);
        etUserEmail=findViewById(R.id.etUserEmail);
        etUserAddr=findViewById(R.id.etUserAddr);
        etRegDate=findViewById(R.id.etRegDate);
        etStatus=findViewById(R.id.etStatus);

        btRegUser=findViewById(R.id.btRegUser);
        btRegUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUserRequest registerUserRequest= new RegisterUserRequest();
                registerUserRequest.setCompany_id(Integer.parseInt(mCompId));
                registerUserRequest.setUser_id(Integer.parseInt(etUserId.getText().toString()));
                registerUserRequest.setUser_name(etUserName.getText().toString());
                registerUserRequest.setUser_password(etUserPass.getText().toString());
                registerUserRequest.setUser_phone(Integer.parseInt(etUserPhone.getText().toString()));
                registerUserRequest.setUser_email(etUserEmail.getText().toString());
                registerUserRequest.setUser_address(etUserAddr.getText().toString());
                registerUserRequest.setRegistration_date("2011-11-23 01:15:00");
                registerUserRequest.setStatus(Integer.parseInt(etStatus.getText().toString()));
                registerUser(registerUserRequest);
            }
        });
    }
    public void registerUser(RegisterUserRequest registerUserRequest){
        Call<RegisterUserResponse> registerUserResponseCall=ApiClient.getUserService().registerUser(registerUserRequest);
        registerUserResponseCall.enqueue(new Callback<RegisterUserResponse>() {
            @Override
            public void onResponse(Call<RegisterUserResponse> call, Response<RegisterUserResponse> response) {
                if(response.isSuccessful()){
                    String message = "Successful ..";
                    Toast.makeText(UserRegActivity.this,message,Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(UserRegActivity.this,UserLoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    String message = "An error occured.. check log";
                    Toast.makeText(UserRegActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterUserResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(UserRegActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }
}