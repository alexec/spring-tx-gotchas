import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AppTest {

    @Autowired
    private App app;

    @Test
    public void test() throws Exception {
        try {
            app.insertOneRecordAndThenThrowException();
            fail();
        } catch (RuntimeException e) {
            assertEquals("boom!", e.getMessage());
        }

        assertEquals(0, app.countRecords());
    }
}
