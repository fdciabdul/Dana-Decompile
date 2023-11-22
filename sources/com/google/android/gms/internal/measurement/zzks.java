package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes7.dex */
public final class zzks extends zzio implements RandomAccess, zzkt {
    public static final zzkt zza;
    private static final zzks zzb;
    private final List zzc;

    static {
        zzks zzksVar = new zzks(10);
        zzb = zzksVar;
        zzksVar.zzb();
        zza = zzksVar;
    }

    public zzks() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjd) {
            return ((zzjd) obj).zzn(zzkm.zzb);
        }
        return zzkm.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzbP();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zzbP();
        if (collection instanceof zzkt) {
            collection = ((zzkt) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbP();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbP();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzbP();
        return zzj(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* synthetic */ zzkl zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzks(arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final zzkt zze() {
        return zzc() ? new zzms(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg  reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzjd) {
            zzjd zzjdVar = (zzjd) obj;
            String zzn = zzjdVar.zzn(zzkm.zzb);
            if (zzjdVar.zzi()) {
                this.zzc.set(i, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzkm.zzh(bArr);
        if (zzkm.zzi(bArr)) {
            this.zzc.set(i, zzh);
        }
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final void zzi(zzjd zzjdVar) {
        zzbP();
        this.zzc.add(zzjdVar);
        this.modCount++;
    }

    public zzks(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzks(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
