package o;

import java.io.BufferedInputStream;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class getSupportButtonTintMode extends BufferedInputStream {
    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public getSupportButtonTintMode(InputStream inputStream) {
        super(inputStream);
    }
}
