package id.dana.core.ui.glide;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;

/* loaded from: classes.dex */
public final class GlideApp {
    private GlideApp() {
    }

    public static GlideRequests getAuthRequestContext(Context context) {
        return (GlideRequests) Glide.KClassImpl$Data$declaredNonStaticMembers$2(context);
    }

    public static GlideRequests PlaceComponentResult(FragmentActivity fragmentActivity) {
        return (GlideRequests) Glide.getAuthRequestContext(fragmentActivity);
    }

    public static GlideRequests KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment) {
        return (GlideRequests) Glide.MyBillsEntityDataFactory(fragment);
    }

    public static GlideRequests getAuthRequestContext(View view) {
        return (GlideRequests) Glide.getAuthRequestContext(view);
    }
}
