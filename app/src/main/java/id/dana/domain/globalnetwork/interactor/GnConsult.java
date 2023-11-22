package id.dana.domain.globalnetwork.interactor;

import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.model.GnConsultInfo;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/GnConsult;", "", "Lid/dana/domain/globalnetwork/interactor/GnConsult$Params;", "params", "Lid/dana/domain/globalnetwork/model/GnConsultInfo;", "buildUseCase", "(Lid/dana/domain/globalnetwork/interactor/GnConsult$Params;)Lid/dana/domain/globalnetwork/model/GnConsultInfo;", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "globalNetworkRepository", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "<init>", "(Lid/dana/domain/globalnetwork/GlobalNetworkRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GnConsult {
    private final GlobalNetworkRepository globalNetworkRepository;

    @Inject
    public GnConsult(GlobalNetworkRepository globalNetworkRepository) {
        Intrinsics.checkNotNullParameter(globalNetworkRepository, "");
        this.globalNetworkRepository = globalNetworkRepository;
    }

    public final GnConsultInfo buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        GnConsultInfo doGnConsult = this.globalNetworkRepository.doGnConsult(params.getSdkRequestHeaderMap(), params.getSdkRequestData());
        Intrinsics.checkNotNullExpressionValue(doGnConsult, "");
        return doGnConsult;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\"\u0010\t\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0017R.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/GnConsult$Params;", "", "", "", "component1", "()Ljava/util/Map;", "component2", "()Ljava/lang/String;", "sdkRequestHeaderMap", "sdkRequestData", "copy", "(Ljava/util/Map;Ljava/lang/String;)Lid/dana/domain/globalnetwork/interactor/GnConsult$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSdkRequestData", "setSdkRequestData", "(Ljava/lang/String;)V", "Ljava/util/Map;", "getSdkRequestHeaderMap", "setSdkRequestHeaderMap", "(Ljava/util/Map;)V", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private String sdkRequestData;
        private Map<String, String> sdkRequestHeaderMap;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, Map map, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                map = params.sdkRequestHeaderMap;
            }
            if ((i & 2) != 0) {
                str = params.sdkRequestData;
            }
            return params.copy(map, str);
        }

        public final Map<String, String> component1() {
            return this.sdkRequestHeaderMap;
        }

        /* renamed from: component2  reason: from getter */
        public final String getSdkRequestData() {
            return this.sdkRequestData;
        }

        public final Params copy(Map<String, String> sdkRequestHeaderMap, String sdkRequestData) {
            Intrinsics.checkNotNullParameter(sdkRequestHeaderMap, "");
            Intrinsics.checkNotNullParameter(sdkRequestData, "");
            return new Params(sdkRequestHeaderMap, sdkRequestData);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.sdkRequestHeaderMap, params.sdkRequestHeaderMap) && Intrinsics.areEqual(this.sdkRequestData, params.sdkRequestData);
            }
            return false;
        }

        public final int hashCode() {
            return (this.sdkRequestHeaderMap.hashCode() * 31) + this.sdkRequestData.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(sdkRequestHeaderMap=");
            sb.append(this.sdkRequestHeaderMap);
            sb.append(", sdkRequestData=");
            sb.append(this.sdkRequestData);
            sb.append(')');
            return sb.toString();
        }

        public Params(Map<String, String> map, String str) {
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.sdkRequestHeaderMap = map;
            this.sdkRequestData = str;
        }

        @JvmName(name = "getSdkRequestHeaderMap")
        public final Map<String, String> getSdkRequestHeaderMap() {
            return this.sdkRequestHeaderMap;
        }

        @JvmName(name = "setSdkRequestHeaderMap")
        public final void setSdkRequestHeaderMap(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "");
            this.sdkRequestHeaderMap = map;
        }

        @JvmName(name = "getSdkRequestData")
        public final String getSdkRequestData() {
            return this.sdkRequestData;
        }

        @JvmName(name = "setSdkRequestData")
        public final void setSdkRequestData(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.sdkRequestData = str;
        }
    }
}
