package id.dana.mapper;

import id.dana.animation.model.EddAnswerInfoDTOModel;
import id.dana.animation.model.EddConsultModel;
import id.dana.animation.model.EddInfoModel;
import id.dana.animation.model.EddQuestionInfoDTOModel;
import id.dana.domain.kycamledd.model.EddAnswerInfoDTO;
import id.dana.domain.kycamledd.model.EddConsult;
import id.dana.domain.kycamledd.model.EddInfo;
import id.dana.domain.kycamledd.model.EddQuestionInfoDTO;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/kycamledd/model/EddConsult;", "Lid/dana/home/model/EddConsultModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/kycamledd/model/EddConsult;)Lid/dana/home/model/EddConsultModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EddConsultToEddConsultModelMapperKt {
    public static final EddConsultModel MyBillsEntityDataFactory(EddConsult eddConsult) {
        EddInfoModel eddInfoModel;
        Intrinsics.checkNotNullParameter(eddConsult, "");
        boolean eddStatus = eddConsult.getEddStatus();
        EddInfo eddInfo = eddConsult.getEddInfo();
        if (eddInfo != null) {
            Intrinsics.checkNotNullParameter(eddInfo, "");
            String amlOrderId = eddInfo.getAmlOrderId();
            List<EddQuestionInfoDTO> eddQuestionInfos = eddInfo.getEddQuestionInfos();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eddQuestionInfos, 10));
            for (EddQuestionInfoDTO eddQuestionInfoDTO : eddQuestionInfos) {
                Intrinsics.checkNotNullParameter(eddQuestionInfoDTO, "");
                String questionId = eddQuestionInfoDTO.getQuestionId();
                String question = eddQuestionInfoDTO.getQuestion();
                List<EddAnswerInfoDTO> eddAnswerInfos = eddQuestionInfoDTO.getEddAnswerInfos();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(eddAnswerInfos, 10));
                for (EddAnswerInfoDTO eddAnswerInfoDTO : eddAnswerInfos) {
                    Intrinsics.checkNotNullParameter(eddAnswerInfoDTO, "");
                    arrayList2.add(new EddAnswerInfoDTOModel(eddAnswerInfoDTO.getAnswerId(), eddAnswerInfoDTO.getAnswer()));
                }
                arrayList.add(new EddQuestionInfoDTOModel(questionId, question, arrayList2, 0, 8, null));
            }
            eddInfoModel = new EddInfoModel(amlOrderId, arrayList);
        } else {
            eddInfoModel = null;
        }
        return new EddConsultModel(eddStatus, eddInfoModel, eddConsult.getEddMandatory());
    }
}
