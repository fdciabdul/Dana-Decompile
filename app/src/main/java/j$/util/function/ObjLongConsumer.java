package j$.util.function;

/* loaded from: classes.dex */
public interface ObjLongConsumer {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements ObjLongConsumer {
        final /* synthetic */ java.util.function.ObjLongConsumer BuiltInFictitiousFunctionClassFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.ObjLongConsumer objLongConsumer) {
            this.BuiltInFictitiousFunctionClassFactory = objLongConsumer;
        }

        public static /* synthetic */ ObjLongConsumer BuiltInFictitiousFunctionClassFactory(java.util.function.ObjLongConsumer objLongConsumer) {
            if (objLongConsumer == null) {
                return null;
            }
            return objLongConsumer instanceof Wrapper ? ObjLongConsumer.this : new VivifiedWrapper(objLongConsumer);
        }

        @Override // j$.util.function.ObjLongConsumer
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, long j) {
            this.BuiltInFictitiousFunctionClassFactory.accept(obj, j);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.ObjLongConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.ObjLongConsumer BuiltInFictitiousFunctionClassFactory(ObjLongConsumer objLongConsumer) {
            if (objLongConsumer == null) {
                return null;
            }
            return objLongConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) objLongConsumer).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.ObjLongConsumer
        public final /* synthetic */ void accept(Object obj, long j) {
            ObjLongConsumer.this.KClassImpl$Data$declaredNonStaticMembers$2(obj, j);
        }
    }

    void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, long j);
}
