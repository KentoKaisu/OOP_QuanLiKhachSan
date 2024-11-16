import java.math.BigDecimal;


class VIPRoom extends Room {
    boolean hasBeachView;
    boolean hasPrivateBalcony;
    boolean hasJacuzzi;
    boolean hasPremiumTelevision;
    boolean hasCoffeeMachine;
    boolean includesMinibar;
    boolean includes24HourRoomService;
    String bedType;
    boolean hasSoundproofing;

    public VIPRoom(int roomID, int roomTypeID, String status, int floorNumber, int capacity, int adults, int children, RoomType roomType) {
        super(roomID, roomTypeID, status, floorNumber, capacity, adults, children, roomType);
        
        roomType.setBasePrice(new BigDecimal("250000"));
        
        setBasicAmenity();
    }

    @Override
    public BigDecimal calculateCost() {
        BigDecimal basePrice = roomType.getBasePrice();
        BigDecimal adultCost = basePrice.multiply(new BigDecimal(adults));
        BigDecimal childCost = basePrice.multiply(new BigDecimal(0.5)).multiply(new BigDecimal(children));

        BigDecimal additionalCost = BigDecimal.ZERO;

        if (hasBeachView) additionalCost = additionalCost.add(new BigDecimal(50));
        if (hasPrivateBalcony) additionalCost = additionalCost.add(new BigDecimal(30));
        if (hasJacuzzi) additionalCost = additionalCost.add(new BigDecimal(70));
        if (hasPremiumTelevision) additionalCost = additionalCost.add(new BigDecimal(20));
        if (hasCoffeeMachine) additionalCost = additionalCost.add(new BigDecimal(10));
        if (includesMinibar) additionalCost = additionalCost.add(new BigDecimal(40));
        if (includes24HourRoomService) additionalCost = additionalCost.add(new BigDecimal(60));

        return adultCost.add(childCost).add(additionalCost);
    }

    public void setBasicAmenity() {
        this.hasBeachView = true;
        this.hasPrivateBalcony = true;
        this.hasJacuzzi = true;
        this.hasPremiumTelevision = true;
        this.hasCoffeeMachine = true;
        this.includesMinibar = true;
        this.includes24HourRoomService = true;
        this.bedType = "King-size";
        this.hasSoundproofing = true;
    }

    public boolean isHasBeachView() {
        return hasBeachView;
    }

    public void setHasBeachView(boolean hasBeachView) {
        this.hasBeachView = hasBeachView;
    }

    public boolean isHasPrivateBalcony() {
        return hasPrivateBalcony;
    }

    public void setHasPrivateBalcony(boolean hasPrivateBalcony) {
        this.hasPrivateBalcony = hasPrivateBalcony;
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

    public void setHasJacuzzi(boolean hasJacuzzi) {
        this.hasJacuzzi = hasJacuzzi;
    }

    public boolean isHasPremiumTelevision() {
        return hasPremiumTelevision;
    }

    public void setHasPremiumTelevision(boolean hasPremiumTelevision) {
        this.hasPremiumTelevision = hasPremiumTelevision;
    }

    public boolean isHasCoffeeMachine() {
        return hasCoffeeMachine;
    }

    public void setHasCoffeeMachine(boolean hasCoffeeMachine) {
        this.hasCoffeeMachine = hasCoffeeMachine;
    }

    public boolean isIncludesMinibar() {
        return includesMinibar;
    }

    public void setIncludesMinibar(boolean includesMinibar) {
        this.includesMinibar = includesMinibar;
    }

    public boolean isIncludes24HourRoomService() {
        return includes24HourRoomService;
    }

    public void setIncludes24HourRoomService(boolean includes24HourRoomService) {
        this.includes24HourRoomService = includes24HourRoomService;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public boolean isHasSoundproofing() {
        return hasSoundproofing;
    }

    public void setHasSoundproofing(boolean hasSoundproofing) {
        this.hasSoundproofing = hasSoundproofing;
    }
}