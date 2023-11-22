package id.dana.initializer;

import android.content.Context;
import androidx.startup.Initializer;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.DanaAppInitializer;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.di.ComponentHolder;
import id.dana.toggle.userloginlogout.ILoginLogoutObserver;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\b\u001a\u00020\u0007X\u0087\"¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/initializer/FirebaseCrashlyticsInitializer;", "Landroidx/startup/Initializer;", "", "", "Ljava/lang/Class;", "PlaceComponentResult", "()Ljava/util/List;", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "loginLogoutObserver", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FirebaseCrashlyticsInitializer implements Initializer<Unit> {
    @Inject
    public LoginLogoutObserver loginLogoutObserver;

    @Override // androidx.startup.Initializer
    public final /* synthetic */ Unit getAuthRequestContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        ComponentHolder.getAuthRequestContext().MyBillsEntityDataFactory(this);
        LoginLogoutObserver loginLogoutObserver = this.loginLogoutObserver;
        if (loginLogoutObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loginLogoutObserver = null;
        }
        loginLogoutObserver.KClassImpl$Data$declaredNonStaticMembers$2(new ILoginLogoutObserver() { // from class: id.dana.initializer.FirebaseCrashlyticsInitializer$create$1
            @Override // id.dana.toggle.userloginlogout.ILoginLogoutObserver
            public final void PlaceComponentResult(LoginLogoutSubject.UserLogin p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics.Companion.getAuthRequestContext(p0.getUserId());
            }
        });
        UserInfoManager.instance().addUserChangeObserver(new IAPUserChangeObserver() { // from class: id.dana.initializer.FirebaseCrashlyticsInitializer$create$2
            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserChanged(IAPLoginUserInfo p0) {
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserLogin(IAPLoginUserInfo p0) {
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public final void onUserLogout() {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics.Companion.BuiltInFictitiousFunctionClassFactory();
            }
        });
        return Unit.INSTANCE;
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return CollectionsKt.listOf(DanaAppInitializer.class);
    }
}
