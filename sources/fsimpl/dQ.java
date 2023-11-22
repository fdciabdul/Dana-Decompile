package fsimpl;

import android.webkit.WebView;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class dQ extends WeakReference {

    /* renamed from: a  reason: collision with root package name */
    public final int f7923a;
    public int b;

    public dQ(int i, WebView webView, ReferenceQueue referenceQueue) {
        super(webView, referenceQueue);
        this.f7923a = i;
    }
}
