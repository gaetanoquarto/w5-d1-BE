package it.gaetanoquarto.esercizio2.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@Scope("prototype")
public abstract class Topping extends Pizza{

	protected Pizza pizza;
	protected String nomeTopping;
	protected double prezzo;
	protected int calorie;

	public Topping() {
		super();
	}

	@Override
	public String toString() {
		return getNome() + "prezzo: " + getPrezzo() + " calorie: " + getCalorie();
	}

	
	
	



}
