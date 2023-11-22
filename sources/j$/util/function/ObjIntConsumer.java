package j$.util.function;

/* loaded from: classes.dex */
public interface ObjIntConsumer {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements ObjIntConsumer {
        final /* synthetic */ java.util.function.ObjIntConsumer PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.ObjIntConsumer objIntConsumer) {
            this.PlaceComponentResult = objIntConsumer;
        }

        public static /* synthetic */ ObjIntConsumer MyBillsEntityDataFactory(java.util.function.ObjIntConsumer objIntConsumer) {
            if (objIntConsumer == null) {
                return null;
            }
            return objIntConsumer instanceof Wrapper ? ObjIntConsumer.this : new VivifiedWrapper(objIntConsumer);
        }

        @Override // j$.util.function.ObjIntConsumer
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Object obj, int i) {
            this.PlaceComponentResult.accept(obj, i);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.ObjIntConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.ObjIntConsumer getAuthRequestContext(ObjIntConsumer objIntConsumer) {
            if (objIntConsumer == null) {
                return null;
            }
            return objIntConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) objIntConsumer).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.ObjIntConsumer
        public final /* synthetic */ void accept(Object obj, int i) {
            ObjIntConsumer.this.BuiltInFictitiousFunctionClassFactory(obj, i);
        }
    }

    void BuiltInFictitiousFunctionClassFactory(Object obj, int i);
}
