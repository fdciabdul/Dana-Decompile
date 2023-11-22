package com.alibaba.griver.base.common.action;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.griver.api.common.GriverExtension;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public interface GriverSplashBackButtonVisibilityExtension extends GriverExtension {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Visibility {
    }

    int getVisibility(AppNode appNode);
}
