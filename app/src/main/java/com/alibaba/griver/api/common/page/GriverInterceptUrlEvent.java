package com.alibaba.griver.api.common.page;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverEvent;

@Deprecated
/* loaded from: classes3.dex */
public interface GriverInterceptUrlEvent extends GriverEvent {
    boolean interceptUrl(Page page, String str);
}
