package id.dana.cashier.domain.model;

import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.passkey.Passkey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\"\u0010#R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u001c\u0010 \u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\f"}, d2 = {"Lid/dana/cashier/domain/model/NpsSurveyQuestion;", "", "", "Lid/dana/cashier/domain/model/NpsSurveyAnswer;", "answerList", "Ljava/util/List;", "getAnswerList", "()Ljava/util/List;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "", "id", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "index", "getIndex", LottieConstants.PARAM_MAX_VALUE, "getMax", LottieConstants.PARAM_MIN_VALUE, "getMin", "otherText", "getOtherText", "preAnswerId", "getPreAnswerId", SecurityConstants.KEY_QUESTION_TYPE, "getQuestionType", Passkey.REQUIRED, "getRequired", "title", "getTitle", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveyQuestion {
    private final List<NpsSurveyAnswer> answerList;
    private final String content;
    private final Integer id;
    private final Integer index;
    private final Integer max;
    private final Integer min;
    private final String otherText;
    private final Integer preAnswerId;
    private final Integer questionType;
    private final Integer required;
    private final String title;

    public NpsSurveyQuestion(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, String str, String str2, Integer num6, Integer num7, String str3, List<NpsSurveyAnswer> list) {
        this.id = num;
        this.index = num2;
        this.min = num3;
        this.questionType = num4;
        this.max = num5;
        this.title = str;
        this.otherText = str2;
        this.preAnswerId = num6;
        this.required = num7;
        this.content = str3;
        this.answerList = list;
    }

    @JvmName(name = "getId")
    public final Integer getId() {
        return this.id;
    }

    @JvmName(name = "getIndex")
    public final Integer getIndex() {
        return this.index;
    }

    @JvmName(name = "getMin")
    public final Integer getMin() {
        return this.min;
    }

    @JvmName(name = "getQuestionType")
    public final Integer getQuestionType() {
        return this.questionType;
    }

    @JvmName(name = "getMax")
    public final Integer getMax() {
        return this.max;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getOtherText")
    public final String getOtherText() {
        return this.otherText;
    }

    @JvmName(name = "getPreAnswerId")
    public final Integer getPreAnswerId() {
        return this.preAnswerId;
    }

    @JvmName(name = "getRequired")
    public final Integer getRequired() {
        return this.required;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getAnswerList")
    public final List<NpsSurveyAnswer> getAnswerList() {
        return this.answerList;
    }
}
