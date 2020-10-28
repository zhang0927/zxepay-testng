package model;

import lombok.Data;

@Data
public class paymentOrder {

    private String F_OUTER_ORDER_NO;
    private String F_ORDER_STATUS;

    public String getOrderstatus() {
        return F_ORDER_STATUS;
    }

    public void setOrderstatus(String orderstatus) {
        this.F_ORDER_STATUS = orderstatus;
    }

    public String getOrderno() {
        return F_OUTER_ORDER_NO;
    }

    public void setOrderno(String orderno) {
        this.F_OUTER_ORDER_NO = orderno;
    }
}
