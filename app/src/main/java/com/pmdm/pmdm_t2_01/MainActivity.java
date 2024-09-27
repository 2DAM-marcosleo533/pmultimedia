package com.pmdm.pmdm_t2_01;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private final String TAG = "PMOM";
    private TextToSpeech sintetizador;

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

    sintetizador = new TextToSpeech(this, this);
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(this, "se crea la app", Toast.LENGTH_LONG).show();
        hablar("Vuelve a la app");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "se crea la app", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "se crea la app", Toast.LENGTH_LONG).show();
        sintetizador.shutdown();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "se crea la app", Toast.LENGTH_LONG).show();
        hablar("Empieza la app");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "se crea la app", Toast.LENGTH_LONG).show();
    }

    private void hablar(String msg){
        sintetizador.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
    }

    //Parametros de configuracion del sintetizador
    @Override
    public void onInit(int i) {

    sintetizador.setLanguage(Locale.getDefault());
    sintetizador.setPitch(1f);
    sintetizador.setSpeechRate(1f);

    }
}