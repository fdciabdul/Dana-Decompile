package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.ExtendNpsSurveyInfo;
import id.dana.cashier.domain.model.NpsSurveyAnswer;
import id.dana.cashier.domain.model.NpsSurveyConsultInfo;
import id.dana.cashier.domain.model.NpsSurveyQuestion;
import id.dana.cashier.model.npssurvey.ExtendNpsSurveyModel;
import id.dana.cashier.model.npssurvey.NpsSurveyAnswerModel;
import id.dana.cashier.model.npssurvey.NpsSurveyModel;
import id.dana.cashier.model.npssurvey.NpsSurveyQuestionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "Lid/dana/cashier/model/npssurvey/NpsSurveyModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;)Lid/dana/cashier/model/npssurvey/NpsSurveyModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchNpsSurveyModelMapperKt {
    public static final NpsSurveyModel BuiltInFictitiousFunctionClassFactory(NpsSurveyConsultInfo npsSurveyConsultInfo) {
        Integer num;
        String str;
        ExtendNpsSurveyModel extendNpsSurveyModel;
        ArrayList arrayList;
        Iterator it;
        Integer num2;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(npsSurveyConsultInfo, "");
        String surveyId = npsSurveyConsultInfo.getSurveyId();
        Boolean success = npsSurveyConsultInfo.getSuccess();
        Boolean showSurvey = npsSurveyConsultInfo.getShowSurvey();
        Integer scoreLimt = npsSurveyConsultInfo.getScoreLimt();
        String surveyChannel = npsSurveyConsultInfo.getSurveyChannel();
        ExtendNpsSurveyInfo survey = npsSurveyConsultInfo.getSurvey();
        if (survey != null) {
            Intrinsics.checkNotNullParameter(survey, "");
            Integer id2 = survey.getId();
            Integer status = survey.getStatus();
            Integer questionCount = survey.getQuestionCount();
            Integer next = survey.getNext();
            String title = survey.getTitle();
            String created = survey.getCreated();
            Integer project = survey.getProject();
            String description = survey.getDescription();
            Integer requiredCount = survey.getRequiredCount();
            List<NpsSurveyQuestion> questionList = survey.getQuestionList();
            if (questionList != null) {
                Intrinsics.checkNotNullParameter(questionList, "");
                List<NpsSurveyQuestion> list = questionList;
                str = surveyChannel;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    NpsSurveyQuestion npsSurveyQuestion = (NpsSurveyQuestion) it2.next();
                    Intrinsics.checkNotNullParameter(npsSurveyQuestion, "");
                    Integer id3 = npsSurveyQuestion.getId();
                    Integer index = npsSurveyQuestion.getIndex();
                    Integer min = npsSurveyQuestion.getMin();
                    Integer questionType = npsSurveyQuestion.getQuestionType();
                    Integer max = npsSurveyQuestion.getMax();
                    String title2 = npsSurveyQuestion.getTitle();
                    String otherText = npsSurveyQuestion.getOtherText();
                    Integer preAnswerId = npsSurveyQuestion.getPreAnswerId();
                    Integer required = npsSurveyQuestion.getRequired();
                    String content = npsSurveyQuestion.getContent();
                    List<NpsSurveyAnswer> answerList = npsSurveyQuestion.getAnswerList();
                    if (answerList != null) {
                        Intrinsics.checkNotNullParameter(answerList, "");
                        List<NpsSurveyAnswer> list2 = answerList;
                        it = it2;
                        num2 = scoreLimt;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        for (NpsSurveyAnswer npsSurveyAnswer : list2) {
                            Intrinsics.checkNotNullParameter(npsSurveyAnswer, "");
                            arrayList4.add(new NpsSurveyAnswerModel(npsSurveyAnswer.getOptionType(), npsSurveyAnswer.getExclusive(), npsSurveyAnswer.getDescAnswer(), npsSurveyAnswer.getLabel(), npsSurveyAnswer.getValue(), npsSurveyAnswer.getSubTitle(), npsSurveyAnswer.getIndex()));
                        }
                        arrayList2 = arrayList4;
                    } else {
                        it = it2;
                        num2 = scoreLimt;
                        arrayList2 = null;
                    }
                    arrayList3.add(new NpsSurveyQuestionModel(id3, index, min, questionType, max, title2, otherText, preAnswerId, required, content, arrayList2));
                    it2 = it;
                    scoreLimt = num2;
                }
                num = scoreLimt;
                arrayList = arrayList3;
            } else {
                num = scoreLimt;
                str = surveyChannel;
                arrayList = null;
            }
            extendNpsSurveyModel = new ExtendNpsSurveyModel(id2, status, questionCount, next, title, created, project, description, requiredCount, arrayList);
        } else {
            num = scoreLimt;
            str = surveyChannel;
            extendNpsSurveyModel = null;
        }
        return new NpsSurveyModel(surveyId, success, showSurvey, num, str, extendNpsSurveyModel);
    }
}
