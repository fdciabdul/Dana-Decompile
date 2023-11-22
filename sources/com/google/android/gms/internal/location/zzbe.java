package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class zzbe extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final Map zzf;
    private final Map zzg;
    private final Map zzh;
    private final String zzi;
    private boolean zzj;

    public zzbe(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new HashMap();
        this.zzg = new HashMap();
        this.zzh = new HashMap();
        this.zzi = str;
    }

    private final boolean zzG(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures == null) {
            return false;
        }
        int length = availableFeatures.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                feature2 = null;
                break;
            }
            feature2 = availableFeatures[i];
            if (feature.getName().equals(feature2.getName())) {
                break;
            }
            i++;
        }
        return feature2 != null && feature2.getVersion() >= feature.getVersion();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzam ? (zzam) queryLocalInterface : new zzal(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        synchronized (this) {
            if (isConnected()) {
                try {
                    synchronized (this.zzf) {
                        Iterator it = this.zzf.values().iterator();
                        while (it.hasNext()) {
                            ((zzam) getService()).zzz(zzbh.zzb((zzbc) it.next(), null));
                        }
                        this.zzf.clear();
                    }
                    synchronized (this.zzg) {
                        Iterator it2 = this.zzg.values().iterator();
                        while (it2.hasNext()) {
                            ((zzam) getService()).zzz(zzbh.zza((zzay) it2.next(), null));
                        }
                        this.zzg.clear();
                    }
                    synchronized (this.zzh) {
                        Iterator it3 = this.zzh.values().iterator();
                        while (it3.hasNext()) {
                            ((zzam) getService()).zzy(new zzj(2, null, (zzaz) it3.next(), null));
                        }
                        this.zzh.clear();
                    }
                    if (this.zzj) {
                        zzF(false, new zzat(this));
                    }
                } catch (Exception e) {
                    InstrumentInjector.log_e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.location.zzy.zzj;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzi);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzA(PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        ((zzam) getService()).zzz(new zzbh(2, null, null, null, pendingIntent, zzaiVar, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(zzbf zzbfVar, ListenerHolder listenerHolder, zzai zzaiVar) throws RemoteException {
        zzay zzayVar;
        ListenerHolder.ListenerKey listenerKey = listenerHolder.getListenerKey();
        if (listenerKey == null) {
            InstrumentInjector.log_e("LocationClientImpl", "requested location updates on dead listener", new RuntimeException());
            return;
        }
        getContext();
        synchronized (this) {
            synchronized (this.zzg) {
                zzay zzayVar2 = (zzay) this.zzg.get(listenerKey);
                if (zzayVar2 == null) {
                    zzayVar2 = new zzay(listenerHolder);
                    this.zzg.put(listenerKey, zzayVar2);
                }
                zzayVar = zzayVar2;
            }
            ((zzam) getService()).zzz(new zzbh(1, zzbfVar, null, zzayVar, null, zzaiVar, listenerKey.toIdString()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(zzbf zzbfVar, ListenerHolder listenerHolder, zzai zzaiVar) throws RemoteException {
        zzbc zzbcVar;
        ListenerHolder.ListenerKey listenerKey = listenerHolder.getListenerKey();
        if (listenerKey == null) {
            InstrumentInjector.log_e("LocationClientImpl", "requested location updates on dead listener", new RuntimeException());
            return;
        }
        getContext();
        synchronized (this) {
            synchronized (this.zzf) {
                zzbc zzbcVar2 = (zzbc) this.zzf.get(listenerKey);
                if (zzbcVar2 == null) {
                    zzbcVar2 = new zzbc(listenerHolder);
                    this.zzf.put(listenerKey, zzbcVar2);
                }
                zzbcVar = zzbcVar2;
            }
            ((zzam) getService()).zzz(new zzbh(1, zzbfVar, zzbcVar, null, null, zzaiVar, listenerKey.toIdString()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzD(zzbf zzbfVar, PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        getContext();
        zzam zzamVar = (zzam) getService();
        int hashCode = pendingIntent.hashCode();
        StringBuilder sb = new StringBuilder(25);
        sb.append("PendingIntent@");
        sb.append(hashCode);
        zzamVar.zzz(new zzbh(1, zzbfVar, null, null, pendingIntent, zzaiVar, sb.toString()));
    }

    public final void zzE(Location location, IStatusCallback iStatusCallback) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzy.zzh)) {
            ((zzam) getService()).zzv(location, iStatusCallback);
            return;
        }
        ((zzam) getService()).zzu(location);
        iStatusCallback.onResult(Status.RESULT_SUCCESS);
    }

    public final void zzF(boolean z, IStatusCallback iStatusCallback) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzy.zzg)) {
            ((zzam) getService()).zzx(z, iStatusCallback);
        } else {
            ((zzam) getService()).zzw(z);
            iStatusCallback.onResult(Status.RESULT_SUCCESS);
        }
        this.zzj = z;
    }

    public final LocationAvailability zzp() throws RemoteException {
        return ((zzam) getService()).zzf(getContext().getPackageName());
    }

    public final void zzq(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        Preconditions.checkNotNull(geofencingRequest, "geofencingRequest can't be null.");
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzg(geofencingRequest, pendingIntent, new zzba(resultHolder));
    }

    public final void zzr(LocationSettingsRequest locationSettingsRequest, BaseImplementation.ResultHolder resultHolder, String str) throws RemoteException {
        Preconditions.checkArgument(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        Preconditions.checkArgument(resultHolder != null, "listener can't be null.");
        ((zzam) getService()).zzh(locationSettingsRequest, new zzbd(resultHolder), null);
    }

    public final void zzs(zzai zzaiVar) throws RemoteException {
        ((zzam) getService()).zzi(zzaiVar);
    }

    public final void zzt(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken, zzao zzaoVar) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzy.zze)) {
            final ICancelToken zze2 = ((zzam) getService()).zze(currentLocationRequest, zzaoVar);
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzar
                    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                    public final void onCanceled() {
                        ICancelToken iCancelToken = ICancelToken.this;
                        int i = zzbe.zze;
                        try {
                            iCancelToken.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        final AtomicReference atomicReference = new AtomicReference();
        OnTokenCanceledListener onTokenCanceledListener = new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzas
            @Override // com.google.android.gms.tasks.OnTokenCanceledListener
            public final void onCanceled() {
                zzbe zzbeVar = zzbe.this;
                ListenerHolder.ListenerKey listenerKey = ((ListenerHolder) Preconditions.checkNotNull((ListenerHolder) atomicReference.get())).getListenerKey();
                if (listenerKey != null) {
                    try {
                        zzbeVar.zzy(listenerKey, null);
                    } catch (RemoteException unused) {
                    }
                }
            }
        };
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(new zzau(this, zzaoVar, onTokenCanceledListener), zzbn.zza(Looper.getMainLooper()), "LocationCallback");
        atomicReference.set(createListenerHolder);
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(onTokenCanceledListener);
        }
        LocationRequest create = LocationRequest.create();
        create.setPriority(currentLocationRequest.getPriority());
        create.setInterval(0L);
        create.setFastestInterval(0L);
        create.setExpirationDuration(currentLocationRequest.getDurationMillis());
        zzbf zzc = zzbf.zzc(null, create);
        zzc.zzj = true;
        zzc.zze(currentLocationRequest.getMaxUpdateAgeMillis());
        zzB(zzc, createListenerHolder, new zzav(this, zzaoVar));
    }

    public final void zzu(LastLocationRequest lastLocationRequest, zzao zzaoVar) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzy.zzf)) {
            ((zzam) getService()).zzj(lastLocationRequest, zzaoVar);
        } else {
            zzaoVar.zzb(Status.RESULT_SUCCESS, ((zzam) getService()).zzd());
        }
    }

    public final void zzv(PendingIntent pendingIntent) throws RemoteException {
        Preconditions.checkNotNull(pendingIntent);
        ((zzam) getService()).zzl(pendingIntent);
    }

    public final void zzw(PendingIntent pendingIntent, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzn(pendingIntent, new zzba(resultHolder), getContext().getPackageName());
    }

    public final void zzx(List list, BaseImplementation.ResultHolder resultHolder) throws RemoteException {
        Preconditions.checkArgument(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzo((String[]) list.toArray(new String[0]), new zzba(resultHolder), getContext().getPackageName());
    }

    public final void zzy(ListenerHolder.ListenerKey listenerKey, zzai zzaiVar) throws RemoteException {
        Preconditions.checkNotNull(listenerKey, "Invalid null listener key");
        synchronized (this.zzg) {
            zzay zzayVar = (zzay) this.zzg.remove(listenerKey);
            if (zzayVar != null) {
                zzayVar.zzc();
                ((zzam) getService()).zzz(zzbh.zza(zzayVar, zzaiVar));
            }
        }
    }

    public final void zzz(ListenerHolder.ListenerKey listenerKey, zzai zzaiVar) throws RemoteException {
        Preconditions.checkNotNull(listenerKey, "Invalid null listener key");
        synchronized (this.zzf) {
            zzbc zzbcVar = (zzbc) this.zzf.remove(listenerKey);
            if (zzbcVar != null) {
                zzbcVar.zzc();
                ((zzam) getService()).zzz(zzbh.zzb(zzbcVar, zzaiVar));
            }
        }
    }
}
