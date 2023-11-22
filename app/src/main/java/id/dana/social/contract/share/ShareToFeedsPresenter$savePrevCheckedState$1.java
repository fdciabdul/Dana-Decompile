package id.dana.social.contract.share;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.social.contract.share.ShareToFeedsContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Z)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ShareToFeedsPresenter$savePrevCheckedState$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ShareToFeedsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShareToFeedsPresenter$savePrevCheckedState$1(ShareToFeedsPresenter shareToFeedsPresenter) {
        super(1);
        this.this$0 = shareToFeedsPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ShareToFeedsContract.View view;
        ShareToFeedsContract.View view2;
        view = this.this$0.getErrorConfigVersion;
        view.dismissProgress();
        view2 = this.this$0.getErrorConfigVersion;
        view2.MyBillsEntityDataFactory();
    }
}
