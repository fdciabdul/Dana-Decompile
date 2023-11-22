package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.npssurvey.ExtendNpsSurveyInfoResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveyAnswerResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveyInfoResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveyQuestionResult;
import id.dana.cashier.domain.model.ExtendNpsSurveyInfo;
import id.dana.cashier.domain.model.NpsSurveyAnswer;
import id.dana.cashier.domain.model.NpsSurveyConsultInfo;
import id.dana.cashier.domain.model.NpsSurveyQuestion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004*\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000b\u0010\b\u001a\u0011\u0010\f\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;", "Lid/dana/cashier/domain/model/ExtendNpsSurveyInfo;", "toExtendNpsSurveyInfo", "(Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;)Lid/dana/cashier/domain/model/ExtendNpsSurveyInfo;", "", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyAnswerResult;", "Lid/dana/cashier/domain/model/NpsSurveyAnswer;", "toListNpsSurveyAnswer", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyQuestionResult;", "Lid/dana/cashier/domain/model/NpsSurveyQuestion;", "toListNpsSurveyQuestion", "toNpsSurveyAnswer", "(Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyAnswerResult;)Lid/dana/cashier/domain/model/NpsSurveyAnswer;", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyInfoResult;", "Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "toNpsSurveyConsult", "(Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyInfoResult;)Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "toNpsSurveyQuestion", "(Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyQuestionResult;)Lid/dana/cashier/domain/model/NpsSurveyQuestion;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchNpsSurveyResultMapperKt {
    public static final NpsSurveyConsultInfo toNpsSurveyConsult(NpsSurveyInfoResult npsSurveyInfoResult) {
        Intrinsics.checkNotNullParameter(npsSurveyInfoResult, "");
        String surveyId = npsSurveyInfoResult.getSurveyId();
        boolean z = npsSurveyInfoResult.success;
        Boolean showSurvey = npsSurveyInfoResult.getShowSurvey();
        Integer scoreLimt = npsSurveyInfoResult.getScoreLimt();
        String surveyChannel = npsSurveyInfoResult.getSurveyChannel();
        ExtendNpsSurveyInfoResult survey = npsSurveyInfoResult.getSurvey();
        return new NpsSurveyConsultInfo(surveyId, Boolean.valueOf(z), showSurvey, scoreLimt, surveyChannel, survey != null ? toExtendNpsSurveyInfo(survey) : null);
    }

    public static final ExtendNpsSurveyInfo toExtendNpsSurveyInfo(ExtendNpsSurveyInfoResult extendNpsSurveyInfoResult) {
        Intrinsics.checkNotNullParameter(extendNpsSurveyInfoResult, "");
        Integer id2 = extendNpsSurveyInfoResult.getId();
        Integer status = extendNpsSurveyInfoResult.getStatus();
        Integer questionCount = extendNpsSurveyInfoResult.getQuestionCount();
        Integer next = extendNpsSurveyInfoResult.getNext();
        String title = extendNpsSurveyInfoResult.getTitle();
        String created = extendNpsSurveyInfoResult.getCreated();
        Integer project = extendNpsSurveyInfoResult.getProject();
        String description = extendNpsSurveyInfoResult.getDescription();
        Integer requiredCount = extendNpsSurveyInfoResult.getRequiredCount();
        List<NpsSurveyQuestionResult> questionList = extendNpsSurveyInfoResult.getQuestionList();
        return new ExtendNpsSurveyInfo(id2, status, questionCount, next, title, created, project, description, requiredCount, questionList != null ? toListNpsSurveyQuestion(questionList) : null);
    }

    public static final NpsSurveyQuestion toNpsSurveyQuestion(NpsSurveyQuestionResult npsSurveyQuestionResult) {
        Intrinsics.checkNotNullParameter(npsSurveyQuestionResult, "");
        Integer id2 = npsSurveyQuestionResult.getId();
        Integer index = npsSurveyQuestionResult.getIndex();
        Integer min = npsSurveyQuestionResult.getMin();
        Integer questionType = npsSurveyQuestionResult.getQuestionType();
        Integer max = npsSurveyQuestionResult.getMax();
        String title = npsSurveyQuestionResult.getTitle();
        String otherText = npsSurveyQuestionResult.getOtherText();
        Integer preAnswerId = npsSurveyQuestionResult.getPreAnswerId();
        Integer required = npsSurveyQuestionResult.getRequired();
        String content = npsSurveyQuestionResult.getContent();
        List<NpsSurveyAnswerResult> answerList = npsSurveyQuestionResult.getAnswerList();
        return new NpsSurveyQuestion(id2, index, min, questionType, max, title, otherText, preAnswerId, required, content, answerList != null ? toListNpsSurveyAnswer(answerList) : null);
    }

    public static final List<NpsSurveyQuestion> toListNpsSurveyQuestion(List<NpsSurveyQuestionResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<NpsSurveyQuestionResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toNpsSurveyQuestion((NpsSurveyQuestionResult) it.next()));
        }
        return arrayList;
    }

    public static final NpsSurveyAnswer toNpsSurveyAnswer(NpsSurveyAnswerResult npsSurveyAnswerResult) {
        Intrinsics.checkNotNullParameter(npsSurveyAnswerResult, "");
        return new NpsSurveyAnswer(npsSurveyAnswerResult.getOptionType(), npsSurveyAnswerResult.getExclusive(), npsSurveyAnswerResult.getDescAnswer(), npsSurveyAnswerResult.getLabel(), npsSurveyAnswerResult.getValue(), npsSurveyAnswerResult.getSubTitle(), npsSurveyAnswerResult.getIndex());
    }

    public static final List<NpsSurveyAnswer> toListNpsSurveyAnswer(List<NpsSurveyAnswerResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<NpsSurveyAnswerResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toNpsSurveyAnswer((NpsSurveyAnswerResult) it.next()));
        }
        return arrayList;
    }
}
