package j$.util.concurrent;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.StreamSupport;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public class ThreadLocalRandom extends Random {
    private static final ThreadLocal instances;
    private static final ThreadLocal nextLocalGaussian;
    private static final AtomicInteger probeGenerator = new AtomicInteger();
    private static final AtomicLong seeder;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized;
    int threadLocalRandomProbe;
    long threadLocalRandomSeed;

    /* loaded from: classes2.dex */
    final class RandomDoublesSpliterator implements Spliterator.OfDouble {
        final double BuiltInFictitiousFunctionClassFactory;
        long KClassImpl$Data$declaredNonStaticMembers$2;
        final double MyBillsEntityDataFactory;
        final long getAuthRequestContext;

        RandomDoublesSpliterator(long j, long j2, double d, double d2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.getAuthRequestContext = j2;
            this.MyBillsEntityDataFactory = d;
            this.BuiltInFictitiousFunctionClassFactory = d2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // j$.util.Spliterator.OfDouble
        /* renamed from: scheduleImpl  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public RandomDoublesSpliterator getErrorConfigVersion() {
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            long j2 = (this.getAuthRequestContext + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j2;
            return new RandomDoublesSpliterator(j, j2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 17728;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DoubleConsumer doubleConsumer) {
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            long j2 = this.getAuthRequestContext;
            if (j < j2) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = j2;
                double d = this.MyBillsEntityDataFactory;
                double d2 = this.BuiltInFictitiousFunctionClassFactory;
                ThreadLocalRandom current = ThreadLocalRandom.current();
                do {
                    doubleConsumer.accept(current.internalNextDouble(d, d2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext - this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
        public final boolean MyBillsEntityDataFactory(DoubleConsumer doubleConsumer) {
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (j < this.getAuthRequestContext) {
                doubleConsumer.accept(ThreadLocalRandom.current().internalNextDouble(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory));
                this.KClassImpl$Data$declaredNonStaticMembers$2 = j + 1;
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.PlaceComponentResult(this, consumer);
        }
    }

    /* loaded from: classes2.dex */
    final class RandomIntsSpliterator implements Spliterator.OfInt {
        final int BuiltInFictitiousFunctionClassFactory;
        final int MyBillsEntityDataFactory;
        long PlaceComponentResult;
        final long getAuthRequestContext;

        RandomIntsSpliterator(long j, long j2, int i, int i2) {
            this.PlaceComponentResult = j;
            this.getAuthRequestContext = j2;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // j$.util.Spliterator.OfInt
        /* renamed from: scheduleImpl  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public RandomIntsSpliterator getErrorConfigVersion() {
            long j = this.PlaceComponentResult;
            long j2 = (this.getAuthRequestContext + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.PlaceComponentResult = j2;
            return new RandomIntsSpliterator(j, j2, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 17728;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext - this.PlaceComponentResult;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public final boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
            long j = this.PlaceComponentResult;
            if (j < this.getAuthRequestContext) {
                intConsumer.accept(ThreadLocalRandom.current().internalNextInt(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory));
                this.PlaceComponentResult = j + 1;
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer) {
            long j = this.PlaceComponentResult;
            long j2 = this.getAuthRequestContext;
            if (j < j2) {
                this.PlaceComponentResult = j2;
                int i = this.BuiltInFictitiousFunctionClassFactory;
                int i2 = this.MyBillsEntityDataFactory;
                ThreadLocalRandom current = ThreadLocalRandom.current();
                do {
                    intConsumer.accept(current.internalNextInt(i, i2));
                    j++;
                } while (j < j2);
            }
        }
    }

    /* loaded from: classes2.dex */
    final class RandomLongsSpliterator implements Spliterator.OfLong {
        long BuiltInFictitiousFunctionClassFactory;
        final long KClassImpl$Data$declaredNonStaticMembers$2;
        final long MyBillsEntityDataFactory;
        final long getAuthRequestContext;

        RandomLongsSpliterator(long j, long j2, long j3, long j4) {
            this.BuiltInFictitiousFunctionClassFactory = j;
            this.MyBillsEntityDataFactory = j2;
            this.getAuthRequestContext = j3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // j$.util.Spliterator.OfLong
        public RandomLongsSpliterator moveToNextValue() {
            long j = this.BuiltInFictitiousFunctionClassFactory;
            long j2 = (this.MyBillsEntityDataFactory + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.BuiltInFictitiousFunctionClassFactory = j2;
            return new RandomLongsSpliterator(j, j2, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 17728;
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final boolean MyBillsEntityDataFactory(LongConsumer longConsumer) {
            long j = this.BuiltInFictitiousFunctionClassFactory;
            if (j < this.MyBillsEntityDataFactory) {
                longConsumer.accept(ThreadLocalRandom.current().internalNextLong(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2));
                this.BuiltInFictitiousFunctionClassFactory = j + 1;
                return true;
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory - this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.getAuthRequestContext(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(LongConsumer longConsumer) {
            long j = this.BuiltInFictitiousFunctionClassFactory;
            long j2 = this.MyBillsEntityDataFactory;
            if (j < j2) {
                this.BuiltInFictitiousFunctionClassFactory = j2;
                long j3 = this.getAuthRequestContext;
                long j4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                ThreadLocalRandom current = ThreadLocalRandom.current();
                do {
                    longConsumer.accept(current.internalNextLong(j3, j4));
                    j++;
                } while (j < j2);
            }
        }
    }

    static {
        long mix64;
        if (((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: j$.util.concurrent.ThreadLocalRandom.1
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            }
        })).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            mix64 = seed[0] & 255;
            for (int i = 1; i < 8; i++) {
                mix64 = (mix64 << 8) | (seed[i] & 255);
            }
        } else {
            mix64 = mix64(System.nanoTime()) ^ mix64(System.currentTimeMillis());
        }
        seeder = new AtomicLong(mix64);
        nextLocalGaussian = new ThreadLocal();
        instances = new ThreadLocal() { // from class: j$.util.concurrent.ThreadLocalRandom.2
            @Override // java.lang.ThreadLocal
            protected final Object initialValue() {
                return new ThreadLocalRandom(0);
            }
        };
        new ObjectStreamField("rnd", Long.TYPE);
        new ObjectStreamField("initialized", Boolean.TYPE);
    }

    private ThreadLocalRandom() {
        this.initialized = true;
    }

    /* synthetic */ ThreadLocalRandom(int i) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int advanceProbe(int i) {
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        ((ThreadLocalRandom) instances.get()).threadLocalRandomProbe = i4;
        return i4;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) instances.get();
        if (threadLocalRandom.threadLocalRandomProbe == 0) {
            localInit();
        }
        return threadLocalRandom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int getProbe() {
        return ((ThreadLocalRandom) instances.get()).threadLocalRandomProbe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void localInit() {
        int addAndGet = probeGenerator.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long mix64 = mix64(seeder.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) instances.get();
        threadLocalRandom.threadLocalRandomSeed = mix64;
        threadLocalRandom.threadLocalRandomProbe = addAndGet;
    }

    private static int mix32(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j2 ^ (j2 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    private static long mix64(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private Object readResolve() {
        return current();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("rnd", this.threadLocalRandomSeed);
        putFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    @Override // java.util.Random
    public final DoubleStream doubles() {
        return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomDoublesSpliterator(0L, LongCompanionObject.MAX_VALUE, Double.MAX_VALUE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
    }

    @Override // java.util.Random
    public final java.util.stream.DoubleStream doubles(double d, double d2) {
        if (d < d2) {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomDoublesSpliterator(0L, LongCompanionObject.MAX_VALUE, d, d2)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final java.util.stream.DoubleStream doubles(long j) {
        if (j >= 0) {
            return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomDoublesSpliterator(0L, j, Double.MAX_VALUE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final java.util.stream.DoubleStream doubles(long j, double d, double d2) {
        if (j >= 0) {
            if (d < d2) {
                return DoubleStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomDoublesSpliterator(0L, j, d, d2)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    final double internalNextDouble(double d, double d2) {
        double nextLong = nextLong() >>> 11;
        Double.isNaN(nextLong);
        double d3 = nextLong * 1.1102230246251565E-16d;
        if (d < d2) {
            double d4 = ((d2 - d) * d3) + d;
            return d4 >= d2 ? Double.longBitsToDouble(Double.doubleToLongBits(d2) - 1) : d4;
        }
        return d3;
    }

    final int internalNextInt(int i, int i2) {
        int i3;
        int i4;
        int mix32 = mix32(nextSeed());
        if (i < i2) {
            int i5 = i2 - i;
            int i6 = i5 - 1;
            if ((i5 & i6) == 0) {
                i4 = mix32 & i6;
            } else if (i5 > 0) {
                int i7 = mix32 >>> 1;
                while (true) {
                    i3 = i7 % i5;
                    if ((i7 + i6) - i3 >= 0) {
                        break;
                    }
                    i7 = mix32(nextSeed()) >>> 1;
                }
                i4 = i3;
            } else {
                while (true) {
                    if (mix32 >= i && mix32 < i2) {
                        return mix32;
                    }
                    mix32 = mix32(nextSeed());
                }
            }
            return i4 + i;
        }
        return mix32;
    }

    final long internalNextLong(long j, long j2) {
        long mix64 = mix64(nextSeed());
        if (j >= j2) {
            return mix64;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (mix64 & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = mix64 >>> 1;
                long j6 = j5 % j3;
                if ((j5 + j4) - j6 >= 0) {
                    return j6 + j;
                }
                mix64 = mix64(nextSeed());
            }
        } else {
            while (true) {
                if (mix64 >= j && mix64 < j2) {
                    return mix64;
                }
                mix64 = mix64(nextSeed());
            }
        }
    }

    @Override // java.util.Random
    public final IntStream ints() {
        return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomIntsSpliterator(0L, LongCompanionObject.MAX_VALUE, Integer.MAX_VALUE, 0)));
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(int i, int i2) {
        if (i < i2) {
            return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomIntsSpliterator(0L, LongCompanionObject.MAX_VALUE, i, i2)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(long j) {
        if (j >= 0) {
            return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomIntsSpliterator(0L, j, Integer.MAX_VALUE, 0)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(long j, int i, int i2) {
        if (j >= 0) {
            if (i < i2) {
                return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(StreamSupport.getAuthRequestContext(new RandomIntsSpliterator(0L, j, i, i2)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final LongStream longs() {
        return LongStream.Wrapper.MyBillsEntityDataFactory(StreamSupport.PlaceComponentResult(new RandomLongsSpliterator(0L, LongCompanionObject.MAX_VALUE, LongCompanionObject.MAX_VALUE, 0L)));
    }

    @Override // java.util.Random
    public final java.util.stream.LongStream longs(long j) {
        if (j >= 0) {
            return LongStream.Wrapper.MyBillsEntityDataFactory(StreamSupport.PlaceComponentResult(new RandomLongsSpliterator(0L, j, LongCompanionObject.MAX_VALUE, 0L)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final java.util.stream.LongStream longs(long j, long j2) {
        if (j < j2) {
            return LongStream.Wrapper.MyBillsEntityDataFactory(StreamSupport.PlaceComponentResult(new RandomLongsSpliterator(0L, LongCompanionObject.MAX_VALUE, j, j2)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final java.util.stream.LongStream longs(long j, long j2, long j3) {
        if (j >= 0) {
            if (j2 < j3) {
                return LongStream.Wrapper.MyBillsEntityDataFactory(StreamSupport.PlaceComponentResult(new RandomLongsSpliterator(0L, j, j2, j3)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    protected final int next(int i) {
        return (int) (mix64(nextSeed()) >>> (64 - i));
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return mix32(nextSeed()) < 0;
    }

    @Override // java.util.Random
    public final double nextDouble() {
        double mix64 = mix64(nextSeed()) >>> 11;
        Double.isNaN(mix64);
        return mix64 * 1.1102230246251565E-16d;
    }

    public double nextDouble(double d) {
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double mix64 = mix64(nextSeed()) >>> 11;
            Double.isNaN(mix64);
            double d2 = mix64 * 1.1102230246251565E-16d * d;
            return d2 < d ? d2 : Double.longBitsToDouble(Double.doubleToLongBits(d) - 1);
        }
        throw new IllegalArgumentException("bound must be positive");
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (mix32(nextSeed()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public final double nextGaussian() {
        ThreadLocal threadLocal = nextLocalGaussian;
        Double d = (Double) threadLocal.get();
        if (d != null) {
            threadLocal.set(null);
            return d.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d2 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d2 < 1.0d && d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d2) * (-2.0d)) / d2);
                nextLocalGaussian.set(new Double(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    @Override // java.util.Random
    public final int nextInt() {
        return mix32(nextSeed());
    }

    @Override // java.util.Random
    public final int nextInt(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        int mix32 = mix32(nextSeed());
        int i2 = i - 1;
        if ((i & i2) == 0) {
            return mix32 & i2;
        }
        while (true) {
            int i3 = mix32 >>> 1;
            int i4 = i3 % i;
            if ((i3 + i2) - i4 >= 0) {
                return i4;
            }
            mix32 = mix32(nextSeed());
        }
    }

    public int nextInt(int i, int i2) {
        if (i < i2) {
            return internalNextInt(i, i2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final long nextLong() {
        return mix64(nextSeed());
    }

    public long nextLong(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        long mix64 = mix64(nextSeed());
        long j2 = j - 1;
        if ((j & j2) == 0) {
            return mix64 & j2;
        }
        while (true) {
            long j3 = mix64 >>> 1;
            long j4 = j3 % j;
            if ((j3 + j2) - j4 >= 0) {
                return j4;
            }
            mix64 = mix64(nextSeed());
        }
    }

    public long nextLong(long j, long j2) {
        if (j < j2) {
            return internalNextLong(j, j2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    final long nextSeed() {
        long j = this.threadLocalRandomSeed - 7046029254386353131L;
        this.threadLocalRandomSeed = j;
        return j;
    }

    @Override // java.util.Random
    public final void setSeed(long j) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
    }
}
