package go;

import go.Seq;

/* loaded from: classes8.dex */
public abstract class Universe {

    /* loaded from: classes8.dex */
    public static final class proxyerror extends Exception implements Seq.Proxy, error {
        private final int refnum;

        public proxyerror(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }

        @Override // go.error
        public final native String error();

        @Override // java.lang.Throwable
        public final String getMessage() {
            return error();
        }

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }
    }

    static {
        Seq.touch();
        _init();
    }

    private Universe() {
    }

    private static native void _init();

    public static void touch() {
    }
}
