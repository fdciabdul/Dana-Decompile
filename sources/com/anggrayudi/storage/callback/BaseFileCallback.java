package com.anggrayudi.storage.callback;

import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\b\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/anggrayudi/storage/callback/BaseFileCallback;", BehaviorLogger.Key.ERROR_CODE, "Report", "Result", "", "Lkotlinx/coroutines/CoroutineScope;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineScope;", "PlaceComponentResult", "p0", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class BaseFileCallback<ErrorCode, Report, Result> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public CoroutineScope PlaceComponentResult;

    public BaseFileCallback(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        this.PlaceComponentResult = coroutineScope;
    }
}
