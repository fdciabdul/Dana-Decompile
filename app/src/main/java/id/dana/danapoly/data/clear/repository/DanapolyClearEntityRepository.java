package id.dana.danapoly.data.clear.repository;

import id.dana.danapoly.data.config.repository.source.local.DanapolyPreference;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danapoly/data/clear/repository/DanapolyClearEntityRepository;", "Lid/dana/danapoly/domain/clear/DanapolyClearRepository;", "Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "Lid/dana/danapoly/data/config/repository/source/local/DanapolyPreference;", "getAuthRequestContext", "Lid/dana/danapoly/data/config/repository/source/local/DanapolyPreference;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/danapoly/data/config/repository/source/local/DanapolyPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanapolyClearEntityRepository implements DanapolyClearRepository {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DanapolyPreference PlaceComponentResult;

    @Inject
    public DanapolyClearEntityRepository(DanapolyPreference danapolyPreference) {
        Intrinsics.checkNotNullParameter(danapolyPreference, "");
        this.PlaceComponentResult = danapolyPreference;
    }

    @Override // id.dana.danapoly.domain.clear.DanapolyClearRepository
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.clearData("LastBackgroundColor");
        Observable<Unit> just = Observable.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
