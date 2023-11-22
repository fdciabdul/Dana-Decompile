package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.acs.plugin.ui.activity.ThirdPartyAuthActivity;
import id.dana.animation.view.QrRefreshNotification;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode getAuthRequestContext = PorterDuff.Mode.SRC_IN;
    public byte[] BuiltInFictitiousFunctionClassFactory;
    Object KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public int NetworkUserEntityData$$ExternalSyntheticLambda1;
    public int PlaceComponentResult;
    public String getErrorConfigVersion;
    public ColorStateList lookAheadTest;
    public Parcelable moveToNextValue;
    PorterDuff.Mode scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface IconType {
    }

    private static String BuiltInFictitiousFunctionClassFactory(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return QrRefreshNotification.DATA;
            case 4:
                return ThirdPartyAuthActivity.KEY_URI;
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public static IconCompat KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        ObjectsCompat.BuiltInFictitiousFunctionClassFactory(context);
        return PlaceComponentResult(context.getResources(), context.getPackageName(), i);
    }

    public static IconCompat PlaceComponentResult(Resources resources, String str, int i) {
        ObjectsCompat.BuiltInFictitiousFunctionClassFactory(str);
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.MyBillsEntityDataFactory = i;
        if (resources != null) {
            try {
                iconCompat.KClassImpl$Data$declaredNonStaticMembers$2 = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
        iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        return iconCompat;
    }

    public static IconCompat KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
        ObjectsCompat.BuiltInFictitiousFunctionClassFactory(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.KClassImpl$Data$declaredNonStaticMembers$2 = bitmap;
        return iconCompat;
    }

    public static IconCompat PlaceComponentResult(Bitmap bitmap) {
        ObjectsCompat.BuiltInFictitiousFunctionClassFactory(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.KClassImpl$Data$declaredNonStaticMembers$2 = bitmap;
        return iconCompat;
    }

    public IconCompat() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.moveToNextValue = null;
        this.MyBillsEntityDataFactory = 0;
        this.PlaceComponentResult = 0;
        this.lookAheadTest = null;
        this.scheduleImpl = getAuthRequestContext;
        this.getErrorConfigVersion = null;
    }

    IconCompat(int i) {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.moveToNextValue = null;
        this.MyBillsEntityDataFactory = 0;
        this.PlaceComponentResult = 0;
        this.lookAheadTest = null;
        this.scheduleImpl = getAuthRequestContext;
        this.getErrorConfigVersion = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
    }

    public int KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public String getAuthRequestContext() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("called getResPackage() on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str == null || TextUtils.isEmpty(str)) {
            return ((String) this.KClassImpl$Data$declaredNonStaticMembers$2).split(":", -1)[0];
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public int MyBillsEntityDataFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("called getResId() on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        return this.MyBillsEntityDataFactory;
    }

    public Bitmap BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (i == 1) {
            return (Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (i == 5) {
            return MyBillsEntityDataFactory((Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2, true);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("called getBitmap() on ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public Uri PlaceComponentResult() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (i != 4 && i != 6) {
            StringBuilder sb = new StringBuilder();
            sb.append("called getUri() on ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        return Uri.parse((String) this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Deprecated
    public Icon moveToNextValue() {
        return PlaceComponentResult((Context) null);
    }

    public Icon PlaceComponentResult(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.MyBillsEntityDataFactory(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public void BuiltInFictitiousFunctionClassFactory(Context context) {
        Object obj;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != 2 || (obj = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                InstrumentInjector.log_i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            String authRequestContext = getAuthRequestContext();
            int identifier = MyBillsEntityDataFactory(context, authRequestContext).getIdentifier(str4, str3, str5);
            if (this.MyBillsEntityDataFactory != identifier) {
                StringBuilder sb = new StringBuilder();
                sb.append("Id has changed for ");
                sb.append(authRequestContext);
                sb.append(" ");
                sb.append(str);
                InstrumentInjector.log_i("IconCompat", sb.toString());
                this.MyBillsEntityDataFactory = identifier;
            }
        }
    }

    public Drawable getAuthRequestContext(Context context) {
        BuiltInFictitiousFunctionClassFactory(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.PlaceComponentResult(PlaceComponentResult(context), context);
        }
        Drawable KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(context);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null && (this.lookAheadTest != null || this.scheduleImpl != getAuthRequestContext)) {
            KClassImpl$Data$declaredNonStaticMembers$2.mutate();
            DrawableCompat.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest);
            DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private Drawable KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        switch (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2);
            case 2:
                String authRequestContext = getAuthRequestContext();
                if (TextUtils.isEmpty(authRequestContext)) {
                    authRequestContext = context.getPackageName();
                }
                try {
                    return ResourcesCompat.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(context, authRequestContext), this.MyBillsEntityDataFactory, context.getTheme());
                } catch (RuntimeException e) {
                    InstrumentInjector.log_e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.MyBillsEntityDataFactory), this.KClassImpl$Data$declaredNonStaticMembers$2), e);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult));
            case 4:
                InputStream MyBillsEntityDataFactory = MyBillsEntityDataFactory(context);
                if (MyBillsEntityDataFactory != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(MyBillsEntityDataFactory));
                }
                break;
            case 5:
                return new BitmapDrawable(context.getResources(), MyBillsEntityDataFactory((Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2, false));
            case 6:
                InputStream MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context);
                if (MyBillsEntityDataFactory2 != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return Api26Impl.getAuthRequestContext(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(MyBillsEntityDataFactory2)));
                    }
                    return new BitmapDrawable(context.getResources(), MyBillsEntityDataFactory(BitmapFactory.decodeStream(MyBillsEntityDataFactory2), false));
                }
                break;
        }
        return null;
    }

    public InputStream MyBillsEntityDataFactory(Context context) {
        Uri PlaceComponentResult = PlaceComponentResult();
        String scheme = PlaceComponentResult.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(PlaceComponentResult);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to load image from URI: ");
                sb.append(PlaceComponentResult);
                InstrumentInjector.log_w("IconCompat", sb.toString(), e);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.KClassImpl$Data$declaredNonStaticMembers$2));
        } catch (FileNotFoundException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to load image from path: ");
            sb2.append(PlaceComponentResult);
            InstrumentInjector.log_w("IconCompat", sb2.toString(), e2);
            return null;
        }
    }

    static Resources MyBillsEntityDataFactory(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            InstrumentInjector.log_e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e);
            return null;
        }
    }

    public Bundle scheduleImpl() {
        Bundle bundle = new Bundle();
        switch (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
        }
        bundle.putInt("type", this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        bundle.putInt("int1", this.MyBillsEntityDataFactory);
        bundle.putInt("int2", this.PlaceComponentResult);
        bundle.putString("string1", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        ColorStateList colorStateList = this.lookAheadTest;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.scheduleImpl;
        if (mode != getAuthRequestContext) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public String toString() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1) {
            return String.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
        switch (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(MyBillsEntityDataFactory())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.MyBillsEntityDataFactory);
                if (this.PlaceComponentResult != 0) {
                    sb.append(" off=");
                    sb.append(this.PlaceComponentResult);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
        }
        if (this.lookAheadTest != null) {
            sb.append(" tint=");
            sb.append(this.lookAheadTest);
        }
        if (this.scheduleImpl != getAuthRequestContext) {
            sb.append(" mode=");
            sb.append(this.scheduleImpl);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void getAuthRequestContext(boolean z) {
        this.getErrorConfigVersion = this.scheduleImpl.name();
        switch (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.moveToNextValue = (Parcelable) this.KClassImpl$Data$declaredNonStaticMembers$2;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.KClassImpl$Data$declaredNonStaticMembers$2;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.BuiltInFictitiousFunctionClassFactory = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.moveToNextValue = (Parcelable) this.KClassImpl$Data$declaredNonStaticMembers$2;
                return;
            case 2:
                this.BuiltInFictitiousFunctionClassFactory = ((String) this.KClassImpl$Data$declaredNonStaticMembers$2).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.BuiltInFictitiousFunctionClassFactory = (byte[]) this.KClassImpl$Data$declaredNonStaticMembers$2;
                return;
            case 4:
            case 6:
                this.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void lookAheadTest() {
        this.scheduleImpl = PorterDuff.Mode.valueOf(this.getErrorConfigVersion);
        switch (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            case -1:
                Parcelable parcelable = this.moveToNextValue;
                if (parcelable != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.moveToNextValue;
                if (parcelable2 != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = parcelable2;
                    return;
                }
                byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = bArr;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 3;
                this.MyBillsEntityDataFactory = 0;
                this.PlaceComponentResult = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.BuiltInFictitiousFunctionClassFactory, Charset.forName("UTF-16"));
                this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == 2 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
                return;
        }
    }

    static Bitmap MyBillsEntityDataFactory(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static String MyBillsEntityDataFactory(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int PlaceComponentResult(Object obj) {
            return ((Icon) obj).getType();
        }

        static int getAuthRequestContext(Object obj) {
            return ((Icon) obj).getResId();
        }

        static Uri BuiltInFictitiousFunctionClassFactory(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static Drawable getAuthRequestContext(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon PlaceComponentResult(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static Icon getAuthRequestContext(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static int KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.PlaceComponentResult(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                InstrumentInjector.log_e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(obj);
                InstrumentInjector.log_e("IconCompat", sb2.toString(), e2);
                return -1;
            } catch (InvocationTargetException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to get icon type ");
                sb3.append(obj);
                InstrumentInjector.log_e("IconCompat", sb3.toString(), e3);
                return -1;
            }
        }

        static String MyBillsEntityDataFactory(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.MyBillsEntityDataFactory(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon package", e);
                return null;
            } catch (NoSuchMethodException e2) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon package", e2);
                return null;
            } catch (InvocationTargetException e3) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon package", e3);
                return null;
            }
        }

        static int PlaceComponentResult(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getAuthRequestContext(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon resource", e);
                return 0;
            } catch (NoSuchMethodException e2) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            } catch (InvocationTargetException e3) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            }
        }

        static Uri getAuthRequestContext(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.BuiltInFictitiousFunctionClassFactory(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon uri", e);
                return null;
            } catch (NoSuchMethodException e2) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (InvocationTargetException e3) {
                InstrumentInjector.log_e("IconCompat", "Unable to get icon uri", e3);
                return null;
            }
        }

        static Icon MyBillsEntityDataFactory(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                case -1:
                    return (Icon) iconCompat.KClassImpl$Data$declaredNonStaticMembers$2;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.KClassImpl$Data$declaredNonStaticMembers$2);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.getAuthRequestContext(), iconCompat.MyBillsEntityDataFactory);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.KClassImpl$Data$declaredNonStaticMembers$2, iconCompat.MyBillsEntityDataFactory, iconCompat.PlaceComponentResult);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.KClassImpl$Data$declaredNonStaticMembers$2);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 26) {
                        createWithBitmap = Api26Impl.PlaceComponentResult((Bitmap) iconCompat.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(IconCompat.MyBillsEntityDataFactory((Bitmap) iconCompat.KClassImpl$Data$declaredNonStaticMembers$2, false));
                        break;
                    }
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        createWithBitmap = Api30Impl.getAuthRequestContext(iconCompat.PlaceComponentResult());
                        break;
                    } else if (context == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Context is required to resolve the file uri of the icon: ");
                        sb.append(iconCompat.PlaceComponentResult());
                        throw new IllegalArgumentException(sb.toString());
                    } else {
                        InputStream MyBillsEntityDataFactory = iconCompat.MyBillsEntityDataFactory(context);
                        if (MyBillsEntityDataFactory == null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Cannot load adaptive icon from uri: ");
                            sb2.append(iconCompat.PlaceComponentResult());
                            throw new IllegalStateException(sb2.toString());
                        } else if (Build.VERSION.SDK_INT >= 26) {
                            createWithBitmap = Api26Impl.PlaceComponentResult(BitmapFactory.decodeStream(MyBillsEntityDataFactory));
                            break;
                        } else {
                            createWithBitmap = Icon.createWithBitmap(IconCompat.MyBillsEntityDataFactory(BitmapFactory.decodeStream(MyBillsEntityDataFactory), false));
                            break;
                        }
                    }
            }
            if (iconCompat.lookAheadTest != null) {
                createWithBitmap.setTintList(iconCompat.lookAheadTest);
            }
            if (iconCompat.scheduleImpl != IconCompat.getAuthRequestContext) {
                createWithBitmap.setTintMode(iconCompat.scheduleImpl);
            }
            return createWithBitmap;
        }

        static Drawable PlaceComponentResult(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }
    }
}
