package id.dana.danah5.imagecapture;

import androidx.view.FlowExtKt;
import androidx.view.Lifecycle;
import id.dana.danah5.imagecapture.viewmodel.ImageCaptureUiState;
import id.dana.danah5.imagecapture.viewmodel.ImageCaptureViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danah5.imagecapture.ImageCaptureActivity$initLifecycle$1", f = "ImageCaptureActivity.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class ImageCaptureActivity$initLifecycle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageCaptureActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCaptureActivity$initLifecycle$1(ImageCaptureActivity imageCaptureActivity, Continuation<? super ImageCaptureActivity$initLifecycle$1> continuation) {
        super(2, continuation);
        this.this$0 = imageCaptureActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageCaptureActivity$initLifecycle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ImageCaptureActivity$initLifecycle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ImageCaptureViewModel vm;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            vm = this.this$0.getVm();
            StateFlow<ImageCaptureUiState> uiState = vm.getUiState();
            Lifecycle lifecycle = this.this$0.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "");
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(uiState, lifecycle));
            final ImageCaptureActivity imageCaptureActivity = this.this$0;
            this.label = 1;
            if (distinctUntilChanged.collect(new FlowCollector() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initLifecycle$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((ImageCaptureUiState) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(ImageCaptureUiState imageCaptureUiState, Continuation<? super Unit> continuation) {
                    if (!(imageCaptureUiState instanceof ImageCaptureUiState.Idle) && (imageCaptureUiState instanceof ImageCaptureUiState.InitPhotoTips)) {
                        ImageCaptureActivity.this.photoTipsModel = ((ImageCaptureUiState.InitPhotoTips) imageCaptureUiState).getPhotoTipsModel();
                        ImageCaptureActivity.this.initButtonCheckTip();
                    }
                    return Unit.INSTANCE;
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
}
