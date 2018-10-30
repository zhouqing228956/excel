package com.zhou.excel.entity;

/**
 * 实体类
 *
 * @Author:zhou
 * @Create:2018/10/13 13:45
 */
public class Excel{
    private Integer id;
    private String point;
    private String riqi;
    private double attu;

    public double getAttu() {
        return attu;
    }

    public void setAttu(double attu) {
        this.attu = attu;
    }

    @Override
    public String toString() {
        return "Excel{" +
                "id=" + id +
                ", point='" + point + '\'' +
                ", riqi='" + riqi + '\'' +
                ", attu=" + attu +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

}
