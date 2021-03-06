package dk.ernstlassen.corndog.model;

import javax.xml.bind.annotation.XmlRootElement;

public class DynamicAbility {

	private StaticAbility sa;
	public double stamina;
	public double speed;
	public double frustration;
	public boolean fatigued;

	public DynamicAbility(StaticAbility sa) {
		this.sa = sa;
		stamina = sa.stamina;
		speed = 0.0;
		frustration = sa.aggressive * 0.01;
		fatigued = false;
	}
	
	public void recover(double amount) {
		if((stamina+=amount) > sa.getMaxStamina()) stamina = sa.getMaxStamina();
	}

	@Override
	public String toString() {
		return "DynamicAbility [sa=" + sa + ", stamina=" + stamina + ", speed="
				+ speed + ", frustration=" + frustration + ", fatigued="
				+ fatigued + "]";
	}

}
