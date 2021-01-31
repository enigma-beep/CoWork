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

public class UserLoginActivity extends AppCompatActivity {

    Button btLogin;
    EditText etUser;
    EditText etPass;
    String mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        etUser=findViewById(R.id.etUser);
        etPass=findViewById(R.id.etPass);

        btLogin=findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserLoginRequest userLoginRequest=new UserLoginRequest();
                userLoginRequest.setUser_id(Integer.parseInt(etUser.getText().toString()));
                userLogin(userLoginRequest);

            }
        });
    }

    public void userLogin(UserLoginRequest userLoginRequest){
        Call<UserLoginResponse> userLoginResponseCall=ApiClient.getUserService().getUser(Integer.parseInt(etUser.getText().toString()));
        userLoginResponseCall.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                if(response.isSuccessful()){
                    mPass=response.body().getUser_password();
//                    Toast.makeText(UserLoginActivity.this,mPass,Toast.LENGTH_SHORT).show();
                    if(etPass.getText().toString().equals(mPass)){
                        Toast.makeText(UserLoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(UserLoginActivity.this,MainActivity.class);
                        startActivity(i);
//                        finish();
                    }else{
                        Toast.makeText(UserLoginActivity.this,"Please Check your Password",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    String message = "An error occured.. check log";
                    Toast.makeText(UserLoginActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                String message = "An error occured.. check log";
                Toast.makeText(UserLoginActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });
    }
}