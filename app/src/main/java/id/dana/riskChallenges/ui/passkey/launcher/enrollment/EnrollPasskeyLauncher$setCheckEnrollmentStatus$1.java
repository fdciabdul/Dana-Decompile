package id.dana.riskChallenges.ui.passkey.launcher.enrollment;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "it", "", BridgeDSL.INVOKE, "(Ljava/util/List;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class EnrollPasskeyLauncher$setCheckEnrollmentStatus$1 extends Lambda implements Function1<List<? extends PasskeyCredential>, Unit> {
    public static final EnrollPasskeyLauncher$setCheckEnrollmentStatus$1 INSTANCE = new EnrollPasskeyLauncher$setCheckEnrollmentStatus$1();

    EnrollPasskeyLauncher$setCheckEnrollmentStatus$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<PasskeyCredential> list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends PasskeyCredential> list) {
        invoke2((List<PasskeyCredential>) list);
        return Unit.INSTANCE;
    }
}
