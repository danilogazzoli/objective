import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] options = {"Ok", "Cancelar"};
		int resposta = 0;
		
		JFrame frame = new JFrame("Game Gourmet");
		
	    BinaryTree bt = new BinaryTree();
		// Pergunta Inicial
		while (resposta == 0) {
			resposta = JOptionPane.showOptionDialog(frame,
        		    "Pense num prato que você gosta.",
        		    "",
        		    JOptionPane.OK_OPTION,
        		    JOptionPane.CANCEL_OPTION,
        		    null,
        		    options,
        		    options[0]);
					
					/* JOptionPane.showMessageDialog(frame, "Pense num prato que você gosta"); */
			if (resposta == 0) {
				bt.traversePreOrder(bt.root);
			}
		}

	}

}
