package com.iap.ac.android.diagnoselog.a;

import com.iap.ac.android.diagnoselog.core.DiagnoseLogContext;
import com.iap.ac.android.diagnoselog.core.UserDiagnosing;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7565a;
    public final /* synthetic */ DiagnoseLogContext b;

    public a(DiagnoseLogContext diagnoseLogContext, String str) {
        this.b = diagnoseLogContext;
        this.f7565a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        DiagnoseLogContext diagnoseLogContext = this.b;
        new UserDiagnosing(diagnoseLogContext.d, diagnoseLogContext.c, null).a(this.f7565a);
    }
}
