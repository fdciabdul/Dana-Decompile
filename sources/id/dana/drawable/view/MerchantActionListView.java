package id.dana.drawable.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantActionInfoComponent;
import id.dana.di.modules.MerchantDetailActionInfoModule;
import id.dana.dialog.DialogContactUs;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.extension.ContextExtKt;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.homeshopping.HomeShoppingDialogFragment;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.utils.LocationUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,B+\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005¢\u0006\u0004\b+\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/nearbyrevamp/view/MerchantActionListView;", "Lid/dana/base/BaseRichView;", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "()V", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "merchantDetailConfig", "showActionMenu", "(Lid/dana/nearbyme/model/ShopModel;Lid/dana/domain/nearbyme/model/MerchantDetailConfig;)V", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "merchantDetailAnalyticTracker", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "getMerchantDetailAnalyticTracker", "()Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "setMerchantDetailAnalyticTracker", "(Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;)V", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/model/ShopModel;", "PlaceComponentResult", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantActionListView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private ShopModel PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public MerchantDetailAnalyticTracker merchantDetailAnalyticTracker;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantActionListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantActionListView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_action_list;
    }

    @JvmName(name = "getMerchantDetailAnalyticTracker")
    public final MerchantDetailAnalyticTracker getMerchantDetailAnalyticTracker() {
        MerchantDetailAnalyticTracker merchantDetailAnalyticTracker = this.merchantDetailAnalyticTracker;
        if (merchantDetailAnalyticTracker != null) {
            return merchantDetailAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantDetailAnalyticTracker")
    public final void setMerchantDetailAnalyticTracker(MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        Intrinsics.checkNotNullParameter(merchantDetailAnalyticTracker, "");
        this.merchantDetailAnalyticTracker = merchantDetailAnalyticTracker;
    }

    @JvmName(name = "getNearbyAnalyticTracker")
    public final NearbyAnalyticTracker getNearbyAnalyticTracker() {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker != null) {
            return nearbyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyAnalyticTracker")
    public final void setNearbyAnalyticTracker(NearbyAnalyticTracker nearbyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(nearbyAnalyticTracker, "");
        this.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantActionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantActionListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantActionListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        MerchantActionView merchantActionView = (MerchantActionView) _$_findCachedViewById(R.id.setQuestsVisible);
        if (merchantActionView != null) {
            MerchantActionView.setOnActionClickListener$default(merchantActionView, new MerchantActionListView$setup$1(this), null, 2, null);
        }
        MerchantActionView merchantActionView2 = (MerchantActionView) _$_findCachedViewById(R.id.getNxWebChromeClient);
        if (merchantActionView2 != null) {
            MerchantActionView.setOnActionClickListener$default(merchantActionView2, new MerchantActionListView$setup$2(this), null, 2, null);
        }
        MerchantActionView merchantActionView3 = (MerchantActionView) _$_findCachedViewById(R.id.res_0x7f0a0e63_bankaccountnumberboxview_inputbanknumberchangedlistener_1);
        if (merchantActionView3 != null) {
            MerchantActionView.setOnActionClickListener$default(merchantActionView3, new MerchantActionListView$setup$3(this), null, 2, null);
        }
        MerchantActionView merchantActionView4 = (MerchantActionView) _$_findCachedViewById(R.id.updateValueLocked);
        if (merchantActionView4 != null) {
            MerchantActionView.setOnActionClickListener$default(merchantActionView4, new MerchantActionListView$setup$4(this), null, 2, null);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantActionInfoComponent.Builder authRequestContext = DaggerMerchantActionInfoComponent.getAuthRequestContext();
        authRequestContext.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (MerchantDetailActionInfoModule) Preconditions.getAuthRequestContext(new MerchantDetailActionInfoModule());
        if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantDetailActionInfoModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, ApplicationComponent.class);
        new DaggerMerchantActionInfoComponent.MerchantActionInfoComponentImpl(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public final void showActionMenu(ShopModel shopModel, MerchantDetailConfig merchantDetailConfig) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(shopModel, "");
        this.PlaceComponentResult = shopModel;
        if (merchantDetailConfig != null) {
            MerchantActionView merchantActionView = (MerchantActionView) _$_findCachedViewById(R.id.setQuestsVisible);
            if (merchantActionView != null) {
                if (merchantDetailConfig.getCallEnabled()) {
                    if (MyBillsEntityDataFactory().length() > 0) {
                        z2 = true;
                        merchantActionView.setState(z2);
                    }
                }
                z2 = false;
                merchantActionView.setState(z2);
            }
            MerchantActionView merchantActionView2 = (MerchantActionView) _$_findCachedViewById(R.id.res_0x7f0a0e63_bankaccountnumberboxview_inputbanknumberchangedlistener_1);
            if (merchantActionView2 != null) {
                if (merchantDetailConfig.getDirectionEnabled()) {
                    LocationUtil.PlaceComponentResult(shopModel.DatabaseTableConfigUtil, shopModel.PrepareContext);
                    z = true;
                } else {
                    z = false;
                }
                merchantActionView2.setState(z);
            }
            MerchantActionView merchantActionView3 = (MerchantActionView) _$_findCachedViewById(R.id.updateValueLocked);
            if (merchantActionView3 != null) {
                merchantActionView3.setState(merchantDetailConfig.getHomeShoppingEnabled() && shopModel.initRecordTimeStamp());
            }
            MerchantActionView merchantActionView4 = (MerchantActionView) _$_findCachedViewById(R.id.getNxWebChromeClient);
            if (merchantActionView4 != null) {
                merchantActionView4.setState(merchantDetailConfig.getShareEnabled());
            }
        }
    }

    private final String MyBillsEntityDataFactory() {
        ShopModel shopModel = this.PlaceComponentResult;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        String authRequestContext = shopModel.getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return PhoneNumberUtilKt.replaceIndoRegionDashWithPhonePrefix(authRequestContext);
    }

    public static final /* synthetic */ void access$launchMessage(MerchantActionListView merchantActionListView, String str) {
        Context context = merchantActionListView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Context context2 = merchantActionListView.getContext();
        Object[] objArr = new Object[1];
        ShopModel shopModel = merchantActionListView.PlaceComponentResult;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        objArr[0] = shopModel.newProxyInstance;
        String string = context2.getString(R.string.customer_service_wa_template, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "");
        ContextExtKt.KClassImpl$Data$declaredNonStaticMembers$2(context, str, string);
    }

    public static final /* synthetic */ void access$onPhoneClick(final MerchantActionListView merchantActionListView) {
        BaseActivity baseActivity;
        FragmentManager supportFragmentManager;
        if (merchantActionListView.PlaceComponentResult != null) {
            String MyBillsEntityDataFactory = merchantActionListView.MyBillsEntityDataFactory();
            if (!(MyBillsEntityDataFactory.length() > 0)) {
                MyBillsEntityDataFactory = null;
            }
            if (MyBillsEntityDataFactory == null || (baseActivity = merchantActionListView.getBaseActivity()) == null || (supportFragmentManager = baseActivity.getSupportFragmentManager()) == null) {
                return;
            }
            DialogContactUs.Builder builder = new DialogContactUs.Builder(null, null, null, null, 15, null);
            Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
            builder.getAuthRequestContext = MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
            builder.PlaceComponentResult = MyBillsEntityDataFactory;
            Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.nearbyrevamp.view.MerchantActionListView$onPhoneClick$3$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                    Context context = MerchantActionListView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    ContextExtKt.PlaceComponentResult(context, str);
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
            MerchantActionListView$onPhoneClick$3$1$2 merchantActionListView$onPhoneClick$3$1$2 = new MerchantActionListView$onPhoneClick$3$1$2(merchantActionListView);
            Intrinsics.checkNotNullParameter(merchantActionListView$onPhoneClick$3$1$2, "");
            builder.BuiltInFictitiousFunctionClassFactory = merchantActionListView$onPhoneClick$3$1$2;
            builder.MyBillsEntityDataFactory().show(supportFragmentManager, "DialogContactUs");
        }
    }

    public static final /* synthetic */ void access$openGoogleMaps(MerchantActionListView merchantActionListView) {
        Context context;
        if (merchantActionListView.PlaceComponentResult == null || (context = merchantActionListView.getContext()) == null) {
            return;
        }
        ShopModel shopModel = merchantActionListView.PlaceComponentResult;
        ShopModel shopModel2 = null;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        double d = shopModel.DatabaseTableConfigUtil;
        ShopModel shopModel3 = merchantActionListView.PlaceComponentResult;
        if (shopModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            shopModel2 = shopModel3;
        }
        ContextExtKt.BuiltInFictitiousFunctionClassFactory(context, d, shopModel2.PrepareContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [id.dana.nearbyme.model.ShopModel] */
    public static final /* synthetic */ void access$openHomeshopping(MerchantActionListView merchantActionListView) {
        BaseActivity baseActivity;
        if (merchantActionListView.PlaceComponentResult == null || (baseActivity = merchantActionListView.getBaseActivity()) == null) {
            return;
        }
        HomeShoppingDialogFragment.Companion companion = HomeShoppingDialogFragment.INSTANCE;
        FragmentManager supportFragmentManager = baseActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        ShopModel shopModel = merchantActionListView.PlaceComponentResult;
        ?? r3 = 0;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        HomeShoppingDialogFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager, new MerchantDetailViewState(shopModel, r3, 2, r3));
        NearbyAnalyticTracker nearbyAnalyticTracker = merchantActionListView.getNearbyAnalyticTracker();
        ShopModel shopModel2 = merchantActionListView.PlaceComponentResult;
        if (shopModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            r3 = shopModel2;
        }
        nearbyAnalyticTracker.MyBillsEntityDataFactory(r3, TrackerKey.SourceType.NEARBY_ME_DETAIL);
    }

    public static final /* synthetic */ void access$shareDeeplink(MerchantActionListView merchantActionListView) {
        if (merchantActionListView.PlaceComponentResult != null) {
            Context context = merchantActionListView.getContext();
            ShopModel shopModel = null;
            if (context != null) {
                Context context2 = merchantActionListView.getContext();
                Object[] objArr = new Object[2];
                ShopModel shopModel2 = merchantActionListView.PlaceComponentResult;
                if (shopModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    shopModel2 = null;
                }
                String str = shopModel2.newProxyInstance;
                if (str == null) {
                    str = "";
                }
                objArr[0] = str;
                ShopModel shopModel3 = merchantActionListView.PlaceComponentResult;
                if (shopModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    shopModel3 = null;
                }
                objArr[1] = NearbyExtensionKt.PlaceComponentResult(shopModel3);
                String string = context2.getString(R.string.merchant_detail_deeplink_share, objArr);
                Intrinsics.checkNotNullExpressionValue(string, "");
                ContextExtKt.BuiltInFictitiousFunctionClassFactory(context, string);
            }
            MerchantDetailAnalyticTracker merchantDetailAnalyticTracker = merchantActionListView.getMerchantDetailAnalyticTracker();
            ShopModel shopModel4 = merchantActionListView.PlaceComponentResult;
            if (shopModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                shopModel4 = null;
            }
            String str2 = shopModel4.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (str2 == null) {
                str2 = "";
            }
            ShopModel shopModel5 = merchantActionListView.PlaceComponentResult;
            if (shopModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                shopModel = shopModel5;
            }
            String str3 = shopModel.newProxyInstance;
            merchantDetailAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(str2, str3 != null ? str3 : "");
        }
    }
}
