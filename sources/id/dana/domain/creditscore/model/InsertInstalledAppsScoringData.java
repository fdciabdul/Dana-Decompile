package id.dana.domain.creditscore.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.foundation.logger.PerformanceConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\t"}, d2 = {"Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData$InstalledAppDataInfo;", "component3", "()Ljava/util/List;", "scheme", "type", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getScheme", "getType", "Ljava/util/List;", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "InstalledAppDataInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InsertInstalledAppsScoringData {
    private final String scheme;
    private final String type;
    private final List<InstalledAppDataInfo> value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InsertInstalledAppsScoringData copy$default(InsertInstalledAppsScoringData insertInstalledAppsScoringData, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = insertInstalledAppsScoringData.scheme;
        }
        if ((i & 2) != 0) {
            str2 = insertInstalledAppsScoringData.type;
        }
        if ((i & 4) != 0) {
            list = insertInstalledAppsScoringData.value;
        }
        return insertInstalledAppsScoringData.copy(str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: component2  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<InstalledAppDataInfo> component3() {
        return this.value;
    }

    public final InsertInstalledAppsScoringData copy(String scheme, String type, List<InstalledAppDataInfo> value) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(value, "");
        return new InsertInstalledAppsScoringData(scheme, type, value);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InsertInstalledAppsScoringData) {
            InsertInstalledAppsScoringData insertInstalledAppsScoringData = (InsertInstalledAppsScoringData) other;
            return Intrinsics.areEqual(this.scheme, insertInstalledAppsScoringData.scheme) && Intrinsics.areEqual(this.type, insertInstalledAppsScoringData.type) && Intrinsics.areEqual(this.value, insertInstalledAppsScoringData.value);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.scheme.hashCode() * 31) + this.type.hashCode()) * 31) + this.value.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InsertInstalledAppsScoringData(scheme=");
        sb.append(this.scheme);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(')');
        return sb.toString();
    }

    public InsertInstalledAppsScoringData(String str, String str2, List<InstalledAppDataInfo> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.scheme = str;
        this.type = str2;
        this.value = list;
    }

    @JvmName(name = "getScheme")
    public final String getScheme() {
        return this.scheme;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getValue")
    public final List<InstalledAppDataInfo> getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData$InstalledAppDataInfo;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "timestamp", "data", PerformanceConstant.PERFORMANCE_PHASE, "copy", "(JLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData$InstalledAppDataInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getData", "getPhase", "J", "getTimestamp", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class InstalledAppDataInfo {
        private final String data;
        private final String phase;
        private final long timestamp;

        public static /* synthetic */ InstalledAppDataInfo copy$default(InstalledAppDataInfo installedAppDataInfo, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = installedAppDataInfo.timestamp;
            }
            if ((i & 2) != 0) {
                str = installedAppDataInfo.data;
            }
            if ((i & 4) != 0) {
                str2 = installedAppDataInfo.phase;
            }
            return installedAppDataInfo.copy(j, str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* renamed from: component2  reason: from getter */
        public final String getData() {
            return this.data;
        }

        /* renamed from: component3  reason: from getter */
        public final String getPhase() {
            return this.phase;
        }

        public final InstalledAppDataInfo copy(long timestamp, String data, String phase) {
            Intrinsics.checkNotNullParameter(data, "");
            return new InstalledAppDataInfo(timestamp, data, phase);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof InstalledAppDataInfo) {
                InstalledAppDataInfo installedAppDataInfo = (InstalledAppDataInfo) other;
                return this.timestamp == installedAppDataInfo.timestamp && Intrinsics.areEqual(this.data, installedAppDataInfo.data) && Intrinsics.areEqual(this.phase, installedAppDataInfo.phase);
            }
            return false;
        }

        public final int hashCode() {
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.timestamp);
            int hashCode = this.data.hashCode();
            String str = this.phase;
            return (((m * 31) + hashCode) * 31) + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("InstalledAppDataInfo(timestamp=");
            sb.append(this.timestamp);
            sb.append(", data=");
            sb.append(this.data);
            sb.append(", phase=");
            sb.append(this.phase);
            sb.append(')');
            return sb.toString();
        }

        public InstalledAppDataInfo(long j, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.timestamp = j;
            this.data = str;
            this.phase = str2;
        }

        @JvmName(name = "getTimestamp")
        public final long getTimestamp() {
            return this.timestamp;
        }

        @JvmName(name = "getData")
        public final String getData() {
            return this.data;
        }

        @JvmName(name = "getPhase")
        public final String getPhase() {
            return this.phase;
        }
    }
}
