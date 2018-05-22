package listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionListener {

    @EventListener
    public void handleSessionCreated(HttpSessionCreatedEvent event) {
    }
    
    @EventListener
    public void handleSessionDestroyed(HttpSessionDestroyedEvent event) {
    }
}
