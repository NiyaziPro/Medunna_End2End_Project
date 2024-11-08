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
    private Integer roomNumber;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "status")
    private boolean status;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    public Room() {
    }

    public Room(int id, Integer roomNumber, String roomType, boolean status, Double price, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
