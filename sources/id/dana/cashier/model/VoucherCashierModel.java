package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.data.util.NumberUtils;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.sendmoney.model.CouponPayMethodInfoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\"\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010%\u0012\b\u00107\u001a\u0004\u0018\u00010\u000b\u0012\b\u00108\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010>\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010@\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\b\u0010D\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0010J\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\rJ'\u0010\f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0015¢\u0006\u0004\b\u0014\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010%X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010$R\u0013\u0010'\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010$R\u0019\u0010+\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b'\u0010!R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b+\u0010,R\u0013\u0010.\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b-\u0010!R\u0013\u0010-\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b/\u0010!R\u0013\u0010/\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b0\u0010$R\u001a\u00100\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\u0014\u0010\u0010R\u001a\u00101\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b.\u00102\u001a\u0004\b'\u0010\u0010R\u0013\u00103\u001a\u0004\u0018\u00010\u0015X\u0007¢\u0006\u0006\n\u0004\b3\u0010!R\u0013\u00105\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b4\u0010$R\u0013\u00106\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b6\u0010#"}, d2 = {"Lid/dana/cashier/model/VoucherCashierModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "()Z", "getAuthRequestContext", "lookAheadTest", "getErrorConfigVersion", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p1", "p2", "(Ljava/lang/String;JZ)Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(J)Z", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Ljava/lang/String;", "Lid/dana/cashier/model/CouponCashierModel;", "Lid/dana/cashier/model/CouponCashierModel;", "scheduleImpl", "", "Lid/dana/sendmoney/model/CouponPayMethodInfoModel;", "Ljava/util/List;", "moveToNextValue", "Ljava/lang/Boolean;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "Z", "isLayoutRequested", "PrepareContext", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(Ljava/lang/Long;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/cashier/model/CouponCashierModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VoucherCashierModel implements Parcelable {
    public static final Parcelable.Creator<VoucherCashierModel> CREATOR = new Creator();
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final Long NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CouponCashierModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MoneyViewModel PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final Long initRecordTimeStamp;
    public final MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Long MyBillsEntityDataFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<CouponPayMethodInfoModel> moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public boolean DatabaseTableConfigUtil;
    public final Long isLayoutRequested;
    public String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Long getErrorConfigVersion;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof VoucherCashierModel) {
            VoucherCashierModel voucherCashierModel = (VoucherCashierModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, voucherCashierModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, voucherCashierModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, voucherCashierModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, voucherCashierModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, voucherCashierModel.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, voucherCashierModel.moveToNextValue) && Intrinsics.areEqual(this.getErrorConfigVersion, voucherCashierModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.initRecordTimeStamp, voucherCashierModel.initRecordTimeStamp) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.GetContactSyncConfig, voucherCashierModel.GetContactSyncConfig) && Intrinsics.areEqual(this.isLayoutRequested, voucherCashierModel.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.lookAheadTest, voucherCashierModel.lookAheadTest) && this.DatabaseTableConfigUtil == voucherCashierModel.DatabaseTableConfigUtil && this.NetworkUserEntityData$$ExternalSyntheticLambda1 == voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda1 && Intrinsics.areEqual(this.newProxyInstance, voucherCashierModel.newProxyInstance) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, voucherCashierModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.MyBillsEntityDataFactory;
        int hashCode = l == null ? 0 : l.hashCode();
        MoneyViewModel moneyViewModel = this.PlaceComponentResult;
        int hashCode2 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        CouponCashierModel couponCashierModel = this.getAuthRequestContext;
        int hashCode3 = couponCashierModel == null ? 0 : couponCashierModel.hashCode();
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.scheduleImpl;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        int hashCode6 = list == null ? 0 : list.hashCode();
        Long l2 = this.getErrorConfigVersion;
        int hashCode7 = l2 == null ? 0 : l2.hashCode();
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode8 = bool == null ? 0 : bool.hashCode();
        Long l3 = this.initRecordTimeStamp;
        int hashCode9 = l3 == null ? 0 : l3.hashCode();
        Long l4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode10 = l4 == null ? 0 : l4.hashCode();
        String str3 = this.GetContactSyncConfig;
        int hashCode11 = str3 == null ? 0 : str3.hashCode();
        Long l5 = this.isLayoutRequested;
        int hashCode12 = l5 == null ? 0 : l5.hashCode();
        MoneyViewModel moneyViewModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode13 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str4 = this.lookAheadTest;
        int hashCode14 = str4 == null ? 0 : str4.hashCode();
        boolean z = this.DatabaseTableConfigUtil;
        int i = z ? 1 : z ? 1 : 0;
        boolean z2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        String str5 = this.newProxyInstance;
        int hashCode15 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + i) * 31) + i2) * 31) + hashCode15) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VoucherCashierModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Long l = this.MyBillsEntityDataFactory;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        MoneyViewModel moneyViewModel = this.PlaceComponentResult;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        CouponCashierModel couponCashierModel = this.getAuthRequestContext;
        if (couponCashierModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            couponCashierModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.scheduleImpl);
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<CouponPayMethodInfoModel> it = list.iterator();
            while (it.hasNext()) {
                p0.writeParcelable(it.next(), p1);
            }
        }
        Long l2 = this.getErrorConfigVersion;
        if (l2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l2.longValue());
        }
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l3 = this.initRecordTimeStamp;
        if (l3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l3.longValue());
        }
        Long l4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (l4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l4.longValue());
        }
        p0.writeString(this.GetContactSyncConfig);
        Long l5 = this.isLayoutRequested;
        if (l5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l5.longValue());
        }
        MoneyViewModel moneyViewModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        p0.writeString(this.lookAheadTest);
        p0.writeInt(this.DatabaseTableConfigUtil ? 1 : 0);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? 1 : 0);
        p0.writeString(this.newProxyInstance);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoucherCashierModel(Long l, MoneyViewModel moneyViewModel, CouponCashierModel couponCashierModel, String str, String str2, List<? extends CouponPayMethodInfoModel> list, Long l2, Boolean bool, Long l3, Long l4, String str3, Long l5, MoneyViewModel moneyViewModel2, String str4, boolean z, boolean z2, String str5, String str6) {
        this.MyBillsEntityDataFactory = l;
        this.PlaceComponentResult = moneyViewModel;
        this.getAuthRequestContext = couponCashierModel;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.scheduleImpl = str2;
        this.moveToNextValue = list;
        this.getErrorConfigVersion = l2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bool;
        this.initRecordTimeStamp = l3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = l4;
        this.GetContactSyncConfig = str3;
        this.isLayoutRequested = l5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = moneyViewModel2;
        this.lookAheadTest = str4;
        this.DatabaseTableConfigUtil = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z2;
        this.newProxyInstance = str5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str6;
    }

    public /* synthetic */ VoucherCashierModel(Long l, MoneyViewModel moneyViewModel, CouponCashierModel couponCashierModel, String str, String str2, List list, Long l2, Boolean bool, Long l3, Long l4, String str3, Long l5, MoneyViewModel moneyViewModel2, String str4, boolean z, boolean z2, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, moneyViewModel, couponCashierModel, str, str2, list, l2, bool, l3, l4, str3, l5, moneyViewModel2, (i & 8192) != 0 ? "" : str4, (i & 16384) != 0 ? false : z, (32768 & i) != 0 ? true : z2, str5, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str6);
    }

    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final boolean getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public static /* synthetic */ CurrencyAmountModel BuiltInFictitiousFunctionClassFactory(VoucherCashierModel voucherCashierModel, String str, boolean z, String str2, int i) {
        Object obj;
        CurrencyAmountModel currencyAmountModel;
        boolean areEqual;
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            voucherCashierModel.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
        List<CouponPayMethodInfoModel> list = voucherCashierModel.moveToNextValue;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) obj;
                String str3 = voucherCashierModel.KClassImpl$Data$declaredNonStaticMembers$2;
                boolean z2 = true;
                if (str3 == null || str3.length() == 0) {
                    areEqual = Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE");
                } else {
                    String str4 = couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory;
                    if (str4 == null || str4.length() == 0) {
                        areEqual = Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, str2);
                    } else {
                        String str5 = voucherCashierModel.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (str5 != null && str5.length() != 0) {
                            z2 = false;
                        }
                        if (z2) {
                            areEqual = Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "ONLINE_CREDIT");
                        } else {
                            areEqual = Intrinsics.areEqual(couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory, voucherCashierModel.KClassImpl$Data$declaredNonStaticMembers$2);
                        }
                    }
                }
                if (areEqual) {
                    break;
                }
            }
            CouponPayMethodInfoModel couponPayMethodInfoModel2 = (CouponPayMethodInfoModel) obj;
            if (couponPayMethodInfoModel2 != null && (currencyAmountModel = couponPayMethodInfoModel2.lookAheadTest) != null) {
                return currencyAmountModel;
            }
        }
        MoneyViewModel moneyViewModel = voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (moneyViewModel != null) {
            MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
            return MoneyViewModel.Companion.PlaceComponentResult(moneyViewModel);
        }
        return null;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") && Intrinsics.areEqual(couponPayMethodInfoModel.MyBillsEntityDataFactory, "BALANCE") && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean MyBillsEntityDataFactory() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") && Intrinsics.areEqual(couponPayMethodInfoModel.MyBillsEntityDataFactory, "BALANCE") && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory() && couponPayMethodInfoModel.MyBillsEntityDataFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean PlaceComponentResult() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") && Intrinsics.areEqual(couponPayMethodInfoModel.MyBillsEntityDataFactory, PayMethod.BALANCE_FAMILY) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean getAuthRequestContext() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") && Intrinsics.areEqual(couponPayMethodInfoModel.MyBillsEntityDataFactory, PayMethod.BALANCE_FAMILY) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory() && couponPayMethodInfoModel.MyBillsEntityDataFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean MyBillsEntityDataFactory(String p0) {
        if (p0 == null) {
            return false;
        }
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory, p0) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        if (p0 == null) {
            return false;
        }
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory, p0) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory() && couponPayMethodInfoModel.MyBillsEntityDataFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if ((Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") || Intrinsics.areEqual(couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory, p0)) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if (Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, PayMethod.LOAN_CREDIT) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean lookAheadTest() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if ((Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") || Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, PayMethod.LOAN_CREDIT)) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean MyBillsEntityDataFactory(String p0, long p1, boolean p2) {
        Object obj = null;
        if (p2) {
            if (KClassImpl$Data$declaredNonStaticMembers$2(p1)) {
                return false;
            }
            List<CouponPayMethodInfoModel> list = this.moveToNextValue;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                    if (Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") || Intrinsics.areEqual(couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory, p0)) {
                        obj = next;
                        break;
                    }
                }
                obj = (CouponPayMethodInfoModel) obj;
            }
            if (obj == null) {
                return false;
            }
        } else {
            List<CouponPayMethodInfoModel> list2 = this.moveToNextValue;
            if (list2 != null) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    CouponPayMethodInfoModel couponPayMethodInfoModel2 = (CouponPayMethodInfoModel) next2;
                    if ((Intrinsics.areEqual(couponPayMethodInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") || Intrinsics.areEqual(couponPayMethodInfoModel2.BuiltInFictitiousFunctionClassFactory, p0)) && couponPayMethodInfoModel2.BuiltInFictitiousFunctionClassFactory() && couponPayMethodInfoModel2.MyBillsEntityDataFactory()) {
                        obj = next2;
                        break;
                    }
                }
                obj = (CouponPayMethodInfoModel) obj;
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean getErrorConfigVersion() {
        List<CouponPayMethodInfoModel> list = this.moveToNextValue;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CouponPayMethodInfoModel couponPayMethodInfoModel = (CouponPayMethodInfoModel) next;
                if ((Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, "BALANCE") || Intrinsics.areEqual(couponPayMethodInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, PayMethod.LOAN_CREDIT)) && couponPayMethodInfoModel.BuiltInFictitiousFunctionClassFactory() && couponPayMethodInfoModel.MyBillsEntityDataFactory()) {
                    obj = next;
                    break;
                }
            }
            obj = (CouponPayMethodInfoModel) obj;
        }
        return obj != null;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
        CurrencyAmountModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this, null, false, null, 7);
        String cleanAll = BuiltInFictitiousFunctionClassFactory != null ? NumberUtils.getCleanAll(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) : null;
        if (cleanAll == null) {
            cleanAll = "0";
        }
        return Math.abs(p0) - NumberExtKt.toSafeLong$default(cleanAll, 0L, 1, (Object) null) < 10000;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<VoucherCashierModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VoucherCashierModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            CouponCashierModel createFromParcel2 = parcel.readInt() == 0 ? null : CouponCashierModel.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(parcel.readParcelable(VoucherCashierModel.class.getClassLoader()));
                }
            }
            return new VoucherCashierModel(valueOf, createFromParcel, createFromParcel2, readString, readString2, arrayList, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? MoneyViewModel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VoucherCashierModel[] newArray(int i) {
            return new VoucherCashierModel[i];
        }
    }
}
