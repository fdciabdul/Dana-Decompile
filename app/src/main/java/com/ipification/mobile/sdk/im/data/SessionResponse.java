package com.ipification.mobile.sdk.im.data;

import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\f"}, d2 = {"Lcom/ipification/mobile/sdk/im/data/SessionResponse;", "", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "PlaceComponentResult", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "()Z", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "p0", "p1", "p2", "<init>", "(ZLcom/ipification/mobile/sdk/android/response/AuthResponse;Lcom/ipification/mobile/sdk/android/exception/CellularException;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionResponse {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CellularException getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final AuthResponse PlaceComponentResult;

    public SessionResponse(boolean z, AuthResponse authResponse, CellularException cellularException) {
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = authResponse;
        this.getAuthRequestContext = cellularException;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
