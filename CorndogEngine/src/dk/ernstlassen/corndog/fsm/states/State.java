package dk.ernstlassen.corndog.fsm.states;

import java.util.ArrayList;

import dk.ernstlassen.corndog.model.Biker;

public abstract class State {

	ArrayList<State> states;
	Biker biker;
	
	protected Attacking attacking;
	protected Peleton peleton;
	protected Pacing pacing;
	
	public State(Biker biker) {
		this.states = new ArrayList<>();
	}
	
	public ArrayList<State> getStates() {
		return states;
	}
}
