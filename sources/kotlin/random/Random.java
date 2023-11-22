package kotlin.random;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0016J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u001f\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010\"J\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010#"}, d2 = {"Lkotlin/random/Random;", "", "", "bitCount", "nextBits", "(I)I", "", "nextBoolean", "()Z", "", "array", "nextBytes", "([B)[B", "fromIndex", "toIndex", "([BII)[B", GriverMonitorConstants.KEY_SIZE, "(I)[B", "", "nextDouble", "()D", "until", "(D)D", "from", "(DD)D", "", "nextFloat", "()F", "nextInt", "()I", "(II)I", "", "nextLong", "()J", "(J)J", "(JJ)J", "<init>", "()V", "Default"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Random {

    /* renamed from: Default  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    public abstract int nextBits(int bitCount);

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int until) {
        return nextInt(0, until);
    }

    public int nextInt(int from, int until) {
        int nextInt;
        int i;
        int i2;
        int nextInt2;
        boolean z;
        RandomKt.checkRangeBounds(from, until);
        int i3 = until - from;
        if (i3 > 0 || i3 == Integer.MIN_VALUE) {
            if (((-i3) & i3) == i3) {
                i2 = nextBits(RandomKt.fastLog2(i3));
                return from + i2;
            }
            do {
                nextInt = nextInt() >>> 1;
                i = nextInt % i3;
            } while ((nextInt - i) + (i3 - 1) < 0);
            i2 = i;
            return from + i2;
        }
        do {
            nextInt2 = nextInt();
            z = false;
            if (from <= nextInt2 && nextInt2 < until) {
                z = true;
            }
        } while (!z);
        return nextInt2;
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public long nextLong(long until) {
        return nextLong(0L, until);
    }

    public long nextLong(long from, long until) {
        long nextLong;
        boolean z;
        long nextLong2;
        long j;
        long j2;
        int nextInt;
        RandomKt.checkRangeBounds(from, until);
        long j3 = until - from;
        if (j3 > 0) {
            if (((-j3) & j3) == j3) {
                int i = (int) j3;
                int i2 = (int) (j3 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i));
                } else if (i2 == 1) {
                    nextInt = nextInt();
                } else {
                    j2 = (nextBits(RandomKt.fastLog2(i2)) << 32) + (nextInt() & 4294967295L);
                    return from + j2;
                }
                j2 = nextInt & 4294967295L;
                return from + j2;
            }
            do {
                nextLong2 = nextLong() >>> 1;
                j = nextLong2 % j3;
            } while ((nextLong2 - j) + (j3 - 1) < 0);
            j2 = j;
            return from + j2;
        }
        do {
            nextLong = nextLong();
            z = false;
            if (from <= nextLong && nextLong < until) {
                z = true;
            }
        } while (!z);
        return nextLong;
    }

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double until) {
        return nextDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, until);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.RandomKt.checkRangeBounds(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L2b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L2b
            goto L2c
        L2b:
            r3 = 0
        L2c:
            if (r3 == 0) goto L3e
            double r0 = r6.nextDouble()
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L45
        L3e:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L45:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L4f
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L4f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] nextBytes(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 1
            if (r8 < 0) goto Le
            int r2 = r7.length
            if (r8 > r2) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1d
            if (r9 < 0) goto L18
            int r2 = r7.length
            if (r9 > r2) goto L18
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.String r3 = "fromIndex ("
            if (r2 == 0) goto L8c
            if (r8 > r9) goto L25
            goto L26
        L25:
            r1 = 0
        L26:
            if (r1 == 0) goto L66
            int r1 = r9 - r8
            int r1 = r1 / 4
            r2 = 0
        L2d:
            if (r2 >= r1) goto L50
            int r3 = r6.nextInt()
            byte r4 = (byte) r3
            r7[r8] = r4
            int r4 = r3 >>> 8
            byte r4 = (byte) r4
            int r5 = r8 + 1
            r7[r5] = r4
            int r4 = r3 >>> 16
            byte r4 = (byte) r4
            int r5 = r8 + 2
            r7[r5] = r4
            int r3 = r3 >>> 24
            byte r3 = (byte) r3
            int r4 = r8 + 3
            r7[r4] = r3
            int r8 = r8 + 4
            int r2 = r2 + 1
            goto L2d
        L50:
            int r9 = r9 - r8
            int r1 = r9 * 8
            int r1 = r6.nextBits(r1)
        L57:
            if (r0 >= r9) goto L65
            int r2 = r0 * 8
            int r2 = r1 >>> r2
            byte r2 = (byte) r2
            int r3 = r8 + r0
            r7[r3] = r2
            int r0 = r0 + 1
            goto L57
        L65:
            return r7
        L66:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = ") must be not greater than toIndex ("
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = ")."
            r7.append(r8)
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L8c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = ") or toIndex ("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ") are out of range: 0.."
            r0.append(r8)
            int r7 = r7.length
            r0.append(r7)
            r7 = 46
            r0.append(r7)
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r0.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            goto Lbc
        Lbb:
            throw r7
        Lbc:
            goto Lbb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextBytes(byte[], int, int):byte[]");
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int size) {
        return nextBytes(new byte[size]);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001-B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0011J\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0018J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0007J\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010$J\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "bitCount", "nextBits", "(I)I", "", "nextBoolean", "()Z", "", "array", "nextBytes", "([B)[B", "fromIndex", "toIndex", "([BII)[B", GriverMonitorConstants.KEY_SIZE, "(I)[B", "", "nextDouble", "()D", "until", "(D)D", "from", "(DD)D", "", "nextFloat", "()F", "nextInt", "()I", "(II)I", "", "nextLong", "()J", "(J)J", "(JJ)J", "", "writeReplace", "()Ljava/lang/Object;", "defaultRandom", "Lkotlin/random/Random;", "<init>", "()V", "Serialized"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlin.random.Random$Default  reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion extends Random implements Serializable {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "", "serialVersionUID", "J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: kotlin.random.Random$Default$Serialized */
        /* loaded from: classes9.dex */
        static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.INSTANCE;
            }
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public final int nextBits(int bitCount) {
            return Random.defaultRandom.nextBits(bitCount);
        }

        @Override // kotlin.random.Random
        public final int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public final int nextInt(int until) {
            return Random.defaultRandom.nextInt(until);
        }

        @Override // kotlin.random.Random
        public final int nextInt(int from, int until) {
            return Random.defaultRandom.nextInt(from, until);
        }

        @Override // kotlin.random.Random
        public final long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public final long nextLong(long until) {
            return Random.defaultRandom.nextLong(until);
        }

        @Override // kotlin.random.Random
        public final long nextLong(long from, long until) {
            return Random.defaultRandom.nextLong(from, until);
        }

        @Override // kotlin.random.Random
        public final boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public final double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public final double nextDouble(double until) {
            return Random.defaultRandom.nextDouble(until);
        }

        @Override // kotlin.random.Random
        public final double nextDouble(double from, double until) {
            return Random.defaultRandom.nextDouble(from, until);
        }

        @Override // kotlin.random.Random
        public final float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public final byte[] nextBytes(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public final byte[] nextBytes(int size) {
            return Random.defaultRandom.nextBytes(size);
        }

        @Override // kotlin.random.Random
        public final byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(array, "");
            return Random.defaultRandom.nextBytes(array, fromIndex, toIndex);
        }
    }
}
