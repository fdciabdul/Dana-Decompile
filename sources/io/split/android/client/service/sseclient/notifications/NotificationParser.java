package io.split.android.client.service.sseclient.notifications;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;

/* loaded from: classes6.dex */
public class NotificationParser {
    private static final String EVENT_TYPE_ERROR = "error";
    private static final String EVENT_TYPE_FIELD = "event";

    public IncomingNotification parseIncoming(String str) throws JsonSyntaxException {
        try {
            RawNotification rawNotification = (RawNotification) Json.fromJson(str, RawNotification.class);
            try {
                NotificationType type = ((IncomingNotificationType) Json.fromJson(rawNotification.getData(), IncomingNotificationType.class)).getType();
                if (type == null) {
                    type = NotificationType.OCCUPANCY;
                }
                return new IncomingNotification(type, rawNotification.getChannel(), rawNotification.getData(), rawNotification.getTimestamp());
            } catch (JsonSyntaxException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error parsing notification: ");
                sb.append(e.getLocalizedMessage());
                Logger.e(sb.toString());
                return null;
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected error while parsing incomming notification: ");
                sb2.append(e2.getLocalizedMessage());
                Logger.e(sb2.toString());
                return null;
            }
        } catch (JsonSyntaxException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected error while parsing raw notification: ");
            sb3.append(e3.getLocalizedMessage());
            Logger.e(sb3.toString());
            return null;
        }
    }

    public SplitsChangeNotification parseSplitUpdate(String str) throws JsonSyntaxException {
        return (SplitsChangeNotification) Json.fromJson(str, SplitsChangeNotification.class);
    }

    public SplitKillNotification parseSplitKill(String str) throws JsonSyntaxException {
        return (SplitKillNotification) Json.fromJson(str, SplitKillNotification.class);
    }

    public MySegmentChangeNotification parseMySegmentUpdate(String str) throws JsonSyntaxException {
        return (MySegmentChangeNotification) Json.fromJson(str, MySegmentChangeNotification.class);
    }

    public MySegmentChangeV2Notification parseMySegmentUpdateV2(String str) throws JsonSyntaxException {
        return (MySegmentChangeV2Notification) Json.fromJson(str, MySegmentChangeV2Notification.class);
    }

    public OccupancyNotification parseOccupancy(String str) throws JsonSyntaxException {
        return (OccupancyNotification) Json.fromJson(str, OccupancyNotification.class);
    }

    public ControlNotification parseControl(String str) throws JsonSyntaxException {
        return (ControlNotification) Json.fromJson(str, ControlNotification.class);
    }

    public StreamingError parseError(String str) throws JsonSyntaxException {
        return (StreamingError) Json.fromJson(str, StreamingError.class);
    }

    public KeyList parseKeyList(String str) throws JsonSyntaxException {
        return (KeyList) Json.fromJson(str, KeyList.class);
    }

    public boolean isError(Map<String, String> map) {
        return map != null && "error".equals(map.get("event"));
    }

    public String extractUserKeyHashFromChannel(String str) {
        if (str != null) {
            String[] split = str.split("_");
            if (split.length > 2) {
                return split[2];
            }
            return null;
        }
        return null;
    }
}
