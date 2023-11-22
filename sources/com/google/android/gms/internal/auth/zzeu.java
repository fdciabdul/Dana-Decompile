package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzes;
import com.google.android.gms.internal.auth.zzeu;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class zzeu<MessageType extends zzeu<MessageType, BuilderType>, BuilderType extends zzes<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgz zzc = zzgz.zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeu zza(Class cls) {
        Map map = zzb;
        zzeu zzeuVar = (zzeu) map.get(cls);
        if (zzeuVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzeuVar = (zzeu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzeuVar == null) {
            zzeuVar = (zzeu) ((zzeu) zzhi.zze(cls)).zzi(6, null, null);
            if (zzeuVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzeuVar);
        }
        return zzeuVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r1 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.auth.zzeu zzb(com.google.android.gms.internal.auth.zzeu r3, byte[] r4) throws com.google.android.gms.internal.auth.zzfa {
        /*
            int r0 = r4.length
            com.google.android.gms.internal.auth.zzek r1 = com.google.android.gms.internal.auth.zzek.zza
            r2 = 0
            com.google.android.gms.internal.auth.zzeu r3 = zzj(r3, r4, r2, r0, r1)
            if (r3 == 0) goto L46
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r4 = 1
            r0 = 0
            java.lang.Object r1 = r3.zzi(r4, r0, r0)
            java.lang.Byte r1 = (java.lang.Byte) r1
            byte r1 = r1.byteValue()
            if (r1 != r4) goto L1b
            goto L46
        L1b:
            if (r1 == 0) goto L39
            com.google.android.gms.internal.auth.zzge r1 = com.google.android.gms.internal.auth.zzge.zza()
            java.lang.Class r2 = r3.getClass()
            com.google.android.gms.internal.auth.zzgh r1 = r1.zzb(r2)
            boolean r1 = r1.zzi(r3)
            if (r4 == r1) goto L31
            r4 = r0
            goto L32
        L31:
            r4 = r3
        L32:
            r2 = 2
            r3.zzi(r2, r4, r0)
            if (r1 == 0) goto L39
            goto L46
        L39:
            com.google.android.gms.internal.auth.zzgx r4 = new com.google.android.gms.internal.auth.zzgx
            r4.<init>(r3)
            com.google.android.gms.internal.auth.zzfa r4 = r4.zza()
            r4.zze(r3)
            throw r4
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzeu.zzb(com.google.android.gms.internal.auth.zzeu, byte[]):com.google.android.gms.internal.auth.zzeu");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzey zzc() {
        return zzgf.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzf(zzfw zzfwVar, String str, Object[] objArr) {
        return new zzgg(zzfwVar, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzg(Class cls, zzeu zzeuVar) {
        zzb.put(cls, zzeuVar);
    }

    private static zzeu zzj(zzeu zzeuVar, byte[] bArr, int i, int i2, zzek zzekVar) throws zzfa {
        zzeu zzeuVar2 = (zzeu) zzeuVar.zzi(4, null, null);
        try {
            zzgh zzb2 = zzge.zza().zzb(zzeuVar2.getClass());
            zzb2.zzg(zzeuVar2, bArr, 0, i2, new zzds(zzekVar));
            zzb2.zze(zzeuVar2);
            if (zzeuVar2.zza == 0) {
                return zzeuVar2;
            }
            throw new RuntimeException();
        } catch (zzfa e) {
            e.zze(zzeuVar2);
            throw e;
        } catch (zzgx e2) {
            zzfa zza = e2.zza();
            zza.zze(zzeuVar2);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzfa) {
                throw ((zzfa) e3.getCause());
            }
            zzfa zzfaVar = new zzfa(e3);
            zzfaVar.zze(zzeuVar2);
            throw zzfaVar;
        } catch (IndexOutOfBoundsException unused) {
            zzfa zzf = zzfa.zzf();
            zzf.zze(zzeuVar2);
            throw zzf;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzge.zza().zzb(getClass()).zzh(this, (zzeu) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza = zzge.zza().zzb(getClass()).zza(this);
        this.zza = zza;
        return zza;
    }

    public final String toString() {
        return zzfy.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.auth.zzfw
    public final /* synthetic */ zzfv zzd() {
        zzes zzesVar = (zzes) zzi(5, null, null);
        zzesVar.zze(this);
        return zzesVar;
    }

    @Override // com.google.android.gms.internal.auth.zzfx
    public final /* synthetic */ zzfw zzh() {
        return (zzeu) zzi(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzi(int i, Object obj, Object obj2);
}
