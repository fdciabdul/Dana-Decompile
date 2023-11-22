package id.dana.kyb.helper.service.strategy;

import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BO\b\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0005"}, d2 = {"Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategyFactory;", "", "Ldagger/Lazy;", "Lid/dana/kyb/helper/service/strategy/KybServiceActionTypeStrategy;", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/kyb/helper/service/strategy/KybServiceAuthActionStrategy;", "getAuthRequestContext", "PlaceComponentResult", "Lid/dana/kyb/helper/service/strategy/KybServiceDeepLinkActionStrategy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/helper/service/strategy/KybServiceJsApiActionStrategy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/helper/service/strategy/KybServiceUrlActionStrategy;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceActionStrategyFactory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<KybServiceJsApiActionStrategy> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Lazy<KybServiceUrlActionStrategy> getAuthRequestContext;
    public final Lazy<KybServiceActionTypeStrategy> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy<KybServiceDeepLinkActionStrategy> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy<KybServiceAuthActionStrategy> PlaceComponentResult;

    @Inject
    public KybServiceActionStrategyFactory(Lazy<KybServiceUrlActionStrategy> lazy, Lazy<KybServiceAuthActionStrategy> lazy2, Lazy<KybServiceJsApiActionStrategy> lazy3, Lazy<KybServiceDeepLinkActionStrategy> lazy4, Lazy<KybServiceActionTypeStrategy> lazy5) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        this.getAuthRequestContext = lazy;
        this.PlaceComponentResult = lazy2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
        this.MyBillsEntityDataFactory = lazy5;
    }
}
