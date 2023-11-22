package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnLifecycleEvent;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.nearbyme.extension.NearbyViewExtKt;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B%\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bR\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantPromoView;", "Lid/dana/base/BaseRichView;", "Landroidx/lifecycle/LifecycleObserver;", "", "getLayout", "()I", "", "onCreate", "()V", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantPromoView$PromoViewInteraction;", "sentListener", "setListener", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantPromoView$PromoViewInteraction;)V", "", "promoText", "", "Lid/dana/nearbyme/model/PromoInfoModel;", "data", "setPromo", "(Ljava/lang/String;Ljava/util/List;)V", "setup", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantPromoView$PromoViewInteraction;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PromoViewInteraction"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantPromoView extends BaseRichView implements LifecycleObserver {
    private final Lazy MyBillsEntityDataFactory;
    private PromoViewInteraction PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    public static final byte[] $$a = {61, 16, -46, 32, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 107;
    public static final byte[] getAuthRequestContext = {83, -75, 7, 97, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 206;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantPromoView$PromoViewInteraction;", "", "", "Lid/dana/nearbyme/model/PromoInfoModel;", "promoInfos", "", "onSeeAllPromoClick", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface PromoViewInteraction {
        void onSeeAllPromoClick(List<? extends PromoInfoModel> promoInfos);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantPromoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantPromoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView.getAuthRequestContext
            int r9 = r9 * 3
            int r9 = r9 + 16
            int r7 = r7 * 15
            int r7 = 18 - r7
            int r8 = 106 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L17:
            r3 = 0
        L18:
            r6 = r9
            r9 = r8
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r8) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L35:
            int r10 = r10 + r8
            int r8 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView.a(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 4
            int r7 = 75 - r7
            int r9 = r9 * 4
            int r9 = 42 - r9
            byte[] r0 = id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView.$$a
            int r8 = r8 * 4
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L34
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L34:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r9 + 1
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView.b(byte, byte, short, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_merchant_promo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPromoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_promo);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        this.MyBillsEntityDataFactory = NearbyViewExtKt.MyBillsEntityDataFactory(constraintLayout);
    }

    public /* synthetic */ MerchantPromoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        ((LifecycleOwner) context).getLifecycle().BuiltInFictitiousFunctionClassFactory(this);
    }

    public final void setListener(PromoViewInteraction sentListener) {
        Intrinsics.checkNotNullParameter(sentListener, "");
        this.PlaceComponentResult = sentListener;
    }

    public static /* synthetic */ void $r8$lambda$iZgirSAJFtpF2_fIeCkx22UoDi4(List list, MerchantPromoView merchantPromoView, View view) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(merchantPromoView, "");
        if ((!list.isEmpty()) == true) {
            PromoViewInteraction promoViewInteraction = merchantPromoView.PlaceComponentResult;
            if (promoViewInteraction == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoViewInteraction = null;
            }
            promoViewInteraction.onSeeAllPromoClick(list);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        try {
            byte b = (byte) (getAuthRequestContext[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-getAuthRequestContext[5]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 494, 5 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 35 - View.resolveSize(0, 0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {528158937, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), Color.alpha(0) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                ((SkeletonScreen) this.MyBillsEntityDataFactory.getValue()).MyBillsEntityDataFactory();
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

    public final void setPromo(String promoText, final List<? extends PromoInfoModel> data) {
        Intrinsics.checkNotNullParameter(promoText, "");
        Intrinsics.checkNotNullParameter(data, "");
        ((SkeletonScreen) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult();
        String str = promoText;
        if (str.length() > 0) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1860_getlistsuggestedlocations_params);
            if (appCompatTextView != null) {
                appCompatTextView.setText(str);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_promo);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        } else {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_promo);
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.getEnvironmentInfoFromCollector);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantPromoView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantPromoView.$r8$lambda$iZgirSAJFtpF2_fIeCkx22UoDi4(data, this, view);
                }
            });
        }
    }
}
