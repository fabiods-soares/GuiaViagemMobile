package com.trave.travel;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPartida;
    private Spinner spinnerDestino;
    private EditText txtKML;
    private TextView lblDistancia;
    private TextView lblLitros;
    private Viagem viagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerPartida = findViewById(R.id.spinnerPartida);
        spinnerDestino = findViewById(R.id.spinnerDestino);
        txtKML = findViewById(R.id.txtKML);
        lblDistancia = findViewById(R.id.lblDistancia);
        lblLitros = findViewById(R.id.lblLitros);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        // Carregar cidades nos spinners

        carregarCidades();


        // Configurar o listener para o botão
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularViagem();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarCidades() {
        List<String> cidades = new ArrayList<>(Viagem.getCidades().keySet());

        // Adiciona o item padrão ao início da lista
        cidades.add(0, "Selecione");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPartida.setAdapter(adapter);
        spinnerDestino.setAdapter(adapter);

    }

    private void calcularViagem() {
        String partida = spinnerPartida.getSelectedItem().toString();
        String destino = spinnerDestino.getSelectedItem().toString();
        int kml;

        try {
            kml = Integer.parseInt(txtKML.getText().toString());
        } catch (NumberFormatException e) {
            lblDistancia.setText("Informe um valor válido para KML.");
            lblLitros.setText("");
            return;
        }

        viagem = new Viagem();
        viagem.setPartida(partida);
        viagem.setDestino(destino);
        viagem.setKml(kml);

        double distancia = viagem.DistanciaAB();
        double litros = viagem.LitrosGastos();

        lblDistancia.setText(String.format("Distância: %.2f km", distancia));
        lblLitros.setText(String.format("Litros gastos: %.2f L", litros));
    }
}