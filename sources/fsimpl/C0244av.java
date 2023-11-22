package fsimpl;

import android.content.res.Resources;
import android.view.View;
import com.alipay.iap.android.aplog.log.spm.SpmTrackIntegrator;
import com.fullstory.instrumentation.frameworks.compose.FSAttribute;
import com.fullstory.instrumentation.frameworks.compose.FSClass;
import com.fullstory.instrumentation.frameworks.compose.FSClickModifier;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;
import com.fullstory.instrumentation.frameworks.compose.FSComposeModifier;
import com.fullstory.instrumentation.frameworks.compose.FSComposeRole;
import com.fullstory.instrumentation.frameworks.compose.FSComposeSemanticsConfiguration;
import com.fullstory.instrumentation.frameworks.compose.FSComposeSemanticsModifier;
import com.fullstory.instrumentation.frameworks.compose.FSId;
import com.fullstory.instrumentation.frameworks.compose.FSTag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: fsimpl.av  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0244av {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f7862a = new WeakHashMap();
    private static final Map b = new WeakHashMap();

    public static FSClickModifier a(FSComposeModifier fSComposeModifier) {
        final FSClickModifier[] fSClickModifierArr = new FSClickModifier[1];
        C0264bo.a(fSComposeModifier, new InterfaceC0265bp() { // from class: fsimpl.-$$Lambda$av$yvzyTkZnX3CCvom2Hxjy8fbCujU
            @Override // fsimpl.InterfaceC0265bp
            public final void accept(FSComposeModifier fSComposeModifier2) {
                C0244av.a(fSClickModifierArr, fSComposeModifier2);
            }
        });
        return fSClickModifierArr[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
    
        if (r9 != 224) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
    
        if (r9 != 224) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
    
        r0.g = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static fsimpl.C0248az a(android.view.View r9, fsimpl.aA r10) {
        /*
            fsimpl.az r0 = new fsimpl.az
            r0.<init>()
            java.lang.String r1 = c(r9)
            r0.f7865a = r1
            java.lang.String r1 = b(r9)
            r0.e = r1
            java.lang.String r1 = a(r9)
            r0.b = r1
            java.lang.Object r1 = r9.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L38
            java.lang.String r1 = (java.lang.String) r1
            r0.a()
            java.util.Map r2 = r0.d
            java.lang.String r3 = "tag"
            r2.put(r3, r1)
            boolean r2 = fsimpl.C0256bg.d(r9)
            if (r2 == 0) goto L38
            java.util.Map r2 = r0.d
            java.lang.String r3 = "testid"
            r2.put(r3, r1)
        L38:
            r10.a(r9, r0)
            boolean r10 = r9 instanceof android.widget.TextView
            if (r10 == 0) goto La6
            android.widget.TextView r9 = (android.widget.TextView) r9
            android.text.style.URLSpan[] r10 = r9.getUrls()
            int r1 = r10.length
            if (r1 <= 0) goto L51
            r1 = 0
            r10 = r10[r1]
            java.lang.String r10 = r10.getURL()
            r0.f = r10
        L51:
            android.text.method.TransformationMethod r10 = r9.getTransformationMethod()
            boolean r10 = r10 instanceof android.text.method.PasswordTransformationMethod
            r1 = 4
            if (r10 == 0) goto L5b
            goto La4
        L5b:
            int r9 = r9.getInputType()
            r10 = r9 & 15
            r9 = r9 & 4080(0xff0, float:5.717E-42)
            r2 = 224(0xe0, float:3.14E-43)
            r3 = 144(0x90, float:2.02E-43)
            r4 = 128(0x80, float:1.794E-43)
            r5 = 1
            r6 = 16
            if (r10 == 0) goto L99
            r7 = 3
            r8 = 2
            if (r10 == r5) goto L82
            if (r10 == r8) goto L7c
            if (r10 == r7) goto L7a
            if (r10 != r1) goto La6
            r9 = 5
            goto L7f
        L7a:
            r9 = 7
            goto L7f
        L7c:
            if (r9 == r6) goto La4
            r9 = 6
        L7f:
            r0.g = r9
            goto La6
        L82:
            if (r9 == r6) goto L96
            r10 = 32
            if (r9 == r10) goto L93
            if (r9 == r4) goto La4
            if (r9 == r3) goto La4
            r10 = 208(0xd0, float:2.91E-43)
            if (r9 == r10) goto L93
            if (r9 == r2) goto La4
            goto La1
        L93:
            r0.g = r8
            goto La6
        L96:
            r0.g = r7
            goto La6
        L99:
            if (r9 == r6) goto La4
            if (r9 == r4) goto La4
            if (r9 == r3) goto La4
            if (r9 == r2) goto La4
        La1:
            r0.g = r5
            goto La6
        La4:
            r0.g = r1
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0244av.a(android.view.View, fsimpl.aA):fsimpl.az");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [fsimpl.aw] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    public static C0248az a(FSComposeLayoutNode fSComposeLayoutNode, aA aAVar, int i) {
        C0248az c0248az = new C0248az();
        c0248az.f7865a = b(fSComposeLayoutNode);
        c0248az.e = a(fSComposeLayoutNode);
        FSComposeModifier _fsGetModifier = fSComposeLayoutNode._fsGetModifier();
        if (_fsGetModifier != null) {
            String str = 0;
            C0247ay c0247ay = new C0247ay();
            boolean a2 = a(fSComposeLayoutNode, _fsGetModifier, c0247ay, i);
            boolean z = true;
            if (!a2) {
                c0248az.a(true);
            }
            c0248az.g = c0247ay.e;
            c0248az.b(c0247ay.f);
            if (c0247ay.d != null) {
                for (Map.Entry entry : c0247ay.d.entrySet()) {
                    c0248az.a();
                    c0248az.d.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (c0247ay.c != null) {
                for (String str2 : c0247ay.c) {
                    c0248az.b();
                    c0248az.c.add(str2);
                }
            }
            if (c0247ay.f7864a != null) {
                boolean z2 = true;
                for (String str3 : c0247ay.f7864a) {
                    if (i < 2) {
                        if (z2) {
                            c0248az.b = str3;
                            z2 = false;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(c0248az.b);
                            sb.append(SpmTrackIntegrator.SEPARATOR_CHAR);
                            sb.append(str3);
                            str3 = sb.toString();
                        }
                    }
                    c0248az.b = str3;
                }
            }
            if (c0247ay.b != null) {
                for (String str4 : c0247ay.b) {
                    if (i >= 2) {
                        str = str4;
                    } else if (z) {
                        str = str4;
                        z = false;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(SpmTrackIntegrator.SEPARATOR_CHAR);
                        sb2.append(str4);
                        str = sb2.toString();
                    }
                }
                if (str != 0) {
                    c0248az.a();
                    if (i >= 2) {
                        c0248az.f7865a = str.toLowerCase();
                    } else {
                        c0248az.d.put("tag", str);
                    }
                }
            }
        }
        return c0248az;
    }

    public static String a(View view) {
        int id2 = view != null ? view.getId() : -1;
        String str = null;
        if (id2 == -1 || C0256bg.d(view)) {
            return null;
        }
        synchronized (f7862a) {
            C0246ax c0246ax = (C0246ax) f7862a.get(view);
            if (c0246ax != null) {
                if (id2 == c0246ax.f7863a) {
                    return c0246ax.b;
                }
                f7862a.remove(view);
            }
            try {
                Resources resources = view.getResources();
                if (resources != null) {
                    str = resources.getResourceEntryName(id2);
                }
            } catch (Resources.NotFoundException unused) {
            }
            f7862a.put(view, new C0246ax(id2, str));
            return str;
        }
    }

    public static String a(Object obj) {
        Package r2;
        if (obj == null || (obj instanceof FSComposeLayoutNode) || (r2 = obj.getClass().getPackage()) == null) {
            return null;
        }
        return r2.getName();
    }

    public static void a() {
        synchronized (f7862a) {
            f7862a.clear();
        }
    }

    private static void a(C0247ay c0247ay, String str, String str2) {
        if (c0247ay.d == null) {
            c0247ay.d = new HashMap();
        }
        c0247ay.d.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FSClickModifier[] fSClickModifierArr, FSComposeModifier fSComposeModifier) {
        if (fSClickModifierArr[0] == null && (fSComposeModifier instanceof FSClickModifier)) {
            fSClickModifierArr[0] = (FSClickModifier) fSComposeModifier;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean[] zArr, C0247ay c0247ay, FSComposeLayoutNode fSComposeLayoutNode, int i, FSComposeModifier fSComposeModifier) {
        FSComposeSemanticsConfiguration _fsGetSemanticsConfiguration;
        String _fsGetTag;
        List list;
        if (fSComposeModifier instanceof FSAttribute) {
            zArr[0] = true;
            FSAttribute fSAttribute = (FSAttribute) fSComposeModifier;
            String _fsGetName = fSAttribute._fsGetName();
            String _fsGetValue = fSAttribute._fsGetValue();
            if (_fsGetName != null) {
                a(c0247ay, _fsGetName, _fsGetValue);
                return;
            }
            return;
        }
        if (fSComposeModifier instanceof FSClass) {
            zArr[0] = true;
            _fsGetTag = ((FSClass) fSComposeModifier)._fsGetClass();
            if (_fsGetTag == null) {
                return;
            }
            if (c0247ay.c == null) {
                c0247ay.c = new ArrayList();
            }
            list = c0247ay.c;
        } else if (fSComposeModifier instanceof FSId) {
            zArr[0] = true;
            _fsGetTag = ((FSId) fSComposeModifier)._fsGetId();
            if (_fsGetTag == null) {
                return;
            }
            if (c0247ay.f7864a == null) {
                c0247ay.f7864a = new ArrayList();
            }
            list = c0247ay.f7864a;
        } else if (!(fSComposeModifier instanceof FSTag)) {
            if (fSComposeModifier instanceof FSClickModifier) {
                ((FSClickModifier) fSComposeModifier)._fsSetLayoutNode(new WeakReference(fSComposeLayoutNode));
                return;
            } else if (!(fSComposeModifier instanceof FSComposeSemanticsModifier) || (_fsGetSemanticsConfiguration = fSComposeLayoutNode._fsGetSemanticsConfiguration((FSComposeSemanticsModifier) fSComposeModifier)) == null) {
                return;
            } else {
                if (c0247ay.e != 4 && _fsGetSemanticsConfiguration._fsIsPassword()) {
                    if (i >= 3) {
                        zArr[0] = true;
                    }
                    c0247ay.e = (byte) 4;
                    b.put(fSComposeLayoutNode, null);
                }
                if (i >= 2) {
                    FSComposeRole _fsGetRole = _fsGetSemanticsConfiguration._fsGetRole();
                    if (_fsGetRole != null) {
                        zArr[0] = true;
                        a(c0247ay, "semantic_role", _fsGetRole.toString().toLowerCase(Locale.US));
                    }
                    if (i < 3 || c0247ay.e == 4) {
                        return;
                    }
                    if (_fsGetSemanticsConfiguration._fsIsTextField() || _fsGetSemanticsConfiguration._fsGetText() != null) {
                        zArr[0] = true;
                        c0247ay.e = (byte) 1;
                        if (c0247ay.f) {
                            return;
                        }
                        c0247ay.f = _fsGetSemanticsConfiguration._fsIsTextField();
                        return;
                    }
                    return;
                }
                return;
            }
        } else {
            zArr[0] = true;
            _fsGetTag = ((FSTag) fSComposeModifier)._fsGetTag();
            if (_fsGetTag == null) {
                return;
            }
            if (c0247ay.b == null) {
                c0247ay.b = new ArrayList();
            }
            list = c0247ay.b;
        }
        list.add(_fsGetTag);
    }

    public static boolean a(final FSComposeLayoutNode fSComposeLayoutNode, FSComposeModifier fSComposeModifier, final C0247ay c0247ay, final int i) {
        final boolean[] zArr = new boolean[1];
        if (b.containsKey(fSComposeLayoutNode)) {
            if (i >= 3) {
                zArr[0] = true;
            }
            c0247ay.e = (byte) 4;
        }
        C0264bo.a(fSComposeModifier, new InterfaceC0265bp() { // from class: fsimpl.-$$Lambda$av$5mIRkx_ZOQIieKC0lH2vMcN62J8
            @Override // fsimpl.InterfaceC0265bp
            public final void accept(FSComposeModifier fSComposeModifier2) {
                C0244av.a(zArr, c0247ay, fSComposeLayoutNode, i, fSComposeModifier2);
            }
        });
        return zArr[0];
    }

    public static String b(View view) {
        return a((Object) view);
    }

    private static String b(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof FSComposeLayoutNode ? "compose" : obj.getClass().getSimpleName().toLowerCase();
    }

    public static String c(View view) {
        return b((Object) view);
    }
}
