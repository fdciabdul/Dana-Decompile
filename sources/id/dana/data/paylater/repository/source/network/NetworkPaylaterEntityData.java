package id.dana.data.paylater.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.paylater.repository.PaylaterEntityData;
import id.dana.data.paylater.repository.source.PaylaterFacade;
import id.dana.data.paylater.repository.source.PaylaterHomeInfoExceptionParser;
import id.dana.data.paylater.repository.source.network.request.LoanConsultWhitelistRequest;
import id.dana.data.paylater.repository.source.network.request.LoanRegisterEntityRequest;
import id.dana.data.paylater.repository.source.network.request.PaylaterHomeInfoRequest;
import id.dana.data.paylater.repository.source.network.result.LoanRegisterResult;
import id.dana.data.paylater.repository.source.network.result.LoanWhitelistResult;
import id.dana.data.paylater.repository.source.network.result.PaylaterHomeInfoResult;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006*\u00020\u00070\u00070\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/paylater/repository/source/network/NetworkPaylaterEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/paylater/repository/source/PaylaterFacade;", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "userId", "", "withBill", "Lio/reactivex/Observable;", "Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;", "getLoanConsultWhitelist", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "agreementKey", "Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;", "getLoanRegisterInfo", "(Ljava/lang/String;)Lio/reactivex/Observable;", "skipBillInfo", "Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "getPaylaterHomeInfo", "(Z)Lio/reactivex/Observable;", "Lkotlin/Pair;", "pairDeviceInfo", "()Lkotlin/Pair;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/data/config/DeviceInformationProvider;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkPaylaterEntityData extends SecureBaseNetwork<PaylaterFacade> implements PaylaterEntityData {
    private final DeviceInformationProvider deviceInformationProvider;

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable clearCacheLoanWhitelist(String str) {
        return PaylaterEntityData.CC.$default$clearCacheLoanWhitelist(this, str);
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Class<PaylaterFacade> getFacadeClass() {
        return PaylaterFacade.class;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPayLaterCacheWhitelistValue(String str) {
        return PaylaterEntityData.CC.$default$getPayLaterCacheWhitelistValue(this, str);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPayLaterLoanStatus(String str) {
        return PaylaterEntityData.CC.$default$getPayLaterLoanStatus(this, str);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPaylaterCicilMethodConfig() {
        return PaylaterEntityData.CC.$default$getPaylaterCicilMethodConfig(this);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPaylaterRotationDelayTime(String str) {
        return PaylaterEntityData.CC.$default$getPaylaterRotationDelayTime(this, str);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable resetPayLaterCacheLoanWhitelist() {
        return PaylaterEntityData.CC.$default$resetPayLaterCacheLoanWhitelist(this);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable savePayLaterCacheWhitelistValue(String str, LoanWhitelist loanWhitelist) {
        return PaylaterEntityData.CC.$default$savePayLaterCacheWhitelistValue(this, str, loanWhitelist);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable savePayLaterLoanStatus(List list, String str) {
        return PaylaterEntityData.CC.$default$savePayLaterLoanStatus(this, list, str);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable savePaylaterRotationDelayTime(String str, long j) {
        return PaylaterEntityData.CC.$default$savePaylaterRotationDelayTime(this, str, j);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable setLoanServicesState(String str, String str2) {
        return PaylaterEntityData.CC.$default$setLoanServicesState(this, str, str2);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable setOffLoanServicesState(LoanWhitelist loanWhitelist) {
        return PaylaterEntityData.CC.$default$setOffLoanServicesState(this, loanWhitelist);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable setPaylaterChannel(String str) {
        return PaylaterEntityData.CC.$default$setPaylaterChannel(this, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkPaylaterEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, DeviceInformationProvider deviceInformationProvider) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<PaylaterHomeInfoResult> getPaylaterHomeInfo(final boolean skipBillInfo) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.paylater.repository.source.network.NetworkPaylaterEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PaylaterHomeInfoResult m1580getPaylaterHomeInfo$lambda1;
                m1580getPaylaterHomeInfo$lambda1 = NetworkPaylaterEntityData.m1580getPaylaterHomeInfo$lambda1(skipBillInfo, this, (PaylaterFacade) obj);
                return m1580getPaylaterHomeInfo$lambda1;
            }
        }, new PaylaterHomeInfoExceptionParser());
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: getPaylaterHomeInfo$lambda-1 */
    public static final PaylaterHomeInfoResult m1580getPaylaterHomeInfo$lambda1(boolean z, NetworkPaylaterEntityData networkPaylaterEntityData, PaylaterFacade paylaterFacade) {
        Intrinsics.checkNotNullParameter(networkPaylaterEntityData, "");
        PaylaterHomeInfoRequest paylaterHomeInfoRequest = new PaylaterHomeInfoRequest(z);
        paylaterHomeInfoRequest.envInfo = networkPaylaterEntityData.generateMobileEnvInfo();
        return paylaterFacade.getPaylaterHomeInfo(paylaterHomeInfoRequest);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<LoanWhitelistResult> getLoanConsultWhitelist(final String userId, final boolean withBill) {
        Intrinsics.checkNotNullParameter(userId, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.paylater.repository.source.network.NetworkPaylaterEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoanWhitelistResult m1578getLoanConsultWhitelist$lambda3;
                m1578getLoanConsultWhitelist$lambda3 = NetworkPaylaterEntityData.m1578getLoanConsultWhitelist$lambda3(userId, withBill, this, (PaylaterFacade) obj);
                return m1578getLoanConsultWhitelist$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: getLoanConsultWhitelist$lambda-3 */
    public static final LoanWhitelistResult m1578getLoanConsultWhitelist$lambda3(String str, boolean z, NetworkPaylaterEntityData networkPaylaterEntityData, PaylaterFacade paylaterFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkPaylaterEntityData, "");
        LoanConsultWhitelistRequest loanConsultWhitelistRequest = new LoanConsultWhitelistRequest(str, z);
        loanConsultWhitelistRequest.envInfo = networkPaylaterEntityData.generateMobileEnvInfo();
        return paylaterFacade.getLoanConsultWhitelist(loanConsultWhitelistRequest);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<LoanRegisterResult> getLoanRegisterInfo(final String agreementKey) {
        Intrinsics.checkNotNullParameter(agreementKey, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.paylater.repository.source.network.NetworkPaylaterEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoanRegisterResult m1579getLoanRegisterInfo$lambda5;
                m1579getLoanRegisterInfo$lambda5 = NetworkPaylaterEntityData.m1579getLoanRegisterInfo$lambda5(NetworkPaylaterEntityData.this, agreementKey, (PaylaterFacade) obj);
                return m1579getLoanRegisterInfo$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: getLoanRegisterInfo$lambda-5 */
    public static final LoanRegisterResult m1579getLoanRegisterInfo$lambda5(NetworkPaylaterEntityData networkPaylaterEntityData, String str, PaylaterFacade paylaterFacade) {
        Intrinsics.checkNotNullParameter(networkPaylaterEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        LoanRegisterEntityRequest loanRegisterEntityRequest = new LoanRegisterEntityRequest(null, null, null, 7, null);
        loanRegisterEntityRequest.setEnvInfo(networkPaylaterEntityData.generateMobileEnvInfo());
        loanRegisterEntityRequest.setExtParams(MapsKt.mutableMapOf(TuplesKt.to("agreementKey", str), TuplesKt.to("isCashierPage", Boolean.TRUE)));
        loanRegisterEntityRequest.setApplyInfo(MapsKt.mutableMapOf(networkPaylaterEntityData.pairDeviceInfo()));
        return paylaterFacade.getLoanRegisterInfo(loanRegisterEntityRequest);
    }

    private final Pair<String, String> pairDeviceInfo() {
        return TuplesKt.to(DanaLogConstants.BizType.DEVICE_INFO, JSONExtKt.PlaceComponentResult().toJson(this.deviceInformationProvider.assembleDeviceInfo()));
    }
}
