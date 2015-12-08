package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "salt", nullable = false)
    private String salt;
    @Column(name = "birthday", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date bithday;
    @Column(name = "address", nullable = false)
    private String address;
    @Column( name = "IMAGE" )
    @Lob
    private byte[] profileImage;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlTransient
    private List<Event> myEvents = new ArrayList<>(0);

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlTransient
    private List<Message> outMessages = new ArrayList<>(0);

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlTransient
    private List<Message> inMessages = new ArrayList<>(0);

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlTransient
    private List<UserGroup> myGroups = new ArrayList<>(0);

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlTransient
    private List<Group> ownGroup = new ArrayList<>(0);

    public User() {

    }

    public User(String name, String email, String password, String salt, Date bithday, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.bithday = bithday;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getBithday() {
        return bithday;
    }

    public void setBithday(Date bithday) {
        this.bithday = bithday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Message> getOutMessages() {
        return outMessages;
    }

    public void setOutMessages(List<Message> outMessages) {
        this.outMessages = outMessages;
    }

    public List<Message> getInMessages() {
        return inMessages;
    }

    public void setInMessages(List<Message> inMessages) {
        this.inMessages = inMessages;
    }

    public List<UserGroup> getMyGroups() {
        return myGroups;
    }

    public void setMyGroups(List<UserGroup> myGroups) {
        this.myGroups = myGroups;
    }

    public List<Group> getOwnGroup() {
        return ownGroup;
    }

    public void setOwnGroup(List<Group> ownGroup) {
        this.ownGroup = ownGroup;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public List<Event> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(List<Event> myEvents) {
        this.myEvents = myEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name + " [" + email + "]";
    }
}