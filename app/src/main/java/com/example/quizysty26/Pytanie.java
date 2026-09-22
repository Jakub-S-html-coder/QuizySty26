package com.example.quizysty26;
public class Pytanie {
    private String tresc;
    private int idObrazu;
    public Pytanie(String tresc, int idObrazu) {
        this.tresc = tresc;
        this.idObrazu = idObrazu;
    }
    public String getTresc() {
        return tresc;
    }
    public int getObraz() {
        return idObrazu;
    }
}
