package id.dana.domain.promoquest.model;

import com.alibaba.griver.api.common.config.GriverConfigConstants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\u001fR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010'R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010#R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010#"}, d2 = {"Lid/dana/domain/promoquest/model/MissionSummary;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/promoquest/model/Quest;", "component2", "()Lid/dana/domain/promoquest/model/Quest;", "Ljava/util/Date;", "component3", "()Ljava/util/Date;", "component4", "component5", "id", "quest", GriverConfigConstants.PARAM_PREPARE_APP_TIMEOUT, "status", "thumbnail", "copy", "(Ljava/lang/String;Lid/dana/domain/promoquest/model/Quest;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/promoquest/model/MissionSummary;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Date;", "getExpireTime", "setExpireTime", "(Ljava/util/Date;)V", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "Lid/dana/domain/promoquest/model/Quest;", "getQuest", "setQuest", "(Lid/dana/domain/promoquest/model/Quest;)V", "getStatus", "setStatus", "getThumbnail", "setThumbnail", "<init>", "(Ljava/lang/String;Lid/dana/domain/promoquest/model/Quest;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class MissionSummary {
    private Date expireTime;
    private String id;
    private Quest quest;
    private String status;
    private String thumbnail;

    public MissionSummary() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MissionSummary copy$default(MissionSummary missionSummary, String str, Quest quest, Date date, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = missionSummary.id;
        }
        if ((i & 2) != 0) {
            quest = missionSummary.quest;
        }
        Quest quest2 = quest;
        if ((i & 4) != 0) {
            date = missionSummary.expireTime;
        }
        Date date2 = date;
        if ((i & 8) != 0) {
            str2 = missionSummary.status;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = missionSummary.thumbnail;
        }
        return missionSummary.copy(str, quest2, date2, str4, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final Quest getQuest() {
        return this.quest;
    }

    /* renamed from: component3  reason: from getter */
    public final Date getExpireTime() {
        return this.expireTime;
    }

    /* renamed from: component4  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5  reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final MissionSummary copy(String id2, Quest quest, Date expireTime, String status, String thumbnail) {
        return new MissionSummary(id2, quest, expireTime, status, thumbnail);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MissionSummary) {
            MissionSummary missionSummary = (MissionSummary) other;
            return Intrinsics.areEqual(this.id, missionSummary.id) && Intrinsics.areEqual(this.quest, missionSummary.quest) && Intrinsics.areEqual(this.expireTime, missionSummary.expireTime) && Intrinsics.areEqual(this.status, missionSummary.status) && Intrinsics.areEqual(this.thumbnail, missionSummary.thumbnail);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        Quest quest = this.quest;
        int hashCode2 = quest == null ? 0 : quest.hashCode();
        Date date = this.expireTime;
        int hashCode3 = date == null ? 0 : date.hashCode();
        String str2 = this.status;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.thumbnail;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MissionSummary(id=");
        sb.append(this.id);
        sb.append(", quest=");
        sb.append(this.quest);
        sb.append(", expireTime=");
        sb.append(this.expireTime);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", thumbnail=");
        sb.append(this.thumbnail);
        sb.append(')');
        return sb.toString();
    }

    public MissionSummary(String str, Quest quest, Date date, String str2, String str3) {
        this.id = str;
        this.quest = quest;
        this.expireTime = date;
        this.status = str2;
        this.thumbnail = str3;
    }

    public /* synthetic */ MissionSummary(String str, Quest quest, Date date, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : quest, (i & 4) != 0 ? null : date, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getQuest")
    public final Quest getQuest() {
        return this.quest;
    }

    @JvmName(name = "setQuest")
    public final void setQuest(Quest quest) {
        this.quest = quest;
    }

    @JvmName(name = "getExpireTime")
    public final Date getExpireTime() {
        return this.expireTime;
    }

    @JvmName(name = "setExpireTime")
    public final void setExpireTime(Date date) {
        this.expireTime = date;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        this.status = str;
    }

    @JvmName(name = "getThumbnail")
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @JvmName(name = "setThumbnail")
    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }
}
