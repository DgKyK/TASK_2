import org.junit.Assert;
import org.junit.Test;
import ua.alex.task.DAO.ActivitiesDAO;
import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.WorkDay;
import ua.alex.task.servise.WorkDayOrganizer;

import java.time.LocalTime;
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
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        test.formDay();
        int dayDuration = day.getEndOfDay().getHour() - day.getStartOfDay().getHour();
        int durationOfAllDayActivities = day.getActivityList().stream().mapToInt( x -> x.getDuration().getHour()).sum();
        Assert.assertEquals(dayDuration, durationOfAllDayActivities);
    }

    @Test
    public void testIsBeetweenStartEndOfDay() {
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        LocalTime testTime = LocalTime.of(12,0);
        Boolean ethalon = testTime.getHour() >= day.getStartOfDay().getHour() && testTime.isBefore(day.getEndOfDay());
        Boolean compared = test.isBetweenStartEndOfDay(testTime);
        Assert.assertTrue(ethalon && compared);
    }


}
