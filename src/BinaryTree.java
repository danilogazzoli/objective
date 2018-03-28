
public class BinaryTree {
    RootNode root;


    public BinaryTree() {
        Node yesNode = new Node();
        yesNode.setDish(new Dish("Lasanha"));

        Node noNode = new Node();
        noNode.setDish(new Dish("Bolo de Chocolate"));

        this.root = new RootNode(); //nó raiz
        this.root.setQuestion("O prato que você pensou é massa?"); //pergunta inicial
        this.root.setYesNode(yesNode);
        this.root.setNoNode(noNode);
    	
    }	 
    
}
