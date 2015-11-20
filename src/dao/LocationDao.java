package dao;

import model.Location;

import java.util.List;

public interface LocationDao {

    public void createLocation(Location location) throws Exception;
    public void deleteLocation(Location location) throws Exception;
    public void updateLocation(Location location) throws Exception;

    public List<Location> getAllLocation() throws Exception;

}
