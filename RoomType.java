import java.math.BigDecimal;


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
