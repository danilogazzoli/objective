public class Node {
	int valor;
    String nomePrato;
    String caracteristicaPrato;
    Node esquerda;
    Node direita;
 
    Node(int valor, String nomePrato, String caracteristicaPrato) {
        this.valor = valor;
        this.nomePrato = nomePrato;
        this.caracteristicaPrato = caracteristicaPrato;
        direita = null;
        esquerda = null;
    }
}