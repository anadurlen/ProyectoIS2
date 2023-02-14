package modelo.bean;


	
	

	import java.util.Date;
	import java.util.List;
	import java.util.Vector;

	import javax.faces.application.FacesMessage;
	import javax.faces.context.FacesContext;
	import javax.faces.event.AjaxBehaviorEvent;

	import org.primefaces.event.SelectEvent;

	import businessLogic.BLFacade;
	import businessLogic.BLFacadeImplementation;
	import configuration.UtilDate;
	import dataAccess.HibernateDataAccess;
	import dataAccess.IHibernateDataAccess;
	
	import exceptions.EventFinished;
	import exceptions.QuestionAlreadyExist;
import modelo.dominio.Event;
import modelo.dominio.Question;

	public class QuestionBean3 {
		
		
		BLFacade bl;
		
		private Date date;
		private String question;
		private Integer bet;
		private List<Event> events;
		private Event event;
		
		private List<Question> questions;
		
		private List<Event> allEvents;
		
		public QuestionBean3() {
			 bl = BLFacadeImplementation.getInstance();
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
			
			/*
			 * System.out.println(this.date); this.events = (List<Event>)
			 * bl.getEvents(date);
			 */
			 
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public Integer getBet() {
			return bet;
		}

		public void setBet(Integer bet) {
			this.bet = bet;
		}
		
		
		  public void comprobar() { 
			  if(this.bet <= 0.0) {
		  
		  FacesContext.getCurrentInstance().addMessage(null, new
		  FacesMessage("La apuesta debe ser mayor a 0")); 
		  }else {
		  System.out.println("Evento: " + this.event + " Pregunta: " + this.question +
		  " Minimo apuesta: " + this.bet); 
		  try { Question q = bl.createQuestion(this.event, this.question, this.bet); 
		  if(q == null) {
		  
		  FacesContext.getCurrentInstance().addMessage(null, new
		  FacesMessage("La pregunta ya existe")); }
		  else {
		  FacesContext.getCurrentInstance().addMessage(null, new
		  FacesMessage("La pregunta se ha creado correctamente")); 
		  } } 
		   catch (EventFinished e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (QuestionAlreadyExist e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  }
		 

	    
		  public void onEventSelect (SelectEvent event) {
				this.event = (Event) event.getObject();
				setQuestions(this.event.getQuestions());
			}	
			
		
		
		public void onDateSelect(SelectEvent event) { 
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Fecha escogida: "+event.getObject()));
			this.events=(List<Event>) bl.getEvents((Date)event.getObject());		
			}
		
		
		public List<Event> getEvents() {
			
			
			
			
			
			return events;
		}

		public void setEvents(List<Event> events) {
			this.events = events;
		}
		
		
		
		public void eventsBD(SelectEvent event) {
			
			Date date = (Date) event.getObject();
			this.events= bl.getEvents(date);//eventos base de datos que coincidan en esa fecha
			
				}
			
		
		/*
		 * System.out.println("Selected events" + this.events); Date date = (Date)
		 * event.getObject(); Vector<Event> listaEventos = bl.getEvents(date);
		 * 
		 * FacesContext.getCurrentInstance().addMessage(null, new
		 * FacesMessage(listaEventos.toString())); }
		 */
			
		public void selectEvent(AjaxBehaviorEvent ev) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El evento seleccionado es: " + event.getDescription()));
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
			
		}

		public List<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(List<Question> questions) {
			this.questions = questions;
		}
		
		
		public List<Event> allEvents(List<Event> events) {
			
			List<Event> todosEventos= (List<Event>) bl.allEvents();
			System.out.println("hola estoy funcionando");
			return todosEventos;
			
		}

		public List<Event> getAllEvents() {
			return allEvents;
		}

		public void setAllEvents(List<Event> allEvents) {
			this.allEvents = allEvents;
		}
		
		

		
		
		
		

		

	}



