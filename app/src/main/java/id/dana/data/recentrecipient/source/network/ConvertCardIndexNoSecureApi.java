package id.dana.data.recentrecipient.source.network;

import id.dana.data.recentrecipient.model.BankCardConversionRequest;
import id.dana.data.recentrecipient.model.BankCardConversionResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/recentrecipient/source/network/ConvertCardIndexNoSecureApi;", "", "", "ctoken", "Lid/dana/data/recentrecipient/model/BankCardConversionRequest;", "request", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "convertCardIndexNo", "(Ljava/lang/String;Lid/dana/data/recentrecipient/model/BankCardConversionRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ConvertCardIndexNoSecureApi {
    @POST("/wallet/api/alipayplus.home.user.biztransfer.queryCardIndexNo.json")
    Observable<ResultResponse<BankCardConversionResult>> convertCardIndexNo(@Query("ctoken") String ctoken, @Body BankCardConversionRequest request);
}
