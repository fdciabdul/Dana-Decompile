package j$.util.stream;

import j$.util.DoubleSummaryStatistics;
import j$.util.IntSummaryStatistics;
import j$.util.LongSummaryStatistics;
import j$.util.StringJoiner;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.LongFunction;
import j$.util.function.Supplier;
import j$.util.function.ToLongFunction;
import j$.util.stream.Node;
import j$.util.stream.Nodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class SliceOps$$ExternalSyntheticLambda0 implements BiConsumer, LongFunction, BinaryOperator, IntFunction, ToLongFunction, Consumer, Supplier, Function {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ SliceOps$$ExternalSyntheticLambda0(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // j$.util.function.ToLongFunction
    public final long KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        int i = ReferencePipeline.getErrorConfigVersion;
        return 1L;
    }

    @Override // j$.util.function.IntFunction
    public final Object MyBillsEntityDataFactory(int i) {
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 != 0) {
            if (i2 == 9) {
                int i3 = ReferencePipeline.getErrorConfigVersion;
                return new Object[i];
            } else if (i2 == 11) {
                int i4 = SliceOps$2.moveToNextValue;
                return new Integer[i];
            } else if (i2 != 12) {
                int i5 = SliceOps$4.NetworkUserEntityData$$ExternalSyntheticLambda0;
                return new Double[i];
            } else {
                int i6 = SliceOps$3.BuiltInFictitiousFunctionClassFactory;
                return new Long[i];
            }
        }
        return new Object[i];
    }

    @Override // j$.util.function.LongFunction
    public final Object MyBillsEntityDataFactory(long j) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return i != 2 ? i != 4 ? Nodes.KClassImpl$Data$declaredNonStaticMembers$2(j) : Nodes.BuiltInFictitiousFunctionClassFactory(j) : Nodes.MyBillsEntityDataFactory(j);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 1) {
            long[] jArr = (long[]) obj;
            long[] jArr2 = (long[]) obj2;
            int i2 = LongPipeline.lookAheadTest;
            jArr[0] = jArr[0] + jArr2[0];
            jArr[1] = jArr[1] + jArr2[1];
        } else if (i == 17) {
            ((StringJoiner) obj).BuiltInFictitiousFunctionClassFactory((CharSequence) obj2);
        } else if (i == 23) {
            ((List) obj).add(obj2);
        } else if (i == 26) {
            ((Set) obj).add(obj2);
        } else {
            LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
            if (i != 28) {
                linkedHashSet.addAll((LinkedHashSet) obj2);
            } else {
                linkedHashSet.add(obj2);
            }
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 1 && i != 17 && i != 23 && i == 26) {
            return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
        }
        return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 3 && i != 5 && i == 7) {
            return BiFunction.CC.MyBillsEntityDataFactory(this, function);
        }
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.Function
    /* renamed from: andThen */
    public final /* synthetic */ Function mo3169andThen(Function function) {
        return Function.CC.getAuthRequestContext(this, function);
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        return ((StringJoiner) obj).toString();
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 3) {
            if (i != 5) {
                if (i != 7) {
                    if (i != 8) {
                        StringJoiner stringJoiner = (StringJoiner) obj;
                        StringJoiner stringJoiner2 = (StringJoiner) obj2;
                        StringBuilder sb = stringJoiner2.PlaceComponentResult;
                        if (sb != null) {
                            int length = sb.length();
                            StringBuilder sb2 = stringJoiner.PlaceComponentResult;
                            if (sb2 != null) {
                                sb2.append(stringJoiner.KClassImpl$Data$declaredNonStaticMembers$2);
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(stringJoiner.MyBillsEntityDataFactory);
                                stringJoiner.PlaceComponentResult = sb3;
                            }
                            stringJoiner.PlaceComponentResult.append((CharSequence) stringJoiner2.PlaceComponentResult, stringJoiner2.MyBillsEntityDataFactory.length(), length);
                        }
                        return stringJoiner;
                    }
                    return new Nodes.ConcNode((Node) obj, (Node) obj2);
                }
                return new Nodes.ConcNode.OfLong((Node.OfLong) obj, (Node.OfLong) obj2);
            }
            return new Nodes.ConcNode.OfInt((Node.OfInt) obj, (Node.OfInt) obj2);
        }
        return new Nodes.ConcNode.OfDouble((Node.OfDouble) obj, (Node.OfDouble) obj2);
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 16) {
            if (i != 24) {
                if (i != 25) {
                    switch (i) {
                        case 20:
                            return new IntSummaryStatistics();
                        case 21:
                            return new HashMap();
                        case 22:
                            return new ArrayList();
                        default:
                            return new LinkedHashSet();
                    }
                }
                return new HashSet();
            }
            return new LongSummaryStatistics();
        }
        return new DoubleSummaryStatistics();
    }
}
