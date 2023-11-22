package id.dana.domain.imagecapture.interactor;

import id.dana.domain.imagecapture.ImageCaptureRepository;
import id.dana.domain.promotion.Space;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/domain/promotion/Space;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.domain.imagecapture.interactor.GetTipUploadPhotoCDP$buildUseCase$1", f = "GetTipUploadPhotoCDP.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class GetTipUploadPhotoCDP$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super Space>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $param;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetTipUploadPhotoCDP this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTipUploadPhotoCDP$buildUseCase$1(GetTipUploadPhotoCDP getTipUploadPhotoCDP, String str, Continuation<? super GetTipUploadPhotoCDP$buildUseCase$1> continuation) {
        super(2, continuation);
        this.this$0 = getTipUploadPhotoCDP;
        this.$param = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetTipUploadPhotoCDP$buildUseCase$1 getTipUploadPhotoCDP$buildUseCase$1 = new GetTipUploadPhotoCDP$buildUseCase$1(this.this$0, this.$param, continuation);
        getTipUploadPhotoCDP$buildUseCase$1.L$0 = obj;
        return getTipUploadPhotoCDP$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Space> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetTipUploadPhotoCDP$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ImageCaptureRepository imageCaptureRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            imageCaptureRepository = this.this$0.imageCaptureRepository;
            Space blockingFirst = imageCaptureRepository.getCdpImageCapture(this.$param).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            this.label = 1;
            if (flowCollector.emit(blockingFirst, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
