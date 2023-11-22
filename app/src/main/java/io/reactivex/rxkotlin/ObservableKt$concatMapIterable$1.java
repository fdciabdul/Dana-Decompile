package io.reactivex.rxkotlin;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [U] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "", "p0", "getAuthRequestContext", "(Ljava/lang/Iterable;)Ljava/lang/Iterable;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
final class ObservableKt$concatMapIterable$1<T, R, U> implements Function<T, Iterable<? extends U>> {
    public static final ObservableKt$concatMapIterable$1 getAuthRequestContext = new ObservableKt$concatMapIterable$1();

    ObservableKt$concatMapIterable$1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public final Iterable<T> apply(Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "");
        return iterable;
    }
}
