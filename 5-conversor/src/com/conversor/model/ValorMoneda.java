package com.conversor.model;

public enum ValorMoneda {
	//cambiamos en base a pesos mexicanos.
	
	DOLLAR(0.054, "Dollar", 18.59), WKW(69, "Won sur Coreano", 0.01), 
	LIBRAEST(0.045, "\"Libra Esterlina", 22.36), EURO(0.050, "Euro", 19.86), 
	YEN(7.2180, "Yen", 0.14), COLOMBIANO(259.36, "Peso Colombiano", 0.0039);
	
	public String getTipo() {
		return tipo;
	}

	private double valor;
	private double valorInverso;
	private String tipo;
	
	
	private ValorMoneda(double valor, String tipo, double valorInverso) {
		this.valor = valor;
		this.tipo = tipo;
		this.valorInverso = valorInverso;
	}

	public double getValor() {
		return valor;
	}
	
	public double getValorInverso() {
		return valorInverso;
	}
	

}
