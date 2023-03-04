package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import lk.madhack.unigo.model.Announcement;
import lk.madhack.unigo.model.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Announcements extends AppCompatActivity {

    private RecyclerView annRecyclerView;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.136:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getAllAnnouncements();

    }

    private void getAllAnnouncements() {

        Call<List<Announcement>> call = jsonPlaceHolderApi.getAllAnnouncements();
        call.enqueue(new Callback<List<Announcement>>() {
            @Override
            public void onResponse(Call<List<Announcement>> call, Response<List<Announcement>> response) {

                if(!response.isSuccessful()){
                    return;
                }
                AnnRecyclerViewAdapter myAdapter = new AnnRecyclerViewAdapter(Announcements.this,response.body());
                annRecyclerView.setAdapter(myAdapter);
                annRecyclerView.setLayoutManager(new LinearLayoutManager(Announcements.this));
            }

            @Override
            public void onFailure(Call<List<Announcement>> call, Throwable t) {
                return;
            }
        });

    }

    private void initViews() {
        annRecyclerView = findViewById(R.id.annRecyclerView);
    }

}