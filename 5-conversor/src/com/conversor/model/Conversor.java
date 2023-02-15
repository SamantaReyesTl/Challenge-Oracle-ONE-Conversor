package com.conversor.model;

public class Conversor {
	
	private double cantidad;

	public Conversor(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double convertirA(ValorMoneda tipo) {
		cantidad = (cantidad * tipo.getValor())/1;
		return cantidad;
	}
	
	public double vamoAConvertir(ValorMoneda tipo) {
		cantidad = ( tipo.getValorInverso() * cantidad ) * 1;
		return cantidad;
	}

}
