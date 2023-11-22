package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveyConsultEntityRequest;
import id.dana.cashier.domain.model.NpsSurveyConsultRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;", "toNpsSurveyConsultEntityRequest", "(Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;)Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveyConsultEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchNpsSurveyInfoRequestMapperKt {
    public static final NpsSurveyConsultEntityRequest toNpsSurveyConsultEntityRequest(NpsSurveyConsultRequest npsSurveyConsultRequest) {
        Intrinsics.checkNotNullParameter(npsSurveyConsultRequest, "");
        return new NpsSurveyConsultEntityRequest(npsSurveyConsultRequest.getTransType(), npsSurveyConsultRequest.getMerchantTransType(), npsSurveyConsultRequest.getMerchantName(), npsSurveyConsultRequest.getNpsScenario());
    }
}
