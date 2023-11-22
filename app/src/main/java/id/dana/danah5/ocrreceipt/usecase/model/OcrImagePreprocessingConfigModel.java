package id.dana.danah5.ocrreceipt.usecase.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/danah5/ocrreceipt/usecase/model/OcrImagePreprocessingConfigModel;", "", "", "component1", "()Z", "", "component2", "()J", "enable", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "copy", "(ZJ)Lid/dana/danah5/ocrreceipt/usecase/model/OcrImagePreprocessingConfigModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getEnable", "J", "getTimeout", "<init>", "(ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class OcrImagePreprocessingConfigModel {
    private final boolean enable;
    private final long timeout;

    public static /* synthetic */ OcrImagePreprocessingConfigModel copy$default(OcrImagePreprocessingConfigModel ocrImagePreprocessingConfigModel, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ocrImagePreprocessingConfigModel.enable;
        }
        if ((i & 2) != 0) {
            j = ocrImagePreprocessingConfigModel.timeout;
        }
        return ocrImagePreprocessingConfigModel.copy(z, j);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    public final OcrImagePreprocessingConfigModel copy(boolean enable, long timeout) {
        return new OcrImagePreprocessingConfigModel(enable, timeout);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OcrImagePreprocessingConfigModel) {
            OcrImagePreprocessingConfigModel ocrImagePreprocessingConfigModel = (OcrImagePreprocessingConfigModel) other;
            return this.enable == ocrImagePreprocessingConfigModel.enable && this.timeout == ocrImagePreprocessingConfigModel.timeout;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.timeout);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OcrImagePreprocessingConfigModel(enable=");
        sb.append(this.enable);
        sb.append(", timeout=");
        sb.append(this.timeout);
        sb.append(')');
        return sb.toString();
    }

    public OcrImagePreprocessingConfigModel(boolean z, long j) {
        this.enable = z;
        this.timeout = j;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getTimeout")
    public final long getTimeout() {
        return this.timeout;
    }
}
