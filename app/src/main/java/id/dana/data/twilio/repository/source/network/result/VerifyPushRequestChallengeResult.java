package id.dana.data.twilio.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", TwilioIdentityVerificationActivity.CHALLENGE_SID, "timer", "action", "copy", "(Ljava/lang/String;ILjava/lang/String;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAction", "getChallengeSid", "I", "getTimer", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyPushRequestChallengeResult extends BaseRpcResult {
    private final String action;
    private final String challengeSid;
    private final int timer;

    public VerifyPushRequestChallengeResult() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ VerifyPushRequestChallengeResult copy$default(VerifyPushRequestChallengeResult verifyPushRequestChallengeResult, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = verifyPushRequestChallengeResult.challengeSid;
        }
        if ((i2 & 2) != 0) {
            i = verifyPushRequestChallengeResult.timer;
        }
        if ((i2 & 4) != 0) {
            str2 = verifyPushRequestChallengeResult.action;
        }
        return verifyPushRequestChallengeResult.copy(str, i, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getChallengeSid() {
        return this.challengeSid;
    }

    /* renamed from: component2  reason: from getter */
    public final int getTimer() {
        return this.timer;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final VerifyPushRequestChallengeResult copy(String challengeSid, int timer, String action) {
        Intrinsics.checkNotNullParameter(challengeSid, "");
        Intrinsics.checkNotNullParameter(action, "");
        return new VerifyPushRequestChallengeResult(challengeSid, timer, action);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPushRequestChallengeResult) {
            VerifyPushRequestChallengeResult verifyPushRequestChallengeResult = (VerifyPushRequestChallengeResult) other;
            return Intrinsics.areEqual(this.challengeSid, verifyPushRequestChallengeResult.challengeSid) && this.timer == verifyPushRequestChallengeResult.timer && Intrinsics.areEqual(this.action, verifyPushRequestChallengeResult.action);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.challengeSid.hashCode() * 31) + this.timer) * 31) + this.action.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPushRequestChallengeResult(challengeSid=");
        sb.append(this.challengeSid);
        sb.append(", timer=");
        sb.append(this.timer);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifyPushRequestChallengeResult(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2);
    }

    @JvmName(name = "getChallengeSid")
    public final String getChallengeSid() {
        return this.challengeSid;
    }

    @JvmName(name = "getTimer")
    public final int getTimer() {
        return this.timer;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    public VerifyPushRequestChallengeResult(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.challengeSid = str;
        this.timer = i;
        this.action = str2;
    }
}
