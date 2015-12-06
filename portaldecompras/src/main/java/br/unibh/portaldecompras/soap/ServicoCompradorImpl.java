package br.unibh.portaldecompras.soap;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import br.unibh.portaldecompras.model.Comprador;

@WebService(endpointInterface = "br.unibh.portaldecompras.soap.ServicoComprador", serviceName = "comprador")
@Stateless
public class ServicoCompradorImpl implements ServicoComprador {
	@Inject
	private EntityManager em;
	@Inject
	private Logger log;

	@SuppressWarnings("unchecked")
	@Override
	public Comprador[] listarTodos() {
		log.info("Encontrando todos os compradores");
		List<Object> lista = em.createQuery("from Comprador").getResultList();
		return lista.toArray(new Comprador[lista.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comprador[] listar(String nome) {
		log.info("Encontrando comprador " + nome);
		List<Object> lista = em.createQuery("select c from Comprador c where c.nome like :nome")
				.setParameter("nome", nome + "%").getResultList();
		return lista.toArray(new Comprador[lista.size()]);
	}

}
