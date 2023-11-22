package id.dana.data.electronicmoney.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.electronicmoney.ElectronicMoneyFacade;
import id.dana.data.electronicmoney.ElectronicmoneyData;
import id.dana.data.electronicmoney.network.request.BrizziManualReversalRequest;
import id.dana.data.electronicmoney.network.request.ElectronicMoneyBizIdRequest;
import id.dana.data.electronicmoney.network.request.EmoneyConfirmBalanceRequest;
import id.dana.data.electronicmoney.network.request.EmoneyInquiryRequest;
import id.dana.data.electronicmoney.network.request.EmoneyReversalRequest;
import id.dana.data.electronicmoney.network.request.EmoneyTopupCommandRequest;
import id.dana.data.electronicmoney.network.response.BrizziGetAccessTokenResponse;
import id.dana.data.electronicmoney.network.response.ElectronicMoneyGetBizIdResponse;
import id.dana.data.electronicmoney.network.response.EmoneyCardInfoResponse;
import id.dana.data.electronicmoney.network.response.EmoneyReversalResponse;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.domain.electronicmoney.model.request.BrizziReversalInfo;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyBaseResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u001e\u0012\u0006\u0010\b\u001a\u00020\u001f\u0012\u0006\u0010\u0018\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\fJC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u001aJ+\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/electronicmoney/network/NetworkElectronicMoneyEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/electronicmoney/ElectronicMoneyFacade;", "Lid/dana/data/electronicmoney/ElectronicmoneyData;", "", "p0", "p1", "", "p2", "Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyBaseResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "MyBillsEntityDataFactory", "(Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;)Lio/reactivex/Observable;", "Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;", "()Lio/reactivex/Observable;", "Lid/dana/data/electronicmoney/network/response/BrizziGetAccessTokenResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "p3", "Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "getAuthRequestContext", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkElectronicMoneyEntityData extends SecureBaseNetwork<ElectronicMoneyFacade> implements ElectronicmoneyData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<ElectronicMoneyFacade> getFacadeClass() {
        return ElectronicMoneyFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkElectronicMoneyEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<ElectronicMoneyBaseResult> MyBillsEntityDataFactory(final BrizziReversalInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<ElectronicMoneyBaseResult> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.BuiltInFictitiousFunctionClassFactory(BrizziReversalInfo.this, this, (ElectronicMoneyFacade) obj);
            }
        }).map(new Function() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkElectronicMoneyEntityData.BuiltInFictitiousFunctionClassFactory((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<ElectronicMoneyGetBizIdResponse> BuiltInFictitiousFunctionClassFactory() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda9
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.BuiltInFictitiousFunctionClassFactory(NetworkElectronicMoneyEntityData.this, (ElectronicMoneyFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<EmoneyCardInfoResponse> getAuthRequestContext(final Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.MyBillsEntityDataFactory(p0, this, (ElectronicMoneyFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<EmoneyReversalResponse> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, final Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.MyBillsEntityDataFactory(p0, p1, p2, this, (ElectronicMoneyFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<EmoneyCardInfoResponse> MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final Map<String, String> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.getAuthRequestContext(p0, p1, p2, p3, this, (ElectronicMoneyFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<ElectronicMoneyBaseResult> BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<ElectronicMoneyBaseResult> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.getAuthRequestContext(p0, p1, p2, this, (ElectronicMoneyFacade) obj);
            }
        }).map(new Function() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkElectronicMoneyEntityData.KClassImpl$Data$declaredNonStaticMembers$2((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ ElectronicMoneyGetBizIdResponse MyBillsEntityDataFactory(NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        Intrinsics.checkNotNullExpressionValue(electronicMoneyFacade, "");
        ElectronicMoneyBizIdRequest electronicMoneyBizIdRequest = new ElectronicMoneyBizIdRequest("BRIZZI_GEN_REFNUM");
        electronicMoneyBizIdRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.getElectronicMoneyBizId(electronicMoneyBizIdRequest);
    }

    public static /* synthetic */ ElectronicMoneyGetBizIdResponse BuiltInFictitiousFunctionClassFactory(NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        Intrinsics.checkNotNullExpressionValue(electronicMoneyFacade, "");
        ElectronicMoneyBizIdRequest electronicMoneyBizIdRequest = new ElectronicMoneyBizIdRequest("MANDIRI_EMONEY_GEN_TRANS_ID_UPDATE_PROCESS");
        electronicMoneyBizIdRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.getElectronicMoneyBizId(electronicMoneyBizIdRequest);
    }

    public static /* synthetic */ EmoneyCardInfoResponse getAuthRequestContext(String str, String str2, String str3, Map map, NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        EmoneyTopupCommandRequest emoneyTopupCommandRequest = new EmoneyTopupCommandRequest(str, str2, Boolean.valueOf(str3 != null ? StringsKt.contains$default((CharSequence) str3, (CharSequence) "reversal", false, 2, (Object) null) : false), map);
        emoneyTopupCommandRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.getTopUpCommandEmoney(emoneyTopupCommandRequest);
    }

    public static /* synthetic */ EmoneyCardInfoResponse MyBillsEntityDataFactory(Map map, NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        EmoneyInquiryRequest emoneyInquiryRequest = new EmoneyInquiryRequest("MANDIRI", map);
        emoneyInquiryRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.inquireBalance(emoneyInquiryRequest);
    }

    public static /* synthetic */ BrizziGetAccessTokenResponse KClassImpl$Data$declaredNonStaticMembers$2(NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.getBrizziAccessToken(baseRpcRequest);
    }

    public static /* synthetic */ BrizziGetAccessTokenResponse getAuthRequestContext(BrizziGetAccessTokenResponse brizziGetAccessTokenResponse, ElectronicMoneyGetBizIdResponse electronicMoneyGetBizIdResponse) {
        Intrinsics.checkNotNullParameter(brizziGetAccessTokenResponse, "");
        Intrinsics.checkNotNullParameter(electronicMoneyGetBizIdResponse, "");
        brizziGetAccessTokenResponse.setReffNumber(electronicMoneyGetBizIdResponse.getBizId());
        return brizziGetAccessTokenResponse;
    }

    public static /* synthetic */ ElectronicMoneyBaseResult BuiltInFictitiousFunctionClassFactory(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        ElectronicMoneyBaseResult electronicMoneyBaseResult = new ElectronicMoneyBaseResult(false, null, null, 7, null);
        electronicMoneyBaseResult.setSuccess(baseRpcResult.success);
        electronicMoneyBaseResult.setErrorCode(baseRpcResult.errorCode);
        electronicMoneyBaseResult.setErrorMessage(baseRpcResult.errorMessage);
        return electronicMoneyBaseResult;
    }

    public static /* synthetic */ EmoneyReversalResponse MyBillsEntityDataFactory(String str, String str2, Map map, NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        EmoneyReversalRequest emoneyReversalRequest = new EmoneyReversalRequest(str, str2, map);
        emoneyReversalRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.getReversalEmoney(emoneyReversalRequest);
    }

    public static /* synthetic */ ElectronicMoneyBaseResult KClassImpl$Data$declaredNonStaticMembers$2(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return new ElectronicMoneyBaseResult(baseRpcResult.success, baseRpcResult.errorCode, baseRpcResult.errorMessage);
    }

    public static /* synthetic */ Observable KClassImpl$Data$declaredNonStaticMembers$2(final NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, final BrizziGetAccessTokenResponse brizziGetAccessTokenResponse) {
        Observable map = networkElectronicMoneyEntityData.wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda10
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.MyBillsEntityDataFactory(NetworkElectronicMoneyEntityData.this, (ElectronicMoneyFacade) obj);
            }
        }).map(new Function() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkElectronicMoneyEntityData.getAuthRequestContext(BrizziGetAccessTokenResponse.this, (ElectronicMoneyGetBizIdResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ BaseRpcResult BuiltInFictitiousFunctionClassFactory(BrizziReversalInfo brizziReversalInfo, NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(brizziReversalInfo, "");
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        BrizziManualReversalRequest brizziManualReversalRequest = new BrizziManualReversalRequest(brizziReversalInfo.getReversalData(), brizziReversalInfo.getErrorCode(), brizziReversalInfo);
        brizziManualReversalRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.doBrizziManualReversal(brizziManualReversalRequest);
    }

    public static /* synthetic */ BaseRpcResult getAuthRequestContext(String str, String str2, Map map, NetworkElectronicMoneyEntityData networkElectronicMoneyEntityData, ElectronicMoneyFacade electronicMoneyFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(networkElectronicMoneyEntityData, "");
        EmoneyConfirmBalanceRequest emoneyConfirmBalanceRequest = new EmoneyConfirmBalanceRequest(str, str2, map);
        emoneyConfirmBalanceRequest.envInfo = networkElectronicMoneyEntityData.generateMobileEnvInfo();
        return electronicMoneyFacade.confirmUpdateBalanceEmoney(emoneyConfirmBalanceRequest);
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<BrizziGetAccessTokenResponse> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkElectronicMoneyEntityData.KClassImpl$Data$declaredNonStaticMembers$2(NetworkElectronicMoneyEntityData.this, (ElectronicMoneyFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        Observable<BrizziGetAccessTokenResponse> flatMap = wrapper.flatMap(new Function() { // from class: id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkElectronicMoneyEntityData.KClassImpl$Data$declaredNonStaticMembers$2(NetworkElectronicMoneyEntityData.this, (BrizziGetAccessTokenResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }
}
