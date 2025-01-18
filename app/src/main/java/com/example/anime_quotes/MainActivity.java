package com.example.anime_quotes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //getting view by id for the btn and txt
        Button showAnimeQuotes = findViewById(R.id.btnShowQuotes);
        TextView animeQuotes = findViewById(R.id.txtAnimeQuotes);

        //making request queue for the api
        RequestQueue queue = Volley.newRequestQueue(this);

        //setting api of the website
        String animeQuotesApi = "https://anime-facts-rest-api.herokuapp.com/api/v1";

        //

    }
}