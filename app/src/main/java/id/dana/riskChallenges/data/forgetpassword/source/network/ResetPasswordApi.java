package id.dana.riskChallenges.data.forgetpassword.source.network;

import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.network.base.ResultResponse;
import id.dana.riskChallenges.data.forgetpassword.source.network.request.ResetPasswordRequest;
import id.dana.riskChallenges.data.forgetpassword.source.network.request.RiskChallengesRequest;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.ResetPasswordResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.RiskChallengesResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/source/network/ResetPasswordApi;", "", "Lid/dana/riskChallenges/data/forgetpassword/source/network/request/RiskChallengesRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/RiskChallengesResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/riskChallenges/data/forgetpassword/source/network/request/RiskChallengesRequest;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/request/ResetPasswordRequest;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/ResetPasswordResult;", "getAuthRequestContext", "(Lid/dana/riskChallenges/data/forgetpassword/source/network/request/ResetPasswordRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ResetPasswordApi {
    @POST(TrackerDataKey.NetworkErrorOperationTypeProperty.FORGET_PASSWORD_CONSULT)
    Observable<ResultResponse<RiskChallengesResult>> KClassImpl$Data$declaredNonStaticMembers$2(@Body RiskChallengesRequest p0);

    @POST("wallet/api/alipayplus.mobilewallet.user.security.resetPassword.json")
    Observable<ResultResponse<ResetPasswordResult>> getAuthRequestContext(@Body ResetPasswordRequest p0);
}
