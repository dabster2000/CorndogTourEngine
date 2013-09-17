package dk.ernstlassen.corndog.fsm.states;

import dk.ernstlassen.corndog.model.Biker;


public class Attacking extends State {

	public Attacking(Biker biker) {
		super(biker);
	}

	public void setPeleton(Peleton peleton) {
		this.peleton = peleton;
	}

	public void setPacing(Pacing pacing) {
		this.pacing = pacing;
	}
}
