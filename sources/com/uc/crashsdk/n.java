package com.uc.crashsdk;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes8.dex */
final class n implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return com.uc.crashsdk.a.h.b(str) && str.endsWith(".st");
    }
}
