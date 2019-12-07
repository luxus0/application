package lukasz.exercise_app.Gui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import lukasz.exercise_app.Entities.Registration;
import lukasz.exercise_app.Repository.RegistrationRepo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Route
public class RegistrationGui  extends FormLayout {

    private RegistrationRepo repo;



    private TextField textFieldId;

    @Size(min=0, max=30)
    private TextField textFieldName;

    @Size(min=2, max=30)
    private TextField textFieldSurname;

    @NotNull
    @Size(min=1, max=30)
    private TextField textFieldAge;

    @Size(min=1, max=30)
    private TextField textFieldPesel;

    @Size(min=1, max=30)
    private TextField textFieldAdress;

    @Size(min=1, max=30)
    private TextField textFieldEmail;

    @Size(min=1, max=30)
    private TextField textFieldMobile;

    @Size(min=1, max=30)
    private TextField birth;


    private Button saveButton;
    private Button nextPage;
    private Button removeText;
    private Button mainPage;


    @NotNull
    private Text protectPersonalData_text;

    private Link regulationLink;
    private Link personalData;
    private Link cookies;


    public RegistrationGui(){

        textFieldId = new TextField("ID");
        textFieldId.setMaxWidth("150px");
        textFieldId.getStyle().set("padding-right","20px");
        textFieldId.getStyle().set("padding-left","20px");


        textFieldName = new TextField("Name");
        textFieldName.setMaxWidth("150px");
        textFieldName.getStyle().set("padding-right","20px");
        textFieldName.getStyle().set("padding-left","20px");


        textFieldSurname = new TextField("Surname");
        textFieldSurname.setMaxWidth("150px");
        textFieldSurname.getStyle().set("padding-right","20px");
        textFieldSurname.getStyle().set("padding-left","20px");

        textFieldAge = new TextField("Age");
        textFieldAge.setMaxWidth("150px");
        textFieldAge.getStyle().set("padding-right","20px");
        textFieldAge.getStyle().set("padding-left","20px");

        textFieldPesel = new TextField("Pesel");
        textFieldPesel.setMaxWidth("150px");
        textFieldPesel.getStyle().set("padding-right","20px");
        textFieldPesel.getStyle().set("padding-left","20px");


        textFieldAdress = new TextField("Adress");
        textFieldAdress.setMaxWidth("150px");
        textFieldAdress.getStyle().set("padding-right","20px");
        textFieldAdress.getStyle().set("padding-left","20px");

        textFieldEmail = new TextField("Email");
        textFieldEmail.setMaxWidth("150px");
        textFieldEmail.getStyle().set("padding-right","20px");
        textFieldEmail.getStyle().set("padding-left","20px");

        textFieldMobile = new TextField("Mobile");
        textFieldMobile.setMaxWidth("150px");
        textFieldMobile.getStyle().set("padding-right","20px");
        textFieldMobile.getStyle().set("padding-left","20px");

        protectPersonalData_text = new Text(getProtectionPersonalData());

        birth = new TextField("Date Birth");
        birth.setMaxWidth("150px");

        regulationLink = new Link("Regulation",new ExternalResource("/regulationGui"));
        regulationLink.setTargetName("Regulation");
        regulationLink.setDescription("aaa");
        regulationLink.setTargetWidth(100);
        regulationLink.setEnabled(true);
        regulationLink.setResponsive(true);

        personalData = new Link("Personal data",new ExternalResource("/personalDataGui"));


        cookies = new Link("Cookies",new ExternalResource("/cookiesGui"));

        Image image = new Image("https://www.smileysapp.com/gif-emoji/waving-hi.gif","");
        image.setMaxHeight("40px");
        image.setMaxWidth("40px");
        saveButton = new Button("ADD",image);
        saveButton.setMinHeight("40px");
        saveButton.setMaxWidth("110px");

        addComponentAtIndex(0,textFieldName);
        addComponentAtIndex(1,textFieldSurname);
        addComponentAtIndex(2,textFieldAge);
        addComponentAtIndex(3,textFieldPesel);
        addComponentAtIndex(4,birth);
        addComponentAtIndex(5,textFieldAdress);
        addComponentAtIndex(6,textFieldEmail);
        addComponentAtIndex(7,textFieldMobile);
        add(saveButton);
        add(protectPersonalData_text);



        /*saveButton.addClickListener( event ->
            {


                Registration registration = new Registration(textFieldName.getValue(), textFieldSurname.getValue(),
                                Integer.parseInt(textFieldAge.getValue()), Long.parseLong(new BigInteger(textFieldPesel.getValue().hashCode())),
                        LocalDateTime.now(), textFieldAdress.getValue(), textFieldEmail.getValue(),
                                Integer.parseInt(textFieldMobile.getValue()));

            repo.save(registration);

            });*/


    }



    public String getProtectionPersonalData()
    {
        String protect = "Press button save you accept " + regulationLink +
                 personalData + "\n" +
                "inform you how we collect\n" +
                " we use and share data users,\n" +
                "and the rules about" + cookies + "inform\n" +
                " how we use from file cookie and\n" +
            "the similar technology. You could receive\n " +
            "SMS Message from us, witch you can resign at any time";

        return protect;

    }

   
    public TextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(TextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public TextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public void setTextFieldSurname(TextField textFieldSurname) {
        this.textFieldSurname = textFieldSurname;
    }

    public TextField getTextFieldAge() {
        return textFieldAge;
    }

    public void setTextFieldAge(TextField textFieldAge) {
        this.textFieldAge = textFieldAge;
    }

    public TextField getTextFieldPesel() {
        return textFieldPesel;
    }

    public void setTextFieldPesel(TextField textFieldPesel) {
        this.textFieldPesel = textFieldPesel;
    }

    public TextField getTextFieldAdress() {
        return textFieldAdress;
    }

    public void setTextFieldAdress(TextField textFieldAdress) {
        this.textFieldAdress = textFieldAdress;
    }

    public TextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public void setTextFieldEmail(TextField textFieldEmail) {
        this.textFieldEmail = textFieldEmail;
    }

    public TextField getTextFieldMobile() {
        return textFieldMobile;
    }

    public void setTextFieldMobile(TextField textFieldMobile) {
        this.textFieldMobile = textFieldMobile;
    }

    public TextField getTextFieldId() {
        return textFieldId;
    }

    public void setTextFieldId(TextField textFieldId) {
        this.textFieldId = textFieldId;
    }

    public TextField getBirth() {
        return birth;
    }

    public void setBirth(TextField birth) {
        this.birth = birth;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public Button getNextPage() {
        return nextPage;
    }

    public void setNextPage(Button nextPage) {
        this.nextPage = nextPage;
    }

    public Button getRemoveText() {
        return removeText;
    }

    public void setRemoveText(Button removeText) {
        this.removeText = removeText;
    }

    public Button getMainPage() {
        return mainPage;
    }

    public void setMainPage(Button mainPage) {
        this.mainPage = mainPage;
    }

    public Text getProtectPersonalData_text() {
        return protectPersonalData_text;
    }

    public void setProtectPersonalData_text(Text protectPersonalData_text) {
        this.protectPersonalData_text = protectPersonalData_text;
    }

    public Link getRegulationLink() {
        return regulationLink;
    }

    public void setRegulationLink(Link regulationLink) {
        this.regulationLink = regulationLink;
    }

    public Link getPersonalData() {
        return personalData;
    }

    public void setPersonalData(Link personalData) {
        this.personalData = personalData;
    }

    public Link getCookies() {
        return cookies;
    }

    public void setCookies(Link cookies) {
        this.cookies = cookies;
    }

}
