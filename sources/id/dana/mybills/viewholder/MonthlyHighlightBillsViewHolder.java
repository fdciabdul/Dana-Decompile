package id.dana.mybills.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.extension.view.InputExtKt;
import id.dana.mybills.model.BillSubscriptionHighlightModel;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.richview.CurrencyTextView;
import id.dana.utils.DateTimeUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b"}, d2 = {"Lid/dana/mybills/viewholder/MonthlyHighlightBillsViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "I", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonthlyHighlightBillsViewHolder extends BaseRecyclerViewHolder<BillSubscriptionHighlightModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(BillSubscriptionHighlightModel billSubscriptionHighlightModel) {
        BillSubscriptionHighlightModel billSubscriptionHighlightModel2 = billSubscriptionHighlightModel;
        View view = this.itemView;
        if (billSubscriptionHighlightModel2 != null) {
            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.ArrayTable$2);
            if (circleImageView != null) {
                Intrinsics.checkNotNullExpressionValue(circleImageView, "");
                CircleImageView circleImageView2 = circleImageView;
                GlideApp.getAuthRequestContext(circleImageView2.getContext()).PlaceComponentResult(billSubscriptionHighlightModel2.scheduleImpl).SubSequence().MyBillsEntityDataFactory((ImageView) circleImageView2);
            }
            CircleImageView circleImageView3 = (CircleImageView) view.findViewById(R.id.WithdrawSavedCardChannelView);
            if (circleImageView3 != null) {
                Intrinsics.checkNotNullExpressionValue(circleImageView3, "");
                CircleImageView circleImageView4 = circleImageView3;
                String str = billSubscriptionHighlightModel2.DatabaseTableConfigUtil;
                if (str == null) {
                    str = "";
                }
                GlideApp.getAuthRequestContext(circleImageView4.getContext()).PlaceComponentResult(Integer.valueOf(Intrinsics.areEqual(str, RecurringType.REMINDER) ? R.drawable.ic_mybills_reminder : R.drawable.ic_mybills_auto_deduction)).SubSequence().MyBillsEntityDataFactory((ImageView) circleImageView4);
            }
            TextView textView = (TextView) view.findViewById(R.id.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResultWithPending$1$1);
            if (textView != null) {
                textView.setText(billSubscriptionHighlightModel2.initRecordTimeStamp);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.FeatureOauth_Factory);
            if (textView2 != null) {
                textView2.setText(billSubscriptionHighlightModel2.BuiltInFictitiousFunctionClassFactory);
            }
            CurrencyTextView currencyTextView = (CurrencyTextView) view.findViewById(R.id.getBackDisposition);
            if (currencyTextView != null) {
                currencyTextView.setText(billSubscriptionHighlightModel2.GetContactSyncConfig.PlaceComponentResult);
            }
            Locale locale = Locale.getDefault();
            Long l = billSubscriptionHighlightModel2.lookAheadTest;
            String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("d MMM", locale, l != null ? l.longValue() : -1L);
            Intrinsics.checkNotNullExpressionValue(view, "");
            if (billSubscriptionHighlightModel2.DatabaseTableConfigUtil != null && Intrinsics.areEqual(billSubscriptionHighlightModel2.DatabaseTableConfigUtil, RecurringType.REMINDER)) {
                if (billSubscriptionHighlightModel2.moveToNextValue > 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = view.getContext().getString(R.string.next_schedule_payment_late);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(billSubscriptionHighlightModel2.moveToNextValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    this.BuiltInFictitiousFunctionClassFactory = format;
                    this.MyBillsEntityDataFactory = R.color.f26712131100373;
                } else if (billSubscriptionHighlightModel2.moveToNextValue == 0) {
                    String string2 = view.getContext().getString(R.string.next_schedule_payment_today);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    this.BuiltInFictitiousFunctionClassFactory = string2;
                    this.MyBillsEntityDataFactory = R.color.f27152131100507;
                }
            }
            String str2 = this.BuiltInFictitiousFunctionClassFactory;
            if (str2.length() > 0) {
                TextView textView3 = (TextView) view.findViewById(R.id.createDefaultAppReviewInfo);
                if (textView3 != null) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format("%s • %s", Arrays.copyOf(new Object[]{str2, BuiltInFictitiousFunctionClassFactory}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "");
                    textView3.setText(format2);
                }
                TextView textView4 = (TextView) view.findViewById(R.id.createDefaultAppReviewInfo);
                Intrinsics.checkNotNullExpressionValue(textView4, "");
                InputExtKt.getAuthRequestContext(textView4, this.MyBillsEntityDataFactory, str2, false, new Function0<Unit>() { // from class: id.dana.mybills.viewholder.MonthlyHighlightBillsViewHolder$bindData$1$1$1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            TextView textView5 = (TextView) view.findViewById(R.id.createDefaultAppReviewInfo);
            if (textView5 != null) {
                textView5.setText(BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonthlyHighlightBillsViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_monthly_highlight_bills, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.BuiltInFictitiousFunctionClassFactory = "";
    }
}
