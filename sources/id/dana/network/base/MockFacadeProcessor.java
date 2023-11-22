package id.dana.network.base;

import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.network.base.BaseNetwork;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J)\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00028\u0002H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/network/base/MockFacadeProcessor;", LogConstants.RESULT_FALSE, "S", "MF", "Lid/dana/network/base/BaseNetwork$FacadeProcessor;", "mockFacade", "Lio/reactivex/Observable;", "Lretrofit2/Response;", "Lid/dana/network/base/ResultResponse;", "processMockApi", "(Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface MockFacadeProcessor<F, S, MF> extends BaseNetwork.FacadeProcessor<F, S> {
    Observable<Response<ResultResponse<S>>> processMockApi(MF mockFacade);
}
