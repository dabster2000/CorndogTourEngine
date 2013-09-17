package dk.ernstlassen.corndog.fsm.states;

import dk.ernstlassen.corndog.model.Biker;

public class Pacing extends State {

	public Pacing(Biker biker) {
		super(biker);
	}
	
	public void setAttacking(Attacking attacking) {
		this.attacking = attacking;
	}

	public void setPeleton(Peleton peleton) {
		this.peleton = peleton;
	}
}
