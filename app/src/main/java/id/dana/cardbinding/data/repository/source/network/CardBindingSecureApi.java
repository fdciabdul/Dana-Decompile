package id.dana.cardbinding.data.repository.source.network;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cardbinding.data.model.BindingCardAddResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/data/repository/source/network/CardBindingSecureApi;", "", "", "p0", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "p1", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/cardbinding/data/model/BindingCardAddResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CardBindingSecureApi {
    @POST("/wallet/api/alipayplus.mobilewallet.bindingcard.add.json")
    Observable<ResultResponse<BindingCardAddResult>> BuiltInFictitiousFunctionClassFactory(@Query("ctoken") String p0, @Body BaseRpcRequest p1);
}
