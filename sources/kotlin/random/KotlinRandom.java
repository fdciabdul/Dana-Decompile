package kotlin.random;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "", "bits", HummerConstants.HUMMER_NEXT, "(I)I", "", "nextBoolean", "()Z", "", "bytes", "", "nextBytes", "([B)V", "", "nextDouble", "()D", "", "nextFloat", "()F", "nextInt", "()I", "bound", "", "nextLong", "()J", "seed", "setSeed", "(J)V", "Lkotlin/random/Random;", "impl", "Lkotlin/random/Random;", "getImpl", "()Lkotlin/random/Random;", "seedInitialized", "Z", "<init>", "(Lkotlin/random/Random;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class KotlinRandom extends java.util.Random {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    public KotlinRandom(Random random) {
        Intrinsics.checkNotNullParameter(random, "");
        this.impl = random;
    }

    @JvmName(name = "getImpl")
    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected final int next(int bits) {
        return this.impl.nextBits(bits);
    }

    @Override // java.util.Random
    public final int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public final int nextInt(int bound) {
        return this.impl.nextInt(bound);
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public final long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public final void nextBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "");
        this.impl.nextBytes(bytes);
    }

    @Override // java.util.Random
    public final void setSeed(long seed) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/random/KotlinRandom$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
