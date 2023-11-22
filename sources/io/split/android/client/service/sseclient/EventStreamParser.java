package io.split.android.client.service.sseclient;

import java.util.Map;

/* loaded from: classes6.dex */
public class EventStreamParser {
    public static final String DATA_FIELD = "data";
    public static final String EVENT_FIELD = "event";
    private static final String FIELD_SEPARATOR = ":";
    public static final String ID_FIELD = "data";
    public static final String KEEP_ALIVE_EVENT = "keepalive";
    private static final String KEEP_ALIVE_TOKEN = ":keepalive";

    public boolean parseLineAndAppendValue(String str, Map<String, String> map) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (KEEP_ALIVE_TOKEN.equals(trim)) {
            map.put("event", KEEP_ALIVE_EVENT);
            return true;
        } else if (trim.isEmpty() && map.size() == 0) {
            return false;
        } else {
            if (trim.isEmpty()) {
                return true;
            }
            int indexOf = trim.indexOf(FIELD_SEPARATOR);
            if (indexOf == 0) {
                return false;
            }
            if (indexOf >= 0) {
                map.put(trim.substring(0, indexOf).trim(), indexOf < trim.length() - 1 ? trim.substring(indexOf + 1, trim.length()).trim() : "");
            } else {
                map.put(trim.trim(), "");
            }
            return false;
        }
    }

    public boolean isKeepAlive(Map<String, String> map) {
        return KEEP_ALIVE_EVENT.equals(map.get("event"));
    }
}
