package com.xiaomi.push;

import com.xiaomi.push.C0221r;

/* loaded from: classes8.dex */
final class cw extends C0221r.b {
    final /* synthetic */ Runnable KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(Runnable runnable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
    }

    @Override // com.xiaomi.push.C0221r.b
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.run();
    }
}
