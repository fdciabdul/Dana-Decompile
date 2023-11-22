package id.dana.cashier.data.repository.source.network.request.npssurvey;

import com.google.gson.annotations.SerializedName;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/npssurvey/NpsSurveySubmitAnswerEntity;", "", "", DecodedScanBizInfoKey.COMMENT, "Ljava/lang/String;", "getComment", "()Ljava/lang/String;", "", "id", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "value", "getValue", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveySubmitAnswerEntity {
    private final String comment;
    @SerializedName("id")
    private final Integer id;
    private final String value;

    public NpsSurveySubmitAnswerEntity(Integer num, String str, String str2) {
        this.id = num;
        this.value = str;
        this.comment = str2;
    }

    @JvmName(name = "getId")
    public final Integer getId() {
        return this.id;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "getComment")
    public final String getComment() {
        return this.comment;
    }
}
