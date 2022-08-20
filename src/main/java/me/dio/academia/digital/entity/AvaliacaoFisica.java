package me.dio.academia.digital.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_avaliacoes")

public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)//ALTERAÇÃO EFETUADA EM AVALIAÇÃO FISICA IRÁ REFLETIR EM ALUNO
  @JoinColumn(name = "aluno_id") //COLUNA DAS FOREIGN KEYS ESTARÁ NA TABELA DE AVALIAÇÃO FÍSICA
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual")
  private double peso;

  @Column(name="altura_atual")
  private double altura;

}
