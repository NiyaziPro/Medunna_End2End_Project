package medunna.hibernate;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable // Bu anotasyon tabloyu salt okunur yapar
@Table(name = "room") // Veritabanındaki tablo adı
public class Room {

    @Id
    @Column(name = "id") // ID sütunu adı (genellikle primary key)
    private int id;

    @Column(name = "room_number") // Örneğin bir isim sütunu varsa
    private String roomNumber;

    @Column(name = "price")
    private String price;

    @Column(name = "description")
    private String description;

    public Room() {
    }

    public Room(int id, String roomNumber, String price, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
