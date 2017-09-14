package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaBarrio extends SpringTest {

	@Test
    @Transactional
    @Rollback(true)	
	public void test() {
		// fail("Not yet implemented");
		
		List <Farmacia> resultado = new ArrayList<Farmacia>();
		resultado = getSession().createCriteria(Farmacia.class)
						.createAlias("direccion", "dir")
						.createAlias("dir.barrio", "barrio")
							.add(Restrictions.eq("barrio.nombre","nombreBarrio"))
							.list();
	}

}
