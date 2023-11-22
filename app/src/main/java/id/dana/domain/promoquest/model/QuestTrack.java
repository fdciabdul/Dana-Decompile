package id.dana.domain.promoquest.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ<\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\"\u0010\f\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0017\u001a\u0004\b\f\u0010\b\"\u0004\b\u0018\u0010\u0019R\"\u0010\r\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\r\u0010\b\"\u0004\b\u001a\u0010\u0019R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u001e"}, d2 = {"Lid/dana/domain/promoquest/model/QuestTrack;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "questRedirectType", "questRedirectValue", "isRedeemResult", "isTrackResult", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lid/dana/domain/promoquest/model/QuestTrack;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "setRedeemResult", "(Z)V", "setTrackResult", "Ljava/lang/String;", "getQuestRedirectType", "setQuestRedirectType", "(Ljava/lang/String;)V", "getQuestRedirectValue", "setQuestRedirectValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QuestTrack {
    private boolean isRedeemResult;
    private boolean isTrackResult;
    private String questRedirectType;
    private String questRedirectValue;

    public QuestTrack() {
        this(null, null, false, false, 15, null);
    }

    public static /* synthetic */ QuestTrack copy$default(QuestTrack questTrack, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questTrack.questRedirectType;
        }
        if ((i & 2) != 0) {
            str2 = questTrack.questRedirectValue;
        }
        if ((i & 4) != 0) {
            z = questTrack.isRedeemResult;
        }
        if ((i & 8) != 0) {
            z2 = questTrack.isTrackResult;
        }
        return questTrack.copy(str, str2, z, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getQuestRedirectType() {
        return this.questRedirectType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getQuestRedirectValue() {
        return this.questRedirectValue;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsRedeemResult() {
        return this.isRedeemResult;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getIsTrackResult() {
        return this.isTrackResult;
    }

    public final QuestTrack copy(String questRedirectType, String questRedirectValue, boolean isRedeemResult, boolean isTrackResult) {
        return new QuestTrack(questRedirectType, questRedirectValue, isRedeemResult, isTrackResult);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QuestTrack) {
            QuestTrack questTrack = (QuestTrack) other;
            return Intrinsics.areEqual(this.questRedirectType, questTrack.questRedirectType) && Intrinsics.areEqual(this.questRedirectValue, questTrack.questRedirectValue) && this.isRedeemResult == questTrack.isRedeemResult && this.isTrackResult == questTrack.isTrackResult;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.questRedirectType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.questRedirectValue;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        boolean z = this.isRedeemResult;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.isTrackResult;
        return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuestTrack(questRedirectType=");
        sb.append(this.questRedirectType);
        sb.append(", questRedirectValue=");
        sb.append(this.questRedirectValue);
        sb.append(", isRedeemResult=");
        sb.append(this.isRedeemResult);
        sb.append(", isTrackResult=");
        sb.append(this.isTrackResult);
        sb.append(')');
        return sb.toString();
    }

    public QuestTrack(String str, String str2, boolean z, boolean z2) {
        this.questRedirectType = str;
        this.questRedirectValue = str2;
        this.isRedeemResult = z;
        this.isTrackResult = z2;
    }

    public /* synthetic */ QuestTrack(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    @JvmName(name = "getQuestRedirectType")
    public final String getQuestRedirectType() {
        return this.questRedirectType;
    }

    @JvmName(name = "setQuestRedirectType")
    public final void setQuestRedirectType(String str) {
        this.questRedirectType = str;
    }

    @JvmName(name = "getQuestRedirectValue")
    public final String getQuestRedirectValue() {
        return this.questRedirectValue;
    }

    @JvmName(name = "setQuestRedirectValue")
    public final void setQuestRedirectValue(String str) {
        this.questRedirectValue = str;
    }

    @JvmName(name = "isRedeemResult")
    public final boolean isRedeemResult() {
        return this.isRedeemResult;
    }

    @JvmName(name = "setRedeemResult")
    public final void setRedeemResult(boolean z) {
        this.isRedeemResult = z;
    }

    @JvmName(name = "isTrackResult")
    public final boolean isTrackResult() {
        return this.isTrackResult;
    }

    @JvmName(name = "setTrackResult")
    public final void setTrackResult(boolean z) {
        this.isTrackResult = z;
    }
}
