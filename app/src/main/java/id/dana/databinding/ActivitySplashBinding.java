package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes2.dex */
public final class ActivitySplashBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final ImageView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    private final RelativeLayout scheduleImpl;

    private ActivitySplashBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        this.scheduleImpl = relativeLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.getAuthRequestContext = imageView2;
        this.PlaceComponentResult = imageView3;
        this.MyBillsEntityDataFactory = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
    }

    public static ActivitySplashBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_splash, (ViewGroup) null, false);
        int i = R.id.iv_bi_logo;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_bi_logo);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_kominfo_logo);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_splash);
                if (imageView3 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_dana);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.version_name);
                        if (textView2 != null) {
                            return new ActivitySplashBinding((RelativeLayout) inflate, imageView, imageView2, imageView3, textView, textView2);
                        }
                        i = R.id.version_name;
                    } else {
                        i = R.id.tv_dana;
                    }
                } else {
                    i = R.id.iv_splash;
                }
            } else {
                i = R.id.iv_kominfo_logo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
