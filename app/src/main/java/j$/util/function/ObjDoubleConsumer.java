package j$.util.function;

/* loaded from: classes.dex */
public interface ObjDoubleConsumer {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements ObjDoubleConsumer {
        final /* synthetic */ java.util.function.ObjDoubleConsumer PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.ObjDoubleConsumer objDoubleConsumer) {
            this.PlaceComponentResult = objDoubleConsumer;
        }

        public static /* synthetic */ ObjDoubleConsumer BuiltInFictitiousFunctionClassFactory(java.util.function.ObjDoubleConsumer objDoubleConsumer) {
            if (objDoubleConsumer == null) {
                return null;
            }
            return objDoubleConsumer instanceof Wrapper ? ObjDoubleConsumer.this : new VivifiedWrapper(objDoubleConsumer);
        }

        @Override // j$.util.function.ObjDoubleConsumer
        public final /* synthetic */ void PlaceComponentResult(Object obj, double d) {
            this.PlaceComponentResult.accept(obj, d);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.ObjDoubleConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.ObjDoubleConsumer KClassImpl$Data$declaredNonStaticMembers$2(ObjDoubleConsumer objDoubleConsumer) {
            if (objDoubleConsumer == null) {
                return null;
            }
            return objDoubleConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) objDoubleConsumer).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.ObjDoubleConsumer
        public final /* synthetic */ void accept(Object obj, double d) {
            ObjDoubleConsumer.this.PlaceComponentResult(obj, d);
        }
    }

    void PlaceComponentResult(Object obj, double d);
}
