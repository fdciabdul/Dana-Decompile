package id.dana.wallet_v3.view.addasset.viewholder;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.griver.core.GriverParams;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.NewLayoutCustomGridviewBinding;
import id.dana.model.ThirdPartyService;
import id.dana.utils.ResourceUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B#\u0012\u0006\u0010)\u001a\u00020(\u0012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050%¢\u0006\u0004\b*\u0010+J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010 R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/wallet_v3/view/addasset/viewholder/AddAssetViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "Lid/dana/databinding/NewLayoutCustomGridviewBinding;", "item", "", "bindData", "(Lid/dana/model/ThirdPartyService;)V", "", "amcsKey", "formalizeResourceData", "(Ljava/lang/String;)Ljava/lang/String;", "name", "formalizeResourceName", "data", "formalizeResourceTitle", "(Lid/dana/model/ThirdPartyService;)Ljava/lang/String;", "resourceName", "", "getDrawableResourceId", "(Ljava/lang/String;)I", "getDrawableResourceIdStartsWithIcon", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/NewLayoutCustomGridviewBinding;", "url", "defaultIconDrawableId", "loadPngImageToIconImageView", "(Ljava/lang/String;I)V", GriverParams.ShareParams.IMAGE_URL, "loadSvgImageToIconImageView", "(Ljava/lang/String;)V", "key", "setAssetContentDescription", "value", "setIconContentDescription", "Lkotlin/Function1;", "setLastAddedAssetType", "Lkotlin/jvm/functions/Function1;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AddAssetViewHolder extends ViewBindingRecyclerViewHolder<ThirdPartyService, NewLayoutCustomGridviewBinding> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String DEFAULT_LANGUAGE_CODE = "in";
    private static final String DRAWABLE = "drawable";
    private static final String ICON = "icon_";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory;
    private static long PlaceComponentResult;
    private final Function1<ThirdPartyService, Unit> setLastAddedAssetType;

    /* renamed from: $r8$lambda$Mz-uSNMIoP6_3TTS8Pjo2RQEzu0 */
    public static /* synthetic */ void m3101$r8$lambda$MzuSNMIoP6_3TTS8Pjo2RQEzu0(AddAssetViewHolder addAssetViewHolder, ThirdPartyService thirdPartyService, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        try {
            m3102bindData$lambda1$lambda0(addAssetViewHolder, thirdPartyService, i);
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        try {
            PlaceComponentResult();
            INSTANCE = new Companion(null);
            try {
                int i = MyBillsEntityDataFactory + 21;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void PlaceComponentResult() {
        PlaceComponentResult = 2196958901125334108L;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* bridge */ /* synthetic */ void bindData(Object obj) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 != 0) {
                try {
                    bindData((ThirdPartyService) obj);
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                bindData((ThirdPartyService) obj);
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ NewLayoutCustomGridviewBinding initViewBinding(View view) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            NewLayoutCustomGridviewBinding initViewBinding = initViewBinding(view);
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    return initViewBinding;
                }
                Object obj = null;
                obj.hashCode();
                return initViewBinding;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AddAssetViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function1<? super id.dana.model.ThirdPartyService, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559434(0x7f0d040a, float:1.8744212E38)
            r2.<init>(r1, r0, r3)
            r2.setLastAddedAssetType = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.viewholder.AddAssetViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    protected final NewLayoutCustomGridviewBinding initViewBinding(View view) {
        NewLayoutCustomGridviewBinding BuiltInFictitiousFunctionClassFactory;
        int i = MyBillsEntityDataFactory + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 19 : '`') != 19) {
            Intrinsics.checkNotNullParameter(view, "");
            BuiltInFictitiousFunctionClassFactory = NewLayoutCustomGridviewBinding.BuiltInFictitiousFunctionClassFactory(view);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        } else {
            try {
                Intrinsics.checkNotNullParameter(view, "");
                BuiltInFictitiousFunctionClassFactory = NewLayoutCustomGridviewBinding.BuiltInFictitiousFunctionClassFactory(view);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                int i2 = 89 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = MyBillsEntityDataFactory + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void bindData(final ThirdPartyService item) {
        super.bindData((AddAssetViewHolder) item);
        if (item != null) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(formalizeResourceTitle(item));
            String str = item.GetContactSyncConfig;
            int drawableResourceIdStartsWithIcon = getDrawableResourceIdStartsWithIcon(item.FragmentBottomSheetPaymentSettingBinding);
            if (SvgLoader.getAuthRequestContext(str)) {
                if ((str == null ? (char) 28 : Typography.greater) != '>') {
                    try {
                        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                        MyBillsEntityDataFactory = i % 128;
                        int i2 = i % 2;
                        str = "";
                    } catch (Exception e) {
                        throw e;
                    }
                }
                loadSvgImageToIconImageView(str);
            } else {
                if (str == null) {
                    try {
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
                        MyBillsEntityDataFactory = i3 % 128;
                        if ((i3 % 2 != 0 ? '*' : (char) 2) == '*') {
                            Object[] objArr = null;
                            int length = objArr.length;
                        }
                        str = "";
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                loadPngImageToIconImageView(str, drawableResourceIdStartsWithIcon);
            }
            setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.wallet_v3.view.addasset.viewholder.AddAssetViewHolder$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i4) {
                    AddAssetViewHolder.m3101$r8$lambda$MzuSNMIoP6_3TTS8Pjo2RQEzu0(AddAssetViewHolder.this, item, i4);
                }
            });
            setAssetContentDescription(item.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        MyBillsEntityDataFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    /* renamed from: bindData$lambda-1$lambda-0 */
    private static final void m3102bindData$lambda1$lambda0(AddAssetViewHolder addAssetViewHolder, ThirdPartyService thirdPartyService, int i) {
        int i2 = MyBillsEntityDataFactory + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(addAssetViewHolder, "");
        addAssetViewHolder.setLastAddedAssetType.invoke(thirdPartyService);
        int i4 = MyBillsEntityDataFactory + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (i4 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private final String formalizeResourceTitle(ThirdPartyService data) {
        String str = "";
        if ((Intrinsics.areEqual(Locale.getDefault().getLanguage(), new Locale("in").getLanguage()) ? 'G' : ')') == 'G') {
            int i = MyBillsEntityDataFactory + 95;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if ((data.NetworkUserEntityData$$ExternalSyntheticLambda3 != null ? (char) 11 : (char) 16) == 11) {
                try {
                    str = data.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return formalizeResourceData(str);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        String str2 = data.FragmentBottomSheetPaymentSettingBinding;
        if (str2 != null) {
            try {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                String PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(context, str2, str2);
                if ((PlaceComponentResult2 == null ? '_' : '3') != '_') {
                    str = PlaceComponentResult2;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return formalizeResourceData(str);
    }

    private final void setAssetContentDescription(String key) {
        switch (key.hashCode()) {
            case -1737744515:
                if (key.equals("service_deals")) {
                    String string = getContext().getString(R.string.wallet_ic_deals_voucher);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    setIconContentDescription(string);
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    return;
                }
                return;
            case -1734676042:
                if (key.equals("service_goals")) {
                    String string2 = getContext().getString(R.string.wallet_ic_goals);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    setIconContentDescription(string2);
                    return;
                }
                return;
            case -1048332355:
                if (key.equals("service_aplus_reward")) {
                    String string3 = getContext().getString(R.string.wallet_ic_rewards_voucher);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    setIconContentDescription(string3);
                    return;
                }
                return;
            case -411980612:
                if ((key.equals("service_loyalty") ? '/' : '\t') != '\t') {
                    int i3 = MyBillsEntityDataFactory + 75;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    String string4 = getContext().getString(R.string.wallet_icn_loyalty);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    setIconContentDescription(string4);
                    return;
                }
                return;
            case 359621868:
                if (key.equals("service_ektp")) {
                    String string5 = getContext().getString(R.string.wallet_icn_ktp);
                    Intrinsics.checkNotNullExpressionValue(string5, "");
                    setIconContentDescription(string5);
                    return;
                }
                return;
            case 359623204:
                Object[] objArr = new Object[1];
                a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 7296, new char[]{38252, 35323, 44143, 49386, 59250, 7161, 15996, 21191, 29042, 38395, 34932, 44263}, objArr);
                if (!(key.equals(((String) objArr[0]).intern()))) {
                    return;
                }
                String string6 = getContext().getString(R.string.wallet_ic_emas);
                Intrinsics.checkNotNullExpressionValue(string6, "");
                setIconContentDescription(string6);
                return;
            case 589911593:
                if (key.equals("service_bank_card")) {
                    String string7 = getContext().getString(R.string.wallet_icn_bank_cards);
                    Intrinsics.checkNotNullExpressionValue(string7, "");
                    setIconContentDescription(string7);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void setIconContentDescription(String value) {
        int i = MyBillsEntityDataFactory + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        getBinding().getAuthRequestContext.setContentDescription(value);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private final void loadSvgImageToIconImageView(String r3) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$22 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = r3;
        KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.service_skeleton_circle;
        KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = (AppCompatImageView) this.itemView.findViewById(R.id.custom_gridview_image);
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$22, (byte) 0);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? (byte) 1 : (byte) 0) != 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void loadPngImageToIconImageView(String url, int defaultIconDrawableId) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'W' : (char) 18) != 'W') {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(url).getErrorConfigVersion((int) R.drawable.service_skeleton_circle).PlaceComponentResult(defaultIconDrawableId).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.custom_gridview_image)));
            return;
        }
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(url).getErrorConfigVersion((int) R.drawable.service_skeleton_circle).PlaceComponentResult(defaultIconDrawableId).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.custom_gridview_image)));
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final int getDrawableResourceId(String resourceName) {
        int identifier;
        try {
            if (TextUtils.isEmpty(resourceName)) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
                try {
                    MyBillsEntityDataFactory = i % 128;
                    identifier = i % 2 == 0 ? 0 : 1;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                identifier = getContext().getResources().getIdentifier(resourceName, DRAWABLE, getContext().getPackageName());
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
            MyBillsEntityDataFactory = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int i3 = 22 / 0;
                return identifier;
            }
            return identifier;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final int getDrawableResourceIdStartsWithIcon(String resourceName) {
        StringBuilder sb = new StringBuilder();
        sb.append(ICON);
        sb.append(formalizeResourceName(resourceName));
        int drawableResourceId = getDrawableResourceId(sb.toString());
        int i = MyBillsEntityDataFactory + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return drawableResourceId;
        }
        return drawableResourceId;
    }

    private final String formalizeResourceName(String name) {
        String str;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (name != null) {
            String replace = new Regex(" ").replace(name, "_");
            if (replace != null) {
                try {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    try {
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "");
                        str = replace.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                        MyBillsEntityDataFactory = i5 % 128;
                        int i6 = i5 % 2;
                        return str;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        str = null;
        int i52 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        MyBillsEntityDataFactory = i52 % 128;
        int i62 = i52 % 2;
        return str;
    }

    private final String formalizeResourceData(String amcsKey) {
        if ((TextUtils.isEmpty(amcsKey) ? '\\' : 'M') != '\\') {
            ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
            int PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(getContext(), formalizeResourceName(amcsKey));
            if ((PlaceComponentResult2 > 0 ? (char) 18 : '1') != 18) {
                return amcsKey;
            }
            String string = getContext().getString(PlaceComponentResult2);
            int i = MyBillsEntityDataFactory + 37;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return string;
        }
        int i3 = MyBillsEntityDataFactory + 115;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return "";
        }
        return "";
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? InputCardNumberView.DIVIDER : Typography.greater) != ' ') {
                break;
            }
            try {
                try {
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (PlaceComponentResult ^ 4796183387843776835L);
                    getonboardingscenario.getAuthRequestContext++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                String str = new String(cArr2);
                int i2 = $10 + 7;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                objArr[0] = str;
                return;
            }
            int i4 = $10 + 119;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
    }
}
