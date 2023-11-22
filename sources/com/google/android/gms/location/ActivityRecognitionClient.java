package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes7.dex */
public class ActivityRecognitionClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    public static final /* synthetic */ int zza = 0;

    public ActivityRecognitionClient(Activity activity) {
        super(activity, LocationServices.API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> removeActivityTransitionUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                PendingIntent pendingIntent2 = pendingIntent;
                int i = ActivityRecognitionClient.zza;
                zzj zzjVar = new zzj((TaskCompletionSource) obj2);
                Preconditions.checkNotNull(zzjVar, "ResultHolder not provided.");
                ((com.google.android.gms.internal.location.zzam) ((com.google.android.gms.internal.location.zzbe) obj).getService()).zzk(pendingIntent2, new StatusCallback(zzjVar));
            }
        }).setMethodKey(SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_UMT_FAILED).build());
    }

    public Task<Void> removeActivityUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zze
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                PendingIntent pendingIntent2 = pendingIntent;
                int i = ActivityRecognitionClient.zza;
                ((com.google.android.gms.internal.location.zzbe) obj).zzv(pendingIntent2);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).setMethodKey(SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_NO_APPKEY).build());
    }

    public Task<Void> removeSleepSegmentUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                PendingIntent pendingIntent2 = pendingIntent;
                int i = ActivityRecognitionClient.zza;
                zzj zzjVar = new zzj((TaskCompletionSource) obj2);
                Preconditions.checkNotNull(pendingIntent2, "PendingIntent must be specified.");
                Preconditions.checkNotNull(zzjVar, "ResultHolder not provided.");
                ((com.google.android.gms.internal.location.zzam) ((com.google.android.gms.internal.location.zzbe) obj).getService()).zzp(pendingIntent2, new StatusCallback(zzjVar));
            }
        }).setMethodKey(2411).build());
    }

    public Task<Void> requestActivityTransitionUpdates(final ActivityTransitionRequest activityTransitionRequest, final PendingIntent pendingIntent) {
        activityTransitionRequest.zza(getContextAttributionTag());
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ActivityTransitionRequest activityTransitionRequest2 = ActivityTransitionRequest.this;
                PendingIntent pendingIntent2 = pendingIntent;
                int i = ActivityRecognitionClient.zza;
                zzj zzjVar = new zzj((TaskCompletionSource) obj2);
                Preconditions.checkNotNull(activityTransitionRequest2, "activityTransitionRequest must be specified.");
                Preconditions.checkNotNull(pendingIntent2, "PendingIntent must be specified.");
                Preconditions.checkNotNull(zzjVar, "ResultHolder not provided.");
                ((com.google.android.gms.internal.location.zzam) ((com.google.android.gms.internal.location.zzbe) obj).getService()).zzq(activityTransitionRequest2, pendingIntent2, new StatusCallback(zzjVar));
            }
        }).setMethodKey(SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_SIGN_FAILED).build());
    }

    public Task<Void> requestActivityUpdates(long j, final PendingIntent pendingIntent) {
        zzk zzkVar = new zzk();
        zzkVar.zza(j);
        final zzl zzb = zzkVar.zzb();
        zzb.zza(getContextAttributionTag());
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzl zzlVar = zzl.this;
                PendingIntent pendingIntent2 = pendingIntent;
                int i = ActivityRecognitionClient.zza;
                zzj zzjVar = new zzj((TaskCompletionSource) obj2);
                Preconditions.checkNotNull(zzlVar, "ActivityRecognitionRequest can't be null.");
                Preconditions.checkNotNull(pendingIntent2, "PendingIntent must be specified.");
                Preconditions.checkNotNull(zzjVar, "ResultHolder not provided.");
                ((com.google.android.gms.internal.location.zzam) ((com.google.android.gms.internal.location.zzbe) obj).getService()).zzs(zzlVar, pendingIntent2, new StatusCallback(zzjVar));
            }
        }).setMethodKey(SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_INVALID_PARA).build());
    }

    public Task<Void> requestSleepSegmentUpdates(final PendingIntent pendingIntent, final SleepSegmentRequest sleepSegmentRequest) {
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ActivityRecognitionClient activityRecognitionClient = ActivityRecognitionClient.this;
                ((com.google.android.gms.internal.location.zzam) ((com.google.android.gms.internal.location.zzbe) obj).getService()).zzt(pendingIntent, sleepSegmentRequest, new zzi(activityRecognitionClient, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzy.zzb).setMethodKey(2410).build());
    }

    public ActivityRecognitionClient(Context context) {
        super(context, LocationServices.API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
