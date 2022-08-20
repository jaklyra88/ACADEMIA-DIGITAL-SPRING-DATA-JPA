package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor //CONSTRUTOR VAZIO
@AllArgsConstructor //CONSTRUTOR CONTENDO TODOS OS ATRIBUTOS

//ANOTAÇÕES DE PERSISTÊNCIA
@Entity //REPRESENTA A INJEÇÃO- CRIA A TABELA - NECESSÁRIO CONTER O ID(CHAVE PRIMARIA)
@Table(name = "tab_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true) //DADO DE COLUNA ÚNICA - NÃO PODE HAVER DDOS REPETIDOS
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  //RELACIONAMENRO UM PARA MUITOS - UM ALUNO PARA MUITAS AVALIAÇÕES
  @OneToMany(mappedBy = "aluno",fetch = FetchType.LAZY)//BIDIRECIONAL
  //LAZY - QUANDO SOLICITADO VAI CARREGARA TODAS AS INFORMAÇÕES DO ALUNO EXCETO A AVALIAÇÃO FÍSICA
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
