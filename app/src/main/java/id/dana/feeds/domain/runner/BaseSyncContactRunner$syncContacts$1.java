package id.dana.feeds.domain.runner;

import id.dana.feeds.domain.synccontact.model.FeedsContact;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.domain.runner.BaseSyncContactRunner", f = "BaseSyncContactRunner.kt", i = {}, l = {56, 56}, m = "syncContacts", n = {}, s = {})
/* loaded from: classes2.dex */
public final class BaseSyncContactRunner$syncContacts$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseSyncContactRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSyncContactRunner$syncContacts$1(BaseSyncContactRunner baseSyncContactRunner, Continuation<? super BaseSyncContactRunner$syncContacts$1> continuation) {
        super(continuation);
        this.this$0 = baseSyncContactRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object authRequestContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        authRequestContext = this.this$0.getAuthRequestContext((List<FeedsContact>) null, this);
        return authRequestContext;
    }
}
