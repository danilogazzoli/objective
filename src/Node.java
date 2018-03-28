import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Node {
   JFrame frame = new JFrame("Jogo Gourmet");
	
   private Dish dish;
   protected Node parentNode;
   protected Node yesNode;
   protected Node noNode;
   private boolean isYesNode;
   protected String question;   
   
   public Dish getDish() {
	 return this.dish;
   }
   
   public void setDish(Dish value) {
	 this.dish = value;
   }
   
   public String getQuestion() {
      return this.question;
   }

   public void setQuestion(String value) {
     this.question = value;
   }

   public Node getYesNode() {
      return this.yesNode;
   }

   public void setYesNode(Node value) {
	  this.yesNode = value;
	  yesNode.setParentNode(this);
	  yesNode.isYesNode = true;
   }

   public Node getNoNode() {
	  return this.noNode;
   }

   public void setNoNode(Node value) {
	  this.noNode = value;
	  noNode.setParentNode(this);
	  noNode.isYesNode = false;
   }

   protected Node getParentNode() {
      return this.parentNode;
   }

   protected void setParentNode(Node parentNode) {
      this.parentNode = parentNode;
   }

   protected boolean isYesNode() {
	  return this.isYesNode;
   }
   
   public void doAsk() {
	  int response = JOptionPane.showConfirmDialog(this.frame, "O prato que você pensou é " + this.dish.getDishName() + "?", "Confirm", 0);
	  
	  if(response == 0) {
		  JOptionPane.showMessageDialog(this.frame, "Acertei de novo!", "Jogo Gourmet", 1);
	  } else {
	    
	    String currentDish = JOptionPane.showInputDialog(this.frame, "Qual prato você pensou?", "Desisto", 3);
	    if (currentDish != null) {
		    String question = JOptionPane.showInputDialog(this.frame, currentDish + " é _______ mas " + this.dish.getDishName() + " não.", "Complete", 3);
		    if (question != null ){
			    question = "O prato que você pensou é " + question + "?";
			    
			    //cria o nó. - um nível de hierarquia
			    Node newNode = new RootNode();
			    
			    Node newYesNode = new Node();
			    newYesNode.setDish(new Dish(currentDish));
			
			    if(this.isYesNode()) {
			       this.getParentNode().setYesNode(newNode);
			    } else {
			       this.getParentNode().setNoNode(newNode);
			    }
			
			    newNode.setQuestion(question);
			    newNode.setYesNode(newYesNode);
			    newNode.setNoNode(this);
		    }
	    
	    }
	  } 
   }
   
}