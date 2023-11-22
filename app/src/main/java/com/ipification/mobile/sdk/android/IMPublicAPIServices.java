package com.ipification.mobile.sdk.android;

import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import com.ipification.mobile.sdk.im.data.SessionResponse;
import com.ipification.mobile.sdk.im.listener.CompleteSessionCallback;
import com.ipification.mobile.sdk.im.listener.CompleteStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/ipification/mobile/sdk/android/IMPublicAPIServices;", "", "<init>", "()V", "Factory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class IMPublicAPIServices {

    /* renamed from: Factory  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/ipification/mobile/sdk/android/IMPublicAPIServices$Factory;", "", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.ipification.mobile.sdk.android.IMPublicAPIServices$Factory  reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void PlaceComponentResult(CompleteSessionCallback completeSessionCallback, SessionResponse sessionResponse) {
            CellularException cellularException;
            CellularException cellularException2;
            CellularException cellularException3;
            CellularException cellularException4;
            CellularException cellularException5;
            Intrinsics.checkParameterIsNotNull(completeSessionCallback, "");
            if (sessionResponse != null && sessionResponse.getMyBillsEntityDataFactory()) {
                IPConstant.Companion companion = IPConstant.INSTANCE;
                IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
                StringBuilder sb = new StringBuilder();
                sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
                sb.append("completeSession - success: ");
                AuthResponse authResponse = sessionResponse.PlaceComponentResult;
                sb.append((Object) (authResponse != null ? authResponse.getAuthRequestContext() : null));
                sb.append(" \n");
                String obj = sb.toString();
                Intrinsics.checkParameterIsNotNull(obj, "");
                PlaceComponentResult.DatabaseTableConfigUtil = obj;
                if (sessionResponse.PlaceComponentResult != null) {
                    if (sessionResponse.PlaceComponentResult.getAuthRequestContext() == null) {
                        CompleteStatus completeStatus = CompleteStatus.UNKNOWN;
                        sessionResponse.PlaceComponentResult.MyBillsEntityDataFactory();
                        return;
                    }
                    if (sessionResponse.PlaceComponentResult.getAuthRequestContext() == null) {
                        Intrinsics.throwNpe();
                    }
                    if (sessionResponse.PlaceComponentResult.moveToNextValue() == null) {
                        Intrinsics.throwNpe();
                        return;
                    }
                    return;
                }
                return;
            }
            IPConstant.Companion companion2 = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult2 = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PlaceComponentResult2.DatabaseTableConfigUtil);
            sb2.append("completeSession - error: ");
            sb2.append((Object) ((sessionResponse == null || (cellularException5 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException5.BuiltInFictitiousFunctionClassFactory));
            sb2.append('\n');
            String obj2 = sb2.toString();
            Intrinsics.checkParameterIsNotNull(obj2, "");
            PlaceComponentResult2.DatabaseTableConfigUtil = obj2;
            if (Intrinsics.areEqual((sessionResponse == null || (cellularException4 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException4.BuiltInFictitiousFunctionClassFactory, "not_found")) {
                CompleteStatus completeStatus2 = CompleteStatus.NOT_FOUND;
                return;
            }
            if (Intrinsics.areEqual((sessionResponse == null || (cellularException3 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException3.BuiltInFictitiousFunctionClassFactory, "finished")) {
                CompleteStatus completeStatus3 = CompleteStatus.FINISHED;
                return;
            }
            if (sessionResponse != null && (cellularException2 = sessionResponse.getAuthRequestContext) != null) {
                r1 = cellularException2.BuiltInFictitiousFunctionClassFactory;
            }
            if (Intrinsics.areEqual(r1, "pending")) {
                CompleteStatus completeStatus4 = CompleteStatus.PENDING;
                return;
            }
            CompleteStatus completeStatus5 = CompleteStatus.UNKNOWN;
            if (sessionResponse == null || (cellularException = sessionResponse.getAuthRequestContext) == null) {
                return;
            }
            String str = cellularException.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
