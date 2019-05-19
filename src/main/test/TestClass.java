import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.dao.ActivitiesDao;

import ua.alex.task.model.dao.DaoFactory;
import ua.alex.task.model.entity.HighImportantActivity;
import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.DayTimeLineService;
import ua.alex.task.model.servise.Impl.ActivitiesSorter;
import ua.alex.task.model.servise.Impl.DayTimeLineServiceImpl;
import ua.alex.task.model.servise.Impl.WorkDayOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;
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
    public void testActivitiesSorter() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new HighImportantActivity("Talking",LocalTime.of(13,0), LocalTime.of(2,0),
                LocalTime.of(12,0), 3));
        activities.add(new HighImportantActivity("Job",LocalTime.of(18,0), LocalTime.of(5,0),
                LocalTime.of(12,0), 1));
        activities.add(new HighImportantActivity("Reading",LocalTime.of(15,0), LocalTime.of(1,0),
                LocalTime.of(12,0), 2));
        activities.add(new HighImportantActivity("Cooking",LocalTime.of(12,0), LocalTime.of(2,0),
                LocalTime.of(12,0), 3));
        ActivitiesSorter sorter = new ActivitiesSorter();
        sorter.sortByStartTime(activities);
        for(int i = 0; i < activities.size() - 1; i++) {
            if(!(activities.get(i).getStartTime().isBefore(activities.get(i+1).getStartTime()))){
                Assert.fail();
            }
        }
        sorter.sortByPriority(activities);
        for(int i = 0; i < activities.size() - 1; i++) {
            if(activities.get(i).getPriority() > activities.get(i+1).getPriority()) {
                Assert.fail();
            }
        }
    }

    @Test
    public void testDayTimeLineService() {
        Day day = new WorkDay();
        List<Activity> activities = new ArrayList<>();
        activities.add(new HighImportantActivity("Talking",LocalTime.of(13,0), LocalTime.of(2,0),
                LocalTime.of(12,0), 3));
        activities.add(new HighImportantActivity("Job",LocalTime.of(18,0), LocalTime.of(5,0),
                LocalTime.of(12,0), 1));
        activities.add(new HighImportantActivity("Reading",LocalTime.of(15,0), LocalTime.of(1,0),
                LocalTime.of(12,0), 2));
        activities.add(new HighImportantActivity("Cooking",LocalTime.of(12,0), LocalTime.of(2,0),
                LocalTime.of(12,0), 3));
        DayTimeLineService timeLineService = new DayTimeLineServiceImpl(day);
        List<Activity> test = timeLineService.createDayTimeLine(activities);
        for(int i = 0; i < test.size() - 1; i++) {
            if(!(test.get(i).getStartTime().isBefore(test.get(i+1).getStartTime()))){
                Assert.fail();
            }
        }
    }
}
