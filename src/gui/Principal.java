package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import jogoia.Estado;
import java.util.ArrayList;
import jogoia.Global;

/**
 * <p>Title: </p>
 *
 * <p>Description: Essa é a classe gráfica principal.</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company:  </p>
 * <p>Contact: gustavohe (,at.) gmail.com </p>
 *
 * @author Rodrigo Baroni e Gustavo Augusto Hennig
 * @version 1.0
 */
public class Principal
    extends JFrame {
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jmArquivo = new JMenu();
  JMenuItem jmiSair = new JMenuItem();

  pnTabuleiro tabuleiroOrigem = new pnTabuleiro();
  pnTabuleiro tabuleiroDestino = new pnTabuleiro();
  JLabel jlTabuleiroOrigem = new JLabel();
  JLabel jlTabuleiroDestino = new JLabel();
  JLabel jlTempo = new JLabel();
  public JLabel jlRelogio = new JLabel();
  int tempo_restante = 0;
  Timer timer = null;
  JButton jbExecutar = new JButton();
  JButton jbParar = new JButton();
  JLabel jlConfigProfundidade = new JLabel();
  JTextField jtfProfundidade = new JTextField();
  JTextArea jtaEstados = new JTextArea();
  JTextField jtfTamEstRep = new JTextField();
  JLabel jlTamLista = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  public Principal() {
    try {
      jbInit();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    getContentPane().setLayout(null);
    // jScrollPane1 = new JScrollPane( new JScrollPane(jtaEstados));
    tabuleiroOrigem.setBounds(new Rectangle(71, 63, 193, 155));
    tabuleiroDestino.setBounds(new Rectangle(71, 253, 193, 164));
    jlTabuleiroOrigem.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jlTabuleiroOrigem.setHorizontalAlignment(SwingConstants.CENTER);
    jlTabuleiroOrigem.setText("Tabuleiro Origem");
    jlTabuleiroOrigem.setBounds(new Rectangle(71, 33, 162, 26));
    jlTabuleiroDestino.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jlTabuleiroDestino.setHorizontalAlignment(SwingConstants.CENTER);
    jlTabuleiroDestino.setText("Tabuleiro Destino");
    jlTabuleiroDestino.setBounds(new Rectangle(71, 224, 162, 21));
    jlTempo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jlTempo.setHorizontalAlignment(SwingConstants.CENTER);
    jlTempo.setText("Tempo:");
    jlTempo.setBounds(new Rectangle(36, 534, 77, 25));
    jlRelogio.setBackground(Color.white);
    jlRelogio.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
    jlRelogio.setOpaque(true);
    jlRelogio.setHorizontalAlignment(SwingConstants.CENTER);
    jlRelogio.setBounds(new Rectangle(109, 530, 89, 32));
    jbExecutar.setBounds(new Rectangle(30, 427, 96, 24));
    jbExecutar.setText("Executar");
    jbExecutar.addActionListener(new Principal_jbExecutar_actionAdapter(this));
    jbParar.setBounds(new Rectangle(138, 426, 101, 26));
    jbParar.setText("Parar");
    jbParar.setVisible(true);
    jbParar.addActionListener(new Principal_jbParar_actionAdapter(this));
    jlConfigProfundidade.setText("Configurar Profundidade Máxima:");
    jlConfigProfundidade.setBounds(new Rectangle(34, 466, 191, 23));
    jtfProfundidade.setText("4");
    jtfProfundidade.setBounds(new Rectangle(259, 462, 62, 24));
    jtaEstados.setBorder(BorderFactory.createLineBorder(Color.black));
    jtaEstados.setEditable(false);
    jtfTamEstRep.setText("10");
    jtfTamEstRep.setBounds(new Rectangle(259, 491, 62, 24));
    jlTamLista.setText("Tamanho da lista de estados repetidos:");
    jlTamLista.setBounds(new Rectangle(33, 493, 191, 23)); // jScrollPane1.setBounds(new Rectangle(333, 58, 342, 615));
    jScrollPane1.setBounds(new Rectangle(363, 34, 316, 549));
    jLabel1.setText("jLabel1");
    jLabel1.setBounds(new Rectangle( -41, 203, 34, 14));
    jLabel2.setText("jLabel2");
    jLabel2.setBounds(new Rectangle( -39, 199, 34, 14));
    jLabel3.setFont(new java.awt.Font("Arial", Font.BOLD | Font.ITALIC, 14));
    jLabel3.setText("Gustavo Augusto Hennig e Rodrigo Baroni");
    jLabel3.setBounds(new Rectangle(389, 8, 291, 20));
    this.getContentPane().add(jScrollPane1);
    this.getContentPane().add(jbExecutar);
    this.getContentPane().add(jbParar);
    this.getContentPane().add(jlConfigProfundidade);
    this.getContentPane().add(jtfTamEstRep);
    this.getContentPane().add(jtfProfundidade);
    this.getContentPane().add(jlTamLista);
    this.getContentPane().add(jlRelogio);
    this.getContentPane().add(jlTempo);
    this.getContentPane().add(tabuleiroDestino, null);
    this.getContentPane().add(tabuleiroOrigem, null);
    this.getContentPane().add(jlTabuleiroDestino);
    this.getContentPane().add(jlTabuleiroOrigem);
    this.getContentPane().add(jLabel1);
    this.getContentPane().add(jLabel2);
    this.getContentPane().add(jLabel3);
    jScrollPane1.getViewport().add(jtaEstados);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setJMenuBar(jMenuBar1);
    this.setTitle("Jogo dos 8");
    this.setVisible(true);
    this.setSize(691, 644);
    jmArquivo.setText("Arquivo");
    jmiSair.setText("Sair");
    jmiSair.addActionListener(new Principal_jMenuItem2_actionAdapter(this));
    jMenuBar1.add(jmArquivo);
    jmArquivo.add(jmiSair);
    tabuleiroOrigem.setVisible(true);
    tabuleiroDestino.setVisible(true);
    tabuleiroOrigem.habilitaEdicao = true;
    tabuleiroDestino.habilitaEdicao = true;
    IniciaTimer();

  }

  public static void main(String[] args) {
    Principal principal = new Principal();
  }

  public void jMenuItem2_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  public void aumenta_segundos() {
    tempo_restante++;
    jlRelogio.setText(String.valueOf( (int) Math.floor(tempo_restante / 60)) +
                      ":" + String.valueOf(tempo_restante % 60));
  }

  public void IniciaTimer() {
    timer = new Timer(1000, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        aumenta_segundos();
      }
    });
    timer.stop();
  }

  public void jbExecutar_actionPerformed(ActionEvent e) {

	//Somente faz o processamento se os dados dos 
	// dois tabuleiros forem consistentes.
    if (tabuleiroOrigem.validaDadosTabuleiro() && tabuleiroDestino.validaDadosTabuleiro() ) {

      jbParar.setEnabled(true);
      jbExecutar.setEnabled(false);
      timer.start();

      Executa();
    }
  }

  private void Executa() {

    //Executa o processamento

    //Global.getEstadoInicial(); Somente para teste

    //Guarda a hora atual
    long tempoor = System.currentTimeMillis();
      
    jtaEstados.setText("");
    Global.Reinicia();

    //Pega o estado origem informado na tela principal
    Estado e = tabuleiroOrigem.getEstado();

    //Adiciona o primeiro estado na fila de estados visitados
    Global.estadosVisitados.add(e);
    
    jtaEstados.append(e.toString());

    Global.NivelMaximo = Integer.parseInt(jtfProfundidade.getText());
    Global.maxEstadosVisitados = Integer.parseInt(jtfTamEstRep.getText());
//    e.PrintMe();

 
//    Global.EstadoFinal = Global.getEstadoFinal();
//  Pega o estado destindo informado na tela principal
    Global.EstadoFinal = tabuleiroDestino.getEstado();

    //System.out.println("ESTADO DESEJADO:");

    //Global.EstadoFinal.PrintMe();


//Busca todos possíveis filhos do estado inicial
    ArrayList<Estado> el = e.getEstadosFilhos();
    /*
     Para cada filho o algorítmo busca seu filhos(netos) e assim
        sucessivamente até o limite de profundidade.
     */
    for (Estado e2 : el) {
      e2.getEstadosFilhos();
    }

    jtaEstados.append(Global.stdOut);
    Global.stdOut = "";

    if (!Global.fimEncontrado) {
      jtaEstados.append("Resultado final não pode ser encontrado com essa configuração de profundidade.\n");
                        } ;

      jbParar_actionPerformed(null);
      System.gc();
      
      long lo =  System.currentTimeMillis() - tempoor ;
      
      jlRelogio.setText( String.valueOf(lo ) );
      

    }

    public void jbParar_actionPerformed(ActionEvent e) {
      jbExecutar.setEnabled(true);
      jbParar.setEnabled(false);
      timer.stop();
    }
  }

  class Principal_jbParar_actionAdapter
      implements ActionListener {
    private Principal adaptee;
    Principal_jbParar_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jbParar_actionPerformed(e);
    }
  }

  class Principal_jbExecutar_actionAdapter
      implements ActionListener {
    private Principal adaptee;
    Principal_jbExecutar_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jbExecutar_actionPerformed(e);
    }
  }

  class Principal_jMenuItem2_actionAdapter
      implements ActionListener {
    private Principal adaptee;
    Principal_jMenuItem2_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuItem2_actionPerformed(e);
    }
  }
