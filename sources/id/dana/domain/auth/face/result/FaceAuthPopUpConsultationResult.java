package id.dana.domain.auth.face.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001cR\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u001f\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\t\u0010\u0004\"\u0004\b \u0010\u001cR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\f\u0010\u0004\"\u0004\b!\u0010\u001cR\u0011\u0010#\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\"\u0010\u0004R\u0011\u0010%\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "isFaceLoginFeatureEnabled", "isFaceLoginEnabled", "hasFaceLoginEnrolled", "isFaceLoginReady", "alreadyKyc", "copy", "(ZZZZZ)Lid/dana/domain/auth/face/result/FaceAuthPopUpConsultationResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getAlreadyKyc", "setAlreadyKyc", "(Z)V", "getHasFaceLoginEnrolled", "setHasFaceLoginEnrolled", "setFaceLoginEnabled", "setFaceLoginFeatureEnabled", "setFaceLoginReady", "getShouldShowPopUp", "shouldShowPopUp", "getShouldShowProfileCompletionTask", "shouldShowProfileCompletionTask", "<init>", "(ZZZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FaceAuthPopUpConsultationResult {
    private boolean alreadyKyc;
    private boolean hasFaceLoginEnrolled;
    private boolean isFaceLoginEnabled;
    private boolean isFaceLoginFeatureEnabled;
    private boolean isFaceLoginReady;

    public FaceAuthPopUpConsultationResult() {
        this(false, false, false, false, false, 31, null);
    }

    public static /* synthetic */ FaceAuthPopUpConsultationResult copy$default(FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = faceAuthPopUpConsultationResult.isFaceLoginFeatureEnabled;
        }
        if ((i & 2) != 0) {
            z2 = faceAuthPopUpConsultationResult.isFaceLoginEnabled;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = faceAuthPopUpConsultationResult.hasFaceLoginEnrolled;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = faceAuthPopUpConsultationResult.isFaceLoginReady;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = faceAuthPopUpConsultationResult.alreadyKyc;
        }
        return faceAuthPopUpConsultationResult.copy(z, z6, z7, z8, z5);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsFaceLoginFeatureEnabled() {
        return this.isFaceLoginFeatureEnabled;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getIsFaceLoginEnabled() {
        return this.isFaceLoginEnabled;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasFaceLoginEnrolled() {
        return this.hasFaceLoginEnrolled;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getIsFaceLoginReady() {
        return this.isFaceLoginReady;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getAlreadyKyc() {
        return this.alreadyKyc;
    }

    public final FaceAuthPopUpConsultationResult copy(boolean isFaceLoginFeatureEnabled, boolean isFaceLoginEnabled, boolean hasFaceLoginEnrolled, boolean isFaceLoginReady, boolean alreadyKyc) {
        return new FaceAuthPopUpConsultationResult(isFaceLoginFeatureEnabled, isFaceLoginEnabled, hasFaceLoginEnrolled, isFaceLoginReady, alreadyKyc);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FaceAuthPopUpConsultationResult) {
            FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult = (FaceAuthPopUpConsultationResult) other;
            return this.isFaceLoginFeatureEnabled == faceAuthPopUpConsultationResult.isFaceLoginFeatureEnabled && this.isFaceLoginEnabled == faceAuthPopUpConsultationResult.isFaceLoginEnabled && this.hasFaceLoginEnrolled == faceAuthPopUpConsultationResult.hasFaceLoginEnrolled && this.isFaceLoginReady == faceAuthPopUpConsultationResult.isFaceLoginReady && this.alreadyKyc == faceAuthPopUpConsultationResult.alreadyKyc;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.isFaceLoginFeatureEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.isFaceLoginEnabled;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        ?? r3 = this.hasFaceLoginEnrolled;
        int i2 = r3;
        if (r3 != 0) {
            i2 = 1;
        }
        ?? r4 = this.isFaceLoginReady;
        int i3 = r4;
        if (r4 != 0) {
            i3 = 1;
        }
        boolean z2 = this.alreadyKyc;
        return (((((((r0 * 31) + i) * 31) + i2) * 31) + i3) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FaceAuthPopUpConsultationResult(isFaceLoginFeatureEnabled=");
        sb.append(this.isFaceLoginFeatureEnabled);
        sb.append(", isFaceLoginEnabled=");
        sb.append(this.isFaceLoginEnabled);
        sb.append(", hasFaceLoginEnrolled=");
        sb.append(this.hasFaceLoginEnrolled);
        sb.append(", isFaceLoginReady=");
        sb.append(this.isFaceLoginReady);
        sb.append(", alreadyKyc=");
        sb.append(this.alreadyKyc);
        sb.append(')');
        return sb.toString();
    }

    public FaceAuthPopUpConsultationResult(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.isFaceLoginFeatureEnabled = z;
        this.isFaceLoginEnabled = z2;
        this.hasFaceLoginEnrolled = z3;
        this.isFaceLoginReady = z4;
        this.alreadyKyc = z5;
    }

    public /* synthetic */ FaceAuthPopUpConsultationResult(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5);
    }

    @JvmName(name = "isFaceLoginFeatureEnabled")
    public final boolean isFaceLoginFeatureEnabled() {
        return this.isFaceLoginFeatureEnabled;
    }

    @JvmName(name = "setFaceLoginFeatureEnabled")
    public final void setFaceLoginFeatureEnabled(boolean z) {
        this.isFaceLoginFeatureEnabled = z;
    }

    @JvmName(name = "isFaceLoginEnabled")
    public final boolean isFaceLoginEnabled() {
        return this.isFaceLoginEnabled;
    }

    @JvmName(name = "setFaceLoginEnabled")
    public final void setFaceLoginEnabled(boolean z) {
        this.isFaceLoginEnabled = z;
    }

    @JvmName(name = "getHasFaceLoginEnrolled")
    public final boolean getHasFaceLoginEnrolled() {
        return this.hasFaceLoginEnrolled;
    }

    @JvmName(name = "setHasFaceLoginEnrolled")
    public final void setHasFaceLoginEnrolled(boolean z) {
        this.hasFaceLoginEnrolled = z;
    }

    @JvmName(name = "isFaceLoginReady")
    public final boolean isFaceLoginReady() {
        return this.isFaceLoginReady;
    }

    @JvmName(name = "setFaceLoginReady")
    public final void setFaceLoginReady(boolean z) {
        this.isFaceLoginReady = z;
    }

    @JvmName(name = "getAlreadyKyc")
    public final boolean getAlreadyKyc() {
        return this.alreadyKyc;
    }

    @JvmName(name = "setAlreadyKyc")
    public final void setAlreadyKyc(boolean z) {
        this.alreadyKyc = z;
    }

    @JvmName(name = "getShouldShowPopUp")
    public final boolean getShouldShowPopUp() {
        return (!this.isFaceLoginReady || this.isFaceLoginEnabled || this.hasFaceLoginEnrolled) ? false : true;
    }

    @JvmName(name = "getShouldShowProfileCompletionTask")
    public final boolean getShouldShowProfileCompletionTask() {
        return this.isFaceLoginReady && !this.isFaceLoginEnabled;
    }
}
