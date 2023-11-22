package id.dana.familyaccount.view.managefamily;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewManageFamilyBinding;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000f\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageFamilyView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewManageFamilyBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewManageFamilyBinding;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "familyMemberInfoModel", "", "setManageFamilyType", "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/familyaccount/view/managefamily/ManageFamilyViewState;", "MyBillsEntityDataFactory", "Lid/dana/familyaccount/view/managefamily/ManageFamilyViewState;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageFamilyView extends BaseViewBindingRichView<ViewManageFamilyBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private FamilyMemberInfoModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ManageFamilyViewState KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManageFamilyView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManageFamilyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManageFamilyView(Context context, AttributeSet attributeSet, int i) {
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
    public ManageFamilyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ManageFamilyView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewManageFamilyBinding inflateViewBinding() {
        ViewManageFamilyBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewManageFamilyBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void setManageFamilyType(FamilyMemberInfoModel familyMemberInfoModel) {
        Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
        this.BuiltInFictitiousFunctionClassFactory = familyMemberInfoModel;
        FamilyMemberInfoModel familyMemberInfoModel2 = null;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ManageFamilyViewState(familyMemberInfoModel.MyBillsEntityDataFactory);
        FamilyMemberInfoModel familyMemberInfoModel3 = this.BuiltInFictitiousFunctionClassFactory;
        if (familyMemberInfoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            familyMemberInfoModel2 = familyMemberInfoModel3;
        }
        getBinding().MyBillsEntityDataFactory.loadImage(familyMemberInfoModel2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.ic_avatar_grey_default);
        getBinding().MyBillsEntityDataFactory.setBorderColor(R.drawable.bg_grey_circle);
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(familyMemberInfoModel2.PlaceComponentResult());
        CircleImageView circleImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        circleImageView.setVisibility(BuiltInFictitiousFunctionClassFactory(familyMemberInfoModel2.MyBillsEntityDataFactory) ? 0 : 8);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        String upperCase = p0.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return Intrinsics.areEqual(upperCase, FamilyAccountInvitationStatusType.ACCOUNT_OWNER);
    }
}
