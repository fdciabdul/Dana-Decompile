package id.dana.domain.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/CreateFamilyAccountResult;", "", "", "component1", "()Ljava/lang/String;", "certificateId", "copy", "(Ljava/lang/String;)Lid/dana/domain/familyaccount/model/CreateFamilyAccountResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCertificateId", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateFamilyAccountResult {
    private final String certificateId;

    public static /* synthetic */ CreateFamilyAccountResult copy$default(CreateFamilyAccountResult createFamilyAccountResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createFamilyAccountResult.certificateId;
        }
        return createFamilyAccountResult.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCertificateId() {
        return this.certificateId;
    }

    public final CreateFamilyAccountResult copy(String certificateId) {
        Intrinsics.checkNotNullParameter(certificateId, "");
        return new CreateFamilyAccountResult(certificateId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateFamilyAccountResult) && Intrinsics.areEqual(this.certificateId, ((CreateFamilyAccountResult) other).certificateId);
    }

    public final int hashCode() {
        return this.certificateId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateFamilyAccountResult(certificateId=");
        sb.append(this.certificateId);
        sb.append(')');
        return sb.toString();
    }

    public CreateFamilyAccountResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.certificateId = str;
    }

    @JvmName(name = "getCertificateId")
    public final String getCertificateId() {
        return this.certificateId;
    }
}
