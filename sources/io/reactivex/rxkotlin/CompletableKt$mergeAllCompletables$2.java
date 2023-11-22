package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/reactivex/Completable;", "p0", "PlaceComponentResult", "(Lio/reactivex/Completable;)Lio/reactivex/Completable;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final class CompletableKt$mergeAllCompletables$2<T, R> implements Function<Completable, CompletableSource> {
    public static final CompletableKt$mergeAllCompletables$2 MyBillsEntityDataFactory = new CompletableKt$mergeAllCompletables$2();

    CompletableKt$mergeAllCompletables$2() {
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final Completable apply(Completable completable) {
        Intrinsics.checkParameterIsNotNull(completable, "");
        return completable;
    }
}
