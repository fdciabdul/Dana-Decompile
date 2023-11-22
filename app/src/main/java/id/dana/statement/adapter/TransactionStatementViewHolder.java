package id.dana.statement.adapter;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.statement.StatementTransactionType;
import id.dana.statement.model.StatementSummaryModel;
import id.dana.utils.OSUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0010\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/statement/adapter/TransactionStatementViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/statement/model/StatementSummaryModel;", "", "p0", "getAuthRequestContext", "(I)I", "", "Lid/dana/statement/StatementTransactionType;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/statement/StatementTransactionType;", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransactionStatementViewHolder extends BaseRecyclerViewHolder<StatementSummaryModel> {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {79, Ascii.DC4, Ascii.EM, -22, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 151;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<String, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(StatementSummaryModel statementSummaryModel) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        final StatementSummaryModel statementSummaryModel2 = statementSummaryModel;
        if (statementSummaryModel2 != null) {
            ((TextView) this.itemView.findViewById(R.id.tryMakeCompleting)).setText(getContext().getResources().getString(BuiltInFictitiousFunctionClassFactory(statementSummaryModel2.getAuthRequestContext).getLocalizedTitle()));
            ((TextView) this.itemView.findViewById(R.id.res_0x7f0a1618_snapshotcontroller_1)).setText(statementSummaryModel2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
            int roundToInt = MathKt.roundToInt(statementSummaryModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            if (OSUtil.scheduleImpl()) {
                ProgressBar progressBar = (ProgressBar) this.itemView.findViewById(R.id.res_0x7f0a0fa4_investmentcardmodel_danapluscard_creator);
                KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4.getResources(), getAuthRequestContext(roundToInt), getContext().getTheme());
                progressBar.setProgressTintList(KClassImpl$Data$declaredNonStaticMembers$22);
            } else {
                Drawable mutate = ((ProgressBar) this.itemView.findViewById(R.id.res_0x7f0a0fa4_investmentcardmodel_danapluscard_creator)).getProgressDrawable().mutate();
                Intrinsics.checkNotNullExpressionValue(mutate, "");
                LayerDrawable layerDrawable = (LayerDrawable) mutate;
                KClassImpl$Data$declaredNonStaticMembers$2(layerDrawable, 0).setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23942131099989), PorterDuff.Mode.SRC_IN);
                KClassImpl$Data$declaredNonStaticMembers$2(layerDrawable, 1).setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), getAuthRequestContext(roundToInt)), PorterDuff.Mode.SRC_IN);
            }
            ((ProgressBar) this.itemView.findViewById(R.id.res_0x7f0a0fa4_investmentcardmodel_danapluscard_creator)).setProgress(MathKt.roundToInt(statementSummaryModel2.KClassImpl$Data$declaredNonStaticMembers$2));
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(ContextCompat.PlaceComponentResult(getContext(), BuiltInFictitiousFunctionClassFactory(statementSummaryModel2.getAuthRequestContext).getDrawableIcon())).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter));
            CardView cardView = (CardView) this.itemView.findViewById(R.id.card_view_category);
            cardView.setEnabled(statementSummaryModel2.getMyBillsEntityDataFactory());
            AppCompatImageView appCompatImageView = (AppCompatImageView) cardView.findViewById(R.id.ChannelLimitedFlowMerge);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(statementSummaryModel2.getMyBillsEntityDataFactory() ? 0 : 8);
            cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.adapter.TransactionStatementViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransactionStatementViewHolder.MyBillsEntityDataFactory(TransactionStatementViewHolder.this, statementSummaryModel2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransactionStatementViewHolder(ViewGroup viewGroup, Function1<? super String, Unit> function1) {
        super(viewGroup.getContext(), R.layout.item_statement_history, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    private static int getAuthRequestContext(int p0) {
        if (p0 == RangesKt.coerceIn(p0, 80, 100)) {
            return R.color.f22922131099754;
        }
        if (p0 == RangesKt.coerceIn(p0, 40, 79)) {
            return R.color.getAuthRequestContext_res_0x7f060068;
        }
        if (p0 == RangesKt.coerceIn(p0, 10, 39)) {
            return R.color.f22902131099751;
        }
        RangesKt.coerceIn(p0, 0, 9);
        return R.color.f22892131099749;
    }

    private static StatementTransactionType BuiltInFictitiousFunctionClassFactory(String p0) {
        return Intrinsics.areEqual(p0, StatementTransactionType.TOPUP.getBizType()) ? StatementTransactionType.TOPUP : Intrinsics.areEqual(p0, StatementTransactionType.CASHBACK.getBizType()) ? StatementTransactionType.CASHBACK : Intrinsics.areEqual(p0, StatementTransactionType.RECEIVEMONEY.getBizType()) ? StatementTransactionType.RECEIVEMONEY : Intrinsics.areEqual(p0, StatementTransactionType.DANAKAGET.getBizType()) ? StatementTransactionType.DANAKAGET : Intrinsics.areEqual(p0, StatementTransactionType.SERVICES.getBizType()) ? StatementTransactionType.SERVICES : Intrinsics.areEqual(p0, StatementTransactionType.MERCHANT.getBizType()) ? StatementTransactionType.MERCHANT : Intrinsics.areEqual(p0, StatementTransactionType.SENDMONEY.getBizType()) ? StatementTransactionType.SENDMONEY : Intrinsics.areEqual(p0, StatementTransactionType.CASHOUT.getBizType()) ? StatementTransactionType.CASHOUT : StatementTransactionType.DEFAULT;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TransactionStatementViewHolder transactionStatementViewHolder, StatementSummaryModel statementSummaryModel) {
        Intrinsics.checkNotNullParameter(transactionStatementViewHolder, "");
        transactionStatementViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke(statementSummaryModel.getAuthRequestContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.drawable.Drawable KClassImpl$Data$declaredNonStaticMembers$2(android.graphics.drawable.LayerDrawable r11, int r12) {
        /*
            byte[] r0 = id.dana.statement.adapter.TransactionStatementViewHolder.BuiltInFictitiousFunctionClassFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 97
            r4 = 0
            r5 = 3
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 23
            r7 = 3
            r8 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L48
        L15:
            r3 = r2
            r5 = 97
            r6 = 3
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            int r8 = r7 + 1
            byte r9 = (byte) r5
            r3[r7] = r9
            if (r8 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            int r6 = r6 + 1
            r7 = r2[r6]
            r10 = r5
            r5 = r3
            r3 = r7
            r7 = r6
            r6 = r10
        L48:
            int r6 = r6 + r3
            int r3 = r6 + (-8)
            r6 = r7
            r7 = r8
            r10 = r5
            r5 = r3
            r3 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.statement.adapter.TransactionStatementViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(android.graphics.drawable.LayerDrawable, int):android.graphics.drawable.Drawable");
    }
}
