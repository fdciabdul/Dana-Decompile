package id.dana.domain.version;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B-\b\u0016\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b \u0010!B%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b \u0010\"J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001bR\"\u0010\u000b\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001bR\"\u0010\f\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u001b"}, d2 = {"Lid/dana/domain/version/SemanticVersion;", "", "other", "", "compareTo", "(Lid/dana/domain/version/SemanticVersion;)I", "component1", "()I", "component2", "component3", "major", "minor", "patch", "copy", "(III)Lid/dana/domain/version/SemanticVersion;", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toInt", "", "toString", "()Ljava/lang/String;", "I", "getMajor", "setMajor", "(I)V", "getMinor", "setMinor", "getPatch", "setPatch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(III)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SemanticVersion implements Comparable<SemanticVersion> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int major;
    private int minor;
    private int patch;

    public SemanticVersion() {
        this(0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SemanticVersion copy$default(SemanticVersion semanticVersion, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = semanticVersion.major;
        }
        if ((i4 & 2) != 0) {
            i2 = semanticVersion.minor;
        }
        if ((i4 & 4) != 0) {
            i3 = semanticVersion.patch;
        }
        return semanticVersion.copy(i, i2, i3);
    }

    @JvmStatic
    public static final SemanticVersion fromVersion(String str) {
        return INSTANCE.fromVersion(str);
    }

    /* renamed from: component1  reason: from getter */
    public final int getMajor() {
        return this.major;
    }

    /* renamed from: component2  reason: from getter */
    public final int getMinor() {
        return this.minor;
    }

    /* renamed from: component3  reason: from getter */
    public final int getPatch() {
        return this.patch;
    }

    public final SemanticVersion copy(int major, int minor, int patch) {
        return new SemanticVersion(major, minor, patch);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SemanticVersion) {
            SemanticVersion semanticVersion = (SemanticVersion) other;
            return this.major == semanticVersion.major && this.minor == semanticVersion.minor && this.patch == semanticVersion.patch;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.major * 31) + this.minor) * 31) + this.patch;
    }

    public SemanticVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public /* synthetic */ SemanticVersion(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    @JvmName(name = "getMajor")
    public final int getMajor() {
        return this.major;
    }

    @JvmName(name = "setMajor")
    public final void setMajor(int i) {
        this.major = i;
    }

    @JvmName(name = "getMinor")
    public final int getMinor() {
        return this.minor;
    }

    @JvmName(name = "setMinor")
    public final void setMinor(int i) {
        this.minor = i;
    }

    @JvmName(name = "getPatch")
    public final int getPatch() {
        return this.patch;
    }

    @JvmName(name = "setPatch")
    public final void setPatch(int i) {
        this.patch = i;
    }

    public /* synthetic */ SemanticVersion(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SemanticVersion(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto Le
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto Le
            int r2 = r2.intValue()
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r3 == 0) goto L1c
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)
            if (r3 == 0) goto L1c
            int r3 = r3.intValue()
            goto L1d
        L1c:
            r3 = 0
        L1d:
            if (r4 == 0) goto L29
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)
            if (r4 == 0) goto L29
            int r0 = r4.intValue()
        L29:
            r1.<init>(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.version.SemanticVersion.<init>(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // java.lang.Comparable
    public final int compareTo(SemanticVersion other) {
        Intrinsics.checkNotNullParameter(other, "");
        int i = this.major;
        int i2 = other.major;
        if (i <= i2) {
            if (i >= i2) {
                int i3 = this.minor;
                int i4 = other.minor;
                if (i3 <= i4) {
                    if (i3 >= i4) {
                        int i5 = this.patch;
                        int i6 = other.patch;
                        if (i5 <= i6) {
                            if (i5 >= i6) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return -1;
        }
        return 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }

    public final int toInt() {
        return (this.major * 10000) + (this.minor * 100) + this.patch;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/version/SemanticVersion$Companion;", "", "", "version", "Lid/dana/domain/version/SemanticVersion;", "fromVersion", "(Ljava/lang/String;)Lid/dana/domain/version/SemanticVersion;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SemanticVersion fromVersion(String version) {
            Intrinsics.checkNotNullParameter(version, "");
            List split$default = StringsKt.split$default((CharSequence) version, new String[]{"."}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it = split$default.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((String) next).length() > 0) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            return arrayList2.size() >= 3 ? new SemanticVersion((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2)) : arrayList2.size() == 2 ? new SemanticVersion((String) arrayList2.get(0), (String) arrayList2.get(1), (String) null, 4, (DefaultConstructorMarker) null) : arrayList2.size() == 1 ? new SemanticVersion((String) arrayList2.get(0), (String) null, (String) null, 6, (DefaultConstructorMarker) null) : new SemanticVersion(0, 0, 0, 6, (DefaultConstructorMarker) null);
        }
    }
}
