import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] options = {"Ok"};
		int resposta = 0;
		
		JFrame frame = new JFrame("Game Gourmet");
		
	    BinaryTree bt = new BinaryTree();
	    
		// Pergunta Inicial
		while (resposta == 0) {
			resposta = JOptionPane.showOptionDialog(frame,
        		    "Pense em um prato que você gosta.",
        		    "Jogo Gourmet",
        		    JOptionPane.OK_OPTION,
        		    JOptionPane.CANCEL_OPTION,
        		    null,
        		    options,
        		    options[0]);
			
			if (resposta == 0) {
				bt.root.doAsk();
			}
		}
		System.exit(0);

	}

}
