package com.example.anime_quotes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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
        TextView txtAnimeQuotes = findViewById(R.id.txtAnimeQuotes);

        //making request queue for the api
        RequestQueue queue = Volley.newRequestQueue(this);

        //setting api of the website
        String animeQuotesApi = "https://www.google.com/";

        //setting to request queue
        RequestQueue que = Volley.newRequestQueue(this);

        //initialing onclick listener on btn
        showAnimeQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest animeQuotes = new StringRequest(Request.Method.GET, animeQuotesApi, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtAnimeQuotes.setText(response.substring(0, 1000));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error occur while fetching data from the api", Toast.LENGTH_SHORT).show();
                    }
                });
                que.add(animeQuotes);
            }
        });

    }
}