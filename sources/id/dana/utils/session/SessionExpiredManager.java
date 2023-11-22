package id.dana.utils.session;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import dagger.Lazy;
import id.dana.AppLifeCycleObserver;
import id.dana.ApplicationOrientationCallback;
import id.dana.R;
import id.dana.danah5.DanaH5;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.onboarding.IntroductionActivity;
import id.dana.onboarding.OnboardingActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public class SessionExpiredManager {
    public final Lazy<ApplicationOrientationCallback> BuiltInFictitiousFunctionClassFactory;
    public final Lazy<SessionManager> KClassImpl$Data$declaredNonStaticMembers$2;
    public final Lazy<Context> MyBillsEntityDataFactory;
    public final CompositeDisposable PlaceComponentResult = new CompositeDisposable();
    public MaterialDialog getAuthRequestContext;
    private TwoButtonWithImageDialog getErrorConfigVersion;
    private final Lazy<AppLifeCycleObserver> scheduleImpl;

    @Inject
    public SessionExpiredManager(Lazy<Context> lazy, Lazy<AppLifeCycleObserver> lazy2, Lazy<ApplicationOrientationCallback> lazy3, Lazy<SessionManager> lazy4) {
        this.MyBillsEntityDataFactory = lazy;
        this.scheduleImpl = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (SessionExpiredManager.class) {
            final Activity activity = this.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory.get();
            if (!moveToNextValue() && !getAuthRequestContext(activity) && activity != null) {
                TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(activity);
                builder.FragmentBottomSheetPaymentSettingBinding = activity.getString(R.string.account_freeze_dialog_title);
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
                builder.getErrorConfigVersion = activity.getString(R.string.account_freeze_dialog_login_desc);
                String upperCase = activity.getString(R.string.close).toUpperCase();
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SessionExpiredManager sessionExpiredManager = SessionExpiredManager.this;
                        final Activity activity2 = activity;
                        sessionExpiredManager.KClassImpl$Data$declaredNonStaticMembers$2.get().BuiltInFictitiousFunctionClassFactory(new Function0() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SessionExpiredManager.BuiltInFictitiousFunctionClassFactory(activity2);
                            }
                        }, new Function1() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Throwable th = (Throwable) obj;
                                return SessionExpiredManager.KClassImpl$Data$declaredNonStaticMembers$2(activity2);
                            }
                        });
                    }
                };
                builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = upperCase;
                builder.DatabaseTableConfigUtil = onClickListener;
                builder.initRecordTimeStamp = true;
                String upperCase2 = activity.getString(R.string.account_freeze_dialog_positive_btn).toUpperCase();
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DanaH5.startContainerFullUrl("https://www.dana.id/contact");
                    }
                };
                builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = upperCase2;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener2;
                TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
                MyBillsEntityDataFactory.isLayoutRequested = false;
                TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(activity, str, "alipayplus.mobilewallet.wallet.user.info", "", activity.getString(R.string.account_freeze_dialog_login_desc), "Home", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Activity activity) {
        OnboardingActivity.openAfterLogout(activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        OnboardingActivity.openAfterLogout(activity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.MyBillsEntityDataFactory();
        Intent intent = new Intent(this.MyBillsEntityDataFactory.get(), IntroductionActivity.class);
        intent.setFlags(268468224);
        this.MyBillsEntityDataFactory.get().startActivity(intent);
        this.scheduleImpl.get().getAuthRequestContext = new Runnable() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                SessionExpiredManager sessionExpiredManager = SessionExpiredManager.this;
                sessionExpiredManager.PlaceComponentResult.MyBillsEntityDataFactory();
                sessionExpiredManager.KClassImpl$Data$declaredNonStaticMembers$2.get().BuiltInFictitiousFunctionClassFactory();
            }
        };
    }

    public final boolean getAuthRequestContext() {
        MaterialDialog materialDialog = this.getAuthRequestContext;
        return materialDialog != null && materialDialog.isShowing();
    }

    private boolean moveToNextValue() {
        TwoButtonWithImageDialog twoButtonWithImageDialog = this.getErrorConfigVersion;
        return twoButtonWithImageDialog != null && twoButtonWithImageDialog.PlaceComponentResult();
    }

    public static boolean getAuthRequestContext(Activity activity) {
        return (activity instanceof IntroductionActivity) || (activity instanceof OnboardingActivity);
    }
}
