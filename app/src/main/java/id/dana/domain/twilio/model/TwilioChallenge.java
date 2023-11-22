package id.dana.domain.twilio.model;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J<\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/model/TwilioChallenge;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/Map;", "component3", "scene", "challengeInfo", TwilioIdentityVerificationActivity.CHALLENGE_SID, "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lid/dana/domain/twilio/model/TwilioChallenge;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getChallengeInfo", "Ljava/lang/String;", "getChallengeSid", "getScene", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TwilioChallenge {
    private final Map<String, String> challengeInfo;
    private final String challengeSid;
    private final String scene;

    public TwilioChallenge() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TwilioChallenge copy$default(TwilioChallenge twilioChallenge, String str, Map map, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = twilioChallenge.scene;
        }
        if ((i & 2) != 0) {
            map = twilioChallenge.challengeInfo;
        }
        if ((i & 4) != 0) {
            str2 = twilioChallenge.challengeSid;
        }
        return twilioChallenge.copy(str, map, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    public final Map<String, String> component2() {
        return this.challengeInfo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getChallengeSid() {
        return this.challengeSid;
    }

    public final TwilioChallenge copy(String scene, Map<String, String> challengeInfo, String challengeSid) {
        Intrinsics.checkNotNullParameter(scene, "");
        Intrinsics.checkNotNullParameter(challengeInfo, "");
        return new TwilioChallenge(scene, challengeInfo, challengeSid);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TwilioChallenge) {
            TwilioChallenge twilioChallenge = (TwilioChallenge) other;
            return Intrinsics.areEqual(this.scene, twilioChallenge.scene) && Intrinsics.areEqual(this.challengeInfo, twilioChallenge.challengeInfo) && Intrinsics.areEqual(this.challengeSid, twilioChallenge.challengeSid);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.scene.hashCode();
        int hashCode2 = this.challengeInfo.hashCode();
        String str = this.challengeSid;
        return (((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwilioChallenge(scene=");
        sb.append(this.scene);
        sb.append(", challengeInfo=");
        sb.append(this.challengeInfo);
        sb.append(", challengeSid=");
        sb.append(this.challengeSid);
        sb.append(')');
        return sb.toString();
    }

    public TwilioChallenge(String str, Map<String, String> map, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.scene = str;
        this.challengeInfo = map;
        this.challengeSid = str2;
    }

    @JvmName(name = "getScene")
    public final String getScene() {
        return this.scene;
    }

    public /* synthetic */ TwilioChallenge(String str, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getChallengeInfo")
    public final Map<String, String> getChallengeInfo() {
        return this.challengeInfo;
    }

    @JvmName(name = "getChallengeSid")
    public final String getChallengeSid() {
        return this.challengeSid;
    }
}
