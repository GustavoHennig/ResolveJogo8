package jogoia;

import java.util.ArrayList;

/**
 *
 *
 * <p>Title: Estado</p>
 *
 * <p>Description: Classe mais porradona. Representa cada estado da árvore.
 * Possui diversos metodos de controle.</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company:  </p>
 * <p>Contact: gustavohe (,at.) gmail.com </p>
 * 
 * @author Gustavo Augusto Hennig e Rodrigo Baroni
 * @version 1.0
 *
 */
public class Estado {

  public Peca[][] tabuleiro;
  public Estado EstadoAnterior; //Uma referência ao ancestral(pai)
  private static int IdCount; //Contador de instancias de classe
  private int Id; //Idendificador do estado
  public int Nivel; //Nível de profundidade do estado

  public Estado(Estado pai) {

    if (pai == null) {
        IdCount=0;
      tabuleiro = new Peca[Global.ArraySize][Global.ArraySize];
    }
    else {
//      tabuleiro = pai.tabuleiro.clone();
      tabuleiro = pai.getTabuleiroCopy();

    }
    EstadoAnterior = pai;

    Id = IdCount;
    IdCount++;

  }

  public void SwapPecas(PosPeca peca1, PosPeca peca2) {

    Peca tmpPeca = tabuleiro[peca2.Linha][peca2.Coluna];
    tabuleiro[peca2.Linha][peca2.Coluna] = tabuleiro[peca1.Linha][
        peca1.Coluna];
    tabuleiro[peca1.Linha][peca1.Coluna] = tmpPeca;

  }

  public PosPeca getPosEspaco() throws Exception {

    PosPeca ret = null;

    for (int linha = 0; linha < Global.ArraySize; linha++) {
      for (int coluna = 0; coluna < Global.ArraySize; coluna++) {
        if (tabuleiro[linha][coluna].getNumber() == 0) {
          ret = new PosPeca(linha, coluna);

        }

      }
    }

    if (ret == null) {
      throw new Exception(
          "A peça zero nao foi encontrada no tabuleiro, deu pau mesmo, hehehe!!!");
    }

    return ret;

  }

  public ArrayList<Estado> getEstadosFilhos() {

    return Global.getPossiveisEstados(this);
  }

  public boolean isEstadoFinal() {
    return EstadoIgual(this, Global.EstadoFinal);
  }

  private boolean EstadoIgual(Estado e1, Estado e2) {

    for (int linha = 0; linha < Global.ArraySize; linha++) {
      for (int coluna = 0; coluna < Global.ArraySize; coluna++) {
        if (e1.tabuleiro[linha][coluna].getNumber() !=
            e2.tabuleiro[linha][coluna].getNumber()) {
          return false;

        }

      }
    }
    return true;
  }

  public boolean equals(Object obj) {

    if (obj instanceof Estado) {
      return EstadoIgual(this, ( (Estado) obj));
    }
    else {
      return false;
    }
  }

  public void PrintMe() {
    System.out.println(this.toString());
  }

  public String toString() {

    String ret = "";

    ret = " Estado: " + Id + "  Nivel: " + Nivel + "\n";

    ret += getSpaces(Nivel) + tabuleiro[0][0] + "  " + tabuleiro[0][1] +
        "  " +
        tabuleiro[0][2] + "\n";

    ret += getSpaces(Nivel) + tabuleiro[1][0] + "  " + tabuleiro[1][1] +
        "  " +
        tabuleiro[1][2] + "\n";

    ret += getSpaces(Nivel) + tabuleiro[2][0] + "  " + tabuleiro[2][1] +
        "  " +
        tabuleiro[2][2] + "\n";

    /*
        System.out.println(" Nivel: " + Nivel + "   Estado: " + Id);
     System.out.println(tabuleiro[0][0] + "  " + tabuleiro[0][1] + "  " +
                       tabuleiro[0][2]);
     System.out.println(tabuleiro[1][0] + "  " + tabuleiro[1][1] + "  " +
                       tabuleiro[1][2]);
     System.out.println(tabuleiro[2][0] + "  " + tabuleiro[2][1] + "  " +
                       tabuleiro[2][2]);
     */
    return ret;

  }

  private String getSpaces(int num) {

    String cat = "";

    for (int i = 0; i < num; i++) {
      cat += " . ";
    }
    return cat;

  }

  public Peca[][] getTabuleiroCopy() {

    Peca[][] ret = new Peca[Global.ArraySize][Global.ArraySize];

    for (int linha = 0; linha < Global.ArraySize; linha++) {
      for (int coluna = 0; coluna < Global.ArraySize; coluna++) {

        ret[linha][coluna] = tabuleiro[linha][coluna];

      }
    }

    return ret;
  }
}
