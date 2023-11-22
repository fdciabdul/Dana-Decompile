package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.C0221r;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class cy extends C0221r.b {
    final /* synthetic */ Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(Context context) {
        this.getAuthRequestContext = context;
    }

    @Override // com.xiaomi.push.C0221r.b
    public final void PlaceComponentResult() {
        ArrayList arrayList;
        synchronized (cx.KClassImpl$Data$declaredNonStaticMembers$2()) {
            arrayList = new ArrayList(cx.BuiltInFictitiousFunctionClassFactory());
            cx.BuiltInFictitiousFunctionClassFactory().clear();
        }
        cx.MyBillsEntityDataFactory(this.getAuthRequestContext, arrayList);
    }
}
