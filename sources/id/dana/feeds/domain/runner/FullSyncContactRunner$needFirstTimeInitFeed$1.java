package id.dana.feeds.domain.runner;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.runner.FullSyncContactRunner", f = "FullSyncContactRunner.kt", i = {}, l = {42}, m = "needFirstTimeInitFeed", n = {}, s = {})
/* loaded from: classes2.dex */
public final class FullSyncContactRunner$needFirstTimeInitFeed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullSyncContactRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullSyncContactRunner$needFirstTimeInitFeed$1(FullSyncContactRunner fullSyncContactRunner, Continuation<? super FullSyncContactRunner$needFirstTimeInitFeed$1> continuation) {
        super(continuation);
        this.this$0 = fullSyncContactRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object PlaceComponentResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        PlaceComponentResult = this.this$0.PlaceComponentResult(this);
        return PlaceComponentResult;
    }
}
