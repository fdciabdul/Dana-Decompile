package id.dana.lib.gcontainer.util.handpicked;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.content.FileProvider;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.fastjson.JSONObject;
import com.anggrayudi.storage.extension.UriUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge;
import id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerEntity;
import id.dana.lib.logger.DANALog;
import id.dana.util.media.FileUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b)\u0010*J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00078CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'"}, d2 = {"Lid/dana/lib/gcontainer/util/handpicked/HandPicked;", "", "Landroid/net/Uri;", "imageUri", "Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;", "imageSpec", "Lio/reactivex/Observable;", "", "compressAndRotateImage", "(Landroid/net/Uri;Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;)Lio/reactivex/Observable;", "", "angle", "", "compressImage", "(FLandroid/net/Uri;Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;)Lio/reactivex/Observable;", "byteArray", "convertToBase64String", "([B)Lio/reactivex/Observable;", "Landroid/content/Intent;", "createCameraIntent", "()Landroid/content/Intent;", "Ljava/io/File;", "createImageFile", "()Ljava/io/File;", "data", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", IpcMessageConstants.EXTRA_EVENT, "", "onActivityResult", "(Landroid/content/Intent;Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Ljava/lang/String;)V", "rotateImage", "(Landroid/net/Uri;)Ljava/lang/Float;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "photoUri", "Landroid/net/Uri;", "getProviderAuthority", "()Ljava/lang/String;", "providerAuthority", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class HandPicked {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String IMAGE_CAPTURE_URI_EXTRA = "image_capture_uri_extra";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static byte[] MyBillsEntityDataFactory = null;
    private static final String PROVIDER_SUFFIX = ".provider";
    private static int PlaceComponentResult = 0;
    private static final String TAG;
    private static short[] getAuthRequestContext = null;
    private static int lookAheadTest = 1;
    private static int moveToNextValue;
    private final Context context;
    private Uri photoUri;

    public static /* synthetic */ ObservableSource $r8$lambda$48YHyKGDM5y39jIzq4oj1XC46aY(HandPicked handPicked, byte[] bArr) {
        int i = moveToNextValue + 91;
        lookAheadTest = i % 128;
        char c = i % 2 == 0 ? (char) 7 : 'Y';
        ObservableSource m2661compressAndRotateImage$lambda5 = m2661compressAndRotateImage$lambda5(handPicked, bArr);
        if (c == 7) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = lookAheadTest + 69;
        moveToNextValue = i2 % 128;
        int i3 = i2 % 2;
        return m2661compressAndRotateImage$lambda5;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$ErKc4M2Dm0WnkLCuZY2SRSgCy5Q(HandPicked handPicked, Uri uri, ImagePickerEntity imagePickerEntity, Float f) {
        try {
            int i = lookAheadTest + 71;
            try {
                moveToNextValue = i % 128;
                int i2 = i % 2;
                ObservableSource m2660compressAndRotateImage$lambda4 = m2660compressAndRotateImage$lambda4(handPicked, uri, imagePickerEntity, f);
                int i3 = moveToNextValue + 33;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return m2660compressAndRotateImage$lambda4;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$e-MAbClnurk4F1qZdCiFDUBr2pg */
    public static /* synthetic */ Float m2658$r8$lambda$eMAbClnurk4F1qZdCiFDUBr2pg(HandPicked handPicked, Uri uri) {
        Float m2659compressAndRotateImage$lambda3;
        int i = lookAheadTest + 69;
        moveToNextValue = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? (char) 6 : '\n') != '\n') {
            m2659compressAndRotateImage$lambda3 = m2659compressAndRotateImage$lambda3(handPicked, uri);
            obj.hashCode();
        } else {
            try {
                m2659compressAndRotateImage$lambda3 = m2659compressAndRotateImage$lambda3(handPicked, uri);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = lookAheadTest + 99;
        moveToNextValue = i2 % 128;
        if ((i2 % 2 != 0 ? '!' : '_') != '!') {
            return m2659compressAndRotateImage$lambda3;
        }
        obj.hashCode();
        return m2659compressAndRotateImage$lambda3;
    }

    static void getAuthRequestContext() {
        PlaceComponentResult = 1257195770;
        KClassImpl$Data$declaredNonStaticMembers$2 = -177035914;
        MyBillsEntityDataFactory = new byte[]{61, 81, 38, 41, -97};
        BuiltInFictitiousFunctionClassFactory = 628816672;
    }

    public HandPicked(Context context) {
        try {
            Intrinsics.checkNotNullParameter(context, "");
            this.context = context;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        String str;
        int i = lookAheadTest + 25;
        moveToNextValue = i % 128;
        if (!(i % 2 != 0)) {
            str = TAG;
        } else {
            str = TAG;
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = lookAheadTest + 59;
            moveToNextValue = i2 % 128;
            int i3 = i2 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Intent createCameraIntent() {
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Intent intent2 = null;
            try {
                try {
                    try {
                        this.photoUri = FileProvider.getUriForFile(this.context, getProviderAuthority(), createImageFile());
                        intent2 = intent.putExtra("return-date", true).putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, this.photoUri);
                        try {
                            int i = lookAheadTest + 21;
                            moveToNextValue = i % 128;
                            int i2 = i % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        DANALog.PlaceComponentResult(TAG, "createCameraIntent", e2);
                    }
                } catch (IOException e3) {
                    DANALog.PlaceComponentResult(TAG, "createCameraIntent", e3);
                    return null;
                }
            } catch (ActivityNotFoundException unused) {
            }
            int i3 = moveToNextValue + 41;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return intent2;
        } catch (Exception e4) {
            throw e4;
        }
    }

    private final File createImageFile() throws IOException {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("JPEG_");
        sb.append((Object) format);
        sb.append('_');
        File createTempFile = File.createTempFile(sb.toString(), ".jpg", FileUtil.getAuthRequestContext(this.context));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "");
        try {
            int i = lookAheadTest + 97;
            moveToNextValue = i % 128;
            if (i % 2 == 0) {
                return createTempFile;
            }
            int i2 = 65 / 0;
            return createTempFile;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getProviderAuthority")
    private final String getProviderAuthority() {
        String stringPlus;
        int i = moveToNextValue + 9;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            stringPlus = Intrinsics.stringPlus(this.context.getPackageName(), PROVIDER_SUFFIX);
        } else {
            stringPlus = Intrinsics.stringPlus(this.context.getPackageName(), PROVIDER_SUFFIX);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = lookAheadTest + 5;
        moveToNextValue = i2 % 128;
        int i3 = i2 % 2;
        return stringPlus;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x001d, code lost:
    
        if (((r6 ^ 11) != 0 ? '%' : 'O') != 'O') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0022, code lost:
    
        if ((r6 & 8) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0024, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void onActivityResult$default(id.dana.lib.gcontainer.util.handpicked.HandPicked r1, android.content.Intent r2, id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerEntity r3, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r4, java.lang.String r5, int r6, java.lang.Object r7) {
        /*
            int r7 = id.dana.lib.gcontainer.util.handpicked.HandPicked.lookAheadTest     // Catch: java.lang.Exception -> L33
            int r7 = r7 + 51
            int r0 = r7 % 128
            id.dana.lib.gcontainer.util.handpicked.HandPicked.moveToNextValue = r0     // Catch: java.lang.Exception -> L33
            int r7 = r7 % 2
            r0 = 1
            if (r7 == 0) goto Lf
            r7 = 0
            goto L10
        Lf:
            r7 = 1
        L10:
            if (r7 == r0) goto L20
            r6 = r6 ^ 11
            r7 = 79
            if (r6 == 0) goto L1b
            r6 = 37
            goto L1d
        L1b:
            r6 = 79
        L1d:
            if (r6 == r7) goto L25
            goto L24
        L20:
            r6 = r6 & 8
            if (r6 == 0) goto L25
        L24:
            r5 = 0
        L25:
            r1.onActivityResult(r2, r3, r4, r5)
            int r1 = id.dana.lib.gcontainer.util.handpicked.HandPicked.lookAheadTest
            int r1 = r1 + 107
            int r2 = r1 % 128
            id.dana.lib.gcontainer.util.handpicked.HandPicked.moveToNextValue = r2
            int r1 = r1 % 2
            return
        L33:
            r1 = move-exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.util.handpicked.HandPicked.onActivityResult$default(id.dana.lib.gcontainer.util.handpicked.HandPicked, android.content.Intent, id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerEntity, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, java.lang.String, int, java.lang.Object):void");
    }

    private final Observable<String> convertToBase64String(byte[] byteArray) {
        byte[] encode = Base64.encode(byteArray, 0);
        Intrinsics.checkNotNullExpressionValue(encode, "");
        Object[] objArr = new Object[1];
        a((-1872081855) - (ViewConfiguration.getScrollBarSize() >> 8), (-96) - View.getDefaultSize(0, 0), (short) ((-47) - ExpandableListView.getPackedPositionGroup(0L)), 1080169068 + Gravity.getAbsoluteGravity(0, 0), (byte) (121 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), objArr);
        Charset forName = Charset.forName(((String) objArr[0]).intern());
        Intrinsics.checkNotNullExpressionValue(forName, "");
        Observable<String> just = Observable.just(new String(encode, forName));
        Intrinsics.checkNotNullExpressionValue(just, "");
        int i = lookAheadTest + 3;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return just;
    }

    private final Observable<String> compressAndRotateImage(final Uri imageUri, final ImagePickerEntity imageSpec) {
        try {
            try {
                Observable<String> subscribeOn = Observable.fromCallable(new Callable() { // from class: id.dana.lib.gcontainer.util.handpicked.HandPicked$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return HandPicked.m2658$r8$lambda$eMAbClnurk4F1qZdCiFDUBr2pg(HandPicked.this, imageUri);
                    }
                }).flatMap(new Function() { // from class: id.dana.lib.gcontainer.util.handpicked.HandPicked$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return HandPicked.$r8$lambda$ErKc4M2Dm0WnkLCuZY2SRSgCy5Q(HandPicked.this, imageUri, imageSpec, (Float) obj);
                    }
                }).flatMap(new Function() { // from class: id.dana.lib.gcontainer.util.handpicked.HandPicked$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return HandPicked.$r8$lambda$48YHyKGDM5y39jIzq4oj1XC46aY(HandPicked.this, (byte[]) obj);
                    }
                }).observeOn(Schedulers.getAuthRequestContext()).subscribeOn(Schedulers.MyBillsEntityDataFactory());
                Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
                int i = lookAheadTest + 115;
                moveToNextValue = i % 128;
                int i2 = i % 2;
                return subscribeOn;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: compressAndRotateImage$lambda-3 */
    private static final Float m2659compressAndRotateImage$lambda3(HandPicked handPicked, Uri uri) {
        int i = moveToNextValue + 113;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(handPicked, "");
        Intrinsics.checkNotNullParameter(uri, "");
        Float rotateImage = handPicked.rotateImage(uri);
        int i3 = lookAheadTest + 29;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        return rotateImage;
    }

    /* renamed from: compressAndRotateImage$lambda-4 */
    private static final ObservableSource m2660compressAndRotateImage$lambda4(HandPicked handPicked, Uri uri, ImagePickerEntity imagePickerEntity, Float f) {
        int i = lookAheadTest + 97;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(handPicked, "");
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(imagePickerEntity, "");
        Intrinsics.checkNotNullParameter(f, "");
        Observable<byte[]> compressImage = handPicked.compressImage(f.floatValue(), uri, imagePickerEntity);
        int i3 = moveToNextValue + 23;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return compressImage;
    }

    /* renamed from: compressAndRotateImage$lambda-5 */
    private static final ObservableSource m2661compressAndRotateImage$lambda5(HandPicked handPicked, byte[] bArr) {
        Observable<String> convertToBase64String;
        int i = moveToNextValue + 37;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(handPicked, "");
            Intrinsics.checkNotNullParameter(bArr, "");
            convertToBase64String = handPicked.convertToBase64String(bArr);
        } else {
            Intrinsics.checkNotNullParameter(handPicked, "");
            Intrinsics.checkNotNullParameter(bArr, "");
            convertToBase64String = handPicked.convertToBase64String(bArr);
            int i2 = 68 / 0;
        }
        int i3 = moveToNextValue + 49;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return convertToBase64String;
    }

    private final Float rotateImage(Uri imageUri) throws IOException {
        ExifInterface exifInterface;
        Float valueOf;
        try {
            InputStream BuiltInFictitiousFunctionClassFactory2 = UriUtils.BuiltInFictitiousFunctionClassFactory(imageUri, this.context);
            if ((BuiltInFictitiousFunctionClassFactory2 == null ? 'M' : Typography.quote) != '\"') {
                return null;
            }
            InputStream inputStream = BuiltInFictitiousFunctionClassFactory2;
            try {
                InputStream inputStream2 = inputStream;
                if (Build.VERSION.SDK_INT >= 24) {
                    exifInterface = new ExifInterface(inputStream2);
                } else {
                    String path = imageUri.getPath();
                    if (path == null) {
                        int i = lookAheadTest + 103;
                        moveToNextValue = i % 128;
                        int i2 = i % 2;
                        CloseableKt.closeFinally(inputStream, null);
                        Float valueOf2 = Float.valueOf(0.0f);
                        int i3 = moveToNextValue + 7;
                        lookAheadTest = i3 % 128;
                        if (i3 % 2 == 0) {
                            int i4 = 23 / 0;
                            return valueOf2;
                        }
                        return valueOf2;
                    }
                    exifInterface = new ExifInterface(path);
                }
                int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
                if (attributeInt == 3) {
                    valueOf = Float.valueOf(180.0f);
                } else if (attributeInt != 6) {
                    int i5 = lookAheadTest + 85;
                    moveToNextValue = i5 % 128;
                    int i6 = i5 % 2;
                    if ((attributeInt != 8 ? (char) 15 : 'J') != 15) {
                        valueOf = Float.valueOf(270.0f);
                    } else {
                        int i7 = lookAheadTest + 123;
                        moveToNextValue = i7 % 128;
                        int i8 = i7 % 2;
                        valueOf = Float.valueOf(0.0f);
                    }
                } else {
                    valueOf = Float.valueOf(90.0f);
                }
                CloseableKt.closeFinally(inputStream, null);
                return valueOf;
            } finally {
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final Observable<byte[]> compressImage(float angle, Uri imageUri, ImagePickerEntity imageSpec) throws IOException {
        int width;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(UriUtils.BuiltInFictitiousFunctionClassFactory(imageUri, this.context));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Matrix matrix = new Matrix();
                matrix.postRotate(angle);
                if ((imageSpec.getWidth() > 0 ? '3' : 'H') != 'H') {
                    try {
                        int i = lookAheadTest + 43;
                        moveToNextValue = i % 128;
                        if (i % 2 != 0) {
                            width = imageSpec.getWidth();
                            Object[] objArr = null;
                            int length = objArr.length;
                        } else {
                            width = imageSpec.getWidth();
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    width = decodeStream.getWidth();
                }
                decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, width, (imageSpec.getHeight() > 0 ? ']' : (char) 7) != 7 ? imageSpec.getHeight() : decodeStream.getHeight(), matrix, true);
                decodeStream.compress(Bitmap.CompressFormat.JPEG, imageSpec.getQualityLevel(), byteArrayOutputStream);
                try {
                    Observable<byte[]> just = Observable.just(byteArrayOutputStream.toByteArray());
                    decodeStream.recycle();
                    byteArrayOutputStream.close();
                    Intrinsics.checkNotNullExpressionValue(just, "");
                    if (decodeStream != null) {
                        int i2 = moveToNextValue + 91;
                        lookAheadTest = i2 % 128;
                        int i3 = i2 % 2;
                        decodeStream.recycle();
                    }
                    return just;
                } catch (Throwable th) {
                    decodeStream.recycle();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                if (decodeStream != null) {
                    decodeStream.recycle();
                }
                throw th2;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static {
        try {
            getAuthRequestContext();
            INSTANCE = new Companion(null);
            TAG = "HandPicked";
            int i = lookAheadTest + 45;
            moveToNextValue = i % 128;
            if ((i % 2 != 0 ? '^' : (char) 28) != '^') {
                return;
            }
            int i2 = 91 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void onActivityResult(Intent data, ImagePickerEntity imageSpec, final BridgeCallback bridgeCallback, String r7) {
        Uri data2;
        int i = moveToNextValue + 53;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(imageSpec, "");
            Intrinsics.checkNotNullParameter(bridgeCallback, "");
            Object obj = null;
            if (Intrinsics.areEqual(r7, "cameraWithFrame")) {
                int i3 = moveToNextValue + 43;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                data2 = data == null ? null : (Uri) data.getParcelableExtra("image_capture_uri_extra");
            } else {
                data2 = (data != null ? (char) 30 : 'Q') != 'Q' ? data.getData() : null;
                if (data2 == null) {
                    int i5 = lookAheadTest + 63;
                    moveToNextValue = i5 % 128;
                    int i6 = i5 % 2;
                    data2 = this.photoUri;
                }
            }
            if (data2 != null) {
                compressAndRotateImage(data2, imageSpec).subscribe(new DisposableObserver<String>() { // from class: id.dana.lib.gcontainer.util.handpicked.HandPicked$onActivityResult$$inlined$subscribeWithAutoDispose$1
                    @Override // io.reactivex.Observer
                    public final void onComplete() {
                        dispose();
                    }

                    @Override // io.reactivex.Observer
                    public final void onNext(String t) {
                        BridgeCallback bridgeCallback2 = BridgeCallback.this;
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = jSONObject;
                        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
                        jSONObject2.put((JSONObject) "data", t);
                        Unit unit = Unit.INSTANCE;
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }

                    @Override // io.reactivex.Observer
                    public final void onError(Throwable e) {
                        Intrinsics.checkNotNullParameter(e, "");
                        String str = e instanceof FileNotFoundException ? "007" : "001";
                        DANALog.BuiltInFictitiousFunctionClassFactory(HandPicked.access$getTAG$cp(), e);
                        bridgeCallback.sendJSONResponse(ImagePickerBridge.INSTANCE.getErrorResult(str));
                        dispose();
                    }
                });
                return;
            }
            int i7 = lookAheadTest + 101;
            moveToNextValue = i7 % 128;
            if ((i7 % 2 != 0 ? '7' : 'L') != '7') {
                return;
            }
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x003b, code lost:
    
        if ((r2 != null ? 14 : kotlin.text.Typography.greater) != '>') goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0048, code lost:
    
        if ((r2 == null) != true) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x004a, code lost:
    
        r8 = r2.length;
        r9 = new byte[r8];
        r10 = id.dana.lib.gcontainer.util.handpicked.HandPicked.$10 + 17;
        id.dana.lib.gcontainer.util.handpicked.HandPicked.$11 = r10 % 128;
        r10 = r10 % 2;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0058, code lost:
    
        if (r10 >= r8) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x005a, code lost:
    
        r9[r10] = (byte) (r2[r10] ^ 3097486228508854431L);
        r10 = r10 + 1;
        r11 = id.dana.lib.gcontainer.util.handpicked.HandPicked.$11 + 101;
        id.dana.lib.gcontainer.util.handpicked.HandPicked.$10 = r11 % 128;
        r11 = r11 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x006f, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0072, code lost:
    
        if (r2 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0074, code lost:
    
        r2 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0077, code lost:
    
        r2 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0079, code lost:
    
        if (r2 == '@') goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x007b, code lost:
    
        r2 = (short) (((short) (id.dana.lib.gcontainer.util.handpicked.HandPicked.getAuthRequestContext[r13 + ((int) (id.dana.lib.gcontainer.util.handpicked.HandPicked.BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (id.dana.lib.gcontainer.util.handpicked.HandPicked.PlaceComponentResult ^ 3097486228508854431L)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0092, code lost:
    
        r2 = (byte) (((byte) (id.dana.lib.gcontainer.util.handpicked.HandPicked.MyBillsEntityDataFactory[r13 + ((int) (id.dana.lib.gcontainer.util.handpicked.HandPicked.BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (id.dana.lib.gcontainer.util.handpicked.HandPicked.PlaceComponentResult ^ 3097486228508854431L)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.util.handpicked.HandPicked.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
