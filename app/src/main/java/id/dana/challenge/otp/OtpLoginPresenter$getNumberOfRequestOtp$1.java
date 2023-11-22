package id.dana.challenge.otp;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "numberOfRequest", "", BridgeDSL.INVOKE, "(I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class OtpLoginPresenter$getNumberOfRequestOtp$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ boolean $$isRequestOtp;
    final /* synthetic */ OtpLoginPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpLoginPresenter$getNumberOfRequestOtp$1(OtpLoginPresenter otpLoginPresenter, boolean z) {
        super(1);
        this.this$0 = otpLoginPresenter;
        this.$$isRequestOtp = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        this.this$0.DatabaseTableConfigUtil = i <= 0 ? 0 : i;
        if (!this.$$isRequestOtp) {
            OtpLoginPresenter.MyBillsEntityDataFactory(this.this$0, i);
            OtpLoginPresenter otpLoginPresenter = this.this$0;
            String str5 = otpLoginPresenter.lookAheadTest;
            str = this.this$0.FragmentBottomSheetPaymentSettingBinding;
            str2 = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda6;
            otpLoginPresenter.PlaceComponentResult(str5, str, str2);
            return;
        }
        OtpLoginPresenter otpLoginPresenter2 = this.this$0;
        String str6 = otpLoginPresenter2.lookAheadTest;
        str3 = this.this$0.FragmentBottomSheetPaymentSettingBinding;
        str4 = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda6;
        otpLoginPresenter2.PlaceComponentResult(str6, str3, str4);
    }
}
