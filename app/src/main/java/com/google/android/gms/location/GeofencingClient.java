package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes3.dex */
public class GeofencingClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    public static final /* synthetic */ int zza = 0;

    public GeofencingClient(Activity activity) {
        super(activity, LocationServices.API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> addGeofences(GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        final GeofencingRequest zza2 = geofencingRequest.zza(getContextAttributionTag());
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzay
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                GeofencingRequest geofencingRequest2 = GeofencingRequest.this;
                PendingIntent pendingIntent2 = pendingIntent;
                int i = GeofencingClient.zza;
                ((com.google.android.gms.internal.location.zzbe) obj).zzq(geofencingRequest2, pendingIntent2, new zzba((TaskCompletionSource) obj2));
            }
        }).setMethodKey(2424).build());
    }

    public Task<Void> removeGeofences(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzax
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                PendingIntent pendingIntent2 = pendingIntent;
                int i = GeofencingClient.zza;
                ((com.google.android.gms.internal.location.zzbe) obj).zzw(pendingIntent2, new zzba((TaskCompletionSource) obj2));
            }
        }).setMethodKey(2425).build());
    }

    public GeofencingClient(Context context) {
        super(context, LocationServices.API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> removeGeofences(final List<String> list) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.location.zzaz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                List list2 = list;
                int i = GeofencingClient.zza;
                ((com.google.android.gms.internal.location.zzbe) obj).zzx(list2, new zzba((TaskCompletionSource) obj2));
            }
        }).setMethodKey(2425).build());
    }
}
