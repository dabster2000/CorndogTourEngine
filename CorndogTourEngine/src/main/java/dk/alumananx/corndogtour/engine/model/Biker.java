package dk.alumananx.corndogtour.engine.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Biker {

	public Team user;
	
	public StaticAbility sa;
	@XmlTransient
	public DynamicAbility da;
	
	public String name;
	
	public Biker() {
	}
	
	public Biker(String name, double speed, double aggressive, double technique, double weight, double height, int level) {
		sa = new StaticAbility(speed, 10-speed, aggressive, technique, weight, height, level);
		da = new DynamicAbility(sa);
		this.name = name;
		reset();
		//stm = new StateMachine(this);
		//currentState = stm.getInitialState();
	}
	
	public void reset() {
		//da.stamina = Math.exp(sa.stamina * 0.9);
		
		// ln(6000) = 8,699514748210191
		// ln(0) = 2,718281828459045
		da.fatigued = false;
		da.stamina = sa.getMaxStamina();
	}

	@Override
	public String toString() {
		return "Biker [sa=" + sa + ", da=" + da + ", name=" + name + "]";
	}
	
}
