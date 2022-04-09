package com.jhonssantiago.fragmentsatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nome, senha;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome=findViewById(R.id.editTextNome);
        senha=findViewById(R.id.editTextSenha);
        login=findViewById(R.id.buttonLogin);
    }

    public void clicar(View view){
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("nome_usuario",nome.getText().toString());
        intent.putExtra("senha_usuario",senha.getText().toString());
        startActivity(intent);
    }


}