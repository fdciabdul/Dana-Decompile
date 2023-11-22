package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000b2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u000bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/random/PlatformRandom;", "Lkotlin/random/AbstractPlatformRandom;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/Random;", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "<init>", "(Ljava/util/Random;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class PlatformRandom extends AbstractPlatformRandom implements Serializable {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final java.util.Random impl;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/random/PlatformRandom$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PlatformRandom(java.util.Random random) {
        Intrinsics.checkNotNullParameter(random, "");
        this.impl = random;
    }

    @Override // kotlin.random.AbstractPlatformRandom
    @JvmName(name = "getImpl")
    public final java.util.Random getImpl() {
        return this.impl;
    }
}
