/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.service;

import br.com.value.projects.builder.*;
import br.com.value.projects.dominio.Jogo;
import java.util.Arrays;

import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Guilherme
 */
public class FinalizadorDeJogosTest {

    @Test
    public void deveFinalizarJogosQueIniciaramNaSemanaPassada() {

        Calendar passada = Calendar.getInstance();
        passada.set(1999, 1, 20);

        Jogo jogo1 = new CriadorDeJogo().para("JogoTabuleiro")
                .naData(passada).constroi();
        Jogo jogo2 = new CriadorDeJogo().para("JogoFaroeste")
                .naData(passada).constroi();
//RepositorioDeJogos aqui!
        RepositorioDeJogos daoFalso = mock(RepositorioDeJogos.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(jogo1, jogo2));
        daoFalso.salva(jogo2);

        FinalizadorDeJogos finalizador = new FinalizadorDeJogos(daoFalso);
        finalizador.finaliza();

        Assert.assertEquals(2, finalizador.getTotalFinalizados());
        Assert.assertTrue(jogo1.isFinalizado());
        Assert.assertTrue(jogo2.isFinalizado());
    }

    @Test
    public void deveAtualizarJogosFinalizados() {

        Calendar passada = Calendar.getInstance();
        passada.set(1999, 1, 20);

        Jogo jogo1 = new CriadorDeJogo().para("Tabuleiro")
                .naData(passada).constroi();

        RepositorioDeJogos daoFalso = mock(RepositorioDeJogos.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(jogo1));

        FinalizadorDeJogos finalizador = new FinalizadorDeJogos(daoFalso);
        finalizador.finaliza();

        verify(daoFalso, times(1)).atualiza(jogo1);
    }

}
