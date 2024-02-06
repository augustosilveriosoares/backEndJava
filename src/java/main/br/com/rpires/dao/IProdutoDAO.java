/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;

import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoDAO {

	
	public Integer cadastrar(Produto produto) throws Exception;

	public Produto consultar(String codigo) throws Exception;

	public Integer excluir(Produto produto) throws Exception;

	public List<Produto> buscarTodos() throws Exception;

	public Integer atualizar(Produto produto) throws Exception;
}
