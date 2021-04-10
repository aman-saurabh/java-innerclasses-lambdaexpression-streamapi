package com.tp.sec1.inner_classes;

/*
 * Combination 4 - Class inside an interface.
 * If functionality of a class is closely associated with an interface(i.e class is used inside that particular interface only).
 * Then for such requirements we should go for 'Class inside an interface'.
 * But please note that such classes i.e classes which are declared inside of an interface is always 'public' and 'static' irrespective of whether we declare it or not.
 * It is due to the fact that every member of an interface is always 'public' and 'static'. 
 */

interface EmailService{
	public void sendMail(EmailDetails e);
	
	class EmailDetails{
		String sender;
		String reciever;
		String subject;
		String body;
		public EmailDetails(String sender, String reciever, String subject, String body) {
			this.sender = sender;
			this.reciever = reciever;
			this.subject = subject;
			this.body = body;
		}
	}
}

public class Part19_Combination4 {
	public static void main(String[] args) {
		String sub = "Regarding creation of EmailService object";
		String body = "This is the email body";
		//Implementing EmailService using Anonymous inner class.
		EmailService e = new EmailService() {
			@Override
			public void sendMail(EmailDetails e) {
				String response =  "Email sent to "+e.reciever+" by "+e.sender+" on subject : "+e.subject;
				System.out.println(response);
			}
		};
		EmailService.EmailDetails emailDetails = new EmailService.EmailDetails("aman@gmail.com", "saurabh@gmail.com", sub, body);
		e.sendMail(emailDetails);
	}
}
