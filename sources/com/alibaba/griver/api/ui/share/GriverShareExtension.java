package com.alibaba.griver.api.ui.share;

import com.alibaba.griver.api.common.GriverExtension;
import java.util.List;

/* loaded from: classes2.dex */
public interface GriverShareExtension extends GriverExtension {
    void startShare(ShareParam shareParam, List<BaseShareItem> list, ShareResultListener shareResultListener);
}
