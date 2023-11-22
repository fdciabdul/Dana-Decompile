package id.dana.cashier.data.repository.source.network.result.npssurvey;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/npssurvey/ExtendNpsSurveyInfoResult;", "", "", "created", "Ljava/lang/String;", "getCreated", "()Ljava/lang/String;", "description", "getDescription", "", "id", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", HummerConstants.HUMMER_NEXT, "getNext", "project", "getProject", "questionCount", "getQuestionCount", "", "Lid/dana/cashier/data/repository/source/network/result/npssurvey/NpsSurveyQuestionResult;", "questionList", "Ljava/util/List;", "getQuestionList", "()Ljava/util/List;", "requiredCount", "getRequiredCount", "status", "getStatus", "title", "getTitle", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtendNpsSurveyInfoResult {
    private final String created;
    private final String description;
    private final Integer id;
    private final Integer next;
    private final Integer project;
    private final Integer questionCount;
    private final List<NpsSurveyQuestionResult> questionList;
    private final Integer requiredCount;
    private final Integer status;
    private final String title;

    public ExtendNpsSurveyInfoResult(Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, Integer num5, String str3, Integer num6, List<NpsSurveyQuestionResult> list) {
        this.id = num;
        this.status = num2;
        this.questionCount = num3;
        this.next = num4;
        this.title = str;
        this.created = str2;
        this.project = num5;
        this.description = str3;
        this.requiredCount = num6;
        this.questionList = list;
    }

    @JvmName(name = "getId")
    public final Integer getId() {
        return this.id;
    }

    @JvmName(name = "getStatus")
    public final Integer getStatus() {
        return this.status;
    }

    @JvmName(name = "getQuestionCount")
    public final Integer getQuestionCount() {
        return this.questionCount;
    }

    @JvmName(name = "getNext")
    public final Integer getNext() {
        return this.next;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getCreated")
    public final String getCreated() {
        return this.created;
    }

    @JvmName(name = "getProject")
    public final Integer getProject() {
        return this.project;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getRequiredCount")
    public final Integer getRequiredCount() {
        return this.requiredCount;
    }

    @JvmName(name = "getQuestionList")
    public final List<NpsSurveyQuestionResult> getQuestionList() {
        return this.questionList;
    }
}
