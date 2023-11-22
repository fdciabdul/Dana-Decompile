package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntConsumer;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class StreamSpliterators$SliceSpliterator {
    long BuiltInFictitiousFunctionClassFactory;
    Spliterator KClassImpl$Data$declaredNonStaticMembers$2;
    final long MyBillsEntityDataFactory;
    long PlaceComponentResult;
    final long getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble(Spliterator.OfDouble ofDouble, long j, long j2) {
            super(ofDouble, j, j2);
        }

        private OfDouble(Spliterator.OfDouble ofDouble, long j, long j2, long j3, long j4) {
            super(ofDouble, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator
        protected final Spliterator MyBillsEntityDataFactory(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfDouble((Spliterator.OfDouble) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator.OfPrimitive
        protected final Object scheduleImpl() {
            return new Node$OfDouble$$ExternalSyntheticLambda0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class OfInt extends OfPrimitive implements Spliterator.OfInt {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt(Spliterator.OfInt ofInt, long j, long j2) {
            super(ofInt, j, j2);
        }

        private OfInt(Spliterator.OfInt ofInt, long j, long j2, long j3, long j4) {
            super(ofInt, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator
        protected final Spliterator MyBillsEntityDataFactory(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfInt((Spliterator.OfInt) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator.OfPrimitive
        protected final Object scheduleImpl() {
            return new Node$OfInt$$ExternalSyntheticLambda0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class OfLong extends OfPrimitive implements Spliterator.OfLong {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong(Spliterator.OfLong ofLong, long j, long j2) {
            super(ofLong, j, j2);
        }

        private OfLong(Spliterator.OfLong ofLong, long j, long j2, long j3, long j4) {
            super(ofLong, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator
        protected final Spliterator MyBillsEntityDataFactory(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfLong((Spliterator.OfLong) spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.getAuthRequestContext(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator.OfPrimitive
        protected final Object scheduleImpl() {
            return new Node$OfLong$$ExternalSyntheticLambda0(1);
        }
    }

    /* loaded from: classes.dex */
    abstract class OfPrimitive extends StreamSpliterators$SliceSpliterator implements Spliterator.OfPrimitive {
        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, long j, long j2) {
            super(ofPrimitive, j, j2, 0L, Math.min(ofPrimitive.KClassImpl$Data$declaredNonStaticMembers$2(), j2));
        }

        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, long j, long j2, long j3, long j4) {
            super(ofPrimitive, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final void getAuthRequestContext(Object obj) {
            long j = this.MyBillsEntityDataFactory;
            long j2 = this.PlaceComponentResult;
            if (j >= j2) {
                return;
            }
            long j3 = this.BuiltInFictitiousFunctionClassFactory;
            if (j3 >= j2) {
                return;
            }
            if (j3 >= j && ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2() + j3 <= this.getAuthRequestContext) {
                ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(obj);
                this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult;
                return;
            }
            while (this.MyBillsEntityDataFactory > this.BuiltInFictitiousFunctionClassFactory) {
                ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(scheduleImpl());
                this.BuiltInFictitiousFunctionClassFactory++;
            }
            while (this.BuiltInFictitiousFunctionClassFactory < this.PlaceComponentResult) {
                ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(obj);
                this.BuiltInFictitiousFunctionClassFactory++;
            }
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        public final /* bridge */ /* synthetic */ boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
            return PlaceComponentResult((Object) intConsumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final boolean PlaceComponentResult(Object obj) {
            long j;
            if (this.MyBillsEntityDataFactory >= this.PlaceComponentResult) {
                return false;
            }
            while (true) {
                long j2 = this.MyBillsEntityDataFactory;
                j = this.BuiltInFictitiousFunctionClassFactory;
                if (j2 <= j) {
                    break;
                }
                ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(scheduleImpl());
                this.BuiltInFictitiousFunctionClassFactory++;
            }
            if (j >= this.PlaceComponentResult) {
                return false;
            }
            this.BuiltInFictitiousFunctionClassFactory = j + 1;
            return ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(obj);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        protected abstract Object scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class OfRef extends StreamSpliterators$SliceSpliterator implements Spliterator {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfRef(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2, 0L, Math.min(spliterator.KClassImpl$Data$declaredNonStaticMembers$2(), j2));
        }

        private OfRef(Spliterator spliterator, long j, long j2, long j3, long j4) {
            super(spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            long j;
            if (this.MyBillsEntityDataFactory >= this.PlaceComponentResult) {
                return false;
            }
            while (true) {
                long j2 = this.MyBillsEntityDataFactory;
                j = this.BuiltInFictitiousFunctionClassFactory;
                if (j2 <= j) {
                    break;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(new SliceOps$$ExternalSyntheticLambda0(15));
                this.BuiltInFictitiousFunctionClassFactory++;
            }
            if (j >= this.PlaceComponentResult) {
                return false;
            }
            this.BuiltInFictitiousFunctionClassFactory = j + 1;
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$SliceSpliterator
        protected final Spliterator MyBillsEntityDataFactory(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfRef(spliterator, j, j2, j3, j4);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            long j = this.MyBillsEntityDataFactory;
            long j2 = this.PlaceComponentResult;
            if (j >= j2) {
                return;
            }
            long j3 = this.BuiltInFictitiousFunctionClassFactory;
            if (j3 >= j2) {
                return;
            }
            if (j3 >= j && this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() + j3 <= this.getAuthRequestContext) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(consumer);
                this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult;
                return;
            }
            while (this.MyBillsEntityDataFactory > this.BuiltInFictitiousFunctionClassFactory) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(new SliceOps$$ExternalSyntheticLambda0(14));
                this.BuiltInFictitiousFunctionClassFactory++;
            }
            while (this.BuiltInFictitiousFunctionClassFactory < this.PlaceComponentResult) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
                this.BuiltInFictitiousFunctionClassFactory++;
            }
        }
    }

    StreamSpliterators$SliceSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spliterator;
        this.MyBillsEntityDataFactory = j;
        this.getAuthRequestContext = j2;
        this.BuiltInFictitiousFunctionClassFactory = j3;
        this.PlaceComponentResult = j4;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        long j = this.MyBillsEntityDataFactory;
        long j2 = this.PlaceComponentResult;
        if (j < j2) {
            return j2 - Math.max(j, this.BuiltInFictitiousFunctionClassFactory);
        }
        return 0L;
    }

    public final Spliterator MyBillsEntityDataFactory() {
        long j = this.MyBillsEntityDataFactory;
        long j2 = this.PlaceComponentResult;
        if (j >= j2 || this.BuiltInFictitiousFunctionClassFactory >= j2) {
            return null;
        }
        while (true) {
            Spliterator moveToNextValue = this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
            if (moveToNextValue == null) {
                return null;
            }
            long KClassImpl$Data$declaredNonStaticMembers$2 = moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2() + this.BuiltInFictitiousFunctionClassFactory;
            long min = Math.min(KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
            long j3 = this.MyBillsEntityDataFactory;
            if (j3 >= min) {
                this.BuiltInFictitiousFunctionClassFactory = min;
            } else {
                long j4 = this.getAuthRequestContext;
                if (min < j4) {
                    long j5 = this.BuiltInFictitiousFunctionClassFactory;
                    if (j5 < j3 || KClassImpl$Data$declaredNonStaticMembers$2 > j4) {
                        this.BuiltInFictitiousFunctionClassFactory = min;
                        return MyBillsEntityDataFactory(moveToNextValue, j3, j4, j5, min);
                    }
                    this.BuiltInFictitiousFunctionClassFactory = min;
                    return moveToNextValue;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = moveToNextValue;
                this.PlaceComponentResult = min;
            }
        }
    }

    protected abstract Spliterator MyBillsEntityDataFactory(Spliterator spliterator, long j, long j2, long j3, long j4);

    public final /* synthetic */ Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return (Spliterator.OfPrimitive) MyBillsEntityDataFactory();
    }

    public final /* synthetic */ Spliterator.OfDouble getErrorConfigVersion() {
        return (Spliterator.OfDouble) MyBillsEntityDataFactory();
    }

    /* renamed from: getErrorConfigVersion  reason: collision with other method in class */
    public final /* synthetic */ Spliterator.OfInt m3173getErrorConfigVersion() {
        return (Spliterator.OfInt) MyBillsEntityDataFactory();
    }

    public final /* synthetic */ Spliterator.OfLong moveToNextValue() {
        return (Spliterator.OfLong) MyBillsEntityDataFactory();
    }
}
