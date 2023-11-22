package id.dana.data.homeinfo.mapper;

import id.dana.data.homeinfo.repository.source.network.result.ProcessingTransactionResult;
import id.dana.data.homeinfo.repository.source.network.result.ProcessingTransactionResultWrapper;
import id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResult;
import id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResultWrapper;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResultWrapper;", "Lid/dana/domain/homeinfo/ProcessingTransactionModel;", "toProcessingTransactionModel", "(Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResultWrapper;)Lid/dana/domain/homeinfo/ProcessingTransactionModel;", "Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;", "Lid/dana/domain/wallet_v3/model/SurveyInfoModel;", "toSurveyInfoModel", "(Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;)Lid/dana/domain/wallet_v3/model/SurveyInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeOmniResultMapperKt {
    public static final SurveyInfoModel toSurveyInfoModel(SurveyInfoResultWrapper surveyInfoResultWrapper) {
        Boolean hasActiveSurvey;
        Intrinsics.checkNotNullParameter(surveyInfoResultWrapper, "");
        SurveyInfoResult surveyInfo = surveyInfoResultWrapper.getSurveyInfo();
        boolean booleanValue = (surveyInfo == null || (hasActiveSurvey = surveyInfo.getHasActiveSurvey()) == null) ? false : hasActiveSurvey.booleanValue();
        SurveyInfoResult surveyInfo2 = surveyInfoResultWrapper.getSurveyInfo();
        String innerUrl = surveyInfo2 != null ? surveyInfo2.getInnerUrl() : null;
        return new SurveyInfoModel(booleanValue, innerUrl != null ? innerUrl : "");
    }

    public static final ProcessingTransactionModel toProcessingTransactionModel(ProcessingTransactionResultWrapper processingTransactionResultWrapper) {
        Boolean hasMore;
        Integer count;
        Intrinsics.checkNotNullParameter(processingTransactionResultWrapper, "");
        ProcessingTransactionResult processingTrans = processingTransactionResultWrapper.getProcessingTrans();
        boolean z = false;
        int intValue = (processingTrans == null || (count = processingTrans.getCount()) == null) ? 0 : count.intValue();
        ProcessingTransactionResult processingTrans2 = processingTransactionResultWrapper.getProcessingTrans();
        if (processingTrans2 != null && (hasMore = processingTrans2.getHasMore()) != null) {
            z = hasMore.booleanValue();
        }
        return new ProcessingTransactionModel(intValue, z);
    }
}
