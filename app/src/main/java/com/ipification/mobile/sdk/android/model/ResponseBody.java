package com.ipification.mobile.sdk.android.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/ipification/mobile/sdk/android/model/ResponseBody;", "", "Lokhttp3/Headers;", "PlaceComponentResult", "()Lokhttp3/Headers;", "", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ResponseBody {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Map<String, List<String>> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public ResponseBody(String str, Map<String, List<String>> map) {
        Intrinsics.checkParameterIsNotNull(map, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = map;
    }

    public final Headers PlaceComponentResult() {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : this.getAuthRequestContext.entrySet()) {
            if (entry.getKey() != null) {
                builder.add(entry.getKey(), entry.getValue().get(0));
            }
        }
        Headers build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "");
        return build;
    }
}
