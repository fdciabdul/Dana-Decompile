package androidx.work;

/* loaded from: classes.dex */
public interface Operation {
    public static final State.SUCCESS KClassImpl$Data$declaredNonStaticMembers$2;
    public static final State.IN_PROGRESS PlaceComponentResult;

    static {
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$2 = new State.SUCCESS(b);
        PlaceComponentResult = new State.IN_PROGRESS(b);
    }

    /* loaded from: classes3.dex */
    public static abstract class State {
        State() {
        }

        /* loaded from: classes3.dex */
        public static final class SUCCESS extends State {
            public final String toString() {
                return "SUCCESS";
            }

            /* synthetic */ SUCCESS(byte b) {
                this();
            }

            private SUCCESS() {
            }
        }

        /* loaded from: classes3.dex */
        public static final class IN_PROGRESS extends State {
            public final String toString() {
                return "IN_PROGRESS";
            }

            /* synthetic */ IN_PROGRESS(byte b) {
                this();
            }

            private IN_PROGRESS() {
            }
        }

        /* loaded from: classes3.dex */
        public static final class FAILURE extends State {
            public final Throwable BuiltInFictitiousFunctionClassFactory;

            public FAILURE(Throwable th) {
                this.BuiltInFictitiousFunctionClassFactory = th;
            }

            public final String toString() {
                return String.format("FAILURE (%s)", this.BuiltInFictitiousFunctionClassFactory.getMessage());
            }
        }
    }
}
