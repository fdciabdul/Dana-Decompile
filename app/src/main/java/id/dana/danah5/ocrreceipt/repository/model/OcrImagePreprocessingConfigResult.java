package id.dana.danah5.ocrreceipt.repository.model;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danah5/ocrreceipt/repository/model/OcrImagePreprocessingConfigResult;", "", "", "enable", "Z", "getEnable", "()Z", "", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "J", "getTimeout", "()J", "<init>", "(ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class OcrImagePreprocessingConfigResult {
    private final boolean enable;
    private final long timeout;

    public OcrImagePreprocessingConfigResult() {
        this(false, 0L, 3, null);
    }

    public OcrImagePreprocessingConfigResult(boolean z, long j) {
        this.enable = z;
        this.timeout = j;
    }

    public /* synthetic */ OcrImagePreprocessingConfigResult(boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j);
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
