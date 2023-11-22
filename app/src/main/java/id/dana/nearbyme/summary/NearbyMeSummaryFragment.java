package id.dana.nearbyme.summary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseFragment;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNearbyMeSummaryComponent;
import id.dana.di.component.NearbyMeSummaryComponent;
import id.dana.nearbyme.NearbyMeActivity;
import id.dana.nearbyme.model.ShopModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.ImageOss;
import id.dana.utils.ResourceUtils;
import id.dana.utils.TagFormat;
import id.dana.utils.TextUtil;
import id.dana.utils.showcase.Utils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes9.dex */
public class NearbyMeSummaryFragment extends BaseFragment {
    public static final byte[] $$a = {TarHeader.LF_DIR, 93, -14, -126, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 171;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {90, -83, 93, -67, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 200;
    ShopModel MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    @BindView(R.id.f3533JsonParseException_res_0x7f0a023e)
    Button btnTopUp;
    @BindView(R.id.cl_nearby_me_empty)
    ConstraintLayout clNearbyMeEmpty;
    @BindView(R.id.cl_nearby_me_normal)
    ConstraintLayout clNearbyMeNormal;
    @BindView(R.id.cl_ribbon_container)
    ViewGroup clRibbonContainer;
    @BindView(R.id.f3743divider_promo_ribbon)
    View dividerPromoRibbon;
    private boolean getErrorConfigVersion;
    @BindView(R.id.iv_empty_image)
    ImageView ivEmptyImage;
    @BindView(R.id.iv_store_image)
    ImageView ivStoreImage;
    @BindView(R.id.iv_view_nearby_me_summary_info_icon)
    ImageView ivViewNearbyMeSummaryInfoIcon;
    private int lookAheadTest = 0;
    @BindView(R.id.lottie_nearby_ribbon)
    LottieAnimationView lottieNearbyRibbon;
    private NearbyMeSummaryComponent moveToNextValue;
    private String scheduleImpl;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_empty_description)
    TextView tvEmptyDescription;
    @BindView(R.id.tv_empty_title)
    TextView tvEmptyTitle;
    @BindView(R.id.tv_merchant_sub_category)
    TextView tvMerchantSubCategory;
    @BindView(R.id.tv_ribbon_line_bottom)
    TextView tvRibbonLineBottom;
    @BindView(R.id.tv_ribbon_line_top)
    TextView tvRibbonLineTop;
    @BindView(R.id.tv_store_distance)
    TextView tvStoreDistance;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.nearbyme.summary.NearbyMeSummaryFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 15
            int r7 = 19 - r7
            int r6 = r6 * 2
            int r6 = 16 - r6
            int r8 = r8 + 105
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r8]
            int r3 = r3 + 1
        L2c:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + 2
            int r8 = r8 + 1
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.summary.NearbyMeSummaryFragment.a(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 4
            int r8 = r8 + 75
            int r9 = r9 * 3
            int r9 = r9 + 4
            int r7 = r7 * 4
            int r7 = r7 + 42
            byte[] r0 = id.dana.nearbyme.summary.NearbyMeSummaryFragment.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L34:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.summary.NearbyMeSummaryFragment.b(int, int, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.view_nearby_me_summary;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            Object[] objArr = new Object[1];
            a(b, b, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.indexOf("", "", 0, 0), View.MeasureSpec.getMode(0) + 4, (char) View.getDefaultSize(0, 0));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), ExpandableListView.getPackedPositionType(0L) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1988161646, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 18 - KeyEvent.keyCodeFromString(""), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(bundle);
                if (KClassImpl$Data$declaredNonStaticMembers$2(getArguments())) {
                    this.MyBillsEntityDataFactory = (ShopModel) getArguments().getParcelable("MERCHANT_PARCELABLE");
                    this.lookAheadTest = getArguments().getInt("PAGE_POSITION_ON_ADAPTER", 0);
                }
                if (bundle != null) {
                    this.PlaceComponentResult = bundle.getBoolean("SAVED_INSTANCE_KEY_DONE_PLAYING", false);
                }
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

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("SAVED_INSTANCE_KEY_DONE_PLAYING", this.PlaceComponentResult);
        super.onSaveInstanceState(bundle);
    }

    @Override // id.dana.base.BaseFragment
    public void onSelected() {
        super.onSelected();
        ShopModel shopModel = this.MyBillsEntityDataFactory;
        if (shopModel != null) {
            PlaceComponentResult(shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7(), true);
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
        return (bundle == null || bundle.getBoolean("EMPTY_MERCHANT") || bundle.getBoolean("LOADING_VIEW")) ? false : true;
    }

    private void getAuthRequestContext() {
        if (this.tvRibbonLineTop != null) {
            String scheduleImpl = this.MyBillsEntityDataFactory.scheduleImpl();
            this.tvRibbonLineTop.setText(ResourceUtils.PlaceComponentResult(getContext(), scheduleImpl, scheduleImpl));
        }
        if (this.tvRibbonLineBottom != null) {
            this.tvRibbonLineBottom.setText(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
    }

    private void PlaceComponentResult(boolean z, boolean z2) {
        long j = z2 ? 0L : 150L;
        this.clRibbonContainer.setVisibility(z ? 0 : 8);
        this.dividerPromoRibbon.setVisibility(z ? 0 : 8);
        if (z) {
            getAuthRequestContext();
            LottieAnimationView lottieAnimationView = this.lottieNearbyRibbon;
            if (lottieAnimationView != null && !this.PlaceComponentResult) {
                lottieAnimationView.postDelayed(new Runnable() { // from class: id.dana.nearbyme.summary.NearbyMeSummaryFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        NearbyMeSummaryFragment nearbyMeSummaryFragment = NearbyMeSummaryFragment.this;
                        LottieAnimationView lottieAnimationView2 = nearbyMeSummaryFragment.lottieNearbyRibbon;
                        if (lottieAnimationView2 != null) {
                            lottieAnimationView2.playAnimation();
                        }
                        nearbyMeSummaryFragment.getAuthRequestContext(false);
                    }
                }, j);
            } else {
                getAuthRequestContext(true);
            }
            this.getErrorConfigVersion = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(boolean z) {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        if (z) {
            this.tvRibbonLineTop.setAlpha(1.0f);
            this.tvRibbonLineBottom.setAlpha(1.0f);
            this.ivViewNearbyMeSummaryInfoIcon.setAlpha(1.0f);
            this.PlaceComponentResult = true;
            return;
        }
        this.tvRibbonLineTop.postDelayed(new Runnable() { // from class: id.dana.nearbyme.summary.NearbyMeSummaryFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NearbyMeSummaryFragment nearbyMeSummaryFragment = NearbyMeSummaryFragment.this;
                NearbyMeSummaryFragment.getAuthRequestContext(nearbyMeSummaryFragment.tvRibbonLineTop);
                NearbyMeSummaryFragment.getAuthRequestContext(nearbyMeSummaryFragment.tvRibbonLineBottom);
                NearbyMeSummaryFragment.getAuthRequestContext(nearbyMeSummaryFragment.ivViewNearbyMeSummaryInfoIcon);
                nearbyMeSummaryFragment.PlaceComponentResult = true;
            }
        }, 350L);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.tvRibbonLineTop == null || this.tvRibbonLineBottom == null || this.ivViewNearbyMeSummaryInfoIcon == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(View view) {
        if (view != null) {
            view.animate().alpha(1.0f).start();
        }
    }

    @OnClick({R.id.f3533JsonParseException_res_0x7f0a023e})
    public void onTopUpClicked() {
        DanaH5.startContainerFullUrl(this.scheduleImpl);
    }

    @OnClick({R.id.f3513xb184aa5d})
    public void onDirectionClicked() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(getContext().getString(R.string.google_navigation_uri), String.valueOf(this.MyBillsEntityDataFactory.DatabaseTableConfigUtil), String.valueOf(this.MyBillsEntityDataFactory.PrepareContext))));
        intent.setPackage("com.google.android.apps.maps");
        if (Utils.getAuthRequestContext(getContext(), intent)) {
            startActivity(intent);
        }
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        ShopModel shopModel;
        if (this.moveToNextValue == null) {
            DaggerNearbyMeSummaryComponent.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DaggerNearbyMeSummaryComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory, ApplicationComponent.class);
            ApplicationComponent applicationComponent = KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory;
            this.moveToNextValue = new DaggerNearbyMeSummaryComponent.NearbyMeSummaryComponentImpl();
        }
        if (getArguments() != null) {
            byte b = 0;
            if (!KClassImpl$Data$declaredNonStaticMembers$2(getArguments()) || (shopModel = this.MyBillsEntityDataFactory) == null) {
                if (getArguments().getBoolean("LOADING_VIEW")) {
                    ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.clNearbyMeNormal);
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_nearby_me_summary_skeleton;
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
                    BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
                    BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
                    new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b).MyBillsEntityDataFactory();
                    return;
                }
                if (getArguments() != null && getArguments().getBoolean("EMPTY_MERCHANT_ON_ERROR")) {
                    InstrumentInjector.Resources_setImageResource(this.ivEmptyImage, R.drawable.ic_bad_internet_connection);
                    this.tvEmptyTitle.setText(R.string.nearby_me_error_title);
                    this.tvEmptyDescription.setText(R.string.nearby_me_error_description);
                }
                this.clNearbyMeNormal.setVisibility(8);
                this.clNearbyMeEmpty.setVisibility(0);
            } else if (shopModel != null) {
                if (shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    getAuthRequestContext();
                    if (this.lookAheadTest == 0 || getUserVisibleHint()) {
                        PlaceComponentResult(true, false);
                    }
                }
                this.lottieNearbyRibbon.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.summary.NearbyMeSummaryFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NearbyMeSummaryFragment nearbyMeSummaryFragment = NearbyMeSummaryFragment.this;
                        if (nearbyMeSummaryFragment.getActivity() != null) {
                            ((NearbyMeActivity) nearbyMeSummaryFragment.getActivity()).showPromoBottomSheet(nearbyMeSummaryFragment.MyBillsEntityDataFactory.getCallingPid);
                        }
                    }
                });
                String authRequestContext = shopModel.getAuthRequestContext(true, " ");
                this.tvStoreName.setText(shopModel.newProxyInstance);
                if (!TextUtils.isEmpty(authRequestContext)) {
                    this.tvMerchantSubCategory.setText(authRequestContext);
                } else {
                    this.tvMerchantSubCategory.setVisibility(8);
                }
                this.tvDescription.setText(shopModel.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult);
                this.tvStoreDistance.setText(TextUtil.PlaceComponentResult(getContext(), shopModel.getErrorConfigVersion));
                final String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (SvgLoader.getAuthRequestContext(str)) {
                    SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$23 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                    KClassImpl$Data$declaredNonStaticMembers$23.BuiltInFictitiousFunctionClassFactory = str;
                    KClassImpl$Data$declaredNonStaticMembers$23.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.marker_placeholder;
                    KClassImpl$Data$declaredNonStaticMembers$23.PlaceComponentResult = this.ivStoreImage;
                    new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$23, b);
                } else {
                    ImageOss.MyBillsEntityDataFactory(str, this.ivStoreImage, new ImageOss.EventListener() { // from class: id.dana.nearbyme.summary.NearbyMeSummaryFragment$$ExternalSyntheticLambda2
                        @Override // id.dana.utils.ImageOss.EventListener
                        public final void PlaceComponentResult(String str2, ImageView imageView) {
                            NearbyMeSummaryFragment nearbyMeSummaryFragment = NearbyMeSummaryFragment.this;
                            String str3 = str;
                            if (nearbyMeSummaryFragment.isAdded()) {
                                GlideApp.PlaceComponentResult(nearbyMeSummaryFragment.getActivity()).PlaceComponentResult(str3).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.marker_placeholder).PlaceComponentResult((int) R.drawable.marker_placeholder).MyBillsEntityDataFactory(nearbyMeSummaryFragment.ivStoreImage);
                            }
                        }
                    });
                }
                if (shopModel.newProxyInstance()) {
                    this.btnTopUp.setVisibility(0);
                    this.scheduleImpl = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}&payMethod=OTC&instId={instId}&fromSKW=true").MyBillsEntityDataFactory("instId", shopModel.GetContactSyncConfig).MyBillsEntityDataFactory("entryPoint", TopupSource.NEARBY).MyBillsEntityDataFactory();
                    return;
                }
                this.btnTopUp.setVisibility(8);
            }
        }
    }
}
