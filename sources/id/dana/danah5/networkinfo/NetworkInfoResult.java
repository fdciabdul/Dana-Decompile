package id.dana.danah5.networkinfo;

import com.google.firebase.perf.metrics.resource.ResourceType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danah5/networkinfo/NetworkInfoResult;", "", "Lid/dana/danah5/networkinfo/NetworkInfoResult$Network;", "network", "Lid/dana/danah5/networkinfo/NetworkInfoResult$Network;", "getNetwork", "()Lid/dana/danah5/networkinfo/NetworkInfoResult$Network;", "<init>", "(Lid/dana/danah5/networkinfo/NetworkInfoResult$Network;)V", ResourceType.NETWORK}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkInfoResult {
    @SerializedName("network")
    private final Network network;

    public NetworkInfoResult(Network network) {
        Intrinsics.checkNotNullParameter(network, "");
        this.network = network;
    }

    @JvmName(name = "getNetwork")
    public final Network getNetwork() {
        return this.network;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/danah5/networkinfo/NetworkInfoResult$Network;", "", "", "carrier", "Ljava/lang/String;", "getCarrier", "()Ljava/lang/String;", "manufacture", "getManufacture", "radio", "getRadio", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Network {
        @SerializedName("carrier")
        private final String carrier;
        @SerializedName("manufacture")
        private final String manufacture;
        @SerializedName("radio")
        private final String radio;

        public Network(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str3, "");
            this.carrier = str;
            this.radio = str2;
            this.manufacture = str3;
        }

        @JvmName(name = "getCarrier")
        public final String getCarrier() {
            return this.carrier;
        }

        @JvmName(name = "getRadio")
        public final String getRadio() {
            return this.radio;
        }

        @JvmName(name = "getManufacture")
        public final String getManufacture() {
            return this.manufacture;
        }
    }
}
