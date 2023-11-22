package com.alipay.mobile.embedview.mapbiz.data;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Control implements Serializable {
    public boolean clickable = false;
    public String iconPath;

    /* renamed from: id  reason: collision with root package name */
    public int f7174id;
    public Position position;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Control control = (Control) obj;
        if (this.f7174id == control.f7174id && this.clickable == control.clickable) {
            Position position = this.position;
            if (position == null ? control.position == null : position.equals(control.position)) {
                String str = this.iconPath;
                String str2 = control.iconPath;
                return str != null ? str.equals(str2) : str2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.f7174id;
    }
}
