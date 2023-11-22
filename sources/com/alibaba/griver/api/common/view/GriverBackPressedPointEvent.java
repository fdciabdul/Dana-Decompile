package com.alibaba.griver.api.common.view;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverEvent;

/* loaded from: classes6.dex */
public interface GriverBackPressedPointEvent extends GriverEvent {
    void handleBackPressed(Page page);
}
