package br.com.value.projects.builder;

import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Participante;
import br.com.value.projects.dominio.Resultado;
import java.util.Calendar;

public class CriadorDeJogo {

    private Jogo jogo;

    public CriadorDeJogo() {
    }

    public CriadorDeJogo para(String descricao) {
        this.jogo = new Jogo(descricao);
        return this;
    }

    public CriadorDeJogo resultado(Participante participante, double metrica) {
        jogo.anota(new Resultado(participante, metrica));
        return this;
    }
    public CriadorDeJogo naData(Calendar passada) {
        jogo.setData(passada);
        return this;
    }

    public Jogo constroi() {
        return jogo;
    }


}
