package lk.madhack.unigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Iterator;
import java.util.List;

import lk.madhack.unigo.model.Event;
import lk.madhack.unigo.model.Subject;
import lk.madhack.unigo.response.SubjectResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetCsSubjects extends AppCompatActivity {

    RecyclerView csRecyclerView;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_cs_subjects);

        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.136:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getCsSubjects();
    }

    private void getCsSubjects() {
        Call<List<Subject>> call = jsonPlaceHolderApi.getCsSubjects();
        call.enqueue(new Callback<List<Subject>>() {
            @Override
            public void onResponse(Call<List<Subject>> call, Response<List<Subject>> response) {
                if(!response.isSuccessful()){
                    return;
                }


                CsRecyclerViewAdapter myAdapter = new CsRecyclerViewAdapter(GetCsSubjects.this, response.body());
                csRecyclerView.setAdapter(myAdapter);
                csRecyclerView.setLayoutManager(new LinearLayoutManager(GetCsSubjects.this));
            }

            @Override
            public void onFailure(Call<List<Subject>> call, Throwable t) {
                return;
            }
        });
    }

    private void initViews() {
        csRecyclerView = findViewById(R.id.csRecyclerView);
    }
}