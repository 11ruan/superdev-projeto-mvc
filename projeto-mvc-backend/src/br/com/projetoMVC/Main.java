package br.com.projetoMVC;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		ProdutoController controller = new ProdutoController();
		
		Produto p = new Produto();
		p.setDescricao("Cadeira Gamer");
		controller.cadastrar(p);
		
		System.out.println("- Lista de Produtos - ");
		System.out.println("id    Descrição");
		for (Produto produto : controller.ListarTodos()) {
			System.out.println(produto.getId() + "     " + produto.getDescricao());
		}
		
	}

}
