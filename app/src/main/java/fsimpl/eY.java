package fsimpl;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class eY extends PrintWriter {

    /* renamed from: a  reason: collision with root package name */
    List f7963a;

    public eY(Writer writer) {
        super(writer);
        this.f7963a = new ArrayList();
    }

    @Override // java.io.PrintWriter
    public void println(Object obj) {
        this.f7963a.add(String.valueOf(obj));
        super.println(obj);
    }
}
