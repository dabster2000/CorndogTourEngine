package dk.ernstlassen.corndog.fsm;

import dk.ernstlassen.corndog.fsm.states.Attacking;
import dk.ernstlassen.corndog.fsm.states.Pacing;
import dk.ernstlassen.corndog.fsm.states.Peleton;
import dk.ernstlassen.corndog.fsm.states.State;
import dk.ernstlassen.corndog.model.Biker;

public class StateMachine {

	private Biker biker;
	private Peleton peleton;
	private Attacking attacking;
	private Pacing pacing;
	
	public StateMachine(Biker biker) {
		this.biker = biker;
		peleton = new Peleton(biker);
		attacking = new Attacking(biker);
		pacing = new Pacing(biker);
		
		peleton.setAttacking(attacking);
		peleton.setPacing(pacing);
		
		attacking.setPeleton(peleton);
		attacking.setPacing(pacing);
		
		pacing.setAttacking(attacking);
		pacing.setPeleton(peleton);
	}
	
	public State getInitialState() {
		return peleton;
	}
	
}
