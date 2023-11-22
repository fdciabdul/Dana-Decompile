package butterknife.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

/* loaded from: classes6.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static final Runnable KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: butterknife.internal.DebouncingOnClickListener$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            DebouncingOnClickListener.getAuthRequestContext = true;
        }
    };
    private static final Handler PlaceComponentResult = new Handler(Looper.getMainLooper());
    static boolean getAuthRequestContext = true;

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (getAuthRequestContext) {
            getAuthRequestContext = false;
            PlaceComponentResult.post(KClassImpl$Data$declaredNonStaticMembers$2);
            KClassImpl$Data$declaredNonStaticMembers$2(view);
        }
    }
}
