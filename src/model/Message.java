package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({User.class})
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "prev_message")
    @XmlTransient
    private Message prevMessage;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "is_read")
    private boolean read;

    @OneToMany(mappedBy = "prevMessage")
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlTransient
    private List<Message> replyMessages = new ArrayList<Message>(0);

    public Message() {

    }

    public Message(User sender, User receiver, String content, Date date) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.date = date;
        this.read = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Message getPrevMessage() {
        return prevMessage;
    }

    public void setPrevMessage(Message prevMessage) {
        this.prevMessage = prevMessage;
    }

    public List<Message> getReplyMessages() {
        return replyMessages;
    }

    public void setReplyMessages(List<Message> replyMessages) {
        this.replyMessages = replyMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (read != message.read) return false;
        if (!content.equals(message.content)) return false;
        if (!date.equals(message.date)) return false;
        if (!receiver.equals(message.receiver)) return false;
        if (!sender.equals(message.sender)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sender.hashCode();
        result = 31 * result + receiver.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (read ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", prevMessage=" + prevMessage +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", read=" + read +
                ", replyMessages=" + replyMessages +
                '}';
    }
}
