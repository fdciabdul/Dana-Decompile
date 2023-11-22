package com.google.android.gms.internal.fido;

import j$.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzbg extends zzbh implements NavigableMap, Map {
    public static final /* synthetic */ int zzb = 0;
    private static final Comparator zzc;
    private static final zzbg zzd;
    private final transient zzbu zze;
    private final transient zzaz zzf;
    @CheckForNull
    private final transient zzbg zzg;

    static {
        zzbp zzbpVar = zzbp.zza;
        zzc = zzbpVar;
        zzbu zzq = zzbi.zzq(zzbpVar);
        int i = zzaz.zzd;
        zzd = new zzbg(zzq, zzbs.zza, null);
    }

    zzbg(zzbu zzbuVar, zzaz zzazVar, @CheckForNull zzbg zzbgVar) {
        this.zze = zzbuVar;
        this.zzf = zzazVar;
        this.zzg = zzbgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzbg zzf(java.util.Map map) {
        final Comparator comparator = zzc;
        Comparator comparator2 = map.comparator();
        int i = 1;
        boolean equals = comparator2 == null ? true : comparator.equals(comparator2);
        Collection entrySet = map.entrySet();
        Map.Entry[] entryArr = zza;
        if (!(entrySet instanceof Collection)) {
            Iterator it = entrySet.iterator();
            Collection arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            entrySet = arrayList;
        }
        Map.Entry[] entryArr2 = (Map.Entry[]) entrySet.toArray(entryArr);
        int length = entryArr2.length;
        if (length != 0) {
            if (length == 1) {
                Map.Entry entry = entryArr2[0];
                entry.getClass();
                return new zzbg(new zzbu(zzaz.zzj(entry.getKey()), comparator), zzaz.zzj(entry.getValue()), null);
            }
            Object[] objArr = new Object[length];
            Object[] objArr2 = new Object[length];
            if (equals) {
                for (int i2 = 0; i2 < length; i2++) {
                    Map.Entry entry2 = entryArr2[i2];
                    entry2.getClass();
                    Object key = entry2.getKey();
                    Object value = entry2.getValue();
                    zzas.zza(key, value);
                    objArr[i2] = key;
                    objArr2[i2] = value;
                }
            } else {
                Arrays.sort(entryArr2, 0, length, new Comparator() { // from class: com.google.android.gms.internal.fido.zzbd
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        Comparator comparator3 = comparator;
                        Map.Entry entry3 = (Map.Entry) obj;
                        Map.Entry entry4 = (Map.Entry) obj2;
                        int i3 = zzbg.zzb;
                        entry3.getClass();
                        entry4.getClass();
                        return comparator3.compare(entry3.getKey(), entry4.getKey());
                    }
                });
                Map.Entry entry3 = entryArr2[0];
                entry3.getClass();
                Object key2 = entry3.getKey();
                objArr[0] = key2;
                Object value2 = entry3.getValue();
                objArr2[0] = value2;
                zzas.zza(objArr[0], value2);
                while (i < length) {
                    Map.Entry entry4 = entryArr2[i - 1];
                    entry4.getClass();
                    Map.Entry entry5 = entryArr2[i];
                    entry5.getClass();
                    Object key3 = entry5.getKey();
                    Object value3 = entry5.getValue();
                    zzas.zza(key3, value3);
                    objArr[i] = key3;
                    objArr2[i] = value3;
                    if (comparator.compare(key2, key3) == 0) {
                        throw new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(entry4) + " and " + String.valueOf(entry5));
                    }
                    i++;
                    key2 = key3;
                }
            }
            return new zzbg(new zzbu(zzaz.zzh(objArr, length), comparator), zzaz.zzh(objArr2, length), null);
        }
        return zzg(comparator);
    }

    static zzbg zzg(Comparator comparator) {
        if (zzbp.zza.equals(comparator)) {
            return zzd;
        }
        zzbu zzq = zzbi.zzq(comparator);
        int i = zzaz.zzd;
        return new zzbg(zzq, zzbs.zza, null);
    }

    private final zzbg zzl(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzf.size()) {
                return this;
            }
            i = 0;
        }
        if (i == i2) {
            return zzg(((zzbi) this.zze).zza);
        }
        return new zzbg(this.zze.zzu(i, i2), this.zzf.subList(i, i2), null);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object ceilingKey(Object obj) {
        return zzbn.zza(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((zzbi) this.zze).zza;
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zze.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableMap descendingMap() {
        zzbr zzatVar;
        zzbg zzbgVar = this.zzg;
        if (zzbgVar == null) {
            if (isEmpty()) {
                Comparator comparator = ((zzbi) this.zze).zza;
                if (comparator instanceof zzbr) {
                    zzatVar = (zzbr) comparator;
                } else {
                    zzatVar = new zzat(comparator);
                }
                return zzg(zzatVar.zza());
            }
            return new zzbg((zzbu) this.zze.descendingSet(), this.zzf.zzf(), this);
        }
        return zzbgVar;
    }

    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    public final /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.zze.first();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object floorKey(Object obj) {
        return zzbn.zza(floorEntry(obj));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object higherKey(Object obj) {
        return zzbn.zza(higherEntry(obj));
    }

    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    public final /* synthetic */ Set keySet() {
        return this.zze;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(this.zzf.size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.zze.last();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object lowerKey(Object obj) {
        return zzbn.zza(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zze;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzf.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.fido.zzba
    /* renamed from: zza */
    public final zzav values() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.fido.zzba
    final zzbc zzb() {
        if (!isEmpty()) {
            return new zzbf(this);
        }
        return zzbt.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzba
    /* renamed from: zzd */
    public final /* synthetic */ zzbc keySet() {
        return this.zze;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r4 < 0) goto L7;
     */
    @Override // com.google.android.gms.internal.fido.zzba, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.fido.zzbu r0 = r3.zze
            r1 = -1
            if (r4 != 0) goto L6
            goto L10
        L6:
            com.google.android.gms.internal.fido.zzaz r2 = r0.zzd     // Catch: java.lang.ClassCastException -> L10
            java.util.Comparator r0 = r0.zza     // Catch: java.lang.ClassCastException -> L10
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch: java.lang.ClassCastException -> L10
            if (r4 >= 0) goto L11
        L10:
            r4 = -1
        L11:
            if (r4 != r1) goto L15
            r4 = 0
            return r4
        L15:
            com.google.android.gms.internal.fido.zzaz r0 = r3.zzf
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbg.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzh  reason: merged with bridge method [inline-methods] */
    public final zzbg headMap(Object obj, boolean z) {
        zzbu zzbuVar = this.zze;
        obj.getClass();
        return zzl(0, zzbuVar.zzs(obj, z));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzj  reason: merged with bridge method [inline-methods] */
    public final zzbg tailMap(Object obj, boolean z) {
        zzbu zzbuVar = this.zze;
        obj.getClass();
        return zzl(zzbuVar.zzt(obj, z), this.zzf.size());
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzi  reason: merged with bridge method [inline-methods] */
    public final zzbg subMap(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (((zzbi) this.zze).zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z2).tailMap(obj, z);
        }
        throw new IllegalArgumentException(zzaq.zza("expected fromKey <= toKey but %s > %s", obj, obj2));
    }
}
