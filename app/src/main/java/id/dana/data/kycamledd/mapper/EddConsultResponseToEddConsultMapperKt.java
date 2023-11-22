package id.dana.data.kycamledd.mapper;

import id.dana.data.kycamledd.repository.source.network.response.EddAnswerInfoDTOResponse;
import id.dana.data.kycamledd.repository.source.network.response.EddConsultResponse;
import id.dana.data.kycamledd.repository.source.network.response.EddInfoResponse;
import id.dana.data.kycamledd.repository.source.network.response.EddQuestionInfoDTOResponse;
import id.dana.domain.kycamledd.model.EddAnswerInfoDTO;
import id.dana.domain.kycamledd.model.EddConsult;
import id.dana.domain.kycamledd.model.EddInfo;
import id.dana.domain.kycamledd.model.EddQuestionInfoDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/kycamledd/repository/source/network/response/EddAnswerInfoDTOResponse;", "Lid/dana/domain/kycamledd/model/EddAnswerInfoDTO;", "toEddAnswerInfoDTO", "(Lid/dana/data/kycamledd/repository/source/network/response/EddAnswerInfoDTOResponse;)Lid/dana/domain/kycamledd/model/EddAnswerInfoDTO;", "Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "", "eddAmlMandatory", "Lid/dana/domain/kycamledd/model/EddConsult;", "toEddConsult", "(Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;Z)Lid/dana/domain/kycamledd/model/EddConsult;", "Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;", "Lid/dana/domain/kycamledd/model/EddInfo;", "toEddInfo", "(Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;)Lid/dana/domain/kycamledd/model/EddInfo;", "Lid/dana/data/kycamledd/repository/source/network/response/EddQuestionInfoDTOResponse;", "Lid/dana/domain/kycamledd/model/EddQuestionInfoDTO;", "toEddQuestionInfoDTO", "(Lid/dana/data/kycamledd/repository/source/network/response/EddQuestionInfoDTOResponse;)Lid/dana/domain/kycamledd/model/EddQuestionInfoDTO;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EddConsultResponseToEddConsultMapperKt {
    public static final EddConsult toEddConsult(EddConsultResponse eddConsultResponse, boolean z) {
        Intrinsics.checkNotNullParameter(eddConsultResponse, "");
        boolean eddStatus = eddConsultResponse.getEddStatus();
        EddInfoResponse eddInfo = eddConsultResponse.getEddInfo();
        return new EddConsult(eddStatus, eddInfo != null ? toEddInfo(eddInfo) : null, z);
    }

    public static final EddInfo toEddInfo(EddInfoResponse eddInfoResponse) {
        Intrinsics.checkNotNullParameter(eddInfoResponse, "");
        String amlOrderId = eddInfoResponse.getAmlOrderId();
        List<EddQuestionInfoDTOResponse> eddQuestionInfos = eddInfoResponse.getEddQuestionInfos();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eddQuestionInfos, 10));
        Iterator<T> it = eddQuestionInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(toEddQuestionInfoDTO((EddQuestionInfoDTOResponse) it.next()));
        }
        return new EddInfo(amlOrderId, arrayList);
    }

    public static final EddQuestionInfoDTO toEddQuestionInfoDTO(EddQuestionInfoDTOResponse eddQuestionInfoDTOResponse) {
        Intrinsics.checkNotNullParameter(eddQuestionInfoDTOResponse, "");
        String questionId = eddQuestionInfoDTOResponse.getQuestionId();
        String question = eddQuestionInfoDTOResponse.getQuestion();
        List<EddAnswerInfoDTOResponse> eddAnswerInfos = eddQuestionInfoDTOResponse.getEddAnswerInfos();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eddAnswerInfos, 10));
        Iterator<T> it = eddAnswerInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(toEddAnswerInfoDTO((EddAnswerInfoDTOResponse) it.next()));
        }
        return new EddQuestionInfoDTO(questionId, question, arrayList);
    }

    public static final EddAnswerInfoDTO toEddAnswerInfoDTO(EddAnswerInfoDTOResponse eddAnswerInfoDTOResponse) {
        Intrinsics.checkNotNullParameter(eddAnswerInfoDTOResponse, "");
        return new EddAnswerInfoDTO(eddAnswerInfoDTOResponse.getAnswerId(), eddAnswerInfoDTOResponse.getAnswer());
    }
}
