package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017"}, d2 = {"Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "", "", "scoreLimt", "Ljava/lang/Integer;", "getScoreLimt", "()Ljava/lang/Integer;", "", "showSurvey", "Ljava/lang/Boolean;", "getShowSurvey", "()Ljava/lang/Boolean;", "success", "getSuccess", "Lid/dana/cashier/domain/model/ExtendNpsSurveyInfo;", "survey", "Lid/dana/cashier/domain/model/ExtendNpsSurveyInfo;", "getSurvey", "()Lid/dana/cashier/domain/model/ExtendNpsSurveyInfo;", "", "surveyChannel", "Ljava/lang/String;", "getSurveyChannel", "()Ljava/lang/String;", "surveyId", "getSurveyId", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lid/dana/cashier/domain/model/ExtendNpsSurveyInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveyConsultInfo {
    private final Integer scoreLimt;
    private final Boolean showSurvey;
    private final Boolean success;
    private final ExtendNpsSurveyInfo survey;
    private final String surveyChannel;
    private final String surveyId;

    public NpsSurveyConsultInfo(String str, Boolean bool, Boolean bool2, Integer num, String str2, ExtendNpsSurveyInfo extendNpsSurveyInfo) {
        this.surveyId = str;
        this.success = bool;
        this.showSurvey = bool2;
        this.scoreLimt = num;
        this.surveyChannel = str2;
        this.survey = extendNpsSurveyInfo;
    }

    @JvmName(name = "getSurveyId")
    public final String getSurveyId() {
        return this.surveyId;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getShowSurvey")
    public final Boolean getShowSurvey() {
        return this.showSurvey;
    }

    @JvmName(name = "getScoreLimt")
    public final Integer getScoreLimt() {
        return this.scoreLimt;
    }

    @JvmName(name = "getSurveyChannel")
    public final String getSurveyChannel() {
        return this.surveyChannel;
    }

    @JvmName(name = "getSurvey")
    public final ExtendNpsSurveyInfo getSurvey() {
        return this.survey;
    }
}
