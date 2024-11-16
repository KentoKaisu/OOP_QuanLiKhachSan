import java.math.BigDecimal;

class StandardRoom extends Room {

    boolean hasAirConditioning;
    boolean hasTelevision;
    boolean hasDesk;
    boolean hasWardrobe;
    boolean hasMinibar;

    public StandardRoom(int roomID, int roomTypeID, String status, int floorNumber, int capacity, int adults, int children, RoomType roomType) {
        super(roomID, roomTypeID, status, floorNumber, capacity, adults, children, roomType);
        setBasicAmenity();
        
        roomType.setBasePrice(new BigDecimal("100000"));
    }

    @Override
    public BigDecimal calculateCost() {
        BigDecimal basePrice = roomType.getBasePrice();
        BigDecimal adultCost = basePrice.multiply(new BigDecimal(adults));
        BigDecimal childCost = basePrice.multiply(new BigDecimal(0.5)).multiply(new BigDecimal(children));
        return adultCost.add(childCost);
    }

    public void setBasicAmenity() {
        this.hasAirConditioning = true;
        this.hasTelevision = true;
        this.hasDesk = true;
        this.hasWardrobe = true;
        this.hasMinibar = false;
    }

    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean isHasTelevision() {
        return hasTelevision;
    }

    public void setHasTelevision(boolean hasTelevision) {
        this.hasTelevision = hasTelevision;
    }

    public boolean isHasDesk() {
        return hasDesk;
    }

    public void setHasDesk(boolean hasDesk) {
        this.hasDesk = hasDesk;
    }

    public boolean isHasWardrobe() {
        return hasWardrobe;
    }

    public void setHasWardrobe(boolean hasWardrobe) {
        this.hasWardrobe = hasWardrobe;
    }

    public boolean isHasMinibar() {
        return hasMinibar;
    }

    public void setHasMinibar(boolean hasMinibar) {
        this.hasMinibar = hasMinibar;
    }
}