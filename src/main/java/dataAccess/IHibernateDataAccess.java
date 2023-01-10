package dataAccess;

import java.util.Date;
import java.util.List;

import modelo.dominio.Event;
import modelo.dominio.Question;


public interface IHibernateDataAccess {
	
	List<Event> getEvents(Date date);

	List<Date> getEventsMonth(Date date);

	void initializeDB();

	Question createQuestion(Event event, String question, float betMinimum);
	
	Event getEvent(Event e);
	
	boolean existQuestion(Event event, String question);

}
