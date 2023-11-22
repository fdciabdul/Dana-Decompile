package id.dana.toggle.locationpermission;

import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "", "Lio/reactivex/subjects/BehaviorSubject;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/BehaviorSubject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocationPermissionSubject {
    public BehaviorSubject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public LocationPermissionSubject() {
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
    }
}
