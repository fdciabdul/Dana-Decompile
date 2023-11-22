package go;

import android.content.Context;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.logging.Logger;

/* loaded from: classes8.dex */
public class Seq {
    private static final int NULL_REFNUM = 41;
    public static final RefTracker tracker;
    private static Logger log = Logger.getLogger("GoSeq");
    public static final Ref nullRef = new Ref(41, null);
    private static final GoRefQueue goRefQueue = new GoRefQueue();

    /* loaded from: classes8.dex */
    public interface GoObject {
        int incRefnum();
    }

    /* loaded from: classes8.dex */
    public static class GoRef extends PhantomReference<GoObject> {
        public final int refnum;

        public GoRef(int i, GoObject goObject, GoRefQueue goRefQueue) {
            super(goObject, goRefQueue);
            if (i <= 0) {
                this.refnum = i;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("GoRef instantiated with a Java refnum ");
            sb.append(i);
            throw new RuntimeException(sb.toString());
        }
    }

    /* loaded from: classes8.dex */
    public static class GoRefQueue extends ReferenceQueue<GoObject> {
        private final Collection<GoRef> refs = Collections.synchronizedCollection(new HashSet());

        public GoRefQueue() {
            Thread thread = new Thread(new Runnable() { // from class: go.Seq.GoRefQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            GoRef goRef = (GoRef) GoRefQueue.this.remove();
                            GoRefQueue.this.refs.remove(goRef);
                            Seq.destroyRef(goRef.refnum);
                            goRef.clear();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            });
            thread.setDaemon(true);
            thread.setName("GoRefQueue Finalizer Thread");
            thread.start();
        }

        public void track(int i, GoObject goObject) {
            this.refs.add(new GoRef(i, goObject, this));
        }
    }

    /* loaded from: classes8.dex */
    public interface Proxy extends GoObject {
    }

    /* loaded from: classes8.dex */
    public static final class Ref {
        public final Object obj;
        private int refcnt;
        public final int refnum;

        public Ref(int i, Object obj) {
            if (i >= 0) {
                this.refnum = i;
                this.refcnt = 0;
                this.obj = obj;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Ref instantiated with a Go refnum ");
            sb.append(i);
            throw new RuntimeException(sb.toString());
        }

        public static /* synthetic */ int access$110(Ref ref) {
            int i = ref.refcnt;
            ref.refcnt = i - 1;
            return i;
        }

        public final void inc() {
            int i = this.refcnt;
            if (i != Integer.MAX_VALUE) {
                this.refcnt = i + 1;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("refnum ");
            sb.append(this.refnum);
            sb.append(" overflow");
            throw new RuntimeException(sb.toString());
        }
    }

    /* loaded from: classes8.dex */
    public static final class RefMap {
        private int next = 0;
        private int live = 0;
        private int[] keys = new int[16];
        private Ref[] objs = new Ref[16];

        private void grow() {
            Ref[] refArr;
            int roundPow2 = roundPow2(this.live);
            int[] iArr = this.keys;
            if (roundPow2 * 2 > iArr.length) {
                iArr = new int[iArr.length * 2];
                refArr = new Ref[this.objs.length * 2];
            } else {
                refArr = this.objs;
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.keys;
                if (i >= iArr2.length) {
                    break;
                }
                Ref ref = this.objs[i];
                if (ref != null) {
                    iArr[i2] = iArr2[i];
                    refArr[i2] = ref;
                    i2++;
                }
                i++;
            }
            for (int i3 = i2; i3 < iArr.length; i3++) {
                iArr[i3] = 0;
                refArr[i3] = null;
            }
            this.keys = iArr;
            this.objs = refArr;
            this.next = i2;
            if (this.live == i2) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bad state: live=");
            sb.append(this.live);
            sb.append(", next=");
            sb.append(this.next);
            throw new RuntimeException(sb.toString());
        }

        private static int roundPow2(int i) {
            int i2 = 1;
            while (i2 < i) {
                i2 *= 2;
            }
            return i2;
        }

        public final Ref get(int i) {
            int binarySearch = Arrays.binarySearch(this.keys, 0, this.next, i);
            if (binarySearch >= 0) {
                return this.objs[binarySearch];
            }
            return null;
        }

        public final void put(int i, Ref ref) {
            if (ref == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("put a null ref (with key ");
                sb.append(i);
                sb.append(")");
                throw new RuntimeException(sb.toString());
            }
            int binarySearch = Arrays.binarySearch(this.keys, 0, this.next, i);
            if (binarySearch >= 0) {
                Ref[] refArr = this.objs;
                if (refArr[binarySearch] == null) {
                    refArr[binarySearch] = ref;
                    this.live++;
                }
                if (refArr[binarySearch] == ref) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("replacing an existing ref (with key ");
                sb2.append(i);
                sb2.append(")");
                throw new RuntimeException(sb2.toString());
            }
            if (this.next >= this.keys.length) {
                grow();
                binarySearch = Arrays.binarySearch(this.keys, 0, this.next, i);
            }
            int i2 = binarySearch ^ (-1);
            int i3 = this.next;
            if (i2 < i3) {
                int[] iArr = this.keys;
                int i4 = i2 + 1;
                System.arraycopy(iArr, i2, iArr, i4, i3 - i2);
                Ref[] refArr2 = this.objs;
                System.arraycopy(refArr2, i2, refArr2, i4, this.next - i2);
            }
            this.keys[i2] = i;
            this.objs[i2] = ref;
            this.live++;
            this.next++;
        }

        public final void remove(int i) {
            int binarySearch = Arrays.binarySearch(this.keys, 0, this.next, i);
            if (binarySearch >= 0) {
                Ref[] refArr = this.objs;
                if (refArr[binarySearch] != null) {
                    refArr[binarySearch] = null;
                    this.live--;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class RefTracker {
        private static final int REF_OFFSET = 42;
        private int next = 42;
        private final RefMap javaObjs = new RefMap();
        private final IdentityHashMap<Object, Integer> javaRefs = new IdentityHashMap<>();

        public final void dec(int i) {
            synchronized (this) {
                if (i <= 0) {
                    Logger logger = Seq.log;
                    StringBuilder sb = new StringBuilder();
                    sb.append("dec request for Go object ");
                    sb.append(i);
                    logger.severe(sb.toString());
                } else if (i == Seq.nullRef.refnum) {
                } else {
                    Ref ref = this.javaObjs.get(i);
                    if (ref == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("referenced Java object is not found: refnum=");
                        sb2.append(i);
                        throw new RuntimeException(sb2.toString());
                    }
                    Ref.access$110(ref);
                    if (ref.refcnt <= 0) {
                        this.javaObjs.remove(i);
                        this.javaRefs.remove(ref.obj);
                    }
                }
            }
        }

        public final Ref get(int i) {
            synchronized (this) {
                if (i < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ref called with Go refnum ");
                    sb.append(i);
                    throw new RuntimeException(sb.toString());
                } else if (i == 41) {
                    return Seq.nullRef;
                } else {
                    Ref ref = this.javaObjs.get(i);
                    if (ref != null) {
                        return ref;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unknown java Ref: ");
                    sb2.append(i);
                    throw new RuntimeException(sb2.toString());
                }
            }
        }

        public final int inc(Object obj) {
            synchronized (this) {
                if (obj == null) {
                    return 41;
                }
                if (obj instanceof Proxy) {
                    return ((Proxy) obj).incRefnum();
                }
                Integer num = this.javaRefs.get(obj);
                if (num == null) {
                    int i = this.next;
                    if (i == Integer.MAX_VALUE) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("createRef overflow for ");
                        sb.append(obj);
                        throw new RuntimeException(sb.toString());
                    }
                    this.next = i + 1;
                    num = Integer.valueOf(i);
                    this.javaRefs.put(obj, num);
                }
                int intValue = num.intValue();
                Ref ref = this.javaObjs.get(intValue);
                if (ref == null) {
                    ref = new Ref(intValue, obj);
                    this.javaObjs.put(intValue, ref);
                }
                ref.inc();
                return intValue;
            }
        }

        public final void incRefnum(int i) {
            synchronized (this) {
                Ref ref = this.javaObjs.get(i);
                if (ref == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("referenced Java object is not found: refnum=");
                    sb.append(i);
                    throw new RuntimeException(sb.toString());
                }
                ref.inc();
            }
        }
    }

    static {
        System.loadLibrary("tf4ca");
        init();
        Universe.touch();
        tracker = new RefTracker();
    }

    private Seq() {
    }

    public static void decRef(int i) {
        tracker.dec(i);
    }

    public static native void destroyRef(int i);

    public static Ref getRef(int i) {
        return tracker.get(i);
    }

    public static int incGoObjectRef(GoObject goObject) {
        return goObject.incRefnum();
    }

    public static native void incGoRef(int i, GoObject goObject);

    public static int incRef(Object obj) {
        return tracker.inc(obj);
    }

    public static void incRefnum(int i) {
        tracker.incRefnum(i);
    }

    private static native void init();

    public static void setContext(Context context) {
        setContext((Object) context);
    }

    public static native void setContext(Object obj);

    public static void touch() {
    }

    public static void trackGoRef(int i, GoObject goObject) {
        if (i <= 0) {
            goRefQueue.track(i, goObject);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("trackGoRef called with Java refnum ");
        sb.append(i);
        throw new RuntimeException(sb.toString());
    }
}
