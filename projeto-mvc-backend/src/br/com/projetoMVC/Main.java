package br.com.projetoMVC;

import java.util.Scanner;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		int decisao = -1;
		Scanner scan = new Scanner(System.in);
		ProdutoController controller = new ProdutoController();
		
		
		
		do {
			System.out.println("Deseja: \n [1]Listar Todos \n [2]Cadastrar \n [3]Alterar \n [4]Excluir \n [5]Buscar por ID \n [0]Sair \n");
			decisao = scan.nextInt();
			
			switch (decisao) {
			case 1: 
				System.out.println("- Lista de Produtos - ");
				System.out.println("id    Descrição");
				for (Produto produto : controller.ListarTodos()) {
					System.out.println(produto.getId() + "     " + produto.getDescricao());
				}
				break;
			case 2:
				System.out.println("Digite oque deseja cadastrar : \n");
				String item = scan.next();
				Produto p = new Produto();
				p.setDescricao(item);
				controller.cadastrar(p);
				break;
			case 3:
				for (Produto produto : controller.ListarTodos()) {
					System.out.println(produto.getId() + "     " + produto.getDescricao());
				}
				
				System.out.println("Digite o ID do que você deseja Alterar: \n");
				int remoProduto = scan.nextInt();
				System.out.println("Digite oque você deseja botar no local: \n");
				String substituir = scan.next();
				
				Produto produtoEncontrado = controller.ListarPorId(remoProduto);
				produtoEncontrado.setDescricao(substituir);
				
				controller.alterar(produtoEncontrado);
				break;
				
			case 4:
				for (Produto produto : controller.ListarTodos()) {
					System.out.println(produto.getId() + "     " + produto.getDescricao());
				}
				
				System.out.println("Digite o ID do que deseja Alterar: \n");
				int idAlterar = scan.nextInt();
				
				Produto produtoAlterar = controller.ListarPorId(idAlterar);
				
				if (produtoAlterar != null) {
					System.out.println("Qual a nova descrição para o produto? ");
					produtoAlterar.setDescricao(scan.next());
					controller.alterar(produtoAlterar);
				} else {
					System.out.println("Produto não encontrado para o código: " + produtoAlterar);
				}
				
				break;
				
			case 5:
				System.out.println("Qual ID deseja Excluir: \n");
				int idBusca = scan.nextInt();
				Produto produtoPorId = controller.ListarPorId(idBusca);
				
				if (produtoPorId != null) {
					System.out.println("Produto: " + produtoPorId.getDescricao());
				} else {
					System.out.println("Produto não encontrado para o código: " + idBusca);
				}
				
				break;
			default:
				
			}
		} while ( decisao != 0);
		
		System.out.println("Saindo do Sistema.........");
		
		
		
		
		
	}

}
