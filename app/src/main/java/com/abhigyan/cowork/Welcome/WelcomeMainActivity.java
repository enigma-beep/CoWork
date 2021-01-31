package com.abhigyan.cowork.Welcome;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class WelcomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);




    }
}*/

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

//import com.abhi.takeyourmeds.BottomNavTestActivity;
import com.abhigyan.cowork.CompanyRegActivity;
import com.abhigyan.cowork.MainActivity;
import com.abhigyan.cowork.R;
import com.abhigyan.cowork.Splash;
import com.abhigyan.cowork.UserLoginActivity;
////import com.facebook.AccessToken;
////import com.facebook.CallbackManager;
////import com.facebook.FacebookCallback;
////import com.facebook.FacebookException;
////import com.facebook.FacebookSdk;
////import com.facebook.login.LoginResult;
////import com.facebook.login.widget.LoginButton;
////import com.google.android.gms.auth.api.Auth;
////import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.auth.api.signin.GoogleSignInResult;
//import com.google.android.gms.common.SignInButton;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FacebookAuthProvider;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.GoogleAuthProvider;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class WelcomeMainActivity extends AppCompatActivity {

    private static final String TAG = "FACELOG";
//    private CallbackManager mCallbackManager;
//    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 1;
    String name, email;
    String idToken;
//    private SignInButton signInButton;
//    private GoogleApiClient googleApiClient;
//    private FirebaseAuth.AuthStateListener authStateListener;

    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;
    private int currentPage;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_main);

        login=findViewById(R.id.sign_in);
        register=findViewById(R.id.register);

        viewPager=findViewById(R.id.viewPager);
        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);
        dotsLayout=findViewById(R.id.dotsLayout);
        addDotesInd(0);

//        mAuth = FirebaseAuth.getInstance();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

//        RelativeLayout relativeLayout = findViewById(R.id.layout);
//        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(2000);
//        animationDrawable.setExitFadeDuration(4000);
//        animationDrawable.start();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeMainActivity.this, UserLoginActivity.class);
                finish();
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeMainActivity.this, CompanyRegActivity.class);
                finish();
                startActivity(i);
            }
        });



    }


    public void addDotesInd(int position){
        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(40);
            dots[i].setTextColor(getResources().getColor(R.color.colorNewPrimary));
            dotsLayout.addView(dots[i]);

        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.button));
        }
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotesInd(i);
            currentPage=i;
            if(i==0){

            }
            else if(i==1){

            }
            else{

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}


