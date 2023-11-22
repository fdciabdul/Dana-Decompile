package com.alibaba.griver.api.ui.dialog;

import com.alibaba.ariver.app.api.point.dialog.CreatePromptParam;

/* loaded from: classes2.dex */
public class GriverCreatePromptParam extends CreatePromptParam {

    /* renamed from: a  reason: collision with root package name */
    private String f6274a;

    public GriverCreatePromptParam(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3, str4, str5);
    }

    public void setAlign(String str) {
        this.f6274a = str;
    }

    public String getAlign() {
        return this.f6274a;
    }
}
