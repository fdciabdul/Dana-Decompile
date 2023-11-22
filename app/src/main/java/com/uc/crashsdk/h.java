package com.uc.crashsdk;

import com.uc.crashsdk.f;
import java.io.File;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h extends f.AbstractC0155f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, f.e eVar) {
        super(str, eVar);
    }

    @Override // com.uc.crashsdk.f.AbstractC0155f
    public final boolean a() {
        return com.uc.crashsdk.a.b.a(new File(this.b), String.format(Locale.US, "%d %d %d %d", Long.valueOf(this.c.f7727a), Long.valueOf(this.c.b), Integer.valueOf(this.c.c), Integer.valueOf(this.c.d)).getBytes());
    }
}
