package com.alibaba.griver.api.ui.optionmenu;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class ToolbarMenu implements Serializable {
    private String icon;
    private String name;
    private String redDot;
    private String tag;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getRedDot() {
        return this.redDot;
    }

    public void setRedDot(String str) {
        this.redDot = str;
    }
}
