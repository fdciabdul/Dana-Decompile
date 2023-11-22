package id.dana.data.cancelsurvey.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData;
import id.dana.data.cancelsurvey.repository.source.network.request.SurveyCancelReasonConsultRequest;
import id.dana.data.cancelsurvey.repository.source.network.request.SurveyCancelReasonSubmitRequest;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonConsultResponse;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonSubmitResponse;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000b"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/network/NetworkCancelSurveyEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/cancelsurvey/repository/source/network/CancelSurveyFacade;", "Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityData;", "", CashierKeyParams.CASHIER_ORDER_ID, "scenario", "goodsId", "Lio/reactivex/Observable;", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonConsultResponse;", "consultCancelSurvey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonSubmitResponse;", "submitCancelSurvey", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkCancelSurveyEntityData extends SecureBaseNetwork<CancelSurveyFacade> implements CancelSurveyEntityData {
    @Override // id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData
    public final /* synthetic */ Observable fetchCancelSurveyReasonConfig(String str) {
        return CancelSurveyEntityData.CC.$default$fetchCancelSurveyReasonConfig(this, str);
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Class<CancelSurveyFacade> getFacadeClass() {
        return CancelSurveyFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCancelSurveyEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData
    public final Observable<SurveyCancelReasonConsultResponse> consultCancelSurvey(String cashierOrderId, String scenario, String goodsId) {
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = scenario.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        final SurveyCancelReasonConsultRequest surveyCancelReasonConsultRequest = new SurveyCancelReasonConsultRequest(cashierOrderId, upperCase, goodsId);
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.cancelsurvey.repository.source.network.NetworkCancelSurveyEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SurveyCancelReasonConsultResponse m820consultCancelSurvey$lambda0;
                m820consultCancelSurvey$lambda0 = NetworkCancelSurveyEntityData.m820consultCancelSurvey$lambda0(SurveyCancelReasonConsultRequest.this, (CancelSurveyFacade) obj);
                return m820consultCancelSurvey$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultCancelSurvey$lambda-0  reason: not valid java name */
    public static final SurveyCancelReasonConsultResponse m820consultCancelSurvey$lambda0(SurveyCancelReasonConsultRequest surveyCancelReasonConsultRequest, CancelSurveyFacade cancelSurveyFacade) {
        Intrinsics.checkNotNullParameter(surveyCancelReasonConsultRequest, "");
        return cancelSurveyFacade.consultCancelSurvey(surveyCancelReasonConsultRequest);
    }

    @Override // id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData
    public final Observable<SurveyCancelReasonSubmitResponse> submitCancelSurvey(String cashierOrderId, String scenario, String goodsId) {
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        final SurveyCancelReasonSubmitRequest surveyCancelReasonSubmitRequest = new SurveyCancelReasonSubmitRequest(cashierOrderId, scenario, goodsId);
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.cancelsurvey.repository.source.network.NetworkCancelSurveyEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SurveyCancelReasonSubmitResponse m821submitCancelSurvey$lambda1;
                m821submitCancelSurvey$lambda1 = NetworkCancelSurveyEntityData.m821submitCancelSurvey$lambda1(SurveyCancelReasonSubmitRequest.this, (CancelSurveyFacade) obj);
                return m821submitCancelSurvey$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitCancelSurvey$lambda-1  reason: not valid java name */
    public static final SurveyCancelReasonSubmitResponse m821submitCancelSurvey$lambda1(SurveyCancelReasonSubmitRequest surveyCancelReasonSubmitRequest, CancelSurveyFacade cancelSurveyFacade) {
        Intrinsics.checkNotNullParameter(surveyCancelReasonSubmitRequest, "");
        return cancelSurveyFacade.submitCancelSurvey(surveyCancelReasonSubmitRequest);
    }
}
