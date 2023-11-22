package id.dana.expresspurchase.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.model.PriceModel;
import id.dana.expresspurchase.model.PriceModelKt;
import id.dana.expresspurchase.model.VoucherExpressInfoModel;
import id.dana.utils.ResourceUtils;
import id.dana.utils.extension.StringExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0004+,-.B'\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&B+\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010'\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010(\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020\u0006¢\u0006\u0004\b%\u0010*J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0004\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoDeals;", "Lid/dana/base/BaseRichView;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "", "getLayout", "()I", "Lid/dana/expresspurchase/view/OfferInfoDeals$DealsShopLocationFailedEvent;", "event", "", "onFailedGetDealsShopLocation", "(Lid/dana/expresspurchase/view/OfferInfoDeals$DealsShopLocationFailedEvent;)V", "Lid/dana/expresspurchase/view/OfferInfoDeals$DealsShopLocationEvent;", "onGetDealsShopLocation", "(Lid/dana/expresspurchase/view/OfferInfoDeals$DealsShopLocationEvent;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "expressPurchaseModel", "setupViews", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;)V", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "getOnClickDealsShopLocationTryAgain", "()Lkotlin/jvm/functions/Function0;", "setOnClickDealsShopLocationTryAgain", "(Lkotlin/jvm/functions/Function0;)V", "onClickDealsShopLocationTryAgain", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "DealsShopLocationEvent", "DealsShopLocationFailedEvent", "ProviderCategory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OfferInfoDeals extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function0<Unit> onClickDealsShopLocationTryAgain;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoDeals$DealsShopLocationFailedEvent;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DealsShopLocationFailedEvent {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferInfoDeals(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferInfoDeals(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_offer_info_deals;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferInfoDeals(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onClickDealsShopLocationTryAgain = OfferInfoDeals$onClickDealsShopLocationTryAgain$1.INSTANCE;
    }

    public /* synthetic */ OfferInfoDeals(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferInfoDeals(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onClickDealsShopLocationTryAgain = OfferInfoDeals$onClickDealsShopLocationTryAgain$1.INSTANCE;
    }

    @JvmName(name = "getOnClickDealsShopLocationTryAgain")
    public final Function0<Unit> getOnClickDealsShopLocationTryAgain() {
        return this.onClickDealsShopLocationTryAgain;
    }

    @JvmName(name = "setOnClickDealsShopLocationTryAgain")
    public final void setOnClickDealsShopLocationTryAgain(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onClickDealsShopLocationTryAgain = function0;
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0999_confirmupdatebalanceemoney_params);
        if (appCompatImageView != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, p0 ? R.drawable.ic_deals_location_online : R.drawable.ic_deals_location_offline);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.DanaSuccessDialogFragment);
        if (appCompatTextView != null) {
            appCompatTextView.setText(getResources().getString(p0 ? R.string.deals_express_location_online : R.string.deals_express_location_offline));
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a036a_r8_lambda_z7cckimop_rjsrtg6ix8npycd_m);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ^ true ? 0 : 8);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a036b_r8_lambda_gxtix1gdajl8esng4zkannb4tb0);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(p0 ? 0 : 8);
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory(String p0) {
        if (StringsKt.startsWith$default(p0, "#", false, 2, (Object) null)) {
            return p0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        sb.append(p0);
        return sb.toString();
    }

    @Subscribe
    public final void onGetDealsShopLocation(DealsShopLocationEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        KClassImpl$Data$declaredNonStaticMembers$2(false);
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.getOWNER_NAME);
        if (appCompatTextView != null) {
            appCompatTextView.setText(event.PlaceComponentResult.getShopName());
        }
    }

    @Subscribe
    public final void onFailedGetDealsShopLocation(DealsShopLocationFailedEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoDeals$DealsShopLocationEvent;", "", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DealsShopLocationEvent {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final DealsShopInfo PlaceComponentResult;

        public DealsShopLocationEvent(DealsShopInfo dealsShopInfo) {
            Intrinsics.checkNotNullParameter(dealsShopInfo, "");
            this.PlaceComponentResult = dealsShopInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011"}, d2 = {"Lid/dana/expresspurchase/view/OfferInfoDeals$ProviderCategory;", "", "", "category", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "value", "getValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "FNB", "SHOPPING", "HEALTH_BEAUTY", "INVESTMENT", "GAMING", "ENTERTAINMENT", "OTHERS"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public enum ProviderCategory {
        FNB("F&B", "fnb"),
        SHOPPING("SHOPPING", "shopping"),
        HEALTH_BEAUTY("HEALTH_&_BEAUTY", "health"),
        INVESTMENT("INVESTMENT", AccountEntityRepository.BalanceType.INVESTMENT),
        GAMING("GAMING", "gaming"),
        ENTERTAINMENT("TRAVEL_&_ENTERTAINMENT", "entertainment"),
        OTHERS("OTHERS", "others");

        private final String category;
        private final String value;

        ProviderCategory(String str, String str2) {
            this.value = str;
            this.category = str2;
        }

        @JvmName(name = "getCategory")
        public final String getCategory() {
            return this.category;
        }

        @JvmName(name = "getValue")
        public final String getValue() {
            return this.value;
        }
    }

    /* renamed from: $r8$lambda$aL09M_25q2XpFzJs1RXUgQvO3-I */
    public static /* synthetic */ void m2587$r8$lambda$aL09M_25q2XpFzJs1RXUgQvO3I(OfferInfoDeals offerInfoDeals, View view) {
        Intrinsics.checkNotNullParameter(offerInfoDeals, "");
        offerInfoDeals.onClickDealsShopLocationTryAgain.invoke();
    }

    public final void setupViews(ExpressPurchaseModel.Deals expressPurchaseModel) {
        String category;
        int PlaceComponentResult;
        ImageView imageView;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.text_header_offer);
        if (appCompatTextView != null) {
            appCompatTextView.setText(expressPurchaseModel.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a12fd_imagebridgeextension_1);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(8);
        }
        if (expressPurchaseModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
            ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
            Context context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("deals_express_voucher_context_online_");
            String str3 = expressPurchaseModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            BuiltInFictitiousFunctionClassFactory(true);
            sb.append(Intrinsics.areEqual(str3, ProviderCategory.INVESTMENT.getValue()) ? ProviderCategory.INVESTMENT.getCategory() : ProviderCategory.OTHERS.getCategory());
            PlaceComponentResult = ResourceUtils.PlaceComponentResult(context, sb.toString());
        } else {
            ResourceUtils resourceUtils2 = ResourceUtils.INSTANCE;
            Context context2 = getContext();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deals_express_voucher_context_offline_");
            String str4 = expressPurchaseModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            BuiltInFictitiousFunctionClassFactory(false);
            if (Intrinsics.areEqual(str4, ProviderCategory.FNB.getValue())) {
                category = ProviderCategory.FNB.getCategory();
            } else if (Intrinsics.areEqual(str4, ProviderCategory.HEALTH_BEAUTY.getValue())) {
                category = ProviderCategory.HEALTH_BEAUTY.getCategory();
            } else if (Intrinsics.areEqual(str4, ProviderCategory.GAMING.getValue())) {
                category = ProviderCategory.GAMING.getCategory();
            } else {
                category = Intrinsics.areEqual(str4, ProviderCategory.ENTERTAINMENT.getValue()) ? ProviderCategory.ENTERTAINMENT.getCategory() : ProviderCategory.OTHERS.getCategory();
            }
            sb2.append(category);
            PlaceComponentResult = ResourceUtils.PlaceComponentResult(context2, sb2.toString());
        }
        if (PlaceComponentResult != 0) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.ElectronicMoneyBaseResult)).setText(getResources().getString(PlaceComponentResult));
        }
        Double d = expressPurchaseModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
        VoucherExpressInfoModel voucherExpressInfoModel = expressPurchaseModel.SubSequence;
        if (voucherExpressInfoModel != null) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
            AppCompatTextView appCompatTextView3 = _$_findCachedViewById != null ? (AppCompatTextView) _$_findCachedViewById.findViewById(R.id.valueFromMethodName) : null;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(voucherExpressInfoModel.scheduleImpl);
            }
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
            AppCompatTextView appCompatTextView4 = _$_findCachedViewById2 != null ? (AppCompatTextView) _$_findCachedViewById2.findViewById(R.id.tvVoucherPrice) : null;
            if (appCompatTextView4 != null) {
                PriceModel priceModel = voucherExpressInfoModel.KClassImpl$Data$declaredNonStaticMembers$2;
                appCompatTextView4.setText(priceModel != null ? priceModel.getAuthRequestContext : null);
            }
            PriceModel priceModel2 = voucherExpressInfoModel.getAuthRequestContext;
            if (priceModel2 != null) {
                int authRequestContext = PriceModelKt.getAuthRequestContext(priceModel2);
                if (authRequestContext < 10000) {
                    View _$_findCachedViewById3 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                    AppCompatTextView appCompatTextView5 = _$_findCachedViewById3 != null ? (AppCompatTextView) _$_findCachedViewById3.findViewById(R.id.res_0x7f0a15ef_merchantdetailcontract_presenter) : null;
                    if (appCompatTextView5 != null) {
                        appCompatTextView5.setText(priceModel2.getAuthRequestContext);
                    }
                    View _$_findCachedViewById4 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                    AppCompatTextView appCompatTextView6 = _$_findCachedViewById4 != null ? (AppCompatTextView) _$_findCachedViewById4.findViewById(R.id.tvVoucherValueThousand) : null;
                    if (appCompatTextView6 != null) {
                        Intrinsics.checkNotNullExpressionValue(appCompatTextView6, "");
                        appCompatTextView6.setVisibility(8);
                    }
                } else {
                    if (10000 <= authRequestContext && authRequestContext < 1000000) {
                        View _$_findCachedViewById5 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                        AppCompatTextView appCompatTextView7 = _$_findCachedViewById5 != null ? (AppCompatTextView) _$_findCachedViewById5.findViewById(R.id.res_0x7f0a15ef_merchantdetailcontract_presenter) : null;
                        if (appCompatTextView7 != null) {
                            appCompatTextView7.setText(PriceModelKt.KClassImpl$Data$declaredNonStaticMembers$2(priceModel2));
                        }
                    } else {
                        View _$_findCachedViewById6 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                        AppCompatTextView appCompatTextView8 = _$_findCachedViewById6 != null ? (AppCompatTextView) _$_findCachedViewById6.findViewById(R.id.res_0x7f0a15ef_merchantdetailcontract_presenter) : null;
                        if (appCompatTextView8 != null) {
                            appCompatTextView8.setText(PriceModelKt.KClassImpl$Data$declaredNonStaticMembers$2(priceModel2));
                        }
                        View _$_findCachedViewById7 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                        AppCompatTextView appCompatTextView9 = _$_findCachedViewById7 != null ? (AppCompatTextView) _$_findCachedViewById7.findViewById(R.id.tvVoucherValueThousand) : null;
                        if (appCompatTextView9 != null) {
                            appCompatTextView9.setText(getResources().getString(R.string.deals_express_voucher_value_million));
                        }
                    }
                }
            }
            if (d != null && !Intrinsics.areEqual(d, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                int floor = d.doubleValue() < 1.0d ? 1 : (int) Math.floor(d.doubleValue());
                View _$_findCachedViewById8 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                AppCompatTextView appCompatTextView10 = _$_findCachedViewById8 != null ? (AppCompatTextView) _$_findCachedViewById8.findViewById(R.id.res_0x7f0a15eb_r8_lambda_4vhlg1ikq3ngh15ibkmr9xx2vv4) : null;
                if (appCompatTextView10 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append('-');
                    sb3.append(floor);
                    sb3.append('%');
                    appCompatTextView10.setText(sb3.toString());
                }
                View _$_findCachedViewById9 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                AppCompatTextView appCompatTextView11 = _$_findCachedViewById9 != null ? (AppCompatTextView) _$_findCachedViewById9.findViewById(R.id.res_0x7f0a15eb_r8_lambda_4vhlg1ikq3ngh15ibkmr9xx2vv4) : null;
                if (appCompatTextView11 != null) {
                    appCompatTextView11.setVisibility(0);
                }
            } else {
                View _$_findCachedViewById10 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
                AppCompatTextView appCompatTextView12 = _$_findCachedViewById10 != null ? (AppCompatTextView) _$_findCachedViewById10.findViewById(R.id.res_0x7f0a15eb_r8_lambda_4vhlg1ikq3ngh15ibkmr9xx2vv4) : null;
                if (appCompatTextView12 != null) {
                    appCompatTextView12.setVisibility(8);
                }
            }
            AppCompatTextView appCompatTextView13 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a14da_component2_rl5bavg);
            if (appCompatTextView13 != null) {
                if (voucherExpressInfoModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    str2 = getResources().getString(R.string.deals_express_min_transaction_default_value);
                } else {
                    str2 = voucherExpressInfoModel.PlaceComponentResult;
                }
                appCompatTextView13.setText(str2);
            }
            AppCompatTextView appCompatTextView14 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a153e_daggerexploredanafragmentcomponent_exploredanafragmentcomponentimpl_providepaylaterrepositoryprovider);
            if (appCompatTextView14 != null) {
                String str5 = voucherExpressInfoModel.getErrorConfigVersion;
                if (str5 == null || StringsKt.isBlank(str5)) {
                    str = getResources().getString(R.string.deals_express_redeem_period_default_value);
                } else {
                    str = voucherExpressInfoModel.getErrorConfigVersion;
                }
                appCompatTextView14.setText(str);
            }
            String str6 = voucherExpressInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(str6 != null ? str6 : "").BuiltInFictitiousFunctionClassFactory((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) ((ShapeableImageView) _$_findCachedViewById(R.id.stopIgnoringView)));
            VoucherExpressInfoModel.VoucherColorCodeModel voucherColorCodeModel = voucherExpressInfoModel.BuiltInFictitiousFunctionClassFactory;
            View _$_findCachedViewById11 = _$_findCachedViewById(R.id.res_0x7f0a1a80_firstdrawlistener_registerfirstdrawlistener_1);
            if (_$_findCachedViewById11 != null) {
                String str7 = voucherColorCodeModel != null ? voucherColorCodeModel.BuiltInFictitiousFunctionClassFactory : null;
                String str8 = str7;
                if ((!(str8 == null || str8.length() == 0)) == false) {
                    str7 = null;
                }
                if (str7 != null) {
                    String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str7);
                    if (StringExtKt.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory) && (imageView = (ImageView) _$_findCachedViewById11.findViewById(R.id.res_0x7f0a0d03_touchdetector_callback)) != null) {
                        imageView.setColorFilter(Color.parseColor(BuiltInFictitiousFunctionClassFactory));
                    }
                }
                String str9 = voucherColorCodeModel != null ? voucherColorCodeModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                String str10 = str9;
                String str11 = (str10 == null || str10.length() == 0) ^ true ? str9 : null;
                if (str11 != null) {
                    String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(str11);
                    if (StringExtKt.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2)) {
                        ((AppCompatTextView) _$_findCachedViewById11.findViewById(R.id.valueFromMethodName)).setTextColor(Color.parseColor(BuiltInFictitiousFunctionClassFactory2));
                        ((AppCompatTextView) _$_findCachedViewById11.findViewById(R.id.RequestMoneyInitModelKt)).setTextColor(Color.parseColor(BuiltInFictitiousFunctionClassFactory2));
                        ((AppCompatTextView) _$_findCachedViewById11.findViewById(R.id.res_0x7f0a15ef_merchantdetailcontract_presenter)).setTextColor(Color.parseColor(BuiltInFictitiousFunctionClassFactory2));
                        ((AppCompatTextView) _$_findCachedViewById11.findViewById(R.id.tvVoucherValueThousand)).setTextColor(Color.parseColor(BuiltInFictitiousFunctionClassFactory2));
                        ((AppCompatTextView) _$_findCachedViewById11.findViewById(R.id.ElectronicMoneyBaseResult)).setTextColor(Color.parseColor(BuiltInFictitiousFunctionClassFactory2));
                    }
                }
            }
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btnDealsLocationError);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.expresspurchase.view.OfferInfoDeals$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OfferInfoDeals.m2587$r8$lambda$aL09M_25q2XpFzJs1RXUgQvO3I(OfferInfoDeals.this, view);
                }
            });
        }
        EventBus.getDefault().register(this);
    }
}
