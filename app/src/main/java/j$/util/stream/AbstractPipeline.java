package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import j$.util.stream.Node;

/* loaded from: classes.dex */
public abstract class AbstractPipeline extends Node.CC implements BaseStream {
    public static final /* synthetic */ int getAuthRequestContext = 0;
    private int BuiltInFictitiousFunctionClassFactory;
    private Supplier DatabaseTableConfigUtil;
    final AbstractPipeline KClassImpl$Data$declaredNonStaticMembers$2;
    protected final int MyBillsEntityDataFactory;
    private AbstractPipeline NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2;
    Runnable PlaceComponentResult;
    private boolean getErrorConfigVersion;
    private boolean lookAheadTest;
    private int moveToNextValue;
    private final AbstractPipeline scheduleImpl;

    public AbstractPipeline(Spliterator spliterator, int i, boolean z) {
        this.scheduleImpl = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = spliterator;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
        int i2 = StreamOpFlag.STREAM_MASK & i;
        this.MyBillsEntityDataFactory = i2;
        this.BuiltInFictitiousFunctionClassFactory = ((i2 << 1) ^ (-1)) & StreamOpFlag.INITIAL_OPS_VALUE;
        this.moveToNextValue = 0;
        this.lookAheadTest = z;
    }

    public AbstractPipeline(Supplier supplier, int i, boolean z) {
        this.scheduleImpl = null;
        this.DatabaseTableConfigUtil = supplier;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
        int i2 = StreamOpFlag.STREAM_MASK & i;
        this.MyBillsEntityDataFactory = i2;
        this.BuiltInFictitiousFunctionClassFactory = ((i2 << 1) ^ (-1)) & StreamOpFlag.INITIAL_OPS_VALUE;
        this.moveToNextValue = 0;
        this.lookAheadTest = z;
    }

    public AbstractPipeline(AbstractPipeline abstractPipeline, int i) {
        if (abstractPipeline.getErrorConfigVersion) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        abstractPipeline.getErrorConfigVersion = true;
        abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
        this.scheduleImpl = abstractPipeline;
        this.MyBillsEntityDataFactory = StreamOpFlag.OP_MASK & i;
        this.BuiltInFictitiousFunctionClassFactory = StreamOpFlag.combineOpFlags(i, abstractPipeline.BuiltInFictitiousFunctionClassFactory);
        AbstractPipeline abstractPipeline2 = abstractPipeline.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = abstractPipeline2;
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            abstractPipeline2.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        }
        this.moveToNextValue = abstractPipeline.moveToNextValue + 1;
    }

    private Spliterator MyBillsEntityDataFactory(int i) {
        int i2;
        int i3;
        AbstractPipeline abstractPipeline = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Spliterator spliterator = abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (spliterator != null) {
            abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        } else {
            Supplier supplier = abstractPipeline.DatabaseTableConfigUtil;
            if (supplier == null) {
                throw new IllegalStateException("source already consumed or closed");
            }
            spliterator = (Spliterator) supplier.get();
            this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = null;
        }
        AbstractPipeline abstractPipeline2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (abstractPipeline2.lookAheadTest && abstractPipeline2.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            AbstractPipeline abstractPipeline3 = abstractPipeline2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i4 = 1;
            while (abstractPipeline2 != this) {
                int i5 = abstractPipeline3.MyBillsEntityDataFactory;
                if (abstractPipeline3.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    i4 = 0;
                    if (StreamOpFlag.SHORT_CIRCUIT.isKnown(i5)) {
                        i5 &= StreamOpFlag.IS_SHORT_CIRCUIT ^ (-1);
                    }
                    spliterator = abstractPipeline3.MyBillsEntityDataFactory(abstractPipeline2, spliterator);
                    if (spliterator.KClassImpl$Data$declaredNonStaticMembers$2(64)) {
                        i2 = i5 & (StreamOpFlag.NOT_SIZED ^ (-1));
                        i3 = StreamOpFlag.IS_SIZED;
                    } else {
                        i2 = i5 & (StreamOpFlag.IS_SIZED ^ (-1));
                        i3 = StreamOpFlag.NOT_SIZED;
                    }
                    i5 = i2 | i3;
                }
                abstractPipeline3.moveToNextValue = i4;
                abstractPipeline3.BuiltInFictitiousFunctionClassFactory = StreamOpFlag.combineOpFlags(i5, abstractPipeline2.BuiltInFictitiousFunctionClassFactory);
                i4++;
                AbstractPipeline abstractPipeline4 = abstractPipeline3;
                abstractPipeline3 = abstractPipeline3.NetworkUserEntityData$$ExternalSyntheticLambda0;
                abstractPipeline2 = abstractPipeline4;
            }
        }
        if (i != 0) {
            this.BuiltInFictitiousFunctionClassFactory = StreamOpFlag.combineOpFlags(i, this.BuiltInFictitiousFunctionClassFactory);
        }
        return spliterator;
    }

    abstract Spliterator BuiltInFictitiousFunctionClassFactory(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z);

    abstract Node BuiltInFictitiousFunctionClassFactory(Node.CC cc, Spliterator spliterator, boolean z, IntFunction intFunction);

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return StreamOpFlag.ORDERED.isKnown(this.BuiltInFictitiousFunctionClassFactory);
    }

    public abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    public final Node KClassImpl$Data$declaredNonStaticMembers$2(IntFunction intFunction) {
        if (this.getErrorConfigVersion) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.getErrorConfigVersion = true;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest && this.scheduleImpl != null && NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.moveToNextValue = 0;
            AbstractPipeline abstractPipeline = this.scheduleImpl;
            return getAuthRequestContext(abstractPipeline.MyBillsEntityDataFactory(0), intFunction, abstractPipeline);
        }
        return BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(0), true, intFunction);
    }

    @Override // j$.util.stream.Node.CC
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Spliterator spliterator, Sink sink) {
        if (StreamOpFlag.SHORT_CIRCUIT.isKnown(this.BuiltInFictitiousFunctionClassFactory)) {
            MyBillsEntityDataFactory(spliterator, sink);
            return;
        }
        sink.begin(spliterator.PlaceComponentResult());
        spliterator.getAuthRequestContext(sink);
        sink.end();
    }

    abstract Spliterator MyBillsEntityDataFactory(Supplier supplier);

    Spliterator MyBillsEntityDataFactory(AbstractPipeline abstractPipeline, Spliterator spliterator) {
        return getAuthRequestContext(spliterator, new FindOps$$ExternalSyntheticLambda1(1), abstractPipeline).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final Object MyBillsEntityDataFactory(TerminalOp terminalOp) {
        if (this.getErrorConfigVersion) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.getErrorConfigVersion = true;
        return this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest ? terminalOp.getAuthRequestContext(this, MyBillsEntityDataFactory(terminalOp.BuiltInFictitiousFunctionClassFactory())) : terminalOp.MyBillsEntityDataFactory(this, MyBillsEntityDataFactory(terminalOp.BuiltInFictitiousFunctionClassFactory()));
    }

    @Override // j$.util.stream.Node.CC
    public final void MyBillsEntityDataFactory(Spliterator spliterator, Sink sink) {
        AbstractPipeline abstractPipeline = this;
        while (abstractPipeline.moveToNextValue > 0) {
            abstractPipeline = abstractPipeline.scheduleImpl;
        }
        sink.begin(spliterator.PlaceComponentResult());
        abstractPipeline.getAuthRequestContext(spliterator, sink);
        sink.end();
    }

    @Override // j$.util.stream.BaseStream
    public final boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest;
    }

    abstract boolean NetworkUserEntityData$$ExternalSyntheticLambda0();

    @Override // j$.util.stream.BaseStream
    public Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (this.getErrorConfigVersion) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.getErrorConfigVersion = true;
        AbstractPipeline abstractPipeline = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (this == abstractPipeline) {
            Spliterator spliterator = abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (spliterator != null) {
                abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                return spliterator;
            }
            Supplier supplier = abstractPipeline.DatabaseTableConfigUtil;
            if (supplier != null) {
                abstractPipeline.DatabaseTableConfigUtil = null;
                return MyBillsEntityDataFactory(supplier);
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        return BuiltInFictitiousFunctionClassFactory(this, new Collectors$$ExternalSyntheticLambda25(2, this), abstractPipeline.lookAheadTest);
    }

    public final int PlaceComponentResult() {
        AbstractPipeline abstractPipeline = this;
        while (abstractPipeline.moveToNextValue > 0) {
            abstractPipeline = abstractPipeline.scheduleImpl;
        }
        return abstractPipeline.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final Spliterator PlaceComponentResult(Spliterator spliterator) {
        return this.moveToNextValue == 0 ? spliterator : BuiltInFictitiousFunctionClassFactory(this, new Collectors$$ExternalSyntheticLambda25(1, spliterator), this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
    }

    @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
    public final void close() {
        this.getErrorConfigVersion = true;
        this.DatabaseTableConfigUtil = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        AbstractPipeline abstractPipeline = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Runnable runnable = abstractPipeline.PlaceComponentResult;
        if (runnable != null) {
            abstractPipeline.PlaceComponentResult = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.Node.CC
    public final int getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // j$.util.stream.Node.CC
    public final long getAuthRequestContext(Spliterator spliterator) {
        if (StreamOpFlag.SIZED.isKnown(this.BuiltInFictitiousFunctionClassFactory)) {
            return spliterator.PlaceComponentResult();
        }
        return -1L;
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream getAuthRequestContext(Runnable runnable) {
        AbstractPipeline abstractPipeline = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Runnable runnable2 = abstractPipeline.PlaceComponentResult;
        if (runnable2 != null) {
            runnable = new Streams$1(0, runnable2, runnable);
        }
        abstractPipeline.PlaceComponentResult = runnable;
        return this;
    }

    Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public abstract Sink getAuthRequestContext(int i, Sink sink);

    @Override // j$.util.stream.Node.CC
    public final Sink getAuthRequestContext(Sink sink) {
        for (AbstractPipeline abstractPipeline = this; abstractPipeline.moveToNextValue > 0; abstractPipeline = abstractPipeline.scheduleImpl) {
            sink = abstractPipeline.getAuthRequestContext(abstractPipeline.scheduleImpl.BuiltInFictitiousFunctionClassFactory, sink);
        }
        return sink;
    }

    abstract void getAuthRequestContext(Spliterator spliterator, Sink sink);

    public final /* synthetic */ Spliterator getErrorConfigVersion() {
        return MyBillsEntityDataFactory(0);
    }

    public final Spliterator lookAheadTest() {
        AbstractPipeline abstractPipeline = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (this == abstractPipeline) {
            if (this.getErrorConfigVersion) {
                throw new IllegalStateException("stream has already been operated upon or closed");
            }
            this.getErrorConfigVersion = true;
            Spliterator spliterator = abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (spliterator != null) {
                abstractPipeline.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                return spliterator;
            }
            Supplier supplier = abstractPipeline.DatabaseTableConfigUtil;
            if (supplier != null) {
                Spliterator spliterator2 = (Spliterator) supplier.get();
                this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = null;
                return spliterator2;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream moveToNextValue() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = true;
        return this;
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream scheduleImpl() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = false;
        return this;
    }

    public final Node BuiltInFictitiousFunctionClassFactory(Spliterator spliterator, boolean z, IntFunction intFunction) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest) {
            return BuiltInFictitiousFunctionClassFactory(this, spliterator, z, intFunction);
        }
        Node.Builder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(getAuthRequestContext(spliterator), intFunction);
        Sink sink = BuiltInFictitiousFunctionClassFactory;
        for (AbstractPipeline abstractPipeline = this; abstractPipeline.moveToNextValue > 0; abstractPipeline = abstractPipeline.scheduleImpl) {
            sink = abstractPipeline.getAuthRequestContext(abstractPipeline.scheduleImpl.BuiltInFictitiousFunctionClassFactory, sink);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(spliterator, sink);
        return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    @Override // j$.util.stream.Node.CC
    public final Sink PlaceComponentResult(Spliterator spliterator, Sink sink) {
        Sink sink2 = sink;
        for (AbstractPipeline abstractPipeline = this; abstractPipeline.moveToNextValue > 0; abstractPipeline = abstractPipeline.scheduleImpl) {
            sink2 = abstractPipeline.getAuthRequestContext(abstractPipeline.scheduleImpl.BuiltInFictitiousFunctionClassFactory, sink2);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(spliterator, sink2);
        return sink;
    }
}
