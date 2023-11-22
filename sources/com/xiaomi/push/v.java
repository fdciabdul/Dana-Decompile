package com.xiaomi.push;

/* loaded from: classes8.dex */
public class v implements x {
    private final String PlaceComponentResult;
    private final String getAuthRequestContext;

    public v(String str, String str2) {
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
    }

    @Override // com.xiaomi.push.x
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    @Override // com.xiaomi.push.x
    public final String PlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
