package id.dana.drawable;

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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\nJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u000f\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0015\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0018J'\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u001aJ\u001b\u0010\u0011\u001a\u00020\u001b*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u001c"}, d2 = {"Lid/dana/nearbyrevamp/NewShopMarkerHelper;", "", "Landroid/content/Context;", "p0", "Lid/dana/nearbyme/model/ShopModel;", "p1", "", "p2", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/nearbyme/model/ShopModel;Z)Lcom/google/android/gms/maps/model/BitmapDescriptor;", "", "p3", "p4", "Landroid/graphics/Bitmap;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;IILid/dana/nearbyme/model/ShopModel;Z)Landroid/graphics/Bitmap;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;)Lcom/google/android/gms/maps/model/BitmapDescriptor;", "Landroid/view/View;", "MyBillsEntityDataFactory", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "PlaceComponentResult", "()I", "", "(Landroid/content/Context;Ljava/lang/String;Z)I", "", "(Landroid/view/View;Lid/dana/nearbyme/model/ShopModel;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewShopMarkerHelper {
    public static final NewShopMarkerHelper INSTANCE = new NewShopMarkerHelper();

    private NewShopMarkerHelper() {
    }

    @JvmStatic
    public static final BitmapDescriptor BuiltInFictitiousFunctionClassFactory(Context p0, Drawable p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object systemService = p0.getSystemService("layout_inflater");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.view_user_location_marker, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ivUserMarkerIcon);
        if (imageView != null) {
            imageView.setImageDrawable(p1);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(MyBillsEntityDataFactory(inflate));
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "");
        return fromBitmap;
    }

    @JvmStatic
    public static final BitmapDescriptor KClassImpl$Data$declaredNonStaticMembers$2(Context p0, ShopModel p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(BuiltInFictitiousFunctionClassFactory(p0, R.layout.view_new_shop_marker, R.drawable.ic_new_merchant_pin, p1, p2));
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "");
        return fromBitmap;
    }

    @JvmStatic
    public static final BitmapDescriptor getAuthRequestContext(Context p0, ShopModel p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(BuiltInFictitiousFunctionClassFactory(p0, R.layout.view_new_shop_highlight_marker, R.drawable.ic_new_merchant_highlight_pin, p1, p2));
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "");
        return fromBitmap;
    }

    @JvmStatic
    public static final int getAuthRequestContext(Context p0, String p1, boolean p2) {
        int authRequestContext;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        TextView textView = new TextView(p0);
        textView.setTextSize(10.0f);
        textView.setPadding(6, 0, 6, 0);
        textView.setText(p1);
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (p2) {
            authRequestContext = SizeUtil.getAuthRequestContext(52);
        } else {
            authRequestContext = SizeUtil.getAuthRequestContext(29);
        }
        textView.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        return Math.max(authRequestContext, textView.getMeasuredWidth());
    }

    @JvmStatic
    public static final int MyBillsEntityDataFactory() {
        return SizeUtil.getAuthRequestContext(70);
    }

    @JvmStatic
    public static final int PlaceComponentResult() {
        return SizeUtil.getAuthRequestContext(90);
    }

    private static Bitmap BuiltInFictitiousFunctionClassFactory(Context p0, int p1, int p2, ShopModel p3, boolean p4) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        Object systemService = p0.getSystemService("layout_inflater");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        View inflate = ((LayoutInflater) systemService).inflate(p1, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        if (p2 != 0 && (appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.ivCustomMarkerBackground)) != null) {
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, p2);
            } else {
                appCompatImageView.setImageResource(p2);
            }
        }
        if (p4) {
            KClassImpl$Data$declaredNonStaticMembers$2(inflate, p3);
        } else {
            TextView textView2 = (TextView) inflate.findViewById(R.id.RecentRecipientEntityRepository);
            if (textView2 != null) {
                Intrinsics.checkNotNullExpressionValue(textView2, "");
                textView2.setVisibility(4);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.res_0x7f0a1530_getindosubdivisionsnamebylocation_lambda_3);
            if (appCompatTextView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(4);
            }
        }
        if (p3.whenAvailable != 0 && (textView = (TextView) inflate.findViewById(R.id.TelemetryInitProducer)) != null) {
            textView.setText(String.valueOf(p3.whenAvailable));
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        return MyBillsEntityDataFactory(inflate);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(View view, ShopModel shopModel) {
        TextView textView = (TextView) view.findViewById(R.id.RecentRecipientEntityRepository);
        if (textView != null) {
            String str = shopModel.newProxyInstance;
            if (!(str == null || str.length() == 0)) {
                textView.setText(shopModel.MyBillsEntityDataFactory());
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.res_0x7f0a1530_getindosubdivisionsnamebylocation_lambda_3);
        if (appCompatTextView != null) {
            if (shopModel.readMicros > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                appCompatTextView.setText(NearbyExtensionKt.BuiltInFictitiousFunctionClassFactory(shopModel));
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_star_10dp_filled, 0, 0, 0);
                appCompatTextView.setVisibility(0);
                return;
            }
            appCompatTextView.setVisibility(4);
        }
    }

    private static Bitmap MyBillsEntityDataFactory(View p0) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        p0.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        p0.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        Bitmap createBitmap = Bitmap.createBitmap(p0.getMeasuredWidth(), p0.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "");
        p0.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
