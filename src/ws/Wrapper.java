package ws;

import model.*;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "wrapper")
@XmlSeeAlso({Message.class, User.class, Group.class, Location.class, Message.class, UserGroup.class})
public class Wrapper<T> {

    @XmlElement(name = "wrappitems")
    private List<T> items = null;

    public Wrapper() {
        items = new ArrayList<>();
    }

    public Wrapper(List<T> items) {
        this.items = new ArrayList<>(items);
    }

    @XmlAnyElement(lax = true)
    public List<T> getWItems() {
        return items;
    }

}
