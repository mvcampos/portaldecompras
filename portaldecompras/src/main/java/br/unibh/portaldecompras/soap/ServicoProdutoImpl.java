package br.unibh.portaldecompras.soap;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import br.unibh.portaldecompras.model.Produto;

@WebService(endpointInterface = "br.unibh.portaldecompras.soap.ServicoProduto", serviceName = "produto")
@Stateless
public class ServicoProdutoImpl implements ServicoProduto {
	@Inject
	private EntityManager em;
	@Inject
	private Logger log;

	@SuppressWarnings("unchecked")
	@Override
	public Produto[] listarTodos() {
		log.info("Encontrando todos os produtos");
		List<Object> lista = em.createQuery("from Produto").getResultList();
		return lista.toArray(new Produto[lista.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Produto[] listar(String descricao) {
		log.info("Encontrando produto " + descricao);
		List<Object> lista = em.createQuery("select c from Produto c where c.descricao like :descricao")
				.setParameter("descricao", descricao + "%").getResultList();
		return lista.toArray(new Produto[lista.size()]);
	}

}