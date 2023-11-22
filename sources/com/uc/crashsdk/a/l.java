package com.uc.crashsdk.a;

import com.uc.crashsdk.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class l extends b.a {
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, String str2) {
        super(str);
        this.b = str2;
    }

    @Override // com.uc.crashsdk.b.a
    public final boolean a() {
        return k.c(this.b);
    }
}
