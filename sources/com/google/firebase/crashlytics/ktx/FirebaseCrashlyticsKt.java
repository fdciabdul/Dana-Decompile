package com.google.firebase.crashlytics.ktx;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r"}, d2 = {"Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "Lkotlin/Function1;", "Lcom/google/firebase/crashlytics/ktx/KeyValueBuilder;", "", "Lkotlin/ExtensionFunctionType;", IAPSyncCommand.COMMAND_INIT, "setCustomKeys", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;Lkotlin/jvm/functions/Function1;)V", "", "LIBRARY_NAME", "Ljava/lang/String;", "Lcom/google/firebase/ktx/Firebase;", "getCrashlytics", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class FirebaseCrashlyticsKt {
    public static final String LIBRARY_NAME = "fire-cls-ktx";

    @JvmName(name = "getCrashlytics")
    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseCrashlytics, "");
        return firebaseCrashlytics;
    }

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, Function1<? super KeyValueBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "");
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(new KeyValueBuilder(firebaseCrashlytics));
    }
}
