package com.alipay.mobile.embedview.mapbiz.data;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Panel implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    public int f7176id;
    public Layout layout;
    public Position position;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Panel)) {
            return false;
        }
        Panel panel = (Panel) obj;
        if (this.f7176id != panel.f7176id) {
            return false;
        }
        Position position = this.position;
        if (position == null ? panel.position == null : position.equals(panel.position)) {
            Layout layout = this.layout;
            Layout layout2 = panel.layout;
            return layout != null ? layout.equals(layout2) : layout2 == null;
        }
        return false;
    }

    public int hashCode() {
        return this.f7176id;
    }
}
