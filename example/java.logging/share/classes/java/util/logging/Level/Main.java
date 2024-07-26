package share.classes.java.util.logging.Level;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        minimumLevelLoggerCaresAbout();

        inheritLoggerLevel();

    }

    // 2. if Logger's level is null -> inherit from its parent
    private static void inheritLoggerLevel() {
        Logger parentLogger = Logger.getLogger("com");
        Logger childLogger = Logger.getLogger("com.example");
        parentLogger.setLevel(Level.SEVERE);
        // if you try to get Level -> its null
        //System.out.println(childLogger.getLevel().getName());
        // System.out.println(childLogger.getLevel().toString());
        // once you log -> comprehend that the level is inherited
        childLogger.log(Level.SEVERE, "childLogger - SEVERE");
        childLogger.log(Level.INFO, "childLogger - INFO");      // NOT displayed, because the inherit level is SEVERE
    }

    // 1. Level -- represents | Logger -- MINIMUM level / cares about
    private static void minimumLevelLoggerCaresAbout() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.SEVERE);
        rootLogger.log(Level.INFO, "message NOT displayed");        // NOT displayed, because SEVERE's priority < INFO's priority
        rootLogger.log(Level.SEVERE, "message displayed");
    }
}
