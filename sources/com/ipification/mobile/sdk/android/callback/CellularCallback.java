package com.ipification.mobile.sdk.android.callback;

import com.alibaba.ariver.kernel.RVEvents;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.utils.LogLevel;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "T", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "", "error", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "onIMCancel", "onSuccess", "response", "(Ljava/lang/Object;)V", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface CellularCallback<T> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str) {
            Intrinsics.checkParameterIsNotNull(obj, "");
            Intrinsics.checkParameterIsNotNull(str, "");
            LogUtils.Companion companion = LogUtils.getAuthRequestContext;
            LogUtils.Companion.PlaceComponentResult(LogLevel.DEBUG);
        }

        public static final String MyBillsEntityDataFactory(String str) {
            Intrinsics.checkParameterIsNotNull(str, "");
            return StringsKt.replace$default(str, " ", "", false, 4, (Object) null);
        }

        public static final void getAuthRequestContext(Object obj, String str) {
            Intrinsics.checkParameterIsNotNull(obj, "");
            Intrinsics.checkParameterIsNotNull(str, "");
            LogUtils.Companion companion = LogUtils.getAuthRequestContext;
            LogUtils.Companion.PlaceComponentResult(LogLevel.ERROR);
        }
    }

    void BuiltInFictitiousFunctionClassFactory(CellularException cellularException);

    void PlaceComponentResult(T t);
}
