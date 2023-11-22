package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.payasset.model.Institution;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010;\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010;\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bm\u0010nJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0013\u0010!\u001a\u0004\u0018\u00010 X\u0006¢\u0006\u0006\n\u0004\b!\u0010\"R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0013\u0010$\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0013\u0010%\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u0013\u0010'\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0013\u0010#\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0013\u0010&\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0013\u0010)\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b(\u0010\u0018R\u0013\u0010*\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b*\u0010\u0018R\u0013\u0010(\u001a\u0004\u0018\u00010+X\u0006¢\u0006\u0006\n\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b.\u0010\u0018R\u0013\u0010,\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b)\u0010\u0018R\u0013\u0010/\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b/\u0010\u0018R\u0013\u00101\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b0\u0010\u001aR\u0013\u00102\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b1\u0010\u001dR\u0013\u00105\u001a\u0004\u0018\u000103X\u0006¢\u0006\u0006\n\u0004\b2\u00104R\u0013\u00100\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b5\u0010\u0018R\u0013\u00107\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b6\u0010\u0018R\u0013\u00106\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b8\u0010\u001dR\u0013\u00109\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b9\u0010\u0018R\u0013\u0010:\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b:\u0010\u0018R\u0019\u00108\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010;X\u0006¢\u0006\u0006\n\u0004\b7\u0010<R\u0013\u0010>\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b=\u0010\u001aR\u0013\u0010?\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b>\u0010\u0018R\u0013\u0010A\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b@\u0010\u001aR\u0013\u0010=\u001a\u0004\u0018\u00010BX\u0006¢\u0006\u0006\n\u0004\bA\u0010CR\u0013\u0010@\u001a\u0004\u0018\u000103X\u0006¢\u0006\u0006\n\u0004\b?\u00104R\u0013\u0010E\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\bD\u0010\u0018R\u0019\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010;X\u0006¢\u0006\u0006\n\u0004\bF\u0010<R\u0013\u0010H\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\bH\u0010\u0018"}, d2 = {"Lid/dana/cashier/model/AssetCardModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "lookAheadTest", "scheduleImpl", "Ljava/lang/Integer;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "moveToNextValue", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "Lid/dana/cashier/model/ExtendCashierModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/model/ExtendCashierModel;", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda5", "", "Ljava/lang/Long;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "SubSequence", "getCallingPid", "readMicros", "getSupportButtonTintMode", "whenAvailable", "", "Ljava/util/List;", "VerifyPinStateManager$executeRiskChallenge$2$1", "C", "BottomSheetCardBindingView$watcherCardNumberView$1", DiskFormatter.B, "A", "Lid/dana/cashier/model/RemainingCardLimitAmountModel;", "Lid/dana/cashier/model/RemainingCardLimitAmountModel;", SummaryActivity.DAYS, "getOnBoardingScenario", "getValueOfTouchPositionAbsolute", "E", "VerifyPinStateManager$executeRiskChallenge$2$2", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28", "p29", "p30", "p31", "p32", "p33", "p34", "p35", "p36", "p37", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/cashier/model/DailyLimitAmountConfModel;Ljava/lang/Boolean;Lid/dana/cashier/model/ExtendCashierModel;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/model/RemainingCardLimitAmountModel;Ljava/lang/Long;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AssetCardModel implements Parcelable {
    public static final Parcelable.Creator<AssetCardModel> CREATOR = new Creator();

    /* renamed from: A  reason: from kotlin metadata */
    public final RemainingCardLimitAmountModel VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: B  reason: from kotlin metadata */
    public final Boolean A;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    public final Long B;
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: C  reason: from kotlin metadata */
    public final String BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: D  reason: from kotlin metadata */
    public final String getOnBoardingScenario;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    final String initRecordTimeStamp;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public final Integer NetworkUserEntityData$$ExternalSyntheticLambda5;
    public final String GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    final Boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final Boolean DatabaseTableConfigUtil;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    final Boolean FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public final Long NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final ExtendCashierModel newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String PrepareContext;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    public final String getCallingPid;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    public final Boolean C;
    public final String VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    public final List<String> readMicros;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final Boolean lookAheadTest;
    public final String getSupportButtonTintMode;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    public final List<String> E;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final String isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;
    public final DailyLimitAmountConfModel moveToNextValue;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: readMicros  reason: from kotlin metadata */
    public final Integer SubSequence;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Integer getErrorConfigVersion;
    public final String whenAvailable;

    public AssetCardModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 63, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof AssetCardModel) {
            AssetCardModel assetCardModel = (AssetCardModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, assetCardModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, assetCardModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, assetCardModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, assetCardModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, assetCardModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, assetCardModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, assetCardModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.GetContactSyncConfig, assetCardModel.GetContactSyncConfig) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, assetCardModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, assetCardModel.initRecordTimeStamp) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.isLayoutRequested, assetCardModel.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda3, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda3) && Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, assetCardModel.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda4) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda6, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda6) && Intrinsics.areEqual(this.getCallingPid, assetCardModel.getCallingPid) && Intrinsics.areEqual(this.SubSequence, assetCardModel.SubSequence) && Intrinsics.areEqual(this.getSupportButtonTintMode, assetCardModel.getSupportButtonTintMode) && Intrinsics.areEqual(this.whenAvailable, assetCardModel.whenAvailable) && Intrinsics.areEqual(this.readMicros, assetCardModel.readMicros) && Intrinsics.areEqual(this.BottomSheetCardBindingView$watcherCardNumberView$1, assetCardModel.BottomSheetCardBindingView$watcherCardNumberView$1) && Intrinsics.areEqual(this.A, assetCardModel.A) && Intrinsics.areEqual(this.getOnBoardingScenario, assetCardModel.getOnBoardingScenario) && Intrinsics.areEqual(this.E, assetCardModel.E) && Intrinsics.areEqual(this.VerifyPinStateManager$executeRiskChallenge$2$2, assetCardModel.VerifyPinStateManager$executeRiskChallenge$2$2) && Intrinsics.areEqual(this.moveToNextValue, assetCardModel.moveToNextValue) && Intrinsics.areEqual(this.lookAheadTest, assetCardModel.lookAheadTest) && Intrinsics.areEqual(this.newProxyInstance, assetCardModel.newProxyInstance) && Intrinsics.areEqual(this.PrepareContext, assetCardModel.PrepareContext) && Intrinsics.areEqual(this.C, assetCardModel.C) && Intrinsics.areEqual(this.VerifyPinStateManager$executeRiskChallenge$2$1, assetCardModel.VerifyPinStateManager$executeRiskChallenge$2$1) && Intrinsics.areEqual(this.B, assetCardModel.B) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda5);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.MyBillsEntityDataFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.PlaceComponentResult;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.scheduleImpl;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        Integer num = this.getErrorConfigVersion;
        int hashCode7 = num == null ? 0 : num.hashCode();
        String str6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        Boolean bool2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode9 = bool2 == null ? 0 : bool2.hashCode();
        String str7 = this.GetContactSyncConfig;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        Boolean bool3 = this.DatabaseTableConfigUtil;
        int hashCode11 = bool3 == null ? 0 : bool3.hashCode();
        String str8 = this.initRecordTimeStamp;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        Boolean bool4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode13 = bool4 == null ? 0 : bool4.hashCode();
        String str9 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode14 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.isLayoutRequested;
        int hashCode15 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode16 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int hashCode17 = str12 == null ? 0 : str12.hashCode();
        Boolean bool5 = this.FragmentBottomSheetPaymentSettingBinding;
        int hashCode18 = bool5 == null ? 0 : bool5.hashCode();
        String str13 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int hashCode19 = str13 == null ? 0 : str13.hashCode();
        Long l = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int hashCode20 = l == null ? 0 : l.hashCode();
        String str14 = this.getCallingPid;
        int hashCode21 = str14 == null ? 0 : str14.hashCode();
        Integer num2 = this.SubSequence;
        int hashCode22 = num2 == null ? 0 : num2.hashCode();
        String str15 = this.getSupportButtonTintMode;
        int hashCode23 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.whenAvailable;
        int hashCode24 = str16 == null ? 0 : str16.hashCode();
        List<String> list = this.readMicros;
        int hashCode25 = list == null ? 0 : list.hashCode();
        String str17 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        int hashCode26 = str17 == null ? 0 : str17.hashCode();
        Boolean bool6 = this.A;
        int hashCode27 = bool6 == null ? 0 : bool6.hashCode();
        String str18 = this.getOnBoardingScenario;
        int hashCode28 = str18 == null ? 0 : str18.hashCode();
        List<String> list2 = this.E;
        int hashCode29 = list2 == null ? 0 : list2.hashCode();
        String str19 = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        int hashCode30 = str19 == null ? 0 : str19.hashCode();
        DailyLimitAmountConfModel dailyLimitAmountConfModel = this.moveToNextValue;
        int hashCode31 = dailyLimitAmountConfModel == null ? 0 : dailyLimitAmountConfModel.hashCode();
        Boolean bool7 = this.lookAheadTest;
        int hashCode32 = bool7 == null ? 0 : bool7.hashCode();
        ExtendCashierModel extendCashierModel = this.newProxyInstance;
        int hashCode33 = extendCashierModel == null ? 0 : extendCashierModel.hashCode();
        String str20 = this.PrepareContext;
        int hashCode34 = str20 == null ? 0 : str20.hashCode();
        Boolean bool8 = this.C;
        int hashCode35 = bool8 == null ? 0 : bool8.hashCode();
        RemainingCardLimitAmountModel remainingCardLimitAmountModel = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        int hashCode36 = remainingCardLimitAmountModel == null ? 0 : remainingCardLimitAmountModel.hashCode();
        Long l2 = this.B;
        int hashCode37 = l2 == null ? 0 : l2.hashCode();
        Integer num3 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetCardModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda3=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        sb.append(", FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", getCallingPid=");
        sb.append(this.getCallingPid);
        sb.append(", SubSequence=");
        sb.append(this.SubSequence);
        sb.append(", getSupportButtonTintMode=");
        sb.append(this.getSupportButtonTintMode);
        sb.append(", whenAvailable=");
        sb.append(this.whenAvailable);
        sb.append(", readMicros=");
        sb.append(this.readMicros);
        sb.append(", BottomSheetCardBindingView$watcherCardNumberView$1=");
        sb.append(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        sb.append(", A=");
        sb.append(this.A);
        sb.append(", getOnBoardingScenario=");
        sb.append(this.getOnBoardingScenario);
        sb.append(", E=");
        sb.append(this.E);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$2=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", C=");
        sb.append(this.C);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$1=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        sb.append(", B=");
        sb.append(this.B);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda5=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Boolean bool = this.PlaceComponentResult;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.scheduleImpl);
        Integer num = this.getErrorConfigVersion;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        Boolean bool2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.GetContactSyncConfig);
        Boolean bool3 = this.DatabaseTableConfigUtil;
        if (bool3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.initRecordTimeStamp);
        Boolean bool4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (bool4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        Boolean bool5 = this.FragmentBottomSheetPaymentSettingBinding;
        if (bool5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        Long l = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        p0.writeString(this.getCallingPid);
        Integer num2 = this.SubSequence;
        if (num2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num2.intValue());
        }
        p0.writeString(this.getSupportButtonTintMode);
        p0.writeString(this.whenAvailable);
        p0.writeStringList(this.readMicros);
        p0.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        Boolean bool6 = this.A;
        if (bool6 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.getOnBoardingScenario);
        p0.writeStringList(this.E);
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        DailyLimitAmountConfModel dailyLimitAmountConfModel = this.moveToNextValue;
        if (dailyLimitAmountConfModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            dailyLimitAmountConfModel.writeToParcel(p0, p1);
        }
        Boolean bool7 = this.lookAheadTest;
        if (bool7 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        ExtendCashierModel extendCashierModel = this.newProxyInstance;
        if (extendCashierModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            extendCashierModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.PrepareContext);
        Boolean bool8 = this.C;
        if (bool8 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool8.booleanValue() ? 1 : 0);
        }
        RemainingCardLimitAmountModel remainingCardLimitAmountModel = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (remainingCardLimitAmountModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            remainingCardLimitAmountModel.writeToParcel(p0, p1);
        }
        Long l2 = this.B;
        if (l2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l2.longValue());
        }
        Integer num3 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (num3 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(num3.intValue());
    }

    public AssetCardModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Integer num, String str6, Boolean bool2, String str7, Boolean bool3, String str8, Boolean bool4, String str9, String str10, String str11, String str12, Boolean bool5, String str13, Long l, String str14, Integer num2, String str15, String str16, List<String> list, String str17, Boolean bool6, String str18, List<String> list2, String str19, DailyLimitAmountConfModel dailyLimitAmountConfModel, Boolean bool7, ExtendCashierModel extendCashierModel, String str20, Boolean bool8, RemainingCardLimitAmountModel remainingCardLimitAmountModel, Long l2, Integer num3) {
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.PlaceComponentResult = bool;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.scheduleImpl = str5;
        this.getErrorConfigVersion = num;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bool2;
        this.GetContactSyncConfig = str7;
        this.DatabaseTableConfigUtil = bool3;
        this.initRecordTimeStamp = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = bool4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str9;
        this.isLayoutRequested = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str12;
        this.FragmentBottomSheetPaymentSettingBinding = bool5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = l;
        this.getCallingPid = str14;
        this.SubSequence = num2;
        this.getSupportButtonTintMode = str15;
        this.whenAvailable = str16;
        this.readMicros = list;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = str17;
        this.A = bool6;
        this.getOnBoardingScenario = str18;
        this.E = list2;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = str19;
        this.moveToNextValue = dailyLimitAmountConfModel;
        this.lookAheadTest = bool7;
        this.newProxyInstance = extendCashierModel;
        this.PrepareContext = str20;
        this.C = bool8;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = remainingCardLimitAmountModel;
        this.B = l2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = num3;
    }

    public /* synthetic */ AssetCardModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Integer num, String str6, Boolean bool2, String str7, Boolean bool3, String str8, Boolean bool4, String str9, String str10, String str11, String str12, Boolean bool5, String str13, Long l, String str14, Integer num2, String str15, String str16, List list, String str17, Boolean bool6, String str18, List list2, String str19, DailyLimitAmountConfModel dailyLimitAmountConfModel, Boolean bool7, ExtendCashierModel extendCashierModel, String str20, Boolean bool8, RemainingCardLimitAmountModel remainingCardLimitAmountModel, Long l2, Integer num3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : bool3, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : bool4, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (i & 32768) != 0 ? null : str11, (i & 65536) != 0 ? null : str12, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : bool5, (i & 262144) != 0 ? null : str13, (i & 524288) != 0 ? null : l, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str14, (i & 2097152) != 0 ? null : num2, (i & 4194304) != 0 ? null : str15, (i & 8388608) != 0 ? null : str16, (i & 16777216) != 0 ? null : list, (i & 33554432) != 0 ? null : str17, (i & 67108864) != 0 ? null : bool6, (i & 134217728) != 0 ? null : str18, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : list2, (i & 536870912) != 0 ? null : str19, (i & 1073741824) != 0 ? null : dailyLimitAmountConfModel, (i & Integer.MIN_VALUE) != 0 ? null : bool7, (i2 & 1) != 0 ? null : extendCashierModel, (i2 & 2) != 0 ? null : str20, (i2 & 4) != 0 ? null : bool8, (i2 & 8) != 0 ? null : remainingCardLimitAmountModel, (i2 & 16) != 0 ? null : l2, (i2 & 32) != 0 ? null : num3);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Intrinsics.areEqual("DEBIT_CARD", this.getSupportButtonTintMode) || Intrinsics.areEqual("DIRECT_DEBIT_DEBIT_CARD", this.getSupportButtonTintMode);
    }

    public final boolean PlaceComponentResult() {
        return Intrinsics.areEqual("CREDIT_CARD", this.getSupportButtonTintMode) || Intrinsics.areEqual("DIRECT_DEBIT_CREDIT_CARD", this.getSupportButtonTintMode);
    }

    public final boolean getAuthRequestContext() {
        return StringsKt.equals(Institution.BCA_ONEKLIK, this.NetworkUserEntityData$$ExternalSyntheticLambda7, true);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return Intrinsics.areEqual(this.DatabaseTableConfigUtil, Boolean.TRUE);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<AssetCardModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AssetCardModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            Boolean valueOf6;
            Boolean valueOf7;
            Boolean valueOf8;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            Integer valueOf9 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString6 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString7 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString13 = parcel.readString();
            Long valueOf10 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString14 = parcel.readString();
            Integer valueOf11 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString17 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf6 = null;
            } else {
                valueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString18 = parcel.readString();
            ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
            String readString19 = parcel.readString();
            DailyLimitAmountConfModel createFromParcel = parcel.readInt() == 0 ? null : DailyLimitAmountConfModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                valueOf7 = null;
            } else {
                valueOf7 = Boolean.valueOf(parcel.readInt() != 0);
            }
            ExtendCashierModel createFromParcel2 = parcel.readInt() == 0 ? null : ExtendCashierModel.CREATOR.createFromParcel(parcel);
            String readString20 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf8 = null;
            } else {
                valueOf8 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new AssetCardModel(readString, readString2, readString3, valueOf, readString4, readString5, valueOf9, readString6, valueOf2, readString7, valueOf3, readString8, valueOf4, readString9, readString10, readString11, readString12, valueOf5, readString13, valueOf10, readString14, valueOf11, readString15, readString16, createStringArrayList, readString17, valueOf6, readString18, createStringArrayList2, readString19, createFromParcel, valueOf7, createFromParcel2, readString20, valueOf8, parcel.readInt() == 0 ? null : RemainingCardLimitAmountModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AssetCardModel[] newArray(int i) {
            return new AssetCardModel[i];
        }
    }
}
