package com.example.application.views.verwalten;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Verwalten")
@Route(value = "Verwalten", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class VerwaltenView extends Div {

    private TextField firstName = new TextField("Vorname");
    private TextField lastName = new TextField("Nachname");
    private EmailField email = new EmailField("Email adresse");
    private DatePicker dateOfBirth = new DatePicker("Geburtsdatum");
    private PhoneNumberField phone = new PhoneNumberField("Telefonnummer");
    private CityField city = new CityField("Stadt");
    private RoleField role = new RoleField("Rolle");
    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Speichern");

    private Binder<SamplePerson> binder = new Binder<>(SamplePerson.class);

    public VerwaltenView(SamplePersonService personService) {
        addClassName("verwalten-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            personService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
        });
    }

    private void clearForm() {
        binder.setBean(new SamplePerson());
    }

    private Component createTitle() {
        return new H3("Verwalten");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        //Buttons Layout
        formLayout.add(firstName, lastName, dateOfBirth, phone, email, role, city);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    public static class CityField extends CustomField<String> {

        private ComboBox<String> testbox= new ComboBox<>();

        public CityField(String label) {
            setLabel(label);
            testbox.setWidth("120px");
            testbox.setPlaceholder("Stadt");
            testbox.setAllowedCharPattern("[\\+\\d]");
            testbox.setItems("Stadt A", "Stadt B", "Stadt C", "Stadt D", "Stadt E", "Stadt F", "Stadt G", "Stadt H", "Stadt I");
            testbox.addCustomValueSetListener(e -> testbox.setValue(e.getDetail()));
            HorizontalLayout layout = new HorizontalLayout(testbox);
            layout.setFlexGrow(1.0);
            add(layout);
        }
        @Override
        protected String generateModelValue() {
            if (testbox.getValue() != null) {
                String s = testbox.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String cityName) {
            String[] parts = cityName != null ? cityName.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                testbox.clear();
            } else if (parts.length == 2) {
                testbox.setValue(parts[0]);
            } else {
                testbox.clear();
            }
        }

    }

    public static class RoleField extends CustomField<String> {

        private ComboBox<String> rolebox= new ComboBox<>();

        public RoleField(String label) {
            setLabel(label);
            rolebox.setWidth("120px");
            rolebox.setPlaceholder("");
            rolebox.setAllowedCharPattern("[\\+\\d]");
            rolebox.setItems("Schüler", "Lehrer");
            rolebox.addCustomValueSetListener(e -> rolebox.setValue(e.getDetail()));
            HorizontalLayout layout = new HorizontalLayout(rolebox);
            layout.setFlexGrow(1.0);
            add(layout);
        }
        @Override
        protected String generateModelValue() {
            if (rolebox.getValue() != null) {
                String s = rolebox.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String cityName) {
            String[] parts = cityName != null ? cityName.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                rolebox.clear();
            } else if (parts.length == 2) {
                rolebox.setValue(parts[0]);
            } else {
                rolebox.clear();
            }
        }

    }

    private static class PhoneNumberField extends CustomField<String> {

        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            number.setAllowedCharPattern("\\d");
            HorizontalLayout layout = new HorizontalLayout(number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (number.getValue() != null) {
                String s = number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                number.setValue(parts[1]);
            } else {
                number.clear();
            }
        }
    }

}
