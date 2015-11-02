package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sender", cascade = CascadeType.ALL)
    private Set<Message> outMessages = new HashSet<Message>(0);
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receiver", cascade = CascadeType.ALL)
    private Set<Message> inMessages = new HashSet<Message>(0);
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserGroup> myGroups = new HashSet<UserGroup>(0);
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Group> ownGroup = new HashSet<Group>(0);

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

    public Set<Message> getOutMessages() {
        return outMessages;
    }

    public void setOutMessages(Set<Message> outMessages) {
        this.outMessages = outMessages;
    }

    public Set<Message> getInMessages() {
        return inMessages;
    }

    public void setInMessages(Set<Message> inMessages) {
        this.inMessages = inMessages;
    }

    public Set<UserGroup> getMyGroups() {
        return myGroups;
    }

    public void setMyGroups(Set<UserGroup> myGroups) {
        this.myGroups = myGroups;
    }

    public Set<Group> getOwnGroup() {
        return ownGroup;
    }

    public void setOwnGroup(Set<Group> ownGroup) {
        this.ownGroup = ownGroup;
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
}
