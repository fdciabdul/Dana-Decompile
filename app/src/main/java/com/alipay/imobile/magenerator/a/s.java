package com.alipay.imobile.magenerator.a;

import java.util.Map;

/* loaded from: classes6.dex */
public final class s implements ab {
    public final c a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    @Override // com.alipay.imobile.magenerator.a.ab
    public final c a(String str, a aVar, int i, int i2, Map map) {
        ab wVar;
        int i3 = t.f7021a[aVar.ordinal()];
        if (i3 == 1) {
            wVar = new w();
        } else if (i3 != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("No encoder available for format ");
            sb.append(aVar);
            throw new IllegalArgumentException(sb.toString());
        } else {
            wVar = new h();
        }
        return wVar.a(str, aVar, i, i2, map);
    }
}
