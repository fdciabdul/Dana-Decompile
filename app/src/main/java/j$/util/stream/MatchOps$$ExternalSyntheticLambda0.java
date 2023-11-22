package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.DoublePredicate;
import j$.util.function.IntPredicate;
import j$.util.function.LongPredicate;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final /* synthetic */ class MatchOps$$ExternalSyntheticLambda0 implements Consumer, Supplier {
    public final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int PlaceComponentResult;
    public final /* synthetic */ Object getAuthRequestContext;

    public /* synthetic */ MatchOps$$ExternalSyntheticLambda0(int i, Object obj, Object obj2) {
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
        this.getAuthRequestContext = obj2;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return this.PlaceComponentResult != 1 ? Consumer.CC.PlaceComponentResult(this, consumer) : Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            return new MatchOps$2MatchSink((IntPredicate) this.getAuthRequestContext, (MatchOps$MatchKind) this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (i == 2) {
            final MatchOps$MatchKind matchOps$MatchKind = (MatchOps$MatchKind) this.KClassImpl$Data$declaredNonStaticMembers$2;
            final Predicate predicate = (Predicate) this.getAuthRequestContext;
            return new MatchOps$BooleanTerminalSink(predicate, matchOps$MatchKind) { // from class: j$.util.stream.MatchOps$1MatchSink
                final /* synthetic */ Predicate BuiltInFictitiousFunctionClassFactory;
                final /* synthetic */ MatchOps$MatchKind getAuthRequestContext;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(matchOps$MatchKind);
                    this.getAuthRequestContext = matchOps$MatchKind;
                }

                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    boolean z;
                    boolean z2;
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        return;
                    }
                    boolean test = this.BuiltInFictitiousFunctionClassFactory.test(obj);
                    z = this.getAuthRequestContext.stopOnPredicateMatches;
                    if (test == z) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        z2 = this.getAuthRequestContext.shortCircuitResult;
                        this.lookAheadTest = z2;
                    }
                }
            };
        } else if (i != 3) {
            return new MatchOps$3MatchSink((LongPredicate) this.getAuthRequestContext, (MatchOps$MatchKind) this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            return new MatchOps$4MatchSink((DoublePredicate) this.getAuthRequestContext, (MatchOps$MatchKind) this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.PlaceComponentResult;
        if (i == 1) {
            AtomicBoolean atomicBoolean = (AtomicBoolean) this.KClassImpl$Data$declaredNonStaticMembers$2;
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.getAuthRequestContext;
            int i2 = DistinctOps$1.BuiltInFictitiousFunctionClassFactory;
            if (obj == null) {
                atomicBoolean.set(true);
            } else {
                concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
            }
        } else if (i == 5) {
            BiConsumer biConsumer = (BiConsumer) this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj2 = this.getAuthRequestContext;
            int i3 = ReferencePipeline.getErrorConfigVersion;
            biConsumer.accept(obj2, obj);
        } else {
            StreamSpliterators$DistinctSpliterator streamSpliterators$DistinctSpliterator = (StreamSpliterators$DistinctSpliterator) this.KClassImpl$Data$declaredNonStaticMembers$2;
            Consumer consumer = (Consumer) this.getAuthRequestContext;
            if (streamSpliterators$DistinctSpliterator.PlaceComponentResult.putIfAbsent(obj != null ? obj : StreamSpliterators$DistinctSpliterator.KClassImpl$Data$declaredNonStaticMembers$2, Boolean.TRUE) == null) {
                consumer.accept(obj);
            }
        }
    }
}
