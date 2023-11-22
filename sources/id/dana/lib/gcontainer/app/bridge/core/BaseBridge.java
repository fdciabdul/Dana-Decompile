package id.dana.lib.gcontainer.app.bridge.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.anggrayudi.storage.SimpleStorageHelper;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.core.GriverH5ActivityLifecycleCallbacks;
import id.dana.util.RandomInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b0\u0010\u0010J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001eJ'\u0010 \u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8EX\u0084\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u0010/\u001a\u00020\"8EX\u0085\u0084\u0002¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010&"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/anggrayudi/storage/SimpleStorageHelper;", "getStorageHelper", "(Landroid/app/Activity;)Lcom/anggrayudi/storage/SimpleStorageHelper;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "onFinalized", "()V", "onInitialized", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge$ActivityResultMessageEvent;", "event", "onReceiveActivityResult", "(Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge$ActivityResultMessageEvent;)V", "", "", RequestPermission.PERMISSIONS, "Lcom/anggrayudi/storage/permission/PermissionCallback;", "callback", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "", "(Landroid/app/Activity;Ljava/util/Collection;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "intent", "startActivityForResult", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "Lkotlinx/coroutines/CoroutineScope;", "ioScope$delegate", "Lkotlin/Lazy;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "requestCodeUuid", "Ljava/lang/String;", "uiScope$delegate", "getUiScope", "uiScope", "<init>", "ActivityResultMessageEvent"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public class BaseBridge extends SimpleBridgeExtension {

    /* renamed from: ioScope$delegate  reason: from kotlin metadata */
    private final Lazy ioScope;
    private final CompletableJob job;
    private String requestCodeUuid;

    /* renamed from: uiScope$delegate  reason: from kotlin metadata */
    private final Lazy uiScope;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public final void startActivityForResult(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(intent, "");
        startActivityForResult$default(this, activity, intent, 0, 4, null);
    }

    public BaseBridge() {
        CompletableJob Job$default;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.job = Job$default;
        this.ioScope = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: id.dana.lib.gcontainer.app.bridge.core.BaseBridge$ioScope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CompletableJob completableJob;
                CoroutineDispatcher io2 = Dispatchers.getIO();
                completableJob = BaseBridge.this.job;
                return CoroutineScopeKt.CoroutineScope(io2.plus(completableJob));
            }
        });
        this.uiScope = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: id.dana.lib.gcontainer.app.bridge.core.BaseBridge$uiScope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CompletableJob completableJob;
                MainCoroutineDispatcher main = Dispatchers.getMain();
                completableJob = BaseBridge.this.job;
                return CoroutineScopeKt.CoroutineScope(main.plus(completableJob));
            }
        });
    }

    @JvmName(name = "getIoScope")
    public final CoroutineScope getIoScope() {
        return (CoroutineScope) this.ioScope.getValue();
    }

    @JvmName(name = "getUiScope")
    public final CoroutineScope getUiScope() {
        return (CoroutineScope) this.uiScope.getValue();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        EventBus.getDefault().register(this);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        EventBus.getDefault().unregister(this);
        Job.DefaultImpls.cancel$default(this.job, null, 1, null);
    }

    public final void requestPermissions(Activity activity, Collection<String> permissions, PermissionCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(permissions, "");
        Intrinsics.checkNotNullParameter(callback, "");
        Object[] array = CollectionsKt.distinct(permissions).toArray(new String[0]);
        if (array != null) {
            requestPermissions(activity, (String[]) array, callback);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void requestPermissions(final Activity activity, String[] permissions, PermissionCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(permissions, "");
        Intrinsics.checkNotNullParameter(callback, "");
        if (permissions.length == 0) {
            return;
        }
        int BuiltInFictitiousFunctionClassFactory = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        final H5PermissionRequest h5PermissionRequest = new H5PermissionRequest(activity, permissions, BuiltInFictitiousFunctionClassFactory, callback);
        if (Build.VERSION.SDK_INT >= 23) {
            RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
            if (rVNativePermissionRequestProxy == null) {
                return;
            }
            rVNativePermissionRequestProxy.addPermRequstCallback(BuiltInFictitiousFunctionClassFactory, new IPermissionRequestCallback() { // from class: id.dana.lib.gcontainer.app.bridge.core.BaseBridge$$ExternalSyntheticLambda0
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public final void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                    BaseBridge.m2643requestPermissions$lambda1(H5PermissionRequest.this, activity, i, strArr, iArr);
                }
            });
        }
        activity.runOnUiThread(new Runnable() { // from class: id.dana.lib.gcontainer.app.bridge.core.BaseBridge$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BaseBridge.m2644requestPermissions$lambda2(H5PermissionRequest.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestPermissions$lambda-1  reason: not valid java name */
    public static final void m2643requestPermissions$lambda1(H5PermissionRequest h5PermissionRequest, Activity activity, int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(h5PermissionRequest, "");
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullExpressionValue(strArr, "");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            boolean z = true;
            boolean z2 = iArr[i3] == 0;
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (z2 || ActivityCompat.MyBillsEntityDataFactory(activity, str)) {
                z = false;
            }
            arrayList.add(new PermissionReport(str, z2, z));
            i2++;
            i3++;
        }
        h5PermissionRequest.reportResult(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestPermissions$lambda-2  reason: not valid java name */
    public static final void m2644requestPermissions$lambda2(H5PermissionRequest h5PermissionRequest) {
        Intrinsics.checkNotNullParameter(h5PermissionRequest, "");
        h5PermissionRequest.check();
    }

    public final SimpleStorageHelper getStorageHelper(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        GriverH5ActivityLifecycleCallbacks.Info info = GriverH5ActivityLifecycleCallbacks.INSTANCE.getActivities().get(activity);
        if (info == null) {
            return null;
        }
        return info.getStorageHelper();
    }

    public static /* synthetic */ void startActivityForResult$default(BaseBridge baseBridge, Activity activity, Intent intent, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startActivityForResult");
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        baseBridge.startActivityForResult(activity, intent, i);
    }

    public final void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        GriverH5ActivityLifecycleCallbacks.Info info;
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(intent, "");
        if (!(activity instanceof GriverBaseActivity) || (info = GriverH5ActivityLifecycleCallbacks.INSTANCE.getActivities().get(activity)) == null) {
            return;
        }
        String obj = UUID.randomUUID().toString();
        this.requestCodeUuid = obj;
        Intrinsics.checkNotNull(obj);
        info.startActivityForResult(intent, obj, requestCode);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge$ActivityResultMessageEvent;", "", "Landroid/content/Intent;", "data", "Landroid/content/Intent;", "getData", "()Landroid/content/Intent;", "", RequestPermission.REQUEST_CODE, "I", "getRequestCode", "()I", "", "requestCodeUuid", "Ljava/lang/String;", "getRequestCodeUuid", "()Ljava/lang/String;", "resultCode", "getResultCode", "<init>", "(Ljava/lang/String;IILandroid/content/Intent;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ActivityResultMessageEvent {
        private final Intent data;
        private final int requestCode;
        private final String requestCodeUuid;
        private final int resultCode;

        public ActivityResultMessageEvent(String str, int i, int i2, Intent intent) {
            Intrinsics.checkNotNullParameter(str, "");
            this.requestCodeUuid = str;
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }

        @JvmName(name = "getRequestCodeUuid")
        public final String getRequestCodeUuid() {
            return this.requestCodeUuid;
        }

        @JvmName(name = "getRequestCode")
        public final int getRequestCode() {
            return this.requestCode;
        }

        @JvmName(name = "getResultCode")
        public final int getResultCode() {
            return this.resultCode;
        }

        @JvmName(name = "getData")
        public final Intent getData() {
            return this.data;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveActivityResult(ActivityResultMessageEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (Intrinsics.areEqual(event.getRequestCodeUuid(), this.requestCodeUuid)) {
            onActivityResult(event.getRequestCode(), event.getResultCode(), event.getData());
        }
        this.requestCodeUuid = null;
    }
}
