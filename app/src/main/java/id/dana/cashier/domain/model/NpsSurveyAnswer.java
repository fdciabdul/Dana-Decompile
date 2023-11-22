package id.dana.cashier.domain.model;

import com.alibaba.ariver.kernel.RVParams;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/NpsSurveyAnswer;", "", "", "descAnswer", "Ljava/lang/String;", "getDescAnswer", "()Ljava/lang/String;", "", "exclusive", "Ljava/lang/Integer;", "getExclusive", "()Ljava/lang/Integer;", "index", "getIndex", Constants.ScionAnalytics.PARAM_LABEL, "getLabel", "optionType", "getOptionType", RVParams.LONG_SUB_TITLE, "getSubTitle", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveyAnswer {
    private final String descAnswer;
    private final Integer exclusive;
    private final String index;
    private final String label;
    private final String optionType;
    private final String subTitle;
    private final String value;

    public NpsSurveyAnswer(String str, Integer num, String str2, String str3, String str4, String str5, String str6) {
        this.optionType = str;
        this.exclusive = num;
        this.descAnswer = str2;
        this.label = str3;
        this.value = str4;
        this.subTitle = str5;
        this.index = str6;
    }

    @JvmName(name = "getOptionType")
    public final String getOptionType() {
        return this.optionType;
    }

    @JvmName(name = "getExclusive")
    public final Integer getExclusive() {
        return this.exclusive;
    }

    @JvmName(name = "getDescAnswer")
    public final String getDescAnswer() {
        return this.descAnswer;
    }

    @JvmName(name = "getLabel")
    public final String getLabel() {
        return this.label;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "getSubTitle")
    public final String getSubTitle() {
        return this.subTitle;
    }

    @JvmName(name = "getIndex")
    public final String getIndex() {
        return this.index;
    }
}
