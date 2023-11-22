package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.NpsSurveySubmitAnswerInfo;
import id.dana.cashier.domain.model.NpsSurveySubmitIdentifierInfo;
import id.dana.cashier.domain.model.NpsSurveySubmitRequest;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitAnswerModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitIdentifierModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitRequestModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "PlaceComponentResult", "(Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;)Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubmitNpsSurveyModelRequestMapperKt {
    public static final NpsSurveySubmitRequest PlaceComponentResult(NpsSurveySubmitRequestModel npsSurveySubmitRequestModel) {
        Intrinsics.checkNotNullParameter(npsSurveySubmitRequestModel, "");
        List<NpsSurveySubmitAnswerModel> list = npsSurveySubmitRequestModel.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(list, "");
        List<NpsSurveySubmitAnswerModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (NpsSurveySubmitAnswerModel npsSurveySubmitAnswerModel : list2) {
            Intrinsics.checkNotNullParameter(npsSurveySubmitAnswerModel, "");
            arrayList.add(new NpsSurveySubmitAnswerInfo(npsSurveySubmitAnswerModel.getAuthRequestContext, npsSurveySubmitAnswerModel.BuiltInFictitiousFunctionClassFactory, npsSurveySubmitAnswerModel.MyBillsEntityDataFactory));
        }
        ArrayList arrayList2 = arrayList;
        NpsSurveySubmitIdentifierModel npsSurveySubmitIdentifierModel = npsSurveySubmitRequestModel.MyBillsEntityDataFactory;
        String str = npsSurveySubmitIdentifierModel != null ? npsSurveySubmitIdentifierModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        NpsSurveySubmitIdentifierModel npsSurveySubmitIdentifierModel2 = npsSurveySubmitRequestModel.MyBillsEntityDataFactory;
        return new NpsSurveySubmitRequest(arrayList2, new NpsSurveySubmitIdentifierInfo(str, npsSurveySubmitIdentifierModel2 != null ? npsSurveySubmitIdentifierModel2.MyBillsEntityDataFactory : null), Boolean.valueOf(npsSurveySubmitRequestModel.getGetAuthRequestContext()));
    }
}
