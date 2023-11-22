package id.dana.richview;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PromptCTAView$onBtnNegativeClickListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<View, Unit> $$value;
    final /* synthetic */ PromptCTAView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PromptCTAView$onBtnNegativeClickListener$3(PromptCTAView promptCTAView, Function1<? super View, Unit> function1) {
        super(0);
        this.this$0 = promptCTAView;
        this.$$value = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) this.this$0._$_findCachedViewById(R.id.btnNegativeDown);
        if (danaButtonGhostView != null) {
            final Function1<View, Unit> function1 = this.$$value;
            danaButtonGhostView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.PromptCTAView$onBtnNegativeClickListener$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromptCTAView$onBtnNegativeClickListener$3.m2818invoke$lambda0(Function1.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2818invoke$lambda0(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullExpressionValue(view, "");
        function1.invoke(view);
    }
}
