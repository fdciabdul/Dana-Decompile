package id.dana.data.useremailaddress.repository.source.network;

import id.dana.data.useremailaddress.repository.source.network.result.UserEmailAddressEntityResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface UserEmailAddressApi {
    @POST("/wallet/api/alipayplus.mobilewallet.user.emailbinding.queryuseremail.json")
    Observable<ResultResponse<UserEmailAddressEntityResult>> getEmailAddress(@Query("ctoken") String str);
}
