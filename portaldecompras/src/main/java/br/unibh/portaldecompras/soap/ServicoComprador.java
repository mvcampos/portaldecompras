package br.unibh.portaldecompras.soap;

import javax.jws.WebParam;
import javax.jws.WebService;

import br.unibh.portaldecompras.model.Comprador;

@WebService(name = "comprador", targetNamespace = "http://www.unibh.br")
public interface ServicoComprador {
	public Comprador[] listarTodos();

	public Comprador[] listar(@WebParam(name = "nome") String nome);


}
