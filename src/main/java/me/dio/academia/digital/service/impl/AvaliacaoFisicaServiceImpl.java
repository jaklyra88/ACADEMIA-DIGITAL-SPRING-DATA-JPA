package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    //BUSCANDO O ALUNO A PARTIR DO ID - ACESSANDO O REPOSITÓRIO DE ALUNO - RETORNANDO O ALUNO
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    //POPULANDO A AVALIAÇÃO FÍSICA
    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  //BUSCANDO UMA AVALIAÇÃO PELO ID
  @Override
  public AvaliacaoFisica get(Long id) {

    return null;
  }

  //LISTA DE AVALIAÇÃO FÍSICA
  @Override
  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  //ATUALIZANDO UMA AVALIAÇÃO
  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {

    return null;
  }

  //DELETANDO UMA AVALIAÇÃO
  @Override
  public void delete(Long id) {

  }
}
