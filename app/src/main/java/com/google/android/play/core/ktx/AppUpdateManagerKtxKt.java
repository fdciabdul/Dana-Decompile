package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a7\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\t*\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\u0004*\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0018\u001a\u00020\u0017*\u00020\b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019\u001a'\u0010\u001d\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0016\u0010\"\u001a\u00020\u001f*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0016\u0010\"\u001a\u00020\u001f*\u00020#8Ç\u0002¢\u0006\u0006\u001a\u0004\b \u0010$\"\u0018\u0010'\u001a\u0004\u0018\u00010\u0012*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0016\u0010*\u001a\u00020\u0017*\u00020#8Ç\u0002¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0016\u0010-\u001a\u00020\u0012*\u00020#8Ç\u0002¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0016\u00100\u001a\u00020\u0012*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0016\u00100\u001a\u00020\u0012*\u00020#8Ç\u0002¢\u0006\u0006\u001a\u0004\b.\u0010,\"\u0016\u00101\u001a\u00020\u0017*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b1\u00102\"\u0016\u00103\u001a\u00020\u0017*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b3\u00102\"\u0016\u00107\u001a\u000204*\u00020#8Ç\u0002¢\u0006\u0006\u001a\u0004\b5\u00106\"\u0016\u00109\u001a\u00020\u001f*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b8\u0010!\"\u0016\u00109\u001a\u00020\u001f*\u00020#8Ç\u0002¢\u0006\u0006\u001a\u0004\b8\u0010$\"\u0016\u0010;\u001a\u00020\u0012*\u00020\t8Ç\u0002¢\u0006\u0006\u001a\u0004\b:\u0010/\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lcom/google/android/gms/tasks/Task;", "task", "Lkotlin/Function0;", "", "onCanceled", "runTask", "(Lcom/google/android/gms/tasks/Task;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "requestAppUpdateInfo", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCompleteUpdate", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "requestUpdateFlow", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;)Lkotlinx/coroutines/flow/Flow;", "appUpdateInfo", "", "appUpdateType", "Landroidx/fragment/app/Fragment;", "fragment", RequestPermission.REQUEST_CODE, "", "startUpdateFlowForResult", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;ILandroidx/fragment/app/Fragment;I)Z", "E", "Lkotlinx/coroutines/channels/SendChannel;", LottieParams.KEY_ELEMENT_ID, "tryOffer", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Z", "", "getBytesDownloaded", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)J", "bytesDownloaded", "Lcom/google/android/play/core/install/InstallState;", "(Lcom/google/android/play/core/install/InstallState;)J", "getClientVersionStalenessDays", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Ljava/lang/Integer;", "clientVersionStalenessDays", "getHasTerminalStatus", "(Lcom/google/android/play/core/install/InstallState;)Z", "hasTerminalStatus", "getInstallErrorCode", "(Lcom/google/android/play/core/install/InstallState;)I", "installErrorCode", "getInstallStatus", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)I", "installStatus", "isFlexibleUpdateAllowed", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Z", "isImmediateUpdateAllowed", "", "getPackageName", "(Lcom/google/android/play/core/install/InstallState;)Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "getTotalBytesToDownload", "totalBytesToDownload", "getUpdatePriority", "updatePriority"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AppUpdateManagerKtxKt {
    @JvmName(name = "getInstallErrorCode")
    public static final int getInstallErrorCode(InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "");
        return installState.installErrorCode();
    }

    @JvmName(name = "getInstallStatus")
    public static final int getInstallStatus(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.installStatus();
    }

    @JvmName(name = "getInstallStatus")
    public static final int getInstallStatus(InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "");
        return installState.installStatus();
    }

    @JvmName(name = "getUpdatePriority")
    public static final int getUpdatePriority(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.updatePriority();
    }

    @JvmName(name = "getBytesDownloaded")
    public static final long getBytesDownloaded(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.bytesDownloaded();
    }

    @JvmName(name = "getBytesDownloaded")
    public static final long getBytesDownloaded(InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "");
        return installState.bytesDownloaded();
    }

    @JvmName(name = "getTotalBytesToDownload")
    public static final long getTotalBytesToDownload(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.totalBytesToDownload();
    }

    @JvmName(name = "getTotalBytesToDownload")
    public static final long getTotalBytesToDownload(InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "");
        return installState.totalBytesToDownload();
    }

    @JvmName(name = "getClientVersionStalenessDays")
    public static final Integer getClientVersionStalenessDays(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.clientVersionStalenessDays();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager r5, kotlin.coroutines.Continuation<? super com.google.android.play.core.appupdate.AppUpdateInfo> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            if (r0 == 0) goto L14
            r0 = r6
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = (com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = new com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = ""
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.gms.tasks.Task r5 = r5.getAppUpdateInfo()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            r0.label = r3
            r6 = 2
            r2 = 0
            java.lang.Object r6 = runTask$default(r5, r2, r0, r6, r2)
            if (r6 != r1) goto L49
            return r1
        L49:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.requestAppUpdateInfo(com.google.android.play.core.appupdate.AppUpdateManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object requestCompleteUpdate(AppUpdateManager appUpdateManager, Continuation<? super Unit> continuation) {
        Task<Void> completeUpdate = appUpdateManager.completeUpdate();
        Intrinsics.checkNotNullExpressionValue(completeUpdate, "");
        Object runTask$default = runTask$default(completeUpdate, null, continuation, 2, null);
        return runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runTask$default : Unit.INSTANCE;
    }

    public static final <T> Object runTask(Task<T> task, final Function0<Unit> function0, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                function0.invoke();
            }
        });
        if (task.isComplete()) {
            if (task.isSuccessful()) {
                cancellableContinuationImpl2.resumeWith(Result.m3179constructorimpl(task.getResult()));
            } else {
                Exception exception = task.getException();
                Intrinsics.checkNotNull(exception);
                cancellableContinuationImpl2.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(exception)));
            }
        } else {
            task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(T t) {
                    cancellableContinuationImpl2.resumeWith(Result.m3179constructorimpl(t));
                }
            });
            task.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Intrinsics.checkNotNullParameter(exc, "");
                    cancellableContinuationImpl2.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(exc)));
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object runTask$default(Task task, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$2
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        return runTask(task, function0, continuation);
    }

    @JvmName(name = "getPackageName")
    public static final String getPackageName(InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "");
        String packageName = installState.packageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        return packageName;
    }

    public static final Flow<AppUpdateResult> requestUpdateFlow(AppUpdateManager appUpdateManager) throws InstallException {
        Intrinsics.checkNotNullParameter(appUpdateManager, "");
        return FlowKt.conflate(FlowKt.callbackFlow(new AppUpdateManagerKtxKt$requestUpdateFlow$1(appUpdateManager, null)));
    }

    @JvmName(name = "getHasTerminalStatus")
    public static final boolean getHasTerminalStatus(InstallState installState) {
        Intrinsics.checkNotNullParameter(installState, "");
        int installStatus = installState.installStatus();
        return installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6;
    }

    @JvmName(name = "isFlexibleUpdateAllowed")
    public static final boolean isFlexibleUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.isUpdateTypeAllowed(0);
    }

    @JvmName(name = "isImmediateUpdateAllowed")
    public static final boolean isImmediateUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        return appUpdateInfo.isUpdateTypeAllowed(1);
    }

    public static final boolean startUpdateFlowForResult(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, int i, final Fragment fragment, int i2) throws IntentSender.SendIntentException {
        Intrinsics.checkNotNullParameter(appUpdateManager, "");
        Intrinsics.checkNotNullParameter(appUpdateInfo, "");
        Intrinsics.checkNotNullParameter(fragment, "");
        if (appUpdateInfo.isUpdateTypeAllowed(i)) {
            return appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, new IntentSenderForResultStarter() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$startUpdateFlowForResult$1
                @Override // com.google.android.play.core.common.IntentSenderForResultStarter
                public final void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
                    Fragment.this.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
                }
            }, i2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> boolean tryOffer(SendChannel<? super E> sendChannel, E e) {
        Intrinsics.checkNotNullParameter(sendChannel, "");
        return ChannelResult.m4642isSuccessimpl(sendChannel.mo42trySendJP2dKIU(e));
    }
}
