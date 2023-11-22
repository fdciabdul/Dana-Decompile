package id.dana.danapoly.data.config.model.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006"}, d2 = {"Lid/dana/danapoly/data/config/model/response/EventConfigResponse;", "", "", "currencyType", "Ljava/lang/String;", "getCurrencyType", "()Ljava/lang/String;", "currencyValue", "getCurrencyValue", "effectiveDate", "getEffectiveDate", "eventId", "getEventId", "eventTitle", "getEventTitle", "eventType", "getEventType", "expiryDate", "getExpiryDate", "totalItems", "getTotalItems", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EventConfigResponse {
    private final String currencyType;
    private final String currencyValue;
    private final String effectiveDate;
    private final String eventId;
    private final String eventTitle;
    private final String eventType;
    private final String expiryDate;
    private final String totalItems;

    public EventConfigResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public EventConfigResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.currencyType = str;
        this.currencyValue = str2;
        this.effectiveDate = str3;
        this.eventId = str4;
        this.eventTitle = str5;
        this.eventType = str6;
        this.expiryDate = str7;
        this.totalItems = str8;
    }

    public /* synthetic */ EventConfigResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "");
    }

    @JvmName(name = "getCurrencyType")
    public final String getCurrencyType() {
        return this.currencyType;
    }

    @JvmName(name = "getCurrencyValue")
    public final String getCurrencyValue() {
        return this.currencyValue;
    }

    @JvmName(name = "getEffectiveDate")
    public final String getEffectiveDate() {
        return this.effectiveDate;
    }

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getEventTitle")
    public final String getEventTitle() {
        return this.eventTitle;
    }

    @JvmName(name = "getEventType")
    public final String getEventType() {
        return this.eventType;
    }

    @JvmName(name = "getExpiryDate")
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    @JvmName(name = "getTotalItems")
    public final String getTotalItems() {
        return this.totalItems;
    }
}
