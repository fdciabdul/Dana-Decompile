package id.dana.component.customtoastcomponent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.component.R;
import id.dana.component.utils.ImageResize;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007JP\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ@\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¨\u0006\u0015"}, d2 = {"Lid/dana/component/customtoastcomponent/CustomToast;", "", "()V", "showCustomToast", "", HummerConstants.CONTEXT, "Landroid/app/Activity;", "image", "", ZebraData.ATTR_BACKGROUND, "message", "", "gravity", "xOffsetInDp", "yOffsetInDp", "fillHorizontal", "", "contentDescription", "showCustomToastWithoutIcon", "showTopCustomToast", "border", "design_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CustomToast {
    public static final CustomToast MyBillsEntityDataFactory = new CustomToast();

    private CustomToast() {
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Activity activity, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        BuiltInFictitiousFunctionClassFactory(activity, i, i2, str, 64, true, null);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Activity activity, int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        BuiltInFictitiousFunctionClassFactory(activity, i, i2, str, 64, true, str2);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Activity activity, int i, int i2, String str, int i3) {
        BuiltInFictitiousFunctionClassFactory(activity, i, i2, str, i3, true, null);
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Activity activity, int i, int i2, String str, int i3, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "");
        View inflate = layoutInflater.inflate(R.layout.view_custom_overlays_toast, (ViewGroup) null);
        if (inflate != null) {
            inflate.setContentDescription(str2);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.res_0x7f0a0992_networkuserentitydata_externalsyntheticlambda6);
        InstrumentInjector.Resources_setImageResource(imageView, i);
        TextView textView = (TextView) inflate.findViewById(R.id.tvCustomToast);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setText(str);
        View findViewById = inflate.findViewById(R.id.scheduleImpl_res_0x7f0a0364);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
        constraintLayout.setBackgroundResource(i2);
        if (i == 0) {
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(4);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext(constraintLayout);
            int i4 = R.id.tvCustomToast;
            ViewParent parent = textView.getParent();
            if (parent != null) {
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(i4, 1, ((View) parent).getId(), 1, 16);
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        }
        Toast toast = new Toast(activity.getApplicationContext());
        toast.setDuration(0);
        toast.setGravity(55, ImageResize.BuiltInFictitiousFunctionClassFactory(activity, 0), ImageResize.BuiltInFictitiousFunctionClassFactory(activity, i3));
        toast.setView(inflate);
        toast.show();
    }
}
