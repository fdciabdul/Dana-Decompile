package j$.util.stream;

/* loaded from: classes2.dex */
final class Streams$1 implements Runnable {
    final /* synthetic */ Object BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Object PlaceComponentResult;

    public /* synthetic */ Streams$1(int i, Object obj, Object obj2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = obj;
        this.BuiltInFictitiousFunctionClassFactory = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            try {
                ((BaseStream) this.PlaceComponentResult).close();
                ((BaseStream) this.BuiltInFictitiousFunctionClassFactory).close();
                return;
            } catch (Throwable th) {
                try {
                    ((BaseStream) this.BuiltInFictitiousFunctionClassFactory).close();
                } catch (Throwable th2) {
                    try {
                        th.addSuppressed(th2);
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        }
        try {
            ((Runnable) this.PlaceComponentResult).run();
            ((Runnable) this.BuiltInFictitiousFunctionClassFactory).run();
        } catch (Throwable th3) {
            try {
                ((Runnable) this.BuiltInFictitiousFunctionClassFactory).run();
            } catch (Throwable th4) {
                try {
                    th3.addSuppressed(th4);
                } catch (Throwable unused2) {
                }
            }
            throw th3;
        }
    }
}
