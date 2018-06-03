package example.app.ventu.com.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView texto;
    EditText editText;
    Button boton1;
    Button boton2;
    Button boton3;
    ImageView imagen;
    MediaPlayer mp1,mp2;


    ArrayList<String> frasesB = new ArrayList();
    ArrayList frasesM = new ArrayList();




    int randomB = (int)Math.floor(Math.random()*(frasesB.size()+1));
    int randomM = (int)Math.floor(Math.random()*(frasesM.size()+1));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        frasesB.add(" es la polla en patinete");
        frasesB.add(" el rey del mambo");
        frasesB.add(" es el puto amo");
        frasesB.add(" es la ostia en vinagre");
        frasesB.add(" es un tigre");

        frasesM.add(" es mas tont@ que mis cojones");
        frasesM.add(" es mas tont@ que un ciruelo");
        frasesM.add(" comeme los huevos por debajo del culo");
        frasesM.add(" vete a la mierda que han puesto culolimpios");
        frasesM.add(" es un moñas");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto);
        editText =  findViewById(R.id.edittext);
        boton1 =  findViewById(R.id.boton1);
        boton2 = findViewById(R.id.boton2);
        boton3 =  findViewById(R.id.boton3);
        imagen =  findViewById(R.id.imagen1);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        mp1=MediaPlayer.create(this, R.raw.pmg);
        mp2=MediaPlayer.create(this, R.raw.los4);
    }

    @Override
    public void onClick(View v) {
        int numimagen1 = getResources().getIdentifier("@drawable/s1", null, this.getPackageName());
        int numimagen2 = getResources().getIdentifier("@drawable/s2", null, this.getPackageName());
        int numimagen3 = getResources().getIdentifier("@drawable/s3", null, this.getPackageName());
        String dato = editText.getText().toString();
        switch (v.getId()){
            case R.id.boton1:
                randomB = (int)Math.floor(Math.random()*(frasesB.size()));
                texto.setText(dato + frasesB.get(randomB));
                imagen.setImageResource(numimagen3);
                if (mp2.isPlaying())
                    mp2.pause();

                if (mp1.isPlaying()) {
                    Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                    mp1.pause();
                }else{
                    Toast.makeText(MainActivity.this, "Play PMG", Toast.LENGTH_SHORT).show();
                    mp1.start();
                }
                break;

            case R.id.boton2:
                randomM = (int)Math.floor(Math.random()*(frasesM.size()));
                texto.setText(dato + frasesM.get(randomM) );
                imagen.setImageResource(numimagen2);
                if (mp1.isPlaying())
                    mp1.pause();

                if (mp2.isPlaying()) {
                    Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                    mp2.pause();
                }else{
                    Toast.makeText(MainActivity.this, "Play los 4", Toast.LENGTH_SHORT).show();
                    mp2.start();
                   }
                break;

            case R.id.boton3:
                imagen.setImageResource(numimagen1);
                mp1.stop();
                mp1=MediaPlayer.create(this, R.raw.pmg);
                mp2.stop();
                mp2=MediaPlayer.create(this, R.raw.los4);

                Toast.makeText(MainActivity.this, "pause", Toast.LENGTH_SHORT).show();
                break;
        }

    }







}
