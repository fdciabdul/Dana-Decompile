package id.dana.wallet_v3.view.search.viewholder;

import android.content.Context;
import android.media.AudioTrack;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.ItemWalletAssetSearchRecommendationBinding;
import id.dana.model.ThirdPartyService;
import id.dana.utils.StringWrapperKt;
import id.dana.wallet_v3.listener.AssetRecommendationClickListener;
import id.dana.wallet_v3.model.AssetSearchRecommendationModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.D;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/wallet_v3/view/search/viewholder/AssetSearchRecommendationViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "Lid/dana/databinding/ItemWalletAssetSearchRecommendationBinding;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "", "serviceType", "", "getImageDrawableRes", "(Ljava/lang/String;)I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ItemWalletAssetSearchRecommendationBinding;", "Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;", "assetRecommendationClickListener", "Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;Lid/dana/wallet_v3/listener/AssetRecommendationClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AssetSearchRecommendationViewHolder extends ViewBindingRecyclerViewHolder<WalletV3CardModel, ItemWalletAssetSearchRecommendationBinding> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static long getAuthRequestContext = -8200066783383480254L;
    private final AssetRecommendationClickListener assetRecommendationClickListener;

    public static /* synthetic */ void $r8$lambda$4vhLg1iKQ3NgH15iBkMR9xx2Vv4(WalletV3CardModel walletV3CardModel, AssetSearchRecommendationViewHolder assetSearchRecommendationViewHolder, View view) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 17;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            m3111bindData$lambda2$lambda1(walletV3CardModel, assetSearchRecommendationViewHolder, view);
            int i3 = MyBillsEntityDataFactory + 95;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AssetSearchRecommendationViewHolder(android.view.ViewGroup r1, id.dana.wallet_v3.listener.AssetRecommendationClickListener r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            r4 = 89
            if (r3 == 0) goto L9
            r3 = 86
            goto Lb
        L9:
            r3 = 89
        Lb:
            if (r3 == r4) goto L22
            int r2 = id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 79
            int r3 = r2 % 128
            id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder.MyBillsEntityDataFactory = r3
            int r2 = r2 % 2
            r2 = 0
            int r3 = id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 + 113
            int r4 = r3 % 128
            id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
        L22:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder.<init>(android.view.ViewGroup, id.dana.wallet_v3.listener.AssetRecommendationClickListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* bridge */ /* synthetic */ void bindData(Object obj) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 121;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            bindData((WalletV3CardModel) obj);
            int i3 = BuiltInFictitiousFunctionClassFactory + 3;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* bridge */ /* synthetic */ ItemWalletAssetSearchRecommendationBinding initViewBinding(View view) {
        try {
            int i = MyBillsEntityDataFactory + 99;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            char c = i % 2 == 0 ? 'B' : (char) 15;
            ItemWalletAssetSearchRecommendationBinding initViewBinding = initViewBinding(view);
            if (c == 'B') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 69;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return initViewBinding;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AssetSearchRecommendationViewHolder(android.view.ViewGroup r3, id.dana.wallet_v3.listener.AssetRecommendationClickListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559294(0x7f0d037e, float:1.8743928E38)
            r2.<init>(r1, r0, r3)
            r2.assetRecommendationClickListener = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder.<init>(android.view.ViewGroup, id.dana.wallet_v3.listener.AssetRecommendationClickListener):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    protected final ItemWalletAssetSearchRecommendationBinding initViewBinding(View view) {
        ItemWalletAssetSearchRecommendationBinding PlaceComponentResult;
        try {
            int i = MyBillsEntityDataFactory + 99;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            Object[] objArr = null;
            if (!(i % 2 != 0)) {
                Intrinsics.checkNotNullParameter(view, "");
                PlaceComponentResult = ItemWalletAssetSearchRecommendationBinding.PlaceComponentResult(view);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                int length = objArr.length;
            } else {
                Intrinsics.checkNotNullParameter(view, "");
                PlaceComponentResult = ItemWalletAssetSearchRecommendationBinding.PlaceComponentResult(view);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 115;
            MyBillsEntityDataFactory = i2 % 128;
            if ((i2 % 2 != 0 ? '\'' : 'B') != '\'') {
                return PlaceComponentResult;
            }
            objArr.hashCode();
            return PlaceComponentResult;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void bindData(final WalletV3CardModel item) {
        int i = MyBillsEntityDataFactory + 107;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        byte b = 0;
        Object[] objArr = null;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(item, "");
            boolean z = item instanceof AssetSearchRecommendationModel;
            int length = objArr.length;
            if (!z) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(item, "");
            if (!(item instanceof AssetSearchRecommendationModel)) {
                return;
            }
        }
        AssetSearchRecommendationModel assetSearchRecommendationModel = (AssetSearchRecommendationModel) item;
        String serviceType = assetSearchRecommendationModel.getServiceType();
        ItemWalletAssetSearchRecommendationBinding binding = getBinding();
        AppCompatTextView appCompatTextView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        appCompatTextView.setText(StringWrapperKt.getAuthRequestContext(context, assetSearchRecommendationModel.getTitle()));
        AppCompatTextView appCompatTextView2 = binding.MyBillsEntityDataFactory;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        appCompatTextView2.setText(StringWrapperKt.getAuthRequestContext(context2, assetSearchRecommendationModel.getDesc()));
        if (SvgLoader.getAuthRequestContext(assetSearchRecommendationModel.getImageUrl())) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = assetSearchRecommendationModel.getImageUrl();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = true;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = getImageDrawableRes(serviceType);
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = binding.getAuthRequestContext;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
        } else {
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(assetSearchRecommendationModel.getImageUrl()).MyBillsEntityDataFactory(getImageDrawableRes(serviceType)).MyBillsEntityDataFactory((ImageView) binding.getAuthRequestContext);
            int i2 = MyBillsEntityDataFactory + 11;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
        }
        DanaButtonSecondaryView danaButtonSecondaryView = binding.PlaceComponentResult;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "");
        danaButtonSecondaryView.setActiveButton(StringWrapperKt.getAuthRequestContext(context3, assetSearchRecommendationModel.getBtnTitle()), null);
        binding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.search.viewholder.AssetSearchRecommendationViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssetSearchRecommendationViewHolder.$r8$lambda$4vhLg1iKQ3NgH15iBkMR9xx2Vv4(WalletV3CardModel.this, this, view);
            }
        });
        int i4 = MyBillsEntityDataFactory + 23;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    /* renamed from: bindData$lambda-2$lambda-1 */
    private static final void m3111bindData$lambda2$lambda1(WalletV3CardModel walletV3CardModel, AssetSearchRecommendationViewHolder assetSearchRecommendationViewHolder, View view) {
        try {
            Intrinsics.checkNotNullParameter(walletV3CardModel, "");
            Intrinsics.checkNotNullParameter(assetSearchRecommendationViewHolder, "");
            AssetSearchRecommendationModel assetSearchRecommendationModel = (AssetSearchRecommendationModel) walletV3CardModel;
            ThirdPartyService thirdPartyService = assetSearchRecommendationModel.getThirdPartyService();
            Object[] objArr = null;
            if (thirdPartyService != null) {
                try {
                    AssetRecommendationClickListener assetRecommendationClickListener = assetSearchRecommendationViewHolder.assetRecommendationClickListener;
                    if (assetRecommendationClickListener != null) {
                        int i = MyBillsEntityDataFactory + 107;
                        BuiltInFictitiousFunctionClassFactory = i % 128;
                        if ((i % 2 == 0 ? 'O' : '[') != 'O') {
                            assetRecommendationClickListener.onCardClicked(thirdPartyService, assetSearchRecommendationModel.getSectionType());
                        } else {
                            assetRecommendationClickListener.onCardClicked(thirdPartyService, assetSearchRecommendationModel.getSectionType());
                            int length = objArr.length;
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 67;
            MyBillsEntityDataFactory = i2 % 128;
            if (i2 % 2 != 0) {
                int length2 = objArr.length;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final int getImageDrawableRes(String serviceType) {
        int i = BuiltInFictitiousFunctionClassFactory + 15;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        switch (serviceType.hashCode()) {
            case -1737744515:
                if (serviceType.equals("service_deals")) {
                    int i3 = MyBillsEntityDataFactory + 51;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    if (i3 % 2 == 0) {
                        Object obj = null;
                        obj.hashCode();
                    }
                    return R.drawable.img_voucher_search_recommendation;
                }
                return R.drawable.img_bank_search_recommendation;
            case -1734676042:
                if (serviceType.equals("service_goals")) {
                    int i4 = BuiltInFictitiousFunctionClassFactory + 77;
                    MyBillsEntityDataFactory = i4 % 128;
                    int i5 = i4 % 2;
                    return R.drawable.img_goals_search_recommendation;
                }
                return R.drawable.img_bank_search_recommendation;
            case -411980612:
                return serviceType.equals("service_loyalty") ? R.drawable.img_loyalty_search_recommendation : R.drawable.img_bank_search_recommendation;
            case 359621868:
                if (serviceType.equals("service_ektp")) {
                    int i6 = BuiltInFictitiousFunctionClassFactory + 55;
                    MyBillsEntityDataFactory = i6 % 128;
                    int i7 = i6 % 2;
                    return R.drawable.img_ktp_search_recommendation;
                }
                return R.drawable.img_bank_search_recommendation;
            case 359623204:
                Object[] objArr = new Object[1];
                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{13931, 13848, 30947, 44332, 6325, 45971, 53957, 21069, 24746, 21714, 6444, 1340, 39774, 64116, 16496, 64760}, objArr);
                return serviceType.equals(((String) objArr[0]).intern()) ? R.drawable.img_emas_search_recommedation : R.drawable.img_bank_search_recommendation;
            case 589911593:
                serviceType.equals("service_bank_card");
                return R.drawable.img_bank_search_recommendation;
            case 984076415:
                return serviceType.equals("service_dana_plus") ? R.drawable.img_dana_plus_search_recommendation : R.drawable.img_bank_search_recommendation;
            default:
                return R.drawable.img_bank_search_recommendation;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 41;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? '/' : Typography.greater) != '>') {
                try {
                    int i4 = $11 + 89;
                    try {
                        $10 = i4 % 128;
                        int i5 = i4 % 2;
                        d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                        KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                        d.MyBillsEntityDataFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                return;
            }
        }
    }
}
