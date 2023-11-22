package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class zzin<MessageType extends zzin<MessageType, BuilderType>, BuilderType extends zzim<MessageType, BuilderType>> implements zzll {
    protected int zzb = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzbt(Iterable iterable, List list) {
        zzkm.zze(iterable);
        if (iterable instanceof zzkt) {
            List zzh = ((zzkt) iterable).zzh();
            zzkt zzktVar = (zzkt) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj != null) {
                    if (obj instanceof zzjd) {
                        zzktVar.zzi((zzjd) obj);
                    } else {
                        zzktVar.add((String) obj);
                    }
                } else {
                    String str = "Element at index " + (zzktVar.size() - size) + " is null.";
                    int size2 = zzktVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            break;
                        }
                        zzktVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
            }
        } else if (!(iterable instanceof zzls)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (Object obj2 : iterable) {
                if (obj2 != null) {
                    list.add(obj2);
                } else {
                    String str2 = "Element at index " + (list.size() - size3) + " is null.";
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 < size3) {
                            break;
                        }
                        list.remove(size4);
                    }
                    throw new NullPointerException(str2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzbr() {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final zzjd zzbs() {
        try {
            int zzbw = zzbw();
            zzjd zzjdVar = zzjd.zzb;
            byte[] bArr = new byte[zzbw];
            zzjl zzC = zzjl.zzC(bArr);
            zzbK(zzC);
            zzC.zzD();
            return new zzja(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzbu(int i) {
        throw null;
    }

    public final byte[] zzbv() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzjl zzC = zzjl.zzC(bArr);
            zzbK(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
