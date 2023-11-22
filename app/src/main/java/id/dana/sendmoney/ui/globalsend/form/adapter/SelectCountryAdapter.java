package id.dana.sendmoney.ui.globalsend.form.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemGlobalSendCountryBinding;
import id.dana.sendmoney.ui.globalsend.form.adapter.SelectCountryAdapter;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import id.dana.utils.extension.LanguageExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/SelectCountryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/globalsend/form/adapter/SelectCountryAdapter$CountryViewHolder;", "", "getItemCount", "()I", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "Ljava/util/List;", "getAuthRequestContext", "Lkotlin/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "CountryViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectCountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private List<CountryModel> getAuthRequestContext = new ArrayList();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Function1<? super CountryModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2 = new Function1<CountryModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.SelectCountryAdapter$onCountrySelected$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(CountryModel countryModel) {
            Intrinsics.checkNotNullParameter(countryModel, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(CountryModel countryModel) {
            invoke2(countryModel);
            return Unit.INSTANCE;
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(CountryViewHolder countryViewHolder, int i) {
        String str;
        CountryViewHolder countryViewHolder2 = countryViewHolder;
        Intrinsics.checkNotNullParameter(countryViewHolder2, "");
        final CountryModel countryModel = this.getAuthRequestContext.get(i);
        Intrinsics.checkNotNullParameter(countryModel, "");
        ItemGlobalSendCountryBinding itemGlobalSendCountryBinding = countryViewHolder2.PlaceComponentResult;
        itemGlobalSendCountryBinding.BuiltInFictitiousFunctionClassFactory.setText(countryModel.getAuthRequestContext());
        CircleImageView circleImageView = itemGlobalSendCountryBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        CountryViewHolder.getAuthRequestContext(circleImageView, countryModel.BuiltInFictitiousFunctionClassFactory());
        ConstraintLayout constraintLayout = itemGlobalSendCountryBinding.MyBillsEntityDataFactory;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = countryViewHolder2.itemView.getContext().getString(R.string.lbl_item_country);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{countryModel.KClassImpl$Data$declaredNonStaticMembers$2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        constraintLayout.setContentDescription(format);
        if (countryModel.getScheduleImpl()) {
            ItemGlobalSendCountryBinding itemGlobalSendCountryBinding2 = countryViewHolder2.PlaceComponentResult;
            CircleImageView circleImageView2 = itemGlobalSendCountryBinding2.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
            ViewExtKt.MyBillsEntityDataFactory((ImageView) circleImageView2, true);
            AppCompatTextView appCompatTextView = itemGlobalSendCountryBinding2.BuiltInFictitiousFunctionClassFactory;
            appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), R.color.getErrorConfigVersion));
            AppCompatTextView appCompatTextView2 = itemGlobalSendCountryBinding2.KClassImpl$Data$declaredNonStaticMembers$2;
            appCompatTextView2.setText(appCompatTextView2.getContext().getString(R.string.text_maintenance_country));
            appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView2.getContext(), R.color.scheduleImpl));
            AppCompatTextView appCompatTextView3 = itemGlobalSendCountryBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
            appCompatTextView3.setVisibility(8);
            ConstraintLayout constraintLayout2 = itemGlobalSendCountryBinding2.PlaceComponentResult;
            constraintLayout2.setEnabled(false);
            constraintLayout2.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout2.getContext(), R.color.BuiltInFictitiousFunctionClassFactory));
            return;
        }
        ItemGlobalSendCountryBinding itemGlobalSendCountryBinding3 = countryViewHolder2.PlaceComponentResult;
        SelectCountryAdapter selectCountryAdapter = countryViewHolder2.MyBillsEntityDataFactory;
        CircleImageView circleImageView3 = itemGlobalSendCountryBinding3.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(circleImageView3, "");
        ViewExtKt.MyBillsEntityDataFactory((ImageView) circleImageView3, false);
        AppCompatTextView appCompatTextView4 = itemGlobalSendCountryBinding3.BuiltInFictitiousFunctionClassFactory;
        appCompatTextView4.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView4.getContext(), R.color.lookAheadTest));
        AppCompatTextView appCompatTextView5 = itemGlobalSendCountryBinding3.KClassImpl$Data$declaredNonStaticMembers$2;
        appCompatTextView5.setText(appCompatTextView5.getContext().getString(R.string.res_0x7f131482_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_1));
        appCompatTextView5.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView5.getContext(), R.color.getErrorConfigVersion));
        AppCompatTextView appCompatTextView6 = itemGlobalSendCountryBinding3.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Context context = countryViewHolder2.PlaceComponentResult.PlaceComponentResult.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Intrinsics.checkNotNullParameter(context, "");
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        String str2 = (LocaleUtil.PlaceComponentResult() || !countryModel.KClassImpl$Data$declaredNonStaticMembers$2()) ? "" : "s";
        String str3 = countryModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (Intrinsics.areEqual(str3, CountryModel.Companion.TimeUnit.REAL_TIME.getValue())) {
            str = context.getString(R.string.time_unit_real_time);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else if (Intrinsics.areEqual(str3, CountryModel.Companion.TimeUnit.DAY.getValue())) {
            str = context.getString(R.string.time_unit_x_working_days, countryModel.lookAheadTest, str2);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else if (Intrinsics.areEqual(str3, CountryModel.Companion.TimeUnit.HOURS.getValue())) {
            str = context.getString(R.string.time_unit_x_hours, countryModel.lookAheadTest, str2);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else if (Intrinsics.areEqual(str3, CountryModel.Companion.TimeUnit.MINUTES.getValue())) {
            str = context.getString(R.string.time_unit_x_minutes, countryModel.lookAheadTest, str2);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = "";
        }
        appCompatTextView6.setText(str);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView6, "");
        appCompatTextView6.setVisibility(0);
        ConstraintLayout constraintLayout3 = itemGlobalSendCountryBinding3.PlaceComponentResult;
        constraintLayout3.setEnabled(true);
        constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.SelectCountryAdapter$CountryViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectCountryAdapter.CountryViewHolder.getAuthRequestContext(SelectCountryAdapter.this, countryModel);
            }
        });
        constraintLayout3.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout3.getContext(), R.color.moveToNextValue));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemGlobalSendCountryBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemGlobalSendCountryBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return new CountryViewHolder(this, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final void MyBillsEntityDataFactory(List<CountryModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext = CollectionsKt.sortedWith(p0, new Comparator() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.SelectCountryAdapter$setList$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                CountryModel countryModel = (CountryModel) t;
                CountryModel countryModel2 = (CountryModel) t2;
                return ComparisonsKt.compareValues(LanguageExtKt.getAuthRequestContext() ? countryModel.MyBillsEntityDataFactory : countryModel.PlaceComponentResult, LanguageExtKt.getAuthRequestContext() ? countryModel2.MyBillsEntityDataFactory : countryModel2.PlaceComponentResult);
            }
        });
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.getAuthRequestContext.size();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/SelectCountryAdapter$CountryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "", "p0", "", "getAuthRequestContext", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "Lid/dana/sendmoney/databinding/ItemGlobalSendCountryBinding;", "PlaceComponentResult", "Lid/dana/sendmoney/databinding/ItemGlobalSendCountryBinding;", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/adapter/SelectCountryAdapter;Lid/dana/sendmoney/databinding/ItemGlobalSendCountryBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class CountryViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SelectCountryAdapter MyBillsEntityDataFactory;
        public final ItemGlobalSendCountryBinding PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountryViewHolder(SelectCountryAdapter selectCountryAdapter, ItemGlobalSendCountryBinding itemGlobalSendCountryBinding) {
            super(itemGlobalSendCountryBinding.PlaceComponentResult);
            Intrinsics.checkNotNullParameter(itemGlobalSendCountryBinding, "");
            this.MyBillsEntityDataFactory = selectCountryAdapter;
            this.PlaceComponentResult = itemGlobalSendCountryBinding;
        }

        static void getAuthRequestContext(ImageView imageView, String str) {
            GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.bg_circle_grey_20).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.bg_circle_grey_20).MyBillsEntityDataFactory(imageView);
        }

        public static /* synthetic */ void getAuthRequestContext(SelectCountryAdapter selectCountryAdapter, CountryModel countryModel) {
            Intrinsics.checkNotNullParameter(selectCountryAdapter, "");
            Intrinsics.checkNotNullParameter(countryModel, "");
            selectCountryAdapter.KClassImpl$Data$declaredNonStaticMembers$2.invoke(countryModel);
        }
    }
}
