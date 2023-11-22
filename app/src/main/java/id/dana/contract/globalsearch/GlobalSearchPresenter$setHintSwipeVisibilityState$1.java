package id.dana.contract.globalsearch;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Z)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class GlobalSearchPresenter$setHintSwipeVisibilityState$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final GlobalSearchPresenter$setHintSwipeVisibilityState$1 INSTANCE = new GlobalSearchPresenter$setHintSwipeVisibilityState$1();

    GlobalSearchPresenter$setHintSwipeVisibilityState$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setHintSwipeVisibilityState ");
        sb.append(z);
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.GLOBAL_SEARCH_TAG, sb.toString());
    }
}
