package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0001\u0012B)\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0001\u0013"}, d2 = {"Lid/dana/wallet_v3/model/IdentityCardModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "pocketId", "Ljava/lang/String;", "getPocketId", "()Ljava/lang/String;", "pocketStatus", "getPocketStatus", "pocketType", "getPocketType", "", "viewType", "I", "getViewType", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "KtpCard", "Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class IdentityCardModel extends WalletV3CardModel {
    private final String pocketId;
    private final String pocketStatus;
    private final String pocketType;
    private final int viewType;

    public /* synthetic */ IdentityCardModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i);
    }

    @JvmName(name = "getPocketId")
    public String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "getPocketStatus")
    public String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "getPocketType")
    public String getPocketType() {
        return this.pocketType;
    }

    @Override // id.dana.wallet_v3.model.WalletV3CardModel
    @JvmName(name = "getViewType")
    public int getViewType() {
        return this.viewType;
    }

    private IdentityCardModel(String str, String str2, String str3, int i) {
        super(i, null);
        this.pocketId = str;
        this.pocketStatus = str2;
        this.pocketType = str3;
        this.viewType = i;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0014\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002¢\u0006\u0004\bq\u0010rJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004Jî\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\b\b\u0002\u00101\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b6\u0010\u0016J\u001a\u0010:\u001a\u0002092\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b<\u0010\u0016J\u0010\u0010=\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b=\u0010\u0004J \u0010B\u001a\u00020A2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\bB\u0010CR\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010D\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010GR\"\u0010'\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010D\u001a\u0004\bH\u0010\u0004\"\u0004\bI\u0010GR\"\u0010&\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010D\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u0010GR$\u0010#\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010L\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010OR\"\u0010(\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010D\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010GR\"\u00102\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010D\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010GR\"\u0010,\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010D\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u0010GR\"\u0010*\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010D\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010GR\"\u0010$\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010D\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010GR\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010D\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010GR\"\u0010/\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010D\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010GR\"\u00100\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010D\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010GR\"\u00101\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010D\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010GR\"\u0010)\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010D\u001a\u0004\bb\u0010\u0004\"\u0004\bc\u0010GR\u001a\u0010\u001e\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u0010D\u001a\u0004\bd\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001f\u0010D\u001a\u0004\be\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b \u0010D\u001a\u0004\bf\u0010\u0004R\"\u0010+\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010D\u001a\u0004\bg\u0010\u0004\"\u0004\bh\u0010GR\"\u0010-\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010D\u001a\u0004\bi\u0010\u0004\"\u0004\bj\u0010GR\"\u0010.\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010D\u001a\u0004\bk\u0010\u0004\"\u0004\bl\u0010GR\"\u00103\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010D\u001a\u0004\bm\u0010\u0004\"\u0004\bn\u0010GR\u001a\u0010!\u001a\u00020\u00148\u0017X\u0097\u0004¢\u0006\f\n\u0004\b!\u0010o\u001a\u0004\bp\u0010\u0016"}, d2 = {"Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;", "Lid/dana/wallet_v3/model/IdentityCardModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "", "component4", "()I", "component5", "", "component6", "()Ljava/lang/Long;", "component7", "component8", "component9", "pocketId", "pocketStatus", "pocketType", "viewType", "backgroundUrl", "createdDate", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, ZIMFacade.KEY_CERT_NO, ZIMFacade.KEY_CERT_NAME, "dateOfBirth", "placeOfBirth", "homeAddress", "religion", "gender", RVParams.READ_TITLE, "rw", "marriage", "nationality", "occupation", "district", "subdistrict", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/model/IdentityCardModel$KtpCard;", "describeContents", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "getCertName", "setCertName", "getCertNo", "setCertNo", "Ljava/lang/Long;", "getCreatedDate", "setCreatedDate", "(Ljava/lang/Long;)V", "getDateOfBirth", "setDateOfBirth", "getDistrict", "setDistrict", "getGender", "setGender", "getHomeAddress", "setHomeAddress", "getIconUrl", "setIconUrl", "getLogoUrl", "setLogoUrl", "getMarriage", "setMarriage", "getNationality", "setNationality", "getOccupation", "setOccupation", "getPlaceOfBirth", "setPlaceOfBirth", "getPocketId", "getPocketStatus", "getPocketType", "getReligion", "setReligion", "getRt", "setRt", "getRw", "setRw", "getSubdistrict", "setSubdistrict", "I", "getViewType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class KtpCard extends IdentityCardModel {
        public static final Parcelable.Creator<KtpCard> CREATOR = new Creator();
        private String backgroundUrl;
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
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private String religion;
        private String rt;
        private String rw;
        private String subdistrict;
        private final int viewType;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<KtpCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final KtpCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new KtpCard(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final KtpCard[] newArray(int i) {
                return new KtpCard[i];
            }
        }

        public KtpCard() {
            this(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getCertName() {
            return this.certName;
        }

        /* renamed from: component11  reason: from getter */
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        /* renamed from: component12  reason: from getter */
        public final String getPlaceOfBirth() {
            return this.placeOfBirth;
        }

        /* renamed from: component13  reason: from getter */
        public final String getHomeAddress() {
            return this.homeAddress;
        }

        /* renamed from: component14  reason: from getter */
        public final String getReligion() {
            return this.religion;
        }

        /* renamed from: component15  reason: from getter */
        public final String getGender() {
            return this.gender;
        }

        /* renamed from: component16  reason: from getter */
        public final String getRt() {
            return this.rt;
        }

        /* renamed from: component17  reason: from getter */
        public final String getRw() {
            return this.rw;
        }

        /* renamed from: component18  reason: from getter */
        public final String getMarriage() {
            return this.marriage;
        }

        /* renamed from: component19  reason: from getter */
        public final String getNationality() {
            return this.nationality;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final String getOccupation() {
            return this.occupation;
        }

        /* renamed from: component21  reason: from getter */
        public final String getDistrict() {
            return this.district;
        }

        /* renamed from: component22  reason: from getter */
        public final String getSubdistrict() {
            return this.subdistrict;
        }

        public final String component3() {
            return getPocketType();
        }

        public final int component4() {
            return getViewType();
        }

        /* renamed from: component5  reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        /* renamed from: component6  reason: from getter */
        public final Long getCreatedDate() {
            return this.createdDate;
        }

        /* renamed from: component7  reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: component8  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component9  reason: from getter */
        public final String getCertNo() {
            return this.certNo;
        }

        public final KtpCard copy(String pocketId, String pocketStatus, String pocketType, int viewType, String backgroundUrl, Long createdDate, String iconUrl, String logoUrl, String certNo, String certName, String dateOfBirth, String placeOfBirth, String homeAddress, String religion, String gender, String rt, String rw, String marriage, String nationality, String occupation, String district, String subdistrict) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            Intrinsics.checkNotNullParameter(certNo, "");
            Intrinsics.checkNotNullParameter(certName, "");
            Intrinsics.checkNotNullParameter(dateOfBirth, "");
            Intrinsics.checkNotNullParameter(placeOfBirth, "");
            Intrinsics.checkNotNullParameter(homeAddress, "");
            Intrinsics.checkNotNullParameter(religion, "");
            Intrinsics.checkNotNullParameter(gender, "");
            Intrinsics.checkNotNullParameter(rt, "");
            Intrinsics.checkNotNullParameter(rw, "");
            Intrinsics.checkNotNullParameter(marriage, "");
            Intrinsics.checkNotNullParameter(nationality, "");
            Intrinsics.checkNotNullParameter(occupation, "");
            Intrinsics.checkNotNullParameter(district, "");
            Intrinsics.checkNotNullParameter(subdistrict, "");
            return new KtpCard(pocketId, pocketStatus, pocketType, viewType, backgroundUrl, createdDate, iconUrl, logoUrl, certNo, certName, dateOfBirth, placeOfBirth, homeAddress, religion, gender, rt, rw, marriage, nationality, occupation, district, subdistrict);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof KtpCard) {
                KtpCard ktpCard = (KtpCard) other;
                return Intrinsics.areEqual(getPocketId(), ktpCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), ktpCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), ktpCard.getPocketType()) && getViewType() == ktpCard.getViewType() && Intrinsics.areEqual(this.backgroundUrl, ktpCard.backgroundUrl) && Intrinsics.areEqual(this.createdDate, ktpCard.createdDate) && Intrinsics.areEqual(this.iconUrl, ktpCard.iconUrl) && Intrinsics.areEqual(this.logoUrl, ktpCard.logoUrl) && Intrinsics.areEqual(this.certNo, ktpCard.certNo) && Intrinsics.areEqual(this.certName, ktpCard.certName) && Intrinsics.areEqual(this.dateOfBirth, ktpCard.dateOfBirth) && Intrinsics.areEqual(this.placeOfBirth, ktpCard.placeOfBirth) && Intrinsics.areEqual(this.homeAddress, ktpCard.homeAddress) && Intrinsics.areEqual(this.religion, ktpCard.religion) && Intrinsics.areEqual(this.gender, ktpCard.gender) && Intrinsics.areEqual(this.rt, ktpCard.rt) && Intrinsics.areEqual(this.rw, ktpCard.rw) && Intrinsics.areEqual(this.marriage, ktpCard.marriage) && Intrinsics.areEqual(this.nationality, ktpCard.nationality) && Intrinsics.areEqual(this.occupation, ktpCard.occupation) && Intrinsics.areEqual(this.district, ktpCard.district) && Intrinsics.areEqual(this.subdistrict, ktpCard.subdistrict);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            int viewType = getViewType();
            int hashCode4 = this.backgroundUrl.hashCode();
            Long l = this.createdDate;
            return (((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + viewType) * 31) + hashCode4) * 31) + (l == null ? 0 : l.hashCode())) * 31) + this.iconUrl.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.certNo.hashCode()) * 31) + this.certName.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.placeOfBirth.hashCode()) * 31) + this.homeAddress.hashCode()) * 31) + this.religion.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.rt.hashCode()) * 31) + this.rw.hashCode()) * 31) + this.marriage.hashCode()) * 31) + this.nationality.hashCode()) * 31) + this.occupation.hashCode()) * 31) + this.district.hashCode()) * 31) + this.subdistrict.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("KtpCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", viewType=");
            sb.append(getViewType());
            sb.append(", backgroundUrl=");
            sb.append(this.backgroundUrl);
            sb.append(", createdDate=");
            sb.append(this.createdDate);
            sb.append(", iconUrl=");
            sb.append(this.iconUrl);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", certNo=");
            sb.append(this.certNo);
            sb.append(", certName=");
            sb.append(this.certName);
            sb.append(", dateOfBirth=");
            sb.append(this.dateOfBirth);
            sb.append(", placeOfBirth=");
            sb.append(this.placeOfBirth);
            sb.append(", homeAddress=");
            sb.append(this.homeAddress);
            sb.append(", religion=");
            sb.append(this.religion);
            sb.append(", gender=");
            sb.append(this.gender);
            sb.append(", rt=");
            sb.append(this.rt);
            sb.append(", rw=");
            sb.append(this.rw);
            sb.append(", marriage=");
            sb.append(this.marriage);
            sb.append(", nationality=");
            sb.append(this.nationality);
            sb.append(", occupation=");
            sb.append(this.occupation);
            sb.append(", district=");
            sb.append(this.district);
            sb.append(", subdistrict=");
            sb.append(this.subdistrict);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.viewType);
            parcel.writeString(this.backgroundUrl);
            Long l = this.createdDate;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.certNo);
            parcel.writeString(this.certName);
            parcel.writeString(this.dateOfBirth);
            parcel.writeString(this.placeOfBirth);
            parcel.writeString(this.homeAddress);
            parcel.writeString(this.religion);
            parcel.writeString(this.gender);
            parcel.writeString(this.rt);
            parcel.writeString(this.rw);
            parcel.writeString(this.marriage);
            parcel.writeString(this.nationality);
            parcel.writeString(this.occupation);
            parcel.writeString(this.district);
            parcel.writeString(this.subdistrict);
        }

        public /* synthetic */ KtpCard(String str, String str2, String str3, int i, String str4, Long l, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 14 : i, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? null : l, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? "" : str10, (i2 & 4096) != 0 ? "" : str11, (i2 & 8192) != 0 ? "" : str12, (i2 & 16384) != 0 ? "" : str13, (i2 & 32768) != 0 ? "" : str14, (i2 & 65536) != 0 ? "" : str15, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str16, (i2 & 262144) != 0 ? "" : str17, (i2 & 524288) != 0 ? "" : str18, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str19, (i2 & 2097152) != 0 ? "" : str20);
        }

        @Override // id.dana.wallet_v3.model.IdentityCardModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.IdentityCardModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.IdentityCardModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.IdentityCardModel, id.dana.wallet_v3.model.WalletV3CardModel
        @JvmName(name = "getViewType")
        public final int getViewType() {
            return this.viewType;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KtpCard(String str, String str2, String str3, int i, String str4, Long l, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
            super(str, str2, str3, i, null);
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
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.viewType = i;
            this.backgroundUrl = str4;
            this.createdDate = l;
            this.iconUrl = str5;
            this.logoUrl = str6;
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
        }
    }
}
