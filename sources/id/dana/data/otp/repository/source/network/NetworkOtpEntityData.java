package id.dana.data.otp.repository.source.network;

import android.content.Context;
import android.os.Bundle;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.otp.repository.source.OtpEntityData;
import id.dana.data.otp.repository.source.network.request.SendBankOtpEntityRequest;
import id.dana.data.otp.repository.source.network.request.SendCashierOneKlikOtpRequest;
import id.dana.data.otp.repository.source.network.request.SendOtpRequest;
import id.dana.data.otp.repository.source.network.request.VerifyOtpRequest;
import id.dana.data.otp.repository.source.network.result.SendCashierOneKlikOtpResult;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.BotProtectionExceptionParser;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.ExceptionParserAphome;
import id.dana.network.base.ResultResponse;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.response.login.VerifyOtpResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.promoquest.handler.nativepage.NativePageType;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public class NetworkOtpEntityData extends SecureBaseNetwork<OtpRpcFacade> implements OtpEntityData {
    private final Context context;
    private final OtpApi otpApi;

    public NetworkOtpEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, OtpApi otpApi, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.otpApi = otpApi;
        this.context = context;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<OtpRpcFacade> getFacadeClass() {
        return OtpRpcFacade.class;
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<VerifyOtpResult> verifyOtp(String str, String str2) {
        final VerifyOtpRequest verifyOtpRequest = new VerifyOtpRequest();
        verifyOtpRequest.envInfo = generateMobileEnvInfo();
        verifyOtpRequest.phoneNumber = str;
        verifyOtpRequest.otpValue = str2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.otp.repository.source.network.NetworkOtpEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                VerifyOtpResult verifyOtp;
                verifyOtp = ((OtpRpcFacade) obj).verifyOtp(VerifyOtpRequest.this);
                return verifyOtp;
            }
        });
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendOtpResult> sendOtp(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        final SendOtpRequest sendOtpRequest = new SendOtpRequest();
        sendOtpRequest.envInfo = generateMobileEnvInfo();
        sendOtpRequest.phoneNumber = str;
        sendOtpRequest.sendStrategy = str2;
        sendOtpRequest.serviceCode = str3;
        sendOtpRequest.otpChannel = str5;
        sendOtpRequest.securityId = str6;
        if (str2.equals("AP_PAYMENT")) {
            if (bool.booleanValue()) {
                sendOtpRequest.otpScene = NativePageType.SEND_MONEY;
            } else {
                sendOtpRequest.extParams.put("merchantId", str4);
            }
            return this.otpApi.sendOtp(sendOtpRequest).map(new NetworkOtpEntityData$$ExternalSyntheticLambda0()).flatMap(new ExceptionParserAphome()).map(new NetworkOtpEntityData$$ExternalSyntheticLambda1()).onErrorResumeNext(new Function() { // from class: id.dana.data.otp.repository.source.network.NetworkOtpEntityData$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource apply;
                    apply = new ConnectionExceptionParser().apply((Throwable) obj);
                    return apply;
                }
            });
        }
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.otp.repository.source.network.NetworkOtpEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SendOtpResult sendOtp;
                sendOtp = ((OtpRpcFacade) obj).sendOtp(SendOtpRequest.this);
                return sendOtp;
            }
        }).onErrorResumeNext(checkExceptionType());
    }

    private Function<Throwable, ObservableSource<SendOtpResult>> checkExceptionType() {
        return new Function() { // from class: id.dana.data.otp.repository.source.network.NetworkOtpEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkOtpEntityData.this.m1557xe2df33db((Throwable) obj);
            }
        };
    }

    /* renamed from: lambda$checkExceptionType$3$id-dana-data-otp-repository-source-network-NetworkOtpEntityData */
    public /* synthetic */ ObservableSource m1557xe2df33db(Throwable th) throws Exception {
        return new BotProtectionExceptionParser(this.context, "alipayplus.mobilewallet.user.security.sendOtp").apply(th);
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendOtpResult> sendBankOtp(SendBankOtpEntityRequest sendBankOtpEntityRequest) {
        sendBankOtpEntityRequest.envInfo = generateMobileEnvInfo();
        return this.otpApi.sendBankOtp(sendBankOtpEntityRequest).map(new NetworkOtpEntityData$$ExternalSyntheticLambda0()).flatMap(new ExceptionParserAphome()).map(new NetworkOtpEntityData$$ExternalSyntheticLambda1());
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendOtpResult> verifyBankPhoneOtp(SendBankOtpEntityRequest sendBankOtpEntityRequest) {
        sendBankOtpEntityRequest.envInfo = generateMobileEnvInfo();
        return this.otpApi.verifyBankPhoneOtp(sendBankOtpEntityRequest).map(new NetworkOtpEntityData$$ExternalSyntheticLambda0()).flatMap(new ExceptionParserAphome()).map(new NetworkOtpEntityData$$ExternalSyntheticLambda1());
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<SendCashierOneKlikOtpResult> verifyCashierOneklikOtp(SendCashierOneKlikOtpRequest sendCashierOneKlikOtpRequest) {
        return this.otpApi.verifyCashierOneKlikOtp(sendCashierOneKlikOtpRequest).map(new Function() { // from class: id.dana.data.otp.repository.source.network.NetworkOtpEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (SendCashierOneKlikOtpResult) ((ResultResponse) obj).getResult();
            }
        }).flatMap(new ExceptionParserAphome());
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<String> receiveOtp() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.otp.repository.source.OtpEntityData
    public Observable<Bundle> receiveSms() {
        throw new UnsupportedOperationException();
    }
}
