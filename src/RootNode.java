import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class RootNode extends Node {
   JFrame frame = new JFrame("Jogo Gourmet");

   public void doAsk() {
	      boolean response = JOptionPane.showConfirmDialog(this.frame, this.question, "Confirm", 0) == 0;
	      if(response) {
	         this.yesNode.doAsk();
	      } else {
	         this.noNode.doAsk();
	      }

	   }

}
