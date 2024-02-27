package br.com.augusto;


import org.junit.Test;

import br.com.augusto.dao.MarcaDao;
import br.com.augusto.domain.Marca;

public class PersistenceTeste {
	
	@Test
	public void cadastraMarca() {
		
		try {
			Marca marca = new Marca();
			marca.setNome("Toyota");
			MarcaDao dao = new MarcaDao();
			dao.cadastrar(marca);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
			
		
	}

}
