package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class zzed extends com.google.android.gms.internal.measurement.zzbn implements zzee {
    public zzed() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzaw zzawVar = (zzaw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzaw.CREATOR);
                zzq zzqVar = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzk(zzawVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzlc zzlcVar = (zzlc) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzlc.CREATOR);
                zzq zzqVar2 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzt(zzlcVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzj(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzaw zzawVar2 = (zzaw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzaw.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzl(zzawVar2, readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzs(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                boolean zzg = com.google.android.gms.internal.measurement.zzbo.zzg(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zze = zze(zzqVar5, zzg);
                parcel2.writeNoException();
                parcel2.writeTypedList(zze);
                return true;
            case 9:
                zzaw zzawVar3 = (zzaw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzaw.CREATOR);
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                byte[] zzu = zzu(zzawVar3, readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzu);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzq(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzq zzqVar6 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                String zzd = zzd(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(zzd);
                return true;
            case 12:
                zzac zzacVar = (zzac) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzac.CREATOR);
                zzq zzqVar7 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzn(zzacVar, zzqVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzac zzacVar2 = (zzac) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzac.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzo(zzacVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zzg2 = com.google.android.gms.internal.measurement.zzbo.zzg(parcel);
                zzq zzqVar8 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzh = zzh(readString7, readString8, zzg2, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzh);
                return true;
            case 15:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                boolean zzg3 = com.google.android.gms.internal.measurement.zzbo.zzg(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzi = zzi(readString9, readString10, readString11, zzg3);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                return true;
            case 16:
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                zzq zzqVar9 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzf = zzf(readString12, readString13, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzf);
                return true;
            case 17:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzg4 = zzg(readString14, readString15, readString16);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg4);
                return true;
            case 18:
                zzq zzqVar10 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzm(zzqVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzr(bundle, zzqVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzq zzqVar12 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzp(zzqVar12);
                parcel2.writeNoException();
                return true;
        }
    }
}
