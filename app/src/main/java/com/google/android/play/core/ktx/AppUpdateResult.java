package com.google.android.play.core.ktx;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.ocr.model.SnapReceiptBroadcastData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "<init>", "()V", "Available", "Downloaded", SnapReceiptBroadcastData.Status.InProgress, "NotAvailable", "Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public class AppUpdateResult {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", RequestPermission.REQUEST_CODE, "", "startFlexibleUpdate", "(Landroid/app/Activity;I)Z", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;I)Z", "startImmediateUpdate", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "updateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "getUpdateInfo", "()Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "<init>", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Available extends AppUpdateResult {
        private final AppUpdateManager appUpdateManager;
        private final AppUpdateInfo updateInfo;

        @JvmName(name = "getUpdateInfo")
        public final AppUpdateInfo getUpdateInfo() {
            return this.updateInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Available(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(appUpdateManager, "");
            Intrinsics.checkNotNullParameter(appUpdateInfo, "");
            this.appUpdateManager = appUpdateManager;
            this.updateInfo = appUpdateInfo;
        }

        public final boolean startFlexibleUpdate(Activity activity, int requestCode) {
            Intrinsics.checkNotNullParameter(activity, "");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, 0, activity, requestCode);
        }

        public final boolean startFlexibleUpdate(Fragment fragment, int requestCode) {
            Intrinsics.checkNotNullParameter(fragment, "");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.appUpdateManager, this.updateInfo, 0, fragment, requestCode);
        }

        public final boolean startImmediateUpdate(Activity activity, int requestCode) {
            Intrinsics.checkNotNullParameter(activity, "");
            return this.appUpdateManager.startUpdateFlowForResult(this.updateInfo, 1, activity, requestCode);
        }

        public final boolean startImmediateUpdate(Fragment fragment, int requestCode) {
            Intrinsics.checkNotNullParameter(fragment, "");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.appUpdateManager, this.updateInfo, 1, fragment, requestCode);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "completeUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "<init>", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Downloaded extends AppUpdateResult {
        private final AppUpdateManager appUpdateManager;

        public final Object completeUpdate(Continuation<? super Unit> continuation) {
            Object requestCompleteUpdate = AppUpdateManagerKtxKt.requestCompleteUpdate(this.appUpdateManager, continuation);
            return requestCompleteUpdate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? requestCompleteUpdate : Unit.INSTANCE;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Downloaded(AppUpdateManager appUpdateManager) {
            super(null);
            Intrinsics.checkNotNullParameter(appUpdateManager, "");
            this.appUpdateManager = appUpdateManager;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "Lcom/google/android/play/core/install/InstallState;", "installState", "Lcom/google/android/play/core/install/InstallState;", "getInstallState", "()Lcom/google/android/play/core/install/InstallState;", "<init>", "(Lcom/google/android/play/core/install/InstallState;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class InProgress extends AppUpdateResult {
        private final InstallState installState;

        @JvmName(name = "getInstallState")
        public final InstallState getInstallState() {
            return this.installState;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InProgress(InstallState installState) {
            super(null);
            Intrinsics.checkNotNullParameter(installState, "");
            this.installState = installState;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "<init>", "()V"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class NotAvailable extends AppUpdateResult {
        public static final NotAvailable INSTANCE = new NotAvailable();

        private NotAvailable() {
            super(null);
        }
    }

    private AppUpdateResult() {
    }

    public /* synthetic */ AppUpdateResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
