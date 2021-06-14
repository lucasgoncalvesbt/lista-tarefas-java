/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tarefas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lucas
 */
@Entity
public class Tarefa implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idTarefa;
    private String descricao;
    private String situacao;
   
    public long getIdTarefa() {
        return idTarefa;
    }
    
    public void setIdTarefa(long idTarefa) {
        this.idTarefa = idTarefa;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
