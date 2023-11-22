package id.dana.cashier;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.base.BaseMaterialDialog;
import id.dana.cashier.adapter.BenefitAdapter;
import id.dana.cashier.model.BenefitModel;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.utils.NoUnderlineClickableSpan;
import id.dana.webview.WebViewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018"}, d2 = {"Lid/dana/cashier/CashierAddOnInfoDialog;", "Lid/dana/base/BaseMaterialDialog;", "Lid/dana/cashier/CashierAddOnInfoDialog$Builder;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "getAuthRequestContext", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "Landroidx/constraintlayout/widget/Group;", "PlaceComponentResult", "Landroidx/constraintlayout/widget/Group;", "Landroid/widget/ImageView;", "getErrorConfigVersion", "Landroid/widget/ImageView;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/recyclerview/widget/RecyclerView;", "moveToNextValue", "Landroidx/recyclerview/widget/RecyclerView;", "MyBillsEntityDataFactory", "Landroid/widget/TextView;", "scheduleImpl", "Landroid/widget/TextView;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CashierAddOnInfoDialog extends BaseMaterialDialog<Builder> {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private TextView scheduleImpl;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private TextView moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private TextView getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Group KClassImpl$Data$declaredNonStaticMembers$2;
    private DanaButtonPrimaryView getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ImageView BuiltInFictitiousFunctionClassFactory;
    private TextView lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private RecyclerView MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TextView PlaceComponentResult;

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        DanaButtonPrimaryView danaButtonPrimaryView;
        DanaButtonPrimaryView danaButtonPrimaryView2;
        Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(view, "");
        if (view != null) {
            this.getErrorConfigVersion = (TextView) view.findViewById(id.dana.R.id.GetPureRepPrice);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (TextView) view.findViewById(id.dana.R.id.f4278tvInfoDuration);
            this.scheduleImpl = (TextView) view.findViewById(id.dana.R.id.tvTncPolicy);
            this.moveToNextValue = (TextView) view.findViewById(id.dana.R.id.RVMultimediaProxy);
            this.lookAheadTest = (TextView) view.findViewById(id.dana.R.id.getRelativeLeft);
            this.getAuthRequestContext = (DanaButtonPrimaryView) view.findViewById(id.dana.R.id.f3481btnOk);
            this.BuiltInFictitiousFunctionClassFactory = (ImageView) view.findViewById(id.dana.R.id.ivInfo);
            this.MyBillsEntityDataFactory = (RecyclerView) view.findViewById(id.dana.R.id.f4111res_0x7f0a10e6_descriptorvisibilities_5);
            this.PlaceComponentResult = (TextView) view.findViewById(id.dana.R.id.f4250res_0x7f0a13fd_lambda_processregistrar_0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Group) view.findViewById(id.dana.R.id.groupTooltipBackend);
        }
        if (builder2 != null) {
            if (builder2.getPlaceComponentResult() && builder2.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                if (builder2 != null) {
                    Group group = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (group != null) {
                        group.setVisibility(8);
                    }
                    TextView textView = this.PlaceComponentResult;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    View.OnClickListener onClickListener = builder2.getErrorConfigVersion;
                    if (onClickListener != null && (danaButtonPrimaryView2 = this.getAuthRequestContext) != null) {
                        danaButtonPrimaryView2.setOnClickListener(onClickListener);
                    }
                    String str = builder2.moveToNextValue;
                    TextView textView2 = this.getErrorConfigVersion;
                    if (textView2 != null) {
                        textView2.setText(str);
                    }
                    String str2 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
                    TextView textView3 = this.PlaceComponentResult;
                    if (textView3 != null) {
                        textView3.setText(str2);
                    }
                    String str3 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (str3 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2(str3);
                    }
                }
            } else if (builder2 != null) {
                View.OnClickListener onClickListener2 = builder2.getErrorConfigVersion;
                if (onClickListener2 != null && (danaButtonPrimaryView = this.getAuthRequestContext) != null) {
                    danaButtonPrimaryView.setOnClickListener(onClickListener2);
                }
                String str4 = builder2.moveToNextValue;
                TextView textView4 = this.getErrorConfigVersion;
                if (textView4 != null) {
                    textView4.setText(str4);
                }
                String str5 = builder2.MyBillsEntityDataFactory;
                TextView textView5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (textView5 != null) {
                    textView5.setText(str5);
                }
                String str6 = builder2.scheduleImpl;
                TextView textView6 = this.moveToNextValue;
                if (textView6 != null) {
                    textView6.setText(str6);
                }
                String str7 = builder2.BuiltInFictitiousFunctionClassFactory;
                TextView textView7 = this.lookAheadTest;
                if (textView7 != null) {
                    textView7.setText(str7);
                }
                String str8 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str8 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2(str8);
                }
                String str9 = builder2.lookAheadTest;
                if (str9 != null) {
                    String string = this.MyBillsEntityDataFactory.getString(id.dana.R.string.i_agree_to_the);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    String string2 = this.MyBillsEntityDataFactory.getString(id.dana.R.string.tnc);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    String str10 = string;
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str10, string2, 0, false, 6, (Object) null);
                    NoUnderlineClickableSpan noUnderlineClickableSpan = new NoUnderlineClickableSpan(this.MyBillsEntityDataFactory, WebViewActivity.ContentBuilder(this.MyBillsEntityDataFactory, string2, str9));
                    SpannableString spannableString = new SpannableString(str10);
                    spannableString.setSpan(noUnderlineClickableSpan, indexOf$default, string2.length() + indexOf$default, 33);
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, id.dana.R.color.f22912131099753)), indexOf$default, string2.length() + indexOf$default, 33);
                    spannableString.setSpan(new StyleSpan(1), indexOf$default, string2.length() + indexOf$default, 33);
                    TextView textView8 = this.scheduleImpl;
                    if (textView8 != null) {
                        textView8.setText(spannableString);
                    }
                    TextView textView9 = this.scheduleImpl;
                    if (textView9 != null) {
                        textView9.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
                List<BenefitModel> list = builder2.getAuthRequestContext;
                if (list != null) {
                    BenefitAdapter benefitAdapter = new BenefitAdapter();
                    RecyclerView recyclerView = this.MyBillsEntityDataFactory;
                    if (recyclerView != null) {
                        recyclerView.setAdapter(benefitAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                        recyclerView.setNestedScrollingEnabled(false);
                    }
                    benefitAdapter.setItems(list);
                }
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        ImageView imageView = this.BuiltInFictitiousFunctionClassFactory;
        if (imageView != null) {
            GlideApp.getAuthRequestContext(this.MyBillsEntityDataFactory).PlaceComponentResult(p0).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) id.dana.R.drawable.ic_no_image_state).PlaceComponentResult((int) id.dana.R.drawable.ic_no_image_state).MyBillsEntityDataFactory(imageView);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\f8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\b"}, d2 = {"Lid/dana/cashier/CashierAddOnInfoDialog$Builder;", "Lid/dana/base/BaseMaterialDialog$Cancellation;", "", "Lid/dana/cashier/model/BenefitModel;", "getAuthRequestContext", "Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "MyBillsEntityDataFactory", "", "lookAheadTest", "Z", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "moveToNextValue", "Landroid/view/View$OnClickListener;", "getErrorConfigVersion", "scheduleImpl"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Builder extends BaseMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        String moveToNextValue;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        String BuiltInFictitiousFunctionClassFactory;
        List<BenefitModel> getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        String scheduleImpl;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private boolean PlaceComponentResult;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        View.OnClickListener getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        String lookAheadTest;

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }
}
