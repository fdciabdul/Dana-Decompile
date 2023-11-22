package id.dana.data.here.source.network;

import id.dana.data.here.model.HereTokenResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/here/source/network/HereTokenApi;", "", "", "contentType", "authorization", "grantType", "Lio/reactivex/Observable;", "Lid/dana/data/here/model/HereTokenResponse;", "getToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HereTokenApi {
    public static final String CONTENT_TYPE = "Content-Type";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String GRANT_TYPE_PARAM = "grant_type";
    public static final String HERE_TOKEN_ENDPOINT = "/oauth2/token";

    @FormUrlEncoded
    @POST("/oauth2/token")
    Observable<HereTokenResponse> getToken(@Header("Content-Type") String contentType, @Header("Authorization") String authorization, @Field("grant_type") String grantType);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/data/here/source/network/HereTokenApi$Companion;", "", "", "CONTENT_TYPE", "Ljava/lang/String;", "GRANT_TYPE_PARAM", "HERE_TOKEN_ENDPOINT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String GRANT_TYPE_PARAM = "grant_type";
        public static final String HERE_TOKEN_ENDPOINT = "/oauth2/token";

        private Companion() {
        }
    }
}
