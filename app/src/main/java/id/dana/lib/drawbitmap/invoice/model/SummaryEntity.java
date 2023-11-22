package id.dana.lib.drawbitmap.invoice.model;

/* loaded from: classes2.dex */
public class SummaryEntity {
    private String bizType;
    private String desc;
    private ExtInfo extInfo;
    private String iconUrl;
    private OrderStatus orderStatus;
    private String title;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public ExtInfo getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(ExtInfo extInfo) {
        this.extInfo = extInfo;
    }

    /* loaded from: classes5.dex */
    public static class OrderStatus {
        private String Status;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getStatus() {
            return this.Status;
        }

        public void setStatus(String str) {
            this.Status = str;
        }
    }

    /* loaded from: classes5.dex */
    public static class ExtInfo {
        private String title;
        private String value;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }
}
