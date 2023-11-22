package com.ipification.mobile.sdk.im.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.R;
import com.ipification.mobile.sdk.android.databinding.ImItemBinding;
import com.ipification.mobile.sdk.im.IMService;
import com.ipification.mobile.sdk.im.data.IMInfo;
import com.ipification.mobile.sdk.im.listener.OnIMItemClickListener;
import id.dana.data.socialshare.ShareAppKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/ipification/mobile/sdk/im/adapter/IMListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ipification/mobile/sdk/im/adapter/IMViewHolder;", "", "getItemCount", "()I", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ipification/mobile/sdk/im/listener/OnIMItemClickListener;", "MyBillsEntityDataFactory", "Lcom/ipification/mobile/sdk/im/listener/OnIMItemClickListener;", "", "Lcom/ipification/mobile/sdk/im/data/IMInfo;", "getAuthRequestContext", "Ljava/util/List;", "PlaceComponentResult", "p0", "p1", "<init>", "(Ljava/util/List;Lcom/ipification/mobile/sdk/im/listener/OnIMItemClickListener;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IMListAdapter extends RecyclerView.Adapter<IMViewHolder> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private OnIMItemClickListener MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<IMInfo> PlaceComponentResult;

    public IMListAdapter(List<IMInfo> list, OnIMItemClickListener onIMItemClickListener) {
        Intrinsics.checkParameterIsNotNull(list, "");
        Intrinsics.checkParameterIsNotNull(onIMItemClickListener, "");
        this.PlaceComponentResult = list;
        this.MyBillsEntityDataFactory = onIMItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult.size();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(IMListAdapter iMListAdapter, IMInfo iMInfo) {
        Intrinsics.checkParameterIsNotNull(iMListAdapter, "");
        Intrinsics.checkParameterIsNotNull(iMInfo, "");
        iMListAdapter.MyBillsEntityDataFactory.getAuthRequestContext(iMInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(IMViewHolder iMViewHolder, int i) {
        IMViewHolder iMViewHolder2 = iMViewHolder;
        Intrinsics.checkParameterIsNotNull(iMViewHolder2, "");
        final IMInfo iMInfo = this.PlaceComponentResult.get(i);
        iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: com.ipification.mobile.sdk.im.adapter.IMListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IMListAdapter.BuiltInFictitiousFunctionClassFactory(IMListAdapter.this, iMInfo);
            }
        });
        iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.setText(this.PlaceComponentResult.get(i).BuiltInFictitiousFunctionClassFactory);
        if (Intrinsics.areEqual(iMInfo.BuiltInFictitiousFunctionClassFactory, ShareAppKey.WHATSAPP)) {
            iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setBackgroundResource(R.drawable.im_bg_whatsapp_radius);
            TextView textView = iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            IMService.Companion companion = IMService.INSTANCE;
            textView.setText(IMService.Companion.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda1);
            TextView textView2 = iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            } else {
                textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, 17170443));
                InstrumentInjector.Resources_setImageResource(iMViewHolder2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, R.drawable.res_0x7f080c3a_kclassimpl_data_declarednonstaticmembers_2);
            }
        } else if (Intrinsics.areEqual(iMInfo.BuiltInFictitiousFunctionClassFactory, "viber")) {
            iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setBackgroundResource(R.drawable.im_bg_viber_radius);
            TextView textView3 = iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            IMService.Companion companion2 = IMService.INSTANCE;
            textView3.setText(IMService.Companion.BuiltInFictitiousFunctionClassFactory().DatabaseTableConfigUtil);
            TextView textView4 = iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            } else {
                textView4.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context2, 17170443));
                InstrumentInjector.Resources_setImageResource(iMViewHolder2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, R.drawable.BuiltInFictitiousFunctionClassFactory);
            }
        } else if (Intrinsics.areEqual(iMInfo.BuiltInFictitiousFunctionClassFactory, ShareAppKey.TELEGRAM)) {
            iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setBackgroundResource(R.drawable.im_bg_telegram_radius);
            TextView textView5 = iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            IMService.Companion companion3 = IMService.INSTANCE;
            textView5.setText(IMService.Companion.BuiltInFictitiousFunctionClassFactory().getErrorConfigVersion);
            TextView textView6 = iMViewHolder2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            } else {
                textView6.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context3, 17170443));
                InstrumentInjector.Resources_setImageResource(iMViewHolder2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, R.drawable.ic_telegram);
            }
        }
        if (!iMInfo.getGetAuthRequestContext()) {
            IPConfiguration.Companion companion4 = IPConfiguration.INSTANCE;
            if (IPConfiguration.Companion.MyBillsEntityDataFactory().getAppCompatEmojiTextHelper()) {
                iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setAlpha(0.2f);
                iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setClickable(false);
                return;
            }
        }
        iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setAlpha(1.0f);
        iMViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setClickable(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ IMViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.PlaceComponentResult, viewGroup, false);
        int i2 = R.id.res_0x7f0a0a1b_kclassimpl_data_declarednonstaticmembers_2;
        ImageView imageView = (ImageView) inflate.findViewById(i2);
        if (imageView != null) {
            i2 = R.id.res_0x7f0a1528_networkuserentitydata_externalsyntheticlambda0;
            TextView textView = (TextView) inflate.findViewById(i2);
            if (textView != null) {
                ImItemBinding imItemBinding = new ImItemBinding((ConstraintLayout) inflate, imageView, textView);
                Intrinsics.checkExpressionValueIsNotNull(imItemBinding, "");
                return new IMViewHolder(imItemBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
