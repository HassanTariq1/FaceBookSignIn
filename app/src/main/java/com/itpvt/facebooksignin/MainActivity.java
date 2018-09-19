package com.itpvt.facebooksignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LoginButton log;
    TextView txt;
    CallbackManager call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            FacebookSdk.sdkInitialize(getApplicationContext());

        log=(LoginButton)findViewById(R.id.login_button);
        txt=(TextView)findViewById(R.id.txth);
        call= CallbackManager.Factory.create();

        log.registerCallback(call, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txt.setText("Login success\n" +loginResult.getAccessToken().getUserId()+
                "\n"+ loginResult.getAccessToken().getToken());

            }

            @Override
            public void onCancel() {
txt.setText("Login Failed");
            }

            @Override
            public void onError(FacebookException error) {

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       call.onActivityResult(requestCode,resultCode,data);
    }
}
