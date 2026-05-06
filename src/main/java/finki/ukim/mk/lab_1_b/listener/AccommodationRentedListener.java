package finki.ukim.mk.lab_1_b.listener;

import finki.ukim.mk.lab_1_b.events.AccommodationRentedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AccommodationRentedListener {

    private static final Logger log =
            LoggerFactory.getLogger(AccommodationRentedListener.class);

    @EventListener
    public void onRent(AccommodationRentedEvent event) {
        if (event.numRooms() <= 0) {
            log.info("Accommodation {} is FULL (no available rooms)!", event.accommodationId());
            return;
        }
        log.info("Accommodation rented: {}", event.accommodationId());
        log.info("Room left: {}",event.numRooms()-1);
    }

}