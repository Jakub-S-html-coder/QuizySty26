package com.example.quizysty26;

public class PytanieZamkniete extends Pytanie {
    private String[] odpowiedzi;
    private int poprawneid;

    public PytanieZamkniete(String tresc, int idObrazu, String[] odpowiedzi, int poprawneid) {
        super(tresc, idObrazu);
        this.odpowiedzi = odpowiedzi;
        this.poprawneid = poprawneid;
    }
    public String[] getOdpowiedzi() {
        return odpowiedzi;
    }
    public boolean sprawdzOdpowiedz(int wybranyIndeks) {
        return wybranyIndeks == poprawneid;
    }
}
