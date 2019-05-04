import org.junit.Assert;
import org.junit.Test;
import ua.alex.task.DAO.ActivitiesDAO;
import ua.alex.task.model.Activity;

import java.util.LinkedList;
import java.util.List;

public class TestClass {
    @Test
    public void testActivitiesDAO() {
        ActivitiesDAO dao = new ActivitiesDAO();
        List<Activity> testList = dao.getAllActivities();
        Assert.assertTrue(testList.size() > 0);
    }

    @Test
    public void testFormDay() {

    }
}
