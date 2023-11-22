package com.uc.crashsdk;

import com.uc.crashsdk.f;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class g extends f.AbstractC0155f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ File f7728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, f.e eVar, File file) {
        super(str, eVar);
        this.f7728a = file;
    }

    @Override // com.uc.crashsdk.f.AbstractC0155f
    public final boolean a() {
        String a2 = com.uc.crashsdk.a.b.a(this.f7728a, 64, true);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    this.c.b = Long.parseLong(matcher.group(2));
                    this.c.c = Integer.parseInt(matcher.group(3));
                    this.c.d = Integer.parseInt(matcher.group(4));
                    this.c.f7727a = parseLong;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
        return true;
    }
}
