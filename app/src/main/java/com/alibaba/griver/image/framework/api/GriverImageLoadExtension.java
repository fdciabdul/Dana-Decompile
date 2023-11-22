package com.alibaba.griver.image.framework.api;

import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.image.framework.mode.GriverImageLoadRequest;

/* loaded from: classes3.dex */
public interface GriverImageLoadExtension extends GriverExtension {
    void init();

    void loadImage(GriverImageLoadRequest griverImageLoadRequest);
}
