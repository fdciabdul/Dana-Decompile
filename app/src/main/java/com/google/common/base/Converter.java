package com.google.common.base;

import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    @CheckForNull
    @LazyInit
    private transient Converter<B, A> reverse;

    protected abstract A doBackward(B b);

    protected abstract B doForward(A a2);

    public Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    @CheckForNull
    public final B convert(@CheckForNull A a2) {
        return correctedDoForward(a2);
    }

    @CheckForNull
    B correctedDoForward(@CheckForNull A a2) {
        if (this.handleNullAutomatically) {
            if (a2 == null) {
                return null;
            }
            return (B) Preconditions.checkNotNull(doForward(a2));
        }
        return unsafeDoForward(a2);
    }

    @CheckForNull
    A correctedDoBackward(@CheckForNull B b) {
        if (this.handleNullAutomatically) {
            if (b == null) {
                return null;
            }
            return (A) Preconditions.checkNotNull(doBackward(b));
        }
        return unsafeDoBackward(b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private B unsafeDoForward(@CheckForNull A a2) {
        return (B) doForward(NullnessCasts.uncheckedCastNullableTToT(a2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private A unsafeDoBackward(@CheckForNull B b) {
        return (A) doBackward(NullnessCasts.uncheckedCastNullableTToT(b));
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() { // from class: com.google.common.base.Converter.1

            /* renamed from: com.google.common.base.Converter$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes7.dex */
            class C00941 implements Iterator<B>, j$.util.Iterator {
                private final Iterator<? extends A> fromIterator;

                @Override // j$.util.Iterator
                public /* synthetic */ void forEachRemaining(Consumer consumer) {
                    Iterator.CC.getAuthRequestContext(this, consumer);
                }

                @Override // java.util.Iterator
                public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                    forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
                }

                C00941() {
                    this.fromIterator = iterable.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.fromIterator.hasNext();
                }

                @Override // java.util.Iterator
                public B next() {
                    return (B) Converter.this.convert(this.fromIterator.next());
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.fromIterator.remove();
                }
            }

            @Override // java.lang.Iterable
            public java.util.Iterator<B> iterator() {
                return new C00941();
            }
        };
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter == null) {
            ReverseConverter reverseConverter = new ReverseConverter(this);
            this.reverse = reverseConverter;
            return reverseConverter;
        }
        return converter;
    }

    /* loaded from: classes7.dex */
    static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        protected final A doForward(B b) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected final B doBackward(A a2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        final A correctedDoForward(@CheckForNull B b) {
            return this.original.correctedDoBackward(b);
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        final B correctedDoBackward(@CheckForNull A a2) {
            return this.original.correctedDoForward(a2);
        }

        @Override // com.google.common.base.Converter
        public final Converter<A, B> reverse() {
            return this.original;
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public final boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public final int hashCode() {
            return this.original.hashCode() ^ (-1);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.original);
            sb.append(".reverse()");
            return sb.toString();
        }
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        protected final C doForward(A a2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected final A doBackward(C c) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        final C correctedDoForward(@CheckForNull A a2) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a2));
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        final A correctedDoBackward(@CheckForNull C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public final boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition) obj;
                return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
            }
            return false;
        }

        public final int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.first);
            sb.append(".andThen(");
            sb.append(this.second);
            sb.append(")");
            return sb.toString();
        }
    }

    @Override // com.google.common.base.Function
    @Deprecated
    public final B apply(A a2) {
        return convert(a2);
    }

    @Override // com.google.common.base.Function
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    /* loaded from: classes7.dex */
    static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Converter
        protected final B doForward(A a2) {
            return this.forwardFunction.apply(a2);
        }

        @Override // com.google.common.base.Converter
        protected final A doBackward(B b) {
            return this.backwardFunction.apply(b);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public final boolean equals(@CheckForNull Object obj) {
            if (obj instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
            }
            return false;
        }

        public final int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Converter.from(");
            sb.append(this.forwardFunction);
            sb.append(", ");
            sb.append(this.backwardFunction);
            sb.append(")");
            return sb.toString();
        }
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    /* loaded from: classes7.dex */
    static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Converter
        protected final T doBackward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        protected final T doForward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public final IdentityConverter<T> reverse() {
            return this;
        }

        public final String toString() {
            return "Converter.identity()";
        }

        private IdentityConverter() {
        }

        @Override // com.google.common.base.Converter
        final <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
