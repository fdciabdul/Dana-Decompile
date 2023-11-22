package id.dana.danah5.locationpicker.enums;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lid/dana/danah5/locationpicker/enums/MapUtilityEvent;", "", "", BridgeDSL.INVOKE, "()Ljava/lang/String;", "type", "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MAP_PAGE", "PICK_LOCATION", "CURRENT_LOCATION"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum MapUtilityEvent {
    MAP_PAGE("mapPage"),
    PICK_LOCATION("pickLocation"),
    CURRENT_LOCATION("currentLocation");

    private final String type;

    MapUtilityEvent(String str) {
        this.type = str;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    public final String invoke() {
        return this.type;
    }
}
