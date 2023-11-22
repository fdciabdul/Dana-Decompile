package id.dana.data.holdlogin.v2.interceptor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.holdlogin.v2.entity.HoldLoginResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/HoldLoginResult;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/data/holdlogin/v2/entity/HoldLoginResult;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HoldLoginV2InterceptorImpl$doHoldLogin$1 extends Lambda implements Function1<HoldLoginResult, Unit> {
    public static final HoldLoginV2InterceptorImpl$doHoldLogin$1 INSTANCE = new HoldLoginV2InterceptorImpl$doHoldLogin$1();

    HoldLoginV2InterceptorImpl$doHoldLogin$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HoldLoginResult holdLoginResult) {
        Intrinsics.checkNotNullParameter(holdLoginResult, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(HoldLoginResult holdLoginResult) {
        invoke2(holdLoginResult);
        return Unit.INSTANCE;
    }
}
