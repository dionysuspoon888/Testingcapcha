package com.example.dionysuspoon.testingcapcha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Captcha Validation
    CaptchaImageView cv_captcha_image;
    Button b_captcha_submit;
    EditText et_captcha_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv_captcha_image = findViewById(R.id.cv_captcha_image);
        b_captcha_submit = findViewById(R.id.b_captcha_submit);
        et_captcha_input = findViewById(R.id.et_captcha_input);

        cv_captcha_image.setCaptchaLength(4);
        // 1=letter,2=number,3=both
        cv_captcha_image.setCaptchaType(2);
        // cv_captcha_image.setIsDotNeeded(true); //do this if you need dotted background
        cv_captcha_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //refresh the Captcha
                cv_captcha_image.regenerate();
            }
        });

        b_captcha_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking match or not(string) by getCaptchaCode() (String of Recent Captcha)
                if(et_captcha_input.getText().toString().equals(cv_captcha_image.getCaptchaCode())){
                    Toast.makeText(MainActivity.this, "Matched", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
