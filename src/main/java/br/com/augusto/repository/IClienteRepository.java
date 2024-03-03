/**
 * 
 */
package br.com.augusto.repository;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Cliente;



/**
 * @author augustoss
 *
 */
@Repository
@Configurable
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}
