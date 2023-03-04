package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

import lk.madhack.unigo.model.LoginDetails;
import lk.madhack.unigo.response.StudentResponse;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    private Button btnSignIn;
    private TextView txtEmail, txtPassword;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.136:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {

        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Login.this, "Email or Password is empty", Toast.LENGTH_SHORT).show();
        }else {

            String salt = "$2a$10$123456789012345678901.";
            String hashedPassword = BCrypt.hashpw(password, salt);

            LoginDetails login = new LoginDetails(email, hashedPassword);

            retrofit2.Call<StudentResponse> call = jsonPlaceHolderApi.login(login);
            call.enqueue(new Callback<StudentResponse>() {
                @Override
                public void onResponse(retrofit2.Call<StudentResponse> call, Response<StudentResponse> response) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(Login.this, "Unsuccessful Login", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    StudentResponse LoginResponse = response.body();

                    if(LoginResponse.getCode().toString().equals("1")){

                        txtEmail.setText("");
                        txtPassword.setText("");

                        Toast.makeText(Login.this, LoginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,Dashboard.class);
                        startActivity(intent);
                    }

                }

                @Override
                public void onFailure(Call<StudentResponse> call, Throwable t) {
                    Toast.makeText(Login.this, "Fail to login", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initViews() {
        btnSignIn = findViewById(R.id.btnSignIn);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
    }
}