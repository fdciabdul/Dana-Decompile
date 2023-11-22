package kotlin.coroutines.jvm.internal;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR-\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007@\u0007X\u0087\u000eø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "await", "()V", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class RunSuspend implements Continuation<Unit> {
    private Result<Unit> result;

    @Override // kotlin.coroutines.Continuation
    @JvmName(name = "getContext")
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @JvmName(name = "getResult-xLWZpok")
    /* renamed from: getResult-xLWZpok  reason: not valid java name */
    public final Result<Unit> m4366getResultxLWZpok() {
        return this.result;
    }

    @JvmName(name = "setResult")
    public final void setResult(Result<Unit> result) {
        this.result = result;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object result) {
        synchronized (this) {
            this.result = Result.m3178boximpl(result);
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void await() {
        synchronized (this) {
            while (true) {
                Result<Unit> m4366getResultxLWZpok = m4366getResultxLWZpok();
                if (m4366getResultxLWZpok == null) {
                    wait();
                } else {
                    ResultKt.throwOnFailure(m4366getResultxLWZpok.getValue());
                }
            }
        }
    }
}
