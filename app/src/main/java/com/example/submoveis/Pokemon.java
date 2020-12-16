package com.example.submoveis;

public class Pokemon {
    private String nome;

    private String tipoPrimario;
    private String tipoSecundario;

    public Pokemon(String nome, String tipoPrimario, String tipoSecundario){
        this.nome = nome;
        this.tipoPrimario = tipoPrimario;
        this.tipoSecundario = tipoSecundario;
    }

    @Override
    public String toString() {
        return "Pokemon: " + nome + "\nTipo Primário:" + tipoPrimario + "\nTipo Secundario: " + tipoSecundario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPrimario() {
        return tipoPrimario;
    }

    public void setTipoPrimario(String tipoPrimario) {
        this.tipoPrimario = tipoPrimario;
    }

    public String getTipoSecundario() {
        return tipoSecundario;
    }

    public void setTipoSecundario(String tipoSecundario) {
        this.tipoSecundario = tipoSecundario;
    }
}
