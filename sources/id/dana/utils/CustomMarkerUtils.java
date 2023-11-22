package id.dana.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes9.dex */
public class CustomMarkerUtils {
    private CustomMarkerUtils() {
    }

    public static Bitmap MyBillsEntityDataFactory(Context context, Drawable drawable, String str, int i) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(id.dana.R.layout.view_custom_marker_highlighted, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(id.dana.R.id.iv_custom_marker_icon_highlight);
        ImageView imageView2 = (ImageView) inflate.findViewById(id.dana.R.id.iv_custom_marker_highlight_loadable);
        TextView textView = (TextView) inflate.findViewById(id.dana.R.id.tv_custom_marker_highlight);
        imageView.setBackgroundResource(i);
        imageView2.setImageDrawable(drawable);
        textView.setText(str);
        return KClassImpl$Data$declaredNonStaticMembers$2(inflate);
    }

    public static Bitmap BuiltInFictitiousFunctionClassFactory(Context context, int i, Drawable drawable, int i2, int i3) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        ((ImageView) inflate.findViewById(id.dana.R.id.iv_custom_marker_icon)).setBackgroundResource(i3);
        ((ImageView) inflate.findViewById(i2)).setImageDrawable(drawable);
        return KClassImpl$Data$declaredNonStaticMembers$2(inflate);
    }

    public static Bitmap MyBillsEntityDataFactory(Context context, int i, Drawable drawable, int i2, int i3) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        ((LottieAnimationView) inflate.findViewById(id.dana.R.id.iv_custom_marker_icon)).setBackgroundResource(i3);
        ((ImageView) inflate.findViewById(i2)).setImageDrawable(drawable);
        return KClassImpl$Data$declaredNonStaticMembers$2(inflate);
    }

    public static Bitmap PlaceComponentResult(Context context) {
        return KClassImpl$Data$declaredNonStaticMembers$2(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(id.dana.R.layout.view_custom_marker, (ViewGroup) null));
    }

    private static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
