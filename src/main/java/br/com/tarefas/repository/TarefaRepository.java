/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tarefas.repository;

import br.com.tarefas.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lucas
 */
public interface TarefaRepository extends CrudRepository<Tarefa, Long>{
    
}
