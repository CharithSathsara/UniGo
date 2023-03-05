package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mindrot.jbcrypt.BCrypt;

import lk.madhack.unigo.model.Student;
import lk.madhack.unigo.response.StudentResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {
    
    private TextView txtName, txtIndex, txtEmail, txtPassword, txtRePassword;
    private Button btnRegister;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        
    }

    private void register() {

        String name = txtName.getText().toString();
        String index = txtIndex.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String rePassword = txtRePassword.getText().toString();

        if (name.isEmpty() || index.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            Toast.makeText(SignUp.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(rePassword)) {
            Toast.makeText(SignUp.this, "Password and retype passwords does not match", Toast.LENGTH_SHORT).show();
        } else {

            String salt = "$2a$10$123456789012345678901.";
            String hashedPassword = BCrypt.hashpw(password, salt);

            Student st = new Student(name, email, index, hashedPassword);

            retrofit2.Call<StudentResponse> call = jsonPlaceHolderApi.register(st);
            call.enqueue(new Callback<StudentResponse>() {
                @Override
                public void onResponse(retrofit2.Call<StudentResponse> call, Response<StudentResponse> response) {

                    if (!response.isSuccessful()) {
                        Toast toast = Toast.makeText(SignUp.this, "Unsuccessful SignUp", Toast.LENGTH_SHORT);
                        View view = toast.getView();
                        view.setBackgroundColor(Color.RED);
                        toast.show();
                        return;
                    }

                    StudentResponse registerResponse = response.body();

                    if(registerResponse.getCode().toString().equals("1")){

                        txtName.setText("");
                        txtIndex.setText("");
                        txtEmail.setText("");
                        txtPassword.setText("");
                        txtRePassword.setText("");

                        Toast.makeText(SignUp.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this,Login.class);
                        startActivity(intent);
                    }

                }

                @Override
                public void onFailure(Call<StudentResponse> call, Throwable t) {
                    Toast.makeText(SignUp.this, "Fail to register", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void initViews() {
        btnRegister = findViewById(R.id.btnRegister);
        txtName = findViewById(R.id.txtName);
        txtIndex = findViewById(R.id.txtIndex);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtRePassword = findViewById(R.id.txtRePassword);
    }
}