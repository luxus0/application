package lukasz.exercise_app.Gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lukasz.exercise_app.Dao.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Route
public class ExerciseGui extends VerticalLayout {

    private ExerciseDao dao;
    private TextField textFieldName;
    private TextField textFieldTime;
    private TextField textFieldWage;
    private TextField textFieldLevel;
    private TextField textFieldDestination;
    private TextField textFieldBodyPart;
    private TextField textFieldCategories;
    private TextField textFieldtTypes;
    private TextField textFieldInstructors;
    private Button button;
    private TextArea area;

    @Autowired
    public ExerciseGui(ExerciseDao dao) {
        this.textFieldName = new TextField("Name");
        this.textFieldTime = new TextField("Time");
        this.textFieldWage = new TextField("Wage");
        this.textFieldLevel = new TextField("Level");
        this.textFieldDestination = new TextField("Destination");
        this.textFieldBodyPart = new TextField("Body Part");
        this.textFieldCategories = new TextField("Categories");
        this.textFieldtTypes = new TextField("Types");
        this.textFieldInstructors = new TextField("Instructors");

        this.button = new Button("SHOW ALL");
        this.area = new TextArea();

        button.addClickListener(event->{
            List<Map<String, Object>> showName = dao.showByName(textFieldName.getValue());
            List<Map<String, Object>> showTime = dao.showByTime(Integer.parseInt(textFieldTime.getValue()));
            List<Map<String, Object>> showWage = dao.showByWage(Integer.parseInt(textFieldWage.getValue()));
            List<Map<String, Object>> showLevel = dao.showByLevel(textFieldLevel.getValue());
            List<Map<String, Object>> showDestination = dao.showByDestination(textFieldDestination.getValue());
            List<Map<String, Object>> showCategories = dao.showByCategories(textFieldCategories.getValue());
            List<Map<String, Object>> showTypes = dao.showByTypes(textFieldtTypes.getValue());
            List<Map<String, Object>> showInstructors = dao.showByInstructors(textFieldInstructors.getValue());

            area.setValue(showName.toString());
            area.setValue(showTime.toString());
            area.setValue(showWage.toString());
            area.setValue(showLevel.toString());
            area.setValue(showDestination.toString());
            area.setValue(showCategories.toString());
            area.setValue(showTypes.toString());
            area.setValue(showInstructors.toString());
        });

        this.dao = dao;

        add(textFieldName,textFieldTime,textFieldWage,textFieldLevel,textFieldDestination,
                textFieldBodyPart,textFieldCategories,textFieldtTypes,textFieldInstructors,button,area);
    }




}
