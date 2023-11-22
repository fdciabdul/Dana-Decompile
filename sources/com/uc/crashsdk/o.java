package com.uc.crashsdk;

import com.uc.crashsdk.b;
import java.io.File;

/* loaded from: classes8.dex */
final class o extends b.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str) {
        super(str);
    }

    @Override // com.uc.crashsdk.b.a
    public final boolean a() {
        File file = new File(this.f7718a);
        if (file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }
}
