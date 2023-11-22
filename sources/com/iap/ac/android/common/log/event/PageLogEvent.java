package com.iap.ac.android.common.log.event;

import com.iap.ac.android.common.a.a;
import java.util.Map;

/* loaded from: classes8.dex */
public class PageLogEvent extends BaseLogEvent {
    public PageEvent event;
    public Object page;
    public String pageId;

    /* loaded from: classes8.dex */
    public enum PageEvent {
        START,
        END,
        DESTORY
    }

    public PageLogEvent(String str, PageEvent pageEvent, Object obj, Map<String, String> map) {
        this.pageId = str;
        this.event = pageEvent;
        this.page = obj;
        this.params = map;
    }

    @Override // com.iap.ac.android.common.log.event.BaseLogEvent
    public String toString() {
        StringBuilder a2 = a.a("PageLogEvent{page=");
        a2.append(this.page);
        a2.append(", event=");
        a2.append(this.event);
        a2.append(", pageId='");
        a2.append(this.pageId);
        a2.append('\'');
        a2.append(", params=");
        a2.append(this.params);
        a2.append(", bizCode='");
        a2.append(this.bizCode);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
