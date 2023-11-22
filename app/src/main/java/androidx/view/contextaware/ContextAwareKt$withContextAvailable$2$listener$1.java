package androidx.view.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1;", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes6.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ Function1<Context, R> KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ CancellableContinuation<R> getAuthRequestContext;

    @Override // androidx.view.contextaware.OnContextAvailableListener
    public final void BuiltInFictitiousFunctionClassFactory(Context p0) {
        Object m3179constructorimpl;
        Intrinsics.checkNotNullParameter(p0, "");
        Continuation continuation = this.getAuthRequestContext;
        Function1<Context, R> function1 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            Result.Companion companion = Result.INSTANCE;
            ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = this;
            m3179constructorimpl = Result.m3179constructorimpl(function1.invoke(p0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        continuation.resumeWith(m3179constructorimpl);
    }
}
