package id.dana.richview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.extension.view.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u0001RB\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010P\u001a\u00020\u0014¢\u0006\u0004\bQ\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J#\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\r\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\bR*\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00188\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010,R*\u00101\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00188\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u0018\u0010!\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u00104R*\u0010<\u001a\u0002052\u0006\u0010 \u001a\u0002058\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010(\u001a\u00020=8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b>\u0010?R*\u0010C\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00188\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\"\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R*\u0010K\u001a\u00020D2\u0006\u0010 \u001a\u00020D8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR*\u0010O\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010)\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010,"}, d2 = {"Lid/dana/richview/HomeWidgetBase;", "Lid/dana/base/BaseRichView;", "Landroid/view/View;", "buttonView", "", "addCustomViewButton", "(Landroid/view/View;)V", "dismissWidget", "()V", "Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "getButtonView", "()Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "", "getLayout", "()I", "hideSkeletonLoading", "child", "onViewAdded", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "titleDesc", "subtitleDesc", "buttonDesc", "setContentDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setup", "showSkeletonLoading", "value", "PlaceComponentResult", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", ErrorPageActivity.KEY_BUTTON_TEXT, "BuiltInFictitiousFunctionClassFactory", "I", "getButtonVisibility", "setButtonVisibility", "(I)V", "buttonVisibility", "KClassImpl$Data$declaredNonStaticMembers$2", "getDescriptionText", "setDescriptionText", "descriptionText", "Lid/dana/richview/HomeWidgetBase$AutoDismissListener;", "getAuthRequestContext", "Lid/dana/richview/HomeWidgetBase$AutoDismissListener;", "Landroid/view/View$OnClickListener;", "MyBillsEntityDataFactory", "Landroid/view/View$OnClickListener;", "getOnButtonClickListener", "()Landroid/view/View$OnClickListener;", "setOnButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "onButtonClickListener", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getErrorConfigVersion", "Lcom/ethanhua/skeleton/SkeletonScreen;", "lookAheadTest", "getTitleText", "setTitleText", "titleText", "", "scheduleImpl", "Z", "getWidgetHeaderVisible", "()Z", "setWidgetHeaderVisible", "(Z)V", "widgetHeaderVisible", "moveToNextValue", "getWidgetSkeletonLayout", "setWidgetSkeletonLayout", "widgetSkeletonLayout", "attributeSet", "<init>", "AutoDismissListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class HomeWidgetBase extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int buttonVisibility;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String descriptionText;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private View.OnClickListener onButtonClickListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String buttonText;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private AutoDismissListener PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String titleText;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int widgetSkeletonLayout;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean widgetHeaderVisible;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/HomeWidgetBase$AutoDismissListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface AutoDismissListener {
    }

    public static /* synthetic */ void $r8$lambda$oGxXG5PEuwdieAtziWZ2oweJ1iI(View view) {
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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
    public int getLayout() {
        return R.layout.view_home_widget_base;
    }

    @JvmName(name = "getButtonText")
    public final String getButtonText() {
        return this.buttonText;
    }

    @JvmName(name = "setButtonText")
    public final void setButtonText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.buttonText = str;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.ReferralMapper_Factory_res_0x7f0a024f);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setActiveButton(str, null);
        }
    }

    @JvmName(name = "getButtonVisibility")
    public final int getButtonVisibility() {
        return this.buttonVisibility;
    }

    @JvmName(name = "setButtonVisibility")
    public final void setButtonVisibility(int i) {
        this.buttonVisibility = i;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.ReferralMapper_Factory_res_0x7f0a024f);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setVisibility(i);
        }
    }

    @JvmName(name = "getWidgetHeaderVisible")
    public final boolean getWidgetHeaderVisible() {
        return this.widgetHeaderVisible;
    }

    @JvmName(name = "setWidgetHeaderVisible")
    public final void setWidgetHeaderVisible(boolean z) {
        this.widgetHeaderVisible = z;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_base_home_widget);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(z ? 0 : 8);
        }
    }

    @JvmName(name = "getWidgetSkeletonLayout")
    public final int getWidgetSkeletonLayout() {
        return this.widgetSkeletonLayout;
    }

    @JvmName(name = "setWidgetSkeletonLayout")
    public final void setWidgetSkeletonLayout(int i) {
        this.widgetSkeletonLayout = i;
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) _$_findCachedViewById(R.id.cl_base_home_widget));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = i;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
        ViewSkeletonScreen viewSkeletonScreen2 = viewSkeletonScreen;
        this.BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen2;
        viewSkeletonScreen2.PlaceComponentResult();
    }

    @JvmName(name = "getTitleText")
    public final String getTitleText() {
        return this.titleText;
    }

    @JvmName(name = "setTitleText")
    public final void setTitleText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.titleText = str;
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_widget_title);
        if (textView != null) {
            textView.setText(str);
        }
    }

    @JvmName(name = "getDescriptionText")
    public final String getDescriptionText() {
        return this.descriptionText;
    }

    @JvmName(name = "setDescriptionText")
    public final void setDescriptionText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.descriptionText = str;
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_widget_description);
        if (textView != null) {
            textView.setText(str);
        }
    }

    @JvmName(name = "getOnButtonClickListener")
    public final View.OnClickListener getOnButtonClickListener() {
        return this.onButtonClickListener;
    }

    @JvmName(name = "setOnButtonClickListener")
    public final void setOnButtonClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.onButtonClickListener = onClickListener;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.ReferralMapper_Factory_res_0x7f0a024f);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeWidgetBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.buttonText = "";
        this.widgetHeaderVisible = true;
        this.widgetSkeletonLayout = R.layout.default_home_widget_skeleton;
        this.titleText = "";
        this.descriptionText = "";
        this.onButtonClickListener = new View.OnClickListener() { // from class: id.dana.richview.HomeWidgetBase$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeWidgetBase.$r8$lambda$oGxXG5PEuwdieAtziWZ2oweJ1iI(view);
            }
        };
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.vg_home_widget_base_container);
            if (!(frameLayout != null && childAt.getId() == frameLayout.getId())) {
                removeViewAt(i);
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_home_widget_base);
                if (linearLayout != null) {
                    linearLayout.addView(childAt);
                }
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attrs) {
        Resources.Theme theme;
        super.parseAttrs(context, attrs);
        if (attrs != null) {
            TypedArray obtainStyledAttributes = (context == null || (theme = context.getTheme()) == null) ? null : theme.obtainStyledAttributes(attrs, R.styleable.access$setShowcaseShowing$p, 0, 0);
            if (obtainStyledAttributes != null) {
                String string = obtainStyledAttributes.getString(1);
                if (string == null) {
                    string = "";
                }
                setButtonText(string);
                String string2 = obtainStyledAttributes.getString(10);
                if (string2 == null) {
                    string2 = "";
                }
                setTitleText(string2);
                String string3 = obtainStyledAttributes.getString(3);
                if (string3 == null) {
                    string3 = "";
                }
                setDescriptionText(string3);
                setButtonVisibility(obtainStyledAttributes.getBoolean(2, false) ? 0 : 8);
                setWidgetHeaderVisible(obtainStyledAttributes.getBoolean(4, true));
                setWidgetSkeletonLayout(obtainStyledAttributes.getResourceId(7, R.layout.default_home_widget_skeleton));
                float dimension = obtainStyledAttributes.getDimension(6, getResources().getDimension(R.dimen.f30412131165621));
                float dimension2 = obtainStyledAttributes.getDimension(5, getResources().getDimension(R.dimen.f30412131165621));
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_home_widget_base);
                if (linearLayout != null) {
                    linearLayout.setPadding(0, (int) dimension, 0, (int) dimension2);
                }
                String string4 = obtainStyledAttributes.getString(9);
                if (string4 == null) {
                    string4 = "";
                }
                String string5 = obtainStyledAttributes.getString(8);
                if (string5 == null) {
                    string5 = "";
                }
                String string6 = obtainStyledAttributes.getString(0);
                setContentDescription(string4, string5, string6 != null ? string6 : "");
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void showSkeletonLoading() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.MyBillsEntityDataFactory();
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) _$_findCachedViewById(R.id.cl_base_home_widget));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = this.widgetSkeletonLayout;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
        this.BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen;
    }

    public final void hideSkeletonLoading() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.PlaceComponentResult();
        }
    }

    public final DanaButtonSecondaryView getButtonView() {
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.ReferralMapper_Factory_res_0x7f0a024f);
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        return danaButtonSecondaryView;
    }

    public final void addCustomViewButton(View buttonView) {
        Intrinsics.checkNotNullParameter(buttonView, "");
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.MePageRevampPresenter_Factory);
        if (frameLayout != null) {
            frameLayout.addView(buttonView);
        }
        removeViewInLayout((DanaButtonSecondaryView) _$_findCachedViewById(R.id.ReferralMapper_Factory_res_0x7f0a024f));
    }

    public final void dismissWidget() {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.vg_home_widget_base_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void setContentDescription(String titleDesc, String subtitleDesc, String buttonDesc) {
        Intrinsics.checkNotNullParameter(titleDesc, "");
        Intrinsics.checkNotNullParameter(subtitleDesc, "");
        Intrinsics.checkNotNullParameter(buttonDesc, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_widget_title);
        if (textView != null) {
            textView.setContentDescription(titleDesc);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_widget_description);
        if (textView2 != null) {
            textView2.setContentDescription(subtitleDesc);
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.ReferralMapper_Factory_res_0x7f0a024f);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setContentDescription(buttonDesc);
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        ConstraintLayout constraintLayout = (ConstraintLayout) getButtonView().findViewById(R.id.res_0x7f0a041e_networkuserentitydata_externalsyntheticlambda1);
        if (constraintLayout != null) {
            ViewExtKt.BuiltInFictitiousFunctionClassFactory(constraintLayout, 0, null, 0, null, 10);
        }
    }
}
