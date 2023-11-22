package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.framework.common.ExceptionCode;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public interface VersionPolicy {

        /* loaded from: classes.dex */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* loaded from: classes.dex */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder();
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                InstrumentInjector.log_e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            InstrumentInjector.log_w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            InstrumentInjector.log_e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    @ResultIgnorabilityUnspecified
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        int i;
        IObjectWrapper zzh2;
        DynamiteModule dynamiteModule;
        zzr zzrVar;
        boolean z;
        IObjectWrapper zze2;
        Context applicationContext = context.getApplicationContext();
        zzm zzmVar = null;
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzg;
            zzn zznVar = (zzn) threadLocal.get();
            zzn zznVar2 = new zzn(zzmVar);
            threadLocal.set(zznVar2);
            ThreadLocal threadLocal2 = zzh;
            long longValue = ((Long) threadLocal2.get()).longValue();
            try {
                threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
                VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzi);
                int i2 = selectModule.localVersion;
                int i3 = selectModule.remoteVersion;
                StringBuilder sb = new StringBuilder();
                sb.append("Considering local module ");
                sb.append(str);
                sb.append(":");
                sb.append(i2);
                sb.append(" and remote module ");
                sb.append(str);
                sb.append(":");
                sb.append(i3);
                InstrumentInjector.log_i("DynamiteModule", sb.toString());
                int i4 = selectModule.selection;
                if (i4 != 0) {
                    if (i4 == -1) {
                        if (selectModule.localVersion != 0) {
                            i4 = -1;
                        }
                    }
                    if (i4 != 1 || selectModule.remoteVersion != 0) {
                        if (i4 == -1) {
                            DynamiteModule zzc2 = zzc(applicationContext, str);
                            if (longValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(longValue));
                            }
                            Cursor cursor = zznVar2.zza;
                            if (cursor != null) {
                                cursor.close();
                            }
                            threadLocal.set(zznVar);
                            return zzc2;
                        } else if (i4 != 1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("VersionPolicy returned invalid code:");
                            sb2.append(i4);
                            throw new LoadingException(sb2.toString(), null);
                        } else {
                            try {
                                try {
                                    int i5 = selectModule.remoteVersion;
                                    try {
                                        try {
                                            synchronized (DynamiteModule.class) {
                                                try {
                                                    if (!zzf(context)) {
                                                        try {
                                                            throw new LoadingException("Remote loading disabled", null);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            throw th;
                                                        }
                                                    }
                                                    Boolean bool = zzb;
                                                    if (bool != null) {
                                                        if (bool.booleanValue()) {
                                                            StringBuilder sb3 = new StringBuilder();
                                                            sb3.append("Selected remote version of ");
                                                            sb3.append(str);
                                                            sb3.append(", version >= ");
                                                            sb3.append(i5);
                                                            InstrumentInjector.log_i("DynamiteModule", sb3.toString());
                                                            synchronized (DynamiteModule.class) {
                                                                zzrVar = zzl;
                                                            }
                                                            if (zzrVar == null) {
                                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                                            }
                                                            zzn zznVar3 = (zzn) threadLocal.get();
                                                            if (zznVar3 == null || zznVar3.zza == null) {
                                                                throw new LoadingException("No result cursor", null);
                                                            }
                                                            Context applicationContext2 = context.getApplicationContext();
                                                            Cursor cursor2 = zznVar3.zza;
                                                            ObjectWrapper.wrap(null);
                                                            synchronized (DynamiteModule.class) {
                                                                z = zze >= 2;
                                                            }
                                                            if (z) {
                                                                InstrumentInjector.log_v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                                zze2 = zzrVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i5, ObjectWrapper.wrap(cursor2));
                                                            } else {
                                                                InstrumentInjector.log_w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                                zze2 = zzrVar.zze(ObjectWrapper.wrap(applicationContext2), str, i5, ObjectWrapper.wrap(cursor2));
                                                            }
                                                            Context context2 = (Context) ObjectWrapper.unwrap(zze2);
                                                            if (context2 == null) {
                                                                throw new LoadingException("Failed to get module context", null);
                                                            }
                                                            dynamiteModule = new DynamiteModule(context2);
                                                        } else {
                                                            StringBuilder sb4 = new StringBuilder();
                                                            sb4.append("Selected remote version of ");
                                                            sb4.append(str);
                                                            sb4.append(", version >= ");
                                                            sb4.append(i5);
                                                            InstrumentInjector.log_i("DynamiteModule", sb4.toString());
                                                            zzq zzg2 = zzg(context);
                                                            if (zzg2 == null) {
                                                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                                            }
                                                            int zze3 = zzg2.zze();
                                                            if (zze3 >= 3) {
                                                                zzn zznVar4 = (zzn) threadLocal.get();
                                                                if (zznVar4 == null) {
                                                                    throw new LoadingException("No cached result cursor holder", null);
                                                                }
                                                                zzh2 = zzg2.zzi(ObjectWrapper.wrap(context), str, i5, ObjectWrapper.wrap(zznVar4.zza));
                                                            } else if (zze3 == 2) {
                                                                InstrumentInjector.log_w("DynamiteModule", "IDynamite loader version = 2");
                                                                zzh2 = zzg2.zzj(ObjectWrapper.wrap(context), str, i5);
                                                            } else {
                                                                InstrumentInjector.log_w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                                zzh2 = zzg2.zzh(ObjectWrapper.wrap(context), str, i5);
                                                            }
                                                            Object unwrap = ObjectWrapper.unwrap(zzh2);
                                                            if (unwrap == null) {
                                                                throw new LoadingException("Failed to load remote module.", null);
                                                            }
                                                            dynamiteModule = new DynamiteModule((Context) unwrap);
                                                        }
                                                        if (longValue == 0) {
                                                            threadLocal2.remove();
                                                        } else {
                                                            threadLocal2.set(Long.valueOf(longValue));
                                                        }
                                                        Cursor cursor3 = zznVar2.zza;
                                                        if (cursor3 != null) {
                                                            cursor3.close();
                                                        }
                                                        threadLocal.set(zznVar);
                                                        return dynamiteModule;
                                                    }
                                                    throw new LoadingException("Failed to determine which loading route to use.", null);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                            }
                                        } catch (RemoteException e) {
                                            e = e;
                                            throw new LoadingException("Failed to load remote module.", e, null);
                                        } catch (LoadingException e2) {
                                            throw e2;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            CrashUtils.addDynamiteErrorToDropBox(context, th);
                                            throw new LoadingException("Failed to load remote module.", th, null);
                                        }
                                    } catch (RemoteException e3) {
                                        e = e3;
                                        throw new LoadingException("Failed to load remote module.", e, null);
                                    } catch (LoadingException e4) {
                                        throw e4;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                                        throw new LoadingException("Failed to load remote module.", th, null);
                                    }
                                } catch (LoadingException e5) {
                                    e = e5;
                                    String message = e.getMessage();
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("Failed to load remote module: ");
                                    sb5.append(message);
                                    InstrumentInjector.log_w("DynamiteModule", sb5.toString());
                                    i = selectModule.localVersion;
                                    if (i == 0) {
                                    }
                                    throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                                }
                            } catch (LoadingException e6) {
                                e = e6;
                                String message2 = e.getMessage();
                                StringBuilder sb52 = new StringBuilder();
                                sb52.append("Failed to load remote module: ");
                                sb52.append(message2);
                                InstrumentInjector.log_w("DynamiteModule", sb52.toString());
                                i = selectModule.localVersion;
                                if (i == 0 && versionPolicy.selectModule(context, str, new zzo(i, 0)).selection == -1) {
                                    return zzc(applicationContext, str);
                                }
                                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                            }
                        }
                    }
                }
                int i6 = selectModule.localVersion;
                int i7 = selectModule.remoteVersion;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("No acceptable module ");
                sb6.append(str);
                sb6.append(" found. Local version is ");
                sb6.append(i6);
                sb6.append(" and remote version is ");
                sb6.append(i7);
                sb6.append(".");
                throw new LoadingException(sb6.toString(), null);
            } finally {
                if (longValue == 0) {
                    zzh.remove();
                } else {
                    zzh.set(Long.valueOf(longValue));
                }
                Cursor cursor4 = zznVar2.zza;
                if (cursor4 != null) {
                    cursor4.close();
                }
                zzg.set(zznVar);
            }
        }
        throw new LoadingException("null application Context", null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x01b1 -> B:128:0x01b6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x01b3 -> B:128:0x01b6). Please submit an issue!!! */
    public static int zza(Context context, String str, boolean z) {
        Field declaredField;
        ClassLoader zzcVar;
        Throwable th;
        Cursor cursor;
        RemoteException e;
        Cursor cursor2;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                int i = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String obj = e2.toString();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to load module via V2: ");
                        sb.append(obj);
                        InstrumentInjector.log_w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                zzd(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else if (!zzf(context)) {
                            return 0;
                        } else {
                            if (zzd || Boolean.TRUE.equals(null)) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    int zzb2 = zzb(context, str, z, true);
                                    String str2 = zzc;
                                    if (str2 != null && !str2.isEmpty()) {
                                        ClassLoader zza2 = zzb.zza();
                                        if (zza2 == null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str3 = zzc;
                                                Preconditions.checkNotNull(str3);
                                                zzcVar = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str4 = zzc;
                                                Preconditions.checkNotNull(str4);
                                                zzcVar = new zzc(str4, ClassLoader.getSystemClassLoader());
                                            }
                                            zza2 = zzcVar;
                                        }
                                        zzd(zza2);
                                        declaredField.set(null, zza2);
                                        zzb = Boolean.TRUE;
                                        return zzb2;
                                    }
                                    return zzb2;
                                } catch (LoadingException unused2) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                }
                            }
                        }
                        zzb = bool;
                    }
                }
                if (!bool.booleanValue()) {
                    zzq zzg2 = zzg(context);
                    try {
                        if (zzg2 != null) {
                            try {
                                int zze2 = zzg2.zze();
                                if (zze2 >= 3) {
                                    zzn zznVar = (zzn) zzg.get();
                                    if (zznVar == null || (cursor2 = zznVar.zza) == null) {
                                        cursor = (Cursor) ObjectWrapper.unwrap(zzg2.zzk(ObjectWrapper.wrap(context), str, z, ((Long) zzh.get()).longValue()));
                                        if (cursor != null) {
                                            try {
                                                if (cursor.moveToFirst()) {
                                                    int i2 = cursor.getInt(0);
                                                    r3 = (i2 <= 0 || !zze(cursor)) ? cursor : null;
                                                    if (r3 != null) {
                                                        r3.close();
                                                    }
                                                    i = i2;
                                                }
                                            } catch (RemoteException e3) {
                                                e = e3;
                                                r3 = cursor;
                                                String message = e.getMessage();
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append("Failed to retrieve remote module version: ");
                                                sb2.append(message);
                                                InstrumentInjector.log_w("DynamiteModule", sb2.toString());
                                                if (r3 != null) {
                                                    r3.close();
                                                }
                                                return i;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        InstrumentInjector.log_w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                    } else {
                                        i = cursor2.getInt(0);
                                    }
                                } else if (zze2 == 2) {
                                    InstrumentInjector.log_w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                    i = zzg2.zzg(ObjectWrapper.wrap(context), str, z);
                                } else {
                                    InstrumentInjector.log_w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                    i = zzg2.zzf(ObjectWrapper.wrap(context), str, z);
                                }
                            } catch (RemoteException e4) {
                                e = e4;
                            }
                        }
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = r3;
                    }
                } else {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e5) {
                        String message2 = e5.getMessage();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to retrieve remote module version: ");
                        sb3.append(message2);
                        InstrumentInjector.log_w("DynamiteModule", sb3.toString());
                        return 0;
                    }
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x009d, code lost:
    
        r10.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00da  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.dynamite.zzp] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zzb(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        InstrumentInjector.log_i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzrVar = (zzr) queryLocalInterface;
                } else {
                    zzrVar = new zzr(iBinder);
                }
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zznVar = (zzn) zzg.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, ExceptionCode.CRASH_EXCEPTION) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                InstrumentInjector.log_i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            InstrumentInjector.log_e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                InstrumentInjector.log_e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    @ResultIgnorabilityUnspecified
    public final Context getModuleContext() {
        return this.zzj;
    }

    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
