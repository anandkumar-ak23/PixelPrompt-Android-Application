package com.example.imagegenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
//import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.net.MediaType;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.*;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;
//import okhttp3.Request;
//import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    MaterialButton generateBtn;
    ProgressBar progressBar;
    ImageView imageView;

    public static final MediaType JSON;

    static {
        JSON = MediaType.get("application/json; charset=utf-8 ");
    }

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText=findViewById(R.id.input_text);
        generateBtn= findViewById(R.id.generate_btn);
        imageView =findViewById(R.id.image_view);
        progressBar= findViewById(R.id.progress_bar);
        //collect input text and check it

        generateBtn.setOnClickListener((v) -> {
            //store text to string

            String text= inputText.getText().toString().trim();
            if(text.isEmpty()){
                inputText.setError("Enter Some Prompt ");
                return;
            }
            callAPI(text);

        });
        // callAPI(){
        // }
    }
    
}