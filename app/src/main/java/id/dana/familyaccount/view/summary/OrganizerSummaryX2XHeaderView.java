package id.dana.familyaccount.view.summary;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.ViewOrganizerSummaryX2xHeaderBinding;
import id.dana.familyaccount.constants.FamilyAccountTransactionType;
import id.dana.familyaccount.model.PayeeUserInfoModel;
import id.dana.familyaccount.model.PayerUserInfoModel;
import id.dana.familyaccount.model.SummaryModel;
import id.dana.utils.MaskedTextUtil;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/familyaccount/view/summary/OrganizerSummaryX2XHeaderView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewOrganizerSummaryX2xHeaderBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewOrganizerSummaryX2xHeaderBinding;", "Lid/dana/familyaccount/model/SummaryModel;", "summaryResult", "", "setSummaryHeader", "(Lid/dana/familyaccount/model/SummaryModel;)V", "Lid/dana/familyaccount/view/summary/TransactionTypeViewState;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/familyaccount/view/summary/TransactionTypeViewState;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerSummaryX2XHeaderView extends BaseViewBindingRichView<ViewOrganizerSummaryX2xHeaderBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private TransactionTypeViewState getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2XHeaderView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2XHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2XHeaderView(Context context, AttributeSet attributeSet, int i) {
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
    public OrganizerSummaryX2XHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OrganizerSummaryX2XHeaderView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewOrganizerSummaryX2xHeaderBinding inflateViewBinding() {
        ViewOrganizerSummaryX2xHeaderBinding BuiltInFictitiousFunctionClassFactory = ViewOrganizerSummaryX2xHeaderBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setSummaryHeader(SummaryModel summaryResult) {
        Intrinsics.checkNotNullParameter(summaryResult, "");
        this.getAuthRequestContext = new TransactionTypeViewState(summaryResult.getErrorConfigVersion);
        ShapeableImageView shapeableImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        ShapeableImageView shapeableImageView2 = shapeableImageView;
        TransactionTypeViewState transactionTypeViewState = this.getAuthRequestContext;
        String str = null;
        if (transactionTypeViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transactionTypeViewState = null;
        }
        Integer valueOf = Integer.valueOf(transactionTypeViewState.getAuthRequestContext.MyBillsEntityDataFactory);
        Context context = shapeableImageView2.getContext();
        if (context != null) {
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(context).getAuthRequestContext(valueOf).BuiltInFictitiousFunctionClassFactory((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) shapeableImageView2);
        }
        TextView textView = getBinding().lookAheadTest;
        Resources resources = getResources();
        TransactionTypeViewState transactionTypeViewState2 = this.getAuthRequestContext;
        if (transactionTypeViewState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transactionTypeViewState2 = null;
        }
        textView.setText(resources.getString(transactionTypeViewState2.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory));
        PayerUserInfoModel payerUserInfoModel = summaryResult.GetContactSyncConfig;
        if (payerUserInfoModel != null) {
            ShapeableImageView shapeableImageView3 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView3, "");
            ShapeableImageView shapeableImageView4 = shapeableImageView3;
            String str2 = payerUserInfoModel.PlaceComponentResult;
            Context context2 = shapeableImageView4.getContext();
            if (context2 != null) {
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(context2).getAuthRequestContext(str2).BuiltInFictitiousFunctionClassFactory((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) shapeableImageView4);
            }
            getBinding().getErrorConfigVersion.setText(payerUserInfoModel.BuiltInFictitiousFunctionClassFactory);
        }
        String str3 = summaryResult.getErrorConfigVersion;
        PayeeUserInfoModel payeeUserInfoModel = summaryResult.moveToNextValue;
        if (payeeUserInfoModel != null) {
            if (Intrinsics.areEqual(str3, FamilyAccountTransactionType.TRANSFER_X2B)) {
                ShapeableImageView shapeableImageView5 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(shapeableImageView5, "");
                ShapeableImageView shapeableImageView6 = shapeableImageView5;
                String str4 = payeeUserInfoModel.PlaceComponentResult;
                Object[] objArr = new Object[1];
                if (str4 != null) {
                    str = str4.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(str, "");
                }
                objArr[0] = str;
                String format = String.format(DanaUrl.BANK_ICON_URL, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                Context context3 = shapeableImageView6.getContext();
                if (context3 != null) {
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(context3).getAuthRequestContext(format).BuiltInFictitiousFunctionClassFactory((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) shapeableImageView6);
                }
                getBinding().scheduleImpl.setText(payeeUserInfoModel.getAuthRequestContext);
            } else if (Intrinsics.areEqual(str3, FamilyAccountTransactionType.TRANSFER_X2P)) {
                ShapeableImageView shapeableImageView7 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(shapeableImageView7, "");
                ShapeableImageView shapeableImageView8 = shapeableImageView7;
                String str5 = payeeUserInfoModel.BuiltInFictitiousFunctionClassFactory;
                Context context4 = shapeableImageView8.getContext();
                if (context4 != null) {
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(context4).getAuthRequestContext(str5).BuiltInFictitiousFunctionClassFactory((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) shapeableImageView8);
                }
                getBinding().scheduleImpl.setText(MaskedTextUtil.PlaceComponentResult(payeeUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0));
            }
        }
    }
}
