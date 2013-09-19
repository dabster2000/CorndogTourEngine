package dk.alumananx.corndogtour.engine.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StaticAbility {

	public int level;
	public double speed;
	public double stamina;
	public double aggressive;
	public double technique;
	public double weight;
	public double height;
	
	public StaticAbility(double speed, double stamina, double aggressive,
			double technique, double weight, double height, int level) {
		super();
		this.speed = speed;
		this.stamina = stamina;
		this.aggressive = aggressive;
		this.technique = technique;
		this.weight = weight;
		this.height = height;
		this.level = level;
	}
	
	public double getMaxStamina() {
		return Math.log1p(stamina)*3200+500;
		//return Math.exp(((stamina / 2) + 5) * 0.9) + 100;
	}

	@Override
	public String toString() {
		return "StaticAbility [level=" + level + ", speed=" + speed
				+ ", stamina=" + stamina + ", aggressive=" + aggressive
				+ ", technique=" + technique + ", weight=" + weight
				+ ", height=" + height + "]";
	}
}
