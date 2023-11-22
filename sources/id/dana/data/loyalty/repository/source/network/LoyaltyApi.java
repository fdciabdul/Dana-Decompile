package id.dana.data.loyalty.repository.source.network;

import id.dana.data.loyalty.repository.source.network.request.BaseLoyaltyRequest;
import id.dana.data.loyalty.repository.source.network.request.SubmitReceiptRequest;
import id.dana.data.loyalty.repository.source.network.response.BaseLoyaltyResponse;
import id.dana.data.loyalty.repository.source.network.response.SubmitReceiptResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ5\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H'¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/loyalty/repository/source/network/LoyaltyApi;", "", "", "bearerToken", "Lid/dana/data/loyalty/repository/source/network/request/BaseLoyaltyRequest;", "Lid/dana/data/loyalty/repository/source/network/request/SubmitReceiptRequest;", "submitReceiptRequest", "Lio/reactivex/Single;", "Lid/dana/data/loyalty/repository/source/network/response/BaseLoyaltyResponse;", "Lid/dana/data/loyalty/repository/source/network/response/SubmitReceiptResponse;", "submitReceipt", "(Ljava/lang/String;Lid/dana/data/loyalty/repository/source/network/request/BaseLoyaltyRequest;)Lio/reactivex/Single;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LoyaltyApi {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("/loyalty-pocket/api/receipt")
    Single<BaseLoyaltyResponse<SubmitReceiptResponse>> submitReceipt(@Header("Authorization") String bearerToken, @Body BaseLoyaltyRequest<SubmitReceiptRequest> submitReceiptRequest);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/data/loyalty/repository/source/network/LoyaltyApi$Companion;", "", "", "HEADER_BEARER_TOKEN", "Ljava/lang/String;", "SUBMIT_RECIPT_ENDPOINT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String HEADER_BEARER_TOKEN = "Authorization";
        private static final String SUBMIT_RECIPT_ENDPOINT = "/loyalty-pocket/api/receipt";

        private Companion() {
        }
    }
}
