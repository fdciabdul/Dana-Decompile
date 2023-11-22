package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dk implements ef<dk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f153a;

    /* renamed from: d  reason: collision with other field name */
    public String f158d;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f151a = new eu("Target");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7763a = new em("", (byte) 10, 1);
    private static final em b = new em("", (byte) 11, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 2, 5);
    private static final em f = new em("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f154a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f152a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f156b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f157c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f155a = false;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        r0 = r4.f153a.compareTo(r5.f153a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f156b.compareTo(r5.f156b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f157c.compareTo(r5.f157c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r5 = r4.f158d.compareTo(r5.f158d);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dk r5) {
        /*
            r4 = this;
            java.lang.Class r0 = r4.getClass()
            java.lang.Class r1 = r5.getClass()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L23
            java.lang.Class r0 = r4.getClass()
            java.lang.String r0 = r0.getName()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            int r5 = r0.compareTo(r5)
            return r5
        L23:
            boolean r0 = r4.m288a()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r5.m288a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto L3a
            return r0
        L3a:
            boolean r0 = r4.m288a()
            if (r0 == 0) goto L4b
            long r0 = r4.f152a
            long r2 = r5.f152a
            int r0 = com.xiaomi.push.eg.KClassImpl$Data$declaredNonStaticMembers$2(r0, r2)
            if (r0 == 0) goto L4b
            return r0
        L4b:
            boolean r0 = r4.b()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r5.b()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto L62
            return r0
        L62:
            boolean r0 = r4.b()
            if (r0 == 0) goto L73
            java.lang.String r0 = r4.f153a
            java.lang.String r1 = r5.f153a
            int r0 = com.xiaomi.push.eg.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
            if (r0 == 0) goto L73
            return r0
        L73:
            boolean r0 = r4.c()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r5.c()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto L8a
            return r0
        L8a:
            boolean r0 = r4.c()
            if (r0 == 0) goto L9b
            java.lang.String r0 = r4.f156b
            java.lang.String r1 = r5.f156b
            int r0 = com.xiaomi.push.eg.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
            if (r0 == 0) goto L9b
            return r0
        L9b:
            boolean r0 = r4.d()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r5.d()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto Lb2
            return r0
        Lb2:
            boolean r0 = r4.d()
            if (r0 == 0) goto Lc3
            java.lang.String r0 = r4.f157c
            java.lang.String r1 = r5.f157c
            int r0 = com.xiaomi.push.eg.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1)
            if (r0 == 0) goto Lc3
            return r0
        Lc3:
            boolean r0 = r4.e()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r5.e()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto Lda
            return r0
        Lda:
            boolean r0 = r4.e()
            if (r0 == 0) goto Leb
            boolean r0 = r4.f155a
            boolean r1 = r5.f155a
            int r0 = com.xiaomi.push.eg.PlaceComponentResult(r0, r1)
            if (r0 == 0) goto Leb
            return r0
        Leb:
            boolean r0 = r4.f()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r5.f()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto L102
            return r0
        L102:
            boolean r0 = r4.f()
            if (r0 == 0) goto L113
            java.lang.String r0 = r4.f158d
            java.lang.String r5 = r5.f158d
            int r5 = com.xiaomi.push.eg.KClassImpl$Data$declaredNonStaticMembers$2(r0, r5)
            if (r5 == 0) goto L113
            return r5
        L113:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dk.compareTo(com.xiaomi.push.dk):int");
    }

    public void a() {
        if (this.f153a != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'userId' was not present! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                break;
            }
            short s = PlaceComponentResult.MyBillsEntityDataFactory;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7 && PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                                    this.f158d = epVar.getErrorConfigVersion();
                                }
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                            } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 2) {
                                this.f155a = epVar.GetContactSyncConfig();
                                b(true);
                            } else {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                            }
                        } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                            this.f157c = epVar.getErrorConfigVersion();
                        } else {
                            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                        }
                    } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                        this.f156b = epVar.getErrorConfigVersion();
                    } else {
                        es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                    }
                } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                    this.f153a = epVar.getErrorConfigVersion();
                } else {
                    es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                }
            } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 10) {
                this.f152a = epVar.MyBillsEntityDataFactory();
                a(true);
            } else {
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
        if (m288a()) {
            a();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'channelId' was not found in serialized data! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    public void a(boolean z) {
        this.f154a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m288a() {
        return this.f154a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m289a(dk dkVar) {
        if (dkVar != null && this.f152a == dkVar.f152a) {
            boolean b2 = b();
            boolean b3 = dkVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f153a.equals(dkVar.f153a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = dkVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f156b.equals(dkVar.f156b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = dkVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f157c.equals(dkVar.f157c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = dkVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f155a == dkVar.f155a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = dkVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f158d.equals(dkVar.f158d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        epVar.PlaceComponentResult(f7763a);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f152a);
        if (this.f153a != null) {
            epVar.PlaceComponentResult(b);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f153a);
        }
        if (this.f156b != null && c()) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f156b);
        }
        if (this.f157c != null && d()) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f157c);
        }
        if (e()) {
            epVar.PlaceComponentResult(e);
            epVar.getAuthRequestContext(this.f155a);
        }
        if (this.f158d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f158d);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f154a.set(1, z);
    }

    public boolean b() {
        return this.f153a != null;
    }

    public boolean c() {
        return this.f156b != null;
    }

    public boolean d() {
        return this.f157c != null;
    }

    public boolean e() {
        return this.f154a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dk)) {
            return m289a((dk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f158d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f152a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f153a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f156b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f157c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f155a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f158d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
