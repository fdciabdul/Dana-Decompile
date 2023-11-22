package io.reactivex.rxkotlin;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [K] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "A", DiskFormatter.B, "Lkotlin/Pair;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/Pair;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final class FlowableKt$toMap$1<T, R, K> implements Function<T, K> {
    public static final FlowableKt$toMap$1 BuiltInFictitiousFunctionClassFactory = new FlowableKt$toMap$1();

    FlowableKt$toMap$1() {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [A, java.lang.Object] */
    @Override // io.reactivex.functions.Function
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final A apply(Pair<? extends A, ? extends B> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "");
        return pair.getFirst();
    }
}
