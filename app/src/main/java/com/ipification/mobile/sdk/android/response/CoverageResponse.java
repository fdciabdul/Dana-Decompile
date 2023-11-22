package com.ipification.mobile.sdk.android.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/ipification/mobile/sdk/android/response/CoverageResponse;", "Lcom/ipification/mobile/sdk/android/response/CellularResponse;", "", "PlaceComponentResult", "()Z", "", "p0", "", "p1", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CoverageResponse extends CellularResponse {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverageResponse(int i, String str) {
        super(i, str);
        Intrinsics.checkParameterIsNotNull(str, "");
    }

    public final boolean PlaceComponentResult() {
        int i = this.MyBillsEntityDataFactory;
        if (200 <= i && i <= 299) {
            try {
                JSONObject jSONObject = new JSONObject(this.getAuthRequestContext);
                if (jSONObject.has("available")) {
                    return jSONObject.getBoolean("available");
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
