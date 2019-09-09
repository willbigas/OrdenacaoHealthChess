package model;

import model.enums.Sentido;

public class Ordem {

    private Sentido sentido;
    private String atributo;

    public Ordem() {
    }

    public Ordem(Sentido sentido, String atributo) {
        this.sentido = sentido;
        this.atributo = atributo;
    }


    public Sentido getSentido() {
        return sentido;
    }

    public void setSentido(Sentido sentido) {
        this.sentido = sentido;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public String toString() {
        return "Ordenador{" +
                "sentido=" + sentido +
                ", atributo='" + atributo + '\'' +
                '}';
    }
}
