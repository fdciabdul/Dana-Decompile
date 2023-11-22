package com.alibaba.ariver.app.api.point.dialog;

import android.content.DialogInterface;
import java.util.Map;

/* loaded from: classes2.dex */
public class CreateDialogParam {

    /* renamed from: a  reason: collision with root package name */
    private String f5968a;
    public AgreementClickListener agreementListener;
    public Map<String, Agreement> agreements;
    private String b;
    private String c;
    public String cancelColor;
    public DialogInterface.OnCancelListener cancelListener;
    public boolean cancelable = false;
    private String d;
    private String e;
    public DialogInterface.OnClickListener negativeListener;
    public String negativeTextColor;
    public DialogInterface.OnClickListener positiveListener;
    public String positiveTextColor;

    /* loaded from: classes6.dex */
    public static class Agreement {
        public boolean hasPermission;
        public String tag;
        public String text;
        public String url;
    }

    /* loaded from: classes6.dex */
    public interface AgreementClickListener {
        void onClick(String str);
    }

    public CreateDialogParam(String str, String str2, String str3, String str4, String str5) {
        this.f5968a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public String getTitle() {
        return this.f5968a;
    }

    public String getMessage() {
        return this.b;
    }

    public String getPositiveString() {
        return this.c;
    }

    public String getNegativeString() {
        return this.d;
    }

    public String getAlign() {
        return this.e;
    }
}
