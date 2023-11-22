package id.dana.googleplay.updates;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.anggrayudi.storage.extension.CoroutineExtKt;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.googleplay.updates.DanaUpdateManager;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.utils.OSUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0003012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020!¢\u0006\u0004\b.\u0010/J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0010J\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011¢\u0006\u0004\b\u000b\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u000eJ1\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u0013\u0010\u001c\u001a\u00020\u0007*\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010\b\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010\u000b\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u001a\u001a\u0004\u0018\u00010&8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010'R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010*R\u0014\u0010(\u001a\u00020\u00038CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010+R\u0014\u0010-\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\b\u0010,"}, d2 = {"Lid/dana/googleplay/updates/DanaUpdateManager;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "", "p0", "Lid/dana/googleplay/updates/DanaUpdateManager$SilentUpdateCallback;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLid/dana/googleplay/updates/DanaUpdateManager$SilentUpdateCallback;)V", "Lid/dana/googleplay/updates/DanaUpdateManager$ManualCheckUpdateCallback;", "PlaceComponentResult", "(Lid/dana/googleplay/updates/DanaUpdateManager$ManualCheckUpdateCallback;)V", "destroy", "()V", "", "()Ljava/lang/String;", "", "(II)V", "onPause", "onResume", "p2", "Landroid/view/View$OnClickListener;", "p3", "getAuthRequestContext", "(IIILandroid/view/View$OnClickListener;)V", "BuiltInFictitiousFunctionClassFactory", "Lcom/google/android/material/snackbar/Snackbar;", "MyBillsEntityDataFactory", "(Lcom/google/android/material/snackbar/Snackbar;)V", "", "Ljava/lang/Runnable;", "Ljava/util/List;", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "lookAheadTest", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "Landroid/view/View;", "()Landroid/view/View;", "getErrorConfigVersion", "I", "Z", "()Z", "Lid/dana/googleplay/updates/DanaUpdateManager$SilentUpdateCallback;", "moveToNextValue", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "Companion", "ManualCheckUpdateCallback", "SilentUpdateCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaUpdateManager implements LifecycleObserver, InstallStateUpdatedListener {
    private static boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public SilentUpdateCallback moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<Runnable> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FragmentActivity KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean lookAheadTest;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final AppUpdateManager PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lid/dana/googleplay/updates/DanaUpdateManager$ManualCheckUpdateCallback;", "", "onCheckForUpdatesError", "", "onUpdatesNotFound", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface ManualCheckUpdateCallback {

        /* renamed from: id.dana.googleplay.updates.DanaUpdateManager$ManualCheckUpdateCallback$-CC  reason: invalid class name */
        /* loaded from: classes8.dex */
        public final /* synthetic */ class CC {
            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lid/dana/googleplay/updates/DanaUpdateManager$SilentUpdateCallback;", "", "onUpdatesCancelled", "", "onUpdatesError", "onUpdatesNotFound", "onUpdating", "onUserWantsToUpdate", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface SilentUpdateCallback {

        /* renamed from: id.dana.googleplay.updates.DanaUpdateManager$SilentUpdateCallback$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    public DanaUpdateManager(FragmentActivity fragmentActivity) {
        AppUpdateManager appUpdateManager;
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentActivity;
        if (OSUtil.scheduleImpl() && getAuthRequestContext()) {
            appUpdateManager = AppUpdateManagerFactory.create(fragmentActivity);
            fragmentActivity.getLifecycle().BuiltInFictitiousFunctionClassFactory(this);
            appUpdateManager.registerListener(this);
        } else {
            appUpdateManager = null;
        }
        this.PlaceComponentResult = appUpdateManager;
        this.getAuthRequestContext = new ArrayList();
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final /* synthetic */ void onStateUpdate(InstallState installState) {
        InstallState installState2 = installState;
        Intrinsics.checkNotNullParameter(installState2, "");
        this.MyBillsEntityDataFactory = installState2.installStatus();
        int installStatus = installState2.installStatus();
        if (installStatus == 5) {
            SilentUpdateCallback silentUpdateCallback = this.moveToNextValue;
            if (silentUpdateCallback != null) {
                silentUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } else if (installStatus != 6) {
            if (installStatus == 11) {
                CoroutineExtKt.BuiltInFictitiousFunctionClassFactory(new DanaUpdateManager$popupSnackbarToCompleteUpdate$1(this, null));
            }
        } else {
            SilentUpdateCallback silentUpdateCallback2 = this.moveToNextValue;
            if (silentUpdateCallback2 != null) {
                silentUpdateCallback2.PlaceComponentResult();
            }
        }
    }

    @JvmName(name = "getAuthRequestContext")
    private final boolean getAuthRequestContext() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.KClassImpl$Data$declaredNonStaticMembers$2) == 0;
    }

    public final void PlaceComponentResult(final ManualCheckUpdateCallback p0) {
        Task<AppUpdateInfo> appUpdateInfo;
        Task<AppUpdateInfo> addOnSuccessListener;
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory = false;
        AppUpdateManager appUpdateManager = this.PlaceComponentResult;
        if (appUpdateManager == null || (appUpdateInfo = appUpdateManager.getAppUpdateInfo()) == null || (addOnSuccessListener = appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: id.dana.googleplay.updates.DanaUpdateManager$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                DanaUpdateManager.PlaceComponentResult(DanaUpdateManager.this, p0, (AppUpdateInfo) obj);
            }
        })) == null) {
            return;
        }
        addOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: id.dana.googleplay.updates.DanaUpdateManager$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                DanaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2(DanaUpdateManager.ManualCheckUpdateCallback.this, exc);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        if (r1.equals(id.dana.googleplay.updates.StoreName.XIAOMI) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r1.equals(id.dana.googleplay.updates.StoreName.SAMSUNG) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r1.equals(id.dana.googleplay.updates.StoreName.HUAWEI) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        if (r1.equals(id.dana.googleplay.updates.StoreName.VIVO) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        if (r1.equals(id.dana.googleplay.updates.StoreName.OPPO) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt.onCancel(com.afollestad.materialdialogs.MaterialDialog.positiveButton$default(com.afollestad.materialdialogs.MaterialDialog.message$default(new com.afollestad.materialdialogs.MaterialDialog(r18.KClassImpl$Data$declaredNonStaticMembers$2, r4, r2, r4).cancelOnTouchOutside(false), java.lang.Integer.valueOf((int) id.dana.R.string.force_update_uninstall), null, null, 6, null), null, null, new id.dana.googleplay.updates.DanaUpdateManager$showDialogUninstall$1(r18), 3, null), new id.dana.googleplay.updates.DanaUpdateManager$showDialogUninstall$2(r18)).show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean r19, final id.dana.googleplay.updates.DanaUpdateManager.SilentUpdateCallback r20) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.googleplay.updates.DanaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2(boolean, id.dana.googleplay.updates.DanaUpdateManager$SilentUpdateCallback):void");
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    private final View MyBillsEntityDataFactory() {
        List<Fragment> fragments = this.KClassImpl$Data$declaredNonStaticMembers$2.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof HomeTabFragment) {
                arrayList.add(obj);
            }
        }
        HomeTabFragment homeTabFragment = (HomeTabFragment) CollectionsKt.firstOrNull((List) arrayList);
        if (homeTabFragment != null) {
            return homeTabFragment.getView();
        }
        return null;
    }

    public final void getAuthRequestContext(int p0, int p1, int p2, View.OnClickListener p3) {
        View MyBillsEntityDataFactory;
        if (!(this.KClassImpl$Data$declaredNonStaticMembers$2 instanceof HomeTabActivity) || (MyBillsEntityDataFactory = MyBillsEntityDataFactory()) == null) {
            return;
        }
        final Snackbar make = Snackbar.make(MyBillsEntityDataFactory, p0, p2);
        Intrinsics.checkNotNullExpressionValue(make, "");
        MyBillsEntityDataFactory(make);
        if (p3 == null) {
            p3 = new View.OnClickListener() { // from class: id.dana.googleplay.updates.DanaUpdateManager$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaUpdateManager.BuiltInFictitiousFunctionClassFactory(Snackbar.this);
                }
            };
        }
        make.setAction(p1, p3);
        make.show();
    }

    private static void MyBillsEntityDataFactory(Snackbar snackbar) {
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_action)).setTypeface(ResourcesCompat.PlaceComponentResult(snackbar.getContext(), (int) R.font.f34282131296266));
        snackbar.setActionTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(snackbar.getContext(), R.color.f23182131099816));
    }

    public final void PlaceComponentResult(int p0, int p1) {
        SilentUpdateCallback silentUpdateCallback;
        SilentUpdateCallback silentUpdateCallback2;
        if (p0 != 8) {
            return;
        }
        if (p1 == -1) {
            SilentUpdateCallback silentUpdateCallback3 = this.moveToNextValue;
            if (silentUpdateCallback3 != null) {
                silentUpdateCallback3.getAuthRequestContext();
            }
        } else if (p1 != 0) {
            if (p1 != 1 || (silentUpdateCallback2 = this.moveToNextValue) == null) {
                return;
            }
            silentUpdateCallback2.KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (this.MyBillsEntityDataFactory == 5 || (silentUpdateCallback = this.moveToNextValue) == null) {
        } else {
            silentUpdateCallback.PlaceComponentResult();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.lookAheadTest = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Task<AppUpdateInfo> appUpdateInfo;
        this.lookAheadTest = true;
        AppUpdateManager appUpdateManager = this.PlaceComponentResult;
        if (appUpdateManager != null && (appUpdateInfo = appUpdateManager.getAppUpdateInfo()) != null) {
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: id.dana.googleplay.updates.DanaUpdateManager$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    DanaUpdateManager.getAuthRequestContext(DanaUpdateManager.this, (AppUpdateInfo) obj);
                }
            });
        }
        List<Runnable> list = this.getAuthRequestContext;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        List<Runnable> list2 = this.getAuthRequestContext;
        if (list2 != null) {
            list2.clear();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        AppUpdateManager appUpdateManager = this.PlaceComponentResult;
        if (appUpdateManager != null) {
            appUpdateManager.unregisterListener(this);
        }
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            ApplicationInfo applicationInfo = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager().getApplicationInfo(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "");
            String string = applicationInfo.metaData.getString("CHANNEL");
            if (string != null) {
                String lowerCase = string.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                return lowerCase;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    private final void BuiltInFictitiousFunctionClassFactory() {
        ?? r2 = 0;
        DialogCallbackExtKt.onCancel(MaterialDialog.positiveButton$default(MaterialDialog.message$default(new MaterialDialog(this.KClassImpl$Data$declaredNonStaticMembers$2, r2, 2, r2).cancelOnTouchOutside(false), Integer.valueOf((int) R.string.force_update_content), null, null, 6, null), Integer.valueOf((int) R.string.install), null, new Function1<MaterialDialog, Unit>() { // from class: id.dana.googleplay.updates.DanaUpdateManager$showDialogStore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                invoke2(materialDialog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog) {
                Intrinsics.checkNotNullParameter(materialDialog, "");
                DanaUpdateManager.BuiltInFictitiousFunctionClassFactory(DanaUpdateManager.this);
                DanaUpdateManager.SilentUpdateCallback silentUpdateCallback = DanaUpdateManager.this.moveToNextValue;
                if (silentUpdateCallback != null) {
                    silentUpdateCallback.getAuthRequestContext();
                }
            }
        }, 2, null), new Function1<MaterialDialog, Unit>() { // from class: id.dana.googleplay.updates.DanaUpdateManager$showDialogStore$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                invoke2(materialDialog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog) {
                Intrinsics.checkNotNullParameter(materialDialog, "");
                DanaUpdateManager.SilentUpdateCallback silentUpdateCallback = DanaUpdateManager.this.moveToNextValue;
                if (silentUpdateCallback != null) {
                    silentUpdateCallback.PlaceComponentResult();
                }
            }
        }).show();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Snackbar snackbar) {
        Intrinsics.checkNotNullParameter(snackbar, "");
        snackbar.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void getAuthRequestContext(DanaUpdateManager danaUpdateManager, AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(danaUpdateManager, "");
        if (appUpdateInfo.installStatus() != 11) {
            if (BuiltInFictitiousFunctionClassFactory && appUpdateInfo.isUpdateTypeAllowed(1) && appUpdateInfo.updateAvailability() == 3) {
                danaUpdateManager.PlaceComponentResult.startUpdateFlowForResult(appUpdateInfo, 1, danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, 8);
                return;
            }
            return;
        }
        CoroutineExtKt.BuiltInFictitiousFunctionClassFactory(new DanaUpdateManager$popupSnackbarToCompleteUpdate$1(danaUpdateManager, null));
    }

    public static /* synthetic */ void PlaceComponentResult(DanaUpdateManager danaUpdateManager, ManualCheckUpdateCallback manualCheckUpdateCallback, AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(danaUpdateManager, "");
        Intrinsics.checkNotNullParameter(manualCheckUpdateCallback, "");
        if (appUpdateInfo.updateAvailability() == 2) {
            if (appUpdateInfo.isUpdateTypeAllowed(0)) {
                if (appUpdateInfo.installStatus() == 11) {
                    danaUpdateManager.PlaceComponentResult.completeUpdate();
                    return;
                } else {
                    danaUpdateManager.PlaceComponentResult.startUpdateFlowForResult(appUpdateInfo, 0, danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, 8);
                    return;
                }
            } else if (appUpdateInfo.isUpdateTypeAllowed(1)) {
                danaUpdateManager.PlaceComponentResult.startUpdateFlowForResult(appUpdateInfo, 1, danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, 8);
                return;
            } else {
                return;
            }
        }
        manualCheckUpdateCallback.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void getAuthRequestContext(SilentUpdateCallback silentUpdateCallback, Exception exc) {
        Intrinsics.checkNotNullParameter(silentUpdateCallback, "");
        Intrinsics.checkNotNullParameter(exc, "");
        silentUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SilentUpdateCallback silentUpdateCallback, boolean z, DanaUpdateManager danaUpdateManager, AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(silentUpdateCallback, "");
        Intrinsics.checkNotNullParameter(danaUpdateManager, "");
        int updateAvailability = appUpdateInfo.updateAvailability();
        if (updateAvailability == 1) {
            silentUpdateCallback.BuiltInFictitiousFunctionClassFactory();
        } else if (updateAvailability == 2) {
            if (z && appUpdateInfo.isUpdateTypeAllowed(1)) {
                danaUpdateManager.PlaceComponentResult.startUpdateFlowForResult(appUpdateInfo, 1, danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, 8);
            } else if (appUpdateInfo.isUpdateTypeAllowed(0)) {
                Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "");
                AppUpdateManager appUpdateManager = danaUpdateManager.PlaceComponentResult;
                int installStatus = appUpdateInfo.installStatus();
                if (installStatus == 1 || installStatus == 2 || installStatus == 3) {
                    silentUpdateCallback.MyBillsEntityDataFactory();
                } else if (installStatus == 11) {
                    appUpdateManager.completeUpdate();
                } else {
                    try {
                        appUpdateManager.startUpdateFlowForResult(appUpdateInfo, 0, danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, 8);
                    } catch (IntentSender.SendIntentException e) {
                        Crashlytics.Companion companion = Crashlytics.INSTANCE;
                        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                        StringBuilder sb = new StringBuilder();
                        sb.append("installStatus: ");
                        sb.append(appUpdateInfo.installStatus());
                        String obj = sb.toString();
                        Intrinsics.checkNotNullParameter(obj, "");
                        authRequestContext.getAuthRequestContext.log(obj);
                        Intrinsics.checkNotNullParameter("calling appUpdateManager.startUpdateFlowForResult", "");
                        authRequestContext.getAuthRequestContext.log("calling appUpdateManager.startUpdateFlowForResult");
                        IntentSender.SendIntentException sendIntentException = e;
                        Intrinsics.checkNotNullParameter(sendIntentException, "");
                        authRequestContext.getAuthRequestContext.recordException(sendIntentException);
                    }
                }
            }
        } else if (BuiltInFictitiousFunctionClassFactory) {
            silentUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            silentUpdateCallback.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ManualCheckUpdateCallback manualCheckUpdateCallback, Exception exc) {
        Intrinsics.checkNotNullParameter(manualCheckUpdateCallback, "");
        Intrinsics.checkNotNullParameter(exc, "");
        manualCheckUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DanaUpdateManager danaUpdateManager) {
        String KClassImpl$Data$declaredNonStaticMembers$2 = danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            switch (KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) {
                case -1528916671:
                    if (KClassImpl$Data$declaredNonStaticMembers$2.equals(StoreName.OPPO)) {
                        return;
                    }
                    break;
                case 55641643:
                    if (KClassImpl$Data$declaredNonStaticMembers$2.equals(StoreName.NINEAPPS)) {
                        ContentExtKt.startActivitySafely(danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, new Intent("android.intent.action.VIEW", Uri.parse(StoreLink.DANA_IN_9APPS)));
                        return;
                    }
                    break;
                case 419088309:
                    if (KClassImpl$Data$declaredNonStaticMembers$2.equals(StoreName.VIVO)) {
                        return;
                    }
                    break;
                case 849375066:
                    if (KClassImpl$Data$declaredNonStaticMembers$2.equals(StoreName.HUAWEI)) {
                        return;
                    }
                    break;
                case 1755129127:
                    if (KClassImpl$Data$declaredNonStaticMembers$2.equals(StoreName.SAMSUNG)) {
                        return;
                    }
                    break;
                case 1973600518:
                    if (KClassImpl$Data$declaredNonStaticMembers$2.equals(StoreName.XIAOMI)) {
                        return;
                    }
                    break;
            }
        }
        String packageName = danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(packageName);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        if (ContentExtKt.hasActivityHandler(intent, danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2)) {
            danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2.startActivity(intent);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StoreLink.DANA_IN_GOOGLE_PLAY);
        sb2.append(packageName);
        ContentExtKt.startActivitySafely(danaUpdateManager.KClassImpl$Data$declaredNonStaticMembers$2, new Intent("android.intent.action.VIEW", Uri.parse(sb2.toString())));
    }
}
