package id.dana.utils;

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
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007JD\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J,\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010¨\u0006\u0014"}, d2 = {"Lid/dana/utils/CustomToastUtil;", "", "()V", "showCustomToast", "", HummerConstants.CONTEXT, "Landroid/app/Activity;", "image", "", ZebraData.ATTR_BACKGROUND, "message", "", "gravity", "xOffsetInDp", "yOffsetInDp", "fillHorizontal", "", "contentDescription", "showCustomToastWithoutIcon", "showTopCustomToast", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomToastUtil {
    public static final CustomToastUtil MyBillsEntityDataFactory = new CustomToastUtil();

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        PlaceComponentResult(activity, id.dana.R.drawable.ic_warning_orange, id.dana.R.drawable.bg_rounded_tangerine, str, 48, 60, true, null, 256);
    }

    @JvmStatic
    public static final void getAuthRequestContext(Activity activity, int i, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        PlaceComponentResult(activity, i, id.dana.R.drawable.bg_rounded_toast_payment_auth, str, 48, 60, false, null, 384);
    }

    private CustomToastUtil() {
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, int i, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        PlaceComponentResult(activity, i, id.dana.R.drawable.bg_rounded_toast, str, 48, 24, false, null, 256);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        PlaceComponentResult(activity, 0, id.dana.R.drawable.bg_rounded_toast_payment_auth, str, 48, 60, true, null, 256);
    }

    public static /* synthetic */ void PlaceComponentResult(Activity activity, int i, int i2, String str, int i3, int i4, boolean z, String str2, int i5) {
        getAuthRequestContext(activity, i, i2, str, i3, 0, i4, (i5 & 128) != 0 ? false : z, (i5 & 256) != 0 ? null : str2);
    }

    @JvmStatic
    public static final void getAuthRequestContext(final Activity activity, int i, int i2, String str, final int i3, int i4, final int i5, final boolean z, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "");
        final View inflate = layoutInflater.inflate(id.dana.R.layout.view_custom_toast, (ViewGroup) null);
        if (inflate != null) {
            inflate.setContentDescription(str2);
        }
        ImageView imageView = (ImageView) inflate.findViewById(id.dana.R.id.iv_custom_toast);
        InstrumentInjector.Resources_setImageResource(imageView, i);
        TextView textView = (TextView) inflate.findViewById(id.dana.R.id.tv_custom_toast);
        textView.setText(str);
        View findViewById = inflate.findViewById(id.dana.R.id.cl_custom_toast);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
        constraintLayout.setBackgroundResource(i2);
        if (i == 0) {
            imageView.setVisibility(4);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext(constraintLayout);
            ViewParent parent = textView.getParent();
            if (parent != null) {
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.R.id.tv_custom_toast, 1, ((View) parent).getId(), 1, 16);
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        }
        final int i6 = 0;
        activity.runOnUiThread(new Runnable() { // from class: id.dana.utils.CustomToastUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CustomToastUtil.MyBillsEntityDataFactory(activity, z, i3, i6, i5, inflate);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Activity activity, boolean z, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(activity, "");
        Toast toast = new Toast(activity.getApplicationContext());
        toast.setDuration(0);
        if (z) {
            toast.setGravity(i | 7, ImageResize.PlaceComponentResult(activity, i2), ImageResize.PlaceComponentResult(activity, i3));
        } else {
            toast.setGravity(i, ImageResize.PlaceComponentResult(activity, i2), ImageResize.PlaceComponentResult(activity, i3));
        }
        toast.setView(view);
        toast.show();
    }
}
