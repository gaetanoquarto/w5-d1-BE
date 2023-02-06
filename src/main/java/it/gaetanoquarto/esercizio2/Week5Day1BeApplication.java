package it.gaetanoquarto.esercizio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.gaetanoquarto.esercizio2.beans.Bevanda;
import it.gaetanoquarto.esercizio2.beans.Franchising;
import it.gaetanoquarto.esercizio2.beans.Pizza;
import it.gaetanoquarto.esercizio2.decorator.AnanasDecorator;
import it.gaetanoquarto.esercizio2.decorator.MozzarellaDecorator;
import it.gaetanoquarto.esercizio2.decorator.PomodoroDecorator;
import it.gaetanoquarto.esercizio2.decorator.ProsciuttoDecorator;
import it.gaetanoquarto.esercizio2.decorator.SalameDecorator;

@SpringBootApplication
public class Week5Day1BeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week5Day1BeApplication.class, args);
		pizzeria();
	

	}
	
	
	public static void pizzeria() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("it.gaetanoquarto.esercizio2");
		ctx.refresh();
		
		
		
		Pizza p1 = (Pizza) new Pizza();
		Pizza pMargherita = new PomodoroDecorator(new MozzarellaDecorator(p1));
		Pizza pProsciutto = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(p1)));
		Pizza pAnanas = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(new AnanasDecorator(p1))));
		Pizza pSalameProsciutto = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(new SalameDecorator(p1))));
		Pizza pSalame = new PomodoroDecorator(new MozzarellaDecorator(new SalameDecorator(p1)));
		
		Bevanda b1 = new Bevanda(1.29, "Limonata(0,33cl)", 128);
		Bevanda b2 = new Bevanda(1.29, "Acqua(0.5l)", 0);
		Bevanda b3 = new Bevanda(7.49, "Vino(0,75l, 13%)", 607);
		
		Franchising f1 = new Franchising("Maglia", 21.99);
		Franchising f2 = new Franchising("Tazza", 4.99);
		
		
		System.out.println("Benvenuti in Godfather's Pizza!");
		System.out.println("-------------------------------");
		System.out.println("---------PIZZE---------");
		System.out.println("Pizza Margherita " +"(" + pMargherita.getNome() + ")" + " | PREZZO: €" + pMargherita.getPrezzo() + " | CALORIE: " + pMargherita.getCalorie());
		System.out.println("Pizza Prosciutto " +"(" + pProsciutto.getNome() + ")" + " | PREZZO: €" + pProsciutto.getPrezzo() + " | CALORIE: " + pProsciutto.getCalorie());
		System.out.println("Pizza Hawaii " +"(" + pAnanas.getNome() + ")" + " | PREZZO: €" + pAnanas.getPrezzo() + " | CALORIE: " + pAnanas.getCalorie());
		System.out.println("Pizza Salame " +"(" + pSalame.getNome() + ")" + " | PREZZO: €" + pSalame.getPrezzo() + " | CALORIE: " + pSalame.getCalorie());
		System.out.println("Pizza Salame e prosciutto " +"(" + pSalameProsciutto.getNome() + ")" + " | PREZZO: €" + pSalameProsciutto.getPrezzo() + " | CALORIE: " + pSalameProsciutto.getCalorie());
		System.out.println("---------INGREDIENTI AGGIUNTIVI---------");
		System.out.println();
		System.out.println("---------BEVANDE---------");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println("---------FRANCHISING---------");
		System.out.println(f1);
		System.out.println(f2);


	}

}

