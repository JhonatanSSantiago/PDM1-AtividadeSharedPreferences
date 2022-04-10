package com.jhonssantiago.fragmentsatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {
    private RadioButton htc, pixel, sooner, nexus;
    private RadioButton a2008, a2003, a2005;
    private RadioButton apk, exe;
    private String nome_usuario, senha_usuario;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        htc=findViewById(R.id.SmartHTCC);
        pixel=findViewById(R.id.SmartPixel);
        sooner=findViewById(R.id.SmartSooner);
        nexus=findViewById(R.id.SmartNexus);

        a2003=findViewById(R.id.Ano2003);
        a2005=findViewById(R.id.Ano2005);
        a2008=findViewById(R.id.Ano2008C);

        apk=findViewById(R.id.PacoteApkC);
        exe=findViewById(R.id.PacoteExe);

        Intent intent = getIntent();  //obter uma Intent
        nome_usuario = intent.getStringExtra("nome_usuario");
        senha_usuario = intent.getStringExtra("senha_usuario");

    }

    public void pontos(){
        if(htc.isChecked()){
            total+=1;
        }
        if(pixel.isChecked()){
            total+=0;
        }
        if(nexus.isChecked()){
            total+=0;
        }
        if(sooner.isChecked()){
            total+=0;
        }
        if(a2003.isChecked()){
            total+=0;
        }
        if(a2005.isChecked()){
            total+=0;
        }
        if(a2008.isChecked()){
            total+=1;
        }
        if(exe.isChecked()){
            total+=0;
        }
        if(apk.isChecked()){
            total+=1;
        }
        String t = String.valueOf(total);
        gravar(t);
    }


    public void clicar(View view) {
        pontos();
    }

    private void gravar(String t) {

        SharedPreferences sharedPreferences = getSharedPreferences("dados",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nome_usuario",nome_usuario);
        editor.putString("senha_usuario",senha_usuario);
        editor.putString("score",t);
        boolean resposta = editor.commit();
        if(resposta){
            Intent intent = new Intent(this,TerceiraActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Não salvo",Toast.LENGTH_SHORT).show();
        }

    }//
}