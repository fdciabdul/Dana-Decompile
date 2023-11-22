package id.dana.data.wallet_v3.repository.source.network;

import android.content.Context;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.pocket.model.AssetType;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketQueryListRequest;
import id.dana.data.pocket.model.PocketQueryListResult;
import id.dana.data.wallet_v3.repository.source.network.request.VerifyPinKtpRequest;
import id.dana.data.wallet_v3.repository.source.network.result.InsuranceResult;
import id.dana.data.wallet_v3.repository.source.network.result.KycStatusResult;
import id.dana.data.wallet_v3.repository.source.network.result.VerifyPinKtpResult;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B)\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002¢\u0006\u0004\b\r\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J%\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b$\u0010\u001fJ\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\tJ\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\tJ%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010)J%\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00062\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010."}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/NetworkPersonalTabEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/wallet_v3/repository/source/network/PersonalTabFacade;", "Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityData;", "", "phoneNumber", "Lio/reactivex/Observable;", "", "checkKtpPopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/data/pocket/model/AssetType;", "assetType", "generateQueryKey", "(Ljava/util/List;)Ljava/lang/String;", "Lid/dana/domain/pocket/model/AssetStatus;", "assetStatus", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/String;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "statuses", "Lid/dana/data/pocket/model/PocketQueryListResult;", "Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "getInsuranceAssets", "(IILjava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/pocket/model/KtpAssetResult;", "getKtpInfo", "(II)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "getMobileEnvInfo", "()Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;", "getUserKYCStatus", "isFirstTimeCheck", "saveFirstTimeCheck", "ktpIsSaved", "saveKtpPopUpCheck", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "inputPin", RecordError.KEY_PUB_KEY, "Lid/dana/data/wallet_v3/repository/source/network/result/VerifyPinKtpResult;", "verifyPinKtp", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkPersonalTabEntityData extends SecureBaseNetwork<PersonalTabFacade> implements PersonalTabEntityData {
    private static final String CHECK_KYC = "checkKYC";
    private static final String GET_KTP_SCENE = "GET_KTP";
    private static final String QUERY_TYPE = "queryType";
    private static final String VERIFICATION_METHOD_PASSWORD = "PASSWORD";
    private static final String VERIFY_SCENE_PAYMENT = "PAYMENT";

    @Override // id.dana.network.base.BaseNetwork
    public final Class<PersonalTabFacade> getFacadeClass() {
        return PersonalTabFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkPersonalTabEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> isFirstTimeCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> saveFirstTimeCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> checkKtpPopUp(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> saveKtpPopUpCheck(String phoneNumber, boolean ktpIsSaved) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<KycStatusResult> getUserKYCStatus(final int pageNum, final int pageSize) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkPersonalTabEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                KycStatusResult m2216getUserKYCStatus$lambda1;
                m2216getUserKYCStatus$lambda1 = NetworkPersonalTabEntityData.m2216getUserKYCStatus$lambda1(NetworkPersonalTabEntityData.this, pageNum, pageSize, (PersonalTabFacade) obj);
                return m2216getUserKYCStatus$lambda1;
            }
        }, KycStatusResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserKYCStatus$lambda-1  reason: not valid java name */
    public static final KycStatusResult m2216getUserKYCStatus$lambda1(NetworkPersonalTabEntityData networkPersonalTabEntityData, int i, int i2, PersonalTabFacade personalTabFacade) {
        Intrinsics.checkNotNullParameter(networkPersonalTabEntityData, "");
        PocketQueryListRequest pocketQueryListRequest = new PocketQueryListRequest(networkPersonalTabEntityData.generateQueryKey(CollectionsKt.listOf(AssetType.ID_CARD)), i, i2, null, null, null, 56, null);
        pocketQueryListRequest.extParams = MapsKt.mapOf(TuplesKt.to(QUERY_TYPE, CHECK_KYC));
        pocketQueryListRequest.envInfo = networkPersonalTabEntityData.generateMobileEnvInfo();
        return personalTabFacade.queryKycInfoAsset(pocketQueryListRequest);
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<KtpAssetResult> getKtpInfo(final int pageNum, final int pageSize) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkPersonalTabEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                KtpAssetResult m2215getKtpInfo$lambda3;
                m2215getKtpInfo$lambda3 = NetworkPersonalTabEntityData.m2215getKtpInfo$lambda3(NetworkPersonalTabEntityData.this, pageNum, pageSize, (PersonalTabFacade) obj);
                return m2215getKtpInfo$lambda3;
            }
        }, KtpAssetResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getKtpInfo$lambda-3  reason: not valid java name */
    public static final KtpAssetResult m2215getKtpInfo$lambda3(NetworkPersonalTabEntityData networkPersonalTabEntityData, int i, int i2, PersonalTabFacade personalTabFacade) {
        Intrinsics.checkNotNullParameter(networkPersonalTabEntityData, "");
        PocketQueryListRequest pocketQueryListRequest = new PocketQueryListRequest(networkPersonalTabEntityData.generateQueryKey(CollectionsKt.listOf(AssetType.ID_CARD)), i, i2, null, null, null, 56, null);
        pocketQueryListRequest.envInfo = networkPersonalTabEntityData.generateMobileEnvInfo();
        return personalTabFacade.queryKtpAsset(pocketQueryListRequest);
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<PocketQueryListResult<InsuranceResult>> getInsuranceAssets(final int pageNum, final int pageSize, final List<? extends AssetStatus> statuses) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkPersonalTabEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PocketQueryListResult m2214getInsuranceAssets$lambda5;
                m2214getInsuranceAssets$lambda5 = NetworkPersonalTabEntityData.m2214getInsuranceAssets$lambda5(NetworkPersonalTabEntityData.this, statuses, pageNum, pageSize, (PersonalTabFacade) obj);
                return m2214getInsuranceAssets$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getInsuranceAssets$lambda-5  reason: not valid java name */
    public static final PocketQueryListResult m2214getInsuranceAssets$lambda5(NetworkPersonalTabEntityData networkPersonalTabEntityData, List list, int i, int i2, PersonalTabFacade personalTabFacade) {
        Intrinsics.checkNotNullParameter(networkPersonalTabEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        PocketQueryListRequest pocketQueryListRequest = new PocketQueryListRequest(networkPersonalTabEntityData.generateQueryKey(CollectionsKt.listOf(AssetType.INSURANCE), list), i, i2, null, null, null, 56, null);
        pocketQueryListRequest.envInfo = networkPersonalTabEntityData.generateMobileEnvInfo();
        return personalTabFacade.queryInsuranceAsset(pocketQueryListRequest);
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<VerifyPinKtpResult> verifyPinKtp(final String inputPin, final String pubKey) {
        Intrinsics.checkNotNullParameter(inputPin, "");
        Intrinsics.checkNotNullParameter(pubKey, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.wallet_v3.repository.source.network.NetworkPersonalTabEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                VerifyPinKtpResult m2217verifyPinKtp$lambda7;
                m2217verifyPinKtp$lambda7 = NetworkPersonalTabEntityData.m2217verifyPinKtp$lambda7(inputPin, pubKey, this, (PersonalTabFacade) obj);
                return m2217verifyPinKtp$lambda7;
            }
        }, VerifyPinKtpResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyPinKtp$lambda-7  reason: not valid java name */
    public static final VerifyPinKtpResult m2217verifyPinKtp$lambda7(String str, String str2, NetworkPersonalTabEntityData networkPersonalTabEntityData, PersonalTabFacade personalTabFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(networkPersonalTabEntityData, "");
        String encrypt = RSAHelper.encrypt(str, str2);
        Intrinsics.checkNotNullExpressionValue(encrypt, "");
        VerifyPinKtpRequest verifyPinKtpRequest = new VerifyPinKtpRequest(encrypt, "PAYMENT", "AP_PAYMENT", "PASSWORD");
        verifyPinKtpRequest.envInfo = networkPersonalTabEntityData.getMobileEnvInfo();
        return personalTabFacade.verifyPinKtp(verifyPinKtpRequest);
    }

    private final MobileEnvInfo getMobileEnvInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", GET_KTP_SCENE);
        MobileEnvInfo generateMobileEnvInfo = generateMobileEnvInfo();
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        generateMobileEnvInfo.extendInfo = hashMap;
        return generateMobileEnvInfo;
    }

    private final String generateQueryKey(List<? extends AssetType> assetType) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n           [{\"filterList\": [\n            {\n                \"paramName\": \"ASSET_TYPE\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetType, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            },\n            ]\n           }]\n        ");
        return StringsKt.trimIndent(sb.toString());
    }

    private final String generateQueryKey(List<? extends AssetType> assetType, List<? extends AssetStatus> assetStatus) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n           [{\"filterList\": [\n            {\n                \"paramName\": \"ASSET_TYPE\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetType, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            }, \n            {\n                \"paramName\": \"ASSET_STATUS\",\n                \"paramValue\": [");
        sb.append(CollectionsKt.joinToString$default(assetStatus, "\",\"", "\"", "\"", 0, null, null, 56, null));
        sb.append("]\n            },\n            ]\n           }]\n        ");
        return StringsKt.trimIndent(sb.toString());
    }
}
