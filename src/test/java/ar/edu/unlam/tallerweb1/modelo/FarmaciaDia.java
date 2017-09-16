package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import javassist.bytecode.Descriptor.Iterator;

public class FarmaciaDia extends SpringTest{

	@Test
    @Transactional
    @Rollback(true)
	public void getFarmaciasByDiaTurno() {
		//fail("Not yet implemented");
	    
		saveDataForTest();
	    
		List <Farmacia> farmacias = new ArrayList<Farmacia>();
		farmacias = getSession().createCriteria(Farmacia.class)
										.add(Restrictions.eq("diaDeTurno","martes"))
										.list();
		
		for(Farmacia f : farmacias){
			//System.out.println(f.getDiaDeTurno());
			Assert.assertEquals(f.getDiaDeTurno(), "Martes");
		}
		
	}

}
