package id.dana.domain.promoquest.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.data.constant.BranchLinkConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\bM\u0010NJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J \u0001\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010 \u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u0004R\"\u0010 \u001a\u00020\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010,\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b0\u0010\u0007R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u00104R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00105\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u00108R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u00104R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00101\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u00104R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00101\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u00104R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00101\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u00104R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00101\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u00104R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00101\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u00104R\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00101\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u00104R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00101\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u00104R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010I\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010L"}, d2 = {"Lid/dana/domain/promoquest/model/Mission;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Z", "component11", "component12", "component2", "component3", "Ljava/util/Date;", "component4", "()Ljava/util/Date;", "component5", "component6", "component7", "component8", "", "Lid/dana/domain/promoquest/model/Quest;", "component9", "()Ljava/util/List;", BranchLinkConstant.Params.MISSION_ID, "missionName", "missionDescription", "missionExpireTime", "missionStatus", "missionFinishImage", "missionImage", "missionThumbnail", "questList", "hasPrize", "missionType", "missionTnc", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/promoquest/model/Mission;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHasPrize", "setHasPrize", "(Z)V", "isMissionFlexible", "Ljava/lang/String;", "getMissionDescription", "setMissionDescription", "(Ljava/lang/String;)V", "Ljava/util/Date;", "getMissionExpireTime", "setMissionExpireTime", "(Ljava/util/Date;)V", "getMissionFinishImage", "setMissionFinishImage", "getMissionId", "setMissionId", "getMissionImage", "setMissionImage", "getMissionName", "setMissionName", "getMissionStatus", "setMissionStatus", "getMissionThumbnail", "setMissionThumbnail", "getMissionTnc", "setMissionTnc", "getMissionType", "setMissionType", "Ljava/util/List;", "getQuestList", "setQuestList", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Mission {
    private boolean hasPrize;
    private String missionDescription;
    private Date missionExpireTime;
    private String missionFinishImage;
    private String missionId;
    private String missionImage;
    private String missionName;
    private String missionStatus;
    private String missionThumbnail;
    private String missionTnc;
    private String missionType;
    private List<Quest> questList;

    public Mission() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    /* renamed from: component10  reason: from getter */
    public final boolean getHasPrize() {
        return this.hasPrize;
    }

    /* renamed from: component11  reason: from getter */
    public final String getMissionType() {
        return this.missionType;
    }

    /* renamed from: component12  reason: from getter */
    public final String getMissionTnc() {
        return this.missionTnc;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMissionName() {
        return this.missionName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMissionDescription() {
        return this.missionDescription;
    }

    /* renamed from: component4  reason: from getter */
    public final Date getMissionExpireTime() {
        return this.missionExpireTime;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMissionStatus() {
        return this.missionStatus;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMissionFinishImage() {
        return this.missionFinishImage;
    }

    /* renamed from: component7  reason: from getter */
    public final String getMissionImage() {
        return this.missionImage;
    }

    /* renamed from: component8  reason: from getter */
    public final String getMissionThumbnail() {
        return this.missionThumbnail;
    }

    public final List<Quest> component9() {
        return this.questList;
    }

    public final Mission copy(String missionId, String missionName, String missionDescription, Date missionExpireTime, String missionStatus, String missionFinishImage, String missionImage, String missionThumbnail, List<Quest> questList, boolean hasPrize, String missionType, String missionTnc) {
        Intrinsics.checkNotNullParameter(questList, "");
        Intrinsics.checkNotNullParameter(missionTnc, "");
        return new Mission(missionId, missionName, missionDescription, missionExpireTime, missionStatus, missionFinishImage, missionImage, missionThumbnail, questList, hasPrize, missionType, missionTnc);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Mission) {
            Mission mission = (Mission) other;
            return Intrinsics.areEqual(this.missionId, mission.missionId) && Intrinsics.areEqual(this.missionName, mission.missionName) && Intrinsics.areEqual(this.missionDescription, mission.missionDescription) && Intrinsics.areEqual(this.missionExpireTime, mission.missionExpireTime) && Intrinsics.areEqual(this.missionStatus, mission.missionStatus) && Intrinsics.areEqual(this.missionFinishImage, mission.missionFinishImage) && Intrinsics.areEqual(this.missionImage, mission.missionImage) && Intrinsics.areEqual(this.missionThumbnail, mission.missionThumbnail) && Intrinsics.areEqual(this.questList, mission.questList) && this.hasPrize == mission.hasPrize && Intrinsics.areEqual(this.missionType, mission.missionType) && Intrinsics.areEqual(this.missionTnc, mission.missionTnc);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.missionId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.missionName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.missionDescription;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Date date = this.missionExpireTime;
        int hashCode4 = date == null ? 0 : date.hashCode();
        String str4 = this.missionStatus;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.missionFinishImage;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.missionImage;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.missionThumbnail;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        int hashCode9 = this.questList.hashCode();
        boolean z = this.hasPrize;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str8 = this.missionType;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + (str8 != null ? str8.hashCode() : 0)) * 31) + this.missionTnc.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mission(missionId=");
        sb.append(this.missionId);
        sb.append(", missionName=");
        sb.append(this.missionName);
        sb.append(", missionDescription=");
        sb.append(this.missionDescription);
        sb.append(", missionExpireTime=");
        sb.append(this.missionExpireTime);
        sb.append(", missionStatus=");
        sb.append(this.missionStatus);
        sb.append(", missionFinishImage=");
        sb.append(this.missionFinishImage);
        sb.append(", missionImage=");
        sb.append(this.missionImage);
        sb.append(", missionThumbnail=");
        sb.append(this.missionThumbnail);
        sb.append(", questList=");
        sb.append(this.questList);
        sb.append(", hasPrize=");
        sb.append(this.hasPrize);
        sb.append(", missionType=");
        sb.append(this.missionType);
        sb.append(", missionTnc=");
        sb.append(this.missionTnc);
        sb.append(')');
        return sb.toString();
    }

    public Mission(String str, String str2, String str3, Date date, String str4, String str5, String str6, String str7, List<Quest> list, boolean z, String str8, String str9) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.missionId = str;
        this.missionName = str2;
        this.missionDescription = str3;
        this.missionExpireTime = date;
        this.missionStatus = str4;
        this.missionFinishImage = str5;
        this.missionImage = str6;
        this.missionThumbnail = str7;
        this.questList = list;
        this.hasPrize = z;
        this.missionType = str8;
        this.missionTnc = str9;
    }

    @JvmName(name = "getMissionId")
    public final String getMissionId() {
        return this.missionId;
    }

    @JvmName(name = "setMissionId")
    public final void setMissionId(String str) {
        this.missionId = str;
    }

    @JvmName(name = "getMissionName")
    public final String getMissionName() {
        return this.missionName;
    }

    @JvmName(name = "setMissionName")
    public final void setMissionName(String str) {
        this.missionName = str;
    }

    @JvmName(name = "getMissionDescription")
    public final String getMissionDescription() {
        return this.missionDescription;
    }

    @JvmName(name = "setMissionDescription")
    public final void setMissionDescription(String str) {
        this.missionDescription = str;
    }

    @JvmName(name = "getMissionExpireTime")
    public final Date getMissionExpireTime() {
        return this.missionExpireTime;
    }

    @JvmName(name = "setMissionExpireTime")
    public final void setMissionExpireTime(Date date) {
        this.missionExpireTime = date;
    }

    @JvmName(name = "getMissionStatus")
    public final String getMissionStatus() {
        return this.missionStatus;
    }

    @JvmName(name = "setMissionStatus")
    public final void setMissionStatus(String str) {
        this.missionStatus = str;
    }

    @JvmName(name = "getMissionFinishImage")
    public final String getMissionFinishImage() {
        return this.missionFinishImage;
    }

    @JvmName(name = "setMissionFinishImage")
    public final void setMissionFinishImage(String str) {
        this.missionFinishImage = str;
    }

    @JvmName(name = "getMissionImage")
    public final String getMissionImage() {
        return this.missionImage;
    }

    @JvmName(name = "setMissionImage")
    public final void setMissionImage(String str) {
        this.missionImage = str;
    }

    @JvmName(name = "getMissionThumbnail")
    public final String getMissionThumbnail() {
        return this.missionThumbnail;
    }

    @JvmName(name = "setMissionThumbnail")
    public final void setMissionThumbnail(String str) {
        this.missionThumbnail = str;
    }

    public /* synthetic */ Mission(String str, String str2, String str3, Date date, String str4, String str5, String str6, String str7, List list, boolean z, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : date, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? new ArrayList() : list, (i & 512) != 0 ? false : z, (i & 1024) == 0 ? str8 : null, (i & 2048) != 0 ? "" : str9);
    }

    @JvmName(name = "getQuestList")
    public final List<Quest> getQuestList() {
        return this.questList;
    }

    @JvmName(name = "setQuestList")
    public final void setQuestList(List<Quest> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.questList = list;
    }

    @JvmName(name = "getHasPrize")
    public final boolean getHasPrize() {
        return this.hasPrize;
    }

    @JvmName(name = "setHasPrize")
    public final void setHasPrize(boolean z) {
        this.hasPrize = z;
    }

    @JvmName(name = "getMissionType")
    public final String getMissionType() {
        return this.missionType;
    }

    @JvmName(name = "setMissionType")
    public final void setMissionType(String str) {
        this.missionType = str;
    }

    @JvmName(name = "getMissionTnc")
    public final String getMissionTnc() {
        return this.missionTnc;
    }

    @JvmName(name = "setMissionTnc")
    public final void setMissionTnc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.missionTnc = str;
    }

    @JvmName(name = "isMissionFlexible")
    public final boolean isMissionFlexible() {
        return StringsKt.equals("FLEXIBLE", this.missionType, true);
    }
}
