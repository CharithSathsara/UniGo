package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    private CardView cardViewCourses, cardViewEvents, cardViewAnnouncements, cardViewClubs;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();

        cardViewCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Go To Courses", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard.this,Courses.class);
                startActivity(intent);
            }
        });
        cardViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "GO TO ALL Events", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard.this,UpcomingEvents.class);
                startActivity(intent);
            }
        });
        cardViewAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Go to Announcements", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard.this, Announcements.class);
                startActivity(intent);
            }
        });
        cardViewClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Go To Club Details", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard.this, Clubs.class);
                startActivity(intent);
            }
        });

    }

    private void initViews(){
        cardViewCourses = findViewById(R.id.cardViewCourses);
        cardViewEvents = findViewById(R.id.cardViewEvents);
        cardViewAnnouncements = findViewById(R.id.cardViewAnnouncements);
        cardViewClubs = findViewById(R.id.cardViewClubs);
        txtName = findViewById(R.id.txtName);
    }

}