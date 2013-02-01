package org.miguelff.hubotai.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.miguelff.hubotai.models.TranscriptItem;

@Path("/talk")
@Produces(MediaType.APPLICATION_JSON)
public class TalkService {
		
	private final static Bot bender = new Bot("Bender", "chat");
	
	private final LRUCache<String, Chat> chats = new LRUCache<String, Chat>(100);

	@GET
    public TranscriptItem get(@QueryParam("w") String who, @QueryParam("s") String sentence) {
        Chat chat; 
        if ((chat = chats.get(who)) == null) {
        	chat = new Chat(bender,who);
        	chats.put(who, chat);
        }
        return new TranscriptItem(who, sentence, chat.multisentenceRespond(sentence));        
    }
	
}
