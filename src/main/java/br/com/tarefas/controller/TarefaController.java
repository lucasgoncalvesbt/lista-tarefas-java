package br.com.tarefas.controller;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.repository.TarefaRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/gerenciarTarefas")
    public String listarTarefas(Model model) {
        model.addAttribute("listaTarefas", tarefaRepository.findAll());
        return "gerenciar_tarefas";
    }

    @GetMapping("/novaTarefa")
    public String novaTarefa(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "editar_tarefa";
    }

    @GetMapping("/editarTarefa/{id}")
    public String editarTarefa(@PathVariable("id") long idTarefa, Model model) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(idTarefa);
        model.addAttribute("tarefa", tarefa.get());
        return "editar_tarefa";
    }

    @PostMapping("/salvarTarefa")
    public String salvarTarefa(Tarefa tarefa, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_tarefa";
        }
        tarefaRepository.save(tarefa);
        return "redirect:/gerenciarTarefas";
    }

    @GetMapping("/excluirTarefa/{id}")
    public String excluirTarefa(@PathVariable("id") long idTarefa) {
        tarefaRepository.deleteById(idTarefa);
        return "redirect:/gerenciarTarefas";
    }
}
