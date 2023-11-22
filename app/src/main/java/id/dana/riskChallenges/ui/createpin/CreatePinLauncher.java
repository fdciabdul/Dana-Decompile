package id.dana.riskChallenges.ui.createpin;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResultLauncher;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u000fB\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R \u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0005\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\t\u0010\bR \u0010\u0003\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\n\u0010\bR \u0010\u0005\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0003\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\r\u0010\b"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "", "p0", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "MyBillsEntityDataFactory", "<init>", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreatePinLauncher extends BaseLauncher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public UseCaseStrategy getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;
    private static final Regex moveToNextValue = new Regex("^(?:\\+62)");
    private static final Regex NetworkUserEntityData$$ExternalSyntheticLambda0 = new Regex("^(?:62)");
    private static final Regex getErrorConfigVersion = new Regex("^(?:08)");

    public /* synthetic */ CreatePinLauncher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CreatePinLauncher() {
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/createpin/CreatePinLauncher;", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "Landroidx/fragment/app/FragmentActivity;", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<CreatePinLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private String PlaceComponentResult;
        public UseCaseStrategy KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private String MyBillsEntityDataFactory;
        private String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        public final /* synthetic */ CreatePinLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            CreatePinLauncher createPinLauncher = new CreatePinLauncher(null);
            createPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            createPinLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            createPinLauncher.DatabaseTableConfigUtil = StrategyKey.CREATE_PIN;
            createPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.scheduleImpl;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            createPinLauncher.GetContactSyncConfig = function1;
            createPinLauncher.moveToNextValue = function12;
            createPinLauncher.MyBillsEntityDataFactory = function0;
            Function0<Unit> function02 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(function02, "");
            createPinLauncher.getErrorConfigVersion = function02;
            createPinLauncher.PlaceComponentResult = this.MyBillsEntityDataFactory;
            createPinLauncher.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext;
            createPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult;
            createPinLauncher.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
            createPinLauncher.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
            return createPinLauncher;
        }
    }

    private final void getAuthRequestContext() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.BuiltInFictitiousFunctionClassFactory;
        if (activityResultLauncher != null) {
            Intent intent = new Intent(getErrorConfigVersion(), RiskChallengeActivity.class);
            Pair[] pairArr = new Pair[7];
            pairArr[0] = TuplesKt.to("KEY_STRATEGY", this.DatabaseTableConfigUtil);
            pairArr[1] = TuplesKt.to("KEY_SECURITY_ID", this.BuiltInFictitiousFunctionClassFactory);
            pairArr[2] = TuplesKt.to("KEY_RISK_TOKEN", this.KClassImpl$Data$declaredNonStaticMembers$2);
            pairArr[3] = TuplesKt.to("KEY_USE_CASE_STRATEGY", this.getAuthRequestContext);
            pairArr[4] = TuplesKt.to("KEY_UI_COMPONENT", this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            String str = this.PlaceComponentResult;
            if (str == null) {
                str = null;
            } else if (StringsKt.startsWith$default(str, "+62", false, 2, (Object) null)) {
                str = moveToNextValue.replace(str, "62-");
            } else if (StringsKt.startsWith$default(str, "62", false, 2, (Object) null)) {
                str = NetworkUserEntityData$$ExternalSyntheticLambda0.replace(str, "62-");
            } else if (StringsKt.startsWith$default(str, "08", false, 2, (Object) null)) {
                str = getErrorConfigVersion.replace(str, "62-8");
            }
            pairArr[5] = TuplesKt.to("KEY_PHONE_NUMBER", str);
            pairArr[6] = TuplesKt.to("KEY_SOURCE", this.MyBillsEntityDataFactory);
            intent.putExtras(BundleKt.PlaceComponentResult(pairArr));
            activityResultLauncher.MyBillsEntityDataFactory(intent, null);
        }
    }
}
