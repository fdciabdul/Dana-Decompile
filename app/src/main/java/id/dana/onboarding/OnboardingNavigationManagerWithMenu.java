package id.dana.onboarding;

import android.content.Intent;
import com.zhuinden.simplestack.Backstack;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.MenuItemFacade;
import id.dana.base.OnActivityNavigationManagerWithMenu;
import id.dana.danaviz.DanaVizPromptActivity;
import id.dana.oauth.OauthLoginManager;
import id.dana.onboarding.citcall.CitCallIntroductionKey;
import id.dana.onboarding.confirmpin.ConfirmPinKey;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\u0012\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u0012\u0006\u0010\b\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ9\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\u0010"}, d2 = {"Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "Lid/dana/base/OnActivityNavigationManagerWithMenu;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "", "p1", "p2", "p3", "p4", "MyBillsEntityDataFactory", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Z)V", "Lid/dana/base/KeyBaseActivity;", "Lcom/zhuinden/simplestack/Backstack;", "Lid/dana/base/MenuItemFacade;", "<init>", "(Lid/dana/base/KeyBaseActivity;Lcom/zhuinden/simplestack/Backstack;Lid/dana/base/MenuItemFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnboardingNavigationManagerWithMenu extends OnActivityNavigationManagerWithMenu {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingNavigationManagerWithMenu(KeyBaseActivity<?, ?> keyBaseActivity, Backstack backstack, MenuItemFacade menuItemFacade) {
        super(backstack, keyBaseActivity, menuItemFacade);
        Intrinsics.checkNotNullParameter(keyBaseActivity, "");
        Intrinsics.checkNotNullParameter(backstack, "");
        Intrinsics.checkNotNullParameter(menuItemFacade, "");
    }

    public final void MyBillsEntityDataFactory(String p0, boolean p1, boolean p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        CitCallIntroductionKey citCallIntroductionKey = new CitCallIntroductionKey(p0, p1, p2, p3, p4);
        Intrinsics.checkNotNullParameter(citCallIntroductionKey, "");
        this.getAuthRequestContext.goTo(citCallIntroductionKey);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        ConfirmPinKey.Companion companion = ConfirmPinKey.INSTANCE;
        ConfirmPinKey BuiltInFictitiousFunctionClassFactory = ConfirmPinKey.Companion.BuiltInFictitiousFunctionClassFactory(p0, p1, p2, p3, p4);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        this.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        Intent data = new Intent(KClassImpl$Data$declaredNonStaticMembers$2(), HomeTabActivity.class).setData(KClassImpl$Data$declaredNonStaticMembers$2().getIntent().getData());
        Intrinsics.checkNotNullExpressionValue(data, "");
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        z = OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (z) {
            data.putExtra("fromGoogle", true);
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.APP_TOTAL_LOGIN_TIME, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.APP_TOTAL_LOGIN_TIME);
        KClassImpl$Data$declaredNonStaticMembers$2().startActivity(data);
        PlaceComponentResult();
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        boolean z;
        DanaVizPromptActivity.Companion companion = DanaVizPromptActivity.INSTANCE;
        Intent data = DanaVizPromptActivity.Companion.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2()).setData(KClassImpl$Data$declaredNonStaticMembers$2().getIntent().getData());
        Intrinsics.checkNotNullExpressionValue(data, "");
        data.putExtra("dana_viz_prompt_skippable", p0);
        OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
        z = OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (z) {
            data.putExtra("fromGoogle", true);
        }
        KClassImpl$Data$declaredNonStaticMembers$2().startActivity(data);
        PlaceComponentResult();
    }
}
