package fsimpl;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public class fg {

    /* renamed from: a  reason: collision with root package name */
    int f7986a;
    fh[] b;
    volatile int c;
    private final ReferenceQueue d;
    private final int e;
    private int f;

    public fg() {
        this(16);
    }

    public fg(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.f7986a = 0;
        this.b = a(i == 0 ? 1 : i);
        this.e = 7500;
        b();
        this.d = new ReferenceQueue();
    }

    private static fh[] a(int i) {
        return new fh[i];
    }

    private void b() {
        this.f = (int) ((this.b.length * this.e) / 10000);
    }

    private void c() {
        int length = this.b.length * 2;
        if (length == 0) {
            length = 1;
        }
        fh[] a2 = a(length);
        int i = 0;
        while (true) {
            fh[] fhVarArr = this.b;
            if (i >= fhVarArr.length) {
                this.b = a2;
                b();
                return;
            }
            fh fhVar = fhVarArr[i];
            while (fhVar != null) {
                int i2 = fhVar.b ? 0 : (fhVar.f7987a & Integer.MAX_VALUE) % length;
                fh fhVar2 = fhVar.d;
                fhVar.d = a2[i2];
                a2[i2] = fhVar;
                fhVar = fhVar2;
            }
            i++;
        }
    }

    public int a(Object obj, int i) {
        fh fhVar;
        int i2;
        a();
        if (obj != null) {
            int hashCode = obj.hashCode();
            fh[] fhVarArr = this.b;
            i2 = (hashCode & Integer.MAX_VALUE) % fhVarArr.length;
            fhVar = fhVarArr[i2];
            while (fhVar != null && !obj.equals(fhVar.get())) {
                fhVar = fhVar.d;
            }
        } else {
            fhVar = this.b[0];
            while (fhVar != null && !fhVar.b) {
                fhVar = fhVar.d;
            }
            i2 = 0;
        }
        if (fhVar != null) {
            int i3 = fhVar.c;
            fhVar.c = i;
            return i3;
        }
        this.c++;
        int i4 = this.f7986a + 1;
        this.f7986a = i4;
        if (i4 > this.f) {
            c();
            i2 = obj == null ? 0 : (Integer.MAX_VALUE & obj.hashCode()) % this.b.length;
        }
        fh fhVar2 = new fh(obj, i, this.d);
        fhVar2.d = this.b[i2];
        this.b[i2] = fhVar2;
        return 0;
    }

    void a() {
        while (true) {
            fh fhVar = (fh) this.d.poll();
            if (fhVar == null) {
                return;
            }
            a(fhVar);
        }
    }

    void a(fh fhVar) {
        int i = fhVar.f7987a;
        fh[] fhVarArr = this.b;
        int length = (i & Integer.MAX_VALUE) % fhVarArr.length;
        fh fhVar2 = null;
        for (fh fhVar3 = fhVarArr[length]; fhVar3 != null; fhVar3 = fhVar3.d) {
            if (fhVar == fhVar3) {
                this.c++;
                if (fhVar2 == null) {
                    this.b[length] = fhVar3.d;
                } else {
                    fhVar2.d = fhVar3.d;
                }
                this.f7986a--;
                return;
            }
            fhVar2 = fhVar3;
        }
    }

    public boolean a(Object obj) {
        return c(obj) != null;
    }

    public int b(Object obj) {
        a();
        if (obj == null) {
            for (fh fhVar = this.b[0]; fhVar != null; fhVar = fhVar.d) {
                if (fhVar.b) {
                    return fhVar.c;
                }
            }
            return 0;
        }
        int hashCode = obj.hashCode();
        fh[] fhVarArr = this.b;
        for (fh fhVar2 = fhVarArr[(hashCode & Integer.MAX_VALUE) % fhVarArr.length]; fhVar2 != null; fhVar2 = fhVar2.d) {
            if (obj.equals(fhVar2.get())) {
                return fhVar2.c;
            }
        }
        return 0;
    }

    fh c(Object obj) {
        a();
        if (obj == null) {
            for (fh fhVar = this.b[0]; fhVar != null; fhVar = fhVar.d) {
                if (fhVar.b) {
                    return fhVar;
                }
            }
            return null;
        }
        int hashCode = obj.hashCode();
        fh[] fhVarArr = this.b;
        for (fh fhVar2 = fhVarArr[(hashCode & Integer.MAX_VALUE) % fhVarArr.length]; fhVar2 != null; fhVar2 = fhVar2.d) {
            if (obj.equals(fhVar2.get())) {
                return fhVar2;
            }
        }
        return null;
    }

    public int d(Object obj) {
        fh fhVar;
        fh fhVar2;
        int i;
        a();
        fh fhVar3 = null;
        if (obj != null) {
            int hashCode = obj.hashCode();
            fh[] fhVarArr = this.b;
            i = (hashCode & Integer.MAX_VALUE) % fhVarArr.length;
            fh fhVar4 = fhVarArr[i];
            while (true) {
                fh fhVar5 = fhVar4;
                fhVar2 = fhVar3;
                fhVar3 = fhVar5;
                if (fhVar3 == null || obj.equals(fhVar3.get())) {
                    break;
                }
                fhVar4 = fhVar3.d;
            }
        } else {
            fh fhVar6 = this.b[0];
            while (true) {
                fhVar = fhVar3;
                fhVar3 = fhVar6;
                if (fhVar3 == null || fhVar3.b) {
                    break;
                }
                fhVar6 = fhVar3.d;
            }
            fhVar2 = fhVar;
            i = 0;
        }
        if (fhVar3 != null) {
            this.c++;
            if (fhVar2 == null) {
                this.b[i] = fhVar3.d;
            } else {
                fhVar2.d = fhVar3.d;
            }
            this.f7986a--;
            return fhVar3.c;
        }
        return 0;
    }
}
