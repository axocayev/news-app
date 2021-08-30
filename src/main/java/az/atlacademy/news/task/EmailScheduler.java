package az.atlacademy.news.task;


import az.atlacademy.news.service.Subscriber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
@Component
public class EmailScheduler {
    private final Subscriber subscriber;



    @Scheduled(fixedDelay = 60000,initialDelay = 10000)
    private  void senEmailToSubscribers(){
      //  log.info("Scheduled date {}",LocalDateTime.now());
      //  subscriber.senEmailToSubscribers() ;
    }

   // @Scheduled(cron = "* * * * * *")
    // 1 second  (0-59)
    // 2 minute ( 0-59)
    // 3 hour (0- 23)
   //  4 day of month (1-31)
    // 5 month (1-12)
    // week (1- 7)
    // *-asterisk  ,  - range ,   / interval,  , list
  //  @Scheduled(cron = "0 0 * * * *")//top of every hour
 //   @Scheduled(cron = "*/10 * * * * *") //every 10 secon  // y%10==0
   // @Scheduled(cron = "0 0 8-10 * * ")  // everey 8, 9, 10 oclock
  //  @Scheduled(cron = "0 0 8,14,0 * * *")   //start 6am , 2pm, 0 am
    //@Scheduled(cron = "0 0/30 7,10 * * *")
    //@Scheduled(cron = "0 0 9-17 * * MON-FRI")
   // @Scheduled(cron = "0 0 0 25 12 ?")

    // @yearly  @annually   0 0 0 1 1 *
    // @monthly  0 0 0 1 * * ,
    // @weekly  0 0 0 * * 0,
    // @daily  @midnight   0 0 0 * * *
    // @hourly 0 0 * * * *

    @Value("${cron.mail-sender.schedule-time}")
    private  String cronTime;

    @Scheduled(cron = "${cron.mail-sender.schedule-time}")   //0 0 0 * * *
    //Period
  //@@SchedulerLock(name = "TaskScheduler_scheduledTask",
  //      lockAtLeastForString = "PT5M", lockAtMostForString = "PT14M")
    //https://www.baeldung.com/shedlock-spring
    private  void sendEmailCron(){
         log.info("Scheduled date {}",LocalDateTime.now());
         log.info("cronTime{}",cronTime);
        subscriber.senEmailToSubscribers() ;
    }


}
  //1234   title content        3
  //1235   title33 content33    3

 //2 user

  //subscriber
     //  2,1234
    //   2 1235