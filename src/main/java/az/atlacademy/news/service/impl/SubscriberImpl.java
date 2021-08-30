package az.atlacademy.news.service.impl;

import az.atlacademy.news.service.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubscriberImpl implements Subscriber {

    @Override
    public void senEmailToSubscribers() {
        log.info("Mail sent to subscriber!!!");
    }

}
