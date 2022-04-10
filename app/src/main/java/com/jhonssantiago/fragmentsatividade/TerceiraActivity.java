package com.jhonssantiago.fragmentsatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TerceiraActivity extends AppCompatActivity {
    private TextView nome, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        nome=findViewById(R.id.nomeT3);
        score=findViewById(R.id.scoreT3);
        ler();
    }

    private void ler() {

        SharedPreferences sharedPreferences = getSharedPreferences("dados",MODE_PRIVATE);
        if(sharedPreferences.contains("nome_usuario") && sharedPreferences.contains("senha_usuario") && sharedPreferences.contains("score")){
            String n = sharedPreferences.getString("nome_usuario", "_____");
            String total = sharedPreferences.getString("score","______");
            nome.setText(n);
            score.setText(total);
        }else{
            Toast.makeText(this,"ERRO no arquivo",Toast.LENGTH_SHORT).show();
        }

    }//
}