package id.dana.referral;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.base.SingleClickListener;
import id.dana.component.buttoncomponent.BaseDanaButton;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.model.ReferralWidgetModel;
import id.dana.notification.DanaFirebaseMessagingService;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.ResourceUtils;
import id.dana.utils.android.IntentUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0002=>B'\b\u0016\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u0007¢\u0006\u0004\b9\u0010:B+\b\u0016\u0012\u0006\u00105\u001a\u000204\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00108\u001a\u00020\u0007\u0012\u0006\u0010;\u001a\u00020\u0007¢\u0006\u0004\b9\u0010<J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u0015J\u001b\u0010\u001e\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b!\u0010\u0015J\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\fJ\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0010\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00100R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103"}, d2 = {"Lid/dana/referral/ReferralCodeSectionView;", "Lid/dana/base/BaseRichView;", "", "Lid/dana/model/ReferralWidgetModel;", "p0", "PlaceComponentResult", "(Ljava/util/List;)Lid/dana/model/ReferralWidgetModel;", "", "getLayout", "()I", "", "hideSkeleton", "()V", "onShareReferralCodeClicked", "Lid/dana/component/buttoncomponent/BaseDanaButton;", "p1", "MyBillsEntityDataFactory", "(Lid/dana/component/buttoncomponent/BaseDanaButton;Lid/dana/model/ReferralWidgetModel;)V", "", "deepLinkReferral", "setDeepLinkReferral", "(Ljava/lang/String;)V", "getAuthRequestContext", "Lid/dana/referral/ReferralCodeSectionView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/referral/ReferralCodeSectionView$Listener;)V", "message", "setMessage", "referralButtons", "setReferralButtons", "(Ljava/util/List;)V", "referralCode", "setReferralCode", "", DanaFirebaseMessagingService.EMPTY, "setReferralContainerBottomPadding", "(Z)V", "referred", "setReferralTracker", "(I)V", "setup", "showSkeleton", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/referral/ReferralCodeSectionView$Listener;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "lookAheadTest", "getErrorConfigVersion", "I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralCodeSectionView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Listener PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    private String getAuthRequestContext;
    private int getErrorConfigVersion;
    private SkeletonScreen lookAheadTest;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/referral/ReferralCodeSectionView$Listener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory(String p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReferralCodeSectionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReferralCodeSectionView(Context context, AttributeSet attributeSet) {
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
        return R.layout.cardview_referral_code;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferralCodeSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
    }

    public /* synthetic */ ReferralCodeSectionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferralCodeSectionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_share);
        if (linearLayout != null) {
            final BaseActivity baseActivity = getBaseActivity();
            linearLayout.setOnClickListener(new SingleClickListener(baseActivity) { // from class: id.dana.referral.ReferralCodeSectionView$setup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(baseActivity);
                }

                @Override // id.dana.base.SingleClickListener
                public final void PlaceComponentResult(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReferralCodeSectionView.this.onShareReferralCodeClicked();
                }
            });
        }
    }

    public final void setListener(Listener listener) {
        this.PlaceComponentResult = listener;
    }

    public final void setReferralCode(String referralCode) {
        this.BuiltInFictitiousFunctionClassFactory = referralCode;
        String str = referralCode;
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_referral_code);
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(str);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_referral_code);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_share);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void setDeepLinkReferral(String deepLinkReferral) {
        this.getAuthRequestContext = deepLinkReferral;
    }

    public final void setReferralTracker(int referred) {
        this.getErrorConfigVersion = referred;
    }

    public final void setReferralButtons(List<? extends ReferralWidgetModel> referralButtons) {
        Intrinsics.checkNotNullParameter(referralButtons, "");
        if (referralButtons.isEmpty()) {
            return;
        }
        Iterator<? extends ReferralWidgetModel> it = referralButtons.iterator();
        byte b = 0;
        int i = 0;
        while (it.hasNext()) {
            if (it.next().PlaceComponentResult()) {
                i++;
            }
        }
        if (i == 2) {
            Group group = (Group) _$_findCachedViewById(R.id.group_double_referral_buttons);
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(0);
            Group group2 = (Group) _$_findCachedViewById(R.id.group_single_referral_button);
            Intrinsics.checkNotNullExpressionValue(group2, "");
            group2.setVisibility(8);
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_how_it_works);
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
            getAuthRequestContext(danaButtonSecondaryView, referralButtons.get(0));
            DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_my_progress);
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
            getAuthRequestContext(danaButtonSecondaryView2, referralButtons.get(1));
            return;
        }
        ReferralWidgetModel PlaceComponentResult = PlaceComponentResult(referralButtons);
        if (PlaceComponentResult(referralButtons) != null) {
            Group group3 = (Group) _$_findCachedViewById(R.id.group_double_referral_buttons);
            Intrinsics.checkNotNullExpressionValue(group3, "");
            group3.setVisibility(8);
            Group group4 = (Group) _$_findCachedViewById(R.id.group_single_referral_button);
            Intrinsics.checkNotNullExpressionValue(group4, "");
            group4.setVisibility(0);
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_single_referral_button);
            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
            DanaButtonPrimaryView danaButtonPrimaryView2 = danaButtonPrimaryView;
            MyBillsEntityDataFactory(danaButtonPrimaryView2, PlaceComponentResult);
            if (this.getErrorConfigVersion == 0) {
                EventTrackerModel.Builder MyBillsEntityDataFactory = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext()).MyBillsEntityDataFactory("Destination", "Referral Instruction");
                MyBillsEntityDataFactory.MyBillsEntityDataFactory = TrackerKey.Event.REFERRAL_SEE_MORE_ACTION;
                MyBillsEntityDataFactory.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
                if (TextUtils.isEmpty("/i/dana-promotion/referral-tracker/how-to")) {
                    return;
                }
                danaButtonPrimaryView2.setOnClickListener(new ReferralCodeSectionView$setButtonListener$1(this, "/i/dana-promotion/referral-tracker/how-to", getBaseActivity()));
                return;
            }
            EventTrackerModel.Builder MyBillsEntityDataFactory2 = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext()).MyBillsEntityDataFactory("Destination", "Referral Progress");
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory = TrackerKey.Event.REFERRAL_SEE_MORE_ACTION;
            MyBillsEntityDataFactory2.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, b));
            if (TextUtils.isEmpty("/i/dana-promotion/referral-tracker")) {
                return;
            }
            danaButtonPrimaryView2.setOnClickListener(new ReferralCodeSectionView$setButtonListener$1(this, "/i/dana-promotion/referral-tracker", getBaseActivity()));
        }
    }

    private static ReferralWidgetModel PlaceComponentResult(List<? extends ReferralWidgetModel> p0) {
        for (ReferralWidgetModel referralWidgetModel : p0) {
            if (referralWidgetModel.PlaceComponentResult()) {
                return referralWidgetModel;
            }
        }
        return null;
    }

    private final void getAuthRequestContext(BaseDanaButton p0, ReferralWidgetModel p1) {
        if (!p1.PlaceComponentResult() || TextUtils.isEmpty(p1.KClassImpl$Data$declaredNonStaticMembers$2)) {
            return;
        }
        MyBillsEntityDataFactory(p0, p1);
        String str = p1.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(str, "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p0.setOnClickListener(new ReferralCodeSectionView$setButtonListener$1(this, str, getBaseActivity()));
    }

    public final void setReferralContainerBottomPadding(boolean empty) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_referral_container);
        if (constraintLayout != null) {
            Resources resources = getResources();
            int i = R.dimen.f28012131165267;
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f28012131165267);
            Resources resources2 = getResources();
            if (empty) {
                i = R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055;
            }
            constraintLayout.setPadding(0, dimensionPixelSize, 0, resources2.getDimensionPixelSize(i));
        }
    }

    public final void hideSkeleton() {
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        SkeletonScreen skeletonScreen2 = this.lookAheadTest;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
    }

    public final void showSkeleton() {
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((TextView) _$_findCachedViewById(R.id.tv_referral_code));
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_referral_code_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            byte b = 0;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = viewSkeletonScreen;
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory2 = Skeleton.BuiltInFictitiousFunctionClassFactory((LinearLayout) _$_findCachedViewById(R.id.ll_share));
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext = R.layout.view_referral_code_skeleton;
            BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen2 = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory2, b);
            viewSkeletonScreen2.MyBillsEntityDataFactory();
            this.lookAheadTest = viewSkeletonScreen2;
            return;
        }
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
        SkeletonScreen skeletonScreen2 = this.lookAheadTest;
        if (skeletonScreen2 != null) {
            skeletonScreen2.MyBillsEntityDataFactory();
        }
    }

    public final void setMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "");
        this.MyBillsEntityDataFactory = message;
    }

    public static final /* synthetic */ void access$handleActionClicked(ReferralCodeSectionView referralCodeSectionView, String str) {
        Listener listener = referralCodeSectionView.PlaceComponentResult;
        if (listener != null) {
            listener.BuiltInFictitiousFunctionClassFactory(str);
        }
    }

    private final void MyBillsEntityDataFactory(BaseDanaButton p0, ReferralWidgetModel p1) {
        String str;
        String str2;
        if (p1 == null || (str2 = p1.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            str = null;
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String str3 = p1.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(str3, "");
            String upperCase = StringsKt.replace$default(str3, "_", " ", false, 4, (Object) null).toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            str = ResourceUtils.PlaceComponentResult(context, str2, upperCase);
        }
        p0.setActiveButton(str, null);
    }

    public final void onShareReferralCodeClicked() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REFERRER_INVITE_ATTEMPT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.INVITE_TYPE, TrackerKey.InviteType.SHARE_BUTTON);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        String str = this.MyBillsEntityDataFactory;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(str, Arrays.copyOf(new Object[]{this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        getContext().startActivity(Intent.createChooser(IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(format), getContext().getString(R.string.share_via)));
    }
}
