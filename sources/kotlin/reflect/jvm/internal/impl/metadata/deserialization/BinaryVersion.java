package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class BinaryVersion {
    public static final Companion Companion = new Companion(null);
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    public BinaryVersion(int... iArr) {
        List<Integer> emptyList;
        Intrinsics.checkNotNullParameter(iArr, "");
        this.numbers = iArr;
        Integer orNull = ArraysKt.getOrNull(iArr, 0);
        this.major = orNull != null ? orNull.intValue() : -1;
        Integer orNull2 = ArraysKt.getOrNull(iArr, 1);
        this.minor = orNull2 != null ? orNull2.intValue() : -1;
        Integer orNull3 = ArraysKt.getOrNull(iArr, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : -1;
        if (iArr.length > 3) {
            if (iArr.length > 1024) {
                StringBuilder sb = new StringBuilder();
                sb.append("BinaryVersion with length more than 1024 are not supported. Provided length ");
                sb.append(iArr.length);
                sb.append('.');
                throw new IllegalArgumentException(sb.toString());
            }
            emptyList = CollectionsKt.toList(ArraysKt.asList(iArr).subList(3, iArr.length));
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this.rest = emptyList;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isCompatibleTo(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "");
        int i = this.major;
        return i != 0 ? !(i != binaryVersion.major || this.minor > binaryVersion.minor) : binaryVersion.major == 0 && this.minor == binaryVersion.minor;
    }

    public final boolean isAtLeast(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "");
        return isAtLeast(binaryVersion.major, binaryVersion.minor, binaryVersion.patch);
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.major;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.minor;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.patch >= i3;
    }

    public final boolean isAtMost(int i, int i2, int i3) {
        int i4 = this.major;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.minor;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.patch <= i3;
    }

    public String toString() {
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int i2 = array[i];
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        ArrayList arrayList2 = arrayList;
        return arrayList2.isEmpty() ? "unknown" : CollectionsKt.joinToString$default(arrayList2, ".", null, null, 0, null, null, 62, null);
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual(this.rest, binaryVersion.rest)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.major;
        int i2 = i + (i * 31) + this.minor;
        int i3 = i2 + (i2 * 31) + this.patch;
        return i3 + (i3 * 31) + this.rest.hashCode();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
