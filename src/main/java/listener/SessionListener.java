package listener;

import counter.OnlineCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;
import service.AuthenticationService;

@Component
public class SessionListener {

    @Autowired
    private OnlineCounter onlineCounter;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @EventListener
    public void handleSessionCreated(HttpSessionCreatedEvent event) {
        onlineCounter.increment();
    }
    
    @EventListener
    public void handleSessionDestroyed(HttpSessionDestroyedEvent event) {
        onlineCounter.decrement();
        authenticationService.removeUserAfterSessionOver(event.getSession());
    }
}
