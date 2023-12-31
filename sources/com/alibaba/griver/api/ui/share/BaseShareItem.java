package com.alibaba.griver.api.ui.share;

import java.io.Serializable;

/* loaded from: classes6.dex */
public abstract class BaseShareItem implements Serializable {
    public String channelName;
    public int iconDrawable;
    public String iconUrl;

    public abstract void onShare(ShareParam shareParam, ShareResultListener shareResultListener);
}
