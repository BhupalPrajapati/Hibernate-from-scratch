package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// creating question object(OneToOne Mapping and OneToMany )

		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is the Java?");

		// creating Answer Object(OneToOne Mapping and OneToMany )

		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("Java is programming langauge");
		ans.setQuestion(q1);

		// one more answer for the OneToMany relation mapping
		Answer ans1 = new Answer();
		ans1.setAnswerId(344);
		ans1.setAnswer("Java is used for the creating the softwares");
		ans.setQuestion(q1);

		// one more answer for the OneToMany relation mapping
		Answer ans2 = new Answer();
		ans2.setAnswerId(345);
		ans2.setAnswer("Java is most popular and trusted lanauge");
		ans.setQuestion(q1);
		
		// here we are create list of answer(OneToMany relationship)
		
		List<Answer>list = new ArrayList<Answer>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		// here we pass list of answer in the question(OneToMany relationship)
		q1.setAnswers(list);

		
		// save question with answer(OneToOne Relationship)
//		q1.setAnswer(ans);

		// creating question object(OneToOne Mapping)

//		Question q2 = new Question();
//		q2.setQuestionId(242);
//		q2.setQuestion("What is the collection framework?");

		// creating Answer Object(OneToOne Mapping)

//		Answer ans1 = new Answer();
//		ans1.setAnswerId(344);
//		ans1.setAnswer("API to work with the objects");

		// save question with answer(OneToOne Mapping)
//		q2.setAnswer(ans1);

		// creating question object(OneToOne Mapping)
//
//		Question q3 = new Question();
//		q3.setQuestionId(234324);
//		q3.setQuestion("How to work with Neatbeans?");

		// creating Answer Object(OneToOne Mapping)

//		Answer ans2 = new Answer();
//		ans2.setAnswerId(777);
//		ans2.setAnswer("IDE for writing codes");

		// save question with answer(OneToOne Mapping)
//		q3.setAnswer(ans2);

		Session session = factory.openSession();

		// Transaction begins
		Transaction tx = session.beginTransaction();
        // save the question in session(OneToOne and OneToMany relationship)
		session.save(q1);

		// (OneToOne Mapping)
//		session.save(q2);
//		session.save(q3);

//		session.save(ans);

		// (OneToOne Mapping)
//		session.save(ans1);
//		session.save(ans2);

		// Saving the answer in the session(OneToMany Relationship)
		session.save(ans);
		session.save(ans1);
		session.save(ans2);
		
		
		// Fetching the data from the table(OneToMany Relationship)
		Question q = (Question)session.get(Question.class, 1212);  // pritning the question
		System.out.println(q.getQuestion());
		
		// fetching the all the answer from the table and print here(OneToMany Relation mapping)
		for(Answer a:q.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		
		
		// commit the transaction
		tx.commit();

		factory.close();
		session.close();
	}
}
