package com.hw.warehouse.entity;

import lombok.Data;

/**
 * InProduct entity
 * @author hw
 */
@Data
public class InProductEntity {
    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getInNumber() {
        return inNumber;
    }

    public void setInNumber(String inNumber) {
        this.inNumber = inNumber;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    private String inId;
    private String inName;
    private String inNumber;
    private String inDate;
}
