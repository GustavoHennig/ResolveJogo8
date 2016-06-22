package jogoia;

import java.util.ArrayList;

/**
 *
 *
 * <p>Title: Global</p>
 *
 * <p>Description: Classe que possui diversas funções e variáveis globais.</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company:  </p>
 * <p>Contact: gustavohe (,at.) gmail.com </p>
 * @author Gustavo Augusto Hennig e Rodrigo Baroni
 * @version 1.0
 *
 */
public class Global {

  public static final int ArraySize = 3; //Tamanho do tabuleiro
  public static ArrayList<Estado> estadosVisitados = new ArrayList<Estado> (); //Lista de Estados visitados, para evitar resultado repetido.
  public static int Nivel; //Nivel atual
  public static int NivelMaximo = 4; //Nivel máximo que o algoritmo atual pode executar
  public static int maxEstadosVisitados = 6; //Nro máx de estado para armazendar no log
  public static Estado EstadoFinal; //Estado desejado
  public static String stdOut = ""; 
  public static boolean fimEncontrado = false;


public static void Reinicia(){
  estadosVisitados = new ArrayList<Estado> ();
  Nivel = 0;
  stdOut = "";
  fimEncontrado = false;
}


  private static PosPeca getPosPeca(PosPeca or, Direcao dir) {

//Retorna a posição da próxima peça cfe a direção informada

    PosPeca ret = null;

    switch (dir) {
      case dBaixo:
        ret = new PosPeca(or.Linha + 1, or.Coluna);
        break;
      case dCima:
        ret = new PosPeca(or.Linha - 1, or.Coluna);
        break;

      case dDir:
        ret = new PosPeca(or.Linha, or.Coluna + 1);
        break;
      case dEsq:
        ret = new PosPeca(or.Linha, or.Coluna - 1);
        break;

    }

    return ret;
  }

  private static Estado getNewEstado(Estado estadoant, PosPeca posEspaco,
                                     Direcao movimento) {

    //Gera um novo estado
    Estado tmp = new Estado(estadoant);

    tmp.SwapPecas(posEspaco, getPosPeca(posEspaco, movimento));
    tmp.Nivel = estadoant.Nivel + 1;

    return tmp;

  }

  private static boolean isVisited(Estado est) {

    /* Essa rotina impede que um resultado seja igual ou parecido a algum
     antecessor próximo, o números de estados guardados é configurável.
     */

    for (Estado e : estadosVisitados) {
      if (e.equals(est)) {
        stdOut += "Estado repetido encontrado!\n";
        //System.out.println("Estado repetido!");
        estadosVisitados.add(est);
        if (estadosVisitados.size() > maxEstadosVisitados) {
            estadosVisitados.remove(0);
        }
        return true;
      }
    }

    estadosVisitados.add(est);
    if (estadosVisitados.size() > maxEstadosVisitados) {
      estadosVisitados.remove(0);
    }

//    stdOut+="Estado repetido encontrado!";
    //System.out.println("CNT estados visitados: " + estadosVisitados.size());

    return false;

  }

  public static ArrayList<Estado> getPossiveisEstados(Estado estadoatual) {

//Retorna todos possíveis estados de determinado Estado(Pai)

    ArrayList<Estado> ret = new ArrayList<Estado> ();
    PosPeca pos = null;

    try {
      pos = estadoatual.getPosEspaco();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

//As quatro direções:

    if (pos.Linha > 0) {
      Valida_E_AdicionaEstado(ret, getNewEstado(estadoatual, pos, Direcao.dCima));
    }

    if (pos.Linha < Global.ArraySize - 1) {
      Valida_E_AdicionaEstado(ret,
                              getNewEstado(estadoatual, pos, Direcao.dBaixo));
    }

    if (pos.Coluna > 0) {
      Valida_E_AdicionaEstado(ret, getNewEstado(estadoatual, pos, Direcao.dEsq));
    }

    if (pos.Coluna < Global.ArraySize - 1) {
      Valida_E_AdicionaEstado(ret, getNewEstado(estadoatual, pos, Direcao.dDir));
    }

    return ret;

  }

  private static void Valida_E_AdicionaEstado(ArrayList<Estado> al, Estado e) {

    //Validações gerais dos estados:

    if (fimEncontrado) {
      return;
    }

    if (e.isEstadoFinal()) {

      stdOut += "Estado final encontrado: \n";
      stdOut += e.toString() + "\n";

//      System.out.println(" Estado final encontrado.");
      //   System.exit(0);
      fimEncontrado = true;
      return;
    }

    if (!isVisited(e)) {

      stdOut += e.toString() + "\n";
      //      e.PrintMe();

      if (e.Nivel < NivelMaximo) {
        /* Essa chamada torna a rotina recursiva,
         * pois o filho carrega seus netos e assim por diante,
         * mas sempre seguindo a algoritmo da profundidade
         */
        e.getEstadosFilhos();
      }

      al.add(e);
    }
  }

  public static Estado getEstadoFinal() {
//Demo - Teste
    Estado e = new Estado(null);

    e.Nivel = 0;
    e.tabuleiro[0][0] = new Peca(1);
    e.tabuleiro[0][1] = new Peca(5);
    e.tabuleiro[0][2] = new Peca(6);
    e.tabuleiro[1][0] = new Peca(4);
    e.tabuleiro[1][1] = new Peca(7);
    e.tabuleiro[1][2] = new Peca(2);
    e.tabuleiro[2][0] = new Peca(0);
    e.tabuleiro[2][1] = new Peca(8);
    e.tabuleiro[2][2] = new Peca(3);

    return e;

  }

  public static Estado getEstadoInicial() {
//Demo - Teste
    Estado e = new Estado(null);

    e.Nivel = 0;
    e.tabuleiro[0][0] = new Peca(1);
    e.tabuleiro[0][1] = new Peca(6);
    e.tabuleiro[0][2] = new Peca(5);
    e.tabuleiro[1][0] = new Peca(4);
    e.tabuleiro[1][1] = new Peca(7);
    e.tabuleiro[1][2] = new Peca(2);
    e.tabuleiro[2][0] = new Peca(8);
    e.tabuleiro[2][1] = new Peca(0);
    e.tabuleiro[2][2] = new Peca(3);

    return e;

  }

}
