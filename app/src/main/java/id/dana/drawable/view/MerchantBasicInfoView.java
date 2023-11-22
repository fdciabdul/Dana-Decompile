package id.dana.drawable.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.drawable.view.OpenHourDetailDialogFragment;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import id.dana.utils.DateTimeUtil;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B'\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0005¢\u0006\u0004\b(\u0010)B+\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0004\b(\u0010+J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u00118\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/nearbyrevamp/view/MerchantBasicInfoView;", "Lid/dana/base/BaseRichView;", "", "p0", "p1", "", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;I)V", "getLayout", "()I", "", "getAuthRequestContext", "(IJ)Ljava/lang/String;", "setup", "()V", "", "MyBillsEntityDataFactory", "()Z", "Lid/dana/nearbyrevamp/view/MerchantBasicInfoView$InfoType;", "type", "showAdditionalInfo", "(Lid/dana/nearbyrevamp/view/MerchantBasicInfoView$InfoType;)V", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "shouldDisplayRankingInfo", "showMerchantInfo", "(Lid/dana/nearbyme/model/ShopModel;ZLid/dana/nearbyrevamp/view/MerchantBasicInfoView$InfoType;)V", "Z", "isPreview", "setPreview", "(Z)V", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "InfoType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantBasicInfoView extends BaseRichView {
    private ShopModel PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isPreview;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/nearbyrevamp/view/MerchantBasicInfoView$InfoType;", "", "<init>", "(Ljava/lang/String;I)V", "BASIC", "DETAIL", "DETAIL_WITH_OPENHOUR_REDIRECTION"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum InfoType {
        BASIC,
        DETAIL,
        DETAIL_WITH_OPENHOUR_REDIRECTION
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ShopOpenHourModel.OpenHourType.values().length];
            iArr[ShopOpenHourModel.OpenHourType.NONE.ordinal()] = 1;
            iArr[ShopOpenHourModel.OpenHourType.CLOSE.ordinal()] = 2;
            iArr[ShopOpenHourModel.OpenHourType.CLOSING_SOON.ordinal()] = 3;
            iArr[ShopOpenHourModel.OpenHourType.OPENING_SOON.ordinal()] = 4;
            iArr[ShopOpenHourModel.OpenHourType.OPEN.ordinal()] = 5;
            MyBillsEntityDataFactory = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantBasicInfoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantBasicInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
        return R.layout.view_nearby_merchant_basic_info;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    @JvmName(name = "isPreview")
    /* renamed from: isPreview  reason: from getter */
    public final boolean getIsPreview() {
        return this.isPreview;
    }

    @JvmName(name = "setPreview")
    public final void setPreview(boolean z) {
        this.isPreview = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantBasicInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantBasicInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantBasicInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public static /* synthetic */ void showMerchantInfo$default(MerchantBasicInfoView merchantBasicInfoView, ShopModel shopModel, boolean z, InfoType infoType, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            infoType = InfoType.BASIC;
        }
        merchantBasicInfoView.showMerchantInfo(shopModel, z, infoType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:400:0x038d, code lost:
    
        if (r4.moveToNextValue() != false) goto L401;
     */
    /* JADX WARN: Removed duplicated region for block: B:346:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x02cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showMerchantInfo(id.dana.nearbyme.model.ShopModel r21, boolean r22, id.dana.nearbyrevamp.view.MerchantBasicInfoView.InfoType r23) {
        /*
            Method dump skipped, instructions count: 953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.view.MerchantBasicInfoView.showMerchantInfo(id.dana.nearbyme.model.ShopModel, boolean, id.dana.nearbyrevamp.view.MerchantBasicInfoView$InfoType):void");
    }

    public static /* synthetic */ void showAdditionalInfo$default(MerchantBasicInfoView merchantBasicInfoView, InfoType infoType, int i, Object obj) {
        if ((i & 1) != 0) {
            infoType = InfoType.DETAIL;
        }
        merchantBasicInfoView.showAdditionalInfo(infoType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x0171, code lost:
    
        if (r4.NetworkUserEntityData$$ExternalSyntheticLambda7() != false) goto L171;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showAdditionalInfo(id.dana.nearbyrevamp.view.MerchantBasicInfoView.InfoType r13) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.view.MerchantBasicInfoView.showAdditionalInfo(id.dana.nearbyrevamp.view.MerchantBasicInfoView$InfoType):void");
    }

    private final boolean MyBillsEntityDataFactory() {
        ShopModel shopModel = this.PlaceComponentResult;
        ShopModel shopModel2 = null;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        String PlaceComponentResult = shopModel.PlaceComponentResult(getContext());
        if (PlaceComponentResult == null || PlaceComponentResult.length() == 0) {
            ShopModel shopModel3 = this.PlaceComponentResult;
            if (shopModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                shopModel2 = shopModel3;
            }
            return shopModel2.moveToNextValue();
        }
        return true;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, int p2) {
        String str = p0;
        if (str.length() == 0) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.getCollapseContentDescription);
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.collectPackageFragmentsOptimizedIfPossible);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.getCollapseContentDescription);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setVisibility(0);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) _$_findCachedViewById(R.id.getCollapseContentDescription);
        if (appCompatTextView4 != null) {
            appCompatTextView4.setText(str);
        }
        AppCompatTextView appCompatTextView5 = (AppCompatTextView) _$_findCachedViewById(R.id.getCollapseContentDescription);
        if (appCompatTextView5 != null) {
            appCompatTextView5.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), p2));
        }
        AppCompatTextView appCompatTextView6 = (AppCompatTextView) _$_findCachedViewById(R.id.collectPackageFragmentsOptimizedIfPossible);
        if (appCompatTextView6 != null) {
            appCompatTextView6.setVisibility(0);
        }
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) _$_findCachedViewById(R.id.collectPackageFragmentsOptimizedIfPossible);
        if (appCompatTextView7 != null) {
            appCompatTextView7.setText(p1);
        }
    }

    private final String getAuthRequestContext(int p0, long p1) {
        String string = getContext().getString(p0, DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(p1 * 1000)));
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    public static /* synthetic */ void $r8$lambda$KwW1FCPYf1eB9ONf47eYTFh2Nbg(MerchantBasicInfoView merchantBasicInfoView, View view) {
        BaseActivity baseActivity;
        Intrinsics.checkNotNullParameter(merchantBasicInfoView, "");
        if (merchantBasicInfoView.isPreview || (baseActivity = merchantBasicInfoView.getBaseActivity()) == null) {
            return;
        }
        OpenHourDetailDialogFragment.Companion companion = OpenHourDetailDialogFragment.INSTANCE;
        ShopModel shopModel = merchantBasicInfoView.PlaceComponentResult;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        OpenHourDetailDialogFragment.Companion.MyBillsEntityDataFactory(shopModel).show(baseActivity.getSupportFragmentManager(), "OpenHourDetailBottomsheetDialog");
    }
}
