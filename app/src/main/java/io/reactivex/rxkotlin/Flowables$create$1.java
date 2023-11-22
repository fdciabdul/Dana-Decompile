package io.reactivex.rxkotlin;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006*\u00028\u00008\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "Lio/reactivex/FlowableEmitter;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lio/reactivex/FlowableEmitter;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class Flowables$create$1<T> implements FlowableOnSubscribe<T> {
    final /* synthetic */ Function1 $MyBillsEntityDataFactory;

    @Override // io.reactivex.FlowableOnSubscribe
    public final void BuiltInFictitiousFunctionClassFactory(FlowableEmitter<T> flowableEmitter) {
        Intrinsics.checkParameterIsNotNull(flowableEmitter, "");
        this.$MyBillsEntityDataFactory.invoke(flowableEmitter);
    }
}
