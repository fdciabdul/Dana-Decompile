package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class p extends o.b {
    final /* synthetic */ o KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ String MyBillsEntityDataFactory;
    final /* synthetic */ boolean PlaceComponentResult = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, o.a aVar, String str) {
        super(aVar);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = oVar;
        this.MyBillsEntityDataFactory = str;
    }

    @Override // com.xiaomi.push.o.b
    final void PlaceComponentResult() {
        SharedPreferences sharedPreferences;
        if (this.PlaceComponentResult) {
            return;
        }
        sharedPreferences = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        sharedPreferences.edit().putLong(this.MyBillsEntityDataFactory, System.currentTimeMillis()).commit();
    }
}
