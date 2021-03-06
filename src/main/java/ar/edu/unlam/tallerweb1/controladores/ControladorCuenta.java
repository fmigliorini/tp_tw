package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Calculadora;

@Controller
public class ControladorCuenta {
	
	@RequestMapping(path="/operation/suma/{num1}/{num2}", method = RequestMethod.GET)
	public ModelAndView sumar(@PathVariable("num1") int num1, @PathVariable("num2") int num2 ){
		try{
			ModelMap modelo = new ModelMap();
			
			Calculadora calc = new Calculadora();
			calc.setNum1(num1);
			calc.setNum2(num2);
			Integer suma = calc.sum();
			
			modelo.put("num1", calc.getNum1());
			modelo.put("num2", calc.getNum2());
			modelo.put("res", suma);			
			
			return new ModelAndView("/resultGet", modelo);
			
		} catch(Throwable t) {
			
			return new ModelAndView("/errorGet");
		}
		
	}

	
	@RequestMapping(path="/calc")
	public ModelAndView irAInicio(){
		ModelMap modelo = new ModelMap();
		Calculadora calculadora = new Calculadora();
		modelo.put("calculadora", calculadora);
		return new ModelAndView("calc", modelo);
	}
	
	@RequestMapping(path="/calc", method = RequestMethod.POST)
	public ModelAndView calcular(@ModelAttribute("calculadora") Calculadora calculadora, HttpServletRequest request){
		
		try{
			ModelMap modelo = new ModelMap();
			
			Integer suma = calculadora.sum();
			
			modelo.put("num1", calculadora.getNum1());
			modelo.put("num2", calculadora.getNum2());
			modelo.put("res", suma);			
			
			return new ModelAndView("/result", modelo);
			
		} catch(Throwable t) {
			
			return new ModelAndView("/error");
		}
		
		
		
	}
	
	@RequestMapping(path="/result")
	public ModelAndView result(){
		
		return new ModelAndView("result");
	}
	
	@RequestMapping(path="/error")
	public ModelAndView error(){		
		return new ModelAndView("error");
	}

	
}
