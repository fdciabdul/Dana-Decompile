package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes3.dex */
public final class zzcc {
    private static final String zza = "zzcc";
    private static Context zzb;
    private static zzf zzc;

    public static zzf zza(Context context, MapsInitializer.Renderer renderer) throws GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull(context);
        InstrumentInjector.log_d(zza, "preferredRenderer: ".concat(String.valueOf(String.valueOf(renderer))));
        zzf zzfVar = zzc;
        if (zzfVar == null) {
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
            if (isGooglePlayServicesAvailable == 0) {
                zzf zzd = zzd(context, renderer);
                zzc = zzd;
                try {
                    if (zzd.zzd() == 2) {
                        try {
                            zzc.zzm(ObjectWrapper.wrap(zzc(context, renderer)));
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        } catch (UnsatisfiedLinkError unused) {
                            InstrumentInjector.log_w(zza, "Caught UnsatisfiedLinkError attempting to load the LATEST renderer's native library. Attempting to use the LEGACY renderer instead.");
                            zzb = null;
                            zzc = zzd(context, MapsInitializer.Renderer.LEGACY);
                        }
                    }
                    try {
                        zzf zzfVar2 = zzc;
                        Context zzc2 = zzc(context, renderer);
                        zzc2.getClass();
                        zzfVar2.zzk(ObjectWrapper.wrap(zzc2.getResources()), 18020000);
                        return zzc;
                    } catch (RemoteException e2) {
                        throw new RuntimeRemoteException(e2);
                    }
                } catch (RemoteException e3) {
                    throw new RuntimeRemoteException(e3);
                }
            }
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        return zzfVar;
    }

    private static Context zzb(Exception exc, Context context) {
        InstrumentInjector.log_e(zza, "Failed to load maps module, use pre-Chimera", exc);
        return GooglePlayServicesUtil.getRemoteContext(context);
    }

    private static Context zzc(Context context, MapsInitializer.Renderer renderer) {
        Context zzb2;
        Context context2 = zzb;
        if (context2 == null) {
            String str = renderer == MapsInitializer.Renderer.LEGACY ? "com.google.android.gms.maps_legacy_dynamite" : "com.google.android.gms.maps_core_dynamite";
            try {
                zzb2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str).getModuleContext();
            } catch (Exception e) {
                if (!str.equals("com.google.android.gms.maps_dynamite")) {
                    try {
                        InstrumentInjector.log_d(zza, "Attempting to load maps_dynamite again.");
                        zzb2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
                    } catch (Exception e2) {
                        zzb2 = zzb(e2, context);
                    }
                } else {
                    zzb2 = zzb(e, context);
                }
            }
            zzb = zzb2;
            return zzb2;
        }
        return context2;
    }

    private static zzf zzd(Context context, MapsInitializer.Renderer renderer) {
        InstrumentInjector.log_i(zza, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) zze(((ClassLoader) Preconditions.checkNotNull(zzc(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (!(queryLocalInterface instanceof zzf)) {
                return new zze(iBinder);
            }
            return (zzf) queryLocalInterface;
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl", e);
        }
    }

    private static Object zze(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(String.valueOf(cls.getName())), e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(String.valueOf(cls.getName())), e2);
        }
    }
}
