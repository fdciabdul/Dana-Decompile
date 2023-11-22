package id.dana.domain.paylater.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010,\u001a\u00020\u0019\u0012\b\b\u0002\u0010)\u001a\u00020\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\u0019\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001908\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0019\u0012\b\b\u0002\u0010/\u001a\u00020\u0019\u0012\b\b\u0002\u00102\u001a\u00020\u0019\u0012\b\b\u0002\u0010&\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0004\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\"\u0010)\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u0010,\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\"\u0010/\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\"\u00102\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\"\u00105\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u0010\u0012R(\u00109\u001a\b\u0012\u0004\u0012\u00020\u0019088\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>"}, d2 = {"Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "getThresholdDueInDay", "()J", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "cacheTime", "I", "getCacheTime", "setCacheTime", "(I)V", "delayShowRegistration", "getDelayShowRegistration", "setDelayShowRegistration", "maxCountShowRegistration", "getMaxCountShowRegistration", "setMaxCountShowRegistration", "", "mid", "Ljava/lang/String;", "getMid", "()Ljava/lang/String;", "setMid", "(Ljava/lang/String;)V", "onBoardingImageUrl", "getOnBoardingImageUrl", "setOnBoardingImageUrl", "onboardingSpaceCode", "getOnboardingSpaceCode", "setOnboardingSpaceCode", "payMethodUnregistDesc", "getPayMethodUnregistDesc", "setPayMethodUnregistDesc", "paymethodDescription", "getPaymethodDescription", "setPaymethodDescription", "paymethodName", "getPaymethodName", "setPaymethodName", "promoRibbonDesc", "getPromoRibbonDesc", "setPromoRibbonDesc", "promoRibbonSelectedDesc", "getPromoRibbonSelectedDesc", "setPromoRibbonSelectedDesc", "thresholdDue", "getThresholdDue", "setThresholdDue", "", "tncSpaceCode", "Ljava/util/List;", "getTncSpaceCode", "()Ljava/util/List;", "setTncSpaceCode", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterCicilMethodConfig implements Parcelable {
    public static final Parcelable.Creator<PaylaterCicilMethodConfig> CREATOR = new Creator();
    private int cacheTime;
    private int delayShowRegistration;
    private int maxCountShowRegistration;
    private String mid;
    private String onBoardingImageUrl;
    private String onboardingSpaceCode;
    private String payMethodUnregistDesc;
    private String paymethodDescription;
    private String paymethodName;
    private String promoRibbonDesc;
    private String promoRibbonSelectedDesc;
    private int thresholdDue;
    private List<String> tncSpaceCode;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<PaylaterCicilMethodConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaylaterCicilMethodConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PaylaterCicilMethodConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaylaterCicilMethodConfig[] newArray(int i) {
            return new PaylaterCicilMethodConfig[i];
        }
    }

    public PaylaterCicilMethodConfig() {
        this(null, null, null, null, null, 0, 0, null, null, null, null, 0, 0, 8191, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.paymethodName);
        parcel.writeString(this.paymethodDescription);
        parcel.writeString(this.onboardingSpaceCode);
        parcel.writeStringList(this.tncSpaceCode);
        parcel.writeString(this.mid);
        parcel.writeInt(this.cacheTime);
        parcel.writeInt(this.thresholdDue);
        parcel.writeString(this.onBoardingImageUrl);
        parcel.writeString(this.promoRibbonDesc);
        parcel.writeString(this.promoRibbonSelectedDesc);
        parcel.writeString(this.payMethodUnregistDesc);
        parcel.writeInt(this.maxCountShowRegistration);
        parcel.writeInt(this.delayShowRegistration);
    }

    public PaylaterCicilMethodConfig(String str, String str2, String str3, List<String> list, String str4, int i, int i2, String str5, String str6, String str7, String str8, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.paymethodName = str;
        this.paymethodDescription = str2;
        this.onboardingSpaceCode = str3;
        this.tncSpaceCode = list;
        this.mid = str4;
        this.cacheTime = i;
        this.thresholdDue = i2;
        this.onBoardingImageUrl = str5;
        this.promoRibbonDesc = str6;
        this.promoRibbonSelectedDesc = str7;
        this.payMethodUnregistDesc = str8;
        this.maxCountShowRegistration = i3;
        this.delayShowRegistration = i4;
    }

    @JvmName(name = "getPaymethodName")
    public final String getPaymethodName() {
        return this.paymethodName;
    }

    @JvmName(name = "setPaymethodName")
    public final void setPaymethodName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.paymethodName = str;
    }

    @JvmName(name = "getPaymethodDescription")
    public final String getPaymethodDescription() {
        return this.paymethodDescription;
    }

    @JvmName(name = "setPaymethodDescription")
    public final void setPaymethodDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.paymethodDescription = str;
    }

    @JvmName(name = "getOnboardingSpaceCode")
    public final String getOnboardingSpaceCode() {
        return this.onboardingSpaceCode;
    }

    @JvmName(name = "setOnboardingSpaceCode")
    public final void setOnboardingSpaceCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.onboardingSpaceCode = str;
    }

    public /* synthetic */ PaylaterCicilMethodConfig(String str, String str2, String str3, List list, String str4, int i, int i2, String str5, String str6, String str7, String str8, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? "" : str2, (i5 & 4) != 0 ? "" : str3, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list, (i5 & 16) != 0 ? "" : str4, (i5 & 32) != 0 ? 0 : i, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? "" : str5, (i5 & 256) != 0 ? "" : str6, (i5 & 512) != 0 ? "" : str7, (i5 & 1024) == 0 ? str8 : "", (i5 & 2048) != 0 ? 0 : i3, (i5 & 4096) == 0 ? i4 : 0);
    }

    @JvmName(name = "getTncSpaceCode")
    public final List<String> getTncSpaceCode() {
        return this.tncSpaceCode;
    }

    @JvmName(name = "setTncSpaceCode")
    public final void setTncSpaceCode(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.tncSpaceCode = list;
    }

    @JvmName(name = "getMid")
    public final String getMid() {
        return this.mid;
    }

    @JvmName(name = "setMid")
    public final void setMid(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.mid = str;
    }

    @JvmName(name = "getCacheTime")
    public final int getCacheTime() {
        return this.cacheTime;
    }

    @JvmName(name = "setCacheTime")
    public final void setCacheTime(int i) {
        this.cacheTime = i;
    }

    @JvmName(name = "getThresholdDue")
    public final int getThresholdDue() {
        return this.thresholdDue;
    }

    @JvmName(name = "setThresholdDue")
    public final void setThresholdDue(int i) {
        this.thresholdDue = i;
    }

    @JvmName(name = "getOnBoardingImageUrl")
    public final String getOnBoardingImageUrl() {
        return this.onBoardingImageUrl;
    }

    @JvmName(name = "setOnBoardingImageUrl")
    public final void setOnBoardingImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.onBoardingImageUrl = str;
    }

    @JvmName(name = "getPromoRibbonDesc")
    public final String getPromoRibbonDesc() {
        return this.promoRibbonDesc;
    }

    @JvmName(name = "setPromoRibbonDesc")
    public final void setPromoRibbonDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.promoRibbonDesc = str;
    }

    @JvmName(name = "getPromoRibbonSelectedDesc")
    public final String getPromoRibbonSelectedDesc() {
        return this.promoRibbonSelectedDesc;
    }

    @JvmName(name = "setPromoRibbonSelectedDesc")
    public final void setPromoRibbonSelectedDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.promoRibbonSelectedDesc = str;
    }

    @JvmName(name = "getPayMethodUnregistDesc")
    public final String getPayMethodUnregistDesc() {
        return this.payMethodUnregistDesc;
    }

    @JvmName(name = "setPayMethodUnregistDesc")
    public final void setPayMethodUnregistDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.payMethodUnregistDesc = str;
    }

    @JvmName(name = "getMaxCountShowRegistration")
    public final int getMaxCountShowRegistration() {
        return this.maxCountShowRegistration;
    }

    @JvmName(name = "setMaxCountShowRegistration")
    public final void setMaxCountShowRegistration(int i) {
        this.maxCountShowRegistration = i;
    }

    @JvmName(name = "getDelayShowRegistration")
    public final int getDelayShowRegistration() {
        return this.delayShowRegistration;
    }

    @JvmName(name = "setDelayShowRegistration")
    public final void setDelayShowRegistration(int i) {
        this.delayShowRegistration = i;
    }

    public final long getThresholdDueInDay() {
        return this.thresholdDue * TimeUtils.DAY_TO_SECOND * 1000;
    }
}
