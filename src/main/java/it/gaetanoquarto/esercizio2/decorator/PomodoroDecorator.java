package it.gaetanoquarto.esercizio2.decorator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.gaetanoquarto.esercizio2.beans.Pizza;
import it.gaetanoquarto.esercizio2.beans.Topping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@Scope("prototype")
public class PomodoroDecorator extends Topping{

	
	public PomodoroDecorator(Pizza pizza) {

		this.pizza = pizza;
		this.nomeTopping = "pomodoro";
		this.calorie = 15;
		this.prezzo = 0.10;

	}

	@Override
	public String getNome() {
		return pizza.getNome() + "pomodoro ";
	}
	
	@Override
	public double getPrezzo() {
		return pizza.getPrezzo() + prezzo;
	}
	
	@Override
	public int getCalorie() {
		return pizza.getCalorie() + calorie;
	}

}
