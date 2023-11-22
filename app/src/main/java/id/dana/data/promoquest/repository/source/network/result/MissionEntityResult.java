package id.dana.data.promoquest.repository.source.network.result;

import id.dana.data.constant.BranchLinkConstant;
import java.io.Serializable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bD\u0010EJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0092\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\"\u0010\u001b\u001a\u00020\u00108\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010+R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010/R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b0\u0010\u0004\"\u0004\b1\u0010/R$\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\r\"\u0004\b4\u00105R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010,\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u0010/R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010,\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010/R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010,\u001a\u0004\b:\u0010\u0004\"\u0004\b;\u0010/R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010,\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010/R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010,\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u0010/R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010,\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u0010/R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010,\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u0010/"}, d2 = {"Lid/dana/data/promoquest/repository/source/network/result/MissionEntityResult;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component2", "component3", "component4", "component5", "Ljava/util/Date;", "component6", "()Ljava/util/Date;", "component7", "component8", "", "component9", "()Z", BranchLinkConstant.Params.MISSION_ID, "missionName", "missionStatus", "missionDescription", "missionActiveImage", "missionExpireTime", "missionFinishImage", "missionThumbnail", "hasPrize", "missionType", "missionTnc", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/data/promoquest/repository/source/network/result/MissionEntityResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHasPrize", "setHasPrize", "(Z)V", "Ljava/lang/String;", "getMissionActiveImage", "setMissionActiveImage", "(Ljava/lang/String;)V", "getMissionDescription", "setMissionDescription", "Ljava/util/Date;", "getMissionExpireTime", "setMissionExpireTime", "(Ljava/util/Date;)V", "getMissionFinishImage", "setMissionFinishImage", "getMissionId", "setMissionId", "getMissionName", "setMissionName", "getMissionStatus", "setMissionStatus", "getMissionThumbnail", "setMissionThumbnail", "getMissionTnc", "setMissionTnc", "getMissionType", "setMissionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MissionEntityResult implements Serializable {
    private boolean hasPrize;
    private String missionActiveImage;
    private String missionDescription;
    private Date missionExpireTime;
    private String missionFinishImage;
    private String missionId;
    private String missionName;
    private String missionStatus;
    private String missionThumbnail;
    private String missionTnc;
    private String missionType;

    public MissionEntityResult() {
        this(null, null, null, null, null, null, null, null, false, null, null, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getMissionType() {
        return this.missionType;
    }

    /* renamed from: component11  reason: from getter */
    public final String getMissionTnc() {
        return this.missionTnc;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMissionName() {
        return this.missionName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMissionStatus() {
        return this.missionStatus;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMissionDescription() {
        return this.missionDescription;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMissionActiveImage() {
        return this.missionActiveImage;
    }

    /* renamed from: component6  reason: from getter */
    public final Date getMissionExpireTime() {
        return this.missionExpireTime;
    }

    /* renamed from: component7  reason: from getter */
    public final String getMissionFinishImage() {
        return this.missionFinishImage;
    }

    /* renamed from: component8  reason: from getter */
    public final String getMissionThumbnail() {
        return this.missionThumbnail;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getHasPrize() {
        return this.hasPrize;
    }

    public final MissionEntityResult copy(String missionId, String missionName, String missionStatus, String missionDescription, String missionActiveImage, Date missionExpireTime, String missionFinishImage, String missionThumbnail, boolean hasPrize, String missionType, String missionTnc) {
        return new MissionEntityResult(missionId, missionName, missionStatus, missionDescription, missionActiveImage, missionExpireTime, missionFinishImage, missionThumbnail, hasPrize, missionType, missionTnc);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MissionEntityResult) {
            MissionEntityResult missionEntityResult = (MissionEntityResult) other;
            return Intrinsics.areEqual(this.missionId, missionEntityResult.missionId) && Intrinsics.areEqual(this.missionName, missionEntityResult.missionName) && Intrinsics.areEqual(this.missionStatus, missionEntityResult.missionStatus) && Intrinsics.areEqual(this.missionDescription, missionEntityResult.missionDescription) && Intrinsics.areEqual(this.missionActiveImage, missionEntityResult.missionActiveImage) && Intrinsics.areEqual(this.missionExpireTime, missionEntityResult.missionExpireTime) && Intrinsics.areEqual(this.missionFinishImage, missionEntityResult.missionFinishImage) && Intrinsics.areEqual(this.missionThumbnail, missionEntityResult.missionThumbnail) && this.hasPrize == missionEntityResult.hasPrize && Intrinsics.areEqual(this.missionType, missionEntityResult.missionType) && Intrinsics.areEqual(this.missionTnc, missionEntityResult.missionTnc);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.missionId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.missionName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.missionStatus;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.missionDescription;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.missionActiveImage;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        Date date = this.missionExpireTime;
        int hashCode6 = date == null ? 0 : date.hashCode();
        String str6 = this.missionFinishImage;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.missionThumbnail;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.hasPrize;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str8 = this.missionType;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.missionTnc;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i) * 31) + hashCode9) * 31) + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MissionEntityResult(missionId=");
        sb.append(this.missionId);
        sb.append(", missionName=");
        sb.append(this.missionName);
        sb.append(", missionStatus=");
        sb.append(this.missionStatus);
        sb.append(", missionDescription=");
        sb.append(this.missionDescription);
        sb.append(", missionActiveImage=");
        sb.append(this.missionActiveImage);
        sb.append(", missionExpireTime=");
        sb.append(this.missionExpireTime);
        sb.append(", missionFinishImage=");
        sb.append(this.missionFinishImage);
        sb.append(", missionThumbnail=");
        sb.append(this.missionThumbnail);
        sb.append(", hasPrize=");
        sb.append(this.hasPrize);
        sb.append(", missionType=");
        sb.append(this.missionType);
        sb.append(", missionTnc=");
        sb.append(this.missionTnc);
        sb.append(')');
        return sb.toString();
    }

    public MissionEntityResult(String str, String str2, String str3, String str4, String str5, Date date, String str6, String str7, boolean z, String str8, String str9) {
        this.missionId = str;
        this.missionName = str2;
        this.missionStatus = str3;
        this.missionDescription = str4;
        this.missionActiveImage = str5;
        this.missionExpireTime = date;
        this.missionFinishImage = str6;
        this.missionThumbnail = str7;
        this.hasPrize = z;
        this.missionType = str8;
        this.missionTnc = str9;
    }

    public /* synthetic */ MissionEntityResult(String str, String str2, String str3, String str4, String str5, Date date, String str6, String str7, boolean z, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : date, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? false : z, (i & 512) != 0 ? null : str8, (i & 1024) == 0 ? str9 : null);
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

    @JvmName(name = "getMissionStatus")
    public final String getMissionStatus() {
        return this.missionStatus;
    }

    @JvmName(name = "setMissionStatus")
    public final void setMissionStatus(String str) {
        this.missionStatus = str;
    }

    @JvmName(name = "getMissionDescription")
    public final String getMissionDescription() {
        return this.missionDescription;
    }

    @JvmName(name = "setMissionDescription")
    public final void setMissionDescription(String str) {
        this.missionDescription = str;
    }

    @JvmName(name = "getMissionActiveImage")
    public final String getMissionActiveImage() {
        return this.missionActiveImage;
    }

    @JvmName(name = "setMissionActiveImage")
    public final void setMissionActiveImage(String str) {
        this.missionActiveImage = str;
    }

    @JvmName(name = "getMissionExpireTime")
    public final Date getMissionExpireTime() {
        return this.missionExpireTime;
    }

    @JvmName(name = "setMissionExpireTime")
    public final void setMissionExpireTime(Date date) {
        this.missionExpireTime = date;
    }

    @JvmName(name = "getMissionFinishImage")
    public final String getMissionFinishImage() {
        return this.missionFinishImage;
    }

    @JvmName(name = "setMissionFinishImage")
    public final void setMissionFinishImage(String str) {
        this.missionFinishImage = str;
    }

    @JvmName(name = "getMissionThumbnail")
    public final String getMissionThumbnail() {
        return this.missionThumbnail;
    }

    @JvmName(name = "setMissionThumbnail")
    public final void setMissionThumbnail(String str) {
        this.missionThumbnail = str;
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
        this.missionTnc = str;
    }
}
