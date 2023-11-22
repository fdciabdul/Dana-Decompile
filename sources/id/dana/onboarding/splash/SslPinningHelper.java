package id.dana.onboarding.splash;

import dagger.Lazy;
import id.dana.domain.sslpinning.interactor.PinCertificates;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/onboarding/splash/SslPinningHelper;", "", "Ldagger/Lazy;", "Lid/dana/domain/sslpinning/interactor/PinCertificates;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "PlaceComponentResult", "Lid/dana/domain/sslpinning/interactor/SSLPinningHotUpdate;", "p0", "p1", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SslPinningHelper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<PinCertificates> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<SSLPinningHotUpdate> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SslPinningHelper(Lazy<PinCertificates> lazy, Lazy<SSLPinningHotUpdate> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.PlaceComponentResult = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
    }
}
