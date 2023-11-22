package id.dana.social.di.factory;

import id.dana.DanaApplication;
import id.dana.base.AbstractContractKt;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.SocialCommonModule;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/di/factory/SocialCommonComponentFactory;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SocialCommonComponentFactory {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/di/factory/SocialCommonComponentFactory$Companion;", "", "Lid/dana/DanaApplication;", "p0", "Lid/dana/social/di/component/SocialCommonComponent;", "getAuthRequestContext", "(Lid/dana/DanaApplication;)Lid/dana/social/di/component/SocialCommonComponent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SocialCommonComponent getAuthRequestContext(DanaApplication p0) {
            SocialCommonComponent PlaceComponentResult = p0.getApplicationComponent().PlaceComponentResult(new SocialCommonModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.social.di.factory.SocialCommonComponentFactory$Companion$createSocialCommonComponent$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p02) {
                }

                @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                public final void onGetBottomSheetOnBoardingAvailability(boolean p02, String p1) {
                }

                @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                    BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }
            }));
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            return PlaceComponentResult;
        }
    }
}
