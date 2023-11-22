package id.dana.cardbinding.data.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cardbinding.data.model.BindingCardAddResult;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import id.dana.cardbinding.data.repository.source.CardBindingEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.security.SecureString;
import id.dana.network.base.ResultResponse;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxConvertKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012"}, d2 = {"Lid/dana/cardbinding/data/repository/source/network/NetworkCardBindingEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/cardbinding/data/repository/source/network/CardBindingSecureApi;", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cardbinding/data/model/BindingCardAddResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "", "PlaceComponentResult", "Lid/dana/cardbinding/data/model/SupportedCardsConfigEntity;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Lid/dana/cardbinding/data/repository/source/network/CardBindingSecureApi;", "Lid/dana/network/rpc/RpcConnector;", "p0", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p1", "Landroid/content/Context;", "p2", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/cardbinding/data/repository/source/network/CardBindingSecureApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NetworkCardBindingEntityData extends SecureBaseNetworkFlow<CardBindingSecureApi> implements CardBindingEntityData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CardBindingSecureApi BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<CardBindingSecureApi> getFacadeClass() {
        return CardBindingSecureApi.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCardBindingEntityData(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context, CardBindingSecureApi cardBindingSecureApi) {
        super(apSecurityFacade, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(cardBindingSecureApi, "");
        this.BuiltInFictitiousFunctionClassFactory = cardBindingSecureApi;
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<List<String>> PlaceComponentResult() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<BindingCardAddResult> KClassImpl$Data$declaredNonStaticMembers$2() {
        SecureString authRequestContext = CookieUtil.getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        ObservableSource map = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(authRequestContext.toString(), baseRpcRequest).map(new Function() { // from class: id.dana.cardbinding.data.repository.source.network.NetworkCardBindingEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkCardBindingEntityData.getAuthRequestContext((ResultResponse) obj);
            }
        });
        authRequestContext.clear();
        Intrinsics.checkNotNullExpressionValue(map, "");
        return RxConvertKt.asFlow(map);
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<Boolean> getAuthRequestContext() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<SupportedCardsConfigEntity> BuiltInFictitiousFunctionClassFactory() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ BindingCardAddResult getAuthRequestContext(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (BindingCardAddResult) resultResponse.getResult();
    }
}
