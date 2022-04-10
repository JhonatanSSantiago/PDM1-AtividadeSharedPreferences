package com.jhonssantiago.fragmentsatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Editnome, Editsenha;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Editnome=findViewById(R.id.editTextNome);
        Editsenha=findViewById(R.id.editTextSenha);
        login=findViewById(R.id.buttonLogin);
    }

    public void clicar(View view){
        String nome = Editnome.getText().toString();
        String s = Editsenha.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("dados",MODE_PRIVATE);
        String name = sharedPreferences.getString("nome_usuario", "");
        String senha = sharedPreferences.getString("senha_usuario", "");
        if(name.equals(nome) && senha.equals(s)){
            Intent intent = new Intent(this, TerceiraActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("nome_usuario",Editnome.getText().toString());
            intent.putExtra("senha_usuario",Editsenha.getText().toString());
            startActivity(intent);
        }


    }


}