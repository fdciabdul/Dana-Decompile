package fsimpl;

import android.view.View;
import com.fullstory.instrumentation.frameworks.compose.FSClickModifier;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;
import com.fullstory.instrumentation.frameworks.compose.FSComposeModifier;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: fsimpl.dh  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0311dh {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f7934a = new AtomicBoolean(false);
    private final WeakHashMap b = new WeakHashMap();
    private final WeakHashMap c = new WeakHashMap();
    private final Set d = Collections.newSetFromMap(new WeakHashMap());
    private final aA e;
    private final int f;

    public C0311dh(aA aAVar, int i) {
        this.e = aAVar;
        this.f = i;
    }

    private static FSComposeLayoutNode a(FSClickModifier fSClickModifier) {
        WeakReference _fsGetLayoutNode = fSClickModifier._fsGetLayoutNode();
        if (_fsGetLayoutNode != null) {
            Object obj = _fsGetLayoutNode.get();
            if (obj instanceof FSComposeLayoutNode) {
                return (FSComposeLayoutNode) obj;
            }
            return null;
        }
        return null;
    }

    private C0248az b(View view) {
        C0248az c0248az = (C0248az) this.b.get(view);
        if (c0248az != null) {
            return c0248az;
        }
        C0248az a2 = C0244av.a(view, this.e);
        this.b.put(view, a2);
        return a2;
    }

    private C0248az b(FSComposeLayoutNode fSComposeLayoutNode) {
        synchronized (this) {
            C0248az c0248az = (C0248az) this.c.get(fSComposeLayoutNode);
            if (c0248az != null) {
                return c0248az;
            }
            C0248az a2 = C0244av.a(fSComposeLayoutNode, this.e, this.f);
            this.c.put(fSComposeLayoutNode, a2);
            this.d.remove(fSComposeLayoutNode);
            return a2;
        }
    }

    public FSComposeLayoutNode a(FSComposeModifier fSComposeModifier) {
        synchronized (this) {
            FSClickModifier a2 = C0244av.a(fSComposeModifier);
            if (a2 == null) {
                return null;
            }
            if (this.d.isEmpty()) {
                return a(a2);
            }
            for (FSComposeLayoutNode fSComposeLayoutNode : new HashSet(this.d)) {
                if (fSComposeLayoutNode != null) {
                    b(fSComposeLayoutNode);
                    FSComposeLayoutNode a3 = a(a2);
                    if (a3 != null) {
                        return a3;
                    }
                }
            }
            return null;
        }
    }

    public C0248az a(Object obj) {
        if (obj instanceof View) {
            return b((View) obj);
        }
        if (obj instanceof FSComposeLayoutNode) {
            return b((FSComposeLayoutNode) obj);
        }
        ff.c(obj);
        return new C0248az();
    }

    public void a() {
        this.f7934a.set(true);
    }

    public void a(View view) {
        this.b.remove(view);
        a();
    }

    public void a(FSComposeLayoutNode fSComposeLayoutNode) {
        synchronized (this) {
            this.c.remove(fSComposeLayoutNode);
            this.d.add(fSComposeLayoutNode);
            a();
        }
    }

    public boolean b() {
        return this.f7934a.getAndSet(false);
    }
}
