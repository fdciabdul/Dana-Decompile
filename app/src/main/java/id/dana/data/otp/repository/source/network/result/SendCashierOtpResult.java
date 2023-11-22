package id.dana.data.otp.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0018"}, d2 = {"Lid/dana/data/otp/repository/source/network/result/SendCashierOtpResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()I", "component2", "component3", "expirySeconds", "retrySendSeconds", "otpCodeLength", "copy", "(III)Lid/dana/data/otp/repository/source/network/result/SendCashierOtpResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getExpirySeconds", "setExpirySeconds", "(I)V", "getOtpCodeLength", "setOtpCodeLength", "getRetrySendSeconds", "setRetrySendSeconds", "<init>", "(III)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SendCashierOtpResult extends BaseRpcResultAphome {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @SerializedName("expirySeconds")
    private int expirySeconds;
    private int otpCodeLength;
    private int retrySendSeconds;

    public SendCashierOtpResult() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ SendCashierOtpResult copy$default(SendCashierOtpResult sendCashierOtpResult, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sendCashierOtpResult.expirySeconds;
        }
        if ((i4 & 2) != 0) {
            i2 = sendCashierOtpResult.retrySendSeconds;
        }
        if ((i4 & 4) != 0) {
            i3 = sendCashierOtpResult.otpCodeLength;
        }
        return sendCashierOtpResult.copy(i, i2, i3);
    }

    @JvmStatic
    public static final SendOtpResult toSendOtpResult(SendCashierOtpResult sendCashierOtpResult) {
        return INSTANCE.toSendOtpResult(sendCashierOtpResult);
    }

    /* renamed from: component1  reason: from getter */
    public final int getExpirySeconds() {
        return this.expirySeconds;
    }

    /* renamed from: component2  reason: from getter */
    public final int getRetrySendSeconds() {
        return this.retrySendSeconds;
    }

    /* renamed from: component3  reason: from getter */
    public final int getOtpCodeLength() {
        return this.otpCodeLength;
    }

    public final SendCashierOtpResult copy(int expirySeconds, int retrySendSeconds, int otpCodeLength) {
        return new SendCashierOtpResult(expirySeconds, retrySendSeconds, otpCodeLength);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SendCashierOtpResult) {
            SendCashierOtpResult sendCashierOtpResult = (SendCashierOtpResult) other;
            return this.expirySeconds == sendCashierOtpResult.expirySeconds && this.retrySendSeconds == sendCashierOtpResult.retrySendSeconds && this.otpCodeLength == sendCashierOtpResult.otpCodeLength;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.expirySeconds * 31) + this.retrySendSeconds) * 31) + this.otpCodeLength;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendCashierOtpResult(expirySeconds=");
        sb.append(this.expirySeconds);
        sb.append(", retrySendSeconds=");
        sb.append(this.retrySendSeconds);
        sb.append(", otpCodeLength=");
        sb.append(this.otpCodeLength);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ SendCashierOtpResult(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    @JvmName(name = "getExpirySeconds")
    public final int getExpirySeconds() {
        return this.expirySeconds;
    }

    @JvmName(name = "setExpirySeconds")
    public final void setExpirySeconds(int i) {
        this.expirySeconds = i;
    }

    @JvmName(name = "getRetrySendSeconds")
    public final int getRetrySendSeconds() {
        return this.retrySendSeconds;
    }

    @JvmName(name = "setRetrySendSeconds")
    public final void setRetrySendSeconds(int i) {
        this.retrySendSeconds = i;
    }

    @JvmName(name = "getOtpCodeLength")
    public final int getOtpCodeLength() {
        return this.otpCodeLength;
    }

    @JvmName(name = "setOtpCodeLength")
    public final void setOtpCodeLength(int i) {
        this.otpCodeLength = i;
    }

    public SendCashierOtpResult(int i, int i2, int i3) {
        this.expirySeconds = i;
        this.retrySendSeconds = i2;
        this.otpCodeLength = i3;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/otp/repository/source/network/result/SendCashierOtpResult$Companion;", "", "Lid/dana/data/otp/repository/source/network/result/SendCashierOtpResult;", "Lid/dana/data/otp/repository/source/network/result/SendOtpResult;", "toSendOtpResult", "(Lid/dana/data/otp/repository/source/network/result/SendCashierOtpResult;)Lid/dana/data/otp/repository/source/network/result/SendOtpResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SendOtpResult toSendOtpResult(SendCashierOtpResult sendCashierOtpResult) {
            Intrinsics.checkNotNullParameter(sendCashierOtpResult, "");
            SendOtpResult sendOtpResult = new SendOtpResult();
            sendOtpResult.expirySeconds = sendCashierOtpResult.getExpirySeconds();
            sendOtpResult.retrySendSeconds = sendCashierOtpResult.getRetrySendSeconds();
            sendOtpResult.otpCodeLength = sendCashierOtpResult.getOtpCodeLength();
            sendOtpResult.success = sendCashierOtpResult.success;
            sendOtpResult.errorCode = sendCashierOtpResult.errorCode;
            return sendOtpResult;
        }
    }
}
