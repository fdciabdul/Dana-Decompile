package id.dana.danah5.tooltip.entity;

import java.util.List;

/* loaded from: classes2.dex */
public class TooltipEntity {
    private String bizType;
    private List<Page> pages;
    private String title;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<Page> getPages() {
        return this.pages;
    }

    public void setPages(List<Page> list) {
        this.pages = list;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    /* loaded from: classes8.dex */
    public class Page {
        public static final String SOURCE_LOCAL = "LOCAL";
        public static final String SOURCE_URL = "URL";
        private String body;
        private String image;
        private String imageSource;
        private String title;

        public Page() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getBody() {
            return this.body;
        }

        public void setBody(String str) {
            this.body = str;
        }

        public String getImage() {
            return this.image;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public String getImageSource() {
            return this.imageSource;
        }

        public void setImageSource(String str) {
            this.imageSource = str;
        }
    }
}
