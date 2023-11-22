package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzag {
    private final String zza = ",\n  ";

    private zzag(String str) {
    }

    public static zzag zza(String str) {
        return new zzag(",\n  ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence zzd(@CheckForNull Object obj) {
        obj.getClass();
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final Appendable zzb(Appendable appendable, Iterator it) throws IOException {
        if (it.hasNext()) {
            appendable.append(zzd(it.next()));
            while (it.hasNext()) {
                appendable.append(this.zza);
                appendable.append(zzd(it.next()));
            }
        }
        return appendable;
    }
}
