package id.dana.savings.activity;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.h5event.CheckoutH5EventContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/di/modules/CheckoutH5EventModule;", BridgeDSL.INVOKE, "()Lid/dana/di/modules/CheckoutH5EventModule;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SavingUpdateActivity$checkoutH5EventModule$2 extends Lambda implements Function0<CheckoutH5EventModule> {
    final /* synthetic */ SavingUpdateActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingUpdateActivity$checkoutH5EventModule$2(SavingUpdateActivity savingUpdateActivity) {
        super(0);
        this.this$0 = savingUpdateActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CheckoutH5EventModule invoke() {
        final SavingUpdateActivity savingUpdateActivity = this.this$0;
        return new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.savings.activity.SavingUpdateActivity$checkoutH5EventModule$2$$ExternalSyntheticLambda0
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                SavingUpdateActivity$checkoutH5EventModule$2.m2882invoke$lambda0(SavingUpdateActivity.this, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2882invoke$lambda0(SavingUpdateActivity savingUpdateActivity, boolean z) {
        Intrinsics.checkNotNullParameter(savingUpdateActivity, "");
        savingUpdateActivity.MyBillsEntityDataFactory = z;
    }
}
