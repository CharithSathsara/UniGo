package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import lk.madhack.unigo.model.Subject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetBictSubjects extends AppCompatActivity {

    RecyclerView bictRecyclerView;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_bict_subjects);

        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getBictSubjects();

    }

    private void getBictSubjects() {
        Call<List<Subject>> call = jsonPlaceHolderApi.getBictSubjects();
        call.enqueue(new Callback<List<Subject>>() {
            @Override
            public void onResponse(Call<List<Subject>> call, Response<List<Subject>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                BictRecyclerViewAdapter myAdapter = new BictRecyclerViewAdapter(GetBictSubjects.this, response.body());
                bictRecyclerView.setAdapter(myAdapter);
                bictRecyclerView.setLayoutManager(new LinearLayoutManager(GetBictSubjects.this));
            }

            @Override
            public void onFailure(Call<List<Subject>> call, Throwable t) {
                return;
            }
        });
    }

    private void initViews() {
        bictRecyclerView = findViewById(R.id.bictRecyclerView);
    }
}