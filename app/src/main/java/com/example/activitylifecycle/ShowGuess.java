package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
    private TextView showGuess;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        Bundle extra = getIntent().getExtras();

        showGuess = findViewById(R.id.showGuessTextView);
        backButton = findViewById(R.id.back_button);

//        if (getIntent().getStringExtra("guess") != null) {
//            showGuess.setText(getIntent().getStringExtra("guess"));
//        }

        if (extra != null) {
            showGuess.setText(extra.getString("guess"));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "From second activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}