package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes7.dex */
public interface zzee extends IInterface {
    String zzd(zzq zzqVar) throws RemoteException;

    List zze(zzq zzqVar, boolean z) throws RemoteException;

    List zzf(String str, String str2, zzq zzqVar) throws RemoteException;

    List zzg(String str, String str2, String str3) throws RemoteException;

    List zzh(String str, String str2, boolean z, zzq zzqVar) throws RemoteException;

    List zzi(String str, String str2, String str3, boolean z) throws RemoteException;

    void zzj(zzq zzqVar) throws RemoteException;

    void zzk(zzaw zzawVar, zzq zzqVar) throws RemoteException;

    void zzl(zzaw zzawVar, String str, String str2) throws RemoteException;

    void zzm(zzq zzqVar) throws RemoteException;

    void zzn(zzac zzacVar, zzq zzqVar) throws RemoteException;

    void zzo(zzac zzacVar) throws RemoteException;

    void zzp(zzq zzqVar) throws RemoteException;

    void zzq(long j, String str, String str2, String str3) throws RemoteException;

    void zzr(Bundle bundle, zzq zzqVar) throws RemoteException;

    void zzs(zzq zzqVar) throws RemoteException;

    void zzt(zzlc zzlcVar, zzq zzqVar) throws RemoteException;

    byte[] zzu(zzaw zzawVar, String str) throws RemoteException;
}
