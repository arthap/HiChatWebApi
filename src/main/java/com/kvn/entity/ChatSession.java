package com.kvn.entity;

/**
 * Created by art on 9/7/16.
 */
import javax.persistence.*;

@Entity
@Table(name="APP_USER_CHAT_SESSION")
public class ChatSession {
    @Id
    @Column(name="CHATSESSION_ID")
    @GeneratedValue
    private int chat_id;
    @Column(name="INITIATOR")
    private String Initiator ;
    @Column(name="PARTNER")
    private  String Partner;
    @Column(name="TOPIC_ID")
    private  int  topic_id;
    @ManyToOne
    private com.kvn.entity.User user;

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getInitiator() {
        return Initiator;
    }

    public void setInitiator(String initiator) {
        Initiator = initiator;
    }

    public String getPartner() {
        return Partner;
    }

    public void setPartner(String partner) {
        Partner = partner;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public com.kvn.entity.User getUser() {
        return user;
    }

    public void setUser(com.kvn.entity.User user) {
        this.user = user;
    }
}
