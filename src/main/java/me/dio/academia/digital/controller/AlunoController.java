package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;

  //CRIANDO UM ALUNO - ENVIANDO OS DADOS CONTIDOS NO FORM
  //VALID UTILIZADO PARA VALIDAR AS VALIDAÇÕES CONFIGURADAS NO FORMULÁRIO
  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }

  //RETORNANDO UMA LISTA COM TODAS AS AVALIAÇÕES FÍSICAS DO ALUMO
  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  //RETORNANDO A LISTA DE ALUNOS COM A DATA DE NASCIMENTO CONSULTADA
  //SE NÃO FOR INFORMADA UMA DATA, SERÁ RETORNADOS TODOS OS ALUNOS
  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }


}
