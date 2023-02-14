package dataAccess;

import java.util.Date;
import java.util.List;

import exceptions.QuestionAlreadyExist;
import modelo.dominio.Event;
import modelo.dominio.Question;


public interface IHibernateDataAccess {
	
	
void open();
	
	/**
	 * This method closes the database
	 */
	void close();

	
	/**
	 * This method removes all the elements of the database
	 */
	void emptyDatabase();
	
	
	/**
	 * This is the data access method that initializes the database with some events and questions.
	 * This method is invoked by the business logic (constructor of BLFacadeImplementation) when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */
	

	
	List<Event> getEvents(Date date);

	List<Date> getEventsMonth(Date date);

	void initializeDB();

	Question createQuestion(Event event, String question, float betMinimum) throws QuestionAlreadyExist;
	
	Event getEvent(Event e);
	
	boolean existQuestion(Event event, String question);

	List<Event> allEvents();

}
