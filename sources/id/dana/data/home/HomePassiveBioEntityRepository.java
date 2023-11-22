package id.dana.data.home;

import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.home.HomePassiveBioRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/home/HomePassiveBioEntityRepository;", "Lid/dana/domain/home/HomePassiveBioRepository;", "Lio/reactivex/Observable;", "", "getLastTrackTimeStamp", "()Lio/reactivex/Observable;", "", "MyBillsEntityDataFactory", "p0", "", "saveLastTrackTimeStamp", "(J)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/home/HomePassiveBioPreference;", "PlaceComponentResult", "Lid/dana/data/home/HomePassiveBioPreference;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/data/home/HomePassiveBioPreference;Lid/dana/data/account/repository/source/AccountEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomePassiveBioEntityRepository implements HomePassiveBioRepository {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final AccountEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HomePassiveBioPreference getAuthRequestContext;

    @Inject
    public HomePassiveBioEntityRepository(HomePassiveBioPreference homePassiveBioPreference, AccountEntityDataFactory accountEntityDataFactory) {
        Intrinsics.checkNotNullParameter(homePassiveBioPreference, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        this.getAuthRequestContext = homePassiveBioPreference;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = accountEntityDataFactory;
    }

    @Override // id.dana.domain.home.HomePassiveBioRepository
    public final Observable<Long> getLastTrackTimeStamp() {
        Observable map = MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.data.home.HomePassiveBioEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomePassiveBioEntityRepository.PlaceComponentResult(HomePassiveBioEntityRepository.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.home.HomePassiveBioRepository
    public final Observable<Unit> saveLastTrackTimeStamp(final long p0) {
        Observable map = MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.data.home.HomePassiveBioEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomePassiveBioEntityRepository.BuiltInFictitiousFunctionClassFactory(HomePassiveBioEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(HomePassiveBioEntityRepository homePassiveBioEntityRepository, long j, String str) {
        Intrinsics.checkNotNullParameter(homePassiveBioEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        HomePassiveBioPreference homePassiveBioPreference = homePassiveBioEntityRepository.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = homePassiveBioPreference.BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("LAST_TIME_TRACKED");
        sb.append(str);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(j));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        return phoneNumber == null ? "" : phoneNumber;
    }

    public static /* synthetic */ Long PlaceComponentResult(HomePassiveBioEntityRepository homePassiveBioEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(homePassiveBioEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        HomePassiveBioPreference homePassiveBioPreference = homePassiveBioEntityRepository.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = homePassiveBioPreference.BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("LAST_TIME_TRACKED");
        sb.append(str);
        Long l = preferenceFacade.getLong(sb.toString());
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    private final Observable<String> MyBillsEntityDataFactory() {
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").getAccount().map(new Function() { // from class: id.dana.data.home.HomePassiveBioEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomePassiveBioEntityRepository.MyBillsEntityDataFactory((AccountEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
