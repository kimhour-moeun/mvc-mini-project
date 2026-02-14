import controller.EmployeeController;
import db.EmployeeDb;
import dto.EmployeeCreateDto;
import dto.EmployeeResponse;
import mapper.EmployeeMapper;
import model.dao.EmployeeDao;
import model.dao.EmployeeDaoImpl;
import model.service.EmployeeService;
import model.service.EmployeeServiceImpl;
import view.EmployeeView;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeeDb db = new EmployeeDb();
        EmployeeDao dao = new EmployeeDaoImpl(db);
        EmployeeMapper mapper = new EmployeeMapper();
        EmployeeService service = new EmployeeServiceImpl(dao,mapper);
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(view,service);

        controller.run();
    }
}