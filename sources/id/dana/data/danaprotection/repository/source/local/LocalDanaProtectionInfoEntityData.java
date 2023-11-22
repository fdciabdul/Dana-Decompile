package id.dana.data.danaprotection.repository.source.local;

import id.dana.data.danaprotection.repository.source.DanaProtectionEntityData;
import id.dana.data.danaprotection.repository.source.network.result.DanaProtectionInfoResult;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import io.reactivex.Observable;
import j$.util.Optional;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\rJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0005\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012"}, d2 = {"Lid/dana/data/danaprotection/repository/source/local/LocalDanaProtectionInfoEntityData;", "Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityData;", "Lio/reactivex/Observable;", "Lj$/util/Optional;", "Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "BuiltInFictitiousFunctionClassFactory", "p0", "", "getAuthRequestContext", "(Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;)Lio/reactivex/Observable;", "(Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;)Lio/reactivex/Observable;", "", "(J)Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;", "Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;", "PlaceComponentResult", "<init>", "(Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;)V"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class LocalDanaProtectionInfoEntityData implements DanaProtectionEntityData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DanaProtectionInfoPreference PlaceComponentResult;

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final /* synthetic */ Observable MyBillsEntityDataFactory(String str) {
        return DanaProtectionEntityData.CC.getAuthRequestContext(str);
    }

    @Inject
    public LocalDanaProtectionInfoEntityData(DanaProtectionInfoPreference danaProtectionInfoPreference) {
        Intrinsics.checkNotNullParameter(danaProtectionInfoPreference, "");
        this.PlaceComponentResult = danaProtectionInfoPreference;
    }

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final Observable<Optional<DanaProtectionInfoResult>> MyBillsEntityDataFactory() {
        Observable<Optional<DanaProtectionInfoResult>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.danaprotection.repository.source.local.LocalDanaProtectionInfoEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalDanaProtectionInfoEntityData.getAuthRequestContext(LocalDanaProtectionInfoEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final Observable<DanaProtectionWidgetConfig> BuiltInFictitiousFunctionClassFactory() {
        Observable<DanaProtectionWidgetConfig> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.danaprotection.repository.source.local.LocalDanaProtectionInfoEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalDanaProtectionInfoEntityData.BuiltInFictitiousFunctionClassFactory(LocalDanaProtectionInfoEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final Observable<Boolean> getAuthRequestContext(DanaProtectionInfoResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final Observable<Boolean> getAuthRequestContext(DanaProtectionWidgetConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.PlaceComponentResult.getAuthRequestContext(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final Observable<Boolean> MyBillsEntityDataFactory(final long p0) {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.danaprotection.repository.source.local.LocalDanaProtectionInfoEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalDanaProtectionInfoEntityData.PlaceComponentResult(LocalDanaProtectionInfoEntityData.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.danaprotection.repository.source.DanaProtectionEntityData
    public final Observable<Long> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable<Long> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.danaprotection.repository.source.local.LocalDanaProtectionInfoEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalDanaProtectionInfoEntityData.KClassImpl$Data$declaredNonStaticMembers$2(LocalDanaProtectionInfoEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(LocalDanaProtectionInfoEntityData localDanaProtectionInfoEntityData, long j) {
        Intrinsics.checkNotNullParameter(localDanaProtectionInfoEntityData, "");
        return Boolean.valueOf(localDanaProtectionInfoEntityData.PlaceComponentResult.PlaceComponentResult(j));
    }

    public static /* synthetic */ Long KClassImpl$Data$declaredNonStaticMembers$2(LocalDanaProtectionInfoEntityData localDanaProtectionInfoEntityData) {
        Intrinsics.checkNotNullParameter(localDanaProtectionInfoEntityData, "");
        Long l = localDanaProtectionInfoEntityData.PlaceComponentResult.MyBillsEntityDataFactory.getLong("DANA_PROTECTION_INFO_LATEST_FETCH_TIME");
        return Long.valueOf(l == null ? -1L : l.longValue());
    }

    public static /* synthetic */ Optional getAuthRequestContext(LocalDanaProtectionInfoEntityData localDanaProtectionInfoEntityData) {
        Intrinsics.checkNotNullParameter(localDanaProtectionInfoEntityData, "");
        DanaProtectionInfoPreference danaProtectionInfoPreference = localDanaProtectionInfoEntityData.PlaceComponentResult;
        return Optional.BuiltInFictitiousFunctionClassFactory((DanaProtectionInfoResult) danaProtectionInfoPreference.getAuthRequestContext.fromJson(danaProtectionInfoPreference.MyBillsEntityDataFactory.getString("DANA_PROTECTION_INFO"), DanaProtectionInfoResult.class));
    }

    public static /* synthetic */ DanaProtectionWidgetConfig BuiltInFictitiousFunctionClassFactory(LocalDanaProtectionInfoEntityData localDanaProtectionInfoEntityData) {
        Intrinsics.checkNotNullParameter(localDanaProtectionInfoEntityData, "");
        return localDanaProtectionInfoEntityData.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
