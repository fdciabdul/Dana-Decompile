package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.os.BuildCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface PermissionCompatDelegate {
        boolean KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, String[] strArr, int i);
    }

    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    protected ActivityCompat() {
    }

    public static void PlaceComponentResult(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.BuiltInFictitiousFunctionClassFactory(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void PlaceComponentResult(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT < 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public static void PlaceComponentResult(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.PlaceComponentResult(activity);
        } else {
            activity.finish();
        }
    }

    public static void getAuthRequestContext(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.PlaceComponentResult(activity);
        } else {
            activity.finish();
        }
    }

    public static Uri BuiltInFictitiousFunctionClassFactory(Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return Api22Impl.MyBillsEntityDataFactory(activity);
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    public static void MyBillsEntityDataFactory(Activity activity, SharedElementCallback sharedElementCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Activity activity, SharedElementCallback sharedElementCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(activity);
        }
    }

    public static void lookAheadTest(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(activity);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(final Activity activity, String[] strArr, final int i) {
        PermissionCompatDelegate permissionCompatDelegate = KClassImpl$Data$declaredNonStaticMembers$2;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.KClassImpl$Data$declaredNonStaticMembers$2(activity, strArr, i)) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (TextUtils.isEmpty(strArr[i2])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Permission request for permissions ");
                    sb.append(Arrays.toString(strArr));
                    sb.append(" must not contain null or empty values");
                    throw new IllegalArgumentException(sb.toString());
                }
                if (!BuildCompat.PlaceComponentResult() && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i2));
                }
            }
            int size = hashSet.size();
            final String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    if (!hashSet.contains(Integer.valueOf(i4))) {
                        strArr2[i3] = strArr[i4];
                        i3++;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof RequestPermissionsRequestCodeValidator) {
                    ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
                }
                Api23Impl.PlaceComponentResult(activity, strArr, i);
            } else if (activity instanceof OnRequestPermissionsResultCallback) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.ActivityCompat.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int[] iArr = new int[strArr2.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr2.length;
                        for (int i5 = 0; i5 < length; i5++) {
                            iArr[i5] = packageManager.checkPermission(strArr2[i5], packageName);
                        }
                        ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i, strArr2, iArr);
                    }
                });
            }
        }
    }

    public static boolean MyBillsEntityDataFactory(Activity activity, String str) {
        if ((BuildCompat.PlaceComponentResult() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.PlaceComponentResult(activity, str);
        }
        return false;
    }

    public static void getErrorConfigVersion(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityCompat.MyBillsEntityDataFactory(activity);
                }
            });
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Activity activity) {
        if (activity.isFinishing() || ActivityRecreator.MyBillsEntityDataFactory(activity)) {
            return;
        }
        activity.recreate();
    }

    /* loaded from: classes.dex */
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback BuiltInFictitiousFunctionClassFactory;

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.BuiltInFictitiousFunctionClassFactory = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            Bitmap KClassImpl$Data$declaredNonStaticMembers$2;
            SharedElementCallback sharedElementCallback = this.BuiltInFictitiousFunctionClassFactory;
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null && (KClassImpl$Data$declaredNonStaticMembers$2 = SharedElementCallback.KClassImpl$Data$declaredNonStaticMembers$2(drawable)) != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("sharedElement:snapshot:bitmap", KClassImpl$Data$declaredNonStaticMembers$2);
                    bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                    if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        float[] fArr = new float[9];
                        imageView.getImageMatrix().getValues(fArr);
                        bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                    }
                    return bundle;
                }
            }
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            if (round <= 0 || round2 <= 0) {
                return null;
            }
            float min = Math.min(1.0f, 1048576.0f / (round * round2));
            int i = (int) (round * min);
            int i2 = (int) (round2 * min);
            if (sharedElementCallback.PlaceComponentResult == null) {
                sharedElementCallback.PlaceComponentResult = new Matrix();
            }
            sharedElementCallback.PlaceComponentResult.set(matrix);
            sharedElementCallback.PlaceComponentResult.postTranslate(-rectF.left, -rectF.top);
            sharedElementCallback.PlaceComponentResult.postScale(min, min);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.concat(sharedElementCallback.PlaceComponentResult);
            view.draw(canvas);
            return createBitmap;
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return SharedElementCallback.MyBillsEntityDataFactory(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            SharedElementCallback.MyBillsEntityDataFactory(new SharedElementCallback.OnSharedElementsReadyListener() { // from class: androidx.core.app.ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0
                @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
                public final void MyBillsEntityDataFactory() {
                    ActivityCompat.Api23Impl.PlaceComponentResult(onSharedElementsReadyListener);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        private Api30Impl() {
        }
    }

    /* loaded from: classes.dex */
    static class Api31Impl {
        private Api31Impl() {
        }
    }

    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(Activity activity, Intent intent, int i, Bundle bundle) {
            activity.startActivityForResult(intent, i, bundle);
        }

        static void PlaceComponentResult(Activity activity) {
            activity.finishAffinity();
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void PlaceComponentResult(Activity activity) {
            activity.finishAfterTransition();
        }

        static void BuiltInFictitiousFunctionClassFactory(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void getAuthRequestContext(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void MyBillsEntityDataFactory(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api22Impl {
        private Api22Impl() {
        }

        static Uri MyBillsEntityDataFactory(Activity activity) {
            return activity.getReferrer();
        }
    }

    /* loaded from: classes.dex */
    static class Api28Impl {
        private Api28Impl() {
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static void PlaceComponentResult(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        static boolean PlaceComponentResult(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }

        public static void PlaceComponentResult(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }
    }
}
