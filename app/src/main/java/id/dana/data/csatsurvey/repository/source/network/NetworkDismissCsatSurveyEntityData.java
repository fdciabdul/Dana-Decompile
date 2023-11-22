package id.dana.data.csatsurvey.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.csatsurvey.repository.source.DismissCsatSurveyEntityData;
import id.dana.data.csatsurvey.repository.source.network.facade.DismissCsatSurveyFacade;
import id.dana.data.csatsurvey.repository.source.network.request.DismissCsatSurveyRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/csatsurvey/repository/source/network/NetworkDismissCsatSurveyEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/csatsurvey/repository/source/network/facade/DismissCsatSurveyFacade;", "Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyEntityData;", "", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "p1", "Lid/dana/utils/concurrent/ThreadExecutor;", "p2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkDismissCsatSurveyEntityData extends SecureBaseNetwork<DismissCsatSurveyFacade> implements DismissCsatSurveyEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<DismissCsatSurveyFacade> getFacadeClass() {
        return DismissCsatSurveyFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDismissCsatSurveyEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.csatsurvey.repository.source.DismissCsatSurveyEntityData
    public final Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final DismissCsatSurveyRequest dismissCsatSurveyRequest = new DismissCsatSurveyRequest(p0);
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.csatsurvey.repository.source.network.NetworkDismissCsatSurveyEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkDismissCsatSurveyEntityData.getAuthRequestContext(DismissCsatSurveyRequest.this, (DismissCsatSurveyFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ BaseRpcResult getAuthRequestContext(DismissCsatSurveyRequest dismissCsatSurveyRequest, DismissCsatSurveyFacade dismissCsatSurveyFacade) {
        Intrinsics.checkNotNullParameter(dismissCsatSurveyRequest, "");
        return dismissCsatSurveyFacade.dismissCsatSurvey(dismissCsatSurveyRequest);
    }
}
