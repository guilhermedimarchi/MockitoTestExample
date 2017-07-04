package br.com.value.projects.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Jogo {

    private String descricao;
    private List<Resultado> resultados;
    private Calendar data;
    private boolean finalizado;

    public Jogo(String descricao) {
        this.descricao = descricao;
        this.resultados = new ArrayList<Resultado>();
        this.finalizado = false;
    }

    public void anota(Resultado resultado) {
        if (resultados.isEmpty()
                || !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
            resultados.add(resultado);
        }

    }

    private int ultimoResultadoVisto() {
        return resultados.size() - 1;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Resultado> getResultados() {
        return Collections.unmodifiableList(resultados);
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void finaliza() {
        setFinalizado(true);
    }

}
