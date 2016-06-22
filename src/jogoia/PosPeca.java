package jogoia;


/**
 *
 * <p>Title: PosPeca</p>
 *
 * <p>Description: Classe quer representa a posição de determinada peça no tabuleiro.</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company:  </p>
 * <p>Contact: gustavohe (,at.) gmail.com </p>
 * 
 * @author Gustavo Augusto Hennig
 * @version 1.0
 *
 */

public class PosPeca {

  public PosPeca(int linha, int coluna) {
    this.Coluna = coluna;
    this.Linha = linha;
  }

  public int Coluna = 0;
  public int Linha = 0;
}
