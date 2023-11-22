package id.dana.animation.tab;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import id.dana.R;
import id.dana.animation.tab.InternetConnectivitySnackbar;
import id.dana.core.ui.util.connectivity.InternetConnectionStatus;
import id.dana.utils.OSUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\r\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013"}, d2 = {"Lid/dana/home/tab/ConnectivitySnackbarManager;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "Landroid/app/Activity;", "Landroid/app/Activity;", "MyBillsEntityDataFactory", "I", "PlaceComponentResult", "Lid/dana/home/tab/InternetConnectivitySnackbar;", "Lid/dana/home/tab/InternetConnectivitySnackbar;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectivitySnackbarManager {
    private final Activity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public InternetConnectivitySnackbar KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ViewGroup MyBillsEntityDataFactory;

    public ConnectivitySnackbarManager(Activity activity, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = activity;
        this.MyBillsEntityDataFactory = viewGroup;
        this.PlaceComponentResult = OSUtil.scheduleImpl() ? activity.getWindow().getNavigationBarColor() : 0;
        InternetConnectivitySnackbar.Companion companion = InternetConnectivitySnackbar.INSTANCE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = InternetConnectivitySnackbar.Companion.MyBillsEntityDataFactory(viewGroup, InternetConnectionStatus.SLOW_CONNECTION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        if (!OSUtil.scheduleImpl() || this.BuiltInFictitiousFunctionClassFactory.getWindow() == null) {
            return;
        }
        ObjectAnimator.ofArgb(this.BuiltInFictitiousFunctionClassFactory.getWindow(), "navigationBarColor", this.BuiltInFictitiousFunctionClassFactory.getWindow().getNavigationBarColor(), p0).start();
    }

    private final void getAuthRequestContext(String p0) {
        int i;
        if (Intrinsics.areEqual(p0, InternetConnectionStatus.SLOW_CONNECTION)) {
            i = R.color.f27152131100507;
        } else {
            i = Intrinsics.areEqual(p0, InternetConnectionStatus.FAST_CONNECTION) ? R.color.f23922131099979 : R.color.f26712131100373;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, i));
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isShown()) {
            InternetConnectivitySnackbar internetConnectivitySnackbar = this.KClassImpl$Data$declaredNonStaticMembers$2;
            internetConnectivitySnackbar.getAuthRequestContext(p0);
            getAuthRequestContext(p0);
            internetConnectivitySnackbar.show();
        } else if (Intrinsics.areEqual(p0, InternetConnectionStatus.FAST_CONNECTION)) {
        } else {
            InternetConnectivitySnackbar.Companion companion = InternetConnectivitySnackbar.INSTANCE;
            InternetConnectivitySnackbar MyBillsEntityDataFactory = InternetConnectivitySnackbar.Companion.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, p0);
            MyBillsEntityDataFactory.addCallback(new BaseTransientBottomBar.BaseCallback<InternetConnectivitySnackbar>() { // from class: id.dana.home.tab.ConnectivitySnackbarManager$getSnackbarCallback$1
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                public final /* synthetic */ void onDismissed(InternetConnectivitySnackbar internetConnectivitySnackbar2, int i) {
                    Intrinsics.checkNotNullParameter(internetConnectivitySnackbar2, "");
                    r1.KClassImpl$Data$declaredNonStaticMembers$2(ConnectivitySnackbarManager.this.PlaceComponentResult);
                }
            });
            getAuthRequestContext(p0);
            MyBillsEntityDataFactory.show();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
        }
    }
}
