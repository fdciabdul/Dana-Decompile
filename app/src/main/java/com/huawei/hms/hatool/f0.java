package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes8.dex */
public class f0 {
    public long MyBillsEntityDataFactory = 1800000;
    public volatile boolean getAuthRequestContext = false;
    public a PlaceComponentResult = null;

    /* loaded from: classes8.dex */
    public class a {
        public long KClassImpl$Data$declaredNonStaticMembers$2;
        public String PlaceComponentResult;
        public boolean getAuthRequestContext;

        public a(long j) {
            this.PlaceComponentResult = UUID.randomUUID().toString().replace("-", "");
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult);
            sb.append("_");
            sb.append(j);
            this.PlaceComponentResult = sb.toString();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.getAuthRequestContext = true;
            f0.BuiltInFictitiousFunctionClassFactory(f0.this);
        }

        public static boolean getAuthRequestContext(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        public final boolean PlaceComponentResult(long j, long j2) {
            return j2 - j >= f0.this.MyBillsEntityDataFactory;
        }
    }

    public static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(f0 f0Var) {
        f0Var.getAuthRequestContext = false;
        return false;
    }

    public final boolean MyBillsEntityDataFactory() {
        a aVar = this.PlaceComponentResult;
        if (aVar == null) {
            y.moveToNextValue("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return aVar.getAuthRequestContext;
    }
}
