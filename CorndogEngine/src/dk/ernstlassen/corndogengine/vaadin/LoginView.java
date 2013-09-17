package dk.ernstlassen.corndogengine.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements View {

	@Override
	public void enter(ViewChangeEvent event) {
		this.setMargin(true);
		this.setSizeFull();
		
		//setContent(this);
		
		Panel panel = new Panel();
		panel.setSizeUndefined();
		this.addComponent(panel);
		this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
		Button button = new Button("Login");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
			}
		});
		
		FormLayout form = new FormLayout();
		form.addComponent(new TextField("username"));
		form.addComponent(new PasswordField("Password"));
		form.addComponent(button);
		form.setMargin(true);
		
		panel.setContent(form);
	}

}
