package id.dana.richview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001CB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010A\u001a\u00020\r¢\u0006\u0004\bB\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\nR*\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00118\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010%\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00058\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010$R*\u0010)\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR*\u00101\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020*8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u0010&\u001a\u0002028\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b3\u00104R*\u00108\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR*\u0010@\u001a\u0002092\u0006\u0010\u0018\u001a\u0002098\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?"}, d2 = {"Lid/dana/richview/HomeWidgetLinearBase;", "Lid/dana/base/BaseRichView;", "Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "getButtonView", "()Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "", "getLayout", "()I", "", "hideSkeletonLoading", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "titleDesc", "subtitleDesc", "buttonDesc", "setContentDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setup", "value", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", ErrorPageActivity.KEY_BUTTON_TEXT, "MyBillsEntityDataFactory", "I", "getButtonVisibility", "setButtonVisibility", "(I)V", "buttonVisibility", "KClassImpl$Data$declaredNonStaticMembers$2", "getDescriptionText", "setDescriptionText", "descriptionText", "Landroid/view/View$OnClickListener;", "PlaceComponentResult", "Landroid/view/View$OnClickListener;", "getOnButtonClickListener", "()Landroid/view/View$OnClickListener;", "setOnButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "onButtonClickListener", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getAuthRequestContext", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getErrorConfigVersion", "getTitleText", "setTitleText", "titleText", "", "lookAheadTest", "Z", "getWidgetHeaderVisible", "()Z", "setWidgetHeaderVisible", "(Z)V", "widgetHeaderVisible", "attributeSet", "<init>", "AutoDismissListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class HomeWidgetLinearBase extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String buttonText;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String descriptionText;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int buttonVisibility;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private View.OnClickListener onButtonClickListener;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String titleText;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean widgetHeaderVisible;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/HomeWidgetLinearBase$AutoDismissListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface AutoDismissListener {
    }

    /* renamed from: $r8$lambda$bgE-yt7a1oseHUDN3rmkNVx5ALc  reason: not valid java name */
    public static /* synthetic */ void m2806$r8$lambda$bgEyt7a1oseHUDN3rmkNVx5ALc(View view) {
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
        return R.layout.view_home_widget_linear_base;
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
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.cl_base_home_widget);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
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
    public HomeWidgetLinearBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.buttonText = "";
        this.widgetHeaderVisible = true;
        this.titleText = "";
        this.descriptionText = "";
        this.onButtonClickListener = new View.OnClickListener() { // from class: id.dana.richview.HomeWidgetLinearBase$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeWidgetLinearBase.m2806$r8$lambda$bgEyt7a1oseHUDN3rmkNVx5ALc(view);
            }
        };
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

    public final void hideSkeletonLoading() {
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
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
