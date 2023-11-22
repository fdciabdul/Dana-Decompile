package fsimpl;

import id.dana.tracker.constant.TrackerType;
import java.io.File;
import java.io.IOException;

/* renamed from: fsimpl.z  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0376z {

    /* renamed from: a  reason: collision with root package name */
    private final File f8007a;
    private final File b;
    private final File c;
    private final File d;

    public C0376z(File file) {
        if (file.isFile()) {
            throw new IOException("Cache directory is a file, can't proceed");
        }
        this.d = new File(file, TrackerType.FULLSTORY);
        this.b = new File(this.d, "trash");
        this.f8007a = new File(this.d, "tmp");
        this.c = new File(this.d, "upload");
        eI.a(this.d, null);
        eI.a(this.b, null);
        if (this.f8007a.exists()) {
            eI.b(this.f8007a, this.b);
        }
        eI.a(this.f8007a, this.b);
        eI.a(this.c, this.b);
    }

    public File a() {
        return this.f8007a;
    }

    public File a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(str);
        return File.createTempFile("temp", sb.toString(), this.f8007a);
    }

    public void a(File file) {
        eI.b(file, this.b);
    }

    public File b() {
        return this.b;
    }

    public File c() {
        return this.c;
    }
}
