package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.KybResponse;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.model.KybCompleteInfo;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.QueryLatestOrder;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybMerchantInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/kyb/domain/model/KybCompleteInfo;", "Lid/dana/kyb/domain/interactor/GetKybMerchantInfo$Param;", "Lid/dana/domain/user/UserInfoResponse;", "", "MyBillsEntityDataFactory", "(Lid/dana/domain/user/UserInfoResponse;)Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/domain/KybRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/domain/KybRepository;", "PlaceComponentResult", "Lid/dana/domain/user/repository/UserRepository;", "Lid/dana/domain/user/repository/UserRepository;", "p0", "p1", "<init>", "(Lid/dana/kyb/domain/KybRepository;Lid/dana/domain/user/repository/UserRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetKybMerchantInfo extends BaseUseCase<KybCompleteInfo, Param> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final KybRepository PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final UserRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<KybCompleteInfo> buildUseCase(Param param) {
        Observable flatMap;
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        if (param2.getPlaceComponentResult()) {
            final boolean kClassImpl$Data$declaredNonStaticMembers$2 = param2.getKClassImpl$Data$declaredNonStaticMembers$2();
            flatMap = this.MyBillsEntityDataFactory.getUserInfoForKyb(false).flatMap(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybMerchantInfo$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetKybMerchantInfo.BuiltInFictitiousFunctionClassFactory(GetKybMerchantInfo.this, kClassImpl$Data$declaredNonStaticMembers$2, (UserInfoResponse) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
        } else {
            flatMap = this.MyBillsEntityDataFactory.getUserInfoForKyb(true).flatMap(new GetKybMerchantInfo$$ExternalSyntheticLambda4(this));
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
        }
        Observable<KybCompleteInfo> switchMap = flatMap.switchMap(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybMerchantInfo$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetKybMerchantInfo.PlaceComponentResult(GetKybMerchantInfo.this, (KybCompleteInfo) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        return switchMap;
    }

    @Inject
    public GetKybMerchantInfo(KybRepository kybRepository, UserRepository userRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        this.PlaceComponentResult = kybRepository;
        this.MyBillsEntityDataFactory = userRepository;
    }

    private static boolean MyBillsEntityDataFactory(UserInfoResponse userInfoResponse) {
        KybResponse kybResponse = userInfoResponse.getKybResponse();
        if (kybResponse != null) {
            if (!Intrinsics.areEqual(kybResponse.getKybLevel(), "1")) {
                return false;
            }
            String orderStatus = kybResponse.getOrderStatus();
            if (!(orderStatus == null || orderStatus.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(UserInfoResponse userInfoResponse) {
        KybResponse kybResponse = userInfoResponse.getKybResponse();
        if (kybResponse != null) {
            return StringsKt.equals(kybResponse.getOrderStatus(), "FAILED", true) || StringsKt.equals(kybResponse.getOrderStatus(), "INIT", true) || StringsKt.equals(kybResponse.getOrderStatus(), "REVOKED", true);
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybMerchantInfo$Param;", "", "", "MyBillsEntityDataFactory", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean PlaceComponentResult;

        public Param(boolean z, boolean z2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.PlaceComponentResult = z2;
        }

        public /* synthetic */ Param(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? true : z2);
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(GetKybMerchantInfo getKybMerchantInfo, final UserInfoResponse userInfoResponse) {
        ObservableSource map;
        Intrinsics.checkNotNullParameter(getKybMerchantInfo, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        if (MyBillsEntityDataFactory(userInfoResponse)) {
            map = Observable.just(new KybCompleteInfo(userInfoResponse, null, null, 6, null));
        } else if (BuiltInFictitiousFunctionClassFactory(userInfoResponse)) {
            map = getKybMerchantInfo.PlaceComponentResult.moveToNextValue().map(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybMerchantInfo$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetKybMerchantInfo.MyBillsEntityDataFactory(UserInfoResponse.this, (QueryLatestOrder) obj);
                }
            });
        } else {
            map = getKybMerchantInfo.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(true).map(new GetKybMerchantInfo$$ExternalSyntheticLambda2(userInfoResponse));
        }
        return map;
    }

    public static /* synthetic */ KybCompleteInfo MyBillsEntityDataFactory(UserInfoResponse userInfoResponse, QueryLatestOrder queryLatestOrder) {
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        Intrinsics.checkNotNullParameter(queryLatestOrder, "");
        return new KybCompleteInfo(userInfoResponse, null, queryLatestOrder, 2, null);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(GetKybMerchantInfo getKybMerchantInfo, boolean z, UserInfoResponse userInfoResponse) {
        Observable error;
        Intrinsics.checkNotNullParameter(getKybMerchantInfo, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        if (MyBillsEntityDataFactory(userInfoResponse) || BuiltInFictitiousFunctionClassFactory(userInfoResponse)) {
            int i = 1;
            if (!z) {
                ?? r3 = 0;
                error = Observable.error(new NotImplementedError(r3, i, r3));
                Intrinsics.checkNotNullExpressionValue(error, "");
            } else {
                error = getKybMerchantInfo.MyBillsEntityDataFactory.getUserInfoForKyb(true).flatMap(new GetKybMerchantInfo$$ExternalSyntheticLambda4(getKybMerchantInfo));
                Intrinsics.checkNotNullExpressionValue(error, "");
            }
        } else {
            error = getKybMerchantInfo.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(z).map(new GetKybMerchantInfo$$ExternalSyntheticLambda2(userInfoResponse));
        }
        return error;
    }

    public static /* synthetic */ KybCompleteInfo BuiltInFictitiousFunctionClassFactory(UserInfoResponse userInfoResponse, KybMerchantInfo kybMerchantInfo) {
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        Intrinsics.checkNotNullParameter(kybMerchantInfo, "");
        return new KybCompleteInfo(userInfoResponse, kybMerchantInfo, null, 4, null);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetKybMerchantInfo getKybMerchantInfo, KybCompleteInfo kybCompleteInfo) {
        Intrinsics.checkNotNullParameter(getKybMerchantInfo, "");
        Intrinsics.checkNotNullParameter(kybCompleteInfo, "");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = getKybMerchantInfo.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(kybCompleteInfo.getMerchantId(), kybCompleteInfo.getMerchantTier());
        Predicate BuiltInFictitiousFunctionClassFactory = Functions.BuiltInFictitiousFunctionClassFactory();
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "predicate is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableOnErrorComplete(KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory));
        Observable just = Observable.just(kybCompleteInfo);
        ObjectHelper.PlaceComponentResult(just, "next is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new CompletableAndThenObservable(KClassImpl$Data$declaredNonStaticMembers$22, just));
    }
}
