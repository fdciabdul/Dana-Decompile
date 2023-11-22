package fsimpl;

import java.io.IOException;

/* renamed from: fsimpl.dp  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0318dp extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private int f7942a;

    public C0318dp(int i, String str) {
        super(str);
        this.f7942a = i;
    }

    public boolean a() {
        int i = this.f7942a;
        return i >= 400 && i < 500;
    }
}
