package id.dana.data.kycrenewal.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.kycrenewal.mapper.QueryKYCRenewalStatusResultMapperKt;
import id.dana.data.kycrenewal.mapper.QueryKYCUserDataResultMapperKt;
import id.dana.data.kycrenewal.repository.source.KycRenewalEntityDataFactory;
import id.dana.data.kycrenewal.repository.source.KycRenewalPreferenceEntityDataFactory;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCRenewalStatusResult;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCUserDataResult;
import id.dana.data.kycrenewal.repository.source.session.KycRenewalPreference;
import id.dana.data.kycrenewal.repository.source.session.PreferenceKycRenewalEntityData;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import id.dana.domain.kycrenewal.model.QueryKYCRenewalStatus;
import id.dana.domain.kycrenewal.model.QueryKYCUserData;
import id.dana.domain.kycrenewal.model.ShowDialogPreference;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u001c\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010$"}, d2 = {"Lid/dana/data/kycrenewal/repository/KycRenewalEntityRepository;", "Lid/dana/domain/kycrenewal/KycRenewalRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "", "getKYCRenewalButtonClick", "()Lio/reactivex/Observable;", "", "getKYCRenewalDismissCount", "Lid/dana/domain/kycrenewal/model/QueryKYCRenewalStatus;", "getKYCRenewalStatus", "Lid/dana/domain/kycrenewal/model/QueryKYCUserData;", "getKYCUserData", "", "isNeedToQueryKYCRenewalDialog", "Lid/dana/domain/kycrenewal/model/ShowDialogPreference;", "isNeedToShowKYCRenewalDialog", "p0", "saveClickKYCRenewalButton", "(Z)Lio/reactivex/Observable;", "saveQueryKYCRenewalDialog", "(J)Lio/reactivex/Observable;", "p1", "saveShowKYCRenewalDialog", "(ZJ)Lio/reactivex/Observable;", "setKYCRenewalDismissCount", "(I)Lio/reactivex/Observable;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "MyBillsEntityDataFactory", "Lid/dana/data/kycrenewal/repository/source/KycRenewalEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/kycrenewal/repository/source/KycRenewalEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/kycrenewal/repository/source/KycRenewalPreferenceEntityDataFactory;", "Lid/dana/data/kycrenewal/repository/source/KycRenewalPreferenceEntityDataFactory;", "p2", "<init>", "(Lid/dana/data/kycrenewal/repository/source/KycRenewalEntityDataFactory;Lid/dana/data/kycrenewal/repository/source/KycRenewalPreferenceEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycRenewalEntityRepository implements KycRenewalRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final KycRenewalEntityDataFactory PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final KycRenewalPreferenceEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    @Inject
    public KycRenewalEntityRepository(KycRenewalEntityDataFactory kycRenewalEntityDataFactory, KycRenewalPreferenceEntityDataFactory kycRenewalPreferenceEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(kycRenewalEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(kycRenewalPreferenceEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.PlaceComponentResult = kycRenewalEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = kycRenewalPreferenceEntityDataFactory;
        this.MyBillsEntityDataFactory = holdLoginV1EntityRepository;
    }

    public static /* synthetic */ QueryKYCUserData PlaceComponentResult(QueryKYCUserDataResult queryKYCUserDataResult) {
        Intrinsics.checkNotNullParameter(queryKYCUserDataResult, "");
        return QueryKYCUserDataResultMapperKt.BuiltInFictitiousFunctionClassFactory(queryKYCUserDataResult);
    }

    public static /* synthetic */ QueryKYCRenewalStatus PlaceComponentResult(QueryKYCRenewalStatusResult queryKYCRenewalStatusResult) {
        Intrinsics.checkNotNullParameter(queryKYCRenewalStatusResult, "");
        return QueryKYCRenewalStatusResultMapperKt.BuiltInFictitiousFunctionClassFactory(queryKYCRenewalStatusResult);
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Boolean> getKYCRenewalButtonClick() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory.PlaceComponentResult()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Integer> getKYCRenewalDismissCount() {
        Integer integer = new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory.getAuthRequestContext.getInteger("popup_dismiss");
        Intrinsics.checkNotNullExpressionValue(integer, "");
        Observable<Integer> just = Observable.just(Integer.valueOf(integer.intValue()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<QueryKYCRenewalStatus> getKYCRenewalStatus() {
        KycRenewalEntityDataFactory kycRenewalEntityDataFactory = this.PlaceComponentResult;
        Intrinsics.checkNotNullParameter("network", "");
        Observable map = kycRenewalEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext().map(new Function() { // from class: id.dana.data.kycrenewal.repository.KycRenewalEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KycRenewalEntityRepository.PlaceComponentResult((QueryKYCRenewalStatusResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<QueryKYCUserData> getKYCUserData() {
        KycRenewalEntityDataFactory kycRenewalEntityDataFactory = this.PlaceComponentResult;
        Intrinsics.checkNotNullParameter("network", "");
        Observable map = kycRenewalEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().map(new Function() { // from class: id.dana.data.kycrenewal.repository.KycRenewalEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KycRenewalEntityRepository.PlaceComponentResult((QueryKYCUserDataResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Long> isNeedToQueryKYCRenewalDialog() {
        Long l = new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory.getAuthRequestContext.getLong("popup_check");
        Intrinsics.checkNotNullExpressionValue(l, "");
        Observable<Long> just = Observable.just(Long.valueOf(l.longValue()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<ShowDialogPreference> isNeedToShowKYCRenewalDialog() {
        KycRenewalPreference kycRenewalPreference = new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory;
        boolean authRequestContext = kycRenewalPreference.getAuthRequestContext();
        Long l = kycRenewalPreference.getAuthRequestContext.getLong("popup_show_last_time");
        Intrinsics.checkNotNullExpressionValue(l, "");
        Observable<ShowDialogPreference> just = Observable.just(new ShowDialogPreference(authRequestContext, l.longValue()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Boolean> saveClickKYCRenewalButton(boolean p0) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Boolean> saveQueryKYCRenewalDialog(long p0) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Boolean> saveShowKYCRenewalDialog(boolean p0, long p1) {
        PreferenceKycRenewalEntityData preferenceKycRenewalEntityData = new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        preferenceKycRenewalEntityData.MyBillsEntityDataFactory.getAuthRequestContext(p0);
        preferenceKycRenewalEntityData.MyBillsEntityDataFactory.getAuthRequestContext(p1);
        Boolean bool = Boolean.TRUE;
        Observable<Boolean> just = Observable.just(bool, bool);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.kycrenewal.KycRenewalRepository
    public final Observable<Boolean> setKYCRenewalDismissCount(int p0) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(new PreferenceKycRenewalEntityData(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory.PlaceComponentResult(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
