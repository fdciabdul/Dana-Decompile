package id.dana.social.v2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.feeds.ui.model.DealsVoucherColor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'B+\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002¢\u0006\u0004\b&\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001c\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010 \u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017"}, d2 = {"Lid/dana/social/v2/view/DealsVoucherView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "setup", "()V", "Lid/dana/feeds/ui/model/DealsVoucherColor;", "value", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/ui/model/DealsVoucherColor;", "getBackgroundColor", "()Lid/dana/feeds/ui/model/DealsVoucherColor;", "setBackgroundColor", "(Lid/dana/feeds/ui/model/DealsVoucherColor;)V", "backgroundColor", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", GriverParams.ShareParams.IMAGE_URL, "PlaceComponentResult", "getSubTitle", "setSubTitle", RVParams.LONG_SUB_TITLE, "getAuthRequestContext", "getTitle", GriverEvents.EVENT_SET_TITLE, "title", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DealsVoucherView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String com.alibaba.griver.core.GriverParams.ShareParams.IMAGE_URL java.lang.String;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private DealsVoucherColor backgroundColor;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String com.alibaba.ariver.kernel.RVParams.LONG_SUB_TITLE java.lang.String;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[DealsVoucherColor.values().length];
            iArr[DealsVoucherColor.WHITE.ordinal()] = 1;
            iArr[DealsVoucherColor.BLUE.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DealsVoucherView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DealsVoucherView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_deals_voucher;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DealsVoucherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.title = "";
        this.com.alibaba.ariver.kernel.RVParams.LONG_SUB_TITLE java.lang.String = "";
        this.com.alibaba.griver.core.GriverParams.ShareParams.IMAGE_URL java.lang.String = "";
        this.backgroundColor = DealsVoucherColor.WHITE;
    }

    public /* synthetic */ DealsVoucherView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DealsVoucherView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.title = "";
        this.com.alibaba.ariver.kernel.RVParams.LONG_SUB_TITLE java.lang.String = "";
        this.com.alibaba.griver.core.GriverParams.ShareParams.IMAGE_URL java.lang.String = "";
        this.backgroundColor = DealsVoucherColor.WHITE;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ((TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar)).setText(str);
        this.title = str;
    }

    @JvmName(name = "getSubTitle")
    /* renamed from: getSubTitle  reason: from getter */
    public final String getCom.alibaba.ariver.kernel.RVParams.LONG_SUB_TITLE java.lang.String() {
        return this.com.alibaba.ariver.kernel.RVParams.LONG_SUB_TITLE java.lang.String;
    }

    @JvmName(name = "setSubTitle")
    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ((TextView) _$_findCachedViewById(R.id.paramsForAnalyticsIntent)).setText(str);
        this.com.alibaba.ariver.kernel.RVParams.LONG_SUB_TITLE java.lang.String = str;
    }

    @JvmName(name = "getImageUrl")
    /* renamed from: getImageUrl  reason: from getter */
    public final String getCom.alibaba.griver.core.GriverParams.ShareParams.IMAGE_URL java.lang.String() {
        return this.com.alibaba.griver.core.GriverParams.ShareParams.IMAGE_URL java.lang.String;
    }

    @JvmName(name = "setImageUrl")
    public final void setImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(str).MyBillsEntityDataFactory((Transformation<Bitmap>) new CircleCrop()).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_voucher_logo));
        this.com.alibaba.griver.core.GriverParams.ShareParams.IMAGE_URL java.lang.String = str;
    }

    @JvmName(name = "getBackgroundColor")
    public final DealsVoucherColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @JvmName(name = "setBackgroundColor")
    public final void setBackgroundColor(DealsVoucherColor dealsVoucherColor) {
        int i;
        Intrinsics.checkNotNullParameter(dealsVoucherColor, "");
        int i2 = WhenMappings.getAuthRequestContext[dealsVoucherColor.ordinal()];
        if (i2 == 1) {
            i = R.drawable.deals_voucher_left_side;
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = R.drawable.deals_voucher_left_side_blue;
        }
        InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.res_0x7f0a0d03_touchdetector_callback), i);
        this.backgroundColor = dealsVoucherColor;
    }
}
