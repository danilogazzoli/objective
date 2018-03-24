import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class BinaryTree {
	JFrame frame = new JFrame("Game Gourmet");
	Object[] options = {"Sim", "Não"};
    Node root;


    public BinaryTree() {
    	this.root = new Node(1, "lasanha", "massa");
    	this.root.esquerda = new Node(1, "Bolo de Chocolate", "Doce");
    }	 
    
   
    private Node newNode(Node currentNode) {
    	String pratoAtual = JOptionPane.showInputDialog("Qual prato você pensou?", "Digite seu prato aqui.");
    	String caracteristicaAtual = null;
    	if (pratoAtual != null) {
    		caracteristicaAtual = JOptionPane.showInputDialog(pratoAtual + " é _________ mas " + currentNode.nomePrato + " não é", "Digite seu nome aqui.");
    	}	
    	if ((pratoAtual == null) || (caracteristicaAtual == null)) {
    		return null;
    	} else {
    		return new Node(1, pratoAtual, caracteristicaAtual);
    	}
    	
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
        int resposta = 0;
        if (node != null) {
        	resposta = JOptionPane.showOptionDialog(frame,
        		    "O prato que você pensou é " + node.caracteristicaPrato + "?",
        		    "Pergunta da característica",
        		    JOptionPane.YES_NO_CANCEL_OPTION,
        		    JOptionPane.QUESTION_MESSAGE,
        		    null,
        		    options,
        		    options[0]);
        	
        	if (resposta == 0) {
        		resposta = JOptionPane.showOptionDialog(frame,
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
        			this.createContinue(node);
        		} 
        		
        	}else {
        		this.createContinue(node);
        	}
        } 
    }      
}
