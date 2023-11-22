package id.dana.cashier;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.Risk3dsAdditionalDataModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 C2\u00020\u0001:\u0001CBÅ\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u00105\u001a\u00020\u000e\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010+\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\n\u001a\u00020\u000e¢\u0006\u0004\b\n\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u001cX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010 \u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010\"\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b$\u0010\u001bR\u0013\u0010$\u001a\u0004\u0018\u00010%X\u0006¢\u0006\u0006\n\u0004\b\"\u0010&R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'X\u0006¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u001dR\u0016\u0010(\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00101R\u0016\u0010.\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00103"}, d2 = {"Lid/dana/cashier/RiskParamsFactory;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/os/Bundle;", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Landroid/os/Bundle;", "PlaceComponentResult", "()Ljava/lang/String;", "", "()Z", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/domain/useragreement/model/AgreementInfo;", "MyBillsEntityDataFactory", "Lid/dana/domain/useragreement/model/AgreementInfo;", "Lid/dana/cashier/model/AttributeCashierPayModel;", "Lid/dana/cashier/model/AttributeCashierPayModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Ljava/lang/Integer;", "scheduleImpl", "getErrorConfigVersion", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "lookAheadTest", "Lid/dana/cashier/model/PayResultModel;", "Lid/dana/cashier/model/PayResultModel;", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/util/List;", "DatabaseTableConfigUtil", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "[Ljava/lang/String;", "GetContactSyncConfig", "initRecordTimeStamp", "Lid/dana/cashier/model/VoucherCashierModel;", "Lid/dana/cashier/model/VoucherCashierModel;", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Lid/dana/cashier/model/AttributeCashierPayModel;Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;ZLid/dana/cashier/model/VoucherCashierModel;Lid/dana/cashier/model/PayResultModel;[Ljava/lang/String;Lid/dana/cashier/model/TopUpVerifyRequestModel;Ljava/lang/Integer;Lid/dana/domain/useragreement/model/AgreementInfo;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RiskParamsFactory implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final VoucherCashierModel NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final CashierPayMethodModel initRecordTimeStamp;
    public final AttributeCashierPayModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final AgreementInfo PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final PayResultModel lookAheadTest;
    public final String[] NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final List<String> DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Integer BuiltInFictitiousFunctionClassFactory;
    public final CashierPayMethodModel getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final TopUpVerifyRequestModel GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;
    public final String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String getErrorConfigVersion;
    public static final Parcelable.Creator<RiskParamsFactory> CREATOR = new Creator();

    public RiskParamsFactory() {
        this(null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        AttributeCashierPayModel attributeCashierPayModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            attributeCashierPayModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeParcelable(this.getAuthRequestContext, p1);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
        VoucherCashierModel voucherCashierModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (voucherCashierModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            voucherCashierModel.writeToParcel(p0, p1);
        }
        PayResultModel payResultModel = this.lookAheadTest;
        if (payResultModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            payResultModel.writeToParcel(p0, p1);
        }
        p0.writeStringArray(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        TopUpVerifyRequestModel topUpVerifyRequestModel = this.GetContactSyncConfig;
        if (topUpVerifyRequestModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            topUpVerifyRequestModel.writeToParcel(p0, p1);
        }
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        p0.writeParcelable(this.PlaceComponentResult, p1);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.moveToNextValue);
        p0.writeParcelable(this.initRecordTimeStamp, p1);
        p0.writeString(this.scheduleImpl);
        p0.writeStringList(this.DatabaseTableConfigUtil);
    }

    public RiskParamsFactory(AttributeCashierPayModel attributeCashierPayModel, String str, CashierPayMethodModel cashierPayMethodModel, boolean z, VoucherCashierModel voucherCashierModel, PayResultModel payResultModel, String[] strArr, TopUpVerifyRequestModel topUpVerifyRequestModel, Integer num, AgreementInfo agreementInfo, String str2, String str3, CashierPayMethodModel cashierPayMethodModel2, String str4, List<String> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = attributeCashierPayModel;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = cashierPayMethodModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = voucherCashierModel;
        this.lookAheadTest = payResultModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = strArr;
        this.GetContactSyncConfig = topUpVerifyRequestModel;
        this.BuiltInFictitiousFunctionClassFactory = num;
        this.PlaceComponentResult = agreementInfo;
        this.getErrorConfigVersion = str2;
        this.moveToNextValue = str3;
        this.initRecordTimeStamp = cashierPayMethodModel2;
        this.scheduleImpl = str4;
        this.DatabaseTableConfigUtil = list;
    }

    public /* synthetic */ RiskParamsFactory(AttributeCashierPayModel attributeCashierPayModel, String str, CashierPayMethodModel cashierPayMethodModel, boolean z, VoucherCashierModel voucherCashierModel, PayResultModel payResultModel, String[] strArr, TopUpVerifyRequestModel topUpVerifyRequestModel, Integer num, AgreementInfo agreementInfo, String str2, String str3, CashierPayMethodModel cashierPayMethodModel2, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : attributeCashierPayModel, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : cashierPayMethodModel, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : voucherCashierModel, (i & 32) != 0 ? null : payResultModel, (i & 64) != 0 ? null : strArr, (i & 128) != 0 ? null : topUpVerifyRequestModel, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : agreementInfo, (i & 1024) != 0 ? null : str2, (i & 2048) != 0 ? null : str3, (i & 4096) != 0 ? null : cashierPayMethodModel2, (i & 8192) != 0 ? null : str4, (i & 16384) == 0 ? list : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x002d, code lost:
    
        if (r10 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x002f, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x003c, code lost:
    
        if (r10 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x003e, code lost:
    
        r10 = r0;
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle getAuthRequestContext(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.RiskParamsFactory.getAuthRequestContext(java.lang.String):android.os.Bundle");
    }

    public final boolean getAuthRequestContext() {
        AttributeCashierPayModel attributeCashierPayModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (Intrinsics.areEqual(attributeCashierPayModel != null ? attributeCashierPayModel.O : null, "redirect")) {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2.S;
            return !(str == null || str.length() == 0);
        }
        return false;
    }

    public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        List<Risk3dsAdditionalDataModel> list;
        Bundle bundle = new Bundle();
        AttributeCashierPayModel attributeCashierPayModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        List list2 = null;
        bundle.putString(CashierKeyParams.REDIRECT_URL, attributeCashierPayModel != null ? attributeCashierPayModel.S : null);
        AttributeCashierPayModel attributeCashierPayModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        bundle.putString(CashierKeyParams.REDIRECT_URL_PARAM, String.valueOf(attributeCashierPayModel2 != null ? attributeCashierPayModel2.AppCompatEmojiTextHelper : null));
        AttributeCashierPayModel attributeCashierPayModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        bundle.putString(CashierKeyParams.HTTP_METHOD, attributeCashierPayModel3 != null ? attributeCashierPayModel3.NetworkUserEntityData$$ExternalSyntheticLambda2 : null);
        bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, this.MyBillsEntityDataFactory);
        AttributeCashierPayModel attributeCashierPayModel4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        bundle.putString("contentType", attributeCashierPayModel4 != null ? attributeCashierPayModel4.moveToNextValue : null);
        TopUpVerifyRequestModel topUpVerifyRequestModel = this.GetContactSyncConfig;
        bundle.putString(CashierKeyParams.TOP_UP_ORDER_ID, topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null);
        AttributeCashierPayModel attributeCashierPayModel5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel5 != null && (list = attributeCashierPayModel5.R) != null) {
            list2 = CollectionsKt.toMutableList((Collection) list);
        }
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        bundle.putParcelableArrayList(CashierKeyParams.RISK_3DS_ADDITIONAL_DATA, new ArrayList<>(list2));
        return bundle;
    }

    public final String PlaceComponentResult() {
        List<RiskVerificationMethodModel> list;
        RiskVerificationMethodModel riskVerificationMethodModel;
        AttributeCashierPayModel attributeCashierPayModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel == null || (list = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1) == null || (riskVerificationMethodModel = (RiskVerificationMethodModel) CollectionsKt.getOrNull(list, 1)) == null) {
            return null;
        }
        return riskVerificationMethodModel.scheduleImpl;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<RiskParamsFactory> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RiskParamsFactory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new RiskParamsFactory(parcel.readInt() == 0 ? null : AttributeCashierPayModel.CREATOR.createFromParcel(parcel), parcel.readString(), (CashierPayMethodModel) parcel.readParcelable(RiskParamsFactory.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() == 0 ? null : VoucherCashierModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PayResultModel.CREATOR.createFromParcel(parcel), parcel.createStringArray(), parcel.readInt() == 0 ? null : TopUpVerifyRequestModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, (AgreementInfo) parcel.readParcelable(RiskParamsFactory.class.getClassLoader()), parcel.readString(), parcel.readString(), (CashierPayMethodModel) parcel.readParcelable(RiskParamsFactory.class.getClassLoader()), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RiskParamsFactory[] newArray(int i) {
            return new RiskParamsFactory[i];
        }
    }
}
