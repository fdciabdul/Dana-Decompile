package com.google.android.play.core.ktx;

import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt", f = "AppUpdateManagerKtx.kt", i = {}, l = {WheelView.DIVIDER_ALPHA}, m = "requestAppUpdateInfo", n = {}, s = {})
/* loaded from: classes7.dex */
public final class AppUpdateManagerKtxKt$requestAppUpdateInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppUpdateManagerKtxKt$requestAppUpdateInfo$1(Continuation<? super AppUpdateManagerKtxKt$requestAppUpdateInfo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AppUpdateManagerKtxKt.requestAppUpdateInfo(null, this);
    }
}
