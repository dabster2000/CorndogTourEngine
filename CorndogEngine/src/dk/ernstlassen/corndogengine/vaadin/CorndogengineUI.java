package dk.ernstlassen.corndogengine.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("corndogengine")
public class CorndogengineUI extends UI {

	Navigator navigator;
	protected static final String MAINVIEW = "main";
	
	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("Corndog Tour");
		
		navigator = new Navigator(this, this);
		
		navigator.addView("", new LoginView());
		navigator.addView(MAINVIEW, new MainView());
	}

}