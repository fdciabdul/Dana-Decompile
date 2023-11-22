package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallStateUpdatedListener;

/* loaded from: classes3.dex */
final class zzg implements AppUpdateManager {
    private final zzr zza;
    private final zzc zzb;
    private final Context zzc;
    private final Handler zzd = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzr zzrVar, zzc zzcVar, Context context) {
        this.zza = zzrVar;
        this.zzb = zzcVar;
        this.zzc = context;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Void> completeUpdate() {
        return this.zza.zzd(this.zzc.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.zza.zze(this.zzc.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        synchronized (this) {
            this.zzb.zzb(installStateUpdatedListener);
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        if (appUpdateInfo == null || activity == null || appUpdateOptions == null || appUpdateInfo.zzd()) {
            return Tasks.forException(new InstallException(-4));
        }
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return Tasks.forException(new InstallException(-6));
        }
        appUpdateInfo.zzc();
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", appUpdateInfo.zza(appUpdateOptions));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        intent.putExtra("result_receiver", new zze(this, this.zzd, taskCompletionSource));
        activity.startActivity(intent);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) throws IntentSender.SendIntentException {
        AppUpdateOptions defaultOptions = AppUpdateOptions.defaultOptions(i);
        if (activity == null) {
            return false;
        }
        return startUpdateFlowForResult(appUpdateInfo, new zzf(this, activity), defaultOptions, i2);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        synchronized (this) {
            this.zzb.zzc(installStateUpdatedListener);
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, intentSenderForResultStarter, AppUpdateOptions.defaultOptions(i), i2);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException {
        if (activity == null) {
            return false;
        }
        return startUpdateFlowForResult(appUpdateInfo, new zzf(this, activity), appUpdateOptions, i);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException {
        if (appUpdateInfo == null || intentSenderForResultStarter == null || appUpdateOptions == null || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) || appUpdateInfo.zzd()) {
            return false;
        }
        appUpdateInfo.zzc();
        intentSenderForResultStarter.startIntentSenderForResult(appUpdateInfo.zza(appUpdateOptions).getIntentSender(), i, null, 0, 0, 0, null);
        return true;
    }
}
