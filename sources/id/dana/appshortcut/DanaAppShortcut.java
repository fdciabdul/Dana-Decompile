package id.dana.appshortcut;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.appshortcut.DanaAppShortcutContract;
import id.dana.base.AbstractContractKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDanaAppShortcutComponent;
import id.dana.di.modules.DanaAppShortcutModule;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u0010X\u0087\"¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/appshortcut/DanaAppShortcut;", "", "Landroid/content/Context;", "", "p0", "", "p1", "p2", "p3", "Landroid/content/Intent;", "p4", "Landroidx/core/content/pm/ShortcutInfoCompat;", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;IILandroid/content/Intent;)Landroidx/core/content/pm/ShortcutInfoCompat;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Lid/dana/appshortcut/DanaAppShortcutContract$Presenter;", "danaAppShortcutPresenter", "Lid/dana/appshortcut/DanaAppShortcutContract$Presenter;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaAppShortcut {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context MyBillsEntityDataFactory;
    @Inject
    public DanaAppShortcutContract.Presenter danaAppShortcutPresenter;

    public /* synthetic */ DanaAppShortcut(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @JvmStatic
    public static final boolean getAuthRequestContext(Bundle bundle) {
        return Companion.getAuthRequestContext(bundle);
    }

    private DanaAppShortcut(Context context) {
        this.MyBillsEntityDataFactory = context;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        ApplicationComponent applicationComponent = ((DanaApplication) applicationContext).getApplicationComponent();
        DaggerDanaAppShortcutComponent.Builder MyBillsEntityDataFactory = DaggerDanaAppShortcutComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.PlaceComponentResult = (DanaAppShortcutModule) Preconditions.getAuthRequestContext(new DanaAppShortcutModule(new DanaAppShortcutContract.View() { // from class: id.dana.appshortcut.DanaAppShortcut$getDanaAppShortcutModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.appshortcut.DanaAppShortcutContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                if (p0) {
                    DanaAppShortcut.KClassImpl$Data$declaredNonStaticMembers$2(DanaAppShortcut.this);
                } else {
                    ShortcutManagerCompat.KClassImpl$Data$declaredNonStaticMembers$2(DanaAppShortcut.this.MyBillsEntityDataFactory);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, DanaAppShortcutModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerDanaAppShortcutComponent.DanaAppShortcutComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        DanaAppShortcutContract.Presenter presenter = this.danaAppShortcutPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final ShortcutInfoCompat PlaceComponentResult(Context p0, String p1, int p2, int p3, Intent p4) {
        ShortcutInfoCompat KClassImpl$Data$declaredNonStaticMembers$2 = new ShortcutInfoCompat.Builder(this.MyBillsEntityDataFactory, p1).PlaceComponentResult(p0.getString(p2)).MyBillsEntityDataFactory(p0.getString(p2)).getAuthRequestContext(IconCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, p3)).KClassImpl$Data$declaredNonStaticMembers$2(p4).KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/appshortcut/DanaAppShortcut$Companion;", "", "Landroid/content/Context;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "", "p1", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;I)Landroid/content/Intent;", "Landroid/os/Bundle;", "PlaceComponentResult", "(Landroid/os/Bundle;)I", "MyBillsEntityDataFactory", "", "getAuthRequestContext", "(Landroid/os/Bundle;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, int p1) {
            Intent intent = new Intent(p0, LocalConfigSplashActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268468224);
            intent.addCategory("android.shortcut.conversation");
            intent.putExtra("APP_SHORTCUT_ACTION", true);
            intent.putExtra("APP_SHORTCUT_ACTION_TARGET", p1);
            return intent;
        }

        @JvmStatic
        public static boolean getAuthRequestContext(Bundle p0) {
            if (p0 == null) {
                return false;
            }
            return p0.getBoolean("APP_SHORTCUT_ACTION", false);
        }

        @JvmStatic
        public static int MyBillsEntityDataFactory(Bundle p0) {
            if (p0 == null) {
                return 0;
            }
            return p0.getInt("APP_SHORTCUT_ACTION_TARGET", 0);
        }

        @JvmStatic
        public static int PlaceComponentResult(Bundle p0) {
            if (p0 == null) {
                return 0;
            }
            int i = p0.getInt("APP_SHORTCUT_ACTION_TARGET", 0);
            p0.remove("APP_SHORTCUT_ACTION_TARGET");
            return i;
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            new DanaAppShortcut(p0, null);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanaAppShortcut danaAppShortcut) {
        if (Build.VERSION.SDK_INT >= 25) {
            Context context = danaAppShortcut.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(context, "");
            ShortcutInfoCompat PlaceComponentResult = danaAppShortcut.PlaceComponentResult(context, "id1", R.string.lbl_shortcut_pay, R.drawable.ic_shortcut_scan_48dp, Companion.BuiltInFictitiousFunctionClassFactory(context, 1));
            Context context2 = danaAppShortcut.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(context2, "");
            ShortcutInfoCompat PlaceComponentResult2 = danaAppShortcut.PlaceComponentResult(context2, "id2", R.string.lbl_shortcut_topup, R.drawable.ic_shortcut_top_up_48dp, Companion.BuiltInFictitiousFunctionClassFactory(context2, 2));
            Context context3 = danaAppShortcut.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(context3, "");
            ShortcutInfoCompat PlaceComponentResult3 = danaAppShortcut.PlaceComponentResult(context3, "id3", R.string.lbl_shortcut_send_money, R.drawable.ic_shortcut_send_money_48dp, Companion.BuiltInFictitiousFunctionClassFactory(context3, 3));
            Context context4 = danaAppShortcut.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(context4, "");
            ShortcutManagerCompat.getAuthRequestContext(danaAppShortcut.MyBillsEntityDataFactory, CollectionsKt.listOf((Object[]) new ShortcutInfoCompat[]{PlaceComponentResult, PlaceComponentResult2, PlaceComponentResult3, danaAppShortcut.PlaceComponentResult(context4, "id4", R.string.lbl_shortcut_request_money, R.drawable.ic_shortcut_request_money_48dp, Companion.BuiltInFictitiousFunctionClassFactory(context4, 4))}));
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(Intent intent, Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, "");
        intent.putExtra("APP_SHORTCUT_ACTION_TARGET", Companion.MyBillsEntityDataFactory(bundle));
    }
}
