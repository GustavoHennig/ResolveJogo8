package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import jogoia.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: Essa classe desenha um tabuleiro</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company:  </p>
 * <p>Contact: gustavohe (,at.) gmail.com </p>
 *
 * @author Rodrigo Baroni e Gustavo Augusto Hennig
 * @version 1.0
 */
public class pnTabuleiro
    extends JPanel {
  JLabel jl11 = new JLabel();
  JLabel jl01 = new JLabel();
  JLabel jl22 = new JLabel();
  JLabel jl13 = new JLabel();
  JLabel jl03 = new JLabel();
  JLabel jl02 = new JLabel();
  JLabel jl12 = new JLabel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel jl21 = new JLabel();
  JLabel jl23 = new JLabel();

  public pnTabuleiro() {
    try {
      jbInit();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setLayout(gridLayout1);
    jl11.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl11.setBorder(BorderFactory.createLineBorder(Color.black));
    jl11.setHorizontalAlignment(SwingConstants.CENTER);
    jl11.setText("4");
    jl11.addMouseListener(new Panel1_jl11_mouseAdapter(this));
    jl01.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl01.setBorder(BorderFactory.createLineBorder(Color.black));
    jl01.setHorizontalAlignment(SwingConstants.CENTER);
    jl01.setText("1");
    jl01.addMouseListener(new Panel1_jl01_mouseAdapter(this));
    jl22.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl22.setBorder(BorderFactory.createLineBorder(Color.black));
    jl22.setHorizontalAlignment(SwingConstants.CENTER);
    jl22.setText("8");
    jl22.addMouseListener(new Panel1_jLabel3_mouseAdapter(this));
    jl13.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl13.setBorder(BorderFactory.createLineBorder(Color.black));
    jl13.setHorizontalAlignment(SwingConstants.CENTER);
    jl13.setText("6");
    jl13.addMouseListener(new Panel1_jl13_mouseAdapter(this));
    jl03.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl03.setBorder(BorderFactory.createLineBorder(Color.black));
    jl03.setHorizontalAlignment(SwingConstants.CENTER);
    jl03.setText("3");
    jl03.addMouseListener(new Panel1_jl03_mouseAdapter(this));
    jl02.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl02.setBorder(BorderFactory.createLineBorder(Color.black));
    jl02.setHorizontalAlignment(SwingConstants.CENTER);
    jl02.setText("2");
    jl02.addMouseListener(new Panel1_jl02_mouseAdapter(this));
    jl12.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl12.setBorder(BorderFactory.createLineBorder(Color.black));
    jl12.setHorizontalAlignment(SwingConstants.CENTER);
    jl12.setText("5");
    jl12.addMouseListener(new Panel1_jl12_mouseAdapter(this));
    gridLayout1.setColumns(3);
    gridLayout1.setRows(3);
    jl21.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl21.setBorder(BorderFactory.createLineBorder(Color.black));
    jl21.setHorizontalAlignment(SwingConstants.CENTER);
    jl21.setText("7");
    jl21.addMouseListener(new Panel1_jl21_mouseAdapter(this));
    jl23.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jl23.setBorder(BorderFactory.createLineBorder(Color.black));
    jl23.setHorizontalAlignment(SwingConstants.CENTER);
    jl23.addMouseListener(new Panel1_jl23_mouseAdapter(this));
    this.add(jl01, null);
    this.add(jl02);
    this.add(jl03);
    this.add(jl11, null);
    this.add(jl12, null);
    this.add(jl13, null);
    this.add(jl21);
    this.add(jl22, null);
    this.add(jl23);
  }

  public boolean habilitaEdicao = false;

  public void setaNumeros(MouseEvent e, Object send) {
    if (!habilitaEdicao) {
      return;
    }
    String txt;
    txt = JOptionPane.showInputDialog(null, "Digite um número entre 0 e 8");


    if (txt.equals("")) {
      return;
    }
    if (txt.equals("0")) {
      txt = "";
    }

    /*if (!verificaDadosTabuleiro(txt)) {
      JOptionPane.showMessageDialog(null, "Número já existe", "Mensagem: Erro",
                                    JOptionPane.ERROR_MESSAGE);
      return;

         }*/

    ( (JLabel) send).setText(txt);
  }

  public boolean validaDadosTabuleiro() {

    if ( (verificaDadosTabuleiro(jl01)) || (verificaDadosTabuleiro(jl02)) ||
        (verificaDadosTabuleiro(jl03)) || (verificaDadosTabuleiro(jl11)) ||
        (verificaDadosTabuleiro(jl12)) || (verificaDadosTabuleiro(jl13)) ||
        (verificaDadosTabuleiro(jl21)) || (verificaDadosTabuleiro(jl22)) ||
        (verificaDadosTabuleiro(jl23))) {

      JOptionPane.showMessageDialog(null, "Os valores informados no tabuleiro estão repetidos, não será possível continuar.",
                                    "Mensagem: Erro",
                                    JOptionPane.ERROR_MESSAGE);
      return false;

    }
    else {
      return true;
    }
  }

  public boolean verificaDadosTabuleiro(JLabel txt) {

    return (

        (txt.getText().equals(jl01.getText()) && !txt.equals(jl01)) ||
        (txt.getText().equals(jl02.getText()) && !txt.equals(jl02)) ||
        ( (txt.getText().equals(jl03.getText()) && !txt.equals(jl03)) ||
         (txt.getText().equals(jl11.getText()) && !txt.equals(jl11)) ||
         (txt.getText().equals(jl12.getText()) && !txt.equals(jl12)) ||
         (txt.getText().equals(jl13.getText()) && !txt.equals(jl13)) ||
         (txt.getText().equals(jl21.getText()) && !txt.equals(jl21)) ||
         (txt.getText().equals(jl22.getText()) && !txt.equals(jl22)) ||
         (txt.getText().equals(jl23.getText()) && !txt.equals(jl23))));

  }

  public Estado getEstado() {

    Estado e = new Estado(null);

    e.Nivel = 0;
    e.tabuleiro[0][0] = new Peca(getInt(jl01.getText()));
    e.tabuleiro[0][1] = new Peca(getInt(jl02.getText()));
    e.tabuleiro[0][2] = new Peca(getInt(jl03.getText()));
    e.tabuleiro[1][0] = new Peca(getInt(jl11.getText()));
    e.tabuleiro[1][1] = new Peca(getInt(jl12.getText()));
    e.tabuleiro[1][2] = new Peca(getInt(jl13.getText()));
    e.tabuleiro[2][0] = new Peca(getInt(jl21.getText()));
    e.tabuleiro[2][1] = new Peca(getInt(jl22.getText()));
    e.tabuleiro[2][2] = new Peca(getInt(jl23.getText()));

    return e;

  }

  private int getInt(String str) {
    int ret = 0;
    if (str != "") {
      ret = Integer.parseInt(str);
    }
    else {
      ret = 0;
    }

    return ret;
  }

  public void jl01_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl01);
  }

  public void jl02_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl02);
  }

  public void jl03_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl03);
  }

  public void jl12_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl12);
  }

  public void jl13_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl13);
  }

  public void jl21_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl21);
  }

  public void jl23_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl23);
  }

  public void jl22_mouseReleased(MouseEvent e) {
    setaNumeros(e, jl22);
  }

}

class Panel1_jLabel3_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jLabel3_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl22_mouseReleased(e);
  }
}

class Panel1_jl23_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl23_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl23_mouseReleased(e);
  }
}

class Panel1_jl21_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl21_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl21_mouseReleased(e);
  }
}

class Panel1_jl13_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl13_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl13_mouseReleased(e);
  }
}

class Panel1_jl12_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl12_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl12_mouseReleased(e);
  }
}

class Panel1_jl11_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl11_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {

    adaptee.jl01_mouseReleased(e);
  }
}

class Panel1_jl03_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl03_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl03_mouseReleased(e);
  }
}

class Panel1_jl02_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl02_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl02_mouseReleased(e);
  }
}

class Panel1_jl01_mouseAdapter
    extends MouseAdapter {
  private pnTabuleiro adaptee;
  Panel1_jl01_mouseAdapter(pnTabuleiro adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseReleased(MouseEvent e) {
    adaptee.jl01_mouseReleased(e);
  }
}
