package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveySubmitAnswerEntity;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveySubmitEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveySubmitIdentifierEntity;
import id.dana.cashier.domain.model.NpsSurveySubmitAnswerInfo;
import id.dana.cashier.domain.model.NpsSurveySubmitIdentifierInfo;
import id.dana.cashier.domain.model.NpsSurveySubmitRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lid/dana/cashier/domain/model/NpsSurveySubmitAnswerInfo;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitAnswerEntity;", "toListNpsSurveySubmitAnswerEntity", "(Ljava/util/List;)Ljava/util/List;", "toNpsSurveySubmitAnswerEntity", "(Lid/dana/cashier/domain/model/NpsSurveySubmitAnswerInfo;)Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitAnswerEntity;", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;", "toNpsSurveySubmitEntityRequest", "(Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;)Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitNpsSurveyInfoRequestMapperKt {
    public static final NpsSurveySubmitEntityRequest toNpsSurveySubmitEntityRequest(NpsSurveySubmitRequest npsSurveySubmitRequest) {
        Intrinsics.checkNotNullParameter(npsSurveySubmitRequest, "");
        List<NpsSurveySubmitAnswerInfo> surveyAnswers = npsSurveySubmitRequest.getSurveyAnswers();
        List<NpsSurveySubmitAnswerEntity> listNpsSurveySubmitAnswerEntity = surveyAnswers != null ? toListNpsSurveySubmitAnswerEntity(surveyAnswers) : null;
        NpsSurveySubmitIdentifierInfo surveyIdentifier = npsSurveySubmitRequest.getSurveyIdentifier();
        String surveyId = surveyIdentifier != null ? surveyIdentifier.getSurveyId() : null;
        NpsSurveySubmitIdentifierInfo surveyIdentifier2 = npsSurveySubmitRequest.getSurveyIdentifier();
        return new NpsSurveySubmitEntityRequest(listNpsSurveySubmitAnswerEntity, new NpsSurveySubmitIdentifierEntity(surveyId, surveyIdentifier2 != null ? surveyIdentifier2.getSurveyChannel() : null), npsSurveySubmitRequest.getNpsFlag());
    }

    public static final NpsSurveySubmitAnswerEntity toNpsSurveySubmitAnswerEntity(NpsSurveySubmitAnswerInfo npsSurveySubmitAnswerInfo) {
        Intrinsics.checkNotNullParameter(npsSurveySubmitAnswerInfo, "");
        return new NpsSurveySubmitAnswerEntity(npsSurveySubmitAnswerInfo.getId(), npsSurveySubmitAnswerInfo.getValue(), npsSurveySubmitAnswerInfo.getComment());
    }

    public static final List<NpsSurveySubmitAnswerEntity> toListNpsSurveySubmitAnswerEntity(List<NpsSurveySubmitAnswerInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<NpsSurveySubmitAnswerInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toNpsSurveySubmitAnswerEntity((NpsSurveySubmitAnswerInfo) it.next()));
        }
        return arrayList;
    }
}
