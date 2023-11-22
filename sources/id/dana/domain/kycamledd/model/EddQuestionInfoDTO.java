package id.dana.domain.kycamledd.model;

import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f"}, d2 = {"Lid/dana/domain/kycamledd/model/EddQuestionInfoDTO;", "", "", "Lid/dana/domain/kycamledd/model/EddAnswerInfoDTO;", "eddAnswerInfos", "Ljava/util/List;", "getEddAnswerInfos", "()Ljava/util/List;", "", RequestConstants.KEY_QUESTION, "Ljava/lang/String;", "getQuestion", "()Ljava/lang/String;", "questionId", "getQuestionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EddQuestionInfoDTO {
    private final List<EddAnswerInfoDTO> eddAnswerInfos;
    private final String question;
    private final String questionId;

    public EddQuestionInfoDTO(String str, String str2, List<EddAnswerInfoDTO> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.questionId = str;
        this.question = str2;
        this.eddAnswerInfos = list;
    }

    @JvmName(name = "getQuestionId")
    public final String getQuestionId() {
        return this.questionId;
    }

    @JvmName(name = "getQuestion")
    public final String getQuestion() {
        return this.question;
    }

    @JvmName(name = "getEddAnswerInfos")
    public final List<EddAnswerInfoDTO> getEddAnswerInfos() {
        return this.eddAnswerInfos;
    }
}
