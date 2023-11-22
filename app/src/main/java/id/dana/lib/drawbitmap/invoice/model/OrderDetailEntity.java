package id.dana.lib.drawbitmap.invoice.model;

import java.util.List;

/* loaded from: classes2.dex */
public class OrderDetailEntity {
    private List<Data> data;
    private String number;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setData(List<Data> list) {
        this.data = list;
    }

    /* loaded from: classes5.dex */
    public static class Data {
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
