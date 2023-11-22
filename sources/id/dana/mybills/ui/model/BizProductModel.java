package id.dana.mybills.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u0086\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0019\u0010'\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n0\b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\bN\u0010OJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n0\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J§\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00052\u001b\b\u0002\u0010'\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n0\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010)\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020,HÖ\u0001¢\u0006\u0004\b2\u0010.J\u0010\u00103\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b3\u0010\u0004J \u00108\u001a\u0002072\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020,HÖ\u0001¢\u0006\u0004\b8\u00109R\u0017\u0010\u001d\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010\u0004R\u001a\u0010)\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b<\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010=\u001a\u0004\b>\u0010\u0013R-\u0010'\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n0\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\b@\u0010\fR\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\bA\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\bB\u0010\u0004R\u001a\u0010 \u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010:\u001a\u0004\bC\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\bD\u0010\u0004R\u001a\u0010#\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010E\u001a\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\bF\u0010\u0004R\u001a\u0010%\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010:\u001a\u0004\bG\u0010\u0004R$\u0010(\u001a\u0004\u0018\u00010\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010H\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010KR\u001a\u0010&\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010L\u001a\u0004\bM\u0010\u0007"}, d2 = {"Lid/dana/mybills/ui/model/BizProductModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component10", "()J", "", "", "Lkotlinx/parcelize/RawValue;", "component11", "()Ljava/util/Map;", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "component12", "()Lid/dana/mybills/ui/model/MyBillsServiceModel;", "component13", "Lid/dana/mybills/ui/model/MoneyViewModel;", "component2", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "component3", "component4", "component5", "component6", "", "component7", "()Z", "component8", "component9", "bizId", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "goodsId", "goodsTitle", "goodsType", "goodsIconUrl", "isGoodsActive", "provider", "providerName", KybCpmConstants.TRANSACTION_DATE_PARAM, "extendInfo", "serviceModel", "customerName", "copy", "(Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/util/Map;Lid/dana/mybills/ui/model/MyBillsServiceModel;Ljava/lang/String;)Lid/dana/mybills/ui/model/BizProductModel;", "", "describeContents", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBizId", "getCustomerName", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getDenom", "Ljava/util/Map;", "getExtendInfo", "getGoodsIconUrl", "getGoodsId", "getGoodsTitle", "getGoodsType", "Z", "getProvider", "getProviderName", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "getServiceModel", "setServiceModel", "(Lid/dana/mybills/ui/model/MyBillsServiceModel;)V", "J", "getTransactionDate", "<init>", "(Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/util/Map;Lid/dana/mybills/ui/model/MyBillsServiceModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BizProductModel implements Parcelable {
    public static final Parcelable.Creator<BizProductModel> CREATOR = new Creator();
    private final String bizId;
    private final String customerName;
    private final MoneyViewModel denom;
    private final Map<String, Object> extendInfo;
    private final String goodsIconUrl;
    private final String goodsId;
    private final String goodsTitle;
    private final String goodsType;
    private final boolean isGoodsActive;
    private final String provider;
    private final String providerName;
    private MyBillsServiceModel serviceModel;
    private final long transactionDate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<BizProductModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BizProductModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            MoneyViewModel createFromParcel = MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int i = 0;
            boolean z = parcel.readInt() != 0;
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (i != readInt) {
                linkedHashMap.put(parcel.readString(), parcel.readValue(BizProductModel.class.getClassLoader()));
                i++;
                readInt = readInt;
            }
            return new BizProductModel(readString, createFromParcel, readString2, readString3, readString4, readString5, z, readString6, readString7, readLong, linkedHashMap, parcel.readInt() == 0 ? null : MyBillsServiceModel.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BizProductModel[] newArray(int i) {
            return new BizProductModel[i];
        }
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    /* renamed from: component10  reason: from getter */
    public final long getTransactionDate() {
        return this.transactionDate;
    }

    public final Map<String, Object> component11() {
        return this.extendInfo;
    }

    /* renamed from: component12  reason: from getter */
    public final MyBillsServiceModel getServiceModel() {
        return this.serviceModel;
    }

    /* renamed from: component13  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewModel getDenom() {
        return this.denom;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGoodsIconUrl() {
        return this.goodsIconUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsGoodsActive() {
        return this.isGoodsActive;
    }

    /* renamed from: component8  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component9  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    public final BizProductModel copy(String bizId, MoneyViewModel denom, String goodsId, String goodsTitle, String goodsType, String goodsIconUrl, boolean isGoodsActive, String provider, String providerName, long transactionDate, Map<String, ? extends Object> extendInfo, MyBillsServiceModel serviceModel, String customerName) {
        Intrinsics.checkNotNullParameter(bizId, "");
        Intrinsics.checkNotNullParameter(denom, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(goodsTitle, "");
        Intrinsics.checkNotNullParameter(goodsType, "");
        Intrinsics.checkNotNullParameter(goodsIconUrl, "");
        Intrinsics.checkNotNullParameter(provider, "");
        Intrinsics.checkNotNullParameter(providerName, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(customerName, "");
        return new BizProductModel(bizId, denom, goodsId, goodsTitle, goodsType, goodsIconUrl, isGoodsActive, provider, providerName, transactionDate, extendInfo, serviceModel, customerName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizProductModel) {
            BizProductModel bizProductModel = (BizProductModel) other;
            return Intrinsics.areEqual(this.bizId, bizProductModel.bizId) && Intrinsics.areEqual(this.denom, bizProductModel.denom) && Intrinsics.areEqual(this.goodsId, bizProductModel.goodsId) && Intrinsics.areEqual(this.goodsTitle, bizProductModel.goodsTitle) && Intrinsics.areEqual(this.goodsType, bizProductModel.goodsType) && Intrinsics.areEqual(this.goodsIconUrl, bizProductModel.goodsIconUrl) && this.isGoodsActive == bizProductModel.isGoodsActive && Intrinsics.areEqual(this.provider, bizProductModel.provider) && Intrinsics.areEqual(this.providerName, bizProductModel.providerName) && this.transactionDate == bizProductModel.transactionDate && Intrinsics.areEqual(this.extendInfo, bizProductModel.extendInfo) && Intrinsics.areEqual(this.serviceModel, bizProductModel.serviceModel) && Intrinsics.areEqual(this.customerName, bizProductModel.customerName);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.bizId.hashCode();
        int hashCode2 = this.denom.hashCode();
        int hashCode3 = this.goodsId.hashCode();
        int hashCode4 = this.goodsTitle.hashCode();
        int hashCode5 = this.goodsType.hashCode();
        int hashCode6 = this.goodsIconUrl.hashCode();
        boolean z = this.isGoodsActive;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode7 = this.provider.hashCode();
        int hashCode8 = this.providerName.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.transactionDate);
        int hashCode9 = this.extendInfo.hashCode();
        MyBillsServiceModel myBillsServiceModel = this.serviceModel;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + hashCode7) * 31) + hashCode8) * 31) + m) * 31) + hashCode9) * 31) + (myBillsServiceModel == null ? 0 : myBillsServiceModel.hashCode())) * 31) + this.customerName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizProductModel(bizId=");
        sb.append(this.bizId);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsTitle=");
        sb.append(this.goodsTitle);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", goodsIconUrl=");
        sb.append(this.goodsIconUrl);
        sb.append(", isGoodsActive=");
        sb.append(this.isGoodsActive);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", providerName=");
        sb.append(this.providerName);
        sb.append(", transactionDate=");
        sb.append(this.transactionDate);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", serviceModel=");
        sb.append(this.serviceModel);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.bizId);
        this.denom.writeToParcel(parcel, flags);
        parcel.writeString(this.goodsId);
        parcel.writeString(this.goodsTitle);
        parcel.writeString(this.goodsType);
        parcel.writeString(this.goodsIconUrl);
        parcel.writeInt(this.isGoodsActive ? 1 : 0);
        parcel.writeString(this.provider);
        parcel.writeString(this.providerName);
        parcel.writeLong(this.transactionDate);
        Map<String, Object> map = this.extendInfo;
        parcel.writeInt(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeValue(entry.getValue());
        }
        MyBillsServiceModel myBillsServiceModel = this.serviceModel;
        if (myBillsServiceModel == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            myBillsServiceModel.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.customerName);
    }

    public BizProductModel(String str, MoneyViewModel moneyViewModel, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, long j, Map<String, ? extends Object> map, MyBillsServiceModel myBillsServiceModel, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.bizId = str;
        this.denom = moneyViewModel;
        this.goodsId = str2;
        this.goodsTitle = str3;
        this.goodsType = str4;
        this.goodsIconUrl = str5;
        this.isGoodsActive = z;
        this.provider = str6;
        this.providerName = str7;
        this.transactionDate = j;
        this.extendInfo = map;
        this.serviceModel = myBillsServiceModel;
        this.customerName = str8;
    }

    public /* synthetic */ BizProductModel(String str, MoneyViewModel moneyViewModel, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, long j, Map map, MyBillsServiceModel myBillsServiceModel, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, moneyViewModel, str2, str3, str4, str5, z, str6, str7, j, map, (i & 2048) != 0 ? null : myBillsServiceModel, str8);
    }

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    @JvmName(name = "getDenom")
    public final MoneyViewModel getDenom() {
        return this.denom;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsTitle")
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getGoodsIconUrl")
    public final String getGoodsIconUrl() {
        return this.goodsIconUrl;
    }

    @JvmName(name = "isGoodsActive")
    public final boolean isGoodsActive() {
        return this.isGoodsActive;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "getTransactionDate")
    public final long getTransactionDate() {
        return this.transactionDate;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getServiceModel")
    public final MyBillsServiceModel getServiceModel() {
        return this.serviceModel;
    }

    @JvmName(name = "setServiceModel")
    public final void setServiceModel(MyBillsServiceModel myBillsServiceModel) {
        this.serviceModel = myBillsServiceModel;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }
}
