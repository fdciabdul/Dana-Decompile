package id.dana.data.deeplink.repository.source.network;

import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadPropertiesEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Deprecated
/* loaded from: classes2.dex */
public interface BranchApi {
    @GET("url")
    @Deprecated
    Observable<DeepLinkPayloadPropertiesEntity> getDeepLinkProperties(@Query("url") String str, @Query("branch_key") String str2);
}
