package com.uc.crashsdk;

import com.uc.crashsdk.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class l extends b.a {
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, int i, int i2) {
        super(str);
        this.b = i;
        this.c = i2;
    }

    @Override // com.uc.crashsdk.b.a
    public final boolean a() {
        boolean c;
        c = k.c(this.b, this.c);
        return c;
    }
}
