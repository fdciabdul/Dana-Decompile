package id.dana.cardbinding.viewmodel;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.cardbinding.viewmodel.OtpCardBindingUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class OtpCardBindingViewModel$verifyOtpOneklik$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ OtpCardBindingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OtpCardBindingViewModel$verifyOtpOneklik$2(OtpCardBindingViewModel otpCardBindingViewModel) {
        super(1);
        this.this$0 = otpCardBindingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        MutableStateFlow mutableStateFlow;
        Object value;
        Intrinsics.checkNotNullParameter(th, "");
        mutableStateFlow = this.this$0.PlaceComponentResult;
        do {
            value = mutableStateFlow.getValue();
            OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
        } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.OnVerifyOneklikError.INSTANCE));
    }
}
