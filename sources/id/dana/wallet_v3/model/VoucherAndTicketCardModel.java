package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.google.firebase.messaging.Constants;
import id.dana.danah5.constant.BridgeName;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\b\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB1\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u00068\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0010\u001a\u00020\u000f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\b\u001e\u001f !\"#$%"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "isUsed", "Z", "()Z", "", "pocketId", "Ljava/lang/String;", "getPocketId", "()Ljava/lang/String;", "pocketStatus", "getPocketStatus", "pocketType", "getPocketType", "", "viewType", "I", "getViewType", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "DealsCard", "EmptyState", "LoadingState", "MovieTicketCard", "ParkingTicketCard", "TravelTicketCard", "VoucherCard", "VoucherShimmerLoadingState", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$DealsCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$ParkingTicketCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$TravelTicketCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$MovieTicketCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$LoadingState;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherShimmerLoadingState;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$EmptyState;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class VoucherAndTicketCardModel extends WalletV3CardModel {
    private final boolean isUsed;
    private final String pocketId;
    private final String pocketStatus;
    private final String pocketType;
    private final int viewType;

    public /* synthetic */ VoucherAndTicketCardModel(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, i);
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

    @JvmName(name = "isUsed")
    /* renamed from: isUsed  reason: from getter */
    public boolean getIsUsed() {
        return this.isUsed;
    }

    @Override // id.dana.wallet_v3.model.WalletV3CardModel
    @JvmName(name = "getViewType")
    public int getViewType() {
        return this.viewType;
    }

    private VoucherAndTicketCardModel(String str, String str2, String str3, boolean z, int i) {
        super(i, null);
        this.pocketId = str;
        this.pocketStatus = str2;
        this.pocketType = str3;
        this.isUsed = z;
        this.viewType = i;
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\r\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\r\u0012\b\b\u0002\u00106\u001a\u00020\r\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010:\u001a\u00020\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000fJ\u0010\u0010\u001e\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004Jü\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\b\b\u0002\u00101\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020\r2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010:\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010>\u001a\u00020=HÖ\u0001¢\u0006\u0004\b>\u0010?J\u001a\u0010B\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010@HÖ\u0003¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020=HÖ\u0001¢\u0006\u0004\bD\u0010?J\u0010\u0010E\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bE\u0010\u0004J \u0010J\u001a\u00020I2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020=HÖ\u0001¢\u0006\u0004\bJ\u0010KR\"\u0010(\u001a\u00020\u00128\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010L\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010OR\"\u0010)\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010P\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u0010SR\"\u00104\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010P\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u0010SR\"\u0010:\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010P\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010SR$\u00107\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010X\u001a\u0004\bY\u0010\u0014\"\u0004\bZ\u0010[R\"\u0010-\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010P\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010SR\"\u00102\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010P\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010SR\u001a\u0010'\u001a\u00020\r8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b'\u0010`\u001a\u0004\b'\u0010\u000fR\"\u00100\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010P\u001a\u0004\ba\u0010\u0004\"\u0004\bb\u0010SR\"\u00103\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010P\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010SR\"\u0010/\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010P\u001a\u0004\be\u0010\u0004\"\u0004\bf\u0010SR$\u00109\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010g\u001a\u0004\bh\u0010\u001a\"\u0004\bi\u0010jR\u001a\u0010$\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010P\u001a\u0004\bk\u0010\u0004R\u001a\u0010%\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b%\u0010P\u001a\u0004\bl\u0010\u0004R\u001a\u0010&\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b&\u0010P\u001a\u0004\bm\u0010\u0004R\"\u00106\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010`\u001a\u0004\bn\u0010\u000f\"\u0004\bo\u0010pR$\u00108\u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010q\u001a\u0004\br\u0010\u0017\"\u0004\bs\u0010tR\"\u0010*\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010P\u001a\u0004\bu\u0010\u0004\"\u0004\bv\u0010SR\"\u00101\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010P\u001a\u0004\bw\u0010\u0004\"\u0004\bx\u0010SR\"\u0010+\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010P\u001a\u0004\by\u0010\u0004\"\u0004\bz\u0010SR\"\u0010,\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010P\u001a\u0004\b{\u0010\u0004\"\u0004\b|\u0010SR\"\u00105\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010`\u001a\u0004\b}\u0010\u000f\"\u0004\b~\u0010pR#\u0010.\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\b.\u0010P\u001a\u0004\b\u007f\u0010\u0004\"\u0005\b\u0080\u0001\u0010S"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "", "component18", "()Z", "component19", "component2", "", "component20", "()Ljava/lang/Long;", "Lid/dana/wallet_v3/model/ShareableRpcInfoModel;", "component21", "()Lid/dana/wallet_v3/model/ShareableRpcInfoModel;", "Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;", "component22", "()Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;", "component23", "component3", "component4", "component5", "()J", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "pocketType", "isUsed", "activateDate", "amount", "shortDescription", "templateId", "uniqueId", "howTo", "userPocketStatus", "merchantId", Constants.ScionAnalytics.PARAM_LABEL, "subLabel", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, "backgroundUrl", "usable", "shareable", "expirationDate", "shareableRpcInfo", "pocketAssetTimerConfigModel", "couponCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Lid/dana/wallet_v3/model/ShareableRpcInfoModel;Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherCard;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getActivateDate", "setActivateDate", "(J)V", "Ljava/lang/String;", "getAmount", "setAmount", "(Ljava/lang/String;)V", "getBackgroundUrl", "setBackgroundUrl", "getCouponCode", "setCouponCode", "Ljava/lang/Long;", "getExpirationDate", "setExpirationDate", "(Ljava/lang/Long;)V", "getHowTo", "setHowTo", "getIconUrl", "setIconUrl", "Z", "getLabel", "setLabel", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;", "getPocketAssetTimerConfigModel", "setPocketAssetTimerConfigModel", "(Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;)V", "getPocketId", "getPocketStatus", "getPocketType", "getShareable", "setShareable", "(Z)V", "Lid/dana/wallet_v3/model/ShareableRpcInfoModel;", "getShareableRpcInfo", "setShareableRpcInfo", "(Lid/dana/wallet_v3/model/ShareableRpcInfoModel;)V", "getShortDescription", "setShortDescription", "getSubLabel", "setSubLabel", "getTemplateId", "setTemplateId", "getUniqueId", "setUniqueId", "getUsable", "setUsable", "getUserPocketStatus", "setUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Lid/dana/wallet_v3/model/ShareableRpcInfoModel;Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VoucherCard extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<VoucherCard> CREATOR = new Creator();
        private long activateDate;
        private String amount;
        private String backgroundUrl;
        private String couponCode;
        private Long expirationDate;
        private String howTo;
        private String iconUrl;
        private final boolean isUsed;
        private String label;
        private String logoUrl;
        private String merchantId;
        private PocketAssetTimerConfigModel pocketAssetTimerConfigModel;
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private boolean shareable;
        private ShareableRpcInfoModel shareableRpcInfo;
        private String shortDescription;
        private String subLabel;
        private String templateId;
        private String uniqueId;
        private boolean usable;
        private String userPocketStatus;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<VoucherCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final VoucherCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new VoucherCard(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : ShareableRpcInfoModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? PocketAssetTimerConfigModel.CREATOR.createFromParcel(parcel) : null, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final VoucherCard[] newArray(int i) {
                return new VoucherCard[i];
            }
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getHowTo() {
            return this.howTo;
        }

        /* renamed from: component11  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        /* renamed from: component12  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component13  reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component14  reason: from getter */
        public final String getSubLabel() {
            return this.subLabel;
        }

        /* renamed from: component15  reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: component16  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component17  reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        /* renamed from: component18  reason: from getter */
        public final boolean getUsable() {
            return this.usable;
        }

        /* renamed from: component19  reason: from getter */
        public final boolean getShareable() {
            return this.shareable;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        /* renamed from: component21  reason: from getter */
        public final ShareableRpcInfoModel getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        /* renamed from: component22  reason: from getter */
        public final PocketAssetTimerConfigModel getPocketAssetTimerConfigModel() {
            return this.pocketAssetTimerConfigModel;
        }

        /* renamed from: component23  reason: from getter */
        public final String getCouponCode() {
            return this.couponCode;
        }

        public final String component3() {
            return getPocketType();
        }

        public final boolean component4() {
            return getIsUsed();
        }

        /* renamed from: component5  reason: from getter */
        public final long getActivateDate() {
            return this.activateDate;
        }

        /* renamed from: component6  reason: from getter */
        public final String getAmount() {
            return this.amount;
        }

        /* renamed from: component7  reason: from getter */
        public final String getShortDescription() {
            return this.shortDescription;
        }

        /* renamed from: component8  reason: from getter */
        public final String getTemplateId() {
            return this.templateId;
        }

        /* renamed from: component9  reason: from getter */
        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final VoucherCard copy(String pocketId, String pocketStatus, String pocketType, boolean isUsed, long activateDate, String amount, String shortDescription, String templateId, String uniqueId, String howTo, String userPocketStatus, String merchantId, String label, String subLabel, String iconUrl, String logoUrl, String backgroundUrl, boolean usable, boolean shareable, Long expirationDate, ShareableRpcInfoModel shareableRpcInfo, PocketAssetTimerConfigModel pocketAssetTimerConfigModel, String couponCode) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(amount, "");
            Intrinsics.checkNotNullParameter(shortDescription, "");
            Intrinsics.checkNotNullParameter(templateId, "");
            Intrinsics.checkNotNullParameter(uniqueId, "");
            Intrinsics.checkNotNullParameter(howTo, "");
            Intrinsics.checkNotNullParameter(userPocketStatus, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(label, "");
            Intrinsics.checkNotNullParameter(subLabel, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(couponCode, "");
            return new VoucherCard(pocketId, pocketStatus, pocketType, isUsed, activateDate, amount, shortDescription, templateId, uniqueId, howTo, userPocketStatus, merchantId, label, subLabel, iconUrl, logoUrl, backgroundUrl, usable, shareable, expirationDate, shareableRpcInfo, pocketAssetTimerConfigModel, couponCode);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof VoucherCard) {
                VoucherCard voucherCard = (VoucherCard) other;
                return Intrinsics.areEqual(getPocketId(), voucherCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), voucherCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), voucherCard.getPocketType()) && getIsUsed() == voucherCard.getIsUsed() && this.activateDate == voucherCard.activateDate && Intrinsics.areEqual(this.amount, voucherCard.amount) && Intrinsics.areEqual(this.shortDescription, voucherCard.shortDescription) && Intrinsics.areEqual(this.templateId, voucherCard.templateId) && Intrinsics.areEqual(this.uniqueId, voucherCard.uniqueId) && Intrinsics.areEqual(this.howTo, voucherCard.howTo) && Intrinsics.areEqual(this.userPocketStatus, voucherCard.userPocketStatus) && Intrinsics.areEqual(this.merchantId, voucherCard.merchantId) && Intrinsics.areEqual(this.label, voucherCard.label) && Intrinsics.areEqual(this.subLabel, voucherCard.subLabel) && Intrinsics.areEqual(this.iconUrl, voucherCard.iconUrl) && Intrinsics.areEqual(this.logoUrl, voucherCard.logoUrl) && Intrinsics.areEqual(this.backgroundUrl, voucherCard.backgroundUrl) && this.usable == voucherCard.usable && this.shareable == voucherCard.shareable && Intrinsics.areEqual(this.expirationDate, voucherCard.expirationDate) && Intrinsics.areEqual(this.shareableRpcInfo, voucherCard.shareableRpcInfo) && Intrinsics.areEqual(this.pocketAssetTimerConfigModel, voucherCard.pocketAssetTimerConfigModel) && Intrinsics.areEqual(this.couponCode, voucherCard.couponCode);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            boolean isUsed = getIsUsed();
            int i = isUsed;
            if (isUsed) {
                i = 1;
            }
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.activateDate);
            int hashCode4 = this.amount.hashCode();
            int hashCode5 = this.shortDescription.hashCode();
            int hashCode6 = this.templateId.hashCode();
            int hashCode7 = this.uniqueId.hashCode();
            int hashCode8 = this.howTo.hashCode();
            int hashCode9 = this.userPocketStatus.hashCode();
            int hashCode10 = this.merchantId.hashCode();
            int hashCode11 = this.label.hashCode();
            int hashCode12 = this.subLabel.hashCode();
            int hashCode13 = this.iconUrl.hashCode();
            int hashCode14 = this.logoUrl.hashCode();
            int hashCode15 = this.backgroundUrl.hashCode();
            boolean z = this.usable;
            int i2 = z ? 1 : z ? 1 : 0;
            boolean z2 = this.shareable;
            int i3 = !z2 ? z2 ? 1 : 0 : 1;
            Long l = this.expirationDate;
            int hashCode16 = l == null ? 0 : l.hashCode();
            ShareableRpcInfoModel shareableRpcInfoModel = this.shareableRpcInfo;
            int hashCode17 = shareableRpcInfoModel == null ? 0 : shareableRpcInfoModel.hashCode();
            PocketAssetTimerConfigModel pocketAssetTimerConfigModel = this.pocketAssetTimerConfigModel;
            return (((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + m) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i2) * 31) + i3) * 31) + hashCode16) * 31) + hashCode17) * 31) + (pocketAssetTimerConfigModel != null ? pocketAssetTimerConfigModel.hashCode() : 0)) * 31) + this.couponCode.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VoucherCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", isUsed=");
            sb.append(getIsUsed());
            sb.append(", activateDate=");
            sb.append(this.activateDate);
            sb.append(", amount=");
            sb.append(this.amount);
            sb.append(", shortDescription=");
            sb.append(this.shortDescription);
            sb.append(", templateId=");
            sb.append(this.templateId);
            sb.append(", uniqueId=");
            sb.append(this.uniqueId);
            sb.append(", howTo=");
            sb.append(this.howTo);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", label=");
            sb.append(this.label);
            sb.append(", subLabel=");
            sb.append(this.subLabel);
            sb.append(", iconUrl=");
            sb.append(this.iconUrl);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", backgroundUrl=");
            sb.append(this.backgroundUrl);
            sb.append(", usable=");
            sb.append(this.usable);
            sb.append(", shareable=");
            sb.append(this.shareable);
            sb.append(", expirationDate=");
            sb.append(this.expirationDate);
            sb.append(", shareableRpcInfo=");
            sb.append(this.shareableRpcInfo);
            sb.append(", pocketAssetTimerConfigModel=");
            sb.append(this.pocketAssetTimerConfigModel);
            sb.append(", couponCode=");
            sb.append(this.couponCode);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.isUsed ? 1 : 0);
            parcel.writeLong(this.activateDate);
            parcel.writeString(this.amount);
            parcel.writeString(this.shortDescription);
            parcel.writeString(this.templateId);
            parcel.writeString(this.uniqueId);
            parcel.writeString(this.howTo);
            parcel.writeString(this.userPocketStatus);
            parcel.writeString(this.merchantId);
            parcel.writeString(this.label);
            parcel.writeString(this.subLabel);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.backgroundUrl);
            parcel.writeInt(this.usable ? 1 : 0);
            parcel.writeInt(this.shareable ? 1 : 0);
            Long l = this.expirationDate;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
            ShareableRpcInfoModel shareableRpcInfoModel = this.shareableRpcInfo;
            if (shareableRpcInfoModel == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                shareableRpcInfoModel.writeToParcel(parcel, flags);
            }
            PocketAssetTimerConfigModel pocketAssetTimerConfigModel = this.pocketAssetTimerConfigModel;
            if (pocketAssetTimerConfigModel == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                pocketAssetTimerConfigModel.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.couponCode);
        }

        public /* synthetic */ VoucherCard(String str, String str2, String str3, boolean z, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z2, boolean z3, Long l, ShareableRpcInfoModel shareableRpcInfoModel, PocketAssetTimerConfigModel pocketAssetTimerConfigModel, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? -1L : j, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? "" : str12, (i & 16384) != 0 ? "" : str13, (32768 & i) != 0 ? "" : str14, (65536 & i) != 0 ? "" : str15, (131072 & i) != 0 ? false : z2, (262144 & i) != 0 ? false : z3, (524288 & i) != 0 ? null : l, (1048576 & i) != 0 ? null : shareableRpcInfoModel, (2097152 & i) != 0 ? null : pocketAssetTimerConfigModel, (i & 4194304) != 0 ? "" : str16);
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "isUsed")
        /* renamed from: isUsed  reason: from getter */
        public final boolean getIsUsed() {
            return this.isUsed;
        }

        @JvmName(name = "getActivateDate")
        public final long getActivateDate() {
            return this.activateDate;
        }

        @JvmName(name = "setActivateDate")
        public final void setActivateDate(long j) {
            this.activateDate = j;
        }

        @JvmName(name = "getAmount")
        public final String getAmount() {
            return this.amount;
        }

        @JvmName(name = "setAmount")
        public final void setAmount(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.amount = str;
        }

        @JvmName(name = "getShortDescription")
        public final String getShortDescription() {
            return this.shortDescription;
        }

        @JvmName(name = "setShortDescription")
        public final void setShortDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.shortDescription = str;
        }

        @JvmName(name = "getTemplateId")
        public final String getTemplateId() {
            return this.templateId;
        }

        @JvmName(name = "setTemplateId")
        public final void setTemplateId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.templateId = str;
        }

        @JvmName(name = "getUniqueId")
        public final String getUniqueId() {
            return this.uniqueId;
        }

        @JvmName(name = "setUniqueId")
        public final void setUniqueId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.uniqueId = str;
        }

        @JvmName(name = "getHowTo")
        public final String getHowTo() {
            return this.howTo;
        }

        @JvmName(name = "setHowTo")
        public final void setHowTo(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.howTo = str;
        }

        @JvmName(name = "getUserPocketStatus")
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        @JvmName(name = "setUserPocketStatus")
        public final void setUserPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userPocketStatus = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantId = str;
        }

        @JvmName(name = "getLabel")
        public final String getLabel() {
            return this.label;
        }

        @JvmName(name = "setLabel")
        public final void setLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.label = str;
        }

        @JvmName(name = "getSubLabel")
        public final String getSubLabel() {
            return this.subLabel;
        }

        @JvmName(name = "setSubLabel")
        public final void setSubLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.subLabel = str;
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

        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @JvmName(name = "getUsable")
        public final boolean getUsable() {
            return this.usable;
        }

        @JvmName(name = "setUsable")
        public final void setUsable(boolean z) {
            this.usable = z;
        }

        @JvmName(name = "getShareable")
        public final boolean getShareable() {
            return this.shareable;
        }

        @JvmName(name = "setShareable")
        public final void setShareable(boolean z) {
            this.shareable = z;
        }

        @JvmName(name = "getExpirationDate")
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        @JvmName(name = "setExpirationDate")
        public final void setExpirationDate(Long l) {
            this.expirationDate = l;
        }

        @JvmName(name = "getShareableRpcInfo")
        public final ShareableRpcInfoModel getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        @JvmName(name = "setShareableRpcInfo")
        public final void setShareableRpcInfo(ShareableRpcInfoModel shareableRpcInfoModel) {
            this.shareableRpcInfo = shareableRpcInfoModel;
        }

        @JvmName(name = "getPocketAssetTimerConfigModel")
        public final PocketAssetTimerConfigModel getPocketAssetTimerConfigModel() {
            return this.pocketAssetTimerConfigModel;
        }

        @JvmName(name = "setPocketAssetTimerConfigModel")
        public final void setPocketAssetTimerConfigModel(PocketAssetTimerConfigModel pocketAssetTimerConfigModel) {
            this.pocketAssetTimerConfigModel = pocketAssetTimerConfigModel;
        }

        @JvmName(name = "getCouponCode")
        public final String getCouponCode() {
            return this.couponCode;
        }

        @JvmName(name = "setCouponCode")
        public final void setCouponCode(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.couponCode = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VoucherCard(String str, String str2, String str3, boolean z, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z2, boolean z3, Long l, ShareableRpcInfoModel shareableRpcInfoModel, PocketAssetTimerConfigModel pocketAssetTimerConfigModel, String str16) {
            super(str, str2, str3, z, 8, null);
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
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.isUsed = z;
            this.activateDate = j;
            this.amount = str4;
            this.shortDescription = str5;
            this.templateId = str6;
            this.uniqueId = str7;
            this.howTo = str8;
            this.userPocketStatus = str9;
            this.merchantId = str10;
            this.label = str11;
            this.subLabel = str12;
            this.iconUrl = str13;
            this.logoUrl = str14;
            this.backgroundUrl = str15;
            this.usable = z2;
            this.shareable = z3;
            this.expirationDate = l;
            this.shareableRpcInfo = shareableRpcInfoModel;
            this.pocketAssetTimerConfigModel = pocketAssetTimerConfigModel;
            this.couponCode = str16;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bu\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÃ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003¢\u0006\u0002\u0010'J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0007HÆ\u0003J\t\u0010y\u001a\u00020\u0007HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010|\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010~\u001a\u00020\u0003HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003JÖ\u0002\u0010\u008f\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010\u0090\u0001J\u000b\u0010\u0091\u0001\u001a\u00030\u0092\u0001HÖ\u0001J\u0016\u0010\u0093\u0001\u001a\u00020\u00072\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001HÖ\u0003J\u000b\u0010\u0096\u0001\u001a\u00030\u0092\u0001HÖ\u0001J\n\u0010\u0097\u0001\u001a\u00020\u0003HÖ\u0001J\u001f\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u0092\u0001HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u0010!\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R\u001a\u0010&\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u0010/R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010-\"\u0004\bD\u0010/R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010-\"\u0004\bF\u0010/R\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010G\"\u0004\bH\u0010IR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010GR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010-\"\u0004\bK\u0010/R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010-\"\u0004\bM\u0010/R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010-\"\u0004\bO\u0010/R\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010-\"\u0004\bQ\u0010/R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010-R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010-R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010-R\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010-\"\u0004\bZ\u0010/R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010G\"\u0004\b^\u0010IR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010-\"\u0004\bd\u0010/R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010-\"\u0004\bf\u0010/R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010-\"\u0004\bh\u0010/R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010-\"\u0004\bj\u0010/R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010G\"\u0004\bl\u0010IR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010-\"\u0004\bn\u0010/¨\u0006\u009d\u0001"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$DealsCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "pocketId", "", "pocketStatus", "pocketType", "isUsed", "", "activateDate", "", "amount", "shortDescription", "templateId", "uniqueId", "howTo", "userPocketStatus", "merchantId", Constants.ScionAnalytics.PARAM_LABEL, "subLabel", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, "backgroundUrl", "usable", "shareable", "expirationDate", "shareableRpcInfo", "Lid/dana/wallet_v3/model/ShareableRpcInfoModel;", "pocketAssetTimerConfigModel", "Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;", "couponCode", "backgroundColor", "fontColor", "minTransaction", "categoryIconUrl", "bizType", "isOnlineMerchant", "redemptionType", "providerCategory", "discountRate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Lid/dana/wallet_v3/model/ShareableRpcInfoModel;Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivateDate", "()J", "setActivateDate", "(J)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getBackgroundColor", "setBackgroundColor", "getBackgroundUrl", "setBackgroundUrl", "getBizType", "setBizType", "getCategoryIconUrl", "setCategoryIconUrl", "getCouponCode", "setCouponCode", "getDiscountRate", "setDiscountRate", "getExpirationDate", "()Ljava/lang/Long;", "setExpirationDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFontColor", "setFontColor", "getHowTo", "setHowTo", "getIconUrl", "setIconUrl", "()Z", "setOnlineMerchant", "(Z)V", "getLabel", "setLabel", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "getMinTransaction", "setMinTransaction", "getPocketAssetTimerConfigModel", "()Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;", "setPocketAssetTimerConfigModel", "(Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;)V", "getPocketId", "getPocketStatus", "getPocketType", "getProviderCategory", "setProviderCategory", "getRedemptionType", "setRedemptionType", "getShareable", "setShareable", "getShareableRpcInfo", "()Lid/dana/wallet_v3/model/ShareableRpcInfoModel;", "setShareableRpcInfo", "(Lid/dana/wallet_v3/model/ShareableRpcInfoModel;)V", "getShortDescription", "setShortDescription", "getSubLabel", "setSubLabel", "getTemplateId", "setTemplateId", "getUniqueId", "setUniqueId", "getUsable", "setUsable", "getUserPocketStatus", "setUserPocketStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Lid/dana/wallet_v3/model/ShareableRpcInfoModel;Lid/dana/wallet_v3/model/PocketAssetTimerConfigModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$DealsCard;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DealsCard extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<DealsCard> CREATOR = new Creator();
        private long activateDate;
        private String amount;
        private String backgroundColor;
        private String backgroundUrl;
        private String bizType;
        private String categoryIconUrl;
        private String couponCode;
        private String discountRate;
        private Long expirationDate;
        private String fontColor;
        private String howTo;
        private String iconUrl;
        private boolean isOnlineMerchant;
        private final boolean isUsed;
        private String label;
        private String logoUrl;
        private String merchantId;
        private String minTransaction;
        private PocketAssetTimerConfigModel pocketAssetTimerConfigModel;
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private String providerCategory;
        private String redemptionType;
        private boolean shareable;
        private ShareableRpcInfoModel shareableRpcInfo;
        private String shortDescription;
        private String subLabel;
        private String templateId;
        private String uniqueId;
        private boolean usable;
        private String userPocketStatus;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DealsCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DealsCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new DealsCard(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : ShareableRpcInfoModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? PocketAssetTimerConfigModel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DealsCard[] newArray(int i) {
                return new DealsCard[i];
            }
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getHowTo() {
            return this.howTo;
        }

        /* renamed from: component11  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        /* renamed from: component12  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component13  reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component14  reason: from getter */
        public final String getSubLabel() {
            return this.subLabel;
        }

        /* renamed from: component15  reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: component16  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component17  reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        /* renamed from: component18  reason: from getter */
        public final boolean getUsable() {
            return this.usable;
        }

        /* renamed from: component19  reason: from getter */
        public final boolean getShareable() {
            return this.shareable;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        /* renamed from: component21  reason: from getter */
        public final ShareableRpcInfoModel getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        /* renamed from: component22  reason: from getter */
        public final PocketAssetTimerConfigModel getPocketAssetTimerConfigModel() {
            return this.pocketAssetTimerConfigModel;
        }

        /* renamed from: component23  reason: from getter */
        public final String getCouponCode() {
            return this.couponCode;
        }

        /* renamed from: component24  reason: from getter */
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        /* renamed from: component25  reason: from getter */
        public final String getFontColor() {
            return this.fontColor;
        }

        /* renamed from: component26  reason: from getter */
        public final String getMinTransaction() {
            return this.minTransaction;
        }

        /* renamed from: component27  reason: from getter */
        public final String getCategoryIconUrl() {
            return this.categoryIconUrl;
        }

        /* renamed from: component28  reason: from getter */
        public final String getBizType() {
            return this.bizType;
        }

        /* renamed from: component29  reason: from getter */
        public final boolean getIsOnlineMerchant() {
            return this.isOnlineMerchant;
        }

        public final String component3() {
            return getPocketType();
        }

        /* renamed from: component30  reason: from getter */
        public final String getRedemptionType() {
            return this.redemptionType;
        }

        /* renamed from: component31  reason: from getter */
        public final String getProviderCategory() {
            return this.providerCategory;
        }

        /* renamed from: component32  reason: from getter */
        public final String getDiscountRate() {
            return this.discountRate;
        }

        public final boolean component4() {
            return getIsUsed();
        }

        /* renamed from: component5  reason: from getter */
        public final long getActivateDate() {
            return this.activateDate;
        }

        /* renamed from: component6  reason: from getter */
        public final String getAmount() {
            return this.amount;
        }

        /* renamed from: component7  reason: from getter */
        public final String getShortDescription() {
            return this.shortDescription;
        }

        /* renamed from: component8  reason: from getter */
        public final String getTemplateId() {
            return this.templateId;
        }

        /* renamed from: component9  reason: from getter */
        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final DealsCard copy(String pocketId, String pocketStatus, String pocketType, boolean isUsed, long activateDate, String amount, String shortDescription, String templateId, String uniqueId, String howTo, String userPocketStatus, String merchantId, String label, String subLabel, String iconUrl, String logoUrl, String backgroundUrl, boolean usable, boolean shareable, Long expirationDate, ShareableRpcInfoModel shareableRpcInfo, PocketAssetTimerConfigModel pocketAssetTimerConfigModel, String couponCode, String backgroundColor, String fontColor, String minTransaction, String categoryIconUrl, String bizType, boolean isOnlineMerchant, String redemptionType, String providerCategory, String discountRate) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(amount, "");
            Intrinsics.checkNotNullParameter(shortDescription, "");
            Intrinsics.checkNotNullParameter(templateId, "");
            Intrinsics.checkNotNullParameter(uniqueId, "");
            Intrinsics.checkNotNullParameter(howTo, "");
            Intrinsics.checkNotNullParameter(userPocketStatus, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(label, "");
            Intrinsics.checkNotNullParameter(subLabel, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(couponCode, "");
            Intrinsics.checkNotNullParameter(backgroundColor, "");
            Intrinsics.checkNotNullParameter(fontColor, "");
            Intrinsics.checkNotNullParameter(minTransaction, "");
            Intrinsics.checkNotNullParameter(categoryIconUrl, "");
            Intrinsics.checkNotNullParameter(bizType, "");
            Intrinsics.checkNotNullParameter(redemptionType, "");
            Intrinsics.checkNotNullParameter(providerCategory, "");
            Intrinsics.checkNotNullParameter(discountRate, "");
            return new DealsCard(pocketId, pocketStatus, pocketType, isUsed, activateDate, amount, shortDescription, templateId, uniqueId, howTo, userPocketStatus, merchantId, label, subLabel, iconUrl, logoUrl, backgroundUrl, usable, shareable, expirationDate, shareableRpcInfo, pocketAssetTimerConfigModel, couponCode, backgroundColor, fontColor, minTransaction, categoryIconUrl, bizType, isOnlineMerchant, redemptionType, providerCategory, discountRate);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DealsCard) {
                DealsCard dealsCard = (DealsCard) other;
                return Intrinsics.areEqual(getPocketId(), dealsCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), dealsCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), dealsCard.getPocketType()) && getIsUsed() == dealsCard.getIsUsed() && this.activateDate == dealsCard.activateDate && Intrinsics.areEqual(this.amount, dealsCard.amount) && Intrinsics.areEqual(this.shortDescription, dealsCard.shortDescription) && Intrinsics.areEqual(this.templateId, dealsCard.templateId) && Intrinsics.areEqual(this.uniqueId, dealsCard.uniqueId) && Intrinsics.areEqual(this.howTo, dealsCard.howTo) && Intrinsics.areEqual(this.userPocketStatus, dealsCard.userPocketStatus) && Intrinsics.areEqual(this.merchantId, dealsCard.merchantId) && Intrinsics.areEqual(this.label, dealsCard.label) && Intrinsics.areEqual(this.subLabel, dealsCard.subLabel) && Intrinsics.areEqual(this.iconUrl, dealsCard.iconUrl) && Intrinsics.areEqual(this.logoUrl, dealsCard.logoUrl) && Intrinsics.areEqual(this.backgroundUrl, dealsCard.backgroundUrl) && this.usable == dealsCard.usable && this.shareable == dealsCard.shareable && Intrinsics.areEqual(this.expirationDate, dealsCard.expirationDate) && Intrinsics.areEqual(this.shareableRpcInfo, dealsCard.shareableRpcInfo) && Intrinsics.areEqual(this.pocketAssetTimerConfigModel, dealsCard.pocketAssetTimerConfigModel) && Intrinsics.areEqual(this.couponCode, dealsCard.couponCode) && Intrinsics.areEqual(this.backgroundColor, dealsCard.backgroundColor) && Intrinsics.areEqual(this.fontColor, dealsCard.fontColor) && Intrinsics.areEqual(this.minTransaction, dealsCard.minTransaction) && Intrinsics.areEqual(this.categoryIconUrl, dealsCard.categoryIconUrl) && Intrinsics.areEqual(this.bizType, dealsCard.bizType) && this.isOnlineMerchant == dealsCard.isOnlineMerchant && Intrinsics.areEqual(this.redemptionType, dealsCard.redemptionType) && Intrinsics.areEqual(this.providerCategory, dealsCard.providerCategory) && Intrinsics.areEqual(this.discountRate, dealsCard.discountRate);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            boolean isUsed = getIsUsed();
            int i = isUsed;
            if (isUsed) {
                i = 1;
            }
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.activateDate);
            int hashCode4 = this.amount.hashCode();
            int hashCode5 = this.shortDescription.hashCode();
            int hashCode6 = this.templateId.hashCode();
            int hashCode7 = this.uniqueId.hashCode();
            int hashCode8 = this.howTo.hashCode();
            int hashCode9 = this.userPocketStatus.hashCode();
            int hashCode10 = this.merchantId.hashCode();
            int hashCode11 = this.label.hashCode();
            int hashCode12 = this.subLabel.hashCode();
            int hashCode13 = this.iconUrl.hashCode();
            int hashCode14 = this.logoUrl.hashCode();
            int hashCode15 = this.backgroundUrl.hashCode();
            boolean z = this.usable;
            int i2 = z ? 1 : z ? 1 : 0;
            boolean z2 = this.shareable;
            int i3 = z2 ? 1 : z2 ? 1 : 0;
            Long l = this.expirationDate;
            int hashCode16 = l == null ? 0 : l.hashCode();
            ShareableRpcInfoModel shareableRpcInfoModel = this.shareableRpcInfo;
            int hashCode17 = shareableRpcInfoModel == null ? 0 : shareableRpcInfoModel.hashCode();
            PocketAssetTimerConfigModel pocketAssetTimerConfigModel = this.pocketAssetTimerConfigModel;
            int hashCode18 = pocketAssetTimerConfigModel != null ? pocketAssetTimerConfigModel.hashCode() : 0;
            int hashCode19 = this.couponCode.hashCode();
            int hashCode20 = this.backgroundColor.hashCode();
            int hashCode21 = this.fontColor.hashCode();
            int hashCode22 = this.minTransaction.hashCode();
            int hashCode23 = this.categoryIconUrl.hashCode();
            int hashCode24 = this.bizType.hashCode();
            boolean z3 = this.isOnlineMerchant;
            int i4 = z3;
            if (z3 != 0) {
                i4 = 1;
            }
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + m) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i2) * 31) + i3) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + i4) * 31) + this.redemptionType.hashCode()) * 31) + this.providerCategory.hashCode()) * 31) + this.discountRate.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DealsCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", isUsed=");
            sb.append(getIsUsed());
            sb.append(", activateDate=");
            sb.append(this.activateDate);
            sb.append(", amount=");
            sb.append(this.amount);
            sb.append(", shortDescription=");
            sb.append(this.shortDescription);
            sb.append(", templateId=");
            sb.append(this.templateId);
            sb.append(", uniqueId=");
            sb.append(this.uniqueId);
            sb.append(", howTo=");
            sb.append(this.howTo);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", label=");
            sb.append(this.label);
            sb.append(", subLabel=");
            sb.append(this.subLabel);
            sb.append(", iconUrl=");
            sb.append(this.iconUrl);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", backgroundUrl=");
            sb.append(this.backgroundUrl);
            sb.append(", usable=");
            sb.append(this.usable);
            sb.append(", shareable=");
            sb.append(this.shareable);
            sb.append(", expirationDate=");
            sb.append(this.expirationDate);
            sb.append(", shareableRpcInfo=");
            sb.append(this.shareableRpcInfo);
            sb.append(", pocketAssetTimerConfigModel=");
            sb.append(this.pocketAssetTimerConfigModel);
            sb.append(", couponCode=");
            sb.append(this.couponCode);
            sb.append(", backgroundColor=");
            sb.append(this.backgroundColor);
            sb.append(", fontColor=");
            sb.append(this.fontColor);
            sb.append(", minTransaction=");
            sb.append(this.minTransaction);
            sb.append(", categoryIconUrl=");
            sb.append(this.categoryIconUrl);
            sb.append(", bizType=");
            sb.append(this.bizType);
            sb.append(", isOnlineMerchant=");
            sb.append(this.isOnlineMerchant);
            sb.append(", redemptionType=");
            sb.append(this.redemptionType);
            sb.append(", providerCategory=");
            sb.append(this.providerCategory);
            sb.append(", discountRate=");
            sb.append(this.discountRate);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.isUsed ? 1 : 0);
            parcel.writeLong(this.activateDate);
            parcel.writeString(this.amount);
            parcel.writeString(this.shortDescription);
            parcel.writeString(this.templateId);
            parcel.writeString(this.uniqueId);
            parcel.writeString(this.howTo);
            parcel.writeString(this.userPocketStatus);
            parcel.writeString(this.merchantId);
            parcel.writeString(this.label);
            parcel.writeString(this.subLabel);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.backgroundUrl);
            parcel.writeInt(this.usable ? 1 : 0);
            parcel.writeInt(this.shareable ? 1 : 0);
            Long l = this.expirationDate;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
            ShareableRpcInfoModel shareableRpcInfoModel = this.shareableRpcInfo;
            if (shareableRpcInfoModel == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                shareableRpcInfoModel.writeToParcel(parcel, flags);
            }
            PocketAssetTimerConfigModel pocketAssetTimerConfigModel = this.pocketAssetTimerConfigModel;
            if (pocketAssetTimerConfigModel == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                pocketAssetTimerConfigModel.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.couponCode);
            parcel.writeString(this.backgroundColor);
            parcel.writeString(this.fontColor);
            parcel.writeString(this.minTransaction);
            parcel.writeString(this.categoryIconUrl);
            parcel.writeString(this.bizType);
            parcel.writeInt(this.isOnlineMerchant ? 1 : 0);
            parcel.writeString(this.redemptionType);
            parcel.writeString(this.providerCategory);
            parcel.writeString(this.discountRate);
        }

        public /* synthetic */ DealsCard(String str, String str2, String str3, boolean z, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z2, boolean z3, Long l, ShareableRpcInfoModel shareableRpcInfoModel, PocketAssetTimerConfigModel pocketAssetTimerConfigModel, String str16, String str17, String str18, String str19, String str20, String str21, boolean z4, String str22, String str23, String str24, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? -1L : j, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? "" : str12, (i & 16384) != 0 ? "" : str13, (32768 & i) != 0 ? "" : str14, (65536 & i) != 0 ? "" : str15, (131072 & i) != 0 ? false : z2, (262144 & i) != 0 ? false : z3, (524288 & i) != 0 ? null : l, (1048576 & i) != 0 ? null : shareableRpcInfoModel, (2097152 & i) != 0 ? null : pocketAssetTimerConfigModel, (4194304 & i) != 0 ? "" : str16, (8388608 & i) != 0 ? "" : str17, (16777216 & i) != 0 ? "" : str18, (33554432 & i) != 0 ? "" : str19, (67108864 & i) != 0 ? "" : str20, (134217728 & i) != 0 ? "" : str21, (268435456 & i) != 0 ? false : z4, (536870912 & i) != 0 ? "" : str22, (1073741824 & i) != 0 ? "" : str23, (i & Integer.MIN_VALUE) != 0 ? "" : str24);
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        /* renamed from: isUsed  reason: from getter */
        public final boolean getIsUsed() {
            return this.isUsed;
        }

        public final long getActivateDate() {
            return this.activateDate;
        }

        public final void setActivateDate(long j) {
            this.activateDate = j;
        }

        public final String getAmount() {
            return this.amount;
        }

        public final void setAmount(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.amount = str;
        }

        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final void setShortDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.shortDescription = str;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final void setTemplateId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.templateId = str;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final void setUniqueId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.uniqueId = str;
        }

        public final String getHowTo() {
            return this.howTo;
        }

        public final void setHowTo(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.howTo = str;
        }

        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        public final void setUserPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userPocketStatus = str;
        }

        public final String getMerchantId() {
            return this.merchantId;
        }

        public final void setMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantId = str;
        }

        public final String getLabel() {
            return this.label;
        }

        public final void setLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.label = str;
        }

        public final String getSubLabel() {
            return this.subLabel;
        }

        public final void setSubLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.subLabel = str;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        public final String getLogoUrl() {
            return this.logoUrl;
        }

        public final void setLogoUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.logoUrl = str;
        }

        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        public final boolean getUsable() {
            return this.usable;
        }

        public final void setUsable(boolean z) {
            this.usable = z;
        }

        public final boolean getShareable() {
            return this.shareable;
        }

        public final void setShareable(boolean z) {
            this.shareable = z;
        }

        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        public final void setExpirationDate(Long l) {
            this.expirationDate = l;
        }

        public final ShareableRpcInfoModel getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        public final void setShareableRpcInfo(ShareableRpcInfoModel shareableRpcInfoModel) {
            this.shareableRpcInfo = shareableRpcInfoModel;
        }

        public final PocketAssetTimerConfigModel getPocketAssetTimerConfigModel() {
            return this.pocketAssetTimerConfigModel;
        }

        public final void setPocketAssetTimerConfigModel(PocketAssetTimerConfigModel pocketAssetTimerConfigModel) {
            this.pocketAssetTimerConfigModel = pocketAssetTimerConfigModel;
        }

        public final String getCouponCode() {
            return this.couponCode;
        }

        public final void setCouponCode(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.couponCode = str;
        }

        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        public final void setBackgroundColor(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundColor = str;
        }

        public final String getFontColor() {
            return this.fontColor;
        }

        public final void setFontColor(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.fontColor = str;
        }

        public final String getMinTransaction() {
            return this.minTransaction;
        }

        public final void setMinTransaction(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.minTransaction = str;
        }

        public final String getCategoryIconUrl() {
            return this.categoryIconUrl;
        }

        public final void setCategoryIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.categoryIconUrl = str;
        }

        public final String getBizType() {
            return this.bizType;
        }

        public final void setBizType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.bizType = str;
        }

        public final boolean isOnlineMerchant() {
            return this.isOnlineMerchant;
        }

        public final void setOnlineMerchant(boolean z) {
            this.isOnlineMerchant = z;
        }

        public final String getRedemptionType() {
            return this.redemptionType;
        }

        public final void setRedemptionType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.redemptionType = str;
        }

        public final String getProviderCategory() {
            return this.providerCategory;
        }

        public final void setProviderCategory(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.providerCategory = str;
        }

        public final String getDiscountRate() {
            return this.discountRate;
        }

        public final void setDiscountRate(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.discountRate = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DealsCard(String str, String str2, String str3, boolean z, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z2, boolean z3, Long l, ShareableRpcInfoModel shareableRpcInfoModel, PocketAssetTimerConfigModel pocketAssetTimerConfigModel, String str16, String str17, String str18, String str19, String str20, String str21, boolean z4, String str22, String str23, String str24) {
            super(str, str2, str3, z, 19, null);
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
            Intrinsics.checkNotNullParameter(str22, "");
            Intrinsics.checkNotNullParameter(str23, "");
            Intrinsics.checkNotNullParameter(str24, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.isUsed = z;
            this.activateDate = j;
            this.amount = str4;
            this.shortDescription = str5;
            this.templateId = str6;
            this.uniqueId = str7;
            this.howTo = str8;
            this.userPocketStatus = str9;
            this.merchantId = str10;
            this.label = str11;
            this.subLabel = str12;
            this.iconUrl = str13;
            this.logoUrl = str14;
            this.backgroundUrl = str15;
            this.usable = z2;
            this.shareable = z3;
            this.expirationDate = l;
            this.shareableRpcInfo = shareableRpcInfoModel;
            this.pocketAssetTimerConfigModel = pocketAssetTimerConfigModel;
            this.couponCode = str16;
            this.backgroundColor = str17;
            this.fontColor = str18;
            this.minTransaction = str19;
            this.categoryIconUrl = str20;
            this.bizType = str21;
            this.isOnlineMerchant = z4;
            this.redemptionType = str22;
            this.providerCategory = str23;
            this.discountRate = str24;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\bI\u0010JJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0092\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b)\u0010$J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004J \u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b/\u00100R\"\u0010\u001e\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u00104R\"\u0010\u001d\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00101\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u00104R\u001a\u0010\u0017\u001a\u00020\f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\b\u0017\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u0010;R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00108\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010;R\u001a\u0010\u0014\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u00108\u001a\u0004\b>\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u00108\u001a\u0004\b?\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\b@\u0010\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00108\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u0010;R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00108\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u0010;R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00108\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010;R\"\u0010\u001f\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00101\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u00104"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$ParkingTicketCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "", "component10", "()J", "component11", "component12", "component2", "component3", "", "component4", "()Z", "component5", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "pocketType", "isUsed", "ticketId", "ticketName", "location", "issuerName", "qrUrl", "enterTime", "duration", "total", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$ParkingTicketCard;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", LottieConstants.METHOD_GET_DURATION, "setDuration", "(J)V", "getEnterTime", "setEnterTime", "Z", "Ljava/lang/String;", "getIssuerName", "setIssuerName", "(Ljava/lang/String;)V", "getLocation", "setLocation", "getPocketId", "getPocketStatus", "getPocketType", "getQrUrl", "setQrUrl", "getTicketId", "setTicketId", "getTicketName", "setTicketName", "getTotal", "setTotal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ParkingTicketCard extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<ParkingTicketCard> CREATOR = new Creator();
        private long duration;
        private long enterTime;
        private final boolean isUsed;
        private String issuerName;
        private String location;
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private String qrUrl;
        private String ticketId;
        private String ticketName;
        private long total;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<ParkingTicketCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ParkingTicketCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new ParkingTicketCard(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ParkingTicketCard[] newArray(int i) {
                return new ParkingTicketCard[i];
            }
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final long getEnterTime() {
            return this.enterTime;
        }

        /* renamed from: component11  reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component12  reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        public final String component2() {
            return getPocketStatus();
        }

        public final String component3() {
            return getPocketType();
        }

        public final boolean component4() {
            return getIsUsed();
        }

        /* renamed from: component5  reason: from getter */
        public final String getTicketId() {
            return this.ticketId;
        }

        /* renamed from: component6  reason: from getter */
        public final String getTicketName() {
            return this.ticketName;
        }

        /* renamed from: component7  reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        /* renamed from: component8  reason: from getter */
        public final String getIssuerName() {
            return this.issuerName;
        }

        /* renamed from: component9  reason: from getter */
        public final String getQrUrl() {
            return this.qrUrl;
        }

        public final ParkingTicketCard copy(String pocketId, String pocketStatus, String pocketType, boolean isUsed, String ticketId, String ticketName, String location, String issuerName, String qrUrl, long enterTime, long duration, long total) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            return new ParkingTicketCard(pocketId, pocketStatus, pocketType, isUsed, ticketId, ticketName, location, issuerName, qrUrl, enterTime, duration, total);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ParkingTicketCard) {
                ParkingTicketCard parkingTicketCard = (ParkingTicketCard) other;
                return Intrinsics.areEqual(getPocketId(), parkingTicketCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), parkingTicketCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), parkingTicketCard.getPocketType()) && getIsUsed() == parkingTicketCard.getIsUsed() && Intrinsics.areEqual(this.ticketId, parkingTicketCard.ticketId) && Intrinsics.areEqual(this.ticketName, parkingTicketCard.ticketName) && Intrinsics.areEqual(this.location, parkingTicketCard.location) && Intrinsics.areEqual(this.issuerName, parkingTicketCard.issuerName) && Intrinsics.areEqual(this.qrUrl, parkingTicketCard.qrUrl) && this.enterTime == parkingTicketCard.enterTime && this.duration == parkingTicketCard.duration && this.total == parkingTicketCard.total;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            boolean isUsed = getIsUsed();
            int i = isUsed;
            if (isUsed) {
                i = 1;
            }
            String str = this.ticketId;
            int hashCode4 = str == null ? 0 : str.hashCode();
            String str2 = this.ticketName;
            int hashCode5 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.location;
            int hashCode6 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.issuerName;
            int hashCode7 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.qrUrl;
            return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str5 != null ? str5.hashCode() : 0)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.enterTime)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.duration)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.total);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ParkingTicketCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", isUsed=");
            sb.append(getIsUsed());
            sb.append(", ticketId=");
            sb.append(this.ticketId);
            sb.append(", ticketName=");
            sb.append(this.ticketName);
            sb.append(", location=");
            sb.append(this.location);
            sb.append(", issuerName=");
            sb.append(this.issuerName);
            sb.append(", qrUrl=");
            sb.append(this.qrUrl);
            sb.append(", enterTime=");
            sb.append(this.enterTime);
            sb.append(", duration=");
            sb.append(this.duration);
            sb.append(", total=");
            sb.append(this.total);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.isUsed ? 1 : 0);
            parcel.writeString(this.ticketId);
            parcel.writeString(this.ticketName);
            parcel.writeString(this.location);
            parcel.writeString(this.issuerName);
            parcel.writeString(this.qrUrl);
            parcel.writeLong(this.enterTime);
            parcel.writeLong(this.duration);
            parcel.writeLong(this.total);
        }

        public /* synthetic */ ParkingTicketCard(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, long j, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? 0L : j, (i & 1024) != 0 ? 0L : j2, (i & 2048) != 0 ? 0L : j3);
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "isUsed")
        /* renamed from: isUsed  reason: from getter */
        public final boolean getIsUsed() {
            return this.isUsed;
        }

        @JvmName(name = "getTicketId")
        public final String getTicketId() {
            return this.ticketId;
        }

        @JvmName(name = "setTicketId")
        public final void setTicketId(String str) {
            this.ticketId = str;
        }

        @JvmName(name = "getTicketName")
        public final String getTicketName() {
            return this.ticketName;
        }

        @JvmName(name = "setTicketName")
        public final void setTicketName(String str) {
            this.ticketName = str;
        }

        @JvmName(name = "getLocation")
        public final String getLocation() {
            return this.location;
        }

        @JvmName(name = "setLocation")
        public final void setLocation(String str) {
            this.location = str;
        }

        @JvmName(name = "getIssuerName")
        public final String getIssuerName() {
            return this.issuerName;
        }

        @JvmName(name = "setIssuerName")
        public final void setIssuerName(String str) {
            this.issuerName = str;
        }

        @JvmName(name = "getQrUrl")
        public final String getQrUrl() {
            return this.qrUrl;
        }

        @JvmName(name = "setQrUrl")
        public final void setQrUrl(String str) {
            this.qrUrl = str;
        }

        @JvmName(name = "getEnterTime")
        public final long getEnterTime() {
            return this.enterTime;
        }

        @JvmName(name = "setEnterTime")
        public final void setEnterTime(long j) {
            this.enterTime = j;
        }

        @JvmName(name = LottieConstants.METHOD_GET_DURATION)
        public final long getDuration() {
            return this.duration;
        }

        @JvmName(name = "setDuration")
        public final void setDuration(long j) {
            this.duration = j;
        }

        @JvmName(name = "getTotal")
        public final long getTotal() {
            return this.total;
        }

        @JvmName(name = "setTotal")
        public final void setTotal(long j) {
            this.total = j;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParkingTicketCard(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, long j, long j2, long j3) {
            super(str, str2, str3, z, 10, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.isUsed = z;
            this.ticketId = str4;
            this.ticketName = str5;
            this.location = str6;
            this.issuerName = str7;
            this.qrUrl = str8;
            this.enterTime = j;
            this.duration = j2;
            this.total = j3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B»\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0019\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bk\u0010lJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004JÌ\u0002\u0010<\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00192\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010?\u001a\u00020>HÖ\u0001¢\u0006\u0004\b?\u0010@J\u001a\u0010C\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010AHÖ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020>HÖ\u0001¢\u0006\u0004\bE\u0010@J\u0010\u0010F\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bF\u0010\u0004J \u0010K\u001a\u00020J2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020>HÖ\u0001¢\u0006\u0004\bK\u0010LR\u0019\u0010)\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b)\u0010M\u001a\u0004\bN\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010M\u001a\u0004\bO\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010M\u001a\u0004\bP\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010M\u001a\u0004\bQ\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010M\u001a\u0004\bR\u0010\u0004R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010M\u001a\u0004\bS\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010M\u001a\u0004\bT\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010M\u001a\u0004\bU\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010M\u001a\u0004\bV\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010M\u001a\u0004\bW\u0010\u0004R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010M\u001a\u0004\bX\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010M\u001a\u0004\bY\u0010\u0004R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010M\u001a\u0004\bZ\u0010\u0004R\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010M\u001a\u0004\b[\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010M\u001a\u0004\b\\\u0010\u0004R\u001a\u0010$\u001a\u00020\u00198\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010]\u001a\u0004\b$\u0010\u001bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010M\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010`R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010M\u001a\u0004\ba\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010M\u001a\u0004\bb\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b!\u0010M\u001a\u0004\bc\u0010\u0004R\u001a\u0010\"\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\"\u0010M\u001a\u0004\bd\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b#\u0010M\u001a\u0004\be\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010M\u001a\u0004\bf\u0010\u0004R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010M\u001a\u0004\bg\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010M\u001a\u0004\bh\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010M\u001a\u0004\bi\u0010\u0004R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010M\u001a\u0004\bj\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$TravelTicketCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "", "component4", "()Z", "component5", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "pocketType", "isUsed", "passengerName", "passengerType", "subPocketType", "departure", "arrival", "transportLogoUrl", "departureTime", "arrivalTime", "bookingCode", "transportName", "seatNumber", "departureCode", "arrivalCode", "departureAirport", "arrivalAirport", "departureTerminal", "arrivalTerminal", "primaryCTA", "hexCode", "backgroundUrl", "iconUrl", "gateNumber", DecodedScanBizInfoKey.LOGO_URL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$TravelTicketCard;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getArrival", "getArrivalAirport", "getArrivalCode", "getArrivalTerminal", "getArrivalTime", "getBackgroundUrl", "getBookingCode", "getDeparture", "getDepartureAirport", "getDepartureCode", "getDepartureTerminal", "getDepartureTime", "getGateNumber", "getHexCode", "getIconUrl", "Z", "getLogoUrl", "setLogoUrl", "(Ljava/lang/String;)V", "getPassengerName", "getPassengerType", "getPocketId", "getPocketStatus", "getPocketType", "getPrimaryCTA", "getSeatNumber", "getSubPocketType", "getTransportLogoUrl", "getTransportName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class TravelTicketCard extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<TravelTicketCard> CREATOR = new Creator();
        private final String arrival;
        private final String arrivalAirport;
        private final String arrivalCode;
        private final String arrivalTerminal;
        private final String arrivalTime;
        private final String backgroundUrl;
        private final String bookingCode;
        private final String departure;
        private final String departureAirport;
        private final String departureCode;
        private final String departureTerminal;
        private final String departureTime;
        private final String gateNumber;
        private final String hexCode;
        private final String iconUrl;
        private final boolean isUsed;
        private String logoUrl;
        private final String passengerName;
        private final String passengerType;
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private final String primaryCTA;
        private final String seatNumber;
        private final String subPocketType;
        private final String transportLogoUrl;
        private final String transportName;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<TravelTicketCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TravelTicketCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new TravelTicketCard(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TravelTicketCard[] newArray(int i) {
                return new TravelTicketCard[i];
            }
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getTransportLogoUrl() {
            return this.transportLogoUrl;
        }

        /* renamed from: component11  reason: from getter */
        public final String getDepartureTime() {
            return this.departureTime;
        }

        /* renamed from: component12  reason: from getter */
        public final String getArrivalTime() {
            return this.arrivalTime;
        }

        /* renamed from: component13  reason: from getter */
        public final String getBookingCode() {
            return this.bookingCode;
        }

        /* renamed from: component14  reason: from getter */
        public final String getTransportName() {
            return this.transportName;
        }

        /* renamed from: component15  reason: from getter */
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        /* renamed from: component16  reason: from getter */
        public final String getDepartureCode() {
            return this.departureCode;
        }

        /* renamed from: component17  reason: from getter */
        public final String getArrivalCode() {
            return this.arrivalCode;
        }

        /* renamed from: component18  reason: from getter */
        public final String getDepartureAirport() {
            return this.departureAirport;
        }

        /* renamed from: component19  reason: from getter */
        public final String getArrivalAirport() {
            return this.arrivalAirport;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final String getDepartureTerminal() {
            return this.departureTerminal;
        }

        /* renamed from: component21  reason: from getter */
        public final String getArrivalTerminal() {
            return this.arrivalTerminal;
        }

        /* renamed from: component22  reason: from getter */
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        /* renamed from: component23  reason: from getter */
        public final String getHexCode() {
            return this.hexCode;
        }

        /* renamed from: component24  reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        /* renamed from: component25  reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: component26  reason: from getter */
        public final String getGateNumber() {
            return this.gateNumber;
        }

        /* renamed from: component27  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        public final String component3() {
            return getPocketType();
        }

        public final boolean component4() {
            return getIsUsed();
        }

        /* renamed from: component5  reason: from getter */
        public final String getPassengerName() {
            return this.passengerName;
        }

        /* renamed from: component6  reason: from getter */
        public final String getPassengerType() {
            return this.passengerType;
        }

        /* renamed from: component7  reason: from getter */
        public final String getSubPocketType() {
            return this.subPocketType;
        }

        /* renamed from: component8  reason: from getter */
        public final String getDeparture() {
            return this.departure;
        }

        /* renamed from: component9  reason: from getter */
        public final String getArrival() {
            return this.arrival;
        }

        public final TravelTicketCard copy(String pocketId, String pocketStatus, String pocketType, boolean isUsed, String passengerName, String passengerType, String subPocketType, String departure, String arrival, String transportLogoUrl, String departureTime, String arrivalTime, String bookingCode, String transportName, String seatNumber, String departureCode, String arrivalCode, String departureAirport, String arrivalAirport, String departureTerminal, String arrivalTerminal, String primaryCTA, String hexCode, String backgroundUrl, String iconUrl, String gateNumber, String logoUrl) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            return new TravelTicketCard(pocketId, pocketStatus, pocketType, isUsed, passengerName, passengerType, subPocketType, departure, arrival, transportLogoUrl, departureTime, arrivalTime, bookingCode, transportName, seatNumber, departureCode, arrivalCode, departureAirport, arrivalAirport, departureTerminal, arrivalTerminal, primaryCTA, hexCode, backgroundUrl, iconUrl, gateNumber, logoUrl);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof TravelTicketCard) {
                TravelTicketCard travelTicketCard = (TravelTicketCard) other;
                return Intrinsics.areEqual(getPocketId(), travelTicketCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), travelTicketCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), travelTicketCard.getPocketType()) && getIsUsed() == travelTicketCard.getIsUsed() && Intrinsics.areEqual(this.passengerName, travelTicketCard.passengerName) && Intrinsics.areEqual(this.passengerType, travelTicketCard.passengerType) && Intrinsics.areEqual(this.subPocketType, travelTicketCard.subPocketType) && Intrinsics.areEqual(this.departure, travelTicketCard.departure) && Intrinsics.areEqual(this.arrival, travelTicketCard.arrival) && Intrinsics.areEqual(this.transportLogoUrl, travelTicketCard.transportLogoUrl) && Intrinsics.areEqual(this.departureTime, travelTicketCard.departureTime) && Intrinsics.areEqual(this.arrivalTime, travelTicketCard.arrivalTime) && Intrinsics.areEqual(this.bookingCode, travelTicketCard.bookingCode) && Intrinsics.areEqual(this.transportName, travelTicketCard.transportName) && Intrinsics.areEqual(this.seatNumber, travelTicketCard.seatNumber) && Intrinsics.areEqual(this.departureCode, travelTicketCard.departureCode) && Intrinsics.areEqual(this.arrivalCode, travelTicketCard.arrivalCode) && Intrinsics.areEqual(this.departureAirport, travelTicketCard.departureAirport) && Intrinsics.areEqual(this.arrivalAirport, travelTicketCard.arrivalAirport) && Intrinsics.areEqual(this.departureTerminal, travelTicketCard.departureTerminal) && Intrinsics.areEqual(this.arrivalTerminal, travelTicketCard.arrivalTerminal) && Intrinsics.areEqual(this.primaryCTA, travelTicketCard.primaryCTA) && Intrinsics.areEqual(this.hexCode, travelTicketCard.hexCode) && Intrinsics.areEqual(this.backgroundUrl, travelTicketCard.backgroundUrl) && Intrinsics.areEqual(this.iconUrl, travelTicketCard.iconUrl) && Intrinsics.areEqual(this.gateNumber, travelTicketCard.gateNumber) && Intrinsics.areEqual(this.logoUrl, travelTicketCard.logoUrl);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            boolean isUsed = getIsUsed();
            int i = isUsed;
            if (isUsed) {
                i = 1;
            }
            String str = this.passengerName;
            int hashCode4 = str == null ? 0 : str.hashCode();
            String str2 = this.passengerType;
            int hashCode5 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.subPocketType;
            int hashCode6 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.departure;
            int hashCode7 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.arrival;
            int hashCode8 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.transportLogoUrl;
            int hashCode9 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.departureTime;
            int hashCode10 = str7 == null ? 0 : str7.hashCode();
            String str8 = this.arrivalTime;
            int hashCode11 = str8 == null ? 0 : str8.hashCode();
            String str9 = this.bookingCode;
            int hashCode12 = str9 == null ? 0 : str9.hashCode();
            String str10 = this.transportName;
            int hashCode13 = str10 == null ? 0 : str10.hashCode();
            String str11 = this.seatNumber;
            int hashCode14 = str11 == null ? 0 : str11.hashCode();
            String str12 = this.departureCode;
            int hashCode15 = str12 == null ? 0 : str12.hashCode();
            String str13 = this.arrivalCode;
            int hashCode16 = str13 == null ? 0 : str13.hashCode();
            String str14 = this.departureAirport;
            int hashCode17 = str14 == null ? 0 : str14.hashCode();
            String str15 = this.arrivalAirport;
            int hashCode18 = str15 == null ? 0 : str15.hashCode();
            String str16 = this.departureTerminal;
            int hashCode19 = str16 == null ? 0 : str16.hashCode();
            String str17 = this.arrivalTerminal;
            int hashCode20 = str17 == null ? 0 : str17.hashCode();
            String str18 = this.primaryCTA;
            int hashCode21 = str18 == null ? 0 : str18.hashCode();
            String str19 = this.hexCode;
            int hashCode22 = str19 == null ? 0 : str19.hashCode();
            String str20 = this.backgroundUrl;
            int hashCode23 = str20 == null ? 0 : str20.hashCode();
            String str21 = this.iconUrl;
            int hashCode24 = str21 == null ? 0 : str21.hashCode();
            String str22 = this.gateNumber;
            int hashCode25 = str22 == null ? 0 : str22.hashCode();
            String str23 = this.logoUrl;
            return (((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + (str23 != null ? str23.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TravelTicketCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", isUsed=");
            sb.append(getIsUsed());
            sb.append(", passengerName=");
            sb.append(this.passengerName);
            sb.append(", passengerType=");
            sb.append(this.passengerType);
            sb.append(", subPocketType=");
            sb.append(this.subPocketType);
            sb.append(", departure=");
            sb.append(this.departure);
            sb.append(", arrival=");
            sb.append(this.arrival);
            sb.append(", transportLogoUrl=");
            sb.append(this.transportLogoUrl);
            sb.append(", departureTime=");
            sb.append(this.departureTime);
            sb.append(", arrivalTime=");
            sb.append(this.arrivalTime);
            sb.append(", bookingCode=");
            sb.append(this.bookingCode);
            sb.append(", transportName=");
            sb.append(this.transportName);
            sb.append(", seatNumber=");
            sb.append(this.seatNumber);
            sb.append(", departureCode=");
            sb.append(this.departureCode);
            sb.append(", arrivalCode=");
            sb.append(this.arrivalCode);
            sb.append(", departureAirport=");
            sb.append(this.departureAirport);
            sb.append(", arrivalAirport=");
            sb.append(this.arrivalAirport);
            sb.append(", departureTerminal=");
            sb.append(this.departureTerminal);
            sb.append(", arrivalTerminal=");
            sb.append(this.arrivalTerminal);
            sb.append(", primaryCTA=");
            sb.append(this.primaryCTA);
            sb.append(", hexCode=");
            sb.append(this.hexCode);
            sb.append(", backgroundUrl=");
            sb.append(this.backgroundUrl);
            sb.append(", iconUrl=");
            sb.append(this.iconUrl);
            sb.append(", gateNumber=");
            sb.append(this.gateNumber);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.isUsed ? 1 : 0);
            parcel.writeString(this.passengerName);
            parcel.writeString(this.passengerType);
            parcel.writeString(this.subPocketType);
            parcel.writeString(this.departure);
            parcel.writeString(this.arrival);
            parcel.writeString(this.transportLogoUrl);
            parcel.writeString(this.departureTime);
            parcel.writeString(this.arrivalTime);
            parcel.writeString(this.bookingCode);
            parcel.writeString(this.transportName);
            parcel.writeString(this.seatNumber);
            parcel.writeString(this.departureCode);
            parcel.writeString(this.arrivalCode);
            parcel.writeString(this.departureAirport);
            parcel.writeString(this.arrivalAirport);
            parcel.writeString(this.departureTerminal);
            parcel.writeString(this.arrivalTerminal);
            parcel.writeString(this.primaryCTA);
            parcel.writeString(this.hexCode);
            parcel.writeString(this.backgroundUrl);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.gateNumber);
            parcel.writeString(this.logoUrl);
        }

        public /* synthetic */ TravelTicketCard(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, (32768 & i) != 0 ? "" : str15, (65536 & i) != 0 ? "" : str16, (131072 & i) != 0 ? "" : str17, (262144 & i) != 0 ? "" : str18, (524288 & i) != 0 ? "" : str19, (1048576 & i) != 0 ? "" : str20, (2097152 & i) != 0 ? "" : str21, (4194304 & i) != 0 ? "" : str22, (8388608 & i) != 0 ? "" : str23, (16777216 & i) != 0 ? "" : str24, (33554432 & i) != 0 ? "" : str25, (i & 67108864) != 0 ? "" : str26);
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "isUsed")
        /* renamed from: isUsed  reason: from getter */
        public final boolean getIsUsed() {
            return this.isUsed;
        }

        @JvmName(name = "getPassengerName")
        public final String getPassengerName() {
            return this.passengerName;
        }

        @JvmName(name = "getPassengerType")
        public final String getPassengerType() {
            return this.passengerType;
        }

        @JvmName(name = "getSubPocketType")
        public final String getSubPocketType() {
            return this.subPocketType;
        }

        @JvmName(name = "getDeparture")
        public final String getDeparture() {
            return this.departure;
        }

        @JvmName(name = "getArrival")
        public final String getArrival() {
            return this.arrival;
        }

        @JvmName(name = "getTransportLogoUrl")
        public final String getTransportLogoUrl() {
            return this.transportLogoUrl;
        }

        @JvmName(name = "getDepartureTime")
        public final String getDepartureTime() {
            return this.departureTime;
        }

        @JvmName(name = "getArrivalTime")
        public final String getArrivalTime() {
            return this.arrivalTime;
        }

        @JvmName(name = "getBookingCode")
        public final String getBookingCode() {
            return this.bookingCode;
        }

        @JvmName(name = "getTransportName")
        public final String getTransportName() {
            return this.transportName;
        }

        @JvmName(name = "getSeatNumber")
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        @JvmName(name = "getDepartureCode")
        public final String getDepartureCode() {
            return this.departureCode;
        }

        @JvmName(name = "getArrivalCode")
        public final String getArrivalCode() {
            return this.arrivalCode;
        }

        @JvmName(name = "getDepartureAirport")
        public final String getDepartureAirport() {
            return this.departureAirport;
        }

        @JvmName(name = "getArrivalAirport")
        public final String getArrivalAirport() {
            return this.arrivalAirport;
        }

        @JvmName(name = "getDepartureTerminal")
        public final String getDepartureTerminal() {
            return this.departureTerminal;
        }

        @JvmName(name = "getArrivalTerminal")
        public final String getArrivalTerminal() {
            return this.arrivalTerminal;
        }

        @JvmName(name = "getPrimaryCTA")
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        @JvmName(name = "getHexCode")
        public final String getHexCode() {
            return this.hexCode;
        }

        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @JvmName(name = "getGateNumber")
        public final String getGateNumber() {
            return this.gateNumber;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            this.logoUrl = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TravelTicketCard(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26) {
            super(str, str2, str3, z, 9, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.isUsed = z;
            this.passengerName = str4;
            this.passengerType = str5;
            this.subPocketType = str6;
            this.departure = str7;
            this.arrival = str8;
            this.transportLogoUrl = str9;
            this.departureTime = str10;
            this.arrivalTime = str11;
            this.bookingCode = str12;
            this.transportName = str13;
            this.seatNumber = str14;
            this.departureCode = str15;
            this.arrivalCode = str16;
            this.departureAirport = str17;
            this.arrivalAirport = str18;
            this.departureTerminal = str19;
            this.arrivalTerminal = str20;
            this.primaryCTA = str21;
            this.hexCode = str22;
            this.backgroundUrl = str23;
            this.iconUrl = str24;
            this.gateNumber = str25;
            this.logoUrl = str26;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J°\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020$HÖ\u0001¢\u0006\u0004\b+\u0010&J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\u0004J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020$HÖ\u0001¢\u0006\u0004\b1\u00102R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u00105\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00103\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b8\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00103\u001a\u0004\b9\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u00103\u001a\u0004\b:\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u00103\u001a\u0004\b;\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u00103\u001a\u0004\b<\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b=\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b>\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b?\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b@\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\bA\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$MovieTicketCard;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "", "component4", "()Z", "component5", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "pocketType", "isUsed", "moviePosterUrl", DecodedScanBizInfoKey.LOGO_URL, "backgroundUrl", "movieName", BridgeName.LOCATION_NAME, "ticketClass", "showTime", "studioNumber", "seatNumber", "primaryCTA", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$MovieTicketCard;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBackgroundUrl", "Z", "getLocationName", "getLogoUrl", "getMovieName", "getMoviePosterUrl", "getPocketId", "getPocketStatus", "getPocketType", "getPrimaryCTA", "getSeatNumber", "getShowTime", "getStudioNumber", "getTicketClass", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class MovieTicketCard extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<MovieTicketCard> CREATOR = new Creator();
        private final String backgroundUrl;
        private final boolean isUsed;
        private final String locationName;
        private final String logoUrl;
        private final String movieName;
        private final String moviePosterUrl;
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private final String primaryCTA;
        private final String seatNumber;
        private final String showTime;
        private final String studioNumber;
        private final String ticketClass;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<MovieTicketCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MovieTicketCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new MovieTicketCard(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MovieTicketCard[] newArray(int i) {
                return new MovieTicketCard[i];
            }
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getTicketClass() {
            return this.ticketClass;
        }

        /* renamed from: component11  reason: from getter */
        public final String getShowTime() {
            return this.showTime;
        }

        /* renamed from: component12  reason: from getter */
        public final String getStudioNumber() {
            return this.studioNumber;
        }

        /* renamed from: component13  reason: from getter */
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        /* renamed from: component14  reason: from getter */
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        public final String component2() {
            return getPocketStatus();
        }

        public final String component3() {
            return getPocketType();
        }

        public final boolean component4() {
            return getIsUsed();
        }

        /* renamed from: component5  reason: from getter */
        public final String getMoviePosterUrl() {
            return this.moviePosterUrl;
        }

        /* renamed from: component6  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component7  reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        /* renamed from: component8  reason: from getter */
        public final String getMovieName() {
            return this.movieName;
        }

        /* renamed from: component9  reason: from getter */
        public final String getLocationName() {
            return this.locationName;
        }

        public final MovieTicketCard copy(String pocketId, String pocketStatus, String pocketType, boolean isUsed, String moviePosterUrl, String logoUrl, String backgroundUrl, String movieName, String locationName, String ticketClass, String showTime, String studioNumber, String seatNumber, String primaryCTA) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            return new MovieTicketCard(pocketId, pocketStatus, pocketType, isUsed, moviePosterUrl, logoUrl, backgroundUrl, movieName, locationName, ticketClass, showTime, studioNumber, seatNumber, primaryCTA);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MovieTicketCard) {
                MovieTicketCard movieTicketCard = (MovieTicketCard) other;
                return Intrinsics.areEqual(getPocketId(), movieTicketCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), movieTicketCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), movieTicketCard.getPocketType()) && getIsUsed() == movieTicketCard.getIsUsed() && Intrinsics.areEqual(this.moviePosterUrl, movieTicketCard.moviePosterUrl) && Intrinsics.areEqual(this.logoUrl, movieTicketCard.logoUrl) && Intrinsics.areEqual(this.backgroundUrl, movieTicketCard.backgroundUrl) && Intrinsics.areEqual(this.movieName, movieTicketCard.movieName) && Intrinsics.areEqual(this.locationName, movieTicketCard.locationName) && Intrinsics.areEqual(this.ticketClass, movieTicketCard.ticketClass) && Intrinsics.areEqual(this.showTime, movieTicketCard.showTime) && Intrinsics.areEqual(this.studioNumber, movieTicketCard.studioNumber) && Intrinsics.areEqual(this.seatNumber, movieTicketCard.seatNumber) && Intrinsics.areEqual(this.primaryCTA, movieTicketCard.primaryCTA);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            boolean isUsed = getIsUsed();
            int i = isUsed;
            if (isUsed) {
                i = 1;
            }
            String str = this.moviePosterUrl;
            int hashCode4 = str == null ? 0 : str.hashCode();
            String str2 = this.logoUrl;
            int hashCode5 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.backgroundUrl;
            int hashCode6 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.movieName;
            int hashCode7 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.locationName;
            int hashCode8 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.ticketClass;
            int hashCode9 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.showTime;
            int hashCode10 = str7 == null ? 0 : str7.hashCode();
            String str8 = this.studioNumber;
            int hashCode11 = str8 == null ? 0 : str8.hashCode();
            String str9 = this.seatNumber;
            int hashCode12 = str9 == null ? 0 : str9.hashCode();
            String str10 = this.primaryCTA;
            return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str10 != null ? str10.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MovieTicketCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", isUsed=");
            sb.append(getIsUsed());
            sb.append(", moviePosterUrl=");
            sb.append(this.moviePosterUrl);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", backgroundUrl=");
            sb.append(this.backgroundUrl);
            sb.append(", movieName=");
            sb.append(this.movieName);
            sb.append(", locationName=");
            sb.append(this.locationName);
            sb.append(", ticketClass=");
            sb.append(this.ticketClass);
            sb.append(", showTime=");
            sb.append(this.showTime);
            sb.append(", studioNumber=");
            sb.append(this.studioNumber);
            sb.append(", seatNumber=");
            sb.append(this.seatNumber);
            sb.append(", primaryCTA=");
            sb.append(this.primaryCTA);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.isUsed ? 1 : 0);
            parcel.writeString(this.moviePosterUrl);
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.backgroundUrl);
            parcel.writeString(this.movieName);
            parcel.writeString(this.locationName);
            parcel.writeString(this.ticketClass);
            parcel.writeString(this.showTime);
            parcel.writeString(this.studioNumber);
            parcel.writeString(this.seatNumber);
            parcel.writeString(this.primaryCTA);
        }

        public /* synthetic */ MovieTicketCard(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13);
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.VoucherAndTicketCardModel
        @JvmName(name = "isUsed")
        /* renamed from: isUsed  reason: from getter */
        public final boolean getIsUsed() {
            return this.isUsed;
        }

        @JvmName(name = "getMoviePosterUrl")
        public final String getMoviePosterUrl() {
            return this.moviePosterUrl;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @JvmName(name = "getMovieName")
        public final String getMovieName() {
            return this.movieName;
        }

        @JvmName(name = "getLocationName")
        public final String getLocationName() {
            return this.locationName;
        }

        @JvmName(name = "getTicketClass")
        public final String getTicketClass() {
            return this.ticketClass;
        }

        @JvmName(name = "getShowTime")
        public final String getShowTime() {
            return this.showTime;
        }

        @JvmName(name = "getStudioNumber")
        public final String getStudioNumber() {
            return this.studioNumber;
        }

        @JvmName(name = "getSeatNumber")
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        @JvmName(name = "getPrimaryCTA")
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MovieTicketCard(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
            super(str, str2, str3, z, 15, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.isUsed = z;
            this.moviePosterUrl = str4;
            this.logoUrl = str5;
            this.backgroundUrl = str6;
            this.movieName = str7;
            this.locationName = str8;
            this.ticketClass = str9;
            this.showTime = str10;
            this.studioNumber = str11;
            this.seatNumber = str12;
            this.primaryCTA = str13;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$LoadingState;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "dummyData", "copy", "(Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$LoadingState;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDummyData", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class LoadingState extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<LoadingState> CREATOR = new Creator();
        private final String dummyData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<LoadingState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LoadingState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new LoadingState(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LoadingState[] newArray(int i) {
                return new LoadingState[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LoadingState() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.model.VoucherAndTicketCardModel.LoadingState.<init>():void");
        }

        public static /* synthetic */ LoadingState copy$default(LoadingState loadingState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadingState.dummyData;
            }
            return loadingState.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDummyData() {
            return this.dummyData;
        }

        public final LoadingState copy(String dummyData) {
            return new LoadingState(dummyData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoadingState) && Intrinsics.areEqual(this.dummyData, ((LoadingState) other).dummyData);
        }

        public final int hashCode() {
            String str = this.dummyData;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoadingState(dummyData=");
            sb.append(this.dummyData);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.dummyData);
        }

        public /* synthetic */ LoadingState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getDummyData")
        public final String getDummyData() {
            return this.dummyData;
        }

        public LoadingState(String str) {
            super("", "", "", false, 11, null);
            this.dummyData = str;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherShimmerLoadingState;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "dummyData", "copy", "(Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$VoucherShimmerLoadingState;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDummyData", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class VoucherShimmerLoadingState extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<VoucherShimmerLoadingState> CREATOR = new Creator();
        private final String dummyData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        public static final class Creator implements Parcelable.Creator<VoucherShimmerLoadingState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final VoucherShimmerLoadingState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new VoucherShimmerLoadingState(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final VoucherShimmerLoadingState[] newArray(int i) {
                return new VoucherShimmerLoadingState[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public VoucherShimmerLoadingState() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.model.VoucherAndTicketCardModel.VoucherShimmerLoadingState.<init>():void");
        }

        public static /* synthetic */ VoucherShimmerLoadingState copy$default(VoucherShimmerLoadingState voucherShimmerLoadingState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = voucherShimmerLoadingState.dummyData;
            }
            return voucherShimmerLoadingState.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDummyData() {
            return this.dummyData;
        }

        public final VoucherShimmerLoadingState copy(String dummyData) {
            return new VoucherShimmerLoadingState(dummyData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VoucherShimmerLoadingState) && Intrinsics.areEqual(this.dummyData, ((VoucherShimmerLoadingState) other).dummyData);
        }

        public final int hashCode() {
            String str = this.dummyData;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VoucherShimmerLoadingState(dummyData=");
            sb.append(this.dummyData);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.dummyData);
        }

        public /* synthetic */ VoucherShimmerLoadingState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getDummyData")
        public final String getDummyData() {
            return this.dummyData;
        }

        public VoucherShimmerLoadingState(String str) {
            super("", "", "", false, 12, null);
            this.dummyData = str;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$EmptyState;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "", "component1", "()Ljava/lang/String;", "dummyData", "copy", "(Ljava/lang/String;)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel$EmptyState;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDummyData", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class EmptyState extends VoucherAndTicketCardModel {
        public static final Parcelable.Creator<EmptyState> CREATOR = new Creator();
        private final String dummyData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<EmptyState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmptyState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new EmptyState(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmptyState[] newArray(int i) {
                return new EmptyState[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public EmptyState() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.model.VoucherAndTicketCardModel.EmptyState.<init>():void");
        }

        public static /* synthetic */ EmptyState copy$default(EmptyState emptyState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emptyState.dummyData;
            }
            return emptyState.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDummyData() {
            return this.dummyData;
        }

        public final EmptyState copy(String dummyData) {
            return new EmptyState(dummyData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EmptyState) && Intrinsics.areEqual(this.dummyData, ((EmptyState) other).dummyData);
        }

        public final int hashCode() {
            String str = this.dummyData;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("EmptyState(dummyData=");
            sb.append(this.dummyData);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.dummyData);
        }

        public /* synthetic */ EmptyState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getDummyData")
        public final String getDummyData() {
            return this.dummyData;
        }

        public EmptyState(String str) {
            super("", "", "", false, 3, null);
            this.dummyData = str;
        }
    }
}
