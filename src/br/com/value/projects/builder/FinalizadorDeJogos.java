/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.builder;

import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.service.JogoDaoFalso;
import java.util.Calendar;
import java.util.List;
import br.com.value.projects.service.RepositorioDeJogos;

/**
 *
 * @author Guilherme
 */
public class FinalizadorDeJogos {

    private final RepositorioDeJogos dao;
    private int total = 0;

    public FinalizadorDeJogos(RepositorioDeJogos dao) {
        this.dao = dao;
    }

    public void finaliza() {
        List<Jogo> todosJogosCorrentes = dao.correntes();

        for (Jogo jogo : todosJogosCorrentes) {
            if (comecouSemanaPassada(jogo)) {
                jogo.finaliza();
                total++;
                dao.atualiza(jogo);
            }
        }
    }

    private boolean comecouSemanaPassada(Jogo jogo) {
        return diasEntre(jogo.getData(), Calendar.getInstance()) >= 7;
    }

    private int diasEntre(Calendar inicio, Calendar fim) {
        Calendar data = (Calendar) inicio.clone();
        int diasNoIntervalo = 0;
        while (data.before(fim)) {
            data.add(Calendar.DAY_OF_MONTH, 1);
            diasNoIntervalo++;
        }
        return diasNoIntervalo;
    }

    public int getTotalFinalizados() {
        return total;
    }
}
