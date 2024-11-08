package medunna.hibernate;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "c_test_item")
public class TestItem {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "default_val_min")
    private String defaultValueMin;

    @Column(name = "default_val_max")
    private String defaultValueMax;

    public TestItem() {
    }

    public TestItem(int id, String name, String description, String price, String defaultValueMin, String defaultValueMax) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.defaultValueMin = defaultValueMin;
        this.defaultValueMax = defaultValueMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDefaultValueMin() {
        return defaultValueMin;
    }

    public void setDefaultValueMin(String defaultValueMin) {
        this.defaultValueMin = defaultValueMin;
    }

    public String getDefaultValueMax() {
        return defaultValueMax;
    }

    public void setDefaultValueMax(String defaultValueMax) {
        this.defaultValueMax = defaultValueMax;
    }

    @Override
    public String toString() {
        return String.format("TestItem:%n" +
                        "Id                : %s%n"+
                        "Name              : %s%n"+
                        "Description       : %s%n"+
                        "Price             : %s%n"+
                        "DefaultValueMin   : %s%n"+
                        "DefaultValueMax   : %s%n",
                        id, name, description, price, defaultValueMin, defaultValueMax);
    }
}
