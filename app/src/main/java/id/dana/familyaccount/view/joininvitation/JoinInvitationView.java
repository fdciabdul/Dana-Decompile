package id.dana.familyaccount.view.joininvitation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewJoinInvitationBinding;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/familyaccount/view/joininvitation/JoinInvitationView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewJoinInvitationBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewJoinInvitationBinding;", "", "initInvitationView", "()V", "", "invitationStatusType", "familyName", "setInvitationStatusType", "(Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationViewState;", "Lid/dana/familyaccount/view/joininvitation/JoinInvitationViewState;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JoinInvitationView extends BaseViewBindingRichView<ViewJoinInvitationBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private JoinInvitationViewState getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JoinInvitationView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JoinInvitationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JoinInvitationView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinInvitationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = "";
    }

    public /* synthetic */ JoinInvitationView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewJoinInvitationBinding inflateViewBinding() {
        ViewJoinInvitationBinding BuiltInFictitiousFunctionClassFactory = ViewJoinInvitationBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setInvitationStatusType(String invitationStatusType, String familyName) {
        Intrinsics.checkNotNullParameter(invitationStatusType, "");
        Intrinsics.checkNotNullParameter(familyName, "");
        this.getAuthRequestContext = new JoinInvitationViewState(invitationStatusType);
        this.PlaceComponentResult = familyName;
        AppCompatImageView appCompatImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = getContext();
        JoinInvitationViewState joinInvitationViewState = this.getAuthRequestContext;
        if (joinInvitationViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            joinInvitationViewState = null;
        }
        appCompatImageView.setContentDescription(context.getString(joinInvitationViewState.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory));
    }

    public final void initInvitationView() {
        String str = this.PlaceComponentResult;
        ViewJoinInvitationBinding binding = getBinding();
        RequestManager KClassImpl$Data$declaredNonStaticMembers$2 = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        JoinInvitationViewState joinInvitationViewState = this.getAuthRequestContext;
        JoinInvitationViewState joinInvitationViewState2 = null;
        if (joinInvitationViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            joinInvitationViewState = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(Integer.valueOf(joinInvitationViewState.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2)).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_illustration_family_account_family).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) binding.KClassImpl$Data$declaredNonStaticMembers$2);
        TextView textView = binding.MyBillsEntityDataFactory;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Context context = getContext();
        JoinInvitationViewState joinInvitationViewState3 = this.getAuthRequestContext;
        if (joinInvitationViewState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            joinInvitationViewState3 = null;
        }
        String string = context.getString(joinInvitationViewState3.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
        TextView textView2 = binding.getAuthRequestContext;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        Context context2 = getContext();
        JoinInvitationViewState joinInvitationViewState4 = this.getAuthRequestContext;
        if (joinInvitationViewState4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            joinInvitationViewState2 = joinInvitationViewState4;
        }
        String string2 = context2.getString(joinInvitationViewState2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        textView2.setText(format2);
    }
}
