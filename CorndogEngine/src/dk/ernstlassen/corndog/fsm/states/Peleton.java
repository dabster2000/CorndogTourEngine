package dk.ernstlassen.corndog.fsm.states;

import dk.ernstlassen.corndog.model.Biker;


public class Peleton extends State {

	public Peleton(Biker biker) {
		super(biker);
	}

	public void setAttacking(Attacking attacking) {
		this.attacking = attacking;
	}
	
	public void setPacing(Pacing pacing) {
		this.pacing = pacing;
	}
}
