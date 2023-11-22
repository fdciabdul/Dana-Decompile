package id.dana.domain.synccontact.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0002\u0012\b\b\u0003\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/domain/synccontact/model/SyncContactSplitConfigModel;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "feedSync", "sendMoneySync", "referralSync", "mobileRechargeSync", "backgroundJobSync", "copy", "(ZZZZZ)Lid/dana/domain/synccontact/model/SyncContactSplitConfigModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getBackgroundJobSync", "getFeedSync", "getMobileRechargeSync", "getReferralSync", "getSendMoneySync", "<init>", "(ZZZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SyncContactSplitConfigModel {
    @SerializedName("backgroundJobSync")
    private final boolean backgroundJobSync;
    @SerializedName("feedSync")
    private final boolean feedSync;
    @SerializedName("mobileRechargeSync")
    private final boolean mobileRechargeSync;
    @SerializedName("referralSync")
    private final boolean referralSync;
    @SerializedName("sendMoneySync")
    private final boolean sendMoneySync;

    public static /* synthetic */ SyncContactSplitConfigModel copy$default(SyncContactSplitConfigModel syncContactSplitConfigModel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = syncContactSplitConfigModel.feedSync;
        }
        if ((i & 2) != 0) {
            z2 = syncContactSplitConfigModel.sendMoneySync;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = syncContactSplitConfigModel.referralSync;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = syncContactSplitConfigModel.mobileRechargeSync;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = syncContactSplitConfigModel.backgroundJobSync;
        }
        return syncContactSplitConfigModel.copy(z, z6, z7, z8, z5);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getFeedSync() {
        return this.feedSync;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getSendMoneySync() {
        return this.sendMoneySync;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getReferralSync() {
        return this.referralSync;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getMobileRechargeSync() {
        return this.mobileRechargeSync;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getBackgroundJobSync() {
        return this.backgroundJobSync;
    }

    public final SyncContactSplitConfigModel copy(@JSONField(name = "feedSync") boolean feedSync, @JSONField(name = "sendMoneySync") boolean sendMoneySync, @JSONField(name = "referralSync") boolean referralSync, @JSONField(name = "mobileRechargeSync") boolean mobileRechargeSync, @JSONField(name = "backgroundJobSync") boolean backgroundJobSync) {
        return new SyncContactSplitConfigModel(feedSync, sendMoneySync, referralSync, mobileRechargeSync, backgroundJobSync);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SyncContactSplitConfigModel) {
            SyncContactSplitConfigModel syncContactSplitConfigModel = (SyncContactSplitConfigModel) other;
            return this.feedSync == syncContactSplitConfigModel.feedSync && this.sendMoneySync == syncContactSplitConfigModel.sendMoneySync && this.referralSync == syncContactSplitConfigModel.referralSync && this.mobileRechargeSync == syncContactSplitConfigModel.mobileRechargeSync && this.backgroundJobSync == syncContactSplitConfigModel.backgroundJobSync;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.feedSync;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.sendMoneySync;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        ?? r3 = this.referralSync;
        int i2 = r3;
        if (r3 != 0) {
            i2 = 1;
        }
        ?? r4 = this.mobileRechargeSync;
        int i3 = r4;
        if (r4 != 0) {
            i3 = 1;
        }
        boolean z2 = this.backgroundJobSync;
        return (((((((r0 * 31) + i) * 31) + i2) * 31) + i3) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncContactSplitConfigModel(feedSync=");
        sb.append(this.feedSync);
        sb.append(", sendMoneySync=");
        sb.append(this.sendMoneySync);
        sb.append(", referralSync=");
        sb.append(this.referralSync);
        sb.append(", mobileRechargeSync=");
        sb.append(this.mobileRechargeSync);
        sb.append(", backgroundJobSync=");
        sb.append(this.backgroundJobSync);
        sb.append(')');
        return sb.toString();
    }

    public SyncContactSplitConfigModel(@JSONField(name = "feedSync") boolean z, @JSONField(name = "sendMoneySync") boolean z2, @JSONField(name = "referralSync") boolean z3, @JSONField(name = "mobileRechargeSync") boolean z4, @JSONField(name = "backgroundJobSync") boolean z5) {
        this.feedSync = z;
        this.sendMoneySync = z2;
        this.referralSync = z3;
        this.mobileRechargeSync = z4;
        this.backgroundJobSync = z5;
    }

    public /* synthetic */ SyncContactSplitConfigModel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5);
    }

    @JvmName(name = "getFeedSync")
    public final boolean getFeedSync() {
        return this.feedSync;
    }

    @JvmName(name = "getSendMoneySync")
    public final boolean getSendMoneySync() {
        return this.sendMoneySync;
    }

    @JvmName(name = "getReferralSync")
    public final boolean getReferralSync() {
        return this.referralSync;
    }

    @JvmName(name = "getMobileRechargeSync")
    public final boolean getMobileRechargeSync() {
        return this.mobileRechargeSync;
    }

    @JvmName(name = "getBackgroundJobSync")
    public final boolean getBackgroundJobSync() {
        return this.backgroundJobSync;
    }
}
