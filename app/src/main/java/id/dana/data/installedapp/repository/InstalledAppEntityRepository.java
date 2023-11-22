package id.dana.data.installedapp.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.domain.installedapp.InstalledAppRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0013\u0010\r\u001a\u00020\nX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/installedapp/repository/InstalledAppEntityRepository;", "Lid/dana/domain/installedapp/InstalledAppRepository;", "Lio/reactivex/Observable;", "", "isNeedToSendInstalledApp", "()Lio/reactivex/Observable;", "saveNeedToSendInstalledApp", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/installedapp/repository/InstalledAppEntityData;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "PlaceComponentResult", "Lid/dana/data/installedapp/repository/InstalledAppEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/installedapp/repository/InstalledAppEntityDataFactory;", "p0", "p1", "<init>", "(Lid/dana/data/installedapp/repository/InstalledAppEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InstalledAppEntityRepository implements InstalledAppRepository {
    private final InstalledAppEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    private final AccountEntityDataFactory getAuthRequestContext;

    @Inject
    public InstalledAppEntityRepository(InstalledAppEntityDataFactory installedAppEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory) {
        Intrinsics.checkNotNullParameter(installedAppEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = installedAppEntityDataFactory;
        this.getAuthRequestContext = accountEntityDataFactory;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<InstalledAppEntityData>() { // from class: id.dana.data.installedapp.repository.InstalledAppEntityRepository$createLocalInstalledAppEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InstalledAppEntityData invoke() {
                InstalledAppEntityDataFactory installedAppEntityDataFactory2;
                installedAppEntityDataFactory2 = InstalledAppEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return installedAppEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(Boolean.TRUE);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(Boolean.FALSE);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(InstalledAppEntityRepository installedAppEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(installedAppEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return ((InstalledAppEntityData) installedAppEntityRepository.PlaceComponentResult.getValue()).getAuthRequestContext(str);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(InstalledAppEntityRepository installedAppEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(installedAppEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return ((InstalledAppEntityData) installedAppEntityRepository.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(str);
    }

    @Override // id.dana.domain.installedapp.InstalledAppRepository
    public final Observable<Boolean> isNeedToSendInstalledApp() {
        AccountEntityData createData2 = this.getAuthRequestContext.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<String> phoneNumber = createData2.getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        Observable<Boolean> onErrorResumeNext = phoneNumber.flatMap(new Function() { // from class: id.dana.data.installedapp.repository.InstalledAppEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InstalledAppEntityRepository.MyBillsEntityDataFactory(InstalledAppEntityRepository.this, (String) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.installedapp.repository.InstalledAppEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InstalledAppEntityRepository.PlaceComponentResult((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    @Override // id.dana.domain.installedapp.InstalledAppRepository
    public final Observable<Boolean> saveNeedToSendInstalledApp() {
        AccountEntityData createData2 = this.getAuthRequestContext.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<String> phoneNumber = createData2.getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        Observable<Boolean> onErrorResumeNext = phoneNumber.flatMap(new Function() { // from class: id.dana.data.installedapp.repository.InstalledAppEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InstalledAppEntityRepository.PlaceComponentResult(InstalledAppEntityRepository.this, (String) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.installedapp.repository.InstalledAppEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InstalledAppEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }
}
