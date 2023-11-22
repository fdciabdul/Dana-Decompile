package kotlin;

import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u008a\u0001\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\b2#\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00000\f2#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a5\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a_\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\bø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aa\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u001c\u0010\u0018\u001aT\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0018\u001a[\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\b2#\u0010\u001f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u001e0\fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0011\u0010\u0018\u001a[\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\b2#\u0010\u001f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u001e0\fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0010\u0010\u0018\u001ae\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b \u0010\u0018\u001aX\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u000b*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\b2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0018\u001a\u001a\u0010#\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\bH\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019"}, d2 = {"", "exception", "", "createFailure", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "R", "Lkotlin/Function0;", "block", "Lkotlin/Result;", "runCatching", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onSuccess", "onFailure", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "transform", "map", "mapCatching", "", "action", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResultKt {
    public static final Object createFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new Result.Failure(th);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    private static final <R> Object runCatching(Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m3179constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m3179constructorimpl(createFailure(th));
        }
    }

    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m3179constructorimpl(function1.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m3179constructorimpl(createFailure(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object obj) {
        throwOnFailure(obj);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        return m3182exceptionOrNullimpl != null ? function1.invoke(m3182exceptionOrNullimpl) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object obj, R r) {
        return Result.m3185isFailureimpl(obj) ? r : obj;
    }

    private static final <R, T> R fold(Object obj, Function1<? super T, ? extends R> function1, Function1<? super Throwable, ? extends R> function12) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        if (m3182exceptionOrNullimpl == null) {
            return function1.invoke(obj);
        }
        return function12.invoke(m3182exceptionOrNullimpl);
    }

    private static final <R, T> Object map(Object obj, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        if (Result.m3186isSuccessimpl(obj)) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m3179constructorimpl(function1.invoke(obj));
        }
        return Result.m3179constructorimpl(obj);
    }

    private static final <R, T> Object mapCatching(Object obj, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        if (Result.m3186isSuccessimpl(obj)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                return Result.m3179constructorimpl(function1.invoke(obj));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m3179constructorimpl(createFailure(th));
            }
        }
        return Result.m3179constructorimpl(obj);
    }

    private static final <R, T extends R> Object recover(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        if (m3182exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m3179constructorimpl(function1.invoke(m3182exceptionOrNullimpl));
        }
        return obj;
    }

    private static final <R, T extends R> Object recoverCatching(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        if (m3182exceptionOrNullimpl != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                return Result.m3179constructorimpl(function1.invoke(m3182exceptionOrNullimpl));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m3179constructorimpl(createFailure(th));
            }
        }
        return obj;
    }

    private static final <T> Object onFailure(Object obj, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        if (m3182exceptionOrNullimpl != null) {
            function1.invoke(m3182exceptionOrNullimpl);
        }
        return obj;
    }

    private static final <T> Object onSuccess(Object obj, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        if (Result.m3186isSuccessimpl(obj)) {
            function1.invoke(obj);
        }
        return obj;
    }
}
