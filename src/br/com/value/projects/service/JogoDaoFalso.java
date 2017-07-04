/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.service;

import br.com.value.projects.dominio.Jogo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class JogoDaoFalso implements RepositorioDeJogos {

    private static List<Jogo> jogos = new ArrayList<Jogo>();

    public void salva(Jogo jogo) {
        jogos.add(jogo);
    }

    public List<Jogo> finalizados() {

        List<Jogo> filtrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogos) {
            if (jogo.isFinalizado()) {
                filtrados.add(jogo);
            }
        }

        return filtrados;
    }

    public List<Jogo> correntes() {

        List<Jogo> filtrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogos) {
            if (!jogo.isFinalizado()) {
                filtrados.add(jogo);
            }
        }

        return filtrados;
    }

    public void atualiza(Jogo jogo) {

    }

    public List<Jogo> Temporada() {
        return jogos;
    }
}
