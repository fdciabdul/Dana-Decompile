package id.dana.data.kycamledd.repository.source.network.response;

import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/data/kycamledd/repository/source/network/response/EddQuestionInfoDTOResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lid/dana/data/kycamledd/repository/source/network/response/EddAnswerInfoDTOResponse;", "component3", "()Ljava/util/List;", "questionId", RequestConstants.KEY_QUESTION, "eddAnswerInfos", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/data/kycamledd/repository/source/network/response/EddQuestionInfoDTOResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getEddAnswerInfos", "Ljava/lang/String;", "getQuestion", "getQuestionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EddQuestionInfoDTOResponse {
    private final List<EddAnswerInfoDTOResponse> eddAnswerInfos;
    private final String question;
    private final String questionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EddQuestionInfoDTOResponse copy$default(EddQuestionInfoDTOResponse eddQuestionInfoDTOResponse, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eddQuestionInfoDTOResponse.questionId;
        }
        if ((i & 2) != 0) {
            str2 = eddQuestionInfoDTOResponse.question;
        }
        if ((i & 4) != 0) {
            list = eddQuestionInfoDTOResponse.eddAnswerInfos;
        }
        return eddQuestionInfoDTOResponse.copy(str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getQuestionId() {
        return this.questionId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public final List<EddAnswerInfoDTOResponse> component3() {
        return this.eddAnswerInfos;
    }

    public final EddQuestionInfoDTOResponse copy(String questionId, String question, List<EddAnswerInfoDTOResponse> eddAnswerInfos) {
        Intrinsics.checkNotNullParameter(questionId, "");
        Intrinsics.checkNotNullParameter(question, "");
        Intrinsics.checkNotNullParameter(eddAnswerInfos, "");
        return new EddQuestionInfoDTOResponse(questionId, question, eddAnswerInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EddQuestionInfoDTOResponse) {
            EddQuestionInfoDTOResponse eddQuestionInfoDTOResponse = (EddQuestionInfoDTOResponse) other;
            return Intrinsics.areEqual(this.questionId, eddQuestionInfoDTOResponse.questionId) && Intrinsics.areEqual(this.question, eddQuestionInfoDTOResponse.question) && Intrinsics.areEqual(this.eddAnswerInfos, eddQuestionInfoDTOResponse.eddAnswerInfos);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.questionId.hashCode() * 31) + this.question.hashCode()) * 31) + this.eddAnswerInfos.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EddQuestionInfoDTOResponse(questionId=");
        sb.append(this.questionId);
        sb.append(", question=");
        sb.append(this.question);
        sb.append(", eddAnswerInfos=");
        sb.append(this.eddAnswerInfos);
        sb.append(')');
        return sb.toString();
    }

    public EddQuestionInfoDTOResponse(String str, String str2, List<EddAnswerInfoDTOResponse> list) {
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
    public final List<EddAnswerInfoDTOResponse> getEddAnswerInfos() {
        return this.eddAnswerInfos;
    }
}
