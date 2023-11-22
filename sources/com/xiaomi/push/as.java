package com.xiaomi.push;

import android.util.Pair;
import com.fullstory.instrumentation.InstrumentInjector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: classes8.dex */
class as implements Runnable {
    final /* synthetic */ Throwable BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ String PlaceComponentResult;
    final /* synthetic */ ar getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, String str, Throwable th) {
        this.getAuthRequestContext = arVar;
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        String str2;
        String str3;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        List list5;
        List list6;
        list = ar.getAuthRequestContext;
        simpleDateFormat = ar.KClassImpl$Data$declaredNonStaticMembers$2;
        str = this.getAuthRequestContext.getErrorConfigVersion;
        list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.PlaceComponentResult), this.BuiltInFictitiousFunctionClassFactory));
        list2 = ar.getAuthRequestContext;
        if (list2.size() > 20000) {
            list3 = ar.getAuthRequestContext;
            int size = (list3.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    list5 = ar.getAuthRequestContext;
                    if (list5.size() > 0) {
                        list6 = ar.getAuthRequestContext;
                        list6.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            list4 = ar.getAuthRequestContext;
            simpleDateFormat2 = ar.KClassImpl$Data$declaredNonStaticMembers$2;
            str4 = this.getAuthRequestContext.getErrorConfigVersion;
            StringBuilder sb = new StringBuilder();
            sb.append("flush ");
            sb.append(size);
            sb.append(" lines logs.");
            list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, sb.toString()), null));
        }
        try {
            if (i.MyBillsEntityDataFactory()) {
                ar.MyBillsEntityDataFactory(this.getAuthRequestContext);
                return;
            }
            str3 = this.getAuthRequestContext.getErrorConfigVersion;
            InstrumentInjector.log_w(str3, "SDCard is unavailable.");
        } catch (Exception e) {
            str2 = this.getAuthRequestContext.getErrorConfigVersion;
            InstrumentInjector.log_e(str2, "", e);
        }
    }
}
