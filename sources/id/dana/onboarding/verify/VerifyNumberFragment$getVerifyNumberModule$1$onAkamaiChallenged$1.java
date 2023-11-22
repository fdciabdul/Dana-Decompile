package id.dana.onboarding.verify;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.beehive.lottie.util.MultiThreadUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class VerifyNumberFragment$getVerifyNumberModule$1$onAkamaiChallenged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VerifyNumberFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyNumberFragment$getVerifyNumberModule$1$onAkamaiChallenged$1(VerifyNumberFragment verifyNumberFragment) {
        super(0);
        this.this$0 = verifyNumberFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final VerifyNumberFragment verifyNumberFragment = this.this$0;
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1$onAkamaiChallenged$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerifyNumberFragment$getVerifyNumberModule$1$onAkamaiChallenged$1.m2769invoke$lambda0(VerifyNumberFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2769invoke$lambda0(VerifyNumberFragment verifyNumberFragment) {
        boolean z;
        Intrinsics.checkNotNullParameter(verifyNumberFragment, "");
        z = verifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        VerifyNumberFragment.PlaceComponentResult(verifyNumberFragment, z);
    }
}
