
import com.kuldeep.thoughtworkschallenge.processingEngine.ProcessConfs;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Kuldeep S Chauhan | Date:6 Jul, 2017
 */
public class InputDataTest {

    @Test
    public void testCoreCombinationWithDifferentTimespans() {

        List<String> conferences = new ArrayList();
        Map<String, Integer> unquieConferences = new LinkedHashMap();
        conferences.add("Writing Fast Tests Against Enterprise Rails 60min");
        conferences.add("Overdoing it in Python 45min");
        conferences.add("Lua for the Masses 30min");
        conferences.add("Ruby Errors from Mismatched Gem Versions 45min");
        conferences.add("Common Ruby Errors 45min");
        conferences.add("Rails for Python Developers lightning");
        conferences.add("Communicating Over Distance 60min");
        conferences.add("Accounting-Driven Development 45min");
        conferences.add("Woah 30min");
        conferences.add("Sit Down and Write 30min");
        conferences.add("Pair Programming vs Noise 45min");
        conferences.add("Rails Magic 60min");
        conferences.add("Ruby on Rails: Why We Should Move On 60min");
        conferences.add("Clojure Ate Scala (on my project) 45min");
        conferences.add("Programming in the Boondocks of Seattle 30min");
        conferences.add("Ruby vs. Clojure for Back-End Development 30min");
        conferences.add("Ruby on Rails Legacy App Maintenance 60min");
        conferences.add("A World Without HackerNews 30min");
        conferences.add("User Interface CSS in Rails Apps 30min");

        ProcessConfs.buidConferences(conferences, unquieConferences);

        List<Integer> randomTargets = new ArrayList();
        
        randomTargets.add(340);
        randomTargets.add(285);
        randomTargets.add(524);
        randomTargets.add(385);
        randomTargets.add(275);
        randomTargets.add(760);
        randomTargets.add(523);

        for (Integer target : randomTargets) {
            
            Map<String, Integer> result = ProcessConfs.generateCombinationOfTiming(unquieConferences, target);
            assertNotNull(result);
            assertFalse((result.values().stream().mapToInt(o -> o).sum()) > target);
        }

    }

}
