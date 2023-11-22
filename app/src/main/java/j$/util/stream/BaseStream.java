package j$.util.stream;

import j$.util.Spliterator;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface BaseStream extends AutoCloseable {
    Iterator DatabaseTableConfigUtil();

    boolean MyBillsEntityDataFactory();

    BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1();

    Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2();

    @Override // java.lang.AutoCloseable
    void close();

    BaseStream getAuthRequestContext(Runnable runnable);

    BaseStream moveToNextValue();

    BaseStream scheduleImpl();

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements BaseStream {
        final /* synthetic */ java.util.stream.BaseStream getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.stream.BaseStream baseStream) {
            this.getAuthRequestContext = baseStream;
        }

        public static /* synthetic */ BaseStream KClassImpl$Data$declaredNonStaticMembers$2(java.util.stream.BaseStream baseStream) {
            if (baseStream == null) {
                return null;
            }
            return baseStream instanceof Wrapper ? BaseStream.this : new VivifiedWrapper(baseStream);
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Iterator DatabaseTableConfigUtil() {
            return this.getAuthRequestContext.iterator();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ boolean MyBillsEntityDataFactory() {
            return this.getAuthRequestContext.isParallel();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ Spliterator NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return Spliterator.VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.spliterator());
        }

        @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.getAuthRequestContext.close();
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream getAuthRequestContext(Runnable runnable) {
            java.util.stream.BaseStream onClose = this.getAuthRequestContext.onClose(runnable);
            if (onClose == null) {
                return null;
            }
            return onClose instanceof Wrapper ? BaseStream.this : new VivifiedWrapper(onClose);
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream moveToNextValue() {
            java.util.stream.BaseStream parallel = this.getAuthRequestContext.parallel();
            if (parallel == null) {
                return null;
            }
            return parallel instanceof Wrapper ? BaseStream.this : new VivifiedWrapper(parallel);
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream scheduleImpl() {
            java.util.stream.BaseStream sequential = this.getAuthRequestContext.sequential();
            if (sequential == null) {
                return null;
            }
            return sequential instanceof Wrapper ? BaseStream.this : new VivifiedWrapper(sequential);
        }

        @Override // j$.util.stream.BaseStream
        public final /* synthetic */ BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1() {
            java.util.stream.BaseStream unordered = this.getAuthRequestContext.unordered();
            if (unordered == null) {
                return null;
            }
            return unordered instanceof Wrapper ? BaseStream.this : new VivifiedWrapper(unordered);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.BaseStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.BaseStream MyBillsEntityDataFactory(BaseStream baseStream) {
            if (baseStream == null) {
                return null;
            }
            return baseStream instanceof VivifiedWrapper ? ((VivifiedWrapper) baseStream).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            BaseStream.this.close();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return BaseStream.this.MyBillsEntityDataFactory();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ Iterator iterator() {
            return BaseStream.this.DatabaseTableConfigUtil();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(BaseStream.this.NetworkUserEntityData$$ExternalSyntheticLambda2());
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            BaseStream authRequestContext = BaseStream.this.getAuthRequestContext(runnable);
            if (authRequestContext == null) {
                return null;
            }
            return authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream parallel() {
            BaseStream moveToNextValue = BaseStream.this.moveToNextValue();
            if (moveToNextValue == null) {
                return null;
            }
            return moveToNextValue instanceof VivifiedWrapper ? ((VivifiedWrapper) moveToNextValue).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream sequential() {
            BaseStream scheduleImpl = BaseStream.this.scheduleImpl();
            if (scheduleImpl == null) {
                return null;
            }
            return scheduleImpl instanceof VivifiedWrapper ? ((VivifiedWrapper) scheduleImpl).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.BaseStream unordered() {
            BaseStream NetworkUserEntityData$$ExternalSyntheticLambda1 = BaseStream.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
            if (NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                return null;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda1 instanceof VivifiedWrapper ? ((VivifiedWrapper) NetworkUserEntityData$$ExternalSyntheticLambda1).getAuthRequestContext : new Wrapper();
        }
    }
}
