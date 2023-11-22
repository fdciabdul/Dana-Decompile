package id.dana.wallet_v3.model;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b;\u0018\u00002\u00020\u0001Bå\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010C\u001a\u00020\u0002\u0012\b\b\u0002\u0010F\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010I\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\bL\u0010MR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\"\u00104\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010=\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\"\u0010@\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\"\u0010C\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\"\u0010F\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\"\u0010I\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\b"}, d2 = {"Lid/dana/wallet_v3/model/KtpInfoModel;", "", "", "backgroundUrl", "Ljava/lang/String;", "getBackgroundUrl", "()Ljava/lang/String;", "setBackgroundUrl", "(Ljava/lang/String;)V", "cardTitle", "getCardTitle", "setCardTitle", ZIMFacade.KEY_CERT_NAME, "getCertName", "setCertName", ZIMFacade.KEY_CERT_NO, "getCertNo", "setCertNo", "", "createdDate", "Ljava/lang/Long;", "getCreatedDate", "()Ljava/lang/Long;", "setCreatedDate", "(Ljava/lang/Long;)V", "dateOfBirth", "getDateOfBirth", "setDateOfBirth", "district", "getDistrict", "setDistrict", "gender", "getGender", "setGender", "homeAddress", "getHomeAddress", "setHomeAddress", "iconUrl", "getIconUrl", "setIconUrl", DecodedScanBizInfoKey.LOGO_URL, "getLogoUrl", "setLogoUrl", "marriage", "getMarriage", "setMarriage", "nationality", "getNationality", "setNationality", "occupation", "getOccupation", "setOccupation", "placeOfBirth", "getPlaceOfBirth", "setPlaceOfBirth", "pocketId", "getPocketId", "setPocketId", "pocketStatus", "getPocketStatus", "setPocketStatus", "pocketType", "getPocketType", "setPocketType", "religion", "getReligion", "setReligion", RVParams.READ_TITLE, "getRt", "setRt", "rw", "getRw", "setRw", "subdistrict", "getSubdistrict", "setSubdistrict", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KtpInfoModel {
    private String backgroundUrl;
    private String cardTitle;
    private String certName;
    private String certNo;
    private Long createdDate;
    private String dateOfBirth;
    private String district;
    private String gender;
    private String homeAddress;
    private String iconUrl;
    private String logoUrl;
    private String marriage;
    private String nationality;
    private String occupation;
    private String placeOfBirth;
    private String pocketId;
    private String pocketStatus;
    private String pocketType;
    private String religion;
    private String rt;
    private String rw;
    private String subdistrict;

    public KtpInfoModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    public KtpInfoModel(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        Intrinsics.checkNotNullParameter(str18, "");
        Intrinsics.checkNotNullParameter(str19, "");
        Intrinsics.checkNotNullParameter(str20, "");
        Intrinsics.checkNotNullParameter(str21, "");
        this.backgroundUrl = str;
        this.createdDate = l;
        this.iconUrl = str2;
        this.logoUrl = str3;
        this.pocketId = str4;
        this.pocketStatus = str5;
        this.pocketType = str6;
        this.certNo = str7;
        this.certName = str8;
        this.dateOfBirth = str9;
        this.placeOfBirth = str10;
        this.homeAddress = str11;
        this.religion = str12;
        this.gender = str13;
        this.rt = str14;
        this.rw = str15;
        this.marriage = str16;
        this.nationality = str17;
        this.occupation = str18;
        this.district = str19;
        this.subdistrict = str20;
        this.cardTitle = str21;
    }

    public /* synthetic */ KtpInfoModel(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, (i & 32768) != 0 ? "" : str15, (i & 65536) != 0 ? "" : str16, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str17, (i & 262144) != 0 ? "" : str18, (i & 524288) != 0 ? "" : str19, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str20, (i & 2097152) != 0 ? "" : str21);
    }

    @JvmName(name = "getBackgroundUrl")
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @JvmName(name = "setBackgroundUrl")
    public final void setBackgroundUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.backgroundUrl = str;
    }

    @JvmName(name = "getCreatedDate")
    public final Long getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "setCreatedDate")
    public final void setCreatedDate(Long l) {
        this.createdDate = l;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "setIconUrl")
    public final void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.iconUrl = str;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "setLogoUrl")
    public final void setLogoUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.logoUrl = str;
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "setPocketId")
    public final void setPocketId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketId = str;
    }

    @JvmName(name = "getPocketStatus")
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "setPocketStatus")
    public final void setPocketStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketStatus = str;
    }

    @JvmName(name = "getPocketType")
    public final String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "setPocketType")
    public final void setPocketType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketType = str;
    }

    @JvmName(name = "getCertNo")
    public final String getCertNo() {
        return this.certNo;
    }

    @JvmName(name = "setCertNo")
    public final void setCertNo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.certNo = str;
    }

    @JvmName(name = "getCertName")
    public final String getCertName() {
        return this.certName;
    }

    @JvmName(name = "setCertName")
    public final void setCertName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.certName = str;
    }

    @JvmName(name = "getDateOfBirth")
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    @JvmName(name = "setDateOfBirth")
    public final void setDateOfBirth(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.dateOfBirth = str;
    }

    @JvmName(name = "getPlaceOfBirth")
    public final String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    @JvmName(name = "setPlaceOfBirth")
    public final void setPlaceOfBirth(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.placeOfBirth = str;
    }

    @JvmName(name = "getHomeAddress")
    public final String getHomeAddress() {
        return this.homeAddress;
    }

    @JvmName(name = "setHomeAddress")
    public final void setHomeAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.homeAddress = str;
    }

    @JvmName(name = "getReligion")
    public final String getReligion() {
        return this.religion;
    }

    @JvmName(name = "setReligion")
    public final void setReligion(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.religion = str;
    }

    @JvmName(name = "getGender")
    public final String getGender() {
        return this.gender;
    }

    @JvmName(name = "setGender")
    public final void setGender(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.gender = str;
    }

    @JvmName(name = "getRt")
    public final String getRt() {
        return this.rt;
    }

    @JvmName(name = "setRt")
    public final void setRt(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.rt = str;
    }

    @JvmName(name = "getRw")
    public final String getRw() {
        return this.rw;
    }

    @JvmName(name = "setRw")
    public final void setRw(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.rw = str;
    }

    @JvmName(name = "getMarriage")
    public final String getMarriage() {
        return this.marriage;
    }

    @JvmName(name = "setMarriage")
    public final void setMarriage(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.marriage = str;
    }

    @JvmName(name = "getNationality")
    public final String getNationality() {
        return this.nationality;
    }

    @JvmName(name = "setNationality")
    public final void setNationality(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.nationality = str;
    }

    @JvmName(name = "getOccupation")
    public final String getOccupation() {
        return this.occupation;
    }

    @JvmName(name = "setOccupation")
    public final void setOccupation(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.occupation = str;
    }

    @JvmName(name = "getDistrict")
    public final String getDistrict() {
        return this.district;
    }

    @JvmName(name = "setDistrict")
    public final void setDistrict(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.district = str;
    }

    @JvmName(name = "getSubdistrict")
    public final String getSubdistrict() {
        return this.subdistrict;
    }

    @JvmName(name = "setSubdistrict")
    public final void setSubdistrict(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.subdistrict = str;
    }

    @JvmName(name = "getCardTitle")
    public final String getCardTitle() {
        return this.cardTitle;
    }

    @JvmName(name = "setCardTitle")
    public final void setCardTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cardTitle = str;
    }
}
