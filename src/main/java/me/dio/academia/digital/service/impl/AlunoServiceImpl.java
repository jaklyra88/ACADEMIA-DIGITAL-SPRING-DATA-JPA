package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository repository;

  //CRIANDO UM ALUNO - RECENDO OS DADOS DO SEU RESPECTIVO FORM
  //POPULANDO O ALUNO
  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    //CHAMANDO O REPOSITORY E RETORNANDO O ALUNO
    return repository.save(aluno);
  }


  @Override
  public Aluno get(Long id) {
    return null;
  }

  //RETORNANDO ALUNOS PELA DATA DE NASCIMENTO
  @Override
  public List<Aluno> getAll(String dataDeNascimento) {

    if(dataDeNascimento == null) {
      return repository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }

  }

  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
  }

  //RETORNANDO A LISTA DE AVALIAÇÕES FÍSICAS DO ALUNO
  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    //RECUPERANDO O ALUNO NO REPOSITORY
    Aluno aluno = repository.findById(id).get();

    //RETORNANDO A LISTA DE AVALIAÇÃOES DO ALUNO
    return aluno.getAvaliacoes();

  }

}
