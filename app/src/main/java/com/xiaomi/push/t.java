package com.xiaomi.push;

import com.xiaomi.push.C0221r;

/* loaded from: classes8.dex */
class t implements Runnable {
    final /* synthetic */ C0221r KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ C0221r.b getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(C0221r c0221r, C0221r.b bVar) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = c0221r;
        this.getAuthRequestContext = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext);
    }
}
