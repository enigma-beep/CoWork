package com.abhigyan.cowork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

public class CompanyRegActivity extends AppCompatActivity {

    Button btRegComp;
    EditText etId;
    EditText etCompId;
    EditText etCompWebsite;
    EditText etCompName;
    EditText etCompAddr;
    EditText etCompGst;
    EditText etBranchId;
    EditText etIsApproved;
    String mCompWebsite, mCompName, mCompAddr, mCompGst, mBranchId;
    int mId, mCompId, mIsApproved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_reg);

        etId=findViewById(R.id.etId);
        etCompId=findViewById(R.id.etCompId);
        etCompWebsite=findViewById(R.id.etCompWebsite);
        etCompName=findViewById(R.id.etCompName);
        etCompAddr=findViewById(R.id.etCompAddr);
        etCompGst=findViewById(R.id.etCompGst);
        etBranchId=findViewById(R.id.etBranchId);
        etIsApproved=findViewById(R.id.etIsApproved);





        btRegComp=findViewById(R.id.btRegComp);
        btRegComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCompId=Integer.parseInt(etCompId.getText().toString());
                RegisterCompanyRequest registerCompanyRequest=new RegisterCompanyRequest();
                registerCompanyRequest.setId(Integer.parseInt(etId.getText().toString()));
                registerCompanyRequest.setCompany_id(Integer.parseInt(etCompId.getText().toString()));
                registerCompanyRequest.setCompany_website(etCompWebsite.getText().toString());
                registerCompanyRequest.setCompany_name(etCompName.getText().toString());
                registerCompanyRequest.setCompany_address(etCompAddr.getText().toString());
                registerCompanyRequest.setCompany_gst_no(etCompGst.getText().toString());
                registerCompanyRequest.setBranch_id(etBranchId.getText().toString());
                registerCompanyRequest.setIs_approved(Integer.parseInt(etIsApproved.getText().toString()));
                registerCompany(registerCompanyRequest);
            }
        });
    }

    public void registerCompany(RegisterCompanyRequest registerCompanyRequest){

        Call<RegisterCompanyResponse> registerCompanyResponseCall= ApiClient.getCompanyService().registerCompany(registerCompanyRequest);
        registerCompanyResponseCall.enqueue(new Callback<RegisterCompanyResponse>() {
            @Override
            public void onResponse(Call<RegisterCompanyResponse> call, Response<RegisterCompanyResponse> response) {

                if(response.isSuccessful()){
                    String message = "Successful ..";
                    String CompId= String.valueOf(mCompId);
                    Toast.makeText(CompanyRegActivity.this,message,Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(CompanyRegActivity.this,UserRegActivity.class);
                    i.putExtra("CompId", CompId);
                    startActivity(i);
                    finish();
                }else{
                    String message = "An error occured.. check log";
                    Toast.makeText(CompanyRegActivity.this,message,Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterCompanyResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(CompanyRegActivity.this,message,Toast.LENGTH_LONG).show();

            }
        });
    }
}