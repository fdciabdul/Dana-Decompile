package io.reactivex.rxkotlin;

import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class SubscribersKt$sam$io_reactivex_functions_Action$0 implements Action {
    private final /* synthetic */ Function0 PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscribersKt$sam$io_reactivex_functions_Action$0(Function0 function0) {
        this.PlaceComponentResult = function0;
    }

    @Override // io.reactivex.functions.Action
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.PlaceComponentResult.invoke(), "");
    }
}
