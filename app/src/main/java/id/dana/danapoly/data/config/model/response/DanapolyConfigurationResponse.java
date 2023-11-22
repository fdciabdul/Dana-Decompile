package id.dana.danapoly.data.config.model.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/danapoly/data/config/model/response/DanapolyConfigurationResponse;", "", "", "Lid/dana/danapoly/data/config/model/response/EventConfigResponse;", "eventActive", "Ljava/util/List;", "getEventActive", "()Ljava/util/List;", "lastActiveEvent", "getLastActiveEvent", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyConfigurationResponse {
    private final List<EventConfigResponse> eventActive;
    private final List<EventConfigResponse> lastActiveEvent;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DanapolyConfigurationResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.config.model.response.DanapolyConfigurationResponse.<init>():void");
    }

    public DanapolyConfigurationResponse(List<EventConfigResponse> list, List<EventConfigResponse> list2) {
        this.eventActive = list;
        this.lastActiveEvent = list2;
    }

    public /* synthetic */ DanapolyConfigurationResponse(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    @JvmName(name = "getEventActive")
    public final List<EventConfigResponse> getEventActive() {
        return this.eventActive;
    }

    @JvmName(name = "getLastActiveEvent")
    public final List<EventConfigResponse> getLastActiveEvent() {
        return this.lastActiveEvent;
    }
}
