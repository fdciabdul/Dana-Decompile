package id.dana.kyb.data.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.domain.extension.ObservableExtKt;
import id.dana.domain.promotion.Space;
import id.dana.kyb.data.KybCpmException;
import id.dana.kyb.data.KybEntityData;
import id.dana.kyb.data.mapper.KybCpmMapperKt;
import id.dana.kyb.data.mapper.KybMapperKt;
import id.dana.kyb.data.model.KybServiceResult;
import id.dana.kyb.data.model.KybStartupConfigResult;
import id.dana.kyb.data.model.KybUrlsConfigWrapperResult;
import id.dana.kyb.data.repository.source.KybConfigEntityDataFactory;
import id.dana.kyb.data.repository.source.KybEntityDataFactory;
import id.dana.kyb.data.repository.source.KybPreferenceEntityDataFactory;
import id.dana.kyb.data.repository.source.network.result.KybMerchantInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult;
import id.dana.kyb.data.repository.source.network.result.PaymentOrderCpmResult;
import id.dana.kyb.data.repository.source.network.result.QueryLatestOrderResult;
import id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.KybRequestPayment;
import id.dana.kyb.domain.model.KybService;
import id.dana.kyb.domain.model.KybStartupConfig;
import id.dana.kyb.domain.model.KybUrlsConfig;
import id.dana.kyb.domain.model.PaymentOrderCpm;
import id.dana.kyb.domain.model.QueryLatestOrder;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import id.dana.network.exception.NetworkException;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010\n\u001a\u000202\u0012\u0006\u0010\u000b\u001a\u000200\u0012\u0006\u00108\u001a\u00020,\u0012\u0006\u00109\u001a\u000204\u0012\u0006\u0010:\u001a\u000206\u0012\u0006\u0010;\u001a\u00020.¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\n\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0004\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\n\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0015J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0012J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0004\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\fH\u0016¢\u0006\u0004\b\u001c\u0010\u0012J\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\fH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\f2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016¢\u0006\u0004\b \u0010\u0012J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\fH\u0016¢\u0006\u0004\b\"\u0010\u0012J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0016¢\u0006\u0004\b#\u0010\u0012J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\fH\u0016¢\u0006\u0004\b%\u0010\u0012J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\fH\u0016¢\u0006\u0004\b'\u0010\u0012J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0016¢\u0006\u0004\b(\u0010\u0012J\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u001f\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010)J\u0013\u0010\u001c\u001a\u00020\u0013*\u00020*H\u0002¢\u0006\u0004\b\u001c\u0010+R\u0014\u0010\u000e\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010-R\u0014\u0010\u0004\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010/R\u0014\u0010\u0017\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00101R\u0014\u0010\u0011\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00103R\u0014\u0010\u001c\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00105R\u0014\u0010 \u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u00107"}, d2 = {"Lid/dana/kyb/data/repository/KybEntityRepository;", "Lid/dana/kyb/domain/KybRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Completable;", "MyBillsEntityDataFactory", "()Lio/reactivex/Completable;", "Lid/dana/kyb/data/KybEntityData;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Lid/dana/kyb/data/KybEntityData;", "", "p0", "p1", "Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/PaymentOrderCpm;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "", "Lid/dana/domain/promotion/Space;", "(Z)Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "PlaceComponentResult", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "Lid/dana/kyb/domain/model/KybService;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybStartupConfig;", "getAuthRequestContext", "getErrorConfigVersion", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "(ZLjava/lang/String;)Lio/reactivex/Observable;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/kyb/domain/model/KybRequestPayment;", "scheduleImpl", "lookAheadTest", "Lid/dana/kyb/domain/model/QueryLatestOrder;", "moveToNextValue", "Lid/dana/kyb/domain/model/KybUrlsConfig;", "GetContactSyncConfig", "DatabaseTableConfigUtil", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "", "(Ljava/lang/Throwable;)Z", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/kyb/data/repository/source/KybConfigEntityDataFactory;", "Lid/dana/kyb/data/repository/source/KybConfigEntityDataFactory;", "Lid/dana/kyb/data/repository/source/KybEntityDataFactory;", "Lid/dana/kyb/data/repository/source/KybEntityDataFactory;", "Lid/dana/kyb/data/repository/source/KybPreferenceEntityDataFactory;", "Lid/dana/kyb/data/repository/source/KybPreferenceEntityDataFactory;", "Lid/dana/data/content/mapper/SpaceResultMapper;", "Lid/dana/data/content/mapper/SpaceResultMapper;", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/kyb/data/repository/source/KybEntityDataFactory;Lid/dana/kyb/data/repository/source/KybConfigEntityDataFactory;Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;Lid/dana/kyb/data/repository/source/KybPreferenceEntityDataFactory;Lid/dana/data/content/mapper/SpaceResultMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KybEntityRepository implements KybRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final KybEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final KybPreferenceEntityDataFactory getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final KybConfigEntityDataFactory PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ContentDeliveryEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final SpaceResultMapper NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public KybEntityRepository(KybEntityDataFactory kybEntityDataFactory, KybConfigEntityDataFactory kybConfigEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, KybPreferenceEntityDataFactory kybPreferenceEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(kybEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(kybConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(contentDeliveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(kybPreferenceEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(spaceResultMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kybEntityDataFactory;
        this.PlaceComponentResult = kybConfigEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = contentDeliveryEntityDataFactory;
        this.getAuthRequestContext = kybPreferenceEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = spaceResultMapper;
        this.MyBillsEntityDataFactory = holdLoginV1EntityRepository;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<QueryLatestOrder> moveToNextValue() {
        ObservableSource map = NetworkUserEntityData$$ExternalSyntheticLambda1().PlaceComponentResult().map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.BuiltInFictitiousFunctionClassFactory((QueryLatestOrderResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<QueryLatestOrder> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<KybRequestPayment> scheduleImpl() {
        ObservableSource map = NetworkUserEntityData$$ExternalSyntheticLambda1().getAuthRequestContext().map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.PlaceComponentResult((KybRequestPaymentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<KybRequestPayment> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    private static boolean getAuthRequestContext(Throwable th) {
        return (th instanceof NetworkException) && Intrinsics.areEqual(((NetworkException) th).getErrorCode(), "AE15101858018786");
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Completable MyBillsEntityDataFactory() {
        Completable PlaceComponentResult = Completable.PlaceComponentResult(new Action() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Action
            public final void run() {
                KybEntityRepository.getAuthRequestContext(KybEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    private final KybEntityData NetworkUserEntityData$$ExternalSyntheticLambda1() {
        KybEntityDataFactory kybEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return Intrinsics.areEqual("network", "mock") ? kybEntityDataFactory.BuiltInFictitiousFunctionClassFactory : kybEntityDataFactory.PlaceComponentResult;
    }

    public static /* synthetic */ QueryLatestOrder BuiltInFictitiousFunctionClassFactory(QueryLatestOrderResult queryLatestOrderResult) {
        Intrinsics.checkNotNullParameter(queryLatestOrderResult, "");
        return KybMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(queryLatestOrderResult);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(KybEntityRepository kybEntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return kybEntityRepository.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(str, str2);
    }

    public static /* synthetic */ KybStartupConfig BuiltInFictitiousFunctionClassFactory(KybStartupConfigResult kybStartupConfigResult) {
        Intrinsics.checkNotNullParameter(kybStartupConfigResult, "");
        return KybMapperKt.BuiltInFictitiousFunctionClassFactory(kybStartupConfigResult);
    }

    public static /* synthetic */ Space BuiltInFictitiousFunctionClassFactory(KybEntityRepository kybEntityRepository, SpaceRpcResult spaceRpcResult) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullParameter(spaceRpcResult, "");
        return kybEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(spaceRpcResult);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(KybEntityRepository kybEntityRepository, Space space) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullExpressionValue(space, "");
        kybEntityRepository.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(space);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(KybEntityRepository kybEntityRepository, KybMerchantInfo kybMerchantInfo) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullExpressionValue(kybMerchantInfo, "");
        kybEntityRepository.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(kybMerchantInfo);
    }

    public static /* synthetic */ TransactionListQueryInfo MyBillsEntityDataFactory(TransactionListQueryResult transactionListQueryResult) {
        Intrinsics.checkNotNullParameter(transactionListQueryResult, "");
        return KybMapperKt.getAuthRequestContext(transactionListQueryResult);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(KybEntityRepository kybEntityRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (getAuthRequestContext(th)) {
            return Observable.just(new KybMerchantInfoResult(null, null, null, null, null, null, null, null, null, null, null, false, null, false, false, false, false, false, null, null, null, 2097151, null));
        }
        return Observable.error(th);
    }

    public static /* synthetic */ KybRequestPayment PlaceComponentResult(KybRequestPaymentResult kybRequestPaymentResult) {
        Intrinsics.checkNotNullParameter(kybRequestPaymentResult, "");
        return KybMapperKt.getAuthRequestContext(kybRequestPaymentResult);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(KybEntityRepository kybEntityRepository, String str, String str2, final KybMerchantInfo kybMerchantInfo) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(kybMerchantInfo, "");
        KybEntityDataFactory kybEntityDataFactory = kybEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2;
        return (Intrinsics.areEqual("network", "mock") ? kybEntityDataFactory.BuiltInFictitiousFunctionClassFactory : kybEntityDataFactory.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(kybMerchantInfo, str, str2).onErrorResumeNext(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.PlaceComponentResult(KybMerchantInfo.this, (Throwable) obj);
            }
        }).map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.PlaceComponentResult((PaymentOrderCpmResult) obj);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(KybEntityRepository kybEntityRepository, TransactionListQueryInfo transactionListQueryInfo) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullExpressionValue(transactionListQueryInfo, "");
        kybEntityRepository.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(transactionListQueryInfo);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(KybMerchantInfo kybMerchantInfo, Throwable th) {
        Intrinsics.checkNotNullParameter(kybMerchantInfo, "");
        Intrinsics.checkNotNullParameter(th, "");
        if ((th instanceof NetworkException) && Intrinsics.areEqual(((NetworkException) th).getErrorCode(), "AE15112128001408")) {
            return Observable.error(new KybCpmException(kybMerchantInfo.getMerchantName(), th.getMessage()));
        }
        return Observable.error(th);
    }

    public static /* synthetic */ KybMerchantInfo getAuthRequestContext(KybMerchantInfoResult kybMerchantInfoResult) {
        Intrinsics.checkNotNullParameter(kybMerchantInfoResult, "");
        return KybMapperKt.getAuthRequestContext(kybMerchantInfoResult);
    }

    public static /* synthetic */ KybUrlsConfig PlaceComponentResult(KybUrlsConfigWrapperResult kybUrlsConfigWrapperResult) {
        Intrinsics.checkNotNullParameter(kybUrlsConfigWrapperResult, "");
        return KybMapperKt.BuiltInFictitiousFunctionClassFactory(kybUrlsConfigWrapperResult);
    }

    public static /* synthetic */ Space MyBillsEntityDataFactory(KybEntityRepository kybEntityRepository, SpaceRpcResult spaceRpcResult) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullParameter(spaceRpcResult, "");
        return kybEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(spaceRpcResult);
    }

    public static /* synthetic */ void getAuthRequestContext(KybEntityRepository kybEntityRepository) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        kybEntityRepository.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ KybService KClassImpl$Data$declaredNonStaticMembers$2(KybServiceResult kybServiceResult) {
        Intrinsics.checkNotNullParameter(kybServiceResult, "");
        return KybMapperKt.PlaceComponentResult(kybServiceResult);
    }

    public static /* synthetic */ PaymentOrderCpm PlaceComponentResult(PaymentOrderCpmResult paymentOrderCpmResult) {
        Intrinsics.checkNotNullParameter(paymentOrderCpmResult, "");
        return KybCpmMapperKt.BuiltInFictitiousFunctionClassFactory(paymentOrderCpmResult);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(KybEntityRepository kybEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(kybEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return kybEntityRepository.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(str);
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<PaymentOrderCpm> BuiltInFictitiousFunctionClassFactory(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable flatMap = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.getAuthRequestContext(KybEntityRepository.this, p0, p1, (KybMerchantInfo) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<List<String>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return ObservableExtKt.toSingleObservable(this.PlaceComponentResult.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<Space> MyBillsEntityDataFactory(boolean p0) {
        if (p0) {
            ContentDeliveryEntityData createData2 = this.BuiltInFictitiousFunctionClassFactory.createData2("network");
            Intrinsics.checkNotNullExpressionValue(createData2, "");
            Observable doOnNext = createData2.get(SpaceCode.KYB_BANNER).map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return KybEntityRepository.MyBillsEntityDataFactory(KybEntityRepository.this, (SpaceRpcResult) obj);
                }
            }).doOnNext(new Consumer() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    KybEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(KybEntityRepository.this, (Space) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            Intrinsics.checkNotNullParameter(doOnNext, "");
            Observable<Space> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(doOnNext);
            Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
            return authenticatedRequest;
        }
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<KybCompressQrConfig> PlaceComponentResult() {
        return this.PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<KybMerchantInfo> KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            Observable doOnNext = NetworkUserEntityData$$ExternalSyntheticLambda1().MyBillsEntityDataFactory().onErrorResumeNext(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return KybEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(KybEntityRepository.this, (Throwable) obj);
                }
            }).map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return KybEntityRepository.getAuthRequestContext((KybMerchantInfoResult) obj);
                }
            }).doOnNext(new Consumer() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    KybEntityRepository.MyBillsEntityDataFactory(KybEntityRepository.this, (KybMerchantInfo) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            Intrinsics.checkNotNullParameter(doOnNext, "");
            Observable<KybMerchantInfo> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(doOnNext);
            Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
            return authenticatedRequest;
        }
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<Space> BuiltInFictitiousFunctionClassFactory() {
        ContentDeliveryEntityData createData2 = this.BuiltInFictitiousFunctionClassFactory.createData2("network");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        ObservableSource map = createData2.get(SpaceCode.KYB_QRIS_POSTER).map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.BuiltInFictitiousFunctionClassFactory(KybEntityRepository.this, (SpaceRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<Space> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<KybService> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<R> map = this.PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext(p0).map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((KybServiceResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return ObservableExtKt.toSingleObservable(map);
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<KybStartupConfig> getAuthRequestContext() {
        Observable map = this.PlaceComponentResult.MyBillsEntityDataFactory.PlaceComponentResult().map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.BuiltInFictitiousFunctionClassFactory((KybStartupConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<List<String>> getErrorConfigVersion() {
        return ObservableExtKt.toSingleObservable(this.PlaceComponentResult.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<TransactionListQueryInfo> getAuthRequestContext(boolean p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0) {
            Observable doOnNext = NetworkUserEntityData$$ExternalSyntheticLambda1().MyBillsEntityDataFactory(p1).map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return KybEntityRepository.MyBillsEntityDataFactory((TransactionListQueryResult) obj);
                }
            }).doOnNext(new Consumer() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    KybEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(KybEntityRepository.this, (TransactionListQueryInfo) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            Intrinsics.checkNotNullParameter(doOnNext, "");
            Observable<TransactionListQueryInfo> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(doOnNext);
            Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
            return authenticatedRequest;
        }
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<String> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        AccountEntityData createAccountData = this.MyBillsEntityDataFactory.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        Observable flatMap = createAccountData.getPhoneNumber().flatMap(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.BuiltInFictitiousFunctionClassFactory(KybEntityRepository.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<Boolean> lookAheadTest() {
        return this.PlaceComponentResult.MyBillsEntityDataFactory.scheduleImpl();
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<KybUrlsConfig> GetContactSyncConfig() {
        Observable map = this.PlaceComponentResult.MyBillsEntityDataFactory.MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.PlaceComponentResult((KybUrlsConfigWrapperResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<Boolean> DatabaseTableConfigUtil() {
        return this.PlaceComponentResult.MyBillsEntityDataFactory.getErrorConfigVersion();
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Observable<Boolean> getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        AccountEntityData createAccountData = this.MyBillsEntityDataFactory.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        Observable flatMap = createAccountData.getPhoneNumber().flatMap(new Function() { // from class: id.dana.kyb.data.repository.KybEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return KybEntityRepository.PlaceComponentResult(KybEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.kyb.domain.KybRepository
    public final Completable KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return this.PlaceComponentResult.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }
}
