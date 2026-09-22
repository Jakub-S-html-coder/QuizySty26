package com.example.quizysty26;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.quizysty26.Pytanie;
import com.example.quizysty26.PytanieZamkniete;
import com.example.quizysty26.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewPytanie;
    private TextView textViewPytanie;
    private RadioGroup radioGroupOdpowiedzi;
    private RadioButton radioOdp1;
    private RadioButton radioOdp2;
    private RadioButton radioOdp3;
    private Button btnDalej;
    private List<PytanieZamkniete> listaPytan;
    private int Indeks;
    private int liczbapkt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewPytanie = findViewById(R.id.imageViewPytanie);
        textViewPytanie = findViewById(R.id.textViewPytanie);


        radioGroupOdpowiedzi = findViewById(R.id.radioGroupOdpowiedzi);
        radioOdp1 = findViewById(R.id.radioOdp1);
        radioOdp2 = findViewById(R.id.radioOdp2);
        radioOdp3 = findViewById(R.id.radioOdp3);

        btnDalej = findViewById(R.id.buttonDalej);

        listaPytan = new ArrayList<>();
        inicjalizujPytania();

        Indeks = 0;
        liczbapkt = 0;




        wyswietlPytanie();


        btnDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzIPrzejdzDalej();
            }
        });
    }

    private void inicjalizujPytania() {
        listaPytan.add(new PytanieZamkniete("Które to schronisko?", R.drawable.zad1, new String[]{"Na Rysiance.", "Na Wielkiej Raczy.", "Na Wielkiej Rycerzowej."}, 1));
        listaPytan.add(new PytanieZamkniete("Zwierzę na zdjęciu to", R.drawable.zad2, new String[]{"owczarek.", "wilk.", "kozica."}, 0));
        listaPytan.add(new PytanieZamkniete("W oddali są widoczne", R.drawable.zad3, new String[]{"Himalaje.", "Alpy.", "Tatry."}, 2));
    }

    private void wyswietlPytanie() {
        PytanieZamkniete pytanie = listaPytan.get(Indeks);

        imageViewPytanie.setImageResource(pytanie.getObraz());
        textViewPytanie.setText(pytanie.getTresc());
        String[] odpowiedzi = pytanie.getOdpowiedzi();
        
        
        radioOdp1.setText(odpowiedzi[0]);
        radioOdp2.setText(odpowiedzi[1]);
        radioOdp3.setText(odpowiedzi[2]);

        radioGroupOdpowiedzi.clearCheck();
    }

    private void sprawdzIPrzejdzDalej() {
        int wybranaodpowiedz = radioGroupOdpowiedzi.getCheckedRadioButtonId();
        if (wybranaodpowiedz != -1) {
            int wybranyIndeks = -1;
            if (wybranaodpowiedz == R.id.radioOdp1) {
                wybranyIndeks = 0;
            } else if (wybranaodpowiedz == R.id.radioOdp2) {
                wybranyIndeks = 1;
            } else if (wybranaodpowiedz == R.id.radioOdp3) {
                wybranyIndeks = 2;
            }
            PytanieZamkniete pytanie = listaPytan.get(Indeks);
            if (pytanie.sprawdzOdpowiedz(wybranyIndeks)) {
                liczbapkt++;
            }
        }

        Indeks++;
        if (Indeks >= listaPytan.size()) {
            Indeks = 0;
        }

        wyswietlPytanie();
    }
}