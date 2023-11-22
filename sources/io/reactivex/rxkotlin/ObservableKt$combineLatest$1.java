package io.reactivex.rxkotlin;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0005\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002 \u0010\u0004\u001a\u001c\u0012\b\u0012\u0006*\u00020\u00000\u0000*\u000e\u0012\n\b\u0001\u0012\u0006*\u00020\u00000\u00000\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "R", "", "p0", "BuiltInFictitiousFunctionClassFactory", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class ObservableKt$combineLatest$1<T, R> implements Function<Object[], R> {
    final /* synthetic */ Function1 $PlaceComponentResult;

    @Override // io.reactivex.functions.Function
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final R apply(Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "");
        Function1 function1 = this.$PlaceComponentResult;
        List asList = ArraysKt.asList(objArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asList, 10));
        for (T t : asList) {
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            arrayList.add(t);
        }
        return (R) function1.invoke(arrayList);
    }
}
