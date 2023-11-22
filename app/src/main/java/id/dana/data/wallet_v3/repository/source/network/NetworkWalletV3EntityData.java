package id.dana.data.wallet_v3.repository.source.network;

import android.content.Context;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketOrderRequest;
import id.dana.data.pocket.model.PocketQueryListRequest;
import id.dana.data.pocket.model.UserStatus;
import id.dana.data.wallet_v3.model.PocketUpdateRequest;
import id.dana.data.wallet_v3.model.PocketUpdateResult;
import id.dana.data.wallet_v3.model.UserPocketAssetEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetResult;
import id.dana.data.wallet_v3.repository.WalletV3EntityData;
import id.dana.data.wallet_v3.repository.source.network.request.UserAssetsRequest;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetInfosResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001RB)\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0013\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0013\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJO\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0016¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\rH\u0016¢\u0006\u0004\b&\u0010\u001dJ%\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¢\u0006\u0004\b'\u0010\u0010JU\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010.J/\u00100\u001a\b\u0012\u0004\u0012\u00020/0\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010(\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b0\u00101J#\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b2\u0010.JU\u00103\u001a\b\u0012\u0004\u0012\u00020#0\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b3\u0010+J#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u0010.J\u001d\u00107\u001a\u00020\u00072\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\nH\u0016¢\u0006\u0004\b7\u00108J\u001d\u0010;\u001a\u00020\u00072\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\nH\u0016¢\u0006\u0004\b;\u00108J\u001d\u0010>\u001a\u00020\u00072\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\nH\u0016¢\u0006\u0004\b>\u00108J\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\u0006\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b?\u0010.J+\u0010@\u001a\b\u0012\u0004\u0012\u00020/0\r2\u0006\u0010(\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b@\u0010AJ+\u0010B\u001a\b\u0012\u0004\u0012\u00020#0\r2\u0006\u0010(\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\bB\u0010AJ%\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\r2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000bH\u0016¢\u0006\u0004\bF\u0010G"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/NetworkWalletV3EntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/wallet_v3/repository/source/network/WalletV3Facade;", "Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "", "clearAll", "()V", "Lio/reactivex/Completable;", "deleteKtpDetailInfo", "()Lio/reactivex/Completable;", "", "", "assetType", "Lio/reactivex/Observable;", "", "deleteUserPaymentAssets", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/domain/pocket/model/AssetStatus;", "assetStatus", "generateQueryKey", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/String;", "Lid/dana/data/pocket/model/UserStatus;", "userStatus", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/pocket/model/KtpAssetResult;", "getKtpDetailInfo", "()Lio/reactivex/Observable;", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "statuses", "assetTypes", "Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "getPocketRedDotAsset", "(IILjava/util/List;Ljava/util/List;Ljava/util/List;)Lio/reactivex/Observable;", "getSavedAssetTypes", "getTotalUserPaymentAssets", "cardTitle", "order", "getTotalUserPocketAssets", "(IILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "query", "getUserIdentityViaQuery", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "getUserPaymentAssets", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "getUserPaymentViaQuery", "getUserPocketAssets", "getUserPocketViaQuery", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "ktpResult", "saveKtpDetailInfo", "(Ljava/util/List;)Lio/reactivex/Completable;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "assetInfos", "saveUserPaymentAssets", "Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "pocketAssets", "saveUserPocketAssets", "searchUserIdentityAssets", "searchUserPaymentAssets", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "searchUserPocketAssets", "userId", "pocketId", "Lid/dana/data/wallet_v3/model/PocketUpdateResult;", "updateUserPocketAssets", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkWalletV3EntityData extends SecureBaseNetwork<WalletV3Facade> implements WalletV3EntityData {
    private static final String QUERY_TYPE = "queryType";
    private static final String RED_DOT = "reddot";

    @Override // id.dana.network.base.BaseNetwork
    public final Class<WalletV3Facade> getFacadeClass() {
        return WalletV3Facade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkWalletV3EntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserAssetsWrapperResult> getUserPaymentAssets(final List<String> assetType, String cardTitle) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkWalletV3EntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserAssetsWrapperResult m2219getUserPaymentAssets$lambda1;
                m2219getUserPaymentAssets$lambda1 = NetworkWalletV3EntityData.m2219getUserPaymentAssets$lambda1(assetType, this, (WalletV3Facade) obj);
                return m2219getUserPaymentAssets$lambda1;
            }
        }, UserAssetsWrapperResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPaymentAssets$lambda-1  reason: not valid java name */
    public static final UserAssetsWrapperResult m2219getUserPaymentAssets$lambda1(List list, NetworkWalletV3EntityData networkWalletV3EntityData, WalletV3Facade walletV3Facade) {
        Intrinsics.checkNotNullParameter(networkWalletV3EntityData, "");
        UserAssetsRequest userAssetsRequest = new UserAssetsRequest(null, null, null, null, list, 15, null);
        userAssetsRequest.envInfo = networkWalletV3EntityData.generateMobileEnvInfo();
        return walletV3Facade.queryUserPaymentAssets(userAssetsRequest);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable saveUserPaymentAssets(List<UserAssetInfosResult> assetInfos) {
        Intrinsics.checkNotNullParameter(assetInfos, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserAssetsWrapperResult> searchUserPaymentAssets(String cardTitle, List<String> assetType) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<Boolean> deleteUserPaymentAssets(List<String> assetType) {
        Intrinsics.checkNotNullParameter(assetType, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserPocketAssetResult> getPocketRedDotAsset(final int pageNum, final int pageSize, final List<? extends AssetStatus> statuses, final List<String> assetTypes, final List<? extends UserStatus> userStatus) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Intrinsics.checkNotNullParameter(userStatus, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkWalletV3EntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserPocketAssetResult m2218getPocketRedDotAsset$lambda3;
                m2218getPocketRedDotAsset$lambda3 = NetworkWalletV3EntityData.m2218getPocketRedDotAsset$lambda3(NetworkWalletV3EntityData.this, assetTypes, statuses, userStatus, pageNum, pageSize, (WalletV3Facade) obj);
                return m2218getPocketRedDotAsset$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPocketRedDotAsset$lambda-3  reason: not valid java name */
    public static final UserPocketAssetResult m2218getPocketRedDotAsset$lambda3(NetworkWalletV3EntityData networkWalletV3EntityData, List list, List list2, List list3, int i, int i2, WalletV3Facade walletV3Facade) {
        Intrinsics.checkNotNullParameter(networkWalletV3EntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        PocketQueryListRequest pocketQueryListRequest = new PocketQueryListRequest(networkWalletV3EntityData.generateQueryKey(list, list2, list3), i, i2, null, null, PocketOrderRequest.NEWEST.getOrder(), 24, null);
        pocketQueryListRequest.extParams = MapsKt.mapOf(new Pair(QUERY_TYPE, RED_DOT));
        pocketQueryListRequest.envInfo = networkWalletV3EntityData.generateMobileEnvInfo();
        return walletV3Facade.queryUserPocketAsset(pocketQueryListRequest);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserPocketAssetResult> getUserPocketAssets(final int pageNum, final int pageSize, final List<? extends AssetStatus> statuses, final List<String> assetTypes, String cardTitle, final String order) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkWalletV3EntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserPocketAssetResult m2220getUserPocketAssets$lambda5;
                m2220getUserPocketAssets$lambda5 = NetworkWalletV3EntityData.m2220getUserPocketAssets$lambda5(NetworkWalletV3EntityData.this, assetTypes, statuses, pageNum, pageSize, order, (WalletV3Facade) obj);
                return m2220getUserPocketAssets$lambda5;
            }
        }, UserPocketAssetResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserPocketAssets$lambda-5  reason: not valid java name */
    public static final UserPocketAssetResult m2220getUserPocketAssets$lambda5(NetworkWalletV3EntityData networkWalletV3EntityData, List list, List list2, int i, int i2, String str, WalletV3Facade walletV3Facade) {
        Intrinsics.checkNotNullParameter(networkWalletV3EntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        PocketQueryListRequest pocketQueryListRequest = new PocketQueryListRequest(networkWalletV3EntityData.generateQueryKey(list, list2), i, i2, null, null, str, 24, null);
        pocketQueryListRequest.envInfo = networkWalletV3EntityData.generateMobileEnvInfo();
        return walletV3Facade.queryUserPocketAsset(pocketQueryListRequest);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable saveUserPocketAssets(List<UserPocketAssetEntity> pocketAssets) {
        Intrinsics.checkNotNullParameter(pocketAssets, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<UserPocketAssetResult> searchUserPocketAssets(String cardTitle, List<String> assetType) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<PocketUpdateResult> updateUserPocketAssets(final String userId, final String pocketId) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(pocketId, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkWalletV3EntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PocketUpdateResult m2221updateUserPocketAssets$lambda7;
                m2221updateUserPocketAssets$lambda7 = NetworkWalletV3EntityData.m2221updateUserPocketAssets$lambda7(userId, pocketId, this, (WalletV3Facade) obj);
                return m2221updateUserPocketAssets$lambda7;
            }
        }, PocketUpdateResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUserPocketAssets$lambda-7  reason: not valid java name */
    public static final PocketUpdateResult m2221updateUserPocketAssets$lambda7(String str, String str2, NetworkWalletV3EntityData networkWalletV3EntityData, WalletV3Facade walletV3Facade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(networkWalletV3EntityData, "");
        PocketUpdateRequest pocketUpdateRequest = new PocketUpdateRequest(str, null, str2, 2, null);
        pocketUpdateRequest.envInfo = networkWalletV3EntityData.generateMobileEnvInfo();
        return walletV3Facade.updateUserPocketAsset(pocketUpdateRequest);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<KtpAssetResult> getKtpDetailInfo() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable saveKtpDetailInfo(List<KtpResult> ktpResult) {
        Intrinsics.checkNotNullParameter(ktpResult, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Completable deleteKtpDetailInfo() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<KtpAssetResult> searchUserIdentityAssets(String cardTitle) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getSavedAssetTypes() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<Integer> getTotalUserPaymentAssets(List<String> assetType) {
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<Integer> getTotalUserPocketAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle, String order) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final void clearAll() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getUserPaymentViaQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getUserPocketViaQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.WalletV3EntityData
    public final Observable<List<String>> getUserIdentityViaQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    private final String generateQueryKey(List<String> assetType, List<? extends AssetStatus> assetStatus) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n           [{\"filterList\": [\n            {\n                \"paramName\": \"ASSET_TYPE\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetType, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            }, \n            {\n                \"paramName\": \"ASSET_STATUS\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetStatus, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            },\n            ]\n           }]\n        ");
        return StringsKt.trimIndent(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ String generateQueryKey$default(NetworkWalletV3EntityData networkWalletV3EntityData, List list, List list2, List list3, int i, Object obj) {
        if ((i & 4) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        return networkWalletV3EntityData.generateQueryKey(list, list2, list3);
    }

    private final String generateQueryKey(List<String> assetType, List<? extends AssetStatus> assetStatus, List<? extends UserStatus> userStatus) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n           [{\"filterList\": [\n            {\n                \"paramName\": \"ASSET_TYPE\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetType, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            }, \n            {\n                \"paramName\": \"ASSET_STATUS\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetStatus, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            },\n            {\n                \"paramName\": \"USER_STATUS\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(userStatus, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            },\n            ]\n           }]\n        ");
        return StringsKt.trimIndent(sb.toString());
    }
}
