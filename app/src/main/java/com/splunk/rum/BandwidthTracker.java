package com.splunk.rum;

import j$.time.Clock;
import j$.util.Collection;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.stream.Stream;
import java.util.ArrayDeque;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BandwidthTracker {
    final ArrayDeque<Long> BuiltInFictitiousFunctionClassFactory;
    private final Clock KClassImpl$Data$declaredNonStaticMembers$2;
    final ArrayDeque<Long> MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BandwidthTracker() {
        this(Clock.systemUTC());
    }

    private BandwidthTracker(Clock clock) {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayDeque<>();
        this.MyBillsEntityDataFactory = new ArrayDeque<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(List<byte[]> list) {
        if (this.BuiltInFictitiousFunctionClassFactory.size() > 6) {
            this.BuiltInFictitiousFunctionClassFactory.removeFirst();
        }
        this.BuiltInFictitiousFunctionClassFactory.add(Long.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.millis()));
        if (this.MyBillsEntityDataFactory.size() > 6) {
            this.MyBillsEntityDataFactory.removeFirst();
        }
        this.MyBillsEntityDataFactory.add(Long.valueOf(((Integer) Collection.EL.getAuthRequestContext(list).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                Integer valueOf;
                valueOf = Integer.valueOf(((byte[]) obj).length);
                return valueOf;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).MyBillsEntityDataFactory((Stream) 0, (BiFunction<Stream, ? super T, Stream>) new BiFunction() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda3
            @Override // j$.util.function.BiFunction
            public final /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.MyBillsEntityDataFactory(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Integer.valueOf(((Integer) obj).intValue() + ((Integer) obj2).intValue());
            }
        }, (BinaryOperator<Stream>) new BandwidthTracker$$ExternalSyntheticLambda4())).intValue()));
    }
}
