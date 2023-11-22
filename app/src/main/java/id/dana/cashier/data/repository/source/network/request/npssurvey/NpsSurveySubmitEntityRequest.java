package id.dana.cashier.data.repository.source.network.request.npssurvey;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "npsFlag", "Ljava/lang/Boolean;", "getNpsFlag", "()Ljava/lang/Boolean;", "", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitAnswerEntity;", "surveyAnswerDTOS", "Ljava/util/List;", "getSurveyAnswerDTOS", "()Ljava/util/List;", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitIdentifierEntity;", "surveyIdentifierDTO", "Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitIdentifierEntity;", "getSurveyIdentifierDTO", "()Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitIdentifierEntity;", "<init>", "(Ljava/util/List;Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitIdentifierEntity;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveySubmitEntityRequest extends BaseRpcRequest {
    private final Boolean npsFlag;
    @SerializedName("surveyAnswerDTOS")
    private final List<NpsSurveySubmitAnswerEntity> surveyAnswerDTOS;
    private final NpsSurveySubmitIdentifierEntity surveyIdentifierDTO;

    @JvmName(name = "getSurveyAnswerDTOS")
    public final List<NpsSurveySubmitAnswerEntity> getSurveyAnswerDTOS() {
        return this.surveyAnswerDTOS;
    }

    @JvmName(name = "getSurveyIdentifierDTO")
    public final NpsSurveySubmitIdentifierEntity getSurveyIdentifierDTO() {
        return this.surveyIdentifierDTO;
    }

    @JvmName(name = "getNpsFlag")
    public final Boolean getNpsFlag() {
        return this.npsFlag;
    }

    public NpsSurveySubmitEntityRequest(List<NpsSurveySubmitAnswerEntity> list, NpsSurveySubmitIdentifierEntity npsSurveySubmitIdentifierEntity, Boolean bool) {
        this.surveyAnswerDTOS = list;
        this.surveyIdentifierDTO = npsSurveySubmitIdentifierEntity;
        this.npsFlag = bool;
    }
}
