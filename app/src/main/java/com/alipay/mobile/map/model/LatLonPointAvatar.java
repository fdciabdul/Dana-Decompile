package com.alipay.mobile.map.model;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class LatLonPointAvatar extends LatLonPointEx {
    private static final long serialVersionUID = -1982947103790025314L;
    private Bitmap avatar;
    private String avatarUrl;

    public void setAvatar(Bitmap bitmap) {
        this.avatar = bitmap;
    }

    public Bitmap getAvatar() {
        return this.avatar;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }
}
