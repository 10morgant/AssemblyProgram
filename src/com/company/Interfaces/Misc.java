package com.company.Interfaces;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.security.Key;
import java.util.ArrayList;

public class Misc extends Region {
    ArrayList<StringProperty> lines = new ArrayList<>();
    int lineNumber = 0;

    public Misc(String text) {
        super();
        StringProperty l0 = new SimpleStringProperty(text);
        lines.add(l0);

        Label l = new Label("Test ");
        l.textProperty().bindBidirectional(l0);
        l.getStyleClass().add("codeEditorLabelCss");
        getChildren().add(l);


        // just to find out where to click
        setStyle("-fx-border-color:#2b2b2b;-fx-background-color: #2b2b2b");
        setPrefSize(100, 100);

        EventHandler<MouseEvent> mouseEventEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setFocused(true);
                requestFocus();
                System.out.println("mousey0");
                l.setText(l.getText() + "Mousey0 ");
            }
        };
        setOnActionMouse(mouseEventEventHandler);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                onActionPropertyMouse().get().handle(event);
            }
        });
        this.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onActionPropertyKey().get().handle(event);
            }
        });
        setOnActionKey(new KeyEventHandler());
    }

    // notice we use MouseEvent here only because you call from onMouseEvent, you can substitute any type you need
    private ObjectProperty<EventHandler<MouseEvent>> propertyOnActionMouse = new SimpleObjectProperty<EventHandler<MouseEvent>>();

    public final ObjectProperty<EventHandler<MouseEvent>> onActionPropertyMouse() {
        return propertyOnActionMouse;
    }

    public final void setOnActionMouse(EventHandler<MouseEvent> handler) {
        propertyOnActionMouse.set(handler);
    }

    public final EventHandler<MouseEvent> getOnActionMouse() {
        return propertyOnActionMouse.get();

    }

    private ObjectProperty<EventHandler<KeyEvent>> propertyOnActionKey = new SimpleObjectProperty<EventHandler<KeyEvent>>();

    public final ObjectProperty<EventHandler<KeyEvent>> onActionPropertyKey() {
        return propertyOnActionKey;
    }

    public final void setOnActionKey(EventHandler<KeyEvent> handler) {
        propertyOnActionKey.set(handler);
    }

    public final EventHandler<KeyEvent> getOnActionKey() {
        return propertyOnActionKey.get();

    }

    class KeyEventHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            requestFocus();
            lines.get(lineNumber).setValue(lines.get(lineNumber).getValue() + event.getCharacter());
        }
    }
}