package com.xiaomi.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class cc implements Runnable {
    final /* synthetic */ String PlaceComponentResult;
    final /* synthetic */ bz getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bz bzVar, String str) {
        this.getAuthRequestContext = bzVar;
        this.PlaceComponentResult = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ak.MyBillsEntityDataFactory().MyBillsEntityDataFactory(this.PlaceComponentResult, true);
    }
}
