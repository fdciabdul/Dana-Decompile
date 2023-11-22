package io.reactivex.rxkotlin;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class SubscribersKt$sam$io_reactivex_functions_Consumer$0 implements Consumer {
    private final /* synthetic */ Function1 PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscribersKt$sam$io_reactivex_functions_Consumer$0(Function1 function1) {
        this.PlaceComponentResult = function1;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkExpressionValueIsNotNull(this.PlaceComponentResult.invoke(obj), "");
    }
}
