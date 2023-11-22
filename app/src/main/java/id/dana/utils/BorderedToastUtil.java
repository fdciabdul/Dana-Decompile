package id.dana.utils;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JH\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\n¨\u0006\u0013"}, d2 = {"Lid/dana/utils/BorderedToastUtil;", "", "()V", "showToast", "", HummerConstants.CONTEXT, "Landroid/app/Activity;", "view", "Landroid/view/View;", "gravity", "", "delayInMillis", "", "showToastMessage", "image", "borderColor", "message", "", "maxTextLines", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BorderedToastUtil {
    public static final BorderedToastUtil MyBillsEntityDataFactory = new BorderedToastUtil();

    private BorderedToastUtil() {
    }

    public static void MyBillsEntityDataFactory(Activity activity, int i, int i2, String str, int i3, long j, int i4) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "");
        View inflate = layoutInflater.inflate(id.dana.R.layout.view_toast_template, (ViewGroup) null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(id.dana.R.id.SaveFaceAuthSuggestionState_Factory);
        if (appCompatImageView != null) {
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
        }
        TextView textView = (TextView) inflate.findViewById(id.dana.R.id.FlowAdapters);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(id.dana.R.id.FlowAdapters);
        if (textView2 != null) {
            textView2.setMaxLines(i4);
        }
        ((CardView) inflate.findViewById(id.dana.R.id.cv_toast)).setCardBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(activity, i2));
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        getAuthRequestContext(activity, inflate, i3, j);
    }

    private static void getAuthRequestContext(Activity activity, View view, int i, long j) {
        final Toast toast = new Toast(activity.getApplicationContext());
        toast.setDuration(0);
        toast.setGravity(i, 0, SizeUtil.getAuthRequestContext(48));
        toast.setView(view);
        toast.show();
        new Handler().postDelayed(new Runnable() { // from class: id.dana.utils.BorderedToastUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                toast.cancel();
            }
        }, j);
    }
}
