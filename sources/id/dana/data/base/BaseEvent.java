package id.dana.data.base;

/* loaded from: classes8.dex */
public class BaseEvent<I> {
    private String event;
    private I extInfo;
    private I info;

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public I getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(I i) {
        this.extInfo = i;
    }

    public I getInfo() {
        return this.info;
    }

    public void setInfo(I i) {
        this.info = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseEvent{event='");
        sb.append(this.event);
        sb.append('\'');
        sb.append(", info=");
        sb.append(this.info);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append('}');
        return sb.toString();
    }
}
