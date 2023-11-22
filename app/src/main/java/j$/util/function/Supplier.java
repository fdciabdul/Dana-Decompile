package j$.util.function;

/* loaded from: classes.dex */
public interface Supplier<T> {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements Supplier {
        final /* synthetic */ java.util.function.Supplier MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.Supplier supplier) {
            this.MyBillsEntityDataFactory = supplier;
        }

        public static /* synthetic */ Supplier BuiltInFictitiousFunctionClassFactory(java.util.function.Supplier supplier) {
            if (supplier == null) {
                return null;
            }
            return supplier instanceof Wrapper ? Supplier.this : new VivifiedWrapper(supplier);
        }

        @Override // j$.util.function.Supplier
        public final /* synthetic */ Object get() {
            return this.MyBillsEntityDataFactory.get();
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.Supplier {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Supplier BuiltInFictitiousFunctionClassFactory(Supplier supplier) {
            if (supplier == null) {
                return null;
            }
            return supplier instanceof VivifiedWrapper ? ((VivifiedWrapper) supplier).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.Supplier
        public final /* synthetic */ Object get() {
            return Supplier.this.get();
        }
    }

    T get();
}
