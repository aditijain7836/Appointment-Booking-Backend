package com.example.booking.requests;

public class SlotDto {

    private Integer slotId;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public SlotDto(Integer slotId, Integer userId) {
        this.slotId = slotId;
        this.userId = userId;
    }
}
