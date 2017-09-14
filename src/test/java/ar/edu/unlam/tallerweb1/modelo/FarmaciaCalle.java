package ar.edu.unlam.tallerweb1.modelo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.AssertDelegateTarget;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import javassist.bytecode.Descriptor.Iterator;

public class FarmaciaCalle extends SpringTest {

	@Test
    @Transactional
    @Rollback(false)
	public void getFarmaciaCalle() {
		/*
		Direccion d = new Direccion();
		d.setCalle("xxxxx");
		
		Farmacia f = new Farmacia();
		f.setDiaDeTurno("martes");
		f.setDireccion(d);
		getSession().save(f);
		*/
		
		List <Farmacia> farmacias = getSession().createCriteria(Farmacia.class)
										.createAlias("direccion", "direccion")
										.add(Restrictions.eq("direccion.calle", "xxxxx"))
										.list();

	}

}
