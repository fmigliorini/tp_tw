package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import org.junit.Assert;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaCalle extends SpringTest {

	@Test
    @Transactional
    @Rollback(true)
	public void getFarmaciaCalle() {

		saveDataForTest();
		
		List <Farmacia> farmacias = getSession().createCriteria(Farmacia.class)
										.createAlias("direccion", "direccion")
										.add(Restrictions.eq("direccion.calle", "Calle2"))
										.list();

		for( Farmacia f: farmacias){
			Assert.assertEquals(f.getDireccion().getCalle(), "Calle2");		
		}
	}

}
