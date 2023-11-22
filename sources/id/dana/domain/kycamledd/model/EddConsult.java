package id.dana.domain.kycamledd.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/domain/kycamledd/model/EddConsult;", "", "Lid/dana/domain/kycamledd/model/EddInfo;", "eddInfo", "Lid/dana/domain/kycamledd/model/EddInfo;", "getEddInfo", "()Lid/dana/domain/kycamledd/model/EddInfo;", "", "eddMandatory", "Z", "getEddMandatory", "()Z", "eddStatus", "getEddStatus", "<init>", "(ZLid/dana/domain/kycamledd/model/EddInfo;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EddConsult {
    private final EddInfo eddInfo;
    private final boolean eddMandatory;
    private final boolean eddStatus;

    public EddConsult(boolean z, EddInfo eddInfo, boolean z2) {
        this.eddStatus = z;
        this.eddInfo = eddInfo;
        this.eddMandatory = z2;
    }

    @JvmName(name = "getEddStatus")
    public final boolean getEddStatus() {
        return this.eddStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ EddConsult(boolean r1, id.dana.domain.kycamledd.model.EddInfo r2, boolean r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 2
            if (r4 == 0) goto Lb
            id.dana.domain.kycamledd.model.EddInfo r2 = new id.dana.domain.kycamledd.model.EddInfo
            r4 = 3
            r5 = 0
            r2.<init>(r5, r5, r4, r5)
        Lb:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.kycamledd.model.EddConsult.<init>(boolean, id.dana.domain.kycamledd.model.EddInfo, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getEddInfo")
    public final EddInfo getEddInfo() {
        return this.eddInfo;
    }

    @JvmName(name = "getEddMandatory")
    public final boolean getEddMandatory() {
        return this.eddMandatory;
    }
}
