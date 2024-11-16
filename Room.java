import java.math.BigDecimal;

abstract class Room {
    static int roomCount;
    int roomID;
    int roomTypeID;
    String status;
    int floorNumber;
    int capacity;
    int adults;
    int children;
    RoomType roomType;

    public Room(int roomID, int roomTypeID, String status, int floorNumber, int capacity, int adults, int children, RoomType roomType) {
        this.roomID = roomID;
        this.roomTypeID = roomTypeID;
        this.status = status;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.adults = adults;
        this.children = children;
        this.roomType = roomType;
    }

    public abstract BigDecimal calculateCost();

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}













class RoomType {
    int roomTypeID;
    String typeName;
    String description;
    BigDecimal basePrice;
    int maxBeds;
    float area;

    public RoomType(int roomTypeID, String typeName, String description, BigDecimal basePrice, int maxBeds, float area) {
        this.roomTypeID = roomTypeID;
        this.typeName = typeName;
        this.description = description;
        this.basePrice = basePrice;
        this.maxBeds = maxBeds;
        this.area = area;
    }

    public int getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public int getMaxBeds() {
        return maxBeds;
    }

    public void setMaxBeds(int maxBeds) {
        this.maxBeds = maxBeds;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
}
