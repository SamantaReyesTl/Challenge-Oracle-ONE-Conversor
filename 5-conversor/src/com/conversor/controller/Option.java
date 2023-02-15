package com.conversor.controller;

import com.conversor.model.Conversor;
import com.conversor.model.ValorMoneda;

public class Option {
	
	public static ValorMoneda sellection(String tipo) {
		
		if (tipo == ValorMoneda.DOLLAR.getTipo()) {
			return ValorMoneda.DOLLAR;
		} else if (tipo == ValorMoneda.EURO.getTipo()) {
			return ValorMoneda.EURO;
		} else if (tipo == ValorMoneda.LIBRAEST.getTipo()) {
			return ValorMoneda.LIBRAEST;
		} else if (tipo == ValorMoneda.WKW.getTipo()) {
			return ValorMoneda.WKW;
		} else if (tipo == ValorMoneda.YEN.getTipo()) {
			return ValorMoneda.YEN;
		} else if (tipo == ValorMoneda.COLOMBIANO.getTipo()) {
			return ValorMoneda.COLOMBIANO;
		}
		
		return null;
	}
	
	public static double conversionA(ValorMoneda valorMoneda, double cantidad) {
		Conversor conversor = new Conversor(cantidad);
		return conversor.convertirA(valorMoneda);
		
	}
	
	public static double conversionTo(ValorMoneda valorMoneda, double cantidad) {
		Conversor conversor = new Conversor(cantidad);
		return conversor.vamoAConvertir(valorMoneda);
		
	}

}
