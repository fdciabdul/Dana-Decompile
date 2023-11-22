package id.dana.data.cancelsurvey.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.cancelsurvey.repository.source.network.request.SurveyCancelReasonConsultRequest;
import id.dana.data.cancelsurvey.repository.source.network.request.SurveyCancelReasonSubmitRequest;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonConsultResponse;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonSubmitResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/network/CancelSurveyFacade;", "", "Lid/dana/data/cancelsurvey/repository/source/network/request/SurveyCancelReasonConsultRequest;", "request", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonConsultResponse;", "consultCancelSurvey", "(Lid/dana/data/cancelsurvey/repository/source/network/request/SurveyCancelReasonConsultRequest;)Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonConsultResponse;", "Lid/dana/data/cancelsurvey/repository/source/network/request/SurveyCancelReasonSubmitRequest;", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonSubmitResponse;", "submitCancelSurvey", "(Lid/dana/data/cancelsurvey/repository/source/network/request/SurveyCancelReasonSubmitRequest;)Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonSubmitResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CancelSurveyFacade {
    public static final String CONSULT_CANCEL_SURVEY = "alipayplus.mobilewallet.survey.cancelreason.consult";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String SUBMIT_CANCEL_SURVEY = "alipayplus.mobilewallet.survey.cancelreason.submit";

    @OperationType("alipayplus.mobilewallet.survey.cancelreason.consult")
    @SignCheck
    SurveyCancelReasonConsultResponse consultCancelSurvey(SurveyCancelReasonConsultRequest request);

    @OperationType("alipayplus.mobilewallet.survey.cancelreason.submit")
    @SignCheck
    SurveyCancelReasonSubmitResponse submitCancelSurvey(SurveyCancelReasonSubmitRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/network/CancelSurveyFacade$Companion;", "", "", "CONSULT_CANCEL_SURVEY", "Ljava/lang/String;", "SUBMIT_CANCEL_SURVEY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CONSULT_CANCEL_SURVEY = "alipayplus.mobilewallet.survey.cancelreason.consult";
        public static final String SUBMIT_CANCEL_SURVEY = "alipayplus.mobilewallet.survey.cancelreason.submit";

        private Companion() {
        }
    }
}
