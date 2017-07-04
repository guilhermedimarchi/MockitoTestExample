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
public interface RepositorioDeJogos {

    public void salva(Jogo jogo);

    public List<Jogo> finalizados();

    public List<Jogo> correntes();

    public void atualiza(Jogo jogo);

    public List<Jogo> Temporada();
}
