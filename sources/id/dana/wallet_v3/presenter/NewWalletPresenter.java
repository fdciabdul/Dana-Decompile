package id.dana.wallet_v3.presenter;

import dagger.Lazy;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.LoyaltyToken;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.wallet_v3.constant.WalletAssetType;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi;
import id.dana.domain.wallet_v3.interactor.GetPocketRedDotAsset;
import id.dana.domain.wallet_v3.interactor.GetTotalSectionQuery;
import id.dana.domain.wallet_v3.interactor.GetTotalUserPaymentAsset;
import id.dana.domain.wallet_v3.interactor.GetTotalUserPocketAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal;
import id.dana.domain.wallet_v3.interactor.UpdateTotalSectionQuery;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetsModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.network.exception.NetworkException;
import id.dana.wallet_v3.mapper.UserPaymentAssetsMapperKt;
import id.dana.wallet_v3.mapper.UserPocketAssetsMapperKt;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.presenter.NewWalletContract;
import id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 t2\u00020\u0001:\u0001tB\u0091\u0002\b\u0007\u0012\f\u0010q\u001a\b\u0012\u0004\u0012\u00020p0B\u0012\u0006\u0010Y\u001a\u00020S\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010Z\u001a\u00020V\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010]\u001a\u00020\\\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0B\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0B\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020[0B\u0012\f\u0010`\u001a\b\u0012\u0004\u0012\u00020_0B\u0012\f\u0010b\u001a\b\u0012\u0004\u0012\u00020a0B\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0B\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020N0B\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020o0B\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0B\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0B\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020F0B\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020F0B\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020K0B\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020K0B¢\u0006\u0004\br\u0010sJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010 J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b&\u0010$J\u001f\u0010'\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010 J%\u0010(\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b(\u0010\fJ\u0017\u0010)\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b)\u0010$J%\u0010*\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b*\u0010\fJ%\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b,\u0010-J%\u0010.\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b.\u0010\fJ-\u00101\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u00100\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b1\u00102J%\u00103\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b3\u00104J-\u00105\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\u0011J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0011J+\u0010;\u001a\u00020\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b;\u0010<J\u001d\u0010=\u001a\u00020\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0002H\u0002¢\u0006\u0004\b=\u0010\u0007J\u0017\u0010>\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b>\u0010\u000fJ\u001f\u0010@\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010?\u001a\u00020!H\u0016¢\u0006\u0004\b@\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020F0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010ER\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020G0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010ER\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020I0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010ER\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010ER\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020F0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010ER\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020L0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010ER\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020N0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010ER\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020O0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010ER\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010ER\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010UR\u0014\u0010Z\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010XR\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020[0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010ER\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020K0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010ER\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020_0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010ER\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020a0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010ER\"\u0010c\u001a\u00020\b8\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010i\u001a\u00020\b8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\bi\u0010d\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR\"\u0010l\u001a\u00020\b8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\bl\u0010d\u001a\u0004\bm\u0010f\"\u0004\bn\u0010hR\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020o0B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010ER\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020p0B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bq\u0010E"}, d2 = {"Lid/dana/wallet_v3/presenter/NewWalletPresenter;", "Lid/dana/wallet_v3/presenter/NewWalletContract$Presenter;", "", "", "scenario", "", "checkIsNeedToShowTooltip", "(Ljava/util/List;)V", "", HomeTabActivity.WALLET_SECTION, "assetTypes", "compareTotalCurrentAssets$app_productionRelease", "(ILjava/util/List;)V", "accessToken", "fetchKycLevel", "(Ljava/lang/String;)V", "fetchLoyaltyAccessTokenAndKycLevel", "()V", "errorCode", "getAssetReloadIntervalTime", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getDividedAssetTypeBasedOnPaymentAndPocket", "(Ljava/util/List;)Ljava/util/Map;", "", "throwable", "getErrorCode", "(Ljava/lang/Throwable;)Ljava/lang/String;", "", "cacheDuration", "currentTimestamp", "getInvestmentAssetFromDatabase", "(JJ)V", "", "isShowShimmer", "getInvestmentCardAssets", "(Z)V", "getLoyaltyAssetFromDatabase", "getLoyaltyCardAssets", "getPaymentAssetFromDatabase", "getPaymentAssetsBasedOnAssetType", "getPaymentCardAssets", "getPocketAssetsBasedOnAssetType", "sectionType", "getPocketRedDotTotalCount", "(Ljava/lang/String;Ljava/util/List;)V", "getTotalSectionQuery", "assetType", "order", "getVoucherAndTicketAssets", "(Ljava/util/List;Ljava/lang/String;Z)V", "getVoucherAndTicketOrder", "(Ljava/util/List;Z)V", "getVoucherAssetFromDatabase", "(JJLjava/util/List;)V", "getWalletV3ConfigFromLocal", "onDestroy", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "assetInfos", "onGetInvestmentCardsSuccess", "(Ljava/util/List;Ljava/util/List;)V", "onGetPaymentCardsSuccess", "saveTooltipShown", "isReset", "updateTotalSectionQuery", "(IZ)V", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi;", "getIntervalTimeHitWalletApi", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal;", "Lid/dana/domain/account/interactor/GetKycLevel;", "getKycLevel", "Lid/dana/domain/pocket/interactor/GetLoyaltyToken;", "getLoyaltyAccessToken", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAssetLocal;", "Lid/dana/domain/wallet_v3/interactor/GetPocketRedDotAsset;", "getPocketRedDotAsset", "Lid/dana/domain/wallet_v3/interactor/GetTotalSectionQuery;", "Lid/dana/domain/wallet_v3/interactor/GetTotalUserPaymentAsset;", "getTotalUserPaymentAsset", "Lid/dana/domain/wallet_v3/interactor/GetTotalUserPocketAsset;", "getTotalUserPocketAsset", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;", "getUserInvestmentWalletAsset", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "getUserLoyaltyWalletAsset", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "getUserPaymentWalletAsset", "getUserPocketWalletAsset", "Lid/dana/domain/wallet_v3/interactor/GetVoucherAndTicketOrder;", "Lid/dana/domain/wallet_v3/interactor/GetWalletConfigFromLocal;", "getWalletConfigFromLocal", "Lid/dana/domain/wallet_v3/interactor/GetWalletConfigFromLocal;", "Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;", "isNeedToShowToolTip", "Lid/dana/domain/usereducation/interactor/SaveShowToolTip;", "saveShowToolTip", "totalInvestmentAssets", "I", "getTotalInvestmentAssets$app_productionRelease", "()I", "setTotalInvestmentAssets$app_productionRelease", "(I)V", "totalLoyaltyAssets", "getTotalLoyaltyAssets$app_productionRelease", "setTotalLoyaltyAssets$app_productionRelease", "totalVoucherAssets", "getTotalVoucherAssets$app_productionRelease", "setTotalVoucherAssets$app_productionRelease", "Lid/dana/domain/wallet_v3/interactor/UpdateTotalSectionQuery;", "Lid/dana/wallet_v3/presenter/NewWalletContract$View;", "view", "<init>", "(Ldagger/Lazy;Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;Lid/dana/domain/wallet_v3/interactor/GetWalletConfigFromLocal;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NewWalletPresenter implements NewWalletContract.Presenter {
    private static final int MAXIMUM_QUERY = 2;
    private static final String UNKNOWN_ERROR = "unknown_error";
    private final Lazy<GetIntervalTimeHitWalletApi> getIntervalTimeHitWalletApi;
    private final Lazy<GetUserPaymentWalletAssetLocal> getInvestmentAssetFromDatabase;
    private final Lazy<GetKycLevel> getKycLevel;
    private final Lazy<GetLoyaltyToken> getLoyaltyAccessToken;
    private final Lazy<GetUserPocketWalletAssetLocal> getLoyaltyAssetFromDatabase;
    private final Lazy<GetUserPaymentWalletAssetLocal> getPaymentAssetFromDatabase;
    private final Lazy<GetPocketRedDotAsset> getPocketRedDotAsset;
    private final Lazy<GetTotalSectionQuery> getTotalSectionQuery;
    private final Lazy<GetTotalUserPaymentAsset> getTotalUserPaymentAsset;
    private final Lazy<GetTotalUserPocketAsset> getTotalUserPocketAsset;
    private final GetUserPaymentWalletAsset getUserInvestmentWalletAsset;
    private final GetUserPocketWalletAsset getUserLoyaltyWalletAsset;
    private final GetUserPaymentWalletAsset getUserPaymentWalletAsset;
    private final GetUserPocketWalletAsset getUserPocketWalletAsset;
    private final Lazy<GetVoucherAndTicketOrder> getVoucherAndTicketOrder;
    private final Lazy<GetUserPocketWalletAssetLocal> getVoucherAssetFromDatabase;
    private final GetWalletConfigFromLocal getWalletConfigFromLocal;
    private final Lazy<IsNeedToShowToolTip> isNeedToShowToolTip;
    private final Lazy<SaveShowToolTip> saveShowToolTip;
    private int totalInvestmentAssets;
    private int totalLoyaltyAssets;
    private int totalVoucherAssets;
    private final Lazy<UpdateTotalSectionQuery> updateTotalSectionQuery;
    private final Lazy<NewWalletContract.View> view;

    @Inject
    public NewWalletPresenter(Lazy<NewWalletContract.View> lazy, GetUserPaymentWalletAsset getUserPaymentWalletAsset, GetUserPaymentWalletAsset getUserPaymentWalletAsset2, GetUserPocketWalletAsset getUserPocketWalletAsset, GetUserPocketWalletAsset getUserPocketWalletAsset2, GetWalletConfigFromLocal getWalletConfigFromLocal, Lazy<GetKycLevel> lazy2, Lazy<GetLoyaltyToken> lazy3, Lazy<GetVoucherAndTicketOrder> lazy4, Lazy<IsNeedToShowToolTip> lazy5, Lazy<SaveShowToolTip> lazy6, Lazy<GetPocketRedDotAsset> lazy7, Lazy<GetTotalSectionQuery> lazy8, Lazy<UpdateTotalSectionQuery> lazy9, Lazy<GetTotalUserPaymentAsset> lazy10, Lazy<GetTotalUserPocketAsset> lazy11, Lazy<GetIntervalTimeHitWalletApi> lazy12, Lazy<GetUserPaymentWalletAssetLocal> lazy13, Lazy<GetUserPaymentWalletAssetLocal> lazy14, Lazy<GetUserPocketWalletAssetLocal> lazy15, Lazy<GetUserPocketWalletAssetLocal> lazy16) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(getUserPaymentWalletAsset, "");
        Intrinsics.checkNotNullParameter(getUserPaymentWalletAsset2, "");
        Intrinsics.checkNotNullParameter(getUserPocketWalletAsset, "");
        Intrinsics.checkNotNullParameter(getUserPocketWalletAsset2, "");
        Intrinsics.checkNotNullParameter(getWalletConfigFromLocal, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        Intrinsics.checkNotNullParameter(lazy15, "");
        Intrinsics.checkNotNullParameter(lazy16, "");
        this.view = lazy;
        this.getUserPaymentWalletAsset = getUserPaymentWalletAsset;
        this.getUserInvestmentWalletAsset = getUserPaymentWalletAsset2;
        this.getUserPocketWalletAsset = getUserPocketWalletAsset;
        this.getUserLoyaltyWalletAsset = getUserPocketWalletAsset2;
        this.getWalletConfigFromLocal = getWalletConfigFromLocal;
        this.getKycLevel = lazy2;
        this.getLoyaltyAccessToken = lazy3;
        this.getVoucherAndTicketOrder = lazy4;
        this.isNeedToShowToolTip = lazy5;
        this.saveShowToolTip = lazy6;
        this.getPocketRedDotAsset = lazy7;
        this.getTotalSectionQuery = lazy8;
        this.updateTotalSectionQuery = lazy9;
        this.getTotalUserPaymentAsset = lazy10;
        this.getTotalUserPocketAsset = lazy11;
        this.getIntervalTimeHitWalletApi = lazy12;
        this.getPaymentAssetFromDatabase = lazy13;
        this.getInvestmentAssetFromDatabase = lazy14;
        this.getVoucherAssetFromDatabase = lazy15;
        this.getLoyaltyAssetFromDatabase = lazy16;
    }

    @JvmName(name = "getTotalInvestmentAssets$app_productionRelease")
    /* renamed from: getTotalInvestmentAssets$app_productionRelease  reason: from getter */
    public final int getTotalInvestmentAssets() {
        return this.totalInvestmentAssets;
    }

    @JvmName(name = "setTotalInvestmentAssets$app_productionRelease")
    public final void setTotalInvestmentAssets$app_productionRelease(int i) {
        this.totalInvestmentAssets = i;
    }

    @JvmName(name = "getTotalVoucherAssets$app_productionRelease")
    /* renamed from: getTotalVoucherAssets$app_productionRelease  reason: from getter */
    public final int getTotalVoucherAssets() {
        return this.totalVoucherAssets;
    }

    @JvmName(name = "setTotalVoucherAssets$app_productionRelease")
    public final void setTotalVoucherAssets$app_productionRelease(int i) {
        this.totalVoucherAssets = i;
    }

    @JvmName(name = "getTotalLoyaltyAssets$app_productionRelease")
    /* renamed from: getTotalLoyaltyAssets$app_productionRelease  reason: from getter */
    public final int getTotalLoyaltyAssets() {
        return this.totalLoyaltyAssets;
    }

    @JvmName(name = "setTotalLoyaltyAssets$app_productionRelease")
    public final void setTotalLoyaltyAssets$app_productionRelease(int i) {
        this.totalLoyaltyAssets = i;
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getPaymentCardAssets(boolean isShowShimmer) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.BALANCE.getAsset(), CardAssetType.CREDIT_CARD.getAsset(), CardAssetType.DEBIT_CARD.getAsset(), CardAssetType.PAYLATER.getAsset()});
        if (isShowShimmer) {
            this.view.get().onLoadingGetPaymentCardAssets();
        }
        this.getUserPaymentWalletAsset.execute(new GetUserPaymentWalletAsset.Param(listOf), new Function1<Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPaymentCardAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>> pair) {
                invoke2((Pair<? extends List<UserAssetInfosModel>, ? extends Map<String, String>>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends List<UserAssetInfosModel>, ? extends Map<String, String>> pair) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(pair, "");
                List<UserAssetInfosModel> component1 = pair.component1();
                Map<String, String> component2 = pair.component2();
                NewWalletPresenter.this.onGetPaymentCardsSuccess(component1);
                if ((!component2.isEmpty()) == false) {
                    component2 = null;
                }
                if (component2 != null) {
                    NewWalletPresenter newWalletPresenter = NewWalletPresenter.this;
                    for (String str : component2.values()) {
                        lazy2 = newWalletPresenter.view;
                        ((NewWalletContract.View) lazy2.get()).onErrorGetPaymentCardAssets(str);
                    }
                }
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetPaymentCardAssets();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPaymentCardAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String errorCode;
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                errorCode = NewWalletPresenter.this.getErrorCode(th);
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetPaymentCardAssets();
                lazy2 = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy2.get()).onErrorGetPaymentCardAssets(errorCode);
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getInvestmentCardAssets(boolean isShowShimmer) {
        if (isShowShimmer) {
            this.view.get().onLoadingGetInvestmentCardAssets();
        }
        final List listOf = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.EMAS.getAsset(), CardAssetType.DANA_PLUS.getAsset(), CardAssetType.GOALS.getAsset()});
        this.getUserInvestmentWalletAsset.execute(new GetUserPaymentWalletAsset.Param(listOf), new Function1<Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getInvestmentCardAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>> pair) {
                invoke2((Pair<? extends List<UserAssetInfosModel>, ? extends Map<String, String>>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends List<UserAssetInfosModel>, ? extends Map<String, String>> pair) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(pair, "");
                List<UserAssetInfosModel> component1 = pair.component1();
                Map<String, String> component2 = pair.component2();
                NewWalletPresenter.this.onGetInvestmentCardsSuccess(component1, listOf);
                if ((!component2.isEmpty()) == false) {
                    component2 = null;
                }
                if (component2 != null) {
                    NewWalletPresenter newWalletPresenter = NewWalletPresenter.this;
                    for (String str : component2.values()) {
                        lazy2 = newWalletPresenter.view;
                        ((NewWalletContract.View) lazy2.get()).onErrorGetInvestmentCardAssets(str);
                    }
                }
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetInvestmentCardAssets();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getInvestmentCardAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String errorCode;
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                errorCode = NewWalletPresenter.this.getErrorCode(th);
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetInvestmentCardAssets();
                lazy2 = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy2.get()).onErrorGetInvestmentCardAssets(errorCode);
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getVoucherAndTicketOrder(final List<String> assetType, final boolean isShowShimmer) {
        Intrinsics.checkNotNullParameter(assetType, "");
        this.getVoucherAndTicketOrder.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAndTicketOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                NewWalletPresenter.this.getVoucherAndTicketAssets(assetType, str, isShowShimmer);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAndTicketOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                NewWalletPresenter.this.getVoucherAndTicketAssets(assetType, AssetStatus.EXPIRING_SOON.name(), isShowShimmer);
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getPocketRedDotTotalCount(final String sectionType, List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(sectionType, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        GetPocketRedDotAsset getPocketRedDotAsset = this.getPocketRedDotAsset.get();
        Intrinsics.checkNotNullExpressionValue(getPocketRedDotAsset, "");
        BaseUseCase.execute$default(getPocketRedDotAsset, new GetPocketRedDotAsset.Param(0, 0, null, assetTypes, 7, null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPocketRedDotTotalCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                if (Intrinsics.areEqual(sectionType, "VOUCHER_AND_TICKET")) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onSuccessGetVoucherAndTicketRedDotTotalCount(userPocketAssetListModel.getTotalCount());
                }
            }
        }, null, 4, null);
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getVoucherAndTicketAssets(final List<String> assetType, String order, boolean isShowShimmer) {
        Intrinsics.checkNotNullParameter(assetType, "");
        Intrinsics.checkNotNullParameter(order, "");
        if (isShowShimmer) {
            this.view.get().onLoadingGetVoucherAndTicketAssets();
        }
        this.getUserPocketWalletAsset.execute(new GetUserPocketWalletAsset.Param(1, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING}), assetType, order), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAndTicketAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                NewWalletPresenter.this.setTotalVoucherAssets$app_productionRelease(userPocketAssetListModel.getPockets().size());
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetVoucherAndTicketAssets();
                if (!userPocketAssetListModel.getPockets().isEmpty()) {
                    lazy2 = NewWalletPresenter.this.view;
                    ((NewWalletContract.View) lazy2.get()).onSuccessGetVoucherAndTicketAssets(UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, VoucherAndTicketCardModel>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAndTicketAssets$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final VoucherAndTicketCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                            Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                            return UserPocketAssetsMapperKt.toVoucherAndTicketCardModel(userPocketAssetModel, false);
                        }
                    }));
                    NewWalletPresenter.this.getPocketRedDotTotalCount("VOUCHER_AND_TICKET", assetType);
                    return;
                }
                NewWalletPresenter.this.updateTotalSectionQuery(3, false);
                lazy3 = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy3.get()).onEmptyGetVoucherAndTicketAssets();
                NewWalletPresenter.this.getTotalSectionQuery(3, assetType);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAndTicketAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String errorCode;
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                errorCode = NewWalletPresenter.this.getErrorCode(th);
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetVoucherAndTicketAssets();
                lazy2 = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy2.get()).onErrorGetVoucherAndTicketAssets(errorCode);
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getWalletV3ConfigFromLocal() {
        this.getWalletConfigFromLocal.execute(NoParams.INSTANCE, new Function1<WalletConfig, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getWalletV3ConfigFromLocal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(WalletConfig walletConfig) {
                invoke2(walletConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(WalletConfig walletConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(walletConfig, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onGetWalletV3Config(walletConfig.getWalletV3());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getWalletV3ConfigFromLocal$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r16v0, types: [id.dana.domain.wallet_v3.model.WalletV3AddAssetServices, java.lang.String] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ?? r16 = 0;
                ((NewWalletContract.View) lazy.get()).onGetWalletV3Config(new WalletV3Config(null, null, null, null, null, null, null, null, null, null, null, null, r16, r16, null, null, 65535, null));
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getLoyaltyCardAssets(boolean isShowShimmer) {
        final List listOf = CollectionsKt.listOf(AssetType.LOYALTY.getAsset());
        if (isShowShimmer) {
            this.view.get().onLoadingGetLoyaltyAssets();
        }
        this.getUserLoyaltyWalletAsset.execute(new GetUserPocketWalletAsset.Param(1, 10, CollectionsKt.listOf(AssetStatus.INIT), listOf, null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getLoyaltyCardAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                NewWalletPresenter.this.setTotalLoyaltyAssets$app_productionRelease(userPocketAssetListModel.getPockets().size());
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetLoyaltyAssets();
                if (!userPocketAssetListModel.getPockets().isEmpty()) {
                    lazy2 = NewWalletPresenter.this.view;
                    ((NewWalletContract.View) lazy2.get()).onSuccessGetLoyaltyAssets(UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, LoyaltyCardModel>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getLoyaltyCardAssets$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final LoyaltyCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                            Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                            return UserPocketAssetsMapperKt.toLoyaltyCardModel(userPocketAssetModel, false);
                        }
                    }));
                    return;
                }
                NewWalletPresenter.this.updateTotalSectionQuery(4, false);
                lazy3 = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy3.get()).onEmptyGetLoyaltyAssets();
                NewWalletPresenter.this.getTotalSectionQuery(4, listOf);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getLoyaltyCardAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String errorCode;
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                errorCode = NewWalletPresenter.this.getErrorCode(th);
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onDismissLoadingGetLoyaltyAssets();
                lazy2 = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy2.get()).onErrorGetLoyaltyAssets(errorCode);
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void fetchLoyaltyAccessTokenAndKycLevel() {
        this.getLoyaltyAccessToken.get().execute(NoParams.INSTANCE, new Function1<LoyaltyToken, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$fetchLoyaltyAccessTokenAndKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LoyaltyToken loyaltyToken) {
                invoke2(loyaltyToken);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LoyaltyToken loyaltyToken) {
                Intrinsics.checkNotNullParameter(loyaltyToken, "");
                NewWalletPresenter.this.fetchKycLevel(loyaltyToken.getAccessToken());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$fetchLoyaltyAccessTokenAndKycLevel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onFetchLoyaltyAccessTokenAndKycLevelError();
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void checkIsNeedToShowTooltip(List<String> scenario) {
        Intrinsics.checkNotNullParameter(scenario, "");
        for (final String str : scenario) {
            this.isNeedToShowToolTip.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$checkIsNeedToShowTooltip$1$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    onNext(((Boolean) obj).booleanValue());
                }

                public final void onNext(boolean isShowTooltip) {
                    Lazy lazy;
                    lazy = NewWalletPresenter.this.view;
                    ((NewWalletContract.View) lazy.get()).onShowTooltip(str, isShowTooltip);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable e) {
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(e, "");
                    lazy = NewWalletPresenter.this.view;
                    ((NewWalletContract.View) lazy.get()).onShowTooltip(str, false);
                }
            }, IsNeedToShowToolTip.Params.forShowTooltip(str));
        }
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void saveTooltipShown(String scenario) {
        Intrinsics.checkNotNullParameter(scenario, "");
        this.saveShowToolTip.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$saveTooltipShown$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable e) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(e, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onError(e.getMessage());
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(true, scenario));
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getTotalSectionQuery(final int r9, final List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(assetTypes, "");
        GetTotalSectionQuery getTotalSectionQuery = this.getTotalSectionQuery.get();
        Intrinsics.checkNotNullExpressionValue(getTotalSectionQuery, "");
        BaseUseCase.execute$default(getTotalSectionQuery, Integer.valueOf(r9), new Function1<Integer, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getTotalSectionQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i >= 2) {
                    NewWalletPresenter.this.compareTotalCurrentAssets$app_productionRelease(r9, assetTypes);
                }
            }
        }, null, 4, null);
    }

    public final void compareTotalCurrentAssets$app_productionRelease(int r4, List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Map<String, List<String>> dividedAssetTypeBasedOnPaymentAndPocket = getDividedAssetTypeBasedOnPaymentAndPocket(assetTypes);
        List<String> list = dividedAssetTypeBasedOnPaymentAndPocket.get(WalletSearchPresenter.PAYMENT_ASSET_TYPE_KEY);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<String> list2 = dividedAssetTypeBasedOnPaymentAndPocket.get(WalletSearchPresenter.POCKET_ASSET_TYPE_KEY);
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        if (assetTypes.contains(AssetType.ID_CARD.getAsset())) {
            this.view.get().onHideIdentitySection();
        } else if ((!list.isEmpty()) == true) {
            getPaymentAssetsBasedOnAssetType(r4, list);
        } else if ((!list2.isEmpty()) == true) {
            getPocketAssetsBasedOnAssetType(r4, list2);
        }
    }

    private final Map<String, List<String>> getDividedAssetTypeBasedOnPaymentAndPocket(List<String> assetTypes) {
        List<String> list = assetTypes;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (CardAssetType.INSTANCE.getValue((String) next) != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (AssetType.INSTANCE.getValue((String) obj) != null) {
                arrayList3.add(obj);
            }
        }
        return MapsKt.mapOf(TuplesKt.to(WalletSearchPresenter.PAYMENT_ASSET_TYPE_KEY, arrayList2), TuplesKt.to(WalletSearchPresenter.POCKET_ASSET_TYPE_KEY, arrayList3));
    }

    private final void getPaymentAssetsBasedOnAssetType(final int r9, List<String> assetTypes) {
        GetTotalUserPaymentAsset getTotalUserPaymentAsset = this.getTotalUserPaymentAsset.get();
        Intrinsics.checkNotNullExpressionValue(getTotalUserPaymentAsset, "");
        BaseUseCase.execute$default(getTotalUserPaymentAsset, new GetTotalUserPaymentAsset.Param(assetTypes), new Function1<Integer, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPaymentAssetsBasedOnAssetType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Lazy lazy;
                if (r9 == 2 && this.getTotalInvestmentAssets() == i) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onHideInvestmentSection();
                }
            }
        }, null, 4, null);
    }

    private final void getPocketAssetsBasedOnAssetType(final int r13, List<String> assetTypes) {
        GetTotalUserPocketAsset getTotalUserPocketAsset = this.getTotalUserPocketAsset.get();
        Intrinsics.checkNotNullExpressionValue(getTotalUserPocketAsset, "");
        GetTotalUserPocketAsset getTotalUserPocketAsset2 = getTotalUserPocketAsset;
        List listOf = CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING});
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = assetTypes.iterator();
        while (it.hasNext()) {
            String valueInString = AssetType.INSTANCE.getValueInString((String) it.next());
            if (valueInString != null) {
                arrayList.add(valueInString);
            }
        }
        BaseUseCase.execute$default(getTotalUserPocketAsset2, new GetTotalUserPocketAsset.Param(1, 10, listOf, arrayList, null, 16, null), new Function1<Integer, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPocketAssetsBasedOnAssetType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Lazy lazy;
                Lazy lazy2;
                if (r13 == 3 && this.getTotalVoucherAssets() == i) {
                    lazy2 = this.view;
                    ((NewWalletContract.View) lazy2.get()).onHideVoucherSection();
                } else if (r13 == 4 && this.getTotalLoyaltyAssets() == i) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onHideLoyaltySection();
                }
            }
        }, null, 4, null);
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void updateTotalSectionQuery(int r9, boolean isReset) {
        UpdateTotalSectionQuery updateTotalSectionQuery = this.updateTotalSectionQuery.get();
        Intrinsics.checkNotNullExpressionValue(updateTotalSectionQuery, "");
        BaseUseCase.execute$default(updateTotalSectionQuery, new UpdateTotalSectionQuery.Params(r9, isReset), new Function1<Unit, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$updateTotalSectionQuery$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getAssetReloadIntervalTime(final String r9, String errorCode) {
        Intrinsics.checkNotNullParameter(r9, "");
        Intrinsics.checkNotNullParameter(errorCode, "");
        GetIntervalTimeHitWalletApi getIntervalTimeHitWalletApi = this.getIntervalTimeHitWalletApi.get();
        Intrinsics.checkNotNullExpressionValue(getIntervalTimeHitWalletApi, "");
        BaseUseCase.execute$default(getIntervalTimeHitWalletApi, new GetIntervalTimeHitWalletApi.Param(errorCode), new Function1<Integer, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getAssetReloadIntervalTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Lazy lazy4;
                String str = r9;
                switch (str.hashCode()) {
                    case -1150817175:
                        if (str.equals("FINANCIAL")) {
                            lazy = this.view;
                            ((NewWalletContract.View) lazy.get()).onGetFinancialReloadIntervalTime(System.currentTimeMillis() + i);
                            return;
                        }
                        return;
                    case -554006299:
                        if (str.equals("VOUCHER_AND_TICKET")) {
                            lazy2 = this.view;
                            ((NewWalletContract.View) lazy2.get()).onGetVoucherAndTicketReloadIntervalTime(System.currentTimeMillis() + i);
                            return;
                        }
                        return;
                    case -68698650:
                        if (str.equals("PAYMENT")) {
                            lazy3 = this.view;
                            ((NewWalletContract.View) lazy3.get()).onGetPaymentReloadIntervalTime(System.currentTimeMillis() + i);
                            return;
                        }
                        return;
                    case 1076711462:
                        if (str.equals("LOYALTY")) {
                            lazy4 = this.view;
                            ((NewWalletContract.View) lazy4.get()).onGetLoyaltyReloadIntervalTime(System.currentTimeMillis() + i);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }, null, 4, null);
    }

    public final void fetchKycLevel(final String accessToken) {
        this.getKycLevel.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$fetchKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Lazy lazy;
                boolean z = false;
                if (str != null) {
                    if (str.length() == 0) {
                        z = true;
                    }
                }
                if (z) {
                    str = "KYC0";
                }
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onFetchLoyaltyAccessTokenAndKycLevelSuccess(accessToken, str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$fetchKycLevel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onFetchLoyaltyAccessTokenAndKycLevelError();
            }
        });
    }

    public final void onGetPaymentCardsSuccess(List<UserAssetInfosModel> assetInfos) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = assetInfos.iterator();
        while (it.hasNext()) {
            PaymentCardModel paymentCardModel = UserPaymentAssetsMapperKt.toPaymentCardModel((UserAssetInfosModel) it.next());
            if (paymentCardModel != null) {
                arrayList.add(paymentCardModel);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        if (mutableList.isEmpty()) {
            this.view.get().onEmptyGetPaymentCardAssets();
            return;
        }
        if (mutableList.size() == 1) {
            PaymentCardModel paymentCardModel2 = (PaymentCardModel) CollectionsKt.firstOrNull(mutableList);
            if (Intrinsics.areEqual(paymentCardModel2 != null ? paymentCardModel2.getAssetType() : null, CardAssetType.BALANCE.getAsset())) {
                this.view.get().onSuccessGetPaymentCardAssets(UserPaymentAssetsMapperKt.reorderAssetEmptyPlaceholderToFirst(mutableList));
                return;
            }
        }
        this.view.get().onSuccessGetPaymentCardAssets(UserPaymentAssetsMapperKt.reorderAssetBalanceToFirst(mutableList));
    }

    public final void onGetInvestmentCardsSuccess(List<UserAssetInfosModel> assetInfos, List<String> assetTypes) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = assetInfos.iterator();
        while (it.hasNext()) {
            InvestmentCardModel financialCardModel = UserPaymentAssetsMapperKt.toFinancialCardModel((UserAssetInfosModel) it.next());
            if (financialCardModel != null) {
                arrayList.add(financialCardModel);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            updateTotalSectionQuery(2, false);
            this.view.get().onEmptyGetInvestmentCardAssets();
            getTotalSectionQuery(2, assetTypes);
        } else {
            updateTotalSectionQuery(2, true);
            this.view.get().onSuccessGetInvestmentCardAssets(UserPaymentAssetsMapperKt.reorderAssetDanaPlusToFirst(CollectionsKt.toMutableList((Collection) arrayList2)));
        }
        this.totalInvestmentAssets = assetInfos.size();
    }

    public final String getErrorCode(Throwable throwable) {
        if (throwable instanceof NetworkException) {
            String errorCode = ((NetworkException) throwable).getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            return errorCode;
        }
        return UNKNOWN_ERROR;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getPaymentAssetFromDatabase(final long cacheDuration, final long currentTimestamp) {
        ?? r3 = 0;
        this.getPaymentAssetFromDatabase.get().execute(new GetUserPaymentWalletAssetLocal.Param(WalletAssetType.INSTANCE.getPaymentAssetTypes(), r3, 2, r3), new Function1<List<? extends UserAssetInfosModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPaymentAssetFromDatabase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserAssetInfosModel> list) {
                invoke2((List<UserAssetInfosModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserAssetInfosModel> list) {
                Lazy lazy;
                Lazy lazy2;
                UserAssetsModel info;
                Long cacheTimestamp;
                Intrinsics.checkNotNullParameter(list, "");
                UserAssetInfosModel userAssetInfosModel = (UserAssetInfosModel) CollectionsKt.getOrNull(list, 0);
                long longValue = (userAssetInfosModel == null || (info = userAssetInfosModel.getInfo()) == null || (cacheTimestamp = info.getCacheTimestamp()) == null) ? 0L : cacheTimestamp.longValue();
                if ((!list.isEmpty()) == false || currentTimestamp - longValue > cacheDuration) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("PAYMENT");
                    return;
                }
                this.onGetPaymentCardsSuccess(list);
                lazy2 = this.view;
                ((NewWalletContract.View) lazy2.get()).onSuccessGetAssetFromDatabase("PAYMENT");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getPaymentAssetFromDatabase$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("PAYMENT");
            }
        });
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getInvestmentAssetFromDatabase(final long cacheDuration, final long currentTimestamp) {
        ?? r3 = 0;
        this.getInvestmentAssetFromDatabase.get().execute(new GetUserPaymentWalletAssetLocal.Param(WalletAssetType.INSTANCE.getInvestmentAssetTypes(), r3, 2, r3), new Function1<List<? extends UserAssetInfosModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getInvestmentAssetFromDatabase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserAssetInfosModel> list) {
                invoke2((List<UserAssetInfosModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserAssetInfosModel> list) {
                Lazy lazy;
                Lazy lazy2;
                UserAssetsModel info;
                Long cacheTimestamp;
                Intrinsics.checkNotNullParameter(list, "");
                UserAssetInfosModel userAssetInfosModel = (UserAssetInfosModel) CollectionsKt.getOrNull(list, 0);
                long longValue = (userAssetInfosModel == null || (info = userAssetInfosModel.getInfo()) == null || (cacheTimestamp = info.getCacheTimestamp()) == null) ? 0L : cacheTimestamp.longValue();
                if ((!list.isEmpty()) == false || currentTimestamp - longValue > cacheDuration) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("FINANCIAL");
                    return;
                }
                this.onGetInvestmentCardsSuccess(list, WalletAssetType.INSTANCE.getInvestmentAssetTypes());
                lazy2 = this.view;
                ((NewWalletContract.View) lazy2.get()).onSuccessGetAssetFromDatabase("FINANCIAL");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getInvestmentAssetFromDatabase$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("FINANCIAL");
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getVoucherAssetFromDatabase(final long cacheDuration, final long currentTimestamp, List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(assetTypes, "");
        this.getVoucherAssetFromDatabase.get().execute(new GetUserPocketWalletAssetLocal.Param(1, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING}), assetTypes, null, 16, null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAssetFromDatabase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                UserPocketAssetModel userPocketAssetModel = (UserPocketAssetModel) CollectionsKt.getOrNull(userPocketAssetListModel.getPockets(), 0);
                long cacheTimestamp = userPocketAssetModel != null ? userPocketAssetModel.getCacheTimestamp() : 0L;
                NewPocketQueryListModel<VoucherAndTicketCardModel> newPocketQueryListModel = UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, VoucherAndTicketCardModel>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAssetFromDatabase$1$voucherAssets$1
                    @Override // kotlin.jvm.functions.Function1
                    public final VoucherAndTicketCardModel invoke(UserPocketAssetModel userPocketAssetModel2) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel2, "");
                        return UserPocketAssetsMapperKt.toVoucherAndTicketCardModel(userPocketAssetModel2, false);
                    }
                });
                if ((!newPocketQueryListModel.getPockets().isEmpty()) == false || currentTimestamp - cacheTimestamp > cacheDuration) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("VOUCHER_AND_TICKET");
                    return;
                }
                lazy2 = this.view;
                ((NewWalletContract.View) lazy2.get()).onSuccessGetVoucherAndTicketAssets(newPocketQueryListModel);
                lazy3 = this.view;
                ((NewWalletContract.View) lazy3.get()).onSuccessGetAssetFromDatabase("VOUCHER_AND_TICKET");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getVoucherAssetFromDatabase$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("VOUCHER_AND_TICKET");
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.NewWalletContract.Presenter
    public final void getLoyaltyAssetFromDatabase(final long cacheDuration, final long currentTimestamp) {
        this.getLoyaltyAssetFromDatabase.get().execute(new GetUserPocketWalletAssetLocal.Param(1, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.ACTIVE}), WalletAssetType.INSTANCE.getLoyaltyAssetTypes(), null, 16, null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getLoyaltyAssetFromDatabase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                UserPocketAssetModel userPocketAssetModel = (UserPocketAssetModel) CollectionsKt.getOrNull(userPocketAssetListModel.getPockets(), 0);
                long cacheTimestamp = userPocketAssetModel != null ? userPocketAssetModel.getCacheTimestamp() : 0L;
                NewPocketQueryListModel<LoyaltyCardModel> newPocketQueryListModel = UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, LoyaltyCardModel>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getLoyaltyAssetFromDatabase$1$loyaltyAssets$1
                    @Override // kotlin.jvm.functions.Function1
                    public final LoyaltyCardModel invoke(UserPocketAssetModel userPocketAssetModel2) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel2, "");
                        return UserPocketAssetsMapperKt.toLoyaltyCardModel(userPocketAssetModel2, false);
                    }
                });
                if ((!newPocketQueryListModel.getPockets().isEmpty()) == false || currentTimestamp - cacheTimestamp > cacheDuration) {
                    lazy = this.view;
                    ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("LOYALTY");
                    return;
                }
                lazy2 = this.view;
                ((NewWalletContract.View) lazy2.get()).onSuccessGetLoyaltyAssets(newPocketQueryListModel);
                lazy3 = this.view;
                ((NewWalletContract.View) lazy3.get()).onSuccessGetAssetFromDatabase("LOYALTY");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.NewWalletPresenter$getLoyaltyAssetFromDatabase$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = NewWalletPresenter.this.view;
                ((NewWalletContract.View) lazy.get()).onGetEmptyAssetFromDatabase("LOYALTY");
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getUserPaymentWalletAsset.dispose();
        this.getUserInvestmentWalletAsset.dispose();
        this.getUserPocketWalletAsset.dispose();
        this.getWalletConfigFromLocal.dispose();
        this.getLoyaltyAccessToken.get().dispose();
        this.getKycLevel.get().dispose();
        this.getUserLoyaltyWalletAsset.dispose();
        this.getVoucherAndTicketOrder.get().dispose();
        this.isNeedToShowToolTip.get().dispose();
        this.saveShowToolTip.get().dispose();
        this.getPocketRedDotAsset.get().dispose();
        this.getTotalSectionQuery.get().dispose();
        this.updateTotalSectionQuery.get().dispose();
        this.getTotalUserPaymentAsset.get().dispose();
        this.getTotalUserPocketAsset.get().dispose();
        this.getIntervalTimeHitWalletApi.get().dispose();
        this.getPaymentAssetFromDatabase.get().dispose();
        this.getInvestmentAssetFromDatabase.get().dispose();
        this.getVoucherAssetFromDatabase.get().dispose();
        this.getLoyaltyAssetFromDatabase.get().dispose();
    }
}
