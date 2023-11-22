package id.dana.data.otp.repository.source.network;

import id.dana.data.otp.repository.source.network.request.SendBankOtpEntityRequest;
import id.dana.data.otp.repository.source.network.request.SendCashierOneKlikOtpRequest;
import id.dana.data.otp.repository.source.network.request.SendOtpRequest;
import id.dana.data.otp.repository.source.network.result.SendCashierOneKlikOtpResult;
import id.dana.data.otp.repository.source.network.result.SendCashierOtpResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\bJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/otp/repository/source/network/OtpApi;", "", "Lid/dana/data/otp/repository/source/network/request/SendBankOtpEntityRequest;", "sendBankOtpRequest", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/data/otp/repository/source/network/result/SendCashierOtpResult;", "sendBankOtp", "(Lid/dana/data/otp/repository/source/network/request/SendBankOtpEntityRequest;)Lio/reactivex/Observable;", "Lid/dana/data/otp/repository/source/network/request/SendOtpRequest;", "sendOtpRequest", "sendOtp", "(Lid/dana/data/otp/repository/source/network/request/SendOtpRequest;)Lio/reactivex/Observable;", "verifyBankPhoneOtp", "Lid/dana/data/otp/repository/source/network/request/SendCashierOneKlikOtpRequest;", "sendCashierOneKlikOtpRequest", "Lid/dana/data/otp/repository/source/network/result/SendCashierOneKlikOtpResult;", "verifyCashierOneKlikOtp", "(Lid/dana/data/otp/repository/source/network/request/SendCashierOneKlikOtpRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface OtpApi {
    @POST("/wallet/api/alipayplus.mobilewallet.user.asset.sendBankOtp.json")
    Observable<ResultResponse<SendCashierOtpResult>> sendBankOtp(@Body SendBankOtpEntityRequest sendBankOtpRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.user.security.sendOtp.json")
    Observable<ResultResponse<SendCashierOtpResult>> sendOtp(@Body SendOtpRequest sendOtpRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.user.asset.verifyBankPhoneNoAndSendOtp.json")
    Observable<ResultResponse<SendCashierOtpResult>> verifyBankPhoneOtp(@Body SendBankOtpEntityRequest sendBankOtpRequest);

    @POST("/wallet/api/alipayplus.mobilewallet.cashier.verify.json")
    Observable<ResultResponse<SendCashierOneKlikOtpResult>> verifyCashierOneKlikOtp(@Body SendCashierOneKlikOtpRequest sendCashierOneKlikOtpRequest);
}
