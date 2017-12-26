package com.example.springvaadin;

import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import weatherapi.Weather;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button.ClickListener;

@SpringUI
@Theme("colored")
public class VaadinUI extends UI{
	
	private static final long serialVersionUID = 5021273462572274733L;
	@Autowired
	private Service service;
	private Weather weather;
	private WeatherComponent component;
	
	@Override
	protected void init(VaadinRequest request) {
		TextField name = new TextField("Şehir girin:");
		Button button = new Button("ARA", VaadinIcons.SEARCH);
		button.addStyleName("primary");
		VerticalLayout layout = new VerticalLayout(name, button);
		layout.addComponent(button);
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);












		button.addClickListener(new ClickListener(){
			private static final long serialVersionUID = -8424487726640573041L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				if(component != null) layout.removeComponent(component.getLayout());
				component = new WeatherComponent(service.getWeather(name.getValue()));
				layout.addComponent(component.getLayout());
			}
		});
	}

}
