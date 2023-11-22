package id.dana.danapoly.data.config.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0007R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "getCurrencyValue", "()I", "", "getEventId", "()Ljava/lang/String;", "", "getExpiryDate", "()Ljava/lang/Long;", "getLastActiveEventId", "Lid/dana/danapoly/data/config/model/response/DanapolyConfigurationResponse;", "configInfo", "Lid/dana/danapoly/data/config/model/response/DanapolyConfigurationResponse;", "<init>", "(Lid/dana/danapoly/data/config/model/response/DanapolyConfigurationResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetConfigurationResponse extends BaseRpcResult {
    private final DanapolyConfigurationResponse configInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.danapoly.data.config.model.response.DanapolyConfigurationResponse, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetConfigurationResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.config.model.response.GetConfigurationResponse.<init>():void");
    }

    public /* synthetic */ GetConfigurationResponse(DanapolyConfigurationResponse danapolyConfigurationResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : danapolyConfigurationResponse);
    }

    public GetConfigurationResponse(DanapolyConfigurationResponse danapolyConfigurationResponse) {
        this.configInfo = danapolyConfigurationResponse;
    }

    public final String getEventId() {
        List<EventConfigResponse> eventActive;
        EventConfigResponse eventConfigResponse;
        DanapolyConfigurationResponse danapolyConfigurationResponse = this.configInfo;
        String str = null;
        if (danapolyConfigurationResponse != null && (eventActive = danapolyConfigurationResponse.getEventActive()) != null) {
            if ((!eventActive.isEmpty()) == false) {
                eventActive = null;
            }
            if (eventActive != null && (eventConfigResponse = (EventConfigResponse) CollectionsKt.first((List) eventActive)) != null) {
                str = eventConfigResponse.getEventId();
            }
        }
        return str == null ? "" : str;
    }

    public final String getLastActiveEventId() {
        List<EventConfigResponse> lastActiveEvent;
        EventConfigResponse eventConfigResponse;
        DanapolyConfigurationResponse danapolyConfigurationResponse = this.configInfo;
        String str = null;
        if (danapolyConfigurationResponse != null && (lastActiveEvent = danapolyConfigurationResponse.getLastActiveEvent()) != null) {
            if ((!lastActiveEvent.isEmpty()) == false) {
                lastActiveEvent = null;
            }
            if (lastActiveEvent != null && (eventConfigResponse = (EventConfigResponse) CollectionsKt.first((List) lastActiveEvent)) != null) {
                str = eventConfigResponse.getEventId();
            }
        }
        return str == null ? "" : str;
    }

    public final int getCurrencyValue() {
        List<EventConfigResponse> eventActive;
        EventConfigResponse eventConfigResponse;
        String currencyValue;
        DanapolyConfigurationResponse danapolyConfigurationResponse = this.configInfo;
        if (danapolyConfigurationResponse == null || (eventActive = danapolyConfigurationResponse.getEventActive()) == null || (eventConfigResponse = (EventConfigResponse) CollectionsKt.first((List) eventActive)) == null || (currencyValue = eventConfigResponse.getCurrencyValue()) == null) {
            return 1;
        }
        return Integer.parseInt(currencyValue);
    }

    public final Long getExpiryDate() {
        List<EventConfigResponse> eventActive;
        EventConfigResponse eventConfigResponse;
        String expiryDate;
        DanapolyConfigurationResponse danapolyConfigurationResponse = this.configInfo;
        if (danapolyConfigurationResponse == null || (eventActive = danapolyConfigurationResponse.getEventActive()) == null) {
            return null;
        }
        if ((!eventActive.isEmpty()) == false) {
            eventActive = null;
        }
        if (eventActive == null || (eventConfigResponse = (EventConfigResponse) CollectionsKt.first((List) eventActive)) == null || (expiryDate = eventConfigResponse.getExpiryDate()) == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(expiryDate));
    }
}
