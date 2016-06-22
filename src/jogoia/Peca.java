/*
 * Peca.java
 *
 * Created on 19 de Março de 2007, 20:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jogoia;

/**
 *
 *
 * <p>Title: Peca</p>
 *
 * <p>Description: Classe quer representa uma peca do tabuleiro.</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company:  </p>
 * <p>Contact: gustavohe (,at.) gmail.com </p>
 * @author Gustavo Augusto Hennig
 * @version 1.0
 *
 */
public class Peca {


    private int _number;
    /** Creates a new instance of Peca */
    public Peca(int number) {
        _number=number;
    }

    public int getNumber(){
        return _number;
    }

    public String toString(){
      return String.valueOf(_number);
    }

}
