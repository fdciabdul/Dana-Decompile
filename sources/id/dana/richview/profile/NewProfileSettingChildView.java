package id.dana.richview.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewNewProfileSettingChildBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B'\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010.\u001a\u00020\t¢\u0006\u0004\b/\u00100B+\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010.\u001a\u00020\t\u0012\u0006\u00101\u001a\u00020\t¢\u0006\u0004\b/\u00102J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b!\u0010\u001cJO\u0010(\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010\u000eR\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010,"}, d2 = {"Lid/dana/richview/profile/NewProfileSettingChildView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewNewProfileSettingChildBinding;", "", "p0", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "getLayout", "()I", "", "hideReddot", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "async", IAPSyncCommand.COMMAND_INIT, "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewNewProfileSettingChildBinding;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "visibility", "setParentViewVisibility", "(I)V", "title", GriverEvents.EVENT_SET_TITLE, RVParams.LONG_SUB_TITLE, "name", "iconUrl", "hasReddot", "isShowNewBadge", "isSubtitleBelow", "setView", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZZ)V", "setup", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileSettingChildView extends ViewBindingRichView<ViewNewProfileSettingChildBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewProfileSettingChildView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewProfileSettingChildView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_new_profile_setting_child;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileSettingChildView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NewProfileSettingChildView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileSettingChildView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void init(Context context, AttributeSet attrs, boolean async) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attrs, "");
        super.init(context, attrs, async);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewNewProfileSettingChildBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewNewProfileSettingChildBinding MyBillsEntityDataFactory = ViewNewProfileSettingChildBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setView(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Boolean r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.profile.NewProfileSettingChildView.setView(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, boolean, boolean):void");
    }

    private static boolean getAuthRequestContext(String p0, String p1) {
        return StringsKt.indexOf$default((CharSequence) p0, p1, 0, false, 6, (Object) null) > 0;
    }

    private final void MyBillsEntityDataFactory(String p0) {
        String str = p0;
        if (str == null || str.length() == 0) {
            AppCompatTextView appCompatTextView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            appCompatTextView.setVisibility(8);
            return;
        }
        AppCompatTextView appCompatTextView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        appCompatTextView2.setVisibility(0);
        appCompatTextView2.setText(str);
    }

    public final void setTitle(String title) {
        if (title != null) {
            getBinding().lookAheadTest.setText(title);
        }
    }

    public final void hideReddot() {
        FrameLayout frameLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
    }

    public final void setParentViewVisibility(int visibility) {
        getBinding().getAuthRequestContext.setVisibility(visibility);
    }

    public static final /* synthetic */ void access$hideIconSkeleton(NewProfileSettingChildView newProfileSettingChildView) {
        SkeletonScreen skeletonScreen = newProfileSettingChildView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            Intrinsics.checkNotNull(skeletonScreen);
            skeletonScreen.PlaceComponentResult();
            newProfileSettingChildView.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        if (p0 == null || p1 == null) {
            return false;
        }
        String string = getResources().getString(R.string.security_setting_question_state_off);
        Intrinsics.checkNotNullExpressionValue(string, "");
        if (!Intrinsics.areEqual(string, p1)) {
            String string2 = getResources().getString(R.string.security_setting_email_unset);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            if (!Intrinsics.areEqual(string2, p1)) {
                String string3 = getResources().getString(R.string.change_name_non_kyc);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                if (!Intrinsics.areEqual(string3, p0)) {
                    return false;
                }
                if (!new Regex("\\d+").matches(p1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
