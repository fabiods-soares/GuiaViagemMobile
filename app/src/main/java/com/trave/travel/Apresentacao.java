package com.trave.travel;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Apresentacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apresentacao);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cria um Intent para iniciar a MainActivity
                Intent intent = new Intent(Apresentacao.this, MainActivity.class);
                startActivity(intent);
                // Finaliza a Apresentacao para que o usuário não volte para ela
                finish();
            }
        }, 3000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}