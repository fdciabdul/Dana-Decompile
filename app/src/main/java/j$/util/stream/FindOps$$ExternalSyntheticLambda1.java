package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.DoubleToLongFunction;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.IntToLongFunction;
import j$.util.function.LongUnaryOperator;
import j$.util.function.LongUnaryOperator$$ExternalSyntheticLambda1;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.ObjIntConsumer;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.FindOps$FindSink;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class FindOps$$ExternalSyntheticLambda1 implements IntFunction, BinaryOperator, Function, ObjDoubleConsumer, BiConsumer, DoubleToLongFunction, Supplier, ToDoubleFunction, ToIntFunction, IntToLongFunction, ObjIntConsumer, LongUnaryOperator, ToLongFunction, ObjLongConsumer {
    public final /* synthetic */ int getAuthRequestContext;

    public /* synthetic */ FindOps$$ExternalSyntheticLambda1(int i) {
        this.getAuthRequestContext = i;
    }

    @Override // j$.util.function.LongUnaryOperator
    public final LongUnaryOperator BuiltInFictitiousFunctionClassFactory(LongUnaryOperator longUnaryOperator) {
        return new LongUnaryOperator$$ExternalSyntheticLambda1(this, longUnaryOperator, 1);
    }

    @Override // j$.util.function.ObjIntConsumer
    public final void BuiltInFictitiousFunctionClassFactory(Object obj, int i) {
        long[] jArr = (long[]) obj;
        int i2 = IntPipeline.BuiltInFictitiousFunctionClassFactory;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + i;
    }

    @Override // j$.util.function.ToLongFunction
    public final long KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        int i = LongPipeline.lookAheadTest;
        return ((Long) obj).longValue();
    }

    @Override // j$.util.function.LongUnaryOperator
    public final LongUnaryOperator KClassImpl$Data$declaredNonStaticMembers$2(LongUnaryOperator longUnaryOperator) {
        return new LongUnaryOperator$$ExternalSyntheticLambda1(this, longUnaryOperator, 0);
    }

    @Override // j$.util.function.ObjLongConsumer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, long j) {
        long[] jArr = (long[]) obj;
        int i = LongPipeline.lookAheadTest;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j;
    }

    @Override // j$.util.function.ToIntFunction
    public final int MyBillsEntityDataFactory(Object obj) {
        int i = IntPipeline.BuiltInFictitiousFunctionClassFactory;
        return ((Integer) obj).intValue();
    }

    @Override // j$.util.function.DoubleToLongFunction
    public final long MyBillsEntityDataFactory(double d) {
        int i = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
        return 1L;
    }

    @Override // j$.util.function.IntFunction
    public final Object MyBillsEntityDataFactory(int i) {
        int i2 = this.getAuthRequestContext;
        if (i2 == 1) {
            int i3 = AbstractPipeline.getAuthRequestContext;
            return new Object[i];
        } else if (i2 == 6) {
            int i4 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
            return new Double[i];
        } else if (i2 == 18) {
            int i5 = ForEachOps$ForEachOrderedTask.$r8$clinit;
            return new Object[i];
        } else if (i2 != 24) {
            int i6 = LongPipeline.lookAheadTest;
            return new Long[i];
        } else {
            int i7 = IntPipeline.BuiltInFictitiousFunctionClassFactory;
            return new Integer[i];
        }
    }

    @Override // j$.util.function.ObjDoubleConsumer
    public final void PlaceComponentResult(Object obj, double d) {
        double[] dArr = (double[]) obj;
        if (this.getAuthRequestContext == 7) {
            int i = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
            Collectors.KClassImpl$Data$declaredNonStaticMembers$2(dArr, d);
            dArr[2] = dArr[2] + d;
            return;
        }
        int i2 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
        dArr[2] = dArr[2] + 1.0d;
        Collectors.KClassImpl$Data$declaredNonStaticMembers$2(dArr, d);
        dArr[3] = dArr[3] + d;
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.getAuthRequestContext;
        if (i == 8) {
            double[] dArr = (double[]) obj;
            double[] dArr2 = (double[]) obj2;
            int i2 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
            Collectors.KClassImpl$Data$declaredNonStaticMembers$2(dArr, dArr2[0]);
            Collectors.KClassImpl$Data$declaredNonStaticMembers$2(dArr, dArr2[1]);
            dArr[2] = dArr[2] + dArr2[2];
        } else if (i != 12) {
            long[] jArr = (long[]) obj;
            long[] jArr2 = (long[]) obj2;
            int i3 = IntPipeline.BuiltInFictitiousFunctionClassFactory;
            jArr[0] = jArr[0] + jArr2[0];
            jArr[1] = jArr[1] + jArr2[1];
        } else {
            double[] dArr3 = (double[]) obj;
            double[] dArr4 = (double[]) obj2;
            int i4 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
            Collectors.KClassImpl$Data$declaredNonStaticMembers$2(dArr3, dArr4[0]);
            Collectors.KClassImpl$Data$declaredNonStaticMembers$2(dArr3, dArr4[1]);
            dArr3[2] = dArr3[2] + dArr4[2];
            dArr3[3] = dArr3[3] + dArr4[3];
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return this.getAuthRequestContext != 8 ? BiConsumer.CC.getAuthRequestContext(this, biConsumer) : BiConsumer.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return this.getAuthRequestContext != 2 ? BiFunction.CC.MyBillsEntityDataFactory(this, function) : BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.Function
    /* renamed from: andThen  reason: collision with other method in class */
    public final /* synthetic */ Function mo3169andThen(Function function) {
        return Function.CC.getAuthRequestContext(this, function);
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        Set set = Collectors.getAuthRequestContext;
        return obj;
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.getAuthRequestContext;
        if (i == 2) {
            Set set = Collectors.getAuthRequestContext;
            throw new IllegalStateException(String.format("Duplicate key %s", obj));
        } else if (i != 4) {
            Set set2 = (Set) obj;
            Set set3 = Collectors.getAuthRequestContext;
            set2.addAll((Set) obj2);
            return set2;
        } else {
            List list = (List) obj;
            Set set4 = Collectors.getAuthRequestContext;
            list.addAll((List) obj2);
            return list;
        }
    }

    @Override // j$.util.function.ToDoubleFunction
    public final double applyAsDouble(Object obj) {
        int i = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
        return ((Double) obj).doubleValue();
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        int i = this.getAuthRequestContext;
        if (i != 0) {
            if (i == 10) {
                int i2 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
                return new double[4];
            } else if (i == 21) {
                int i3 = IntPipeline.BuiltInFictitiousFunctionClassFactory;
                return new long[2];
            } else {
                switch (i) {
                    case 14:
                        int i4 = DoublePipeline.BuiltInFictitiousFunctionClassFactory;
                        return new double[3];
                    case 15:
                        return new FindOps$FindSink.OfLong();
                    case 16:
                        return new FindOps$FindSink.OfRef();
                    case 17:
                        return new FindOps$FindSink.OfInt();
                    default:
                        int i5 = LongPipeline.lookAheadTest;
                        return new long[2];
                }
            }
        }
        return new FindOps$FindSink.OfDouble();
    }

    @Override // j$.util.function.IntToLongFunction
    public final long getAuthRequestContext(int i) {
        int i2 = IntPipeline.BuiltInFictitiousFunctionClassFactory;
        return 1L;
    }

    @Override // j$.util.function.LongUnaryOperator
    public final long getAuthRequestContext(long j) {
        int i = LongPipeline.lookAheadTest;
        return 1L;
    }
}
