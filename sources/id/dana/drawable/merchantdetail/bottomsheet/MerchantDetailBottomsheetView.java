package id.dana.drawable.merchantdetail.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.utils.SizeUtil;
import id.dana.drawable.merchantdetail.MerchantDetailView;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB'\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\f¢\u0006\u0004\bO\u0010PB+\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010N\u001a\u00020\f\u0012\u0006\u0010Q\u001a\u00020\f¢\u0006\u0004\bO\u0010RJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\bJ\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\bJ\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\bJ\u001b\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\bJ(\u0010(\u001a\u00020\u00042\u0019\u0010'\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b&\u0012\u0004\u0012\u00020\u00040%¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0010¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\bJ\u001d\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200¢\u0006\u0004\b4\u00103J\u001d\u00105\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00103J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u00106\u001a\u00020.2\u0006\u00107\u001a\u000200H\u0002¢\u0006\u0004\b\u0007\u00103J#\u0010;\u001a\u00020\u00042\f\u0010:\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b;\u0010<R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010=R+\u0010\n\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b&\u0012\u0004\u0012\u00020\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010\t\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR(\u0010I\u001a\b\u0012\u0004\u0012\u00020.0C8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/bottomsheet/MerchantDetailBottomsheetView;", "Lid/dana/base/BaseRichView;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "bottomSheetCallback", "", "addBottomsheetCallback", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V", "MyBillsEntityDataFactory", "()V", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "collapseBottomsheet", "", "getLayout", "()I", "hideMerchantDetailBottomsheet", "", "isMerchantDetailFullyDisplayed", "()Z", "isMerchantDetailPreviewDisplayed", "isShowing", "onMerchantDetailFullyShown", "onMerchantDetailRefreshed", "reset", "resetMerchantDetailContent", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomsheetBehavior", "setBottomsheetBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "Landroid/view/View;", "dimBackgroundView", "setDimBackground", "(Landroid/view/View;)V", "state", "setInitialState", "(I)V", "setNonDraggableExpandBottomsheet", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "callback", "setOnScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "skipCollapsed", "setSkipCollapsed", "(Z)V", "setup", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "", "source", "showMerchantDetailFromList", "(Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)V", "showMerchantDetailFromNonMaps", "showMerchantDetailPreview", "p0", "p1", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "merchantImages", "updateImage", "(Ljava/util/List;Lid/dana/nearbyme/model/ShopModel;)V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View;", "PlaceComponentResult", "Z", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "getShopModelLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setShopModelLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "shopModelLiveData", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailBottomsheetView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BottomSheetBehavior<MerchantDetailBottomsheetView> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private View PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MutableLiveData<ShopModel> shopModelLiveData;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDetailBottomsheetView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDetailBottomsheetView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_detail_bottomsheet;
    }

    @JvmName(name = "getShopModelLiveData")
    public final MutableLiveData<ShopModel> getShopModelLiveData() {
        return this.shopModelLiveData;
    }

    @JvmName(name = "setShopModelLiveData")
    public final void setShopModelLiveData(MutableLiveData<ShopModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "");
        this.shopModelLiveData = mutableLiveData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDetailBottomsheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.shopModelLiveData = new MutableLiveData<>();
    }

    public /* synthetic */ MerchantDetailBottomsheetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDetailBottomsheetView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.shopModelLiveData = new MutableLiveData<>();
    }

    public final void setOnScrollListener(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        this.BuiltInFictitiousFunctionClassFactory = callback;
    }

    public final void setBottomsheetBehavior(final BottomSheetBehavior<MerchantDetailBottomsheetView> bottomsheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomsheetBehavior, "");
        this.MyBillsEntityDataFactory = bottomsheetBehavior;
        bottomsheetBehavior.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.f33332131165977));
        bottomsheetBehavior.setHideable(true);
        bottomsheetBehavior.setFitToContents(true);
        bottomsheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.MerchantDetailBottomsheetView$setBottomsheetBehavior$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                ImageView imageView = (ImageView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.setupButtonChild);
                if (imageView != null) {
                    imageView.setVisibility(p1 == 4 ? 0 : 8);
                }
                if (p1 == 3) {
                    MerchantDetailView merchantDetailView = (MerchantDetailView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
                    if (merchantDetailView != null) {
                        merchantDetailView.setOnFull();
                    }
                } else if (p1 != 4) {
                    if (p1 == 5) {
                        bottomsheetBehavior.setSkipCollapsed(false);
                        bottomsheetBehavior.setPeekHeight(MerchantDetailBottomsheetView.this.getResources().getDimensionPixelSize(R.dimen.f33332131165977));
                    }
                } else {
                    MerchantDetailView merchantDetailView2 = (MerchantDetailView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
                    if (merchantDetailView2 != null) {
                        merchantDetailView2.showComponentWhenFullState(false);
                    }
                    MerchantDetailView merchantDetailView3 = (MerchantDetailView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
                    if (merchantDetailView3 != null) {
                        merchantDetailView3.setOnCollapsed();
                    }
                    MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory();
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                View view;
                View view2;
                View view3;
                Intrinsics.checkNotNullParameter(p0, "");
                CardView cardView = (CardView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.cvMerchantDetail);
                if (cardView != null) {
                    MerchantDetailBottomsheetView.adjustCardRadius$default(MerchantDetailBottomsheetView.this, cardView, p1, 0, 2, null);
                }
                if (p1 > 0.0f) {
                    view2 = MerchantDetailBottomsheetView.this.PlaceComponentResult;
                    if (view2 != null) {
                        view2.setAlpha(p1);
                    }
                    view3 = MerchantDetailBottomsheetView.this.PlaceComponentResult;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                } else {
                    view = MerchantDetailBottomsheetView.this.PlaceComponentResult;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
                MerchantDetailView merchantDetailView = (MerchantDetailView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
                if (merchantDetailView != null) {
                    merchantDetailView.setOnBottomsheetDragged(p1);
                }
            }
        });
    }

    public final void setDimBackground(View dimBackgroundView) {
        this.PlaceComponentResult = dimBackgroundView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        ViewTreeObserver viewTreeObserver;
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
            return;
        }
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null && (viewTreeObserver = merchantDetailView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.MerchantDetailBottomsheetView$adjustBottomSheetPeekHeight$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    BottomSheetBehavior bottomSheetBehavior;
                    ((MerchantDetailView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23)).getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    MerchantDetailView merchantDetailView2 = (MerchantDetailView) MerchantDetailBottomsheetView.this._$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
                    if (merchantDetailView2 != null) {
                        int headerInfoViewBottom = merchantDetailView2.getHeaderInfoViewBottom();
                        bottomSheetBehavior = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                        if (bottomSheetBehavior == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            bottomSheetBehavior = null;
                        }
                        bottomSheetBehavior.setPeekHeight(headerInfoViewBottom + SizeUtil.PlaceComponentResult(12));
                    }
                }
            });
        }
        getAuthRequestContext();
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void getAuthRequestContext() {
        View view;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior.getState() == 4) {
            View view2 = this.PlaceComponentResult;
            boolean z = false;
            if (view2 != null && view2.getVisibility() == 0) {
                z = true;
            }
            if (!z || (view = this.PlaceComponentResult) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        CardView cardView;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior.getState() != 4 || (cardView = (CardView) _$_findCachedViewById(R.id.cvMerchantDetail)) == null) {
            return;
        }
        adjustCardRadius$default(this, cardView, 0.0f, 0, 2, null);
    }

    public final void showMerchantDetailFromList(ShopModel shopModel, String source) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(source, "");
        reset();
        this.shopModelLiveData.PlaceComponentResult((MutableLiveData<ShopModel>) shopModel);
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(3);
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior3 = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bottomSheetBehavior2 = bottomSheetBehavior3;
        }
        bottomSheetBehavior2.setSkipCollapsed(true);
        MyBillsEntityDataFactory(shopModel, source);
    }

    private final void MyBillsEntityDataFactory(ShopModel p0, String p1) {
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.showCompleteShopDataWithPreviewFirst(p0, p1, new Function0<Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.MerchantDetailBottomsheetView$showShopDataWithPreviewFirst$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory();
                }
            });
        }
    }

    public final void resetMerchantDetailContent() {
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.onMerchantDetailReset();
            merchantDetailView.scrollToTop();
        }
    }

    public final void addBottomsheetCallback(BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        Intrinsics.checkNotNullParameter(bottomSheetCallback, "");
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback);
    }

    public final void collapseBottomsheet() {
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.scrollToTop();
        }
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior.getSkipCollapsed()) {
            BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior3 = this.MyBillsEntityDataFactory;
            if (bottomSheetBehavior3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bottomSheetBehavior2 = bottomSheetBehavior3;
            }
            bottomSheetBehavior2.setState(5);
            return;
        }
        this.getAuthRequestContext = true;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior4 = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bottomSheetBehavior2 = bottomSheetBehavior4;
        }
        bottomSheetBehavior2.setState(4);
    }

    public final boolean isShowing() {
        return isMerchantDetailFullyDisplayed() || isMerchantDetailPreviewDisplayed();
    }

    public final boolean isMerchantDetailFullyDisplayed() {
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior.getState() != 6) {
            BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior3 = this.MyBillsEntityDataFactory;
            if (bottomSheetBehavior3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bottomSheetBehavior2 = bottomSheetBehavior3;
            }
            if (bottomSheetBehavior2.getState() != 3) {
                return false;
            }
        }
        return true;
    }

    public final boolean isMerchantDetailPreviewDisplayed() {
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        return bottomSheetBehavior.getState() == 4;
    }

    public final void showMerchantDetailPreview(ShopModel shopModel, String source) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(source, "");
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(4);
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior3 = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bottomSheetBehavior2 = bottomSheetBehavior3;
        }
        bottomSheetBehavior2.setSkipCollapsed(false);
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.showPreviewShopData(shopModel, source);
        }
        MyBillsEntityDataFactory();
    }

    public final void onMerchantDetailFullyShown() {
        MerchantDetailView merchantDetailView;
        Object obj = this.shopModelLiveData.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        ShopModel shopModel = (ShopModel) obj;
        if (shopModel == null || (merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23)) == null) {
            return;
        }
        merchantDetailView.loadCompleteMerchantDetailInfo(shopModel);
    }

    public final void hideMerchantDetailBottomsheet() {
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(5);
    }

    public final void reset() {
        Object obj = this.shopModelLiveData.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        if (obj != null) {
            this.shopModelLiveData.PlaceComponentResult((MutableLiveData<ShopModel>) null);
        }
    }

    public final void setSkipCollapsed(boolean skipCollapsed) {
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setSkipCollapsed(skipCollapsed);
    }

    public final void setNonDraggableExpandBottomsheet() {
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setDraggable(false);
        bottomSheetBehavior.setState(3);
    }

    public final void showMerchantDetailFromNonMaps(ShopModel shopModel, String source) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(source, "");
        this.shopModelLiveData.PlaceComponentResult((MutableLiveData<ShopModel>) shopModel);
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setDraggable(true);
        MyBillsEntityDataFactory(shopModel, source);
    }

    public final void onMerchantDetailRefreshed() {
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setDraggable(true);
        bottomSheetBehavior.setState(3);
        bottomSheetBehavior.setSkipCollapsed(false);
    }

    public final void setInitialState(int state) {
        if (state == 3) {
            CardView cardView = (CardView) _$_findCachedViewById(R.id.cvMerchantDetail);
            if (cardView != null) {
                adjustCardRadius$default(this, cardView, 1.0f, 0, 2, null);
            }
            MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
            if (merchantDetailView != null) {
                merchantDetailView.showComponentWhenFullState(true);
            }
            MerchantDetailView merchantDetailView2 = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
            if (merchantDetailView2 != null) {
                merchantDetailView2.setOnFull();
            }
        }
        BottomSheetBehavior<MerchantDetailBottomsheetView> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(state);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.setupButtonChild);
        if (imageView != null) {
            imageView.setVisibility(state == 4 ? 0 : 8);
        }
    }

    public final void updateImage(List<MerchantImageModel> merchantImages, ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(merchantImages, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        Object obj = this.shopModelLiveData.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        ShopModel shopModel2 = (ShopModel) obj;
        if (shopModel2 == null || !Intrinsics.areEqual(shopModel2, shopModel)) {
            return;
        }
        shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda4 = merchantImages;
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.updateImages(shopModel2);
        }
        MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void adjustCardRadius$default(MerchantDetailBottomsheetView merchantDetailBottomsheetView, CardView cardView, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 16;
        }
        float f2 = 0.0f;
        if (f < 1.0f && f >= 0.0f) {
            f2 = (1.0f - f) * SizeUtil.PlaceComponentResult(i);
        }
        cardView.setRadius(f2);
        cardView.requestLayout();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.setMerchantDetailViewListener(new MerchantDetailView.MerchantDetailViewListener() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.MerchantDetailBottomsheetView$setupMerchantDetailView$1
                @Override // id.dana.nearbyrevamp.merchantdetail.MerchantDetailView.MerchantDetailViewListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    BottomSheetBehavior bottomSheetBehavior;
                    bottomSheetBehavior = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                    if (bottomSheetBehavior == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bottomSheetBehavior = null;
                    }
                    bottomSheetBehavior.setState(3);
                }

                @Override // id.dana.nearbyrevamp.merchantdetail.MerchantDetailView.MerchantDetailViewListener
                public final void getAuthRequestContext() {
                    BottomSheetBehavior bottomSheetBehavior;
                    bottomSheetBehavior = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                    if (bottomSheetBehavior == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bottomSheetBehavior = null;
                    }
                    bottomSheetBehavior.setState(3);
                }

                @Override // id.dana.nearbyrevamp.merchantdetail.MerchantDetailView.MerchantDetailViewListener
                public final void MyBillsEntityDataFactory() {
                    BottomSheetBehavior bottomSheetBehavior;
                    BottomSheetBehavior bottomSheetBehavior2;
                    BottomSheetBehavior bottomSheetBehavior3;
                    bottomSheetBehavior = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                    BottomSheetBehavior bottomSheetBehavior4 = null;
                    if (bottomSheetBehavior == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bottomSheetBehavior = null;
                    }
                    if (bottomSheetBehavior.getSkipCollapsed()) {
                        bottomSheetBehavior3 = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                        if (bottomSheetBehavior3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bottomSheetBehavior4 = bottomSheetBehavior3;
                        }
                        bottomSheetBehavior4.setState(5);
                        return;
                    }
                    bottomSheetBehavior2 = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                    if (bottomSheetBehavior2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bottomSheetBehavior4 = bottomSheetBehavior2;
                    }
                    bottomSheetBehavior4.setState(4);
                }

                @Override // id.dana.nearbyrevamp.merchantdetail.MerchantDetailView.MerchantDetailViewListener
                public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    BottomSheetBehavior bottomSheetBehavior;
                    Function1 function1;
                    Function1 function12;
                    bottomSheetBehavior = MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory;
                    if (bottomSheetBehavior == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bottomSheetBehavior = null;
                    }
                    if (bottomSheetBehavior.getState() == 3) {
                        function12 = MerchantDetailBottomsheetView.this.BuiltInFictitiousFunctionClassFactory;
                        if (function12 != null) {
                            function12.invoke(Boolean.valueOf(p0));
                            return;
                        }
                        return;
                    }
                    function1 = MerchantDetailBottomsheetView.this.BuiltInFictitiousFunctionClassFactory;
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                }

                @Override // id.dana.nearbyrevamp.merchantdetail.MerchantDetailView.MerchantDetailViewListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    MerchantDetailBottomsheetView.this.MyBillsEntityDataFactory();
                }
            });
        }
    }
}
