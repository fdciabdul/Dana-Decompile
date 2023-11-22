package kotlinx.coroutines.internal;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huawei.hms.push.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", e.PlaceComponentResult, BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)Ljava/lang/Throwable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExceptionsConstructorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1<Throwable, Throwable> $$block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstructorKt$safeCtor$1(Function1<? super Throwable, ? extends Throwable> function1) {
        super(1);
        this.$$block = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Throwable invoke(Throwable th) {
        Object m3179constructorimpl;
        Function1<Throwable, Throwable> function1 = this.$$block;
        try {
            Result.Companion companion = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(function1.invoke(th));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = null;
        }
        return (Throwable) m3179constructorimpl;
    }
}
