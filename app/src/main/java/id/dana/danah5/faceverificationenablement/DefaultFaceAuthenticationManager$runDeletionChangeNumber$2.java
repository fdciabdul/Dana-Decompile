package id.dana.danah5.faceverificationenablement;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class DefaultFaceAuthenticationManager$runDeletionChangeNumber$2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultFaceAuthenticationManager$runDeletionChangeNumber$2(Object obj) {
        super(1, obj, DefaultFaceAuthenticationManager.class, "sendErrorResponseChangeNumber", "sendErrorResponseChangeNumber(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        ((DefaultFaceAuthenticationManager) this.receiver).sendErrorResponseChangeNumber(th);
    }
}
