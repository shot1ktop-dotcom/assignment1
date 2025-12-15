import java.util.ArrayList;

public class Inventory {

    private ArrayList<String> name_company;
    private boolean old_version;
    private boolean new_version;

    public Inventory() {
        name_company = new ArrayList<>();
    }

    public Inventory(boolean old_version, boolean new_version) {
        this(); // важно!
        this.old_version = old_version;
        this.new_version = new_version;
    }

    public void addCompany(String name) {
        name_company.add(name);
    }

    public ArrayList<String> getName_company() {
        return name_company;
    }

    public boolean isOld_version() {
        return old_version;
    }

    public void setOld_version(boolean old_version) {
        this.old_version = old_version;
    }

    public boolean isNew_version() {
        return new_version;
    }

    public void setNew_version(boolean new_version) {
        this.new_version = new_version;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name_company=" + name_company +
                ", old_version=" + old_version +
                ", new_version=" + new_version +
                '}';
    }
}
