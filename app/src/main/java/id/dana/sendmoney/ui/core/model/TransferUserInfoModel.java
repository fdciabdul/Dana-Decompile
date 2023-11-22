package id.dana.sendmoney.ui.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.core.ui.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u00100\u001a\u00020\n\u0012\b\b\u0002\u00101\u001a\u00020\n\u0012\b\b\u0002\u00102\u001a\u00020\n\u0012\b\b\u0002\u00103\u001a\u00020\n\u0012\b\b\u0002\u00104\u001a\u00020\u0007\u0012\b\b\u0002\u00105\u001a\u00020\u001e\u0012\b\b\u0002\u00106\u001a\u00020\u001e\u0012\b\b\u0002\u00107\u001a\u00020\u001e\u0012\b\b\u0002\u00108\u001a\u00020\u001e\u0012\b\b\u0002\u00109\u001a\u00020\n\u0012\b\b\u0002\u0010:\u001a\u00020\n\u0012\b\b\u0002\u0010;\u001a\u00020\n\u0012\b\b\u0002\u0010<\u001a\u00020\n\u0012\b\b\u0002\u0010=\u001a\u00020\n\u0012\b\b\u0002\u0010>\u001a\u00020\n\u0012\b\b\u0002\u0010?\u001a\u00020\u0007\u0012\b\b\u0002\u0010@\u001a\u00020\u0007\u0012\b\b\u0002\u0010A\u001a\u00020\n\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u001e¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u000f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\f\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0011\u0010\u0019\u001a\u00020\u001eX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0011\u0010 \u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0011\u0010!\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0011\u0010#\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0011\u0010\"\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0011\u0010$\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0011\u0010%\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0011\u0010&\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b$\u0010\u001dR\u0011\u0010'\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b%\u0010\u001dR\u0011\u0010)\u001a\u00020\u001eX\u0007¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0011\u0010(\u001a\u00020\u001eX\u0007¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0011\u0010*\u001a\u00020\u001eX\u0007¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0011\u0010+\u001a\u00020\u001eX\u0007¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0011\u0010,\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b,\u0010\u001dR\u0011\u0010.\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b-\u0010\u001dR\u0011\u0010-\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b.\u0010\u001dR\u0011\u0010\u001b\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b+\u0010\u0018R\u0011\u0010/\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b*\u0010\u001d"}, d2 = {"Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)Ljava/lang/String;", "hashCode", "MyBillsEntityDataFactory", "()Z", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Z", "getAuthRequestContext", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda6", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lid/dana/core/ui/model/MoneyViewModel;", "Lid/dana/core/ui/model/MoneyViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "moveToNextValue", "lookAheadTest", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "PrepareContext", "FragmentBottomSheetPaymentSettingBinding", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/core/ui/model/MoneyViewModel;Lid/dana/core/ui/model/MoneyViewModel;Lid/dana/core/ui/model/MoneyViewModel;Lid/dana/core/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZLid/dana/core/ui/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TransferUserInfoModel implements Parcelable {
    public static final Parcelable.Creator<TransferUserInfoModel> CREATOR = new Creator();
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final MoneyViewModel initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MoneyViewModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final MoneyViewModel isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final MoneyViewModel DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    public TransferUserInfoModel() {
        this(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, null, false, null, 4194303, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TransferUserInfoModel) {
            TransferUserInfoModel transferUserInfoModel = (TransferUserInfoModel) p0;
            return Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, transferUserInfoModel.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.GetContactSyncConfig, transferUserInfoModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, transferUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.PrepareContext, transferUserInfoModel.PrepareContext) && Intrinsics.areEqual(this.scheduleImpl, transferUserInfoModel.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, transferUserInfoModel.moveToNextValue) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == transferUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 && Intrinsics.areEqual(this.getAuthRequestContext, transferUserInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.initRecordTimeStamp, transferUserInfoModel.initRecordTimeStamp) && Intrinsics.areEqual(this.isLayoutRequested, transferUserInfoModel.isLayoutRequested) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, transferUserInfoModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, transferUserInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, transferUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.newProxyInstance, transferUserInfoModel.newProxyInstance) && Intrinsics.areEqual(this.getErrorConfigVersion, transferUserInfoModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, transferUserInfoModel.lookAheadTest) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, transferUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && this.NetworkUserEntityData$$ExternalSyntheticLambda6 == transferUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda6 && this.MyBillsEntityDataFactory == transferUserInfoModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, transferUserInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && this.PlaceComponentResult == transferUserInfoModel.PlaceComponentResult && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, transferUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.FragmentBottomSheetPaymentSettingBinding.hashCode();
        int hashCode2 = this.GetContactSyncConfig.hashCode();
        int hashCode3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode();
        int hashCode4 = this.PrepareContext.hashCode();
        int hashCode5 = this.scheduleImpl.hashCode();
        int hashCode6 = this.moveToNextValue.hashCode();
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode7 = this.getAuthRequestContext.hashCode();
        int hashCode8 = this.initRecordTimeStamp.hashCode();
        int hashCode9 = this.isLayoutRequested.hashCode();
        int hashCode10 = this.DatabaseTableConfigUtil.hashCode();
        int hashCode11 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode12 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.hashCode();
        int hashCode13 = this.newProxyInstance.hashCode();
        int hashCode14 = this.getErrorConfigVersion.hashCode();
        int hashCode15 = this.lookAheadTest.hashCode();
        int hashCode16 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode();
        boolean z2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        boolean z3 = this.MyBillsEntityDataFactory;
        int i3 = z3 ? 1 : z3 ? 1 : 0;
        int hashCode17 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        boolean z4 = this.PlaceComponentResult;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        return (((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + i2) * 31) + i3) * 31) + hashCode17) * 31) + i4) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferUserInfoModel(FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.moveToNextValue);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
        p0.writeParcelable(this.getAuthRequestContext, p1);
        p0.writeParcelable(this.initRecordTimeStamp, p1);
        p0.writeParcelable(this.isLayoutRequested, p1);
        p0.writeParcelable(this.DatabaseTableConfigUtil, p1);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.newProxyInstance);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda6 ? 1 : 0);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeParcelable(this.NetworkUserEntityData$$ExternalSyntheticLambda8, p1);
    }

    public TransferUserInfoModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, MoneyViewModel moneyViewModel4, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3, String str13, boolean z4, MoneyViewModel moneyViewModel5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        Intrinsics.checkNotNullParameter(moneyViewModel3, "");
        Intrinsics.checkNotNullParameter(moneyViewModel4, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(moneyViewModel5, "");
        this.FragmentBottomSheetPaymentSettingBinding = str;
        this.GetContactSyncConfig = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str3;
        this.PrepareContext = str4;
        this.scheduleImpl = str5;
        this.moveToNextValue = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        this.getAuthRequestContext = moneyViewModel;
        this.initRecordTimeStamp = moneyViewModel2;
        this.isLayoutRequested = moneyViewModel3;
        this.DatabaseTableConfigUtil = moneyViewModel4;
        this.BuiltInFictitiousFunctionClassFactory = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str8;
        this.newProxyInstance = str9;
        this.getErrorConfigVersion = str10;
        this.lookAheadTest = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z2;
        this.MyBillsEntityDataFactory = z3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str13;
        this.PlaceComponentResult = z4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = moneyViewModel5;
    }

    public /* synthetic */ TransferUserInfoModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, MoneyViewModel moneyViewModel4, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3, String str13, boolean z4, MoneyViewModel moneyViewModel5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? false : z, (i & 128) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel, (i & 256) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel2, (i & 512) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel3, (i & 1024) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel4, (i & 2048) != 0 ? "" : str7, (i & 4096) != 0 ? "" : str8, (i & 8192) != 0 ? "" : str9, (i & 16384) != 0 ? "" : str10, (i & 32768) != 0 ? "" : str11, (i & 65536) != 0 ? "" : str12, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z2, (i & 262144) != 0 ? false : z3, (i & 524288) != 0 ? "" : str13, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? false : z4, (i & 2097152) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel5);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.FragmentBottomSheetPaymentSettingBinding.length() > 0;
    }

    public final String BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        return (((this.NetworkUserEntityData$$ExternalSyntheticLambda2.length() > 0) && p1) || StringsKt.contains$default((CharSequence) p0, (CharSequence) "*", false, 2, (Object) null)) ? this.NetworkUserEntityData$$ExternalSyntheticLambda2 : p0;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TransferUserInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TransferUserInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new TransferUserInfoModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (MoneyViewModel) parcel.readParcelable(TransferUserInfoModel.class.getClassLoader()), (MoneyViewModel) parcel.readParcelable(TransferUserInfoModel.class.getClassLoader()), (MoneyViewModel) parcel.readParcelable(TransferUserInfoModel.class.getClassLoader()), (MoneyViewModel) parcel.readParcelable(TransferUserInfoModel.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, (MoneyViewModel) parcel.readParcelable(TransferUserInfoModel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TransferUserInfoModel[] newArray(int i) {
            return new TransferUserInfoModel[i];
        }
    }
}
