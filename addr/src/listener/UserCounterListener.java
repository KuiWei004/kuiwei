package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserCounterListener
 *
 */
public class UserCounterListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	private int counter=0;
    public UserCounterListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	counter++;
    	se.getSession().getServletContext().setAttribute("counter", counter);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	counter--;
    	se.getSession().getServletContext().setAttribute("counter", counter);
    }
	
}
