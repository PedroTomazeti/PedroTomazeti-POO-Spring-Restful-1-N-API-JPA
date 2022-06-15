/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uema.cursos.controller;

import br.uema.cursos.model.Cursos;
import br.uema.cursos.repository.CursosRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pltf0
 */
// Gerenciamento dos cursos
@Controller
// Declaração de uma rota para acessar o gerenciamento
// GetMapping nos redireciona para a url desejada
// PostMapping envia os parâmetros para o corpo da url que colocamos antes
@RequestMapping({"/cursos"})
public class CursosController {
          
    // Acesso ao repositório
    // Indica um ponto aonde a injeção automática de dependências deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores. 
    @Autowired
    private CursosRepository repository;

    @GetMapping("/index")
    // Model é a classe Entidade que será carregada na visão
    public String showCursosList(Model model) {
        // cursos vai resgatar todos as informações da base de dados
        model.addAttribute("cursos", repository.findAll());
        // html que ele utilizará para decorar esses dados
        return "cursos/index";
    }

    // Carregar formulário de cadastro do curso
    @GetMapping("/add-cursos")
    public String showCreateForm(Cursos curso, Model model) {
        // Faz-se uma nova instância da classe Cursos, para ser carregada na visão da aplicação
        curso = new Cursos();
        model.addAttribute("curso", curso);
        // Retorna ao arquivo .html onde se tem a interface
        return "/cursos/add-cursos";
    }

    // Irá resgatar os valores salvos do formulário após o botão de submit for pressionado
    // As rotas que estão referenciando
    @PostMapping("/cadastrar")
    public String addCurso(@Valid Cursos curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/cursos/add-cursos";
        }

        repository.save(curso);
        return "redirect:/cursos/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cursos curso = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + id));
        model.addAttribute("curso", curso);
        return "/cursos/update-cursos";
    }
    
    @PostMapping("/update/{id}")
    public String updateCurso(@PathVariable("id") long id, @Valid Cursos curso, BindingResult result, Model model){
        if(result.hasErrors()){
            curso.setId(id);
            return "/cursos/update-cursos";
        }
        
        repository.save(curso);
        return "redirect:/cursos/index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCurso(@PathVariable("id") long id, Model model) {
        Cursos curso = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + id));
        repository.delete(curso);
        return "redirect:/cursos/index";
    }
}
