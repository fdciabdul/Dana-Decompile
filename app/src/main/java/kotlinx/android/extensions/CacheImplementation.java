package kotlinx.android.extensions;

import kotlin.Metadata;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlinx.android.extensions.CacheImplementation, still in use, count: 1, list:
  (r0v1 kotlinx.android.extensions.CacheImplementation) from 0x002c: SPUT (r0v1 kotlinx.android.extensions.CacheImplementation) (LINE:33) kotlinx.android.extensions.CacheImplementation.DEFAULT kotlinx.android.extensions.CacheImplementation
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:89)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:88)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:239)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;

    public static final CacheImplementation DEFAULT = new CacheImplementation();

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }

    private CacheImplementation() {
    }

    static {
    }
}
