package id.dana.data.nearbyme.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.nearbyme.mapper.DanaDealsVoucherOrderMapper;
import id.dana.data.nearbyme.mapper.NearbyShopsResultMapper;
import id.dana.data.nearbyme.model.NearbyPromoResult;
import id.dana.data.nearbyme.model.PromoInfoEntity;
import id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData;
import id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.session.LocalMerchantInfoEntityData;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.social.Result;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BQ\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bb\u0010cJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001bH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010 \u001a\u00020\u001fH\u0096\u0001¢\u0006\u0004\b \u0010!JI\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%0\b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b(\u0010)J+\u0010,\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J)\u0010/\u001a\b\u0012\u0004\u0012\u00020.0&2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b/\u00100J9\u00102\u001a\b\u0012\u0004\u0012\u0002010&2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b2\u00103JA\u00106\u001a\u0002052\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0&H\u0096@ø\u0001\u0000¢\u0006\u0004\b6\u00107J#\u00109\u001a\u0002082\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b9\u00100J\u0013\u0010:\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J#\u0010>\u001a\u00020=2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b>\u0010?J#\u0010B\u001a\u00020A2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\bB\u00100J\u001b\u0010E\u001a\u00020D2\u0006\u0010C\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010a\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/MerchantInfoEntityRepository;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", FeatureParams.SHOP_ID, "", SecurityConstants.KEY_PAGE_SIZE, "pageNum", "Lid/dana/domain/nearbyme/model/MerchantConsult;", "consultMerchantReview", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "danaDealsOrderRequest", "Lid/dana/domain/nearbyme/model/ProductOrder;", "createDanaDealsVoucherOrder", "(Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "merchantId", "", "skipCache", "Lid/dana/domain/social/Result$Success;", "", "Lid/dana/domain/nearbyme/model/MerchantImage;", "getMerchantImage", "(Ljava/lang/String;Ljava/lang/String;IIZ)Lkotlinx/coroutines/flow/Flow;", "useNewMerchantCategory", "Lid/dana/domain/nearbyme/model/Shop;", "getMerchantInfo", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/model/PromoInfo;", "getMerchantPromo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "getMerchantPromoDanaDeal", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterCriteria", "Lid/dana/domain/nearbyme/model/MerchantReviews;", "getMerchantReview", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "getMerchantReviewSummary", "getReviewCoachmark", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ZdocRecordService.PAGE_NUMBER, "Lid/dana/domain/nearbyme/model/QueryUserReviews;", "getReviewedMerchantsList", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bizInfo", "Lid/dana/domain/nearbyme/model/MerchantAdditionalInfo;", "queryAdditionalInfo", "enabled", "", "setReviewCoachmark", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityData", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/nearbyme/mapper/DanaDealsVoucherOrderMapper;", "danaDealsVoucherOrderMapper", "Lid/dana/data/nearbyme/mapper/DanaDealsVoucherOrderMapper;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/nearbyme/repository/source/session/LocalMerchantInfoEntityData;", "localMerchantInfoEntityData", "Lid/dana/data/nearbyme/repository/source/session/LocalMerchantInfoEntityData;", "Lid/dana/data/nearbyme/repository/NearbyMeEntityRepository;", "nearbyMeEntityRepository", "Lid/dana/data/nearbyme/repository/NearbyMeEntityRepository;", "Lid/dana/data/nearbyme/mapper/NearbyShopsResultMapper;", "nearbyShopsResultMapper", "Lid/dana/data/nearbyme/mapper/NearbyShopsResultMapper;", "Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;", "networkMerchantInfoEntityData", "Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;", "Lid/dana/data/nearbyme/repository/source/network/NetworkNearbyMeEntityData;", "networkNearbyMeEntityData", "Lid/dana/data/nearbyme/repository/source/network/NetworkNearbyMeEntityData;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "splitConfigEntityData", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "<init>", "(Lid/dana/data/nearbyme/mapper/DanaDealsVoucherOrderMapper;Lid/dana/data/nearbyme/repository/source/session/LocalMerchantInfoEntityData;Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;Lid/dana/data/nearbyme/repository/source/network/NetworkNearbyMeEntityData;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/nearbyme/mapper/NearbyShopsResultMapper;Lid/dana/data/nearbyme/repository/NearbyMeEntityRepository;Lid/dana/data/config/source/split/SplitConfigEntityData;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantInfoEntityRepository implements MerchantInfoRepository, HoldLoginV1Repository {
    private final AccountEntityDataFactory accountEntityData;
    private final DanaDealsVoucherOrderMapper danaDealsVoucherOrderMapper;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final LocalMerchantInfoEntityData localMerchantInfoEntityData;
    private final NearbyMeEntityRepository nearbyMeEntityRepository;
    private final NearbyShopsResultMapper nearbyShopsResultMapper;
    private final NetworkMerchantInfoEntityData networkMerchantInfoEntityData;
    private final NetworkNearbyMeEntityData networkNearbyMeEntityData;
    private final SplitConfigEntityData splitConfigEntityData;

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public MerchantInfoEntityRepository(DanaDealsVoucherOrderMapper danaDealsVoucherOrderMapper, LocalMerchantInfoEntityData localMerchantInfoEntityData, NetworkMerchantInfoEntityData networkMerchantInfoEntityData, NetworkNearbyMeEntityData networkNearbyMeEntityData, AccountEntityDataFactory accountEntityDataFactory, NearbyShopsResultMapper nearbyShopsResultMapper, NearbyMeEntityRepository nearbyMeEntityRepository, SplitConfigEntityData splitConfigEntityData, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(danaDealsVoucherOrderMapper, "");
        Intrinsics.checkNotNullParameter(localMerchantInfoEntityData, "");
        Intrinsics.checkNotNullParameter(networkMerchantInfoEntityData, "");
        Intrinsics.checkNotNullParameter(networkNearbyMeEntityData, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(nearbyShopsResultMapper, "");
        Intrinsics.checkNotNullParameter(nearbyMeEntityRepository, "");
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.danaDealsVoucherOrderMapper = danaDealsVoucherOrderMapper;
        this.localMerchantInfoEntityData = localMerchantInfoEntityData;
        this.networkMerchantInfoEntityData = networkMerchantInfoEntityData;
        this.networkNearbyMeEntityData = networkNearbyMeEntityData;
        this.accountEntityData = accountEntityDataFactory;
        this.nearbyShopsResultMapper = nearbyShopsResultMapper;
        this.nearbyMeEntityRepository = nearbyMeEntityRepository;
        this.splitConfigEntityData = splitConfigEntityData;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantInfo(java.lang.String r6, java.lang.String r7, boolean r8, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.Shop> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantInfo$1
            if (r0 == 0) goto L14
            r0 = r9
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantInfo$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantInfo$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantInfo$1
            r0.<init>(r5, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository r6 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6e
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            id.dana.data.nearbyme.repository.NearbyMeEntityRepository r9 = r5.nearbyMeEntityRepository
            io.reactivex.Observable r9 = r9.getMerchantTopupAgent()
            java.lang.Object r9 = r9.blockingFirst()
            java.util.Map r9 = (java.util.Map) r9
            id.dana.data.nearbyme.repository.NearbyMeEntityRepository r2 = r5.nearbyMeEntityRepository
            io.reactivex.Observable r2 = r2.getMerchantSubcategories(r8)
            java.lang.Object r2 = r2.blockingFirst()
            java.util.Map r2 = (java.util.Map) r2
            id.dana.data.nearbyme.mapper.NearbyShopsResultMapper r4 = r5.nearbyShopsResultMapper
            r4.setUsingNewMerchantCategories(r8)
            id.dana.data.nearbyme.mapper.NearbyShopsResultMapper r8 = r5.nearbyShopsResultMapper
            r8.setMerchantInstId(r9)
            id.dana.data.nearbyme.mapper.NearbyShopsResultMapper r8 = r5.nearbyShopsResultMapper
            r8.setMerchantSubcategory(r2)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r8 = r5.networkMerchantInfoEntityData
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r9 = r8.getMerchantInfo(r6, r7, r0)
            if (r9 != r1) goto L6d
            return r1
        L6d:
            r6 = r5
        L6e:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantDetailInfoResult r9 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantDetailInfoResult) r9
            id.dana.data.nearbyme.model.ShopEntity r7 = r9.getShopInfo()
            id.dana.data.nearbyme.mapper.NearbyShopsResultMapper r6 = r6.nearbyShopsResultMapper
            id.dana.domain.nearbyme.model.Shop r6 = r6.transformShopEntity(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.getMerchantInfo(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantReviewSummary(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantReviewSummary> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReviewSummary$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReviewSummary$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReviewSummary$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReviewSummary$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReviewSummary$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r7 = r4.networkMerchantInfoEntityData
            r0.label = r3
            java.lang.Object r7 = r7.getMerchantReviewSummary(r5, r6, r0)
            if (r7 != r1) goto L40
            return r1
        L40:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantReviewSummaryResult r7 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantReviewSummaryResult) r7
            id.dana.domain.nearbyme.model.MerchantReviewSummary r5 = r7.toMerchantReviewSummary()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.getMerchantReviewSummary(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantReview(java.lang.String r9, java.lang.String r10, int r11, int r12, java.util.List<java.lang.String> r13, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantReviews> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReview$1
            if (r0 == 0) goto L14
            r0 = r14
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReview$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReview$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 + r2
            r0.label = r14
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReview$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantReview$1
            r0.<init>(r8, r14)
        L19:
            r7 = r0
            java.lang.Object r14 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r14)
            goto L46
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.ResultKt.throwOnFailure(r14)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r1 = r8.networkMerchantInfoEntityData
            r7.label = r2
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.getMerchantReview(r2, r3, r4, r5, r6, r7)
            if (r14 != r0) goto L46
            return r0
        L46:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantQueryReviewResult r14 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantQueryReviewResult) r14
            id.dana.domain.nearbyme.model.MerchantReviews r9 = r14.toMerchantReviews()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.getMerchantReview(java.lang.String, java.lang.String, int, int, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    public final Flow<Result.Success<List<MerchantImage>>> getMerchantImage(String merchantId, String shopId, int pageNum, int pageSize, boolean skipCache) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(shopId, "");
        final Flow onStart = FlowKt.onStart(FlowKt.flow(new MerchantInfoEntityRepository$getMerchantImage$1(this, merchantId, shopId, pageNum, pageSize, null)), new MerchantInfoEntityRepository$getMerchantImage$2(skipCache, this, merchantId, shopId, pageNum, pageSize, null));
        return (Flow) new Flow<Result.Success<? extends List<? extends MerchantImage>>>() { // from class: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Result.Success<? extends List<? extends MerchantImage>>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $$this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1$2", f = "MerchantInfoEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1$2$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1$2$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4e
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult r5 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult) r5
                        id.dana.domain.social.Result$Success r2 = new id.dana.domain.social.Result$Success
                        java.util.List r5 = r5.toMerchantImages()
                        r2.<init>(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r2, r0)
                        if (r5 != r1) goto L4e
                        return r1
                    L4e:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantPromoDanaDeal(java.lang.String r8, java.lang.String r9, int r10, int r11, kotlin.coroutines.Continuation<? super java.util.List<id.dana.domain.nearbyme.model.MerchantProductInfo>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantPromoDanaDeal$1
            if (r0 == 0) goto L14
            r0 = r12
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantPromoDanaDeal$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantPromoDanaDeal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 + r2
            r0.label = r12
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantPromoDanaDeal$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantPromoDanaDeal$1
            r0.<init>(r7, r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r12)
            goto L45
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r12)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r1 = r7.networkMerchantInfoEntityData
            r6.label = r2
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.getMerchantPromoDanaDeal(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L45
            return r0
        L45:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantPromoDanaDealResult r12 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantPromoDanaDealResult) r12
            java.util.List r8 = r12.toProductInfoList()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.getMerchantPromoDanaDeal(java.lang.String, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createDanaDealsVoucherOrder(id.dana.domain.nearbyme.model.DanaDealsOrderRequest r5, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.ProductOrder> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$createDanaDealsVoucherOrder$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$createDanaDealsVoucherOrder$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$createDanaDealsVoucherOrder$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$createDanaDealsVoucherOrder$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$createDanaDealsVoucherOrder$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L65
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            id.dana.data.nearbyme.mapper.DanaDealsVoucherOrderMapper r6 = r4.danaDealsVoucherOrderMapper
            java.lang.Object r5 = r6.apply(r5)
            id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest r5 = (id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest) r5
            id.dana.data.account.repository.source.AccountEntityDataFactory r6 = r4.accountEntityData
            java.lang.String r2 = "local"
            id.dana.data.account.repository.source.AccountEntityData r6 = r6.createData2(r2)
            io.reactivex.Observable r6 = r6.getUserId()
            java.lang.Object r6 = r6.blockingFirst()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r5.setParam(r6)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r6 = r4.networkMerchantInfoEntityData
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r0.label = r3
            java.lang.Object r6 = r6.createProductOrder(r5, r0)
            if (r6 != r1) goto L65
            return r1
        L65:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.ProductOrderResult r6 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.ProductOrderResult) r6
            id.dana.domain.nearbyme.model.ProductOrder r5 = r6.toProductOrder()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.createDanaDealsVoucherOrder(id.dana.domain.nearbyme.model.DanaDealsOrderRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object consultMerchantReview(java.lang.String r5, int r6, int r7, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantConsult> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$consultMerchantReview$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$consultMerchantReview$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$consultMerchantReview$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$consultMerchantReview$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$consultMerchantReview$1
            r0.<init>(r4, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository r5 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository) r5
            java.lang.Object r6 = r0.L$0
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository r6 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L62
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r8 = r4.networkMerchantInfoEntityData
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L4a
            r2 = 1
            goto L4b
        L4a:
            r2 = 0
        L4b:
            if (r2 != 0) goto L4e
            r5 = 0
        L4e:
            id.dana.data.nearbyme.repository.source.network.request.merchantdetail.BaseMerchantInfoRequest r2 = new id.dana.data.nearbyme.repository.source.network.request.merchantdetail.BaseMerchantInfoRequest
            r2.<init>(r5, r6, r7)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r8 = r8.consultMerchantReview(r2, r0)
            if (r8 != r1) goto L60
            return r1
        L60:
            r5 = r4
            r6 = r5
        L62:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantConsultResult r8 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantConsultResult) r8
            id.dana.data.nearbyme.mapper.NearbyShopsResultMapper r6 = r6.nearbyShopsResultMapper
            id.dana.domain.nearbyme.model.MerchantConsult r6 = r8.toMerchantConsult(r8, r6)
            io.reactivex.Observable r6 = io.reactivex.Observable.just(r6)
            java.lang.String r7 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            io.reactivex.Observable r5 = r5.authenticatedRequest(r6)
            java.lang.Object r5 = r5.blockingFirst()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.consultMerchantReview(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object queryAdditionalInfo(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantAdditionalInfo> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$queryAdditionalInfo$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$queryAdditionalInfo$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$queryAdditionalInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$queryAdditionalInfo$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$queryAdditionalInfo$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r7 = r4.networkMerchantInfoEntityData
            id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantAdditionalInfoRequest r2 = new id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantAdditionalInfoRequest
            r2.<init>(r5, r6)
            r0.label = r3
            java.lang.Object r7 = r7.queryAdditionalInfo(r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantAdditionalInfoResult r7 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantAdditionalInfoResult) r7
            id.dana.domain.nearbyme.model.MerchantAdditionalInfo r5 = r7.toMerchantAdditionalInfo()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.queryAdditionalInfo(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    public final Object getReviewCoachmark(Continuation<? super Boolean> continuation) {
        return this.localMerchantInfoEntityData.getCoachmarkVisibility(continuation);
    }

    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    public final Object setReviewCoachmark(boolean z, Continuation<? super Unit> continuation) {
        Object coachmarkVisibility = this.localMerchantInfoEntityData.setCoachmarkVisibility(z, continuation);
        return coachmarkVisibility == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coachmarkVisibility : Unit.INSTANCE;
    }

    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    public final Object getMerchantPromo(String str, String str2, Continuation<? super List<PromoInfo>> continuation) {
        List<PromoInfoEntity> promoInfos;
        final NearbyPromoShopEntity nearbyPromoShopEntity = new NearbyPromoShopEntity();
        nearbyPromoShopEntity.merchantId = str;
        nearbyPromoShopEntity.shopId = str2;
        ObservableSource switchMap = this.splitConfigEntityData.isMigratePromoOperationType().switchMap(new Function() { // from class: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1510getMerchantPromo$lambda4;
                m1510getMerchantPromo$lambda4 = MerchantInfoEntityRepository.m1510getMerchantPromo$lambda4(MerchantInfoEntityRepository.this, nearbyPromoShopEntity, (Boolean) obj);
                return m1510getMerchantPromo$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        List<NearbyPromoResult> shops = ((NearbyShopsPromoResult) authenticatedRequest((Observable) switchMap).blockingFirst()).getShops();
        Intrinsics.checkNotNullExpressionValue(shops, "");
        NearbyPromoResult nearbyPromoResult = (NearbyPromoResult) CollectionsKt.firstOrNull((List) shops);
        if (nearbyPromoResult == null || (promoInfos = nearbyPromoResult.getPromoInfos()) == null) {
            return CollectionsKt.emptyList();
        }
        List<PromoInfoEntity> list = promoInfos;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PromoInfoEntity) it.next()).toPromoInfo());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMerchantPromo$lambda-4  reason: not valid java name */
    public static final ObservableSource m1510getMerchantPromo$lambda4(MerchantInfoEntityRepository merchantInfoEntityRepository, NearbyPromoShopEntity nearbyPromoShopEntity, Boolean bool) {
        Intrinsics.checkNotNullParameter(merchantInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(nearbyPromoShopEntity, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return merchantInfoEntityRepository.networkNearbyMeEntityData.getNearbyMerchantPromo(bool.booleanValue(), CollectionsKt.listOf(nearbyPromoShopEntity));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // id.dana.domain.nearbyme.MerchantInfoRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getReviewedMerchantsList(int r5, int r6, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.QueryUserReviews> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getReviewedMerchantsList$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getReviewedMerchantsList$1 r0 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getReviewedMerchantsList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getReviewedMerchantsList$1 r0 = new id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getReviewedMerchantsList$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r7 = r4.networkMerchantInfoEntityData
            id.dana.data.nearbyme.repository.source.network.request.merchantreview.QueryUserReviewsRequest r2 = new id.dana.data.nearbyme.repository.source.network.request.merchantreview.QueryUserReviewsRequest
            r2.<init>(r5, r6)
            r0.label = r3
            java.lang.Object r7 = r7.getReviewedMerchantsList(r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            id.dana.data.nearbyme.repository.source.network.result.merchantreview.QueryUserReviewsResult r7 = (id.dana.data.nearbyme.repository.source.network.result.merchantreview.QueryUserReviewsResult) r7
            id.dana.domain.nearbyme.model.QueryUserReviews r5 = r7.toQueryUserReviews()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.getReviewedMerchantsList(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
