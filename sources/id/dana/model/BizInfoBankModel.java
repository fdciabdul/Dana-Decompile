package id.dana.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBW\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\n\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0011\u0010\r\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0011\u0010\f\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0004"}, d2 = {"Lid/dana/model/BizInfoBankModel;", "Lid/dana/model/BizInfoModel;", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizInfoBankModel extends BizInfoModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BizInfoBankModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        super(str);
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
        this.PlaceComponentResult = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.MyBillsEntityDataFactory = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.getAuthRequestContext = str6;
        this.scheduleImpl = str7;
        this.moveToNextValue = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str9;
        this.lookAheadTest = str10;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/model/BizInfoBankModel$Companion;", "", "Lid/dana/model/BizInfoModel;", "", "", "p0", "Lid/dana/model/BizInfoBankModel;", "PlaceComponentResult", "(Lid/dana/model/BizInfoModel;Ljava/util/Map;)Lid/dana/model/BizInfoBankModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static BizInfoBankModel PlaceComponentResult(BizInfoModel bizInfoModel, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(bizInfoModel, "");
            Intrinsics.checkNotNullParameter(map, "");
            String str = bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = map.get("remarks");
            String str3 = str2 == null ? "" : str2;
            String str4 = map.get("bankAccountHolderName");
            String str5 = str4 == null ? "" : str4;
            String str6 = map.get("bankAccountFormattedMaskedNo");
            String str7 = str6 == null ? "" : str6;
            String str8 = map.get("userId");
            String str9 = str8 == null ? "" : str8;
            String str10 = map.get("bankAccountIndexNo");
            String str11 = str10 == null ? "" : str10;
            String str12 = map.get("withdrawInstId");
            String str13 = str12 == null ? "" : str12;
            String str14 = map.get("withdrawPayMethod");
            String str15 = str14 == null ? "" : str14;
            String str16 = map.get("withdrawPayOption");
            String str17 = str16 == null ? "" : str16;
            String str18 = map.get("withdrawInstLocalName");
            BizInfoBankModel bizInfoBankModel = new BizInfoBankModel(str, str3, str5, str7, str9, str11, str13, str15, str17, str18 == null ? "" : str18);
            String str19 = bizInfoModel.scheduleImpl;
            if (str19 == null) {
                str19 = "";
            }
            bizInfoBankModel.scheduleImpl = str19;
            String str20 = bizInfoModel.GetContactSyncConfig;
            if (str20 == null) {
                str20 = "";
            }
            bizInfoBankModel.GetContactSyncConfig = str20;
            String str21 = bizInfoModel.GetContactSyncConfig;
            if (str21 == null) {
                str21 = "";
            }
            bizInfoBankModel.initRecordTimeStamp = str21;
            String str22 = bizInfoModel.DatabaseTableConfigUtil;
            if (str22 == null) {
                str22 = "";
            }
            bizInfoBankModel.DatabaseTableConfigUtil = str22;
            String str23 = bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str23 == null) {
                str23 = "";
            }
            bizInfoBankModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = str23;
            String str24 = bizInfoModel.PrepareContext;
            if (str24 == null) {
                str24 = "";
            }
            bizInfoBankModel.PrepareContext = str24;
            String str25 = bizInfoModel.isLayoutRequested;
            if (str25 == null) {
                str25 = "";
            }
            bizInfoBankModel.isLayoutRequested = str25;
            String str26 = bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (str26 == null) {
                str26 = "";
            }
            bizInfoBankModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = str26;
            String str27 = bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (str27 == null) {
                str27 = "";
            }
            bizInfoBankModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = str27;
            String str28 = bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (str28 == null) {
                str28 = "";
            }
            bizInfoBankModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = str28;
            String str29 = bizInfoModel.newProxyInstance;
            if (str29 == null) {
                str29 = "";
            }
            bizInfoBankModel.newProxyInstance = str29;
            String str30 = bizInfoModel.FragmentBottomSheetPaymentSettingBinding;
            if (str30 == null) {
                str30 = "";
            }
            bizInfoBankModel.FragmentBottomSheetPaymentSettingBinding = str30;
            String str31 = bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
            bizInfoBankModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = str31 != null ? str31 : "";
            return bizInfoBankModel;
        }
    }
}
