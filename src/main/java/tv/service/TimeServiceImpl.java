package tv.service;

import java.time.LocalDateTime;

public class TimeServiceImpl implements TimeService {
    @Override
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
