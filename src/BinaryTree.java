import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class BinaryTree {
	JFrame frame = new JFrame("Game Gourmet");
	Object[] options = {"Sim", "Não"};
    Node root;
    int resposta = 0;
	String pratoAtual = "";
	String pratoAnterior = "";
	String caracteristicaAtual = "";
	Node noAtual = null;

    public BinaryTree() {
    	this.root = new Node(1, "lasanha", "massa");
    	this.root.esquerda = new Node(1, "Bolo de Chocolate", "Doce");
    }	 
    
  
    private Node addRecursive(Node current, int valor, String nomePrato, String caracteristicaPrato) {
        if (current == null) {
            return new Node(valor, nomePrato, caracteristicaPrato);
        }
     
        if (valor < current.valor) {
            current.esquerda = addRecursive(current.esquerda, valor, nomePrato, caracteristicaPrato);
        } else if (valor > current.valor) {
            current.direita = addRecursive(current.direita, valor, nomePrato, caracteristicaPrato);
        } else {
            // value already exists
            return current;
        }
     
        return current;
    }	
    
    private Node newNode(Node currentNode) {
		this.pratoAtual = JOptionPane.showInputDialog("Qual prato você pensou?", "Digite seu prato aqui.");
			
	    this.caracteristicaAtual = JOptionPane.showInputDialog(this.pratoAtual + " é _________ mas " + currentNode.nomePrato + " não é", "Digite seu nome aqui."); 
	    return new Node(1, this.pratoAtual, this.caracteristicaAtual); 
    	
    }
    
    private void createContinue(Node currentNode) {    
		if (currentNode.esquerda == null) {
			currentNode.esquerda = this.newNode(currentNode); 
		} else
		{	
			traversePreOrder(currentNode.direita);
			traversePreOrder(currentNode.esquerda);    
		}   
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
        	this.resposta = JOptionPane.showOptionDialog(frame,
        		    "O prato que você pensou é " + node.caracteristicaPrato + "?",
        		    "Pergunta da característica",
        		    JOptionPane.YES_NO_CANCEL_OPTION,
        		    JOptionPane.QUESTION_MESSAGE,
        		    null,
        		    options,
        		    options[0]);
        	
        	if (resposta == 0) {
        		this.resposta = JOptionPane.showOptionDialog(frame,
            		    "O prato que você pensou é " + node.nomePrato + "?",
            		    "Pergunta do prato",
            		    JOptionPane.YES_NO_CANCEL_OPTION,
            		    JOptionPane.QUESTION_MESSAGE,
            		    null,
            		    options,
            		    options[0]);
        		if (resposta == 0) {
            		JOptionPane.showMessageDialog(frame, "Acertei de novo");
        		} else {      			
        			//
        			this.createContinue(node);
        		} 
        		
        	}else {
        		this.createContinue(node);
        	}
        } 
    }  

    public void add(int value, String nomePrato, String caracteristicaPrato) {
        root = addRecursive(root, value, nomePrato, caracteristicaPrato);
    }	    
}
