package id.dana.domain.promoquest.model;

import id.dana.danah5.share.ShareToFeedBridge;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0086\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010&R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010#\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010&R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010,R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010&R\"\u0010\u0016\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010/\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b0\u00101R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010&R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010#\u001a\u0004\b4\u0010\u0004\"\u0004\b5\u0010&R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u0010&R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010#\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010&"}, d2 = {"Lid/dana/domain/promoquest/model/Quest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "component7", "component8", "", "component9", "()Ljava/util/Map;", "id", "name", "status", "description", "actionType", "isPriceStatus", "redirectType", ShareToFeedBridge.REDIRECT_VALUE, "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/promoquest/model/Quest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActionType", "setActionType", "(Ljava/lang/String;)V", "getDescription", "setDescription", "Ljava/util/Map;", "getExtendInfo", "setExtendInfo", "(Ljava/util/Map;)V", "getId", "setId", "Z", "setPriceStatus", "(Z)V", "getName", "setName", "getRedirectType", "setRedirectType", "getRedirectValue", "setRedirectValue", "getStatus", "setStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Quest {
    private String actionType;
    private String description;
    private Map<String, String> extendInfo;
    private String id;
    private boolean isPriceStatus;
    private String name;
    private String redirectType;
    private String redirectValue;
    private String status;

    public Quest() {
        this(null, null, null, null, null, false, null, null, null, 511, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5  reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getIsPriceStatus() {
        return this.isPriceStatus;
    }

    /* renamed from: component7  reason: from getter */
    public final String getRedirectType() {
        return this.redirectType;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    public final Map<String, String> component9() {
        return this.extendInfo;
    }

    public final Quest copy(String id2, String name, String status, String description, String actionType, boolean isPriceStatus, String redirectType, String redirectValue, Map<String, String> extendInfo) {
        return new Quest(id2, name, status, description, actionType, isPriceStatus, redirectType, redirectValue, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Quest) {
            Quest quest = (Quest) other;
            return Intrinsics.areEqual(this.id, quest.id) && Intrinsics.areEqual(this.name, quest.name) && Intrinsics.areEqual(this.status, quest.status) && Intrinsics.areEqual(this.description, quest.description) && Intrinsics.areEqual(this.actionType, quest.actionType) && this.isPriceStatus == quest.isPriceStatus && Intrinsics.areEqual(this.redirectType, quest.redirectType) && Intrinsics.areEqual(this.redirectValue, quest.redirectValue) && Intrinsics.areEqual(this.extendInfo, quest.extendInfo);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.name;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.status;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.description;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.actionType;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        boolean z = this.isPriceStatus;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str6 = this.redirectType;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.redirectValue;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        Map<String, String> map = this.extendInfo;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + hashCode6) * 31) + hashCode7) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quest(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", actionType=");
        sb.append(this.actionType);
        sb.append(", isPriceStatus=");
        sb.append(this.isPriceStatus);
        sb.append(", redirectType=");
        sb.append(this.redirectType);
        sb.append(", redirectValue=");
        sb.append(this.redirectValue);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public Quest(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, Map<String, String> map) {
        this.id = str;
        this.name = str2;
        this.status = str3;
        this.description = str4;
        this.actionType = str5;
        this.isPriceStatus = z;
        this.redirectType = str6;
        this.redirectValue = str7;
        this.extendInfo = map;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        this.name = str;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        this.status = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        this.description = str;
    }

    @JvmName(name = "getActionType")
    public final String getActionType() {
        return this.actionType;
    }

    @JvmName(name = "setActionType")
    public final void setActionType(String str) {
        this.actionType = str;
    }

    @JvmName(name = "isPriceStatus")
    public final boolean isPriceStatus() {
        return this.isPriceStatus;
    }

    @JvmName(name = "setPriceStatus")
    public final void setPriceStatus(boolean z) {
        this.isPriceStatus = z;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "setRedirectType")
    public final void setRedirectType(String str) {
        this.redirectType = str;
    }

    @JvmName(name = "getRedirectValue")
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    @JvmName(name = "setRedirectValue")
    public final void setRedirectValue(String str) {
        this.redirectValue = str;
    }

    public /* synthetic */ Quest(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null, (i & 256) != 0 ? new HashMap() : map);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(Map<String, String> map) {
        this.extendInfo = map;
    }
}
