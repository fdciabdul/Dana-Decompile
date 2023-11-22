package id.dana.lib.gcontainer.app.bridge.core;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import androidx.view.ComponentActivity;
import androidx.view.Lifecycle;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.anggrayudi.storage.ComponentWrapper;
import com.anggrayudi.storage.FragmentWrapper;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.SimpleStorageHelper;
import com.google.android.gms.common.internal.BaseGmsClient;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.ContainerLifecycleCallback;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.app.bridge.core.GriverH5ActivityLifecycleCallbacks;
import id.dana.lib.logger.DANALog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "", "checkIfOpeningH5", "()V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityPaused", "onActivityResumed", "outState", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks$FinishAllSessionsMessageEvent;", "event", "onShouldFinishAllSessions", "(Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks$FinishAllSessionsMessageEvent;)V", "Landroid/nfc/NfcAdapter;", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "<init>", "Companion", "FinishAllSessionsMessageEvent", "Info"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class GriverH5ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<GriverBaseActivity, Info> activities = new LinkedHashMap();
    private static final List<ContainerLifecycleCallback> containerLifecycleCallbacks = new ArrayList();
    private static boolean isOpeningH5;
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks$FinishAllSessionsMessageEvent;", "", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class FinishAllSessionsMessageEvent {
    }

    public GriverH5ActivityLifecycleCallbacks() {
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onShouldFinishAllSessions(FinishAllSessionsMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        Iterator it = CollectionsKt.reversed(activities.entrySet()).iterator();
        while (it.hasNext()) {
            ((GriverBaseActivity) ((Map.Entry) it.next()).getKey()).finish();
        }
        isOpeningH5 = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r3) {
        ContainerLifecycleCallback callback;
        Intrinsics.checkNotNullParameter(r3, "");
        if (r3 instanceof GriverBaseActivity) {
            try {
                NfcAdapter nfcAdapter = this.nfcAdapter;
                if (nfcAdapter != null) {
                    nfcAdapter.disableForegroundDispatch(r3);
                }
            } catch (IllegalStateException e) {
                DANALog.PlaceComponentResult("NFC - Griver", e.getMessage());
            }
            Info info = activities.get(r3);
            if (info == null || (callback = info.getCallback()) == null) {
                return;
            }
            callback.onContainerActivityLifecycleEvent(Lifecycle.Event.ON_PAUSE, (GriverBaseActivity) r3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r4) {
        ContainerLifecycleCallback callback;
        Intrinsics.checkNotNullParameter(r4, "");
        if (r4 instanceof GriverBaseActivity) {
            try {
                NfcAdapter nfcAdapter = this.nfcAdapter;
                if (nfcAdapter != null) {
                    nfcAdapter.enableForegroundDispatch(r4, this.pendingIntent, null, null);
                }
            } catch (IllegalStateException e) {
                DANALog.PlaceComponentResult("NFC - Griver", e.getMessage());
            }
            Info info = activities.get(r4);
            if (info == null || (callback = info.getCallback()) == null) {
                return;
            }
            callback.onContainerActivityLifecycleEvent(Lifecycle.Event.ON_RESUME, (GriverBaseActivity) r4);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r3) {
        Info info;
        ContainerLifecycleCallback callback;
        Intrinsics.checkNotNullParameter(r3, "");
        if (!(r3 instanceof GriverBaseActivity) || (info = activities.get(r3)) == null || (callback = info.getCallback()) == null) {
            return;
        }
        callback.onContainerActivityLifecycleEvent(Lifecycle.Event.ON_START, (GriverBaseActivity) r3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r3) {
        Info remove;
        ContainerLifecycleCallback callback;
        Intrinsics.checkNotNullParameter(r3, "");
        if ((r3 instanceof GriverBaseActivity) && (remove = activities.remove(r3)) != null && (callback = remove.getCallback()) != null) {
            callback.onContainerActivityLifecycleEvent(Lifecycle.Event.ON_DESTROY, (GriverBaseActivity) r3);
        }
        checkIfOpeningH5();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r4, Bundle outState) {
        Intrinsics.checkNotNullParameter(r4, "");
        Intrinsics.checkNotNullParameter(outState, "");
        Info info = activities.get(r4);
        if (info != null) {
            SimpleStorageHelper storageHelper = info.getStorageHelper();
            Intrinsics.checkNotNullParameter(outState, "");
            SimpleStorage simpleStorage = storageHelper.lookAheadTest;
            Intrinsics.checkNotNullParameter(outState, "");
            outState.putString("com.anggrayudi.storage.lastVisitedFolder", simpleStorage.getErrorConfigVersion.getPath());
            outState.putString("com.anggrayudi.storage.expectedBasePathForAccessRequest", simpleStorage.KClassImpl$Data$declaredNonStaticMembers$2);
            outState.putInt("com.anggrayudi.storage.requestCodeStorageAccess", simpleStorage.BuiltInFictitiousFunctionClassFactory.ordinal());
            outState.putInt("com.anggrayudi.storage.requestCodeStorageAccess", simpleStorage.GetContactSyncConfig);
            outState.putInt("com.anggrayudi.storage.requestCodeFolderPicker", simpleStorage.moveToNextValue);
            outState.putInt("com.anggrayudi.storage.requestCodeFilePicker", simpleStorage.lookAheadTest);
            outState.putInt("com.anggrayudi.storage.requestCodeCreateFile", simpleStorage.NetworkUserEntityData$$ExternalSyntheticLambda0);
            ComponentWrapper componentWrapper = simpleStorage.initRecordTimeStamp;
            if (componentWrapper instanceof FragmentWrapper) {
                outState.putInt("com.anggrayudi.storage.requestCodeFragmentPicker", ((FragmentWrapper) componentWrapper).getAuthRequestContext);
            }
            outState.putInt("com.anggrayudi.storage.originalRequestCode", storageHelper.MyBillsEntityDataFactory);
            outState.putInt("com.anggrayudi.storage.pickerToOpenOnceGranted", storageHelper.getErrorConfigVersion);
            Set<String> set = storageHelper.PlaceComponentResult;
            if (set != null) {
                Object[] array = set.toArray(new String[0]);
                if (array != null) {
                    outState.putStringArray("com.anggrayudi.storage.filterMimeTypes", (String[]) array);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r3) {
        Info info;
        ContainerLifecycleCallback callback;
        Intrinsics.checkNotNullParameter(r3, "");
        checkIfOpeningH5();
        if (!(r3 instanceof GriverBaseActivity) || (info = activities.get(r3)) == null || (callback = info.getCallback()) == null) {
            return;
        }
        callback.onContainerActivityLifecycleEvent(Lifecycle.Event.ON_STOP, (GriverBaseActivity) r3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r7, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(r7, "");
        if (r7 instanceof GriverBaseActivity) {
            final Info info = new Info(new SimpleStorageHelper((ComponentActivity) r7, savedInstanceState), (ContainerLifecycleCallback) CollectionsKt.removeLastOrNull(containerLifecycleCallbacks));
            activities.put(r7, info);
            GriverBaseActivity griverBaseActivity = (GriverBaseActivity) r7;
            ActivityResultLauncher<Intent> registerForActivityResult = griverBaseActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.lib.gcontainer.app.bridge.core.GriverH5ActivityLifecycleCallbacks$$ExternalSyntheticLambda0
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    GriverH5ActivityLifecycleCallbacks.m2645onActivityCreated$lambda1(GriverH5ActivityLifecycleCallbacks.Info.this, (ActivityResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
            info.setResultLauncher$gcontainer_release(registerForActivityResult);
            int i = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
            Activity activity = r7;
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
            if (defaultAdapter == null) {
                defaultAdapter = null;
            } else {
                this.pendingIntent = PendingIntent.getActivity(activity, 0, new Intent(activity, r7.getClass()).addFlags(536870912), i);
                Unit unit = Unit.INSTANCE;
            }
            this.nfcAdapter = defaultAdapter;
            ContainerLifecycleCallback callback = info.getCallback();
            if (callback != null) {
                callback.onContainerActivityLifecycleEvent(Lifecycle.Event.ON_CREATE, griverBaseActivity);
            }
        }
        checkIfOpeningH5();
    }

    /* renamed from: onActivityCreated$lambda-1 */
    public static final void m2645onActivityCreated$lambda1(Info info, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(info, "");
        EventBus.getDefault().post(new BaseBridge.ActivityResultMessageEvent(info.getRequestCodeUuid(), info.getRequestCode(), activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory));
        info.setRequestCodeUuid$gcontainer_release("");
    }

    private final void checkIfOpeningH5() {
        isOpeningH5 = !activities.isEmpty();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0007\u001a\u00020\u00068\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u00020\u00048\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0001@\u0001X\u0081.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks$Info;", "", "Landroid/content/Intent;", "intent", "", "requestCodeUuid", "", RequestPermission.REQUEST_CODE, "", "startActivityForResult", "(Landroid/content/Intent;Ljava/lang/String;I)V", "Lid/dana/lib/gcontainer/ContainerLifecycleCallback;", "callback", "Lid/dana/lib/gcontainer/ContainerLifecycleCallback;", "getCallback$gcontainer_release", "()Lid/dana/lib/gcontainer/ContainerLifecycleCallback;", "I", "getRequestCode$gcontainer_release", "()I", "setRequestCode$gcontainer_release", "(I)V", "Ljava/lang/String;", "getRequestCodeUuid$gcontainer_release", "()Ljava/lang/String;", "setRequestCodeUuid$gcontainer_release", "(Ljava/lang/String;)V", "Landroidx/activity/result/ActivityResultLauncher;", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getResultLauncher$gcontainer_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setResultLauncher$gcontainer_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "Lcom/anggrayudi/storage/SimpleStorageHelper;", "storageHelper", "Lcom/anggrayudi/storage/SimpleStorageHelper;", "getStorageHelper", "()Lcom/anggrayudi/storage/SimpleStorageHelper;", "<init>", "(Lcom/anggrayudi/storage/SimpleStorageHelper;Lid/dana/lib/gcontainer/ContainerLifecycleCallback;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Info {
        private final ContainerLifecycleCallback callback;
        private int requestCode;
        private String requestCodeUuid;
        public ActivityResultLauncher<Intent> resultLauncher;
        private final SimpleStorageHelper storageHelper;

        public Info(SimpleStorageHelper simpleStorageHelper, ContainerLifecycleCallback containerLifecycleCallback) {
            Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
            this.storageHelper = simpleStorageHelper;
            this.callback = containerLifecycleCallback;
            this.requestCodeUuid = "";
        }

        @JvmName(name = "getStorageHelper")
        public final SimpleStorageHelper getStorageHelper() {
            return this.storageHelper;
        }

        @JvmName(name = "getCallback$gcontainer_release")
        /* renamed from: getCallback$gcontainer_release  reason: from getter */
        public final ContainerLifecycleCallback getCallback() {
            return this.callback;
        }

        @JvmName(name = "getResultLauncher$gcontainer_release")
        public final ActivityResultLauncher<Intent> getResultLauncher$gcontainer_release() {
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncher;
            if (activityResultLauncher != null) {
                return activityResultLauncher;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }

        @JvmName(name = "setResultLauncher$gcontainer_release")
        public final void setResultLauncher$gcontainer_release(ActivityResultLauncher<Intent> activityResultLauncher) {
            Intrinsics.checkNotNullParameter(activityResultLauncher, "");
            this.resultLauncher = activityResultLauncher;
        }

        @JvmName(name = "getRequestCodeUuid$gcontainer_release")
        /* renamed from: getRequestCodeUuid$gcontainer_release  reason: from getter */
        public final String getRequestCodeUuid() {
            return this.requestCodeUuid;
        }

        @JvmName(name = "setRequestCodeUuid$gcontainer_release")
        public final void setRequestCodeUuid$gcontainer_release(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.requestCodeUuid = str;
        }

        @JvmName(name = "getRequestCode$gcontainer_release")
        /* renamed from: getRequestCode$gcontainer_release  reason: from getter */
        public final int getRequestCode() {
            return this.requestCode;
        }

        @JvmName(name = "setRequestCode$gcontainer_release")
        public final void setRequestCode$gcontainer_release(int i) {
            this.requestCode = i;
        }

        public final void startActivityForResult(Intent intent, String requestCodeUuid, int r6) {
            Intrinsics.checkNotNullParameter(intent, "");
            Intrinsics.checkNotNullParameter(requestCodeUuid, "");
            try {
                getResultLauncher$gcontainer_release().MyBillsEntityDataFactory(intent, null);
                this.requestCode = r6;
                this.requestCodeUuid = requestCodeUuid;
            } catch (ActivityNotFoundException unused) {
                this.requestCode = 0;
                this.requestCodeUuid = "";
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks$Companion;", "", "", "Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "Lid/dana/lib/gcontainer/app/bridge/core/GriverH5ActivityLifecycleCallbacks$Info;", "activities", "Ljava/util/Map;", "getActivities", "()Ljava/util/Map;", "", "Lid/dana/lib/gcontainer/ContainerLifecycleCallback;", "containerLifecycleCallbacks", "Ljava/util/List;", "getContainerLifecycleCallbacks", "()Ljava/util/List;", "", "p0", "isOpeningH5", "Z", "()Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "isOpeningH5")
        public final boolean isOpeningH5() {
            return GriverH5ActivityLifecycleCallbacks.isOpeningH5;
        }

        @JvmName(name = "getActivities")
        public final Map<GriverBaseActivity, Info> getActivities() {
            return GriverH5ActivityLifecycleCallbacks.activities;
        }

        @JvmName(name = "getContainerLifecycleCallbacks")
        public final List<ContainerLifecycleCallback> getContainerLifecycleCallbacks() {
            return GriverH5ActivityLifecycleCallbacks.containerLifecycleCallbacks;
        }
    }
}
