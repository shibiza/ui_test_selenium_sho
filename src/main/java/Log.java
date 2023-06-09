
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.logging.Logger;

public class Log {

    private static Logger loggerInstance;

    private static Logger getLogger() {
        if (Objects.isNull(loggerInstance)) {
            loggerInstance = (Logger) LoggerFactory.getLogger("Test logger");
        }
        return loggerInstance;
    }

    public static void info(String message) {
        getLogger().info(message);
    }
}
