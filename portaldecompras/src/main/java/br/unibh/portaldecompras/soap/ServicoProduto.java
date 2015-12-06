package br.unibh.portaldecompras.soap;

import javax.jws.WebParam;
import javax.jws.WebService;

import br.unibh.portaldecompras.model.Produto;

@WebService(name = "produto", targetNamespace = "http://www.unibh.br")
public interface ServicoProduto {
	public Produto[] listarTodos();

	public Produto[] listar(@WebParam(name = "descricao") String nome);


}
