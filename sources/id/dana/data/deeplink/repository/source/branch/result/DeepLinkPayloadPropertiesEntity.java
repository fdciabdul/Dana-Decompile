package id.dana.data.deeplink.repository.source.branch.result;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadPropertiesEntity;", "", "Lcom/google/gson/JsonObject;", "component1", "()Lcom/google/gson/JsonObject;", "data", "copy", "(Lcom/google/gson/JsonObject;)Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadPropertiesEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/gson/JsonObject;", "getData", "setData", "(Lcom/google/gson/JsonObject;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeepLinkPayloadPropertiesEntity {
    @SerializedName("data")
    private JsonObject data;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.gson.JsonObject, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DeepLinkPayloadPropertiesEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadPropertiesEntity.<init>():void");
    }

    public static /* synthetic */ DeepLinkPayloadPropertiesEntity copy$default(DeepLinkPayloadPropertiesEntity deepLinkPayloadPropertiesEntity, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonObject = deepLinkPayloadPropertiesEntity.data;
        }
        return deepLinkPayloadPropertiesEntity.copy(jsonObject);
    }

    /* renamed from: component1  reason: from getter */
    public final JsonObject getData() {
        return this.data;
    }

    public final DeepLinkPayloadPropertiesEntity copy(JsonObject data) {
        return new DeepLinkPayloadPropertiesEntity(data);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeepLinkPayloadPropertiesEntity) && Intrinsics.areEqual(this.data, ((DeepLinkPayloadPropertiesEntity) other).data);
    }

    public final int hashCode() {
        JsonObject jsonObject = this.data;
        if (jsonObject == null) {
            return 0;
        }
        return jsonObject.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeepLinkPayloadPropertiesEntity(data=");
        sb.append(this.data);
        sb.append(')');
        return sb.toString();
    }

    public DeepLinkPayloadPropertiesEntity(JsonObject jsonObject) {
        this.data = jsonObject;
    }

    public /* synthetic */ DeepLinkPayloadPropertiesEntity(JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jsonObject);
    }

    @JvmName(name = "getData")
    public final JsonObject getData() {
        return this.data;
    }

    @JvmName(name = "setData")
    public final void setData(JsonObject jsonObject) {
        this.data = jsonObject;
    }
}
