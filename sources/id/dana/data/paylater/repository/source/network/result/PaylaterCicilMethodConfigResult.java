package id.dana.data.paylater.repository.source.network.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B©\u0001\u0012\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0003\u00108\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000107\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR$\u0010(\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR$\u0010+\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR$\u0010.\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR$\u00101\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR$\u00104\u001a\u0004\u0018\u00010\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R*\u00108\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010="}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/PaylaterCicilMethodConfigResult;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "cacheTime", "Ljava/lang/Integer;", "getCacheTime", "()Ljava/lang/Integer;", "setCacheTime", "(Ljava/lang/Integer;)V", "delayShowRegistration", "getDelayShowRegistration", "setDelayShowRegistration", "maxCountShowRegistration", "getMaxCountShowRegistration", "setMaxCountShowRegistration", "", "mid", "Ljava/lang/String;", "getMid", "()Ljava/lang/String;", "setMid", "(Ljava/lang/String;)V", "onBoardingImageUrl", "getOnBoardingImageUrl", "setOnBoardingImageUrl", "onboardingSpaceCode", "getOnboardingSpaceCode", "setOnboardingSpaceCode", "payMethodUnregistDesc", "getPayMethodUnregistDesc", "setPayMethodUnregistDesc", "paymethodDescription", "getPaymethodDescription", "setPaymethodDescription", "paymethodName", "getPaymethodName", "setPaymethodName", "promoRibbonDesc", "getPromoRibbonDesc", "setPromoRibbonDesc", "promoRibbonSelectedDesc", "getPromoRibbonSelectedDesc", "setPromoRibbonSelectedDesc", "thresholdDue", "getThresholdDue", "setThresholdDue", "", "tncSpaceCode", "Ljava/util/List;", "getTncSpaceCode", "()Ljava/util/List;", "setTncSpaceCode", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaylaterCicilMethodConfigResult implements Parcelable, Serializable {
    public static final Parcelable.Creator<PaylaterCicilMethodConfigResult> CREATOR = new Creator();
    public Integer cacheTime;
    public Integer delayShowRegistration;
    public Integer maxCountShowRegistration;
    public String mid;
    public String onBoardingImageUrl;
    public String onboardingSpaceCode;
    public String payMethodUnregistDesc;
    public String paymethodDescription;
    public String paymethodName;
    public String promoRibbonDesc;
    public String promoRibbonSelectedDesc;
    public Integer thresholdDue;
    public List<String> tncSpaceCode;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<PaylaterCicilMethodConfigResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaylaterCicilMethodConfigResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PaylaterCicilMethodConfigResult(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaylaterCicilMethodConfigResult[] newArray(int i) {
            return new PaylaterCicilMethodConfigResult[i];
        }
    }

    public PaylaterCicilMethodConfigResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
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
        Integer num = this.cacheTime;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.thresholdDue;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.onBoardingImageUrl);
        parcel.writeString(this.promoRibbonDesc);
        parcel.writeString(this.promoRibbonSelectedDesc);
        parcel.writeString(this.payMethodUnregistDesc);
        Integer num3 = this.maxCountShowRegistration;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.delayShowRegistration;
        if (num4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num4.intValue());
    }

    public PaylaterCicilMethodConfigResult(@JSONField(name = "paymethod_name") String str, @JSONField(name = "paymethod_description_payconfirmation") String str2, @JSONField(name = "onboarding_space_code") String str3, @JSONField(name = "tnc_space_code") List<String> list, @JSONField(name = "mid") String str4, @JSONField(name = "cache_time") Integer num, @JSONField(name = "threshold_due") Integer num2, @JSONField(name = "onboarding_image_url") String str5, @JSONField(name = "promo_ribbon_desc") String str6, @JSONField(name = "promo_ribbon_selected_desc") String str7, @JSONField(name = "paymethod_unregist_desc") String str8, @JSONField(name = "max_count_show_registration") Integer num3, @JSONField(name = "delay_show_registration") Integer num4) {
        this.paymethodName = str;
        this.paymethodDescription = str2;
        this.onboardingSpaceCode = str3;
        this.tncSpaceCode = list;
        this.mid = str4;
        this.cacheTime = num;
        this.thresholdDue = num2;
        this.onBoardingImageUrl = str5;
        this.promoRibbonDesc = str6;
        this.promoRibbonSelectedDesc = str7;
        this.payMethodUnregistDesc = str8;
        this.maxCountShowRegistration = num3;
        this.delayShowRegistration = num4;
    }

    @JvmName(name = "getPaymethodName")
    public final String getPaymethodName() {
        return this.paymethodName;
    }

    @JvmName(name = "setPaymethodName")
    public final void setPaymethodName(String str) {
        this.paymethodName = str;
    }

    @JvmName(name = "getPaymethodDescription")
    public final String getPaymethodDescription() {
        return this.paymethodDescription;
    }

    @JvmName(name = "setPaymethodDescription")
    public final void setPaymethodDescription(String str) {
        this.paymethodDescription = str;
    }

    @JvmName(name = "getOnboardingSpaceCode")
    public final String getOnboardingSpaceCode() {
        return this.onboardingSpaceCode;
    }

    @JvmName(name = "setOnboardingSpaceCode")
    public final void setOnboardingSpaceCode(String str) {
        this.onboardingSpaceCode = str;
    }

    public /* synthetic */ PaylaterCicilMethodConfigResult(String str, String str2, String str3, List list, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? 0 : num, (i & 64) != 0 ? 0 : num2, (i & 128) != 0 ? "" : str5, (i & 256) != 0 ? "" : str6, (i & 512) != 0 ? "" : str7, (i & 1024) == 0 ? str8 : "", (i & 2048) != 0 ? 0 : num3, (i & 4096) != 0 ? 0 : num4);
    }

    @JvmName(name = "getTncSpaceCode")
    public final List<String> getTncSpaceCode() {
        return this.tncSpaceCode;
    }

    @JvmName(name = "setTncSpaceCode")
    public final void setTncSpaceCode(List<String> list) {
        this.tncSpaceCode = list;
    }

    @JvmName(name = "getMid")
    public final String getMid() {
        return this.mid;
    }

    @JvmName(name = "setMid")
    public final void setMid(String str) {
        this.mid = str;
    }

    @JvmName(name = "getCacheTime")
    public final Integer getCacheTime() {
        return this.cacheTime;
    }

    @JvmName(name = "setCacheTime")
    public final void setCacheTime(Integer num) {
        this.cacheTime = num;
    }

    @JvmName(name = "getThresholdDue")
    public final Integer getThresholdDue() {
        return this.thresholdDue;
    }

    @JvmName(name = "setThresholdDue")
    public final void setThresholdDue(Integer num) {
        this.thresholdDue = num;
    }

    @JvmName(name = "getOnBoardingImageUrl")
    public final String getOnBoardingImageUrl() {
        return this.onBoardingImageUrl;
    }

    @JvmName(name = "setOnBoardingImageUrl")
    public final void setOnBoardingImageUrl(String str) {
        this.onBoardingImageUrl = str;
    }

    @JvmName(name = "getPromoRibbonDesc")
    public final String getPromoRibbonDesc() {
        return this.promoRibbonDesc;
    }

    @JvmName(name = "setPromoRibbonDesc")
    public final void setPromoRibbonDesc(String str) {
        this.promoRibbonDesc = str;
    }

    @JvmName(name = "getPromoRibbonSelectedDesc")
    public final String getPromoRibbonSelectedDesc() {
        return this.promoRibbonSelectedDesc;
    }

    @JvmName(name = "setPromoRibbonSelectedDesc")
    public final void setPromoRibbonSelectedDesc(String str) {
        this.promoRibbonSelectedDesc = str;
    }

    @JvmName(name = "getPayMethodUnregistDesc")
    public final String getPayMethodUnregistDesc() {
        return this.payMethodUnregistDesc;
    }

    @JvmName(name = "setPayMethodUnregistDesc")
    public final void setPayMethodUnregistDesc(String str) {
        this.payMethodUnregistDesc = str;
    }

    @JvmName(name = "getMaxCountShowRegistration")
    public final Integer getMaxCountShowRegistration() {
        return this.maxCountShowRegistration;
    }

    @JvmName(name = "setMaxCountShowRegistration")
    public final void setMaxCountShowRegistration(Integer num) {
        this.maxCountShowRegistration = num;
    }

    @JvmName(name = "getDelayShowRegistration")
    public final Integer getDelayShowRegistration() {
        return this.delayShowRegistration;
    }

    @JvmName(name = "setDelayShowRegistration")
    public final void setDelayShowRegistration(Integer num) {
        this.delayShowRegistration = num;
    }
}
