package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVStartParams;

/* loaded from: classes3.dex */
public class PageSource {
    public String sourceDesc = "";
    public String sourcePageAppLogToken = "";
    public SourceType sourceType = SourceType.UNKNOWN;

    /* loaded from: classes3.dex */
    public enum SourceType {
        START_APP("startApp"),
        PUSH_WINDOW(RVStartParams.FROM_TYPE_PUSH_WINDOW),
        SWITCH_TAB("switchTab"),
        TAB_CLICK(RVEvents.TAB_CLICK),
        TAB_INIT("tabInit"),
        TAB_PUSH("tabPush"),
        EMBED_VIEW("embedView"),
        HREF_CHANGE("hrefChange"),
        UNKNOWN("unknown");

        private String raw;

        SourceType(String str) {
            this.raw = str;
        }

        public final String getRaw() {
            return this.raw;
        }
    }
}
