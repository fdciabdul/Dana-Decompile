package id.dana.core.ui.util;

import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.core.ui.util.FlowViewUtil$onFocusChanges$1", f = "FlowViewUtil.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FlowViewUtil$onFocusChanges$1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditText $this_onFocusChanges;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowViewUtil$onFocusChanges$1(EditText editText, Continuation<? super FlowViewUtil$onFocusChanges$1> continuation) {
        super(2, continuation);
        this.$this_onFocusChanges = editText;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowViewUtil$onFocusChanges$1 flowViewUtil$onFocusChanges$1 = new FlowViewUtil$onFocusChanges$1(this.$this_onFocusChanges, continuation);
        flowViewUtil$onFocusChanges$1.L$0 = obj;
        return flowViewUtil$onFocusChanges$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowViewUtil$onFocusChanges$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
            FlowViewUtil.MyBillsEntityDataFactory();
            this.$this_onFocusChanges.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.core.ui.util.FlowViewUtil$onFocusChanges$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    FlowViewUtil$onFocusChanges$1.m625invokeSuspend$lambda0(ProducerScope.this, view, z);
                }
            });
            final EditText editText = this.$this_onFocusChanges;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: id.dana.core.ui.util.FlowViewUtil$onFocusChanges$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    editText.setOnFocusChangeListener(null);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m625invokeSuspend$lambda0(ProducerScope producerScope, View view, boolean z) {
        producerScope.mo42trySendJP2dKIU(Boolean.valueOf(z));
    }
}
