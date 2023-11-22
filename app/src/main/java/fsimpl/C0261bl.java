package fsimpl;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.bl  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0261bl extends AbstractC0258bi {

    /* renamed from: a  reason: collision with root package name */
    private final C0257bh f7891a;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0261bl(C0257bh c0257bh) {
        super();
        this.f7891a = c0257bh;
    }

    private FragmentManager c(Activity activity) {
        try {
            if (activity instanceof FragmentActivity) {
                return ((FragmentActivity) activity).getSupportFragmentManager();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // fsimpl.AbstractC0258bi
    public final List a() {
        return this.f7891a.getResumedFragmentViewHashes();
    }

    @Override // fsimpl.AbstractC0258bi
    public final void a(Activity activity) {
        try {
            FragmentManager c = c(activity);
            if (c != null) {
                c.registerFragmentLifecycleCallbacks(this.f7891a, true);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // fsimpl.AbstractC0258bi
    public final void b(Activity activity) {
        try {
            FragmentManager c = c(activity);
            if (c != null) {
                c.unregisterFragmentLifecycleCallbacks(this.f7891a);
            }
        } catch (Throwable unused) {
        }
    }
}
