package id.dana.cashier.data.repository.source.network.result.npssurvey;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyInfoResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "scoreLimt", "Ljava/lang/Integer;", "getScoreLimt", "()Ljava/lang/Integer;", "", "showSurvey", "Ljava/lang/Boolean;", "getShowSurvey", "()Ljava/lang/Boolean;", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;", "survey", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;", "getSurvey", "()Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;", "", "surveyChannel", "Ljava/lang/String;", "getSurveyChannel", "()Ljava/lang/String;", "surveyId", "getSurveyId", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveyInfoResult extends BaseRpcResultAphome {
    private final Integer scoreLimt;
    private final Boolean showSurvey;
    private final ExtendNpsSurveyInfoResult survey;
    private final String surveyChannel;
    @SerializedName("surveyId")
    private final String surveyId;

    @JvmName(name = "getSurveyId")
    public final String getSurveyId() {
        return this.surveyId;
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
    public final ExtendNpsSurveyInfoResult getSurvey() {
        return this.survey;
    }

    public NpsSurveyInfoResult(String str, Boolean bool, Integer num, String str2, ExtendNpsSurveyInfoResult extendNpsSurveyInfoResult) {
        this.surveyId = str;
        this.showSurvey = bool;
        this.scoreLimt = num;
        this.surveyChannel = str2;
        this.survey = extendNpsSurveyInfoResult;
    }
}
