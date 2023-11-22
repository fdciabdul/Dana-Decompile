package com.crashlytics.android.answers.shim;

import com.crashlytics.android.answers.CustomEvent;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class KitEvent {
    private final Map<String, Object> attributes = new HashMap();
    private final String eventName;

    public KitEvent(String str) {
        this.eventName = str;
    }

    public KitEvent putAttribute(String str, String str2) {
        this.attributes.put(str, str2);
        return this;
    }

    public KitEvent putAttribute(String str, Number number) {
        this.attributes.put(str, number);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomEvent toCustomEvent() {
        CustomEvent customEvent = new CustomEvent(this.eventName);
        for (String str : this.attributes.keySet()) {
            Object obj = this.attributes.get(str);
            if (obj instanceof String) {
                customEvent.putCustomAttribute(str, (String) obj);
            } else if (obj instanceof Number) {
                customEvent.putCustomAttribute(str, (Number) obj);
            }
        }
        return customEvent;
    }
}
