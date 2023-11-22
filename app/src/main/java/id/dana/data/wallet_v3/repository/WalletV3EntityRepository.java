package id.dana.data.wallet_v3.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.animation.HomeTabActivity;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.pocket.mapper.PocketQueryListResultMapperKt;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.user.UserInfoMapper;
import id.dana.data.wallet.mapper.UserAssetsMapperKt;
import id.dana.data.wallet_v3.mapper.PocketUpdateResultMapperKt;
import id.dana.data.wallet_v3.mapper.UserPocketAssetListMapperKt;
import id.dana.data.wallet_v3.mapper.WalletV3RecommendationConfigMapperKt;
import id.dana.data.wallet_v3.model.PocketUpdateResult;
import id.dana.data.wallet_v3.model.UserPocketAssetEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetResult;
import id.dana.data.wallet_v3.repository.WalletV3EntityData;
import id.dana.data.wallet_v3.repository.source.WalletV3EntityDataFactory;
import id.dana.data.wallet_v3.repository.source.local.WalletV3Preference;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetInfosResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.domain.wallet_v3.model.PocketUpdateModel;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.domain.wallet_v3.model.WalletV3RecommendationConfig;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001\u0012\u0006\u0010c\u001a\u00020b\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0016JG\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00132\u0006\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001e0\u0013H\u0016¢\u0006\u0004\b*\u0010\u0016J\u001b\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001e0\u0013H\u0016¢\u0006\u0004\b+\u0010\u0016J%\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001eH\u0016¢\u0006\u0004\b-\u0010.JK\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u00102\u001a\u00020\u001bH\u0016¢\u0006\u0004\b3\u00104J#\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001e0\u00132\u0006\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b6\u0010)J%\u00107\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001eH\u0016¢\u0006\u0004\b7\u0010.J/\u00108\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001e2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b8\u00109J#\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001e0\u00132\u0006\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b:\u0010)JQ\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e2\b\u0010;\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b<\u00101JQ\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b=\u00101J#\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001e0\u00132\u0006\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b>\u0010)J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¢\u0006\u0004\b?\u0010\u0016J\u0019\u0010A\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020\tH\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010G\u001a\u00020\t2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\t2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bI\u0010HJ\u0017\u0010L\u001a\u00020#2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u00102\u001a\u00020\u001bH\u0016¢\u0006\u0004\bN\u00104J\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u00102\u001a\u00020\u001bH\u0016¢\u0006\u0004\bO\u00104J+\u0010R\u001a\u00020\f2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0000¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\f2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010\u001eH\u0000¢\u0006\u0004\bU\u0010VJ\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010;\u001a\u00020\tH\u0016¢\u0006\u0004\bW\u0010)J\u001f\u0010X\u001a\u00020\f2\u0006\u0010@\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0002¢\u0006\u0004\bX\u0010\u000eJ#\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00132\u0006\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\bY\u0010)J+\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010/\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\bZ\u0010[J1\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00132\u0006\u0010/\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b\\\u0010[J\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u00132\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b^\u0010)R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR(\u0010e\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010VR0\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010'0j8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010r\u001a\u0004\u0018\u00010q8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR$\u0010x\u001a\u0004\u0018\u00010q8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\bx\u0010s\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR$\u0010{\u001a\u0004\u0018\u00010q8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b{\u0010s\u001a\u0004\b|\u0010u\"\u0004\b}\u0010wR\u0015\u0010\u007f\u001a\u00020~8\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/WalletV3EntityRepository;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountEntityData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "createLocalWalletV3EntityData", "()Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "createNetworkWalletV3EntityData", "", "userId", "pocketId", "", "deleteUserPocketAssets$data_productionRelease", "(Ljava/lang/String;Ljava/lang/String;)V", "instId", "", "getAndSaveLastVersionUrlTimestamp", "(Ljava/lang/String;)J", "Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "getDefaultPaymentAsset", "()Lio/reactivex/Observable;", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lid/dana/domain/wallet_v3/model/KtpInfo;", "getKtpInfoFromLocal", "getPhoneNumber", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "", "Lid/dana/domain/pocket/model/AssetStatus;", "statuses", "assetTypes", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "getPocketRedDotAsset", "(IILjava/util/List;Ljava/util/List;)Lio/reactivex/Observable;", "key", "Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "getRecommendationConfig", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getRecommendationConfigKey", "getSavedAssetTypes", "assetType", "getTotalSavedPaymentAssets", "(Ljava/util/List;)Lio/reactivex/Observable;", "cardTitle", "getTotalSavedPocketAssets", "(IILjava/util/List;Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", HomeTabActivity.WALLET_SECTION, "getTotalSectionQuery", "(I)Lio/reactivex/Observable;", "query", "getUserIdentityViaQuery", "getUserPaymentAssets", "getUserPaymentAssetsFromLocal", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "getUserPaymentViaQuery", "order", "getUserPocketAssets", "getUserPocketAssetsFromLocal", "getUserPocketViaQuery", "getVoucherAndTicketOrder", "phoneNumber", "getVoucherAndTicketOrderFromPreference", "(Ljava/lang/String;)Ljava/lang/String;", "", "isVoucherInjection", "Lid/dana/domain/wallet_v3/model/WalletV3Config;", "config", "getVoucherDefaultBackgroundColor", "(ZLid/dana/domain/wallet_v3/model/WalletV3Config;)Ljava/lang/String;", "getVoucherDefaultFontColor", "Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "pocket", "mapToUserPocketAssetModel", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "resetWalletSectionOpen", "saveIWalletSectionQuery", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "assetInfos", "saveUserPaymentAssetsToDatabase$data_productionRelease", "(Ljava/util/List;Ljava/util/List;)V", "pocketAssets", "saveUserPocketAssets$data_productionRelease", "(Ljava/util/List;)V", "saveVoucherAndTicketOrder", "saveVoucherAndTicketOrderToPreference", "searchUserIdentityAssets", "searchUserPaymentAssets", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "searchUserPocketAssets", "Lid/dana/domain/wallet_v3/model/PocketUpdateModel;", "updateUserPocketAssets", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "recommendationConfigKey", "Ljava/util/List;", "getRecommendationConfigKey$data_productionRelease", "()Ljava/util/List;", "setRecommendationConfigKey$data_productionRelease", "", "recommendationConfigMap", "Ljava/util/Map;", "getRecommendationConfigMap$data_productionRelease", "()Ljava/util/Map;", "setRecommendationConfigMap$data_productionRelease", "(Ljava/util/Map;)V", "Lio/reactivex/disposables/Disposable;", "saveUserPaymentDispose", "Lio/reactivex/disposables/Disposable;", "getSaveUserPaymentDispose$data_productionRelease", "()Lio/reactivex/disposables/Disposable;", "setSaveUserPaymentDispose$data_productionRelease", "(Lio/reactivex/disposables/Disposable;)V", "saveUserPocketDispose", "getSaveUserPocketDispose$data_productionRelease", "setSaveUserPocketDispose$data_productionRelease", "updateUserPocketDispose", "getUpdateUserPocketDispose$data_productionRelease", "setUpdateUserPocketDispose$data_productionRelease", "Lid/dana/data/user/UserInfoMapper;", "userInfoMapper", "Lid/dana/data/user/UserInfoMapper;", "Lid/dana/data/wallet_v3/repository/WalletConfigEntityRepository;", "walletConfigEntityRepository", "Lid/dana/data/wallet_v3/repository/WalletConfigEntityRepository;", "Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;", "walletV3EntityDataFactory", "Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;", "Lid/dana/data/wallet_v3/repository/source/local/WalletV3Preference;", "walletV3Preference", "Lid/dana/data/wallet_v3/repository/source/local/WalletV3Preference;", "<init>", "(Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/user/UserInfoMapper;Lid/dana/data/wallet_v3/repository/source/local/WalletV3Preference;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/wallet_v3/repository/WalletConfigEntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletV3EntityRepository implements WalletV3Repository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private List<String> recommendationConfigKey;
    private Map<String, AssetRecommendation> recommendationConfigMap;
    private Disposable saveUserPaymentDispose;
    private Disposable saveUserPocketDispose;
    private Disposable updateUserPocketDispose;
    private final UserInfoMapper userInfoMapper;
    private final WalletConfigEntityRepository walletConfigEntityRepository;
    private final WalletV3EntityDataFactory walletV3EntityDataFactory;
    private final WalletV3Preference walletV3Preference;

    @Inject
    public WalletV3EntityRepository(WalletV3EntityDataFactory walletV3EntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, UserInfoMapper userInfoMapper, WalletV3Preference walletV3Preference, ConfigEntityDataFactory configEntityDataFactory, WalletConfigEntityRepository walletConfigEntityRepository) {
        Intrinsics.checkNotNullParameter(walletV3EntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        Intrinsics.checkNotNullParameter(walletV3Preference, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(walletConfigEntityRepository, "");
        this.walletV3EntityDataFactory = walletV3EntityDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.userInfoMapper = userInfoMapper;
        this.walletV3Preference = walletV3Preference;
        this.configEntityDataFactory = configEntityDataFactory;
        this.walletConfigEntityRepository = walletConfigEntityRepository;
        this.recommendationConfigKey = CollectionsKt.emptyList();
        this.recommendationConfigMap = new LinkedHashMap();
    }

    @JvmName(name = "getRecommendationConfigKey$data_productionRelease")
    public final List<String> getRecommendationConfigKey$data_productionRelease() {
        return this.recommendationConfigKey;
    }

    @JvmName(name = "setRecommendationConfigKey$data_productionRelease")
    public final void setRecommendationConfigKey$data_productionRelease(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.recommendationConfigKey = list;
    }

    @JvmName(name = "getRecommendationConfigMap$data_productionRelease")
    public final Map<String, AssetRecommendation> getRecommendationConfigMap$data_productionRelease() {
        return this.recommendationConfigMap;
    }

    @JvmName(name = "setRecommendationConfigMap$data_productionRelease")
    public final void setRecommendationConfigMap$data_productionRelease(Map<String, AssetRecommendation> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.recommendationConfigMap = map;
    }

    @JvmName(name = "getSaveUserPaymentDispose$data_productionRelease")
    /* renamed from: getSaveUserPaymentDispose$data_productionRelease  reason: from getter */
    public final Disposable getSaveUserPaymentDispose() {
        return this.saveUserPaymentDispose;
    }

    @JvmName(name = "setSaveUserPaymentDispose$data_productionRelease")
    public final void setSaveUserPaymentDispose$data_productionRelease(Disposable disposable) {
        this.saveUserPaymentDispose = disposable;
    }

    @JvmName(name = "getSaveUserPocketDispose$data_productionRelease")
    /* renamed from: getSaveUserPocketDispose$data_productionRelease  reason: from getter */
    public final Disposable getSaveUserPocketDispose() {
        return this.saveUserPocketDispose;
    }

    @JvmName(name = "setSaveUserPocketDispose$data_productionRelease")
    public final void setSaveUserPocketDispose$data_productionRelease(Disposable disposable) {
        this.saveUserPocketDispose = disposable;
    }

    @JvmName(name = "getUpdateUserPocketDispose$data_productionRelease")
    /* renamed from: getUpdateUserPocketDispose$data_productionRelease  reason: from getter */
    public final Disposable getUpdateUserPocketDispose() {
        return this.updateUserPocketDispose;
    }

    @JvmName(name = "setUpdateUserPocketDispose$data_productionRelease")
    public final void setUpdateUserPocketDispose$data_productionRelease(Disposable disposable) {
        this.updateUserPocketDispose = disposable;
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserAssetsWrapperModel> getUserPaymentAssets(final List<String> assetType) {
        Observable<UserAssetsWrapperModel> onErrorResumeNext = WalletV3EntityData.CC.getUserPaymentAssets$default(createNetworkWalletV3EntityData(), assetType, null, 2, null).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WalletV3EntityRepository.m2197getUserPaymentAssets$lambda1(WalletV3EntityRepository.this, assetType, (UserAssetsWrapperResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperModel m2198getUserPaymentAssets$lambda2;
                m2198getUserPaymentAssets$lambda2 = WalletV3EntityRepository.m2198getUserPaymentAssets$lambda2(WalletV3EntityRepository.this, (UserAssetsWrapperResult) obj);
                return m2198getUserPaymentAssets$lambda2;
            }
        }).onErrorResumeNext(getDefaultPaymentAsset());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getUserPaymentAssets$lambda-1  reason: not valid java name */
    public static final void m2197getUserPaymentAssets$lambda1(WalletV3EntityRepository walletV3EntityRepository, List list, UserAssetsWrapperResult userAssetsWrapperResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        long currentTimeMillis = System.currentTimeMillis();
        List<UserAssetInfosResult> assetInfos = userAssetsWrapperResult.getAssetInfos();
        if (assetInfos == null) {
            assetInfos = CollectionsKt.emptyList();
        }
        List<UserAssetInfosResult> list2 = assetInfos;
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            UserAssetResult info = ((UserAssetInfosResult) it.next()).getInfo();
            if (info != null) {
                info.setCacheTimestamp(Long.valueOf(currentTimeMillis));
            }
        }
        List<UserAssetInfosResult> list3 = list2;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        walletV3EntityRepository.saveUserPaymentAssetsToDatabase$data_productionRelease(list3, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPaymentAssets$lambda-2  reason: not valid java name */
    public static final UserAssetsWrapperModel m2198getUserPaymentAssets$lambda2(final WalletV3EntityRepository walletV3EntityRepository, UserAssetsWrapperResult userAssetsWrapperResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userAssetsWrapperResult, "");
        return UserAssetsMapperKt.getAuthRequestContext(userAssetsWrapperResult, new Function1<String, Long>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$getUserPaymentAssets$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(String str) {
                long andSaveLastVersionUrlTimestamp;
                Intrinsics.checkNotNullParameter(str, "");
                andSaveLastVersionUrlTimestamp = WalletV3EntityRepository.this.getAndSaveLastVersionUrlTimestamp(str);
                return Long.valueOf(andSaveLastVersionUrlTimestamp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getAndSaveLastVersionUrlTimestamp(String instId) {
        Long lastVersionBgUrlTimestamp = this.walletV3Preference.getLastVersionBgUrlTimestamp(instId);
        if (lastVersionBgUrlTimestamp == null) {
            return this.walletV3Preference.saveLastVersionBgUrlTimestamp(instId);
        }
        if (System.currentTimeMillis() >= lastVersionBgUrlTimestamp.longValue()) {
            return this.walletV3Preference.saveLastVersionBgUrlTimestamp(instId);
        }
        return lastVersionBgUrlTimestamp.longValue();
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserAssetsWrapperModel> getUserPaymentAssetsFromLocal(List<String> assetType, String cardTitle) {
        Observable map = createLocalWalletV3EntityData().getUserPaymentAssets(assetType, cardTitle).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperModel m2199getUserPaymentAssetsFromLocal$lambda3;
                m2199getUserPaymentAssetsFromLocal$lambda3 = WalletV3EntityRepository.m2199getUserPaymentAssetsFromLocal$lambda3(WalletV3EntityRepository.this, (UserAssetsWrapperResult) obj);
                return m2199getUserPaymentAssetsFromLocal$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPaymentAssetsFromLocal$lambda-3  reason: not valid java name */
    public static final UserAssetsWrapperModel m2199getUserPaymentAssetsFromLocal$lambda3(final WalletV3EntityRepository walletV3EntityRepository, UserAssetsWrapperResult userAssetsWrapperResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userAssetsWrapperResult, "");
        return UserAssetsMapperKt.getAuthRequestContext(userAssetsWrapperResult, new Function1<String, Long>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$getUserPaymentAssetsFromLocal$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(String str) {
                long andSaveLastVersionUrlTimestamp;
                Intrinsics.checkNotNullParameter(str, "");
                andSaveLastVersionUrlTimestamp = WalletV3EntityRepository.this.getAndSaveLastVersionUrlTimestamp(str);
                return Long.valueOf(andSaveLastVersionUrlTimestamp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserPocketAssetModel mapToUserPocketAssetModel(UserPocketAssetEntity pocket) {
        String pocketType = pocket.getPocketType();
        if (Intrinsics.areEqual(pocketType, AssetType.VOUCHER.getAsset())) {
            WalletV3Config walletV3 = this.walletConfigEntityRepository.getWalletConfigFromLocal().blockingFirst().getWalletV3();
            Map<String, Object> bizInfo = pocket.getBizInfo();
            boolean z = bizInfo == null || bizInfo.isEmpty();
            Integer danaDealsVersion = walletV3.getDanaDealsVersion();
            return UserPocketAssetListMapperKt.toUserPocketAssetVoucherModel(pocket, danaDealsVersion != null ? danaDealsVersion.intValue() : 1, getVoucherDefaultBackgroundColor(z, walletV3), getVoucherDefaultFontColor(z, walletV3));
        } else if (Intrinsics.areEqual(pocketType, AssetType.DISCOUNT_COUPON.getAsset())) {
            WalletV3Config walletV32 = this.walletConfigEntityRepository.getWalletConfigFromLocal().blockingFirst().getWalletV3();
            Integer discountCouponVersion = walletV32.getDiscountCouponVersion();
            int intValue = discountCouponVersion != null ? discountCouponVersion.intValue() : 1;
            String discountCouponDefaultBackgroundColor = walletV32.getDiscountCouponDefaultBackgroundColor();
            if (discountCouponDefaultBackgroundColor == null) {
                discountCouponDefaultBackgroundColor = "";
            }
            String discountCouponDefaultFontColor = walletV32.getDiscountCouponDefaultFontColor();
            return UserPocketAssetListMapperKt.toUserPocketAssetDiscountVoucherModel(pocket, intValue, discountCouponDefaultBackgroundColor, discountCouponDefaultFontColor != null ? discountCouponDefaultFontColor : "");
        } else {
            return UserPocketAssetListMapperKt.toUserPocketAssetModel(pocket);
        }
    }

    private final String getVoucherDefaultBackgroundColor(boolean isVoucherInjection, WalletV3Config config) {
        if (isVoucherInjection) {
            String voucherInjectionDefaultBackgroundColor = config.getVoucherInjectionDefaultBackgroundColor();
            if (voucherInjectionDefaultBackgroundColor != null) {
                return voucherInjectionDefaultBackgroundColor;
            }
        } else {
            String defaultBackgroundColor = config.getDefaultBackgroundColor();
            if (defaultBackgroundColor != null) {
                return defaultBackgroundColor;
            }
        }
        return "";
    }

    private final String getVoucherDefaultFontColor(boolean isVoucherInjection, WalletV3Config config) {
        if (isVoucherInjection) {
            String voucherInjectionDefaultFontColor = config.getVoucherInjectionDefaultFontColor();
            if (voucherInjectionDefaultFontColor != null) {
                return voucherInjectionDefaultFontColor;
            }
        } else {
            String defaultFontColor = config.getDefaultFontColor();
            if (defaultFontColor != null) {
                return defaultFontColor;
            }
        }
        return "";
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserAssetsWrapperModel> searchUserPaymentAssets(String cardTitle, List<String> assetType) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        Observable map = createLocalWalletV3EntityData().searchUserPaymentAssets(cardTitle, assetType).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperModel m2209searchUserPaymentAssets$lambda4;
                m2209searchUserPaymentAssets$lambda4 = WalletV3EntityRepository.m2209searchUserPaymentAssets$lambda4(WalletV3EntityRepository.this, (UserAssetsWrapperResult) obj);
                return m2209searchUserPaymentAssets$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchUserPaymentAssets$lambda-4  reason: not valid java name */
    public static final UserAssetsWrapperModel m2209searchUserPaymentAssets$lambda4(final WalletV3EntityRepository walletV3EntityRepository, UserAssetsWrapperResult userAssetsWrapperResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userAssetsWrapperResult, "");
        return UserAssetsMapperKt.getAuthRequestContext(userAssetsWrapperResult, new Function1<String, Long>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$searchUserPaymentAssets$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(String str) {
                long andSaveLastVersionUrlTimestamp;
                Intrinsics.checkNotNullParameter(str, "");
                andSaveLastVersionUrlTimestamp = WalletV3EntityRepository.this.getAndSaveLastVersionUrlTimestamp(str);
                return Long.valueOf(andSaveLastVersionUrlTimestamp);
            }
        });
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserPocketAssetListModel<UserPocketAssetModel>> getPocketRedDotAsset(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Observable<UserPocketAssetListModel<UserPocketAssetModel>> map = WalletV3EntityData.CC.getPocketRedDotAsset$default(createNetworkWalletV3EntityData(), pageNum, pageSize, statuses, assetTypes, null, 16, null).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserPocketAssetListModel m2191getPocketRedDotAsset$lambda5;
                m2191getPocketRedDotAsset$lambda5 = WalletV3EntityRepository.m2191getPocketRedDotAsset$lambda5(WalletV3EntityRepository.this, (UserPocketAssetResult) obj);
                return m2191getPocketRedDotAsset$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPocketRedDotAsset$lambda-5  reason: not valid java name */
    public static final UserPocketAssetListModel m2191getPocketRedDotAsset$lambda5(final WalletV3EntityRepository walletV3EntityRepository, UserPocketAssetResult userPocketAssetResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userPocketAssetResult, "");
        return UserPocketAssetListMapperKt.toUserPocketAssetListModel(userPocketAssetResult, new Function1<UserPocketAssetEntity, UserPocketAssetModel>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$getPocketRedDotAsset$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserPocketAssetModel invoke(UserPocketAssetEntity userPocketAssetEntity) {
                UserPocketAssetModel mapToUserPocketAssetModel;
                Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
                mapToUserPocketAssetModel = WalletV3EntityRepository.this.mapToUserPocketAssetModel(userPocketAssetEntity);
                return mapToUserPocketAssetModel;
            }
        });
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserPocketAssetListModel<UserPocketAssetModel>> getUserPocketAssets(int pageNum, int pageSize, final List<? extends AssetStatus> statuses, List<String> assetTypes, String order) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Observable<UserPocketAssetListModel<UserPocketAssetModel>> map = WalletV3EntityData.CC.getUserPocketAssets$default(createNetworkWalletV3EntityData(), pageNum, pageSize, statuses, assetTypes, null, order, 16, null).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WalletV3EntityRepository.m2200getUserPocketAssets$lambda7(statuses, this, (UserPocketAssetResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserPocketAssetListModel m2201getUserPocketAssets$lambda8;
                m2201getUserPocketAssets$lambda8 = WalletV3EntityRepository.m2201getUserPocketAssets$lambda8(WalletV3EntityRepository.this, (UserPocketAssetResult) obj);
                return m2201getUserPocketAssets$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPocketAssets$lambda-7  reason: not valid java name */
    public static final void m2200getUserPocketAssets$lambda7(List list, WalletV3EntityRepository walletV3EntityRepository, UserPocketAssetResult userPocketAssetResult) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        if (list.contains(AssetStatus.INIT) || list.contains(AssetStatus.EXPIRING)) {
            long currentTimeMillis = System.currentTimeMillis();
            List<UserPocketAssetEntity> pockets = userPocketAssetResult.getPockets();
            Iterator<T> it = pockets.iterator();
            while (it.hasNext()) {
                ((UserPocketAssetEntity) it.next()).setCacheTimestamp(Long.valueOf(currentTimeMillis));
            }
            walletV3EntityRepository.saveUserPocketAssets$data_productionRelease(pockets);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPocketAssets$lambda-8  reason: not valid java name */
    public static final UserPocketAssetListModel m2201getUserPocketAssets$lambda8(final WalletV3EntityRepository walletV3EntityRepository, UserPocketAssetResult userPocketAssetResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userPocketAssetResult, "");
        return UserPocketAssetListMapperKt.toUserPocketAssetListModel(userPocketAssetResult, new Function1<UserPocketAssetEntity, UserPocketAssetModel>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$getUserPocketAssets$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserPocketAssetModel invoke(UserPocketAssetEntity userPocketAssetEntity) {
                UserPocketAssetModel mapToUserPocketAssetModel;
                Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
                mapToUserPocketAssetModel = WalletV3EntityRepository.this.mapToUserPocketAssetModel(userPocketAssetEntity);
                return mapToUserPocketAssetModel;
            }
        });
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserPocketAssetListModel<UserPocketAssetModel>> getUserPocketAssetsFromLocal(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Observable<UserPocketAssetListModel<UserPocketAssetModel>> map = WalletV3EntityData.CC.getUserPocketAssets$default(createLocalWalletV3EntityData(), pageNum, pageSize, statuses, assetTypes, cardTitle, null, 32, null).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserPocketAssetListModel m2202getUserPocketAssetsFromLocal$lambda9;
                m2202getUserPocketAssetsFromLocal$lambda9 = WalletV3EntityRepository.m2202getUserPocketAssetsFromLocal$lambda9(WalletV3EntityRepository.this, (UserPocketAssetResult) obj);
                return m2202getUserPocketAssetsFromLocal$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPocketAssetsFromLocal$lambda-9  reason: not valid java name */
    public static final UserPocketAssetListModel m2202getUserPocketAssetsFromLocal$lambda9(final WalletV3EntityRepository walletV3EntityRepository, UserPocketAssetResult userPocketAssetResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userPocketAssetResult, "");
        return UserPocketAssetListMapperKt.toUserPocketAssetListModel(userPocketAssetResult, new Function1<UserPocketAssetEntity, UserPocketAssetModel>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$getUserPocketAssetsFromLocal$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserPocketAssetModel invoke(UserPocketAssetEntity userPocketAssetEntity) {
                UserPocketAssetModel mapToUserPocketAssetModel;
                Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
                mapToUserPocketAssetModel = WalletV3EntityRepository.this.mapToUserPocketAssetModel(userPocketAssetEntity);
                return mapToUserPocketAssetModel;
            }
        });
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<UserPocketAssetListModel<UserPocketAssetModel>> searchUserPocketAssets(String cardTitle, List<String> assetType) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        Observable map = createLocalWalletV3EntityData().searchUserPocketAssets(cardTitle, assetType).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserPocketAssetListModel m2210searchUserPocketAssets$lambda10;
                m2210searchUserPocketAssets$lambda10 = WalletV3EntityRepository.m2210searchUserPocketAssets$lambda10(WalletV3EntityRepository.this, (UserPocketAssetResult) obj);
                return m2210searchUserPocketAssets$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchUserPocketAssets$lambda-10  reason: not valid java name */
    public static final UserPocketAssetListModel m2210searchUserPocketAssets$lambda10(final WalletV3EntityRepository walletV3EntityRepository, UserPocketAssetResult userPocketAssetResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(userPocketAssetResult, "");
        return UserPocketAssetListMapperKt.toUserPocketAssetListModel(userPocketAssetResult, new Function1<UserPocketAssetEntity, UserPocketAssetModel>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$searchUserPocketAssets$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserPocketAssetModel invoke(UserPocketAssetEntity userPocketAssetEntity) {
                UserPocketAssetModel mapToUserPocketAssetModel;
                Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
                mapToUserPocketAssetModel = WalletV3EntityRepository.this.mapToUserPocketAssetModel(userPocketAssetEntity);
                return mapToUserPocketAssetModel;
            }
        });
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<PocketUpdateModel> updateUserPocketAssets(final String pocketId) {
        Intrinsics.checkNotNullParameter(pocketId, "");
        Observable flatMap = createAccountEntityData().getUserId().flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2211updateUserPocketAssets$lambda13;
                m2211updateUserPocketAssets$lambda13 = WalletV3EntityRepository.m2211updateUserPocketAssets$lambda13(WalletV3EntityRepository.this, pocketId, (String) obj);
                return m2211updateUserPocketAssets$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUserPocketAssets$lambda-13  reason: not valid java name */
    public static final ObservableSource m2211updateUserPocketAssets$lambda13(final WalletV3EntityRepository walletV3EntityRepository, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return walletV3EntityRepository.createNetworkWalletV3EntityData().updateUserPocketAssets(str2, str).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WalletV3EntityRepository.m2212updateUserPocketAssets$lambda13$lambda11(WalletV3EntityRepository.this, str2, str, (PocketUpdateResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PocketUpdateModel m2213updateUserPocketAssets$lambda13$lambda12;
                m2213updateUserPocketAssets$lambda13$lambda12 = WalletV3EntityRepository.m2213updateUserPocketAssets$lambda13$lambda12((PocketUpdateResult) obj);
                return m2213updateUserPocketAssets$lambda13$lambda12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUserPocketAssets$lambda-13$lambda-11  reason: not valid java name */
    public static final void m2212updateUserPocketAssets$lambda13$lambda11(WalletV3EntityRepository walletV3EntityRepository, String str, String str2, PocketUpdateResult pocketUpdateResult) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (pocketUpdateResult.success) {
            walletV3EntityRepository.deleteUserPocketAssets$data_productionRelease(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUserPocketAssets$lambda-13$lambda-12  reason: not valid java name */
    public static final PocketUpdateModel m2213updateUserPocketAssets$lambda13$lambda12(PocketUpdateResult pocketUpdateResult) {
        Intrinsics.checkNotNullParameter(pocketUpdateResult, "");
        return PocketUpdateResultMapperKt.toPocketUpdateModel(pocketUpdateResult);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<PocketQueryList<KtpInfo>> getKtpInfoFromLocal() {
        Observable map = createLocalWalletV3EntityData().getKtpDetailInfo().map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PocketQueryList m2189getKtpInfoFromLocal$lambda14;
                m2189getKtpInfoFromLocal$lambda14 = WalletV3EntityRepository.m2189getKtpInfoFromLocal$lambda14((KtpAssetResult) obj);
                return m2189getKtpInfoFromLocal$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getKtpInfoFromLocal$lambda-14  reason: not valid java name */
    public static final PocketQueryList m2189getKtpInfoFromLocal$lambda14(KtpAssetResult ktpAssetResult) {
        Intrinsics.checkNotNullParameter(ktpAssetResult, "");
        return PocketQueryListResultMapperKt.toPocketQueryList(ktpAssetResult, WalletV3EntityRepository$getKtpInfoFromLocal$1$1.INSTANCE);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<PocketQueryList<KtpInfo>> searchUserIdentityAssets(String cardTitle) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Observable map = createLocalWalletV3EntityData().searchUserIdentityAssets(cardTitle).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PocketQueryList m2208searchUserIdentityAssets$lambda15;
                m2208searchUserIdentityAssets$lambda15 = WalletV3EntityRepository.m2208searchUserIdentityAssets$lambda15((KtpAssetResult) obj);
                return m2208searchUserIdentityAssets$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchUserIdentityAssets$lambda-15  reason: not valid java name */
    public static final PocketQueryList m2208searchUserIdentityAssets$lambda15(KtpAssetResult ktpAssetResult) {
        Intrinsics.checkNotNullParameter(ktpAssetResult, "");
        return PocketQueryListResultMapperKt.toPocketQueryList(ktpAssetResult, WalletV3EntityRepository$searchUserIdentityAssets$1$1.INSTANCE);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<List<String>> getSavedAssetTypes() {
        return createLocalWalletV3EntityData().getSavedAssetTypes();
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<String> getVoucherAndTicketOrder() {
        Observable map = getPhoneNumber().map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m2203getVoucherAndTicketOrder$lambda16;
                m2203getVoucherAndTicketOrder$lambda16 = WalletV3EntityRepository.m2203getVoucherAndTicketOrder$lambda16(WalletV3EntityRepository.this, (String) obj);
                return m2203getVoucherAndTicketOrder$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getVoucherAndTicketOrder$lambda-16  reason: not valid java name */
    public static final String m2203getVoucherAndTicketOrder$lambda16(WalletV3EntityRepository walletV3EntityRepository, String str) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return walletV3EntityRepository.getVoucherAndTicketOrderFromPreference(str);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<Unit> saveVoucherAndTicketOrder(final String order) {
        Intrinsics.checkNotNullParameter(order, "");
        Observable map = getPhoneNumber().map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Unit m2207saveVoucherAndTicketOrder$lambda17;
                m2207saveVoucherAndTicketOrder$lambda17 = WalletV3EntityRepository.m2207saveVoucherAndTicketOrder$lambda17(WalletV3EntityRepository.this, order, (String) obj);
                return m2207saveVoucherAndTicketOrder$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveVoucherAndTicketOrder$lambda-17  reason: not valid java name */
    public static final Unit m2207saveVoucherAndTicketOrder$lambda17(WalletV3EntityRepository walletV3EntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        walletV3EntityRepository.saveVoucherAndTicketOrderToPreference(str2, str);
        return Unit.INSTANCE;
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<Integer> getTotalSectionQuery(int section) {
        if (section == 2) {
            Observable<Integer> just = Observable.just(Integer.valueOf(this.walletV3Preference.getTotalInvestmentQuery()));
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        } else if (section == 3) {
            Observable<Integer> just2 = Observable.just(Integer.valueOf(this.walletV3Preference.getTotalVoucherQuery()));
            Intrinsics.checkNotNullExpressionValue(just2, "");
            return just2;
        } else if (section == 4) {
            Observable<Integer> just3 = Observable.just(Integer.valueOf(this.walletV3Preference.getTotalLoyaltyQuery()));
            Intrinsics.checkNotNullExpressionValue(just3, "");
            return just3;
        } else {
            Observable<Integer> just4 = Observable.just(Integer.valueOf(this.walletV3Preference.getTotalIdentityQuery()));
            Intrinsics.checkNotNullExpressionValue(just4, "");
            return just4;
        }
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<Unit> saveIWalletSectionQuery(int section) {
        if (section == 2) {
            WalletV3Preference walletV3Preference = this.walletV3Preference;
            walletV3Preference.saveTotalInvestmentQuery(walletV3Preference.getTotalInvestmentQuery() + 1);
            Observable<Unit> just = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        } else if (section == 3) {
            WalletV3Preference walletV3Preference2 = this.walletV3Preference;
            walletV3Preference2.saveTotalVoucherQuery(walletV3Preference2.getTotalVoucherQuery() + 1);
            Observable<Unit> just2 = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just2, "");
            return just2;
        } else if (section == 4) {
            WalletV3Preference walletV3Preference3 = this.walletV3Preference;
            walletV3Preference3.saveTotalLoyaltyQuery(walletV3Preference3.getTotalLoyaltyQuery() + 1);
            Observable<Unit> just3 = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just3, "");
            return just3;
        } else {
            WalletV3Preference walletV3Preference4 = this.walletV3Preference;
            walletV3Preference4.saveTotalIdentityQuery(walletV3Preference4.getTotalIdentityQuery() + 1);
            Observable<Unit> just4 = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just4, "");
            return just4;
        }
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<Unit> resetWalletSectionOpen(int section) {
        if (section == 2) {
            this.walletV3Preference.resetTotalInvestmentQuery();
            Observable<Unit> just = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        } else if (section == 3) {
            this.walletV3Preference.resetTotalVoucherQuery();
            Observable<Unit> just2 = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just2, "");
            return just2;
        } else if (section == 4) {
            this.walletV3Preference.resetTotalLoyaltyQuery();
            Observable<Unit> just3 = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just3, "");
            return just3;
        } else {
            this.walletV3Preference.resetTotalIdentityQuery();
            Observable<Unit> just4 = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just4, "");
            return just4;
        }
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<Integer> getTotalSavedPaymentAssets(List<String> assetType) {
        return createLocalWalletV3EntityData().getTotalUserPaymentAssets(assetType);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<Integer> getTotalSavedPocketAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        return WalletV3EntityData.CC.getTotalUserPocketAssets$default(createLocalWalletV3EntityData(), pageNum, pageSize, statuses, assetTypes, cardTitle, null, 32, null);
    }

    private final Observable<UserAssetsWrapperModel> getDefaultPaymentAsset() {
        Observable map = createAccountEntityData().getAccount().map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAssetsWrapperModel m2188getDefaultPaymentAsset$lambda18;
                m2188getDefaultPaymentAsset$lambda18 = WalletV3EntityRepository.m2188getDefaultPaymentAsset$lambda18(WalletV3EntityRepository.this, (AccountEntity) obj);
                return m2188getDefaultPaymentAsset$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDefaultPaymentAsset$lambda-18  reason: not valid java name */
    public static final UserAssetsWrapperModel m2188getDefaultPaymentAsset$lambda18(WalletV3EntityRepository walletV3EntityRepository, AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return walletV3EntityRepository.userInfoMapper.toUserAssetsWrapperModel(accountEntity);
    }

    public final void saveUserPaymentAssetsToDatabase$data_productionRelease(final List<UserAssetInfosResult> assetInfos, List<String> assetType) {
        Intrinsics.checkNotNullParameter(assetInfos, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        Completable flatMapCompletable = WalletV3EntityData.CC.getUserPaymentAssets$default(createLocalWalletV3EntityData(), assetType, null, 2, null).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2204saveUserPaymentAssetsToDatabase$lambda21;
                m2204saveUserPaymentAssetsToDatabase$lambda21 = WalletV3EntityRepository.m2204saveUserPaymentAssetsToDatabase$lambda21(assetInfos, (UserAssetsWrapperResult) obj);
                return m2204saveUserPaymentAssetsToDatabase$lambda21;
            }
        }).flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2205saveUserPaymentAssetsToDatabase$lambda22;
                m2205saveUserPaymentAssetsToDatabase$lambda22 = WalletV3EntityRepository.m2205saveUserPaymentAssetsToDatabase$lambda22(WalletV3EntityRepository.this, (List) obj);
                return m2205saveUserPaymentAssetsToDatabase$lambda22;
            }
        }).flatMapCompletable(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource m2206saveUserPaymentAssetsToDatabase$lambda23;
                m2206saveUserPaymentAssetsToDatabase$lambda23 = WalletV3EntityRepository.m2206saveUserPaymentAssetsToDatabase$lambda23(WalletV3EntityRepository.this, assetInfos, (Boolean) obj);
                return m2206saveUserPaymentAssetsToDatabase$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "");
        this.saveUserPaymentDispose = SubscribersKt.BuiltInFictitiousFunctionClassFactory(flatMapCompletable, new Function1<Throwable, Unit>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$saveUserPaymentAssetsToDatabase$4
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
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("WalletV3", th.getMessage(), th);
                Disposable saveUserPaymentDispose = WalletV3EntityRepository.this.getSaveUserPaymentDispose();
                if (saveUserPaymentDispose != null) {
                    saveUserPaymentDispose.dispose();
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$saveUserPaymentAssetsToDatabase$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Disposable saveUserPaymentDispose = WalletV3EntityRepository.this.getSaveUserPaymentDispose();
                if (saveUserPaymentDispose != null) {
                    saveUserPaymentDispose.dispose();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveUserPaymentAssetsToDatabase$lambda-21  reason: not valid java name */
    public static final List m2204saveUserPaymentAssetsToDatabase$lambda21(List list, UserAssetsWrapperResult userAssetsWrapperResult) {
        boolean z;
        UserAssetResult info;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(userAssetsWrapperResult, "");
        List<UserAssetInfosResult> assetInfos = userAssetsWrapperResult.getAssetInfos();
        if (assetInfos == null || assetInfos.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<UserAssetInfosResult> assetInfos2 = userAssetsWrapperResult.getAssetInfos();
        ArrayList arrayList = new ArrayList();
        for (UserAssetInfosResult userAssetInfosResult : assetInfos2) {
            List<UserAssetInfosResult> list2 = list;
            String str = null;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (UserAssetInfosResult userAssetInfosResult2 : list2) {
                    UserAssetResult info2 = userAssetInfosResult.getInfo();
                    String uniqueId = info2 != null ? info2.getUniqueId() : null;
                    UserAssetResult info3 = userAssetInfosResult2.getInfo();
                    if (Intrinsics.areEqual(uniqueId, info3 != null ? info3.getUniqueId() : null)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z && (info = userAssetInfosResult.getInfo()) != null) {
                str = info.getUniqueId();
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveUserPaymentAssetsToDatabase$lambda-22  reason: not valid java name */
    public static final ObservableSource m2205saveUserPaymentAssetsToDatabase$lambda22(WalletV3EntityRepository walletV3EntityRepository, List list) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        return walletV3EntityRepository.createLocalWalletV3EntityData().deleteUserPaymentAssets(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveUserPaymentAssetsToDatabase$lambda-23  reason: not valid java name */
    public static final CompletableSource m2206saveUserPaymentAssetsToDatabase$lambda23(WalletV3EntityRepository walletV3EntityRepository, List list, Boolean bool) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return walletV3EntityRepository.createLocalWalletV3EntityData().saveUserPaymentAssets(list);
    }

    public final void saveUserPocketAssets$data_productionRelease(List<UserPocketAssetEntity> pocketAssets) {
        WalletV3EntityData createLocalWalletV3EntityData = createLocalWalletV3EntityData();
        if (pocketAssets == null) {
            pocketAssets = CollectionsKt.emptyList();
        }
        this.saveUserPocketDispose = SubscribersKt.BuiltInFictitiousFunctionClassFactory(createLocalWalletV3EntityData.saveUserPocketAssets(pocketAssets), new Function1<Throwable, Unit>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$saveUserPocketAssets$1
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
                Intrinsics.checkNotNullParameter(th, "");
                Disposable saveUserPocketDispose = WalletV3EntityRepository.this.getSaveUserPocketDispose();
                if (saveUserPocketDispose != null) {
                    saveUserPocketDispose.dispose();
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory("WalletV3", th.getMessage(), th);
            }
        }, new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$saveUserPocketAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Disposable saveUserPocketDispose = WalletV3EntityRepository.this.getSaveUserPocketDispose();
                if (saveUserPocketDispose != null) {
                    saveUserPocketDispose.dispose();
                }
            }
        });
    }

    public final void deleteUserPocketAssets$data_productionRelease(String userId, String pocketId) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(pocketId, "");
        this.updateUserPocketDispose = SubscribersKt.MyBillsEntityDataFactory(createLocalWalletV3EntityData().updateUserPocketAssets(userId, pocketId), new Function1<Throwable, Unit>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$deleteUserPocketAssets$1
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
                Intrinsics.checkNotNullParameter(th, "");
                Disposable updateUserPocketDispose = WalletV3EntityRepository.this.getUpdateUserPocketDispose();
                if (updateUserPocketDispose != null) {
                    updateUserPocketDispose.dispose();
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory("WalletV3", th.getMessage(), th);
            }
        }, new Function0<Unit>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$deleteUserPocketAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Disposable updateUserPocketDispose = WalletV3EntityRepository.this.getUpdateUserPocketDispose();
                if (updateUserPocketDispose != null) {
                    updateUserPocketDispose.dispose();
                }
            }
        });
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<List<String>> getRecommendationConfigKey() {
        if (this.recommendationConfigKey.isEmpty()) {
            Observable<List<String>> doOnNext = this.configEntityDataFactory.createData2("split").getWalletV3RecommendationConfigKey().onErrorReturnItem(new Function0<List<? extends String>>() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$getRecommendationConfigKey$local$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends String> invoke() {
                    WalletV3Preference walletV3Preference;
                    walletV3Preference = WalletV3EntityRepository.this.walletV3Preference;
                    List<String> recommendationConfigKey = walletV3Preference.getRecommendationConfigKey();
                    return recommendationConfigKey == null ? CollectionsKt.emptyList() : recommendationConfigKey;
                }
            }.invoke()).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda17
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WalletV3EntityRepository.m2196getRecommendationConfigKey$lambda24(WalletV3EntityRepository.this, (List) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            return doOnNext;
        }
        Observable<List<String>> just = Observable.just(this.recommendationConfigKey);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecommendationConfigKey$lambda-24  reason: not valid java name */
    public static final void m2196getRecommendationConfigKey$lambda24(WalletV3EntityRepository walletV3EntityRepository, List list) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullExpressionValue(list, "");
        walletV3EntityRepository.recommendationConfigKey = list;
        walletV3EntityRepository.walletV3Preference.saveRecommendationConfigKey(list);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<AssetRecommendation> getRecommendationConfig(final String key) {
        Intrinsics.checkNotNullParameter(key, "");
        if (this.recommendationConfigMap.get(key) == null) {
            Observable<AssetRecommendation> doOnNext = this.configEntityDataFactory.createData2("split").getWalletV3RecommendationConfig(key).onErrorReturn(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    WalletV3RecommendationConfig m2192getRecommendationConfig$lambda25;
                    m2192getRecommendationConfig$lambda25 = WalletV3EntityRepository.m2192getRecommendationConfig$lambda25(WalletV3EntityRepository.this, key, (Throwable) obj);
                    return m2192getRecommendationConfig$lambda25;
                }
            }).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WalletV3EntityRepository.m2193getRecommendationConfig$lambda26(WalletV3EntityRepository.this, key, (WalletV3RecommendationConfig) obj);
                }
            }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    AssetRecommendation m2194getRecommendationConfig$lambda27;
                    m2194getRecommendationConfig$lambda27 = WalletV3EntityRepository.m2194getRecommendationConfig$lambda27((WalletV3RecommendationConfig) obj);
                    return m2194getRecommendationConfig$lambda27;
                }
            }).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WalletV3EntityRepository.m2195getRecommendationConfig$lambda28(WalletV3EntityRepository.this, key, (AssetRecommendation) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            return doOnNext;
        }
        Observable<AssetRecommendation> just = Observable.just(this.recommendationConfigMap.get(key));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecommendationConfig$lambda-25  reason: not valid java name */
    public static final WalletV3RecommendationConfig m2192getRecommendationConfig$lambda25(WalletV3EntityRepository walletV3EntityRepository, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        WalletV3RecommendationConfig recommendationConfig = walletV3EntityRepository.walletV3Preference.getRecommendationConfig(str);
        if (recommendationConfig != null) {
            return recommendationConfig;
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecommendationConfig$lambda-26  reason: not valid java name */
    public static final void m2193getRecommendationConfig$lambda26(WalletV3EntityRepository walletV3EntityRepository, String str, WalletV3RecommendationConfig walletV3RecommendationConfig) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        WalletV3Preference walletV3Preference = walletV3EntityRepository.walletV3Preference;
        Intrinsics.checkNotNullExpressionValue(walletV3RecommendationConfig, "");
        walletV3Preference.saveRecommendationConfig(str, walletV3RecommendationConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecommendationConfig$lambda-27  reason: not valid java name */
    public static final AssetRecommendation m2194getRecommendationConfig$lambda27(WalletV3RecommendationConfig walletV3RecommendationConfig) {
        Intrinsics.checkNotNullParameter(walletV3RecommendationConfig, "");
        return WalletV3RecommendationConfigMapperKt.toAssetRecommendation(walletV3RecommendationConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecommendationConfig$lambda-28  reason: not valid java name */
    public static final void m2195getRecommendationConfig$lambda28(WalletV3EntityRepository walletV3EntityRepository, String str, AssetRecommendation assetRecommendation) {
        Intrinsics.checkNotNullParameter(walletV3EntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        walletV3EntityRepository.recommendationConfigMap.put(str, assetRecommendation);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<List<String>> getUserPaymentViaQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "");
        return createLocalWalletV3EntityData().getUserPaymentViaQuery(query);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<List<String>> getUserPocketViaQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "");
        return createLocalWalletV3EntityData().getUserPocketViaQuery(query);
    }

    @Override // id.dana.domain.wallet_v3.repository.WalletV3Repository
    public final Observable<List<String>> getUserIdentityViaQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "");
        return createLocalWalletV3EntityData().getUserIdentityViaQuery(query);
    }

    private final String getVoucherAndTicketOrderFromPreference(String phoneNumber) {
        return this.walletV3Preference.getVoucherAndTicketOrder(phoneNumber);
    }

    private final void saveVoucherAndTicketOrderToPreference(String phoneNumber, String order) {
        this.walletV3Preference.saveVoucherAndTicketOrder(phoneNumber, order);
    }

    private final Observable<String> getPhoneNumber() {
        Observable map = createAccountEntityData().getAccount().map(new Function() { // from class: id.dana.data.wallet_v3.repository.WalletV3EntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m2190getPhoneNumber$lambda29;
                m2190getPhoneNumber$lambda29 = WalletV3EntityRepository.m2190getPhoneNumber$lambda29((AccountEntity) obj);
                return m2190getPhoneNumber$lambda29;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPhoneNumber$lambda-29  reason: not valid java name */
    public static final String m2190getPhoneNumber$lambda29(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        return phoneNumber == null ? "" : phoneNumber;
    }

    private final WalletV3EntityData createNetworkWalletV3EntityData() {
        return this.walletV3EntityDataFactory.createData2("network");
    }

    private final WalletV3EntityData createLocalWalletV3EntityData() {
        return this.walletV3EntityDataFactory.createData2("local");
    }

    private final AccountEntityData createAccountEntityData() {
        return this.accountEntityDataFactory.createData2("local");
    }
}
