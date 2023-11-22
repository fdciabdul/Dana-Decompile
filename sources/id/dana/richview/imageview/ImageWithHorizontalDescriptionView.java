package id.dana.richview.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.extension.ContextExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010>\u001a\u00020\u0002¢\u0006\u0004\b?\u0010@B+\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010>\u001a\u00020\u0002\u0012\u0006\u0010A\u001a\u00020\u0002¢\u0006\u0004\b?\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u000bJ#\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001cJ'\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u0013¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0013¢\u0006\u0004\b&\u0010\u0016J\u0015\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b)\u0010'J\u0015\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0004\b+\u0010\u0016J\u0015\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010\u0016J\u0015\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\b/\u0010\u0016J\u000f\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010\u001cJ\u0015\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020$¢\u0006\u0004\b2\u0010'J\u0015\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0013¢\u0006\u0004\b2\u0010\u0016J\u001d\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0002¢\u0006\u0004\b2\u00105R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00106R\u0016\u0010\f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00106R\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00106R\u0018\u00109\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u001b\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00106R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00106R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00106"}, d2 = {"Lid/dana/richview/imageview/ImageWithHorizontalDescriptionView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "isEnable", "", "getStatusMaintenanceService", "(Z)V", "MyBillsEntityDataFactory", "()Z", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "secondLineDescription", "setBottomLineFirstText", "(Ljava/lang/String;)V", "redNote", "setBottomRedNoteText", "distance", "setDistanceText", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "setFirstLineBadgeGone", "logoDescriptor", "titleDescriptor", "serviceCategoryDescriptor", "setItemContentDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "badgeDrawable", "setTitleBadge", "(Landroid/graphics/drawable/Drawable;)V", "badgeUrl", "setTitleBadgeWithVector", "title", "setTitleText", "upperDesc", "setUpperLineFirstText", "upperNote", "setUpperLineRedNoteText", "setup", "src", "showImage", "url", "placeholderDrawable", "(Ljava/lang/String;I)V", "Ljava/lang/String;", "getErrorConfigVersion", "Landroid/graphics/drawable/Drawable;", "PlaceComponentResult", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "lookAheadTest", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageWithHorizontalDescriptionView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;
    private String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String moveToNextValue;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Drawable PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] PlaceComponentResult = {2, -87, 98, TarHeader.LF_FIFO, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 167;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWithHorizontalDescriptionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWithHorizontalDescriptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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
        return R.layout.view_image_with_horizontal_description;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithHorizontalDescriptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.moveToNextValue = "";
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getAuthRequestContext = "";
        this.scheduleImpl = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
    }

    public /* synthetic */ ImageWithHorizontalDescriptionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithHorizontalDescriptionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.moveToNextValue = "";
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getAuthRequestContext = "";
        this.scheduleImpl = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if ((r5.getAuthRequestContext.length() == 0) != false) goto L26;
     */
    @Override // id.dana.base.BaseRichView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setup() {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.imageview.ImageWithHorizontalDescriptionView.setup():void");
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.getReadyFragment);
            String str = "";
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                this.PlaceComponentResult = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 3);
                String string = obtainStyledAttributes.getString(6);
                if (string == null) {
                    string = "";
                }
                this.moveToNextValue = string;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 4);
                String string2 = obtainStyledAttributes.getString(1);
                if (string2 == null) {
                    string2 = "";
                }
                this.BuiltInFictitiousFunctionClassFactory = string2;
                String string3 = obtainStyledAttributes.getString(0);
                if (string3 == null) {
                    string3 = "";
                }
                this.MyBillsEntityDataFactory = string3;
                String string4 = obtainStyledAttributes.getString(2);
                if (string4 == null) {
                    string4 = "";
                }
                this.getAuthRequestContext = string4;
                String string5 = obtainStyledAttributes.getString(7);
                if (string5 == null) {
                    string5 = "";
                }
                this.scheduleImpl = string5;
                String string6 = obtainStyledAttributes.getString(8);
                if (string6 != null) {
                    str = string6;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void showImage(Drawable src) {
        Intrinsics.checkNotNullParameter(src, "");
        ImageWithRibbonView imageWithRibbonView = (ImageWithRibbonView) _$_findCachedViewById(R.id.isSuccessfulOrRequiresNewFidCreation);
        if (imageWithRibbonView != null) {
            imageWithRibbonView.showImage(src);
        }
    }

    public final void showImage(String url) {
        Intrinsics.checkNotNullParameter(url, "");
        ImageWithRibbonView imageWithRibbonView = (ImageWithRibbonView) _$_findCachedViewById(R.id.isSuccessfulOrRequiresNewFidCreation);
        if (imageWithRibbonView != null) {
            ImageWithRibbonView.showImage$default(imageWithRibbonView, url, 0, 2, null);
        }
    }

    public final void showImage(String url, int placeholderDrawable) {
        Intrinsics.checkNotNullParameter(url, "");
        ImageWithRibbonView imageWithRibbonView = (ImageWithRibbonView) _$_findCachedViewById(R.id.isSuccessfulOrRequiresNewFidCreation);
        if (imageWithRibbonView != null) {
            imageWithRibbonView.showImage(url, placeholderDrawable);
        }
    }

    public final void setTitleBadge(Drawable badgeDrawable) {
        Intrinsics.checkNotNullParameter(badgeDrawable, "");
        GlideRequest<Bitmap> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        GlideRequest<Bitmap> BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.getErrorConfigVersion(ContextExtKt.PlaceComponentResult(context, (int) R.drawable.ic_verified_blue)).BuiltInFictitiousFunctionClassFactory(badgeDrawable);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(ContextExtKt.PlaceComponentResult(context2, (int) R.drawable.ic_verified_blue)).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge)));
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setContentDescription(getContext().getString(R.string.iconVerify));
        }
    }

    public final void setTitleBadgeWithVector(Drawable badgeDrawable) {
        Intrinsics.checkNotNullParameter(badgeDrawable, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(badgeDrawable);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) appCompatImageView.findViewById(R.id.ivTitleBadge);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(0);
            }
            appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.iconDanaBisnis));
        }
    }

    public final void setTitleBadge(String badgeUrl) {
        Intrinsics.checkNotNullParameter(badgeUrl, "");
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(badgeUrl).getErrorConfigVersion(17170443).PlaceComponentResult(17170443).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge)));
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
        }
    }

    public final void setTitleText(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15be_cameraengine_10);
        if (textView != null) {
            textView.setText(title);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15be_cameraengine_10);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    public final void setFirstLineBadgeGone() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivTitleBadge);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
    }

    public final void setBottomLineFirstText(String secondLineDescription) {
        Intrinsics.checkNotNullParameter(secondLineDescription, "");
        this.BuiltInFictitiousFunctionClassFactory = secondLineDescription;
        String str = secondLineDescription;
        if (str.length() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a147c_daggerhomerecyclecomponent_builder);
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a147c_daggerhomerecyclecomponent_builder);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        getAuthRequestContext();
    }

    public final void setDistanceText(String distance) {
        this.MyBillsEntityDataFactory = distance;
        if (distance != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.createProfileProvider);
            if (textView != null) {
                textView.setText(distance);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a095f_daggerpromocentercomponent_promocentercomponentimpl_providepaylaterrepositoryprovider);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(0);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.createProfileProvider);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if ((this.BuiltInFictitiousFunctionClassFactory.length() == 0) && this.MyBillsEntityDataFactory != null) {
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a147c_daggerhomerecyclecomponent_builder);
                if (textView3 != null) {
                    textView3.setText("");
                }
                TextView textView4 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a147c_daggerhomerecyclecomponent_builder);
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
            }
            getAuthRequestContext();
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if ((r0 == null || r0.length() == 0) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext() {
        /*
            r4 = this;
            java.lang.String r0 = r4.BuiltInFictitiousFunctionClassFactory
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L23
            java.lang.String r0 = r4.MyBillsEntityDataFactory
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L1f
            int r0 = r0.length()
            if (r0 == 0) goto L1f
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 != 0) goto L23
            goto L24
        L23:
            r1 = 0
        L24:
            if (r1 == 0) goto L50
            int r0 = id.dana.R.id.tvDotBeforeDistance
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L40
            android.content.Context r1 = r4.getContext()
            r3 = 2131953253(0x7f130665, float:1.9542972E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L40:
            int r0 = id.dana.R.id.tvDotBeforeDistance
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L4f
            r0.setVisibility(r2)
        L4f:
            return
        L50:
            int r0 = id.dana.R.id.tvDotBeforeDistance
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L61
            android.view.View r0 = (android.view.View) r0
            r1 = 8
            r0.setVisibility(r1)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.imageview.ImageWithHorizontalDescriptionView.getAuthRequestContext():void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1441_r8_lambda_exkoo6yfb1gmq9yx74dfkfbog9u);
        if (textView != null) {
            if (!MyBillsEntityDataFactory()) {
                if (!(this.getAuthRequestContext.length() == 0)) {
                    str = getContext().getString(R.string.dot);
                    textView.setText(str);
                }
            }
            textView.setText(str);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1441_r8_lambda_exkoo6yfb1gmq9yx74dfkfbog9u);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    private final boolean MyBillsEntityDataFactory() {
        return (this.BuiltInFictitiousFunctionClassFactory.length() == 0) && this.MyBillsEntityDataFactory == null;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.scheduleImpl.length() == 0) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.length() == 0;
        }
        return false;
    }

    public final void setBottomRedNoteText(String redNote) {
        Intrinsics.checkNotNullParameter(redNote, "");
        this.getAuthRequestContext = redNote;
        if (redNote.length() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvBottomLineRedNote);
            if (textView != null) {
                textView.setText(this.getAuthRequestContext);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvBottomLineRedNote);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final void setUpperLineFirstText(String upperDesc) {
        Intrinsics.checkNotNullParameter(upperDesc, "");
        this.scheduleImpl = upperDesc;
        if (upperDesc.length() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.injectPaymentWalletDetailPresenter);
            if (textView != null) {
                textView.setText(this.scheduleImpl);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.injectPaymentWalletDetailPresenter);
            if (textView2 != null) {
                textView2.setVisibility(0);
                return;
            }
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.injectPaymentWalletDetailPresenter)).setVisibility(8);
    }

    public final void setUpperLineRedNoteText(String upperNote) {
        Intrinsics.checkNotNullParameter(upperNote, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = upperNote;
        if (upperNote.length() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.setMonetaryDecimalSeparator);
            if (textView != null) {
                textView.setText(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.setMonetaryDecimalSeparator);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.CreateActivityRequestMapperKt);
            if (textView3 != null) {
                textView3.setText(BuiltInFictitiousFunctionClassFactory() ? "" : getContext().getString(R.string.dot));
            }
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.CreateActivityRequestMapperKt);
            if (textView4 != null) {
                textView4.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.setMonetaryDecimalSeparator);
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
    }

    public final void getStatusMaintenanceService(boolean isEnable) {
        if (!isEnable) {
            ImageWithRibbonView imageWithRibbonView = (ImageWithRibbonView) _$_findCachedViewById(R.id.isSuccessfulOrRequiresNewFidCreation);
            if (imageWithRibbonView != null) {
                imageWithRibbonView.setImageGreyscale();
            }
            TextView textView = (TextView) _$_findCachedViewById(R.id.setMonetaryDecimalSeparator);
            if (textView != null) {
                textView.setText(getResources().getString(R.string.global_search_service_under_maintenance));
                return;
            }
            return;
        }
        ImageWithRibbonView imageWithRibbonView2 = (ImageWithRibbonView) _$_findCachedViewById(R.id.isSuccessfulOrRequiresNewFidCreation);
        if (imageWithRibbonView2 != null) {
            imageWithRibbonView2.removeImageGreyscale();
        }
    }

    public static /* synthetic */ void setItemContentDescription$default(ImageWithHorizontalDescriptionView imageWithHorizontalDescriptionView, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        imageWithHorizontalDescriptionView.setItemContentDescription(str, str2, str3);
    }

    public final void setItemContentDescription(String logoDescriptor, String titleDescriptor, String serviceCategoryDescriptor) {
        Intrinsics.checkNotNullParameter(logoDescriptor, "");
        Intrinsics.checkNotNullParameter(titleDescriptor, "");
        Intrinsics.checkNotNullParameter(serviceCategoryDescriptor, "");
        ImageWithRibbonView imageWithRibbonView = (ImageWithRibbonView) _$_findCachedViewById(R.id.isSuccessfulOrRequiresNewFidCreation);
        if (imageWithRibbonView != null) {
            imageWithRibbonView.setContentDescription(logoDescriptor);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15be_cameraengine_10);
        if (textView != null) {
            textView.setContentDescription(titleDescriptor);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.injectPaymentWalletDetailPresenter);
        if (textView2 != null) {
            textView2.setContentDescription(serviceCategoryDescriptor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.richview.imageview.ImageWithHorizontalDescriptionView.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 97
            r5 = 4
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 4
            r7 = 23
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L44
        L15:
            r4 = r2
            r5 = 97
            r6 = 4
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            byte r8 = (byte) r5
            int r9 = r7 + 1
            r4[r7] = r8
            if (r9 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            r7 = r2[r6]
            r10 = r5
            r5 = r4
            r4 = r10
        L44:
            int r6 = r6 + 1
            int r4 = r4 + r7
            int r4 = r4 + (-8)
            r7 = r9
            r10 = r5
            r5 = r4
            r4 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.imageview.ImageWithHorizontalDescriptionView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
