package id.dana.riskChallenges.ui.otp.otpwhatsapp;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsAppBottomSheetFragment;
import id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappChallengeFragment;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\b\u0010/\u001a\u0004\u0018\u00010*\u0012\u0006\u00100\u001a\u00020\u0006\u0012\b\b\u0002\u00101\u001a\u00020\u0006\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\b\b\u0002\u00103\u001a\u00020\u001c\u0012\u0006\u00104\u001a\u00020\u0006\u0012\u0006\u00105\u001a\u00020\u0006\u0012\b\u00106\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u00107\u001a\u00020(¢\u0006\u0004\b8\u00109J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001a\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010!\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001bR\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001bR*\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010#\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010)R\u0016\u0010-\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsAppChallengeStrategy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Landroidx/fragment/app/FragmentResultListener;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "Lkotlin/Function0;", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "p2", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "Ljava/lang/String;", "", "Z", "moveToNextValue", "scheduleImpl", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "initRecordTimeStamp", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "newProxyInstance", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtpWhatsAppChallengeStrategy implements RiskChallengeStrategy, FragmentResultListener {
    private final FragmentActivity BuiltInFictitiousFunctionClassFactory;
    private final String DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final TrackerModel initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private Function1<? super Bundle, Unit> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final UiComponent newProxyInstance;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private Function1<? super Bundle, Unit> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final String GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final String lookAheadTest;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[UIComponentType.values().length];
            iArr[UIComponentType.BottomSheet.ordinal()] = 1;
            getAuthRequestContext = iArr;
        }
    }

    public OtpWhatsAppChallengeStrategy(FragmentActivity fragmentActivity, String str, String str2, String str3, UiComponent uiComponent, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, TrackerModel trackerModel) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(trackerModel, "");
        this.BuiltInFictitiousFunctionClassFactory = fragmentActivity;
        this.getErrorConfigVersion = str;
        this.GetContactSyncConfig = str2;
        this.lookAheadTest = str3;
        this.newProxyInstance = uiComponent;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str4;
        this.DatabaseTableConfigUtil = str5;
        this.scheduleImpl = str6;
        this.PlaceComponentResult = z;
        this.moveToNextValue = str7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str9;
        this.initRecordTimeStamp = trackerModel;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        FragmentManager supportFragmentManager = this.BuiltInFictitiousFunctionClassFactory.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        UiComponent uiComponent = this.newProxyInstance;
        UIComponentType uIComponentType = uiComponent != null ? uiComponent.getAuthRequestContext : null;
        if ((uIComponentType == null ? -1 : WhenMappings.getAuthRequestContext[uIComponentType.ordinal()]) == 1) {
            OtpWhatsAppBottomSheetFragment.Companion companion = OtpWhatsAppBottomSheetFragment.INSTANCE;
            OtpWhatsAppBottomSheetFragment BuiltInFictitiousFunctionClassFactory = OtpWhatsAppBottomSheetFragment.Companion.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.GetContactSyncConfig, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, this.DatabaseTableConfigUtil, this.scheduleImpl, this.PlaceComponentResult, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.initRecordTimeStamp);
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(0, BuiltInFictitiousFunctionClassFactory, "verify_otp_whatsapp_bottom_sheet_fragment", 1);
            beginTransaction.getAuthRequestContext();
            return;
        }
        OtpWhatsappChallengeFragment.Companion companion2 = OtpWhatsappChallengeFragment.INSTANCE;
        OtpWhatsappChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2 = OtpWhatsappChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.GetContactSyncConfig, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, this.DatabaseTableConfigUtil, this.scheduleImpl, this.PlaceComponentResult, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.initRecordTimeStamp);
        FragmentTransaction beginTransaction2 = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction2, "");
        FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction2);
        int i = R.id.initRecordTimeStamp;
        OtpWhatsappChallengeFragment otpWhatsappChallengeFragment = KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        beginTransaction2.KClassImpl$Data$declaredNonStaticMembers$2(i, otpWhatsappChallengeFragment, null, 2);
        beginTransaction2.getAuthRequestContext();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super Bundle, Unit> p0, Function1<? super Bundle, Unit> p1, Function0<Unit> p2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0;
        this.MyBillsEntityDataFactory = p2;
        this.getAuthRequestContext = p1;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (Intrinsics.areEqual("KEY_RISK_CHALLENGE_FRAGMENT", p0)) {
            int i = p1.getInt("KEY_RESULT");
            if (i == -1) {
                Function1<? super Bundle, Unit> function1 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (function1 != null) {
                    function1.invoke(p1);
                }
            } else if (i == 0) {
                if (p1.getBoolean("KEY_IS_ERROR")) {
                    Function1<? super Bundle, Unit> function12 = this.getAuthRequestContext;
                    if (function12 != null) {
                        function12.invoke(p1);
                        return;
                    }
                    return;
                }
                Function0<Unit> function0 = this.MyBillsEntityDataFactory;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }
}
