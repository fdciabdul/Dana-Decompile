package com.alibaba.griver.api.common.page;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverEvent;

/* loaded from: classes6.dex */
public interface GriverUrlNavigationEvent extends GriverEvent {
    boolean allowLoadUrl(Page page, String str);

    boolean onStartUrlNavigation(Page page, String str);
}
