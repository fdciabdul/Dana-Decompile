package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.LongFunction;
import j$.util.function.Supplier;
import j$.util.stream.Nodes;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class Collectors$$ExternalSyntheticLambda25 implements Supplier, BinaryOperator, LongFunction, Consumer {
    public final /* synthetic */ Object PlaceComponentResult;
    public final /* synthetic */ int getAuthRequestContext;

    public /* synthetic */ Collectors$$ExternalSyntheticLambda25(int i, Object obj) {
        this.getAuthRequestContext = i;
        this.PlaceComponentResult = obj;
    }

    @Override // j$.util.function.LongFunction
    public final Object MyBillsEntityDataFactory(long j) {
        IntFunction intFunction = (IntFunction) this.PlaceComponentResult;
        int i = Nodes.CollectorTask.OfInt.$r8$clinit;
        return Nodes.BuiltInFictitiousFunctionClassFactory(j, intFunction);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        if (this.getAuthRequestContext != 4) {
            ((List) this.PlaceComponentResult).add(obj);
        } else {
            ((Sink) this.PlaceComponentResult).accept((Sink) obj);
        }
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.getAuthRequestContext;
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        BinaryOperator binaryOperator = (BinaryOperator) this.PlaceComponentResult;
        Map map = (Map) obj;
        Set set = Collectors.getAuthRequestContext;
        for (Map.Entry entry : ((Map) obj2).entrySet()) {
            Map.EL.BuiltInFictitiousFunctionClassFactory(map, entry.getKey(), entry.getValue(), binaryOperator);
        }
        return map;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        if (this.getAuthRequestContext != 1) {
            return ((AbstractPipeline) this.PlaceComponentResult).getErrorConfigVersion();
        }
        Spliterator spliterator = (Spliterator) this.PlaceComponentResult;
        int i = AbstractPipeline.getAuthRequestContext;
        return spliterator;
    }
}
