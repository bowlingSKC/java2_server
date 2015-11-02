package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;

    public UserGroup() {

    }

    public UserGroup(User user, Group group, Date joined) {
        this.user = user;
        this.group = group;
        this.joined = joined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroup)) return false;

        UserGroup userGroup = (UserGroup) o;

        if (!group.equals(userGroup.group)) return false;
        if (!user.equals(userGroup.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + group.hashCode();
        return result;
    }
}
