package com.svs.nhatro.model;

import com.google.gson.annotations.SerializedName;
import com.svs.nhatro.base.BaseModel;

/**
 * Created by DangQuang on 4/19/18.
 **/

public class HostelModel extends BaseModel {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    // 0 : not available , 1 : available
    @SerializedName("status")
    private Integer status;
    @SerializedName("unit_price")
    private String unitPrice;
    @SerializedName("erea")
    private String area;

    public HostelModel(Integer id, String name, Integer status, String unitPrice, String area) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.unitPrice = unitPrice;
        this.area = area;
    }

    public Integer getId() {
        return id != null ? id : 0;
    }

    public String getName() {
        return name != null ? name : "";
    }

    public Boolean getStatus() {
        return status != 0;
    }

    public String getUnitPrice() {
        return unitPrice != null ? unitPrice : "";
    }

    public String getArea() {
        return area != null ? area : "";
    }
}
