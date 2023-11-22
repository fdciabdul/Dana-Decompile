package com.huawei.hms.hatool;

import com.huawei.hms.hatool.o0;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes8.dex */
public class i0 implements n0 {
    public byte[] BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public List<q> scheduleImpl;

    public i0(byte[] bArr, String str, String str2, String str3, String str4, List<q> list) {
        this.BuiltInFictitiousFunctionClassFactory = (byte[]) bArr.clone();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = str3;
        this.PlaceComponentResult = str4;
        this.scheduleImpl = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        b0 authRequestContext;
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "send data running");
        authRequestContext = a0.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, d1.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.PlaceComponentResult), "POST");
        int i = authRequestContext.MyBillsEntityDataFactory;
        if (i != 200) {
            try {
                o0.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.execute(new o0.a(new l0(this.scheduleImpl, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.getAuthRequestContext)));
                return;
            } catch (RejectedExecutionException unused) {
                y.PlaceComponentResult("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:");
        sb.append(this.PlaceComponentResult);
        y.getAuthRequestContext("hmsSdk", sb.toString(), this.getAuthRequestContext, this.MyBillsEntityDataFactory, Integer.valueOf(i));
    }
}
