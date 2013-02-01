package org.miguelff.hubotai.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TranscriptItem {

	private String human;
	private String question;
	private String answer;
	private Time ts;
	
	public TranscriptItem(String human, String question, String answer) {
		this.human = human;
		this.question = question;
		this.answer = answer;
		ts = new Time();
	}
	
	public String getHuman() {
		return human;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public Time getTs() {
		return ts;
	}
	
	@Override
	public String toString() {
		return "[human=" + human + ", question=" + question
				+ ", answer=" + answer + ", ts=" + ts + "]";
	}
}
