package io.split.android.client.service.sseclient.notifications;

/* loaded from: classes6.dex */
public class IncomingNotification extends IncomingNotificationType {
    protected String channel;
    private String jsonData;
    protected long timestamp;

    public IncomingNotification() {
    }

    public IncomingNotification(NotificationType notificationType, String str, String str2, long j) {
        this.type = notificationType;
        this.channel = str;
        this.jsonData = str2;
        this.timestamp = j;
    }

    @Override // io.split.android.client.service.sseclient.notifications.IncomingNotificationType
    public NotificationType getType() {
        return this.type;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
