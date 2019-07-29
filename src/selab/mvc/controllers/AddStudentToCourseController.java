package selab.mvc.controllers;

import org.json.JSONObject;
import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.entities.Registration;
import selab.mvc.views.JsonView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AddStudentToCourseController extends Controller {
    DataSet<Registration> registrations;

    public AddStudentToCourseController(DataContext dataContext) {
        super(dataContext);
        registrations = dataContext.getRegistrations();
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        if (!method.equals("POST"))
            throw new IOException("Method not supported");

        JSONObject input = readJson(body);
        String studentNo = input.getString("studentNo");
        String courseNo = input.getString("courseNo");
        String points = input.getString("points");

        Registration r = new Registration();
        r.setCourseNo(courseNo);
        r.setStudentNo(studentNo);
        System.out.println("HERE");
        r.setPoints(Integer.valueOf(points));

        registrations.add(r);
        System.out.println("ADDED");
        Map<String, String> result = new HashMap<>();
        result.put("success", "true");
        return new JsonView(new JSONObject(result));

    }
}
