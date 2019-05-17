import org.junit.Assert;
import org.junit.Test;
import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.dao.ActivitiesDao;

import ua.alex.task.model.dao.DaoFactory;
import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.WorkDayOrganizer;

import java.time.LocalTime;
import java.util.List;

public class TestClass {
    @Test
    public void testActivitiesDAO() {
        DaoFactory factory = DaoFactory.getInstance();
        ActivitiesDao dao = factory.createActivityDao();
        List<Activity> testList = dao.getAll();
        Assert.assertTrue(testList.size() > 0);
    }

    @Test
    public void testFormDay() {
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        test.formDay();
        int dayDuration = day.getEndOfDay().getHour() - day.getStartOfDay().getHour();
        int durationOfAllDayActivities = day.getActivityList().stream().mapToInt( x -> x.getDuration().getHour()).sum();
        Assert.assertEquals(dayDuration, durationOfAllDayActivities);
    }
}
