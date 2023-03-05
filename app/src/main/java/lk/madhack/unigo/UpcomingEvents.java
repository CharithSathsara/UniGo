package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import lk.madhack.unigo.model.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpcomingEvents extends AppCompatActivity {

    RecyclerView recyclerView;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events);

        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getAllEvents();

    }

    public void getAllEvents() {

        Call<List<Event>> call = jsonPlaceHolderApi.getAllEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                EventsRecyclerViewAdapter myAdapter = new EventsRecyclerViewAdapter(UpcomingEvents.this,response.body());
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(UpcomingEvents.this));
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                return;
            }
        });

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}