package id.dana.domain.model.rpc;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B\u0082\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f¢\u0006\u0002\b\u0017\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bp\u0010qJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u001d\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f¢\u0006\u0002\b\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000eJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u008b\u0002\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f¢\u0006\u0002\b\u00172\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00105\u001a\u000204HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u000204HÖ\u0001¢\u0006\u0004\b;\u00106J\u0010\u0010<\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b<\u0010\u0004J \u0010A\u001a\u00020@2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u000204HÖ\u0001¢\u0006\u0004\bA\u0010BR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010C\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u0010FR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010C\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u0010FR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010C\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u0010FR*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010K\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010NR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010C\u001a\u0004\bO\u0010\u0004\"\u0004\bP\u0010FR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010C\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u0010FR$\u0010(\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010S\u001a\u0004\b(\u0010\u0007\"\u0004\bT\u0010UR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010C\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010FR$\u00101\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010C\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010FR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010C\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010FR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010C\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010FR/\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f¢\u0006\u0002\b\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010K\u001a\u0004\b^\u0010\u000e\"\u0004\b_\u0010NR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010C\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010FR*\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010K\u001a\u0004\bb\u0010\u000e\"\u0004\bc\u0010NR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010C\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010FR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010C\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010FR$\u00100\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010h\u001a\u0004\bi\u0010\u0013\"\u0004\bj\u0010kR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010C\u001a\u0004\bl\u0010\u0004\"\u0004\bm\u0010FR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010C\u001a\u0004\bn\u0010\u0004\"\u0004\bo\u0010F"}, d2 = {"Lid/dana/domain/model/rpc/UserInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/lang/Boolean;", "component11", "component12", "component13", "component14", "", "component15", "()Ljava/util/List;", "component16", "component17", "Ljava/util/Date;", "component18", "()Ljava/util/Date;", "component19", "component2", "Lid/dana/domain/model/rpc/LoginInfo;", "Lkotlinx/android/parcel/RawValue;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "userId", "userStatus", "loginIdInfos", AccountEntityRepository.UpdateType.AVATAR, "nickname", "birthday", "job", "nationality", "gender", "isCertified", "certifiedLevel", "firstName", "middleName", "lastName", "mobileNos", "emails", "language", "registeredTime", WalletConstant.KYC_LEVEL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)Lid/dana/domain/model/rpc/UserInfo;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAvatarUrl", "setAvatarUrl", "(Ljava/lang/String;)V", "getBirthday", "setBirthday", "getCertifiedLevel", "setCertifiedLevel", "Ljava/util/List;", "getEmails", "setEmails", "(Ljava/util/List;)V", "getFirstName", "setFirstName", "getGender", "setGender", "Ljava/lang/Boolean;", "setCertified", "(Ljava/lang/Boolean;)V", "getJob", "setJob", "getKycLevel", "setKycLevel", ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE, "setLanguage", "getLastName", "setLastName", "getLoginIdInfos", "setLoginIdInfos", "getMiddleName", "setMiddleName", "getMobileNos", "setMobileNos", "getNationality", "setNationality", "getNickname", "setNickname", "Ljava/util/Date;", "getRegisteredTime", "setRegisteredTime", "(Ljava/util/Date;)V", "getUserId", "setUserId", "getUserStatus", "setUserStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Creator();
    private String avatarUrl;
    private String birthday;
    private String certifiedLevel;
    private List<String> emails;
    private String firstName;
    private String gender;
    private Boolean isCertified;
    private String job;
    private String kycLevel;
    private String language;
    private String lastName;
    private List<LoginInfo> loginIdInfos;
    private String middleName;
    private List<String> mobileNos;
    private String nationality;
    private String nickname;
    private Date registeredTime;
    private String userId;
    private String userStatus;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<UserInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserInfo createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(parcel.readValue(UserInfo.class.getClassLoader()));
                }
            }
            return new UserInfo(readString, readString2, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString(), (Date) parcel.readSerializable(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    }

    public UserInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component10  reason: from getter */
    public final Boolean getIsCertified() {
        return this.isCertified;
    }

    /* renamed from: component11  reason: from getter */
    public final String getCertifiedLevel() {
        return this.certifiedLevel;
    }

    /* renamed from: component12  reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component13  reason: from getter */
    public final String getMiddleName() {
        return this.middleName;
    }

    /* renamed from: component14  reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    public final List<String> component15() {
        return this.mobileNos;
    }

    public final List<String> component16() {
        return this.emails;
    }

    /* renamed from: component17  reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component18  reason: from getter */
    public final Date getRegisteredTime() {
        return this.registeredTime;
    }

    /* renamed from: component19  reason: from getter */
    public final String getKycLevel() {
        return this.kycLevel;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUserStatus() {
        return this.userStatus;
    }

    public final List<LoginInfo> component3() {
        return this.loginIdInfos;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBirthday() {
        return this.birthday;
    }

    /* renamed from: component7  reason: from getter */
    public final String getJob() {
        return this.job;
    }

    /* renamed from: component8  reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* renamed from: component9  reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    public final UserInfo copy(String userId, String userStatus, List<LoginInfo> loginIdInfos, String avatarUrl, String nickname, String birthday, String job, String nationality, String gender, Boolean isCertified, String certifiedLevel, String firstName, String middleName, String lastName, List<String> mobileNos, List<String> emails, String language, Date registeredTime, String kycLevel) {
        return new UserInfo(userId, userStatus, loginIdInfos, avatarUrl, nickname, birthday, job, nationality, gender, isCertified, certifiedLevel, firstName, middleName, lastName, mobileNos, emails, language, registeredTime, kycLevel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserInfo) {
            UserInfo userInfo = (UserInfo) other;
            return Intrinsics.areEqual(this.userId, userInfo.userId) && Intrinsics.areEqual(this.userStatus, userInfo.userStatus) && Intrinsics.areEqual(this.loginIdInfos, userInfo.loginIdInfos) && Intrinsics.areEqual(this.avatarUrl, userInfo.avatarUrl) && Intrinsics.areEqual(this.nickname, userInfo.nickname) && Intrinsics.areEqual(this.birthday, userInfo.birthday) && Intrinsics.areEqual(this.job, userInfo.job) && Intrinsics.areEqual(this.nationality, userInfo.nationality) && Intrinsics.areEqual(this.gender, userInfo.gender) && Intrinsics.areEqual(this.isCertified, userInfo.isCertified) && Intrinsics.areEqual(this.certifiedLevel, userInfo.certifiedLevel) && Intrinsics.areEqual(this.firstName, userInfo.firstName) && Intrinsics.areEqual(this.middleName, userInfo.middleName) && Intrinsics.areEqual(this.lastName, userInfo.lastName) && Intrinsics.areEqual(this.mobileNos, userInfo.mobileNos) && Intrinsics.areEqual(this.emails, userInfo.emails) && Intrinsics.areEqual(this.language, userInfo.language) && Intrinsics.areEqual(this.registeredTime, userInfo.registeredTime) && Intrinsics.areEqual(this.kycLevel, userInfo.kycLevel);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.userStatus;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        List<LoginInfo> list = this.loginIdInfos;
        int hashCode3 = list == null ? 0 : list.hashCode();
        String str3 = this.avatarUrl;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.nickname;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.birthday;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.job;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.nationality;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.gender;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        Boolean bool = this.isCertified;
        int hashCode10 = bool == null ? 0 : bool.hashCode();
        String str9 = this.certifiedLevel;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.firstName;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.middleName;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.lastName;
        int hashCode14 = str12 == null ? 0 : str12.hashCode();
        List<String> list2 = this.mobileNos;
        int hashCode15 = list2 == null ? 0 : list2.hashCode();
        List<String> list3 = this.emails;
        int hashCode16 = list3 == null ? 0 : list3.hashCode();
        String str13 = this.language;
        int hashCode17 = str13 == null ? 0 : str13.hashCode();
        Date date = this.registeredTime;
        int hashCode18 = date == null ? 0 : date.hashCode();
        String str14 = this.kycLevel;
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + (str14 != null ? str14.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfo(userId=");
        sb.append(this.userId);
        sb.append(", userStatus=");
        sb.append(this.userStatus);
        sb.append(", loginIdInfos=");
        sb.append(this.loginIdInfos);
        sb.append(", avatarUrl=");
        sb.append(this.avatarUrl);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", birthday=");
        sb.append(this.birthday);
        sb.append(", job=");
        sb.append(this.job);
        sb.append(", nationality=");
        sb.append(this.nationality);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", isCertified=");
        sb.append(this.isCertified);
        sb.append(", certifiedLevel=");
        sb.append(this.certifiedLevel);
        sb.append(", firstName=");
        sb.append(this.firstName);
        sb.append(", middleName=");
        sb.append(this.middleName);
        sb.append(", lastName=");
        sb.append(this.lastName);
        sb.append(", mobileNos=");
        sb.append(this.mobileNos);
        sb.append(", emails=");
        sb.append(this.emails);
        sb.append(", language=");
        sb.append(this.language);
        sb.append(", registeredTime=");
        sb.append(this.registeredTime);
        sb.append(", kycLevel=");
        sb.append(this.kycLevel);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.userId);
        parcel.writeString(this.userStatus);
        List<LoginInfo> list = this.loginIdInfos;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<LoginInfo> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeValue(it.next());
            }
        }
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.nickname);
        parcel.writeString(this.birthday);
        parcel.writeString(this.job);
        parcel.writeString(this.nationality);
        parcel.writeString(this.gender);
        Boolean bool = this.isCertified;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.certifiedLevel);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeStringList(this.mobileNos);
        parcel.writeStringList(this.emails);
        parcel.writeString(this.language);
        parcel.writeSerializable(this.registeredTime);
        parcel.writeString(this.kycLevel);
    }

    public UserInfo(String str, String str2, List<LoginInfo> list, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, List<String> list2, List<String> list3, String str13, Date date, String str14) {
        this.userId = str;
        this.userStatus = str2;
        this.loginIdInfos = list;
        this.avatarUrl = str3;
        this.nickname = str4;
        this.birthday = str5;
        this.job = str6;
        this.nationality = str7;
        this.gender = str8;
        this.isCertified = bool;
        this.certifiedLevel = str9;
        this.firstName = str10;
        this.middleName = str11;
        this.lastName = str12;
        this.mobileNos = list2;
        this.emails = list3;
        this.language = str13;
        this.registeredTime = date;
        this.kycLevel = str14;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    @JvmName(name = "getUserStatus")
    public final String getUserStatus() {
        return this.userStatus;
    }

    @JvmName(name = "setUserStatus")
    public final void setUserStatus(String str) {
        this.userStatus = str;
    }

    public /* synthetic */ UserInfo(String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, List list2, List list3, String str13, Date date, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new ArrayList() : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? Boolean.FALSE : bool, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : list2, (i & 32768) != 0 ? null : list3, (i & 65536) != 0 ? null : str13, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : date, (i & 262144) != 0 ? null : str14);
    }

    @JvmName(name = "getLoginIdInfos")
    public final List<LoginInfo> getLoginIdInfos() {
        return this.loginIdInfos;
    }

    @JvmName(name = "setLoginIdInfos")
    public final void setLoginIdInfos(List<LoginInfo> list) {
        this.loginIdInfos = list;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "setAvatarUrl")
    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "setNickname")
    public final void setNickname(String str) {
        this.nickname = str;
    }

    @JvmName(name = "getBirthday")
    public final String getBirthday() {
        return this.birthday;
    }

    @JvmName(name = "setBirthday")
    public final void setBirthday(String str) {
        this.birthday = str;
    }

    @JvmName(name = "getJob")
    public final String getJob() {
        return this.job;
    }

    @JvmName(name = "setJob")
    public final void setJob(String str) {
        this.job = str;
    }

    @JvmName(name = "getNationality")
    public final String getNationality() {
        return this.nationality;
    }

    @JvmName(name = "setNationality")
    public final void setNationality(String str) {
        this.nationality = str;
    }

    @JvmName(name = "getGender")
    public final String getGender() {
        return this.gender;
    }

    @JvmName(name = "setGender")
    public final void setGender(String str) {
        this.gender = str;
    }

    @JvmName(name = "isCertified")
    public final Boolean isCertified() {
        return this.isCertified;
    }

    @JvmName(name = "setCertified")
    public final void setCertified(Boolean bool) {
        this.isCertified = bool;
    }

    @JvmName(name = "getCertifiedLevel")
    public final String getCertifiedLevel() {
        return this.certifiedLevel;
    }

    @JvmName(name = "setCertifiedLevel")
    public final void setCertifiedLevel(String str) {
        this.certifiedLevel = str;
    }

    @JvmName(name = "getFirstName")
    public final String getFirstName() {
        return this.firstName;
    }

    @JvmName(name = "setFirstName")
    public final void setFirstName(String str) {
        this.firstName = str;
    }

    @JvmName(name = "getMiddleName")
    public final String getMiddleName() {
        return this.middleName;
    }

    @JvmName(name = "setMiddleName")
    public final void setMiddleName(String str) {
        this.middleName = str;
    }

    @JvmName(name = "getLastName")
    public final String getLastName() {
        return this.lastName;
    }

    @JvmName(name = "setLastName")
    public final void setLastName(String str) {
        this.lastName = str;
    }

    @JvmName(name = "getMobileNos")
    public final List<String> getMobileNos() {
        return this.mobileNos;
    }

    @JvmName(name = "setMobileNos")
    public final void setMobileNos(List<String> list) {
        this.mobileNos = list;
    }

    @JvmName(name = "getEmails")
    public final List<String> getEmails() {
        return this.emails;
    }

    @JvmName(name = "setEmails")
    public final void setEmails(List<String> list) {
        this.emails = list;
    }

    @JvmName(name = ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE)
    public final String getLanguage() {
        return this.language;
    }

    @JvmName(name = "setLanguage")
    public final void setLanguage(String str) {
        this.language = str;
    }

    @JvmName(name = "getRegisteredTime")
    public final Date getRegisteredTime() {
        return this.registeredTime;
    }

    @JvmName(name = "setRegisteredTime")
    public final void setRegisteredTime(Date date) {
        this.registeredTime = date;
    }

    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @JvmName(name = "setKycLevel")
    public final void setKycLevel(String str) {
        this.kycLevel = str;
    }
}
