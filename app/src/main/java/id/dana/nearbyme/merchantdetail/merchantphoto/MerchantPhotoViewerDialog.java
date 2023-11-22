package id.dana.nearbyme.merchantdetail.merchantphoto;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.di.component.ApplicationComponent;
import id.dana.nearbyme.di.component.DaggerMerchantPhotoViewerComponent;
import id.dana.nearbyme.di.module.MerchantPhotoViewerModule;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.util.AndroidComponentUtilsKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003X\u0087\"¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerDialog;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerDialog;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "", "p0", "Landroid/widget/ImageView;", "p1", "", "p2", "", "PlaceComponentResult", "(Ljava/lang/String;Landroid/widget/ImageView;I)V", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "merchantPhotoViewerPresenter", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerModel;", "scheduleImpl", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotoViewerDialog extends MediaViewerDialog<MerchantImageModel> {
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    @Inject
    public MediaViewerContract.Presenter<MerchantImageModel> merchantPhotoViewerPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MerchantPhotoViewerModel KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$a = {11, Ascii.GS, 107, 8, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR;
    public static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_DIR, 93, -14, -126, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int lookAheadTest = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r0 = id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog.MyBillsEntityDataFactory
            int r8 = r8 * 3
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r7
            int r7 = r8 + 2
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog.a(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = r6 + 75
            int r8 = r8 * 2
            int r8 = 3 - r8
            int r7 = r7 * 2
            int r7 = 42 - r7
            byte[] r0 = id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog.b(short, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog
    public final View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog
    public final /* synthetic */ void getAuthRequestContext(MerchantImageModel merchantImageModel, View view) {
        Resources resources;
        MerchantImageModel merchantImageModel2 = merchantImageModel;
        Intrinsics.checkNotNullParameter(merchantImageModel2, "");
        Intrinsics.checkNotNullParameter(view, "");
        String str = merchantImageModel2.BuiltInFictitiousFunctionClassFactory;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.iv_media_preview);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        PlaceComponentResult(str, appCompatImageView, R.drawable.image_broken_large);
        String str2 = merchantImageModel2.KClassImpl$Data$declaredNonStaticMembers$2;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.DebugCoroutineInfoImpl_res_0x7f0a031b);
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        PlaceComponentResult(str2, circleImageView, R.drawable.avatar_placeholder);
        TextView textView = (TextView) view.findViewById(R.id.tv_media_info_title);
        MerchantPhotoViewerModel merchantPhotoViewerModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = null;
        if (merchantPhotoViewerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPhotoViewerModel = null;
        }
        textView.setText(merchantPhotoViewerModel.getAuthRequestContext);
        if (merchantImageModel2.PlaceComponentResult.length() == 0) {
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                str3 = resources.getString(R.string.user_review_anonymous_label);
            }
        } else {
            str3 = merchantImageModel2.PlaceComponentResult;
        }
        ((TextView) view.findViewById(R.id.tv_media_info_subtitle)).setText(getString(R.string.merchant_photo_author, str3));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        MerchantPhotoViewerModel merchantPhotoViewerModel;
        try {
            byte b = 0;
            byte b2 = (byte) (lookAheadTest - 1);
            byte b3 = (byte) lookAheadTest;
            Object[] objArr = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = (byte) lookAheadTest;
            byte b5 = (byte) (b4 - 1);
            Object[] objArr2 = new Object[1];
            a(b4, b5, b5, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - ImageFormat.getBitsPerPixel(0), 4 - TextUtils.getOffsetBefore("", 0), (char) KeyEvent.keyCodeFromString(""));
                    byte b6 = (byte) ($$a[4] - 1);
                    byte b7 = b6;
                    Object[] objArr4 = new Object[1];
                    b(b6, b7, b7, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), TextUtils.getOffsetAfter("", 0) + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {140793693, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(p0);
                DaggerMerchantPhotoViewerComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMerchantPhotoViewerComponent.BuiltInFictitiousFunctionClassFactory();
                DanaApplication BuiltInFictitiousFunctionClassFactory2 = AndroidComponentUtilsKt.BuiltInFictitiousFunctionClassFactory(this);
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2 != null ? BuiltInFictitiousFunctionClassFactory2.getApplicationComponent() : null);
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (MerchantPhotoViewerModule) Preconditions.getAuthRequestContext(new MerchantPhotoViewerModule(this));
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, MerchantPhotoViewerModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
                new DaggerMerchantPhotoViewerComponent.MerchantPhotoViewerComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, b).BuiltInFictitiousFunctionClassFactory(this);
                Bundle arguments = getArguments();
                if (arguments == null || (merchantPhotoViewerModel = (MerchantPhotoViewerModel) arguments.getParcelable("MERCHANT_VIEWER_MODEL_EXTRA")) == null) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantPhotoViewerModel;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        ((TextView) MyBillsEntityDataFactory(R.id.res_0x7f0a17b4_analyticsmessages_mixpaneldescription)).setText(getString(R.string.title_merchant_viewer_dialog));
    }

    private final void PlaceComponentResult(String p0, ImageView p1, int p2) {
        Context context = getContext();
        if (context != null) {
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(p0).PlaceComponentResult(p2).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory(p1);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "p0", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerModel;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/fragment/app/FragmentManager;Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerModel;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(FragmentManager p0, MerchantPhotoViewerModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            FragmentTransaction beginTransaction = p0.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
            Fragment findFragmentByTag = p0.findFragmentByTag("MerchantPhotoViewer");
            if (findFragmentByTag != null) {
                beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(findFragmentByTag);
            }
            if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
            }
            beginTransaction.scheduleImpl = true;
            beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
            MerchantPhotoViewerDialog merchantPhotoViewerDialog = new MerchantPhotoViewerDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MERCHANT_VIEWER_MODEL_EXTRA", p1);
            bundle.putParcelable("MEDIA_VIEWER_MODEL_EXTRA", p1.BuiltInFictitiousFunctionClassFactory);
            merchantPhotoViewerDialog.setArguments(bundle);
            merchantPhotoViewerDialog.setStyle(2, 0);
            merchantPhotoViewerDialog.show(beginTransaction, "MerchantPhotoViewer");
        }
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog
    public final MediaViewerContract.Presenter<MerchantImageModel> MyBillsEntityDataFactory() {
        MediaViewerContract.Presenter<MerchantImageModel> presenter = this.merchantPhotoViewerPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
