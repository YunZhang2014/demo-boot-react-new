package mcdonaldapp;

/**
 * Created by Yun Zhang on 12/1/17.
 * Branches
 */
public class Branch {

    private String id;

    private double latitude;

    private double longitude;

    private String title;

    private String address;

    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (id.compareTo(branch.id) != 0) return false;
        if (Double.compare(branch.latitude, latitude) != 0) return false;
        if (Double.compare(branch.longitude, longitude) != 0) return false;
        if (!title.equals(branch.title)) return false;
        return address.equals(branch.address);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", title=" + title +
                ", address=" + address +
                '}';
    }
}
