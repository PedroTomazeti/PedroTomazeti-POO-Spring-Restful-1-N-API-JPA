/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.uema.cursos.repository;

import br.uema.cursos.model.Cursos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pltf0
 */
@Repository
@Transactional
// Abstract Factory
// Configuração da Entidade e Sua chave primária
// Permite fazer um CRUD dos nossos dados, sem que a gente escreva uma linha de código.
public interface CursosRepository extends CrudRepository<Cursos, Long>{
    
}
