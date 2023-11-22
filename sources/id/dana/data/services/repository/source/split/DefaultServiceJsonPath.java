package id.dana.data.services.repository.source.split;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lid/dana/data/services/repository/source/split/DefaultServiceJsonPath;", "", "", "defaultJsonPath", "Ljava/lang/String;", "getDefaultJsonPath", "()Ljava/lang/String;", "serviceName", "getServiceName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "DANA_FOOD", "DANA_DELIVERY"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public enum DefaultServiceJsonPath {
    DANA_FOOD("service_dana_food", "split/default-service-dana-food.json"),
    DANA_DELIVERY("service_delivery", "split/default-service-delivery.json");

    private final String defaultJsonPath;
    private final String serviceName;

    DefaultServiceJsonPath(String str, String str2) {
        this.serviceName = str;
        this.defaultJsonPath = str2;
    }

    @JvmName(name = "getDefaultJsonPath")
    public final String getDefaultJsonPath() {
        return this.defaultJsonPath;
    }

    @JvmName(name = "getServiceName")
    public final String getServiceName() {
        return this.serviceName;
    }
}
