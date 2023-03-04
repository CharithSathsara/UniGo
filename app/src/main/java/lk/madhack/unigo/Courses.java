package lk.madhack.unigo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Courses extends AppCompatActivity {

    private CardView cardViewCS, cardViewBICT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        initViews();

        cardViewCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Courses.this, "Go To Computer Science", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Courses.this, GetCsSubjects.class);
                startActivity(intent);
            }
        });
        cardViewBICT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Courses.this, "Go To BICT", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Courses.this,GetBictSubjects.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        cardViewCS = findViewById(R.id.cardViewCS);
        cardViewBICT = findViewById(R.id.cardViewBICT);
    }
}