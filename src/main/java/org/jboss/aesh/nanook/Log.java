package org.jboss.aesh.nanook;

import java.time.LocalDateTime;

/**
 * @author Yoshimasa Tanabe
 */
public class Log {

    private LocalDateTime time;
    private String level;
    private String message;

    public Log(LocalDateTime time, String level, String message) {
        this.time = time;
        this.level = level;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

}
