package id.dana.savings.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.util.NumberUtils;
import id.dana.richview.HideableBalanceView;
import id.dana.savings.ext.SavingModelExtKt;
import id.dana.savings.model.SavingModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/savings/viewholder/SavingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/savings/model/SavingModel;", "Landroid/content/Context;", "p0", "", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingViewHolder extends BaseRecyclerViewHolder<SavingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SavingModel savingModel) {
        SavingModel savingModel2 = savingModel;
        if (savingModel2 != null) {
            boolean lookAheadTest = SavingModelExtKt.lookAheadTest(savingModel2);
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_progress);
            if (textView != null) {
                textView.setVisibility(lookAheadTest ? 8 : 0);
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_goal_achieved);
            if (textView2 != null) {
                textView2.setVisibility(lookAheadTest ? 0 : 8);
            }
            ProgressBar progressBar = (ProgressBar) this.itemView.findViewById(R.id.progress_bar);
            if (progressBar != null) {
                progressBar.setProgress(MathKt.roundToInt(SavingModelExtKt.getAuthRequestContext(savingModel2)));
            }
            if (!SavingModelExtKt.lookAheadTest(savingModel2)) {
                TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_progress);
                if (textView3 != null) {
                    String string = getContext().getString(R.string.progress1);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(SavingModelExtKt.PlaceComponentResult(savingModel2)))}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    textView3.setText(format);
                }
                HideableBalanceView hideableBalanceView = (HideableBalanceView) this.itemView.findViewById(R.id.tv_hideable_target_balance);
                if (hideableBalanceView != null) {
                    hideableBalanceView.setTextSize(2, 14.0f);
                    hideableBalanceView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(hideableBalanceView.getContext(), R.color.f26762131100391));
                    String cleanAll = NumberUtils.getCleanAll(savingModel2.DatabaseTableConfigUtil.PlaceComponentResult);
                    if (cleanAll == null) {
                        cleanAll = "0";
                    }
                    hideableBalanceView.setAmount(cleanAll);
                    hideableBalanceView.setTextAppearance(R.style.f49552132017399);
                    hideableBalanceView.setBalanceVisibility(savingModel2.getMoveToNextValue());
                }
            }
            String str = savingModel2.NetworkUserEntityData$$ExternalSyntheticLambda2;
            TextView textView4 = (TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar);
            if (textView4 != null) {
                textView4.setText(str);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.BottomSheetType);
            if (appCompatImageView != null) {
                GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(SavingModelExtKt.BuiltInFictitiousFunctionClassFactory(savingModel2)).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            }
            long BuiltInFictitiousFunctionClassFactory = savingModel2.lookAheadTest.BuiltInFictitiousFunctionClassFactory();
            boolean moveToNextValue = savingModel2.getMoveToNextValue();
            String valueOf = String.valueOf(BuiltInFictitiousFunctionClassFactory);
            HideableBalanceView hideableBalanceView2 = (HideableBalanceView) this.itemView.findViewById(R.id.tv_hideable_balance);
            if (hideableBalanceView2 != null) {
                hideableBalanceView2.setTextSize(2, 14.0f);
                hideableBalanceView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(hideableBalanceView2.getContext(), 17170444));
                hideableBalanceView2.setAmount(valueOf);
                hideableBalanceView2.setBalanceVisibility(moveToNextValue);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_saving, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
