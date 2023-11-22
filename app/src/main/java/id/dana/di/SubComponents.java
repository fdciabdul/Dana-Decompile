package id.dana.di;

import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.di.component.ImageCaptureComponent;
import id.dana.di.component.InstalledAppComponent;
import id.dana.di.modules.features.imagecapture.ImageCaptureComponentProvider;
import id.dana.di.modules.features.installedapp.InstalledAppComponentProvider;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.sendmoney.di.provider.GlobalSendComponentProvider;
import id.dana.sendmoney.di.provider.GroupSendComponentProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lid/dana/di/SubComponents;", "Lid/dana/sendmoney/di/provider/GroupSendComponentProvider;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "Lid/dana/di/modules/features/installedapp/InstalledAppComponentProvider;", "Lid/dana/mybills/di/provider/MyBillsComponentProvider;", "Lid/dana/di/modules/features/imagecapture/ImageCaptureComponentProvider;", "Lid/dana/danapoly/di/provider/DanapolyComponentProvider;", "Lid/dana/sendmoney/di/provider/GlobalSendComponentProvider;", "provideDanapolyComponent", "Lid/dana/danapoly/di/component/DanapolyComponent$Factory;", "provideGlobalSendComponent", "Lid/dana/sendmoney/di/component/GlobalSendComponent$Factory;", "provideGroupSendComponent", "Lid/dana/sendmoney/di/component/GroupSendComponent$Factory;", "provideImageCaptureComponent", "Lid/dana/di/component/ImageCaptureComponent$Factory;", "provideInstalledAppComponent", "Lid/dana/di/component/InstalledAppComponent$Factory;", "provideMyBillsComponent", "Lid/dana/mybills/di/component/MyBillsComponent$Factory;", "provideRiskChallengesComponent", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent$Factory;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SubComponents extends GroupSendComponentProvider, RiskChallengesProvider, InstalledAppComponentProvider, MyBillsComponentProvider, ImageCaptureComponentProvider, DanapolyComponentProvider, GlobalSendComponentProvider {

    /* renamed from: id.dana.di.SubComponents$-CC */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static GroupSendComponent.Factory MyBillsEntityDataFactory() {
            GroupSendComponent.Factory BottomSheetCardBindingView$watcherCardNumberView$1 = ComponentHolder.getAuthRequestContext().BottomSheetCardBindingView$watcherCardNumberView$1();
            Intrinsics.checkNotNullExpressionValue(BottomSheetCardBindingView$watcherCardNumberView$1, "");
            return BottomSheetCardBindingView$watcherCardNumberView$1;
        }

        public static InstalledAppComponent.Factory BuiltInFictitiousFunctionClassFactory() {
            InstalledAppComponent.Factory D = ComponentHolder.getAuthRequestContext().D();
            Intrinsics.checkNotNullExpressionValue(D, "");
            return D;
        }

        public static RiskChallengesComponent.Factory NetworkUserEntityData$$ExternalSyntheticLambda0() {
            RiskChallengesComponent.Factory CYFMonitor$ChallengeActionCallback = ComponentHolder.getAuthRequestContext().CYFMonitor$ChallengeActionCallback();
            Intrinsics.checkNotNullExpressionValue(CYFMonitor$ChallengeActionCallback, "");
            return CYFMonitor$ChallengeActionCallback;
        }

        public static MyBillsComponent.Factory getErrorConfigVersion() {
            MyBillsComponent.Factory Q = ComponentHolder.getAuthRequestContext().Q();
            Intrinsics.checkNotNullExpressionValue(Q, "");
            return Q;
        }

        public static ImageCaptureComponent.Factory getAuthRequestContext() {
            ImageCaptureComponent.Factory onBoardingScenario = ComponentHolder.getAuthRequestContext().getOnBoardingScenario();
            Intrinsics.checkNotNullExpressionValue(onBoardingScenario, "");
            return onBoardingScenario;
        }

        public static DanapolyComponent.Factory KClassImpl$Data$declaredNonStaticMembers$2() {
            DanapolyComponent.Factory DatabaseTableConfigUtil = ComponentHolder.getAuthRequestContext().DatabaseTableConfigUtil();
            Intrinsics.checkNotNullExpressionValue(DatabaseTableConfigUtil, "");
            return DatabaseTableConfigUtil;
        }

        public static GlobalSendComponent.Factory PlaceComponentResult() {
            GlobalSendComponent.Factory callingPid = ComponentHolder.getAuthRequestContext().getCallingPid();
            Intrinsics.checkNotNullExpressionValue(callingPid, "");
            return callingPid;
        }
    }
}
