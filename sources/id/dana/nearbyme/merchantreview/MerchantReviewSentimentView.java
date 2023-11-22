package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.nearbyme.merchantreview.adapter.MerchantReviewTagAdapter;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.merchantreview.model.SentimentState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u001d"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewSentimentView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "getSelectedTags", "()Ljava/util/List;", "Lkotlin/Function0;", "", "onTagClick", "setOnTagClick", "(Lkotlin/jvm/functions/Function0;)V", "setup", "()V", "Lid/dana/nearbyme/merchantreview/model/SentimentState;", "sentimentState", "updateSentiment", "(Lid/dana/nearbyme/merchantreview/model/SentimentState;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantreview/model/SentimentState;", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewTagAdapter;", "Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewTagAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewSentimentView extends BaseRichView {
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;
    private SentimentState KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MerchantReviewTagAdapter PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private List<MerchantReviewTagModel> getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<MerchantReviewTagModel> MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantReviewSentimentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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
        return R.layout.view_merchant_review_sentiment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewSentimentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = new ArrayList();
        this.MyBillsEntityDataFactory = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SentimentState.None();
    }

    public /* synthetic */ MerchantReviewSentimentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView;
        if (getContext() == null || (recyclerView = (RecyclerView) _$_findCachedViewById(R.id.showPreviewShopData)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        MerchantReviewTagAdapter merchantReviewTagAdapter = new MerchantReviewTagAdapter(new MerchantReviewTagListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewSentimentView$setup$1$1$1
            @Override // id.dana.nearbyme.merchantreview.MerchantReviewTagListener
            public final void MyBillsEntityDataFactory(int p0) {
                Function0 function0;
                function0 = MerchantReviewSentimentView.this.BuiltInFictitiousFunctionClassFactory;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        this.PlaceComponentResult = merchantReviewTagAdapter;
        recyclerView.setAdapter(merchantReviewTagAdapter);
    }

    public final void setOnTagClick(Function0<Unit> onTagClick) {
        Intrinsics.checkNotNullParameter(onTagClick, "");
        this.BuiltInFictitiousFunctionClassFactory = onTagClick;
    }

    public final void updateSentiment(SentimentState sentimentState) {
        List<MerchantReviewTagModel> emptyList;
        Intrinsics.checkNotNullParameter(sentimentState, "");
        MerchantReviewTagAdapter merchantReviewTagAdapter = this.PlaceComponentResult;
        MerchantReviewTagAdapter merchantReviewTagAdapter2 = null;
        if (merchantReviewTagAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewTagAdapter = null;
        }
        SentimentState sentimentState2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((sentimentState2 instanceof SentimentState.Positive) && (sentimentState instanceof SentimentState.Positive)) {
            return;
        }
        if ((sentimentState2 instanceof SentimentState.Negative) && (sentimentState instanceof SentimentState.Negative)) {
            return;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 instanceof SentimentState.Positive) {
            this.getAuthRequestContext = getSelectedTags();
        } else {
            this.MyBillsEntityDataFactory = getSelectedTags();
        }
        LinkedList linkedList = (LinkedList) merchantReviewTagAdapter.PlaceComponentResult.getValue();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((MerchantReviewTagModel) it.next()).MyBillsEntityDataFactory = false;
        }
        linkedList.clear();
        boolean z = sentimentState instanceof SentimentState.Positive;
        if (z) {
            List<MerchantReviewTagModel> list = ((SentimentState.Positive) sentimentState).MyBillsEntityDataFactory;
            if (this.getAuthRequestContext.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                List<MerchantReviewTagModel> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (MerchantReviewTagModel merchantReviewTagModel : list2) {
                    if (merchantReviewTagModel.getMyBillsEntityDataFactory()) {
                        arrayList.add(merchantReviewTagModel);
                    }
                    arrayList2.add(Unit.INSTANCE);
                }
                this.getAuthRequestContext = arrayList;
            } else {
                List<MerchantReviewTagModel> list3 = list;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (MerchantReviewTagModel merchantReviewTagModel2 : list3) {
                    List<MerchantReviewTagModel> list4 = this.getAuthRequestContext;
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj : list4) {
                        if (Intrinsics.areEqual(((MerchantReviewTagModel) obj).PlaceComponentResult, merchantReviewTagModel2.PlaceComponentResult)) {
                            arrayList4.add(obj);
                        }
                    }
                    ArrayList<MerchantReviewTagModel> arrayList5 = arrayList4;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                    for (MerchantReviewTagModel merchantReviewTagModel3 : arrayList5) {
                        merchantReviewTagModel2.MyBillsEntityDataFactory = true;
                        arrayList6.add(Unit.INSTANCE);
                    }
                    arrayList3.add(arrayList6);
                }
            }
            MerchantReviewTagAdapter merchantReviewTagAdapter3 = this.PlaceComponentResult;
            if (merchantReviewTagAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantReviewTagAdapter3 = null;
            }
            List<MerchantReviewTagModel> list5 = this.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(list5, "");
            ((LinkedList) merchantReviewTagAdapter3.PlaceComponentResult.getValue()).clear();
            ((LinkedList) merchantReviewTagAdapter3.PlaceComponentResult.getValue()).addAll(list5);
        } else if (sentimentState instanceof SentimentState.Negative) {
            List<MerchantReviewTagModel> list6 = ((SentimentState.Negative) sentimentState).MyBillsEntityDataFactory;
            if (this.MyBillsEntityDataFactory.isEmpty()) {
                ArrayList arrayList7 = new ArrayList();
                List<MerchantReviewTagModel> list7 = list6;
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                for (MerchantReviewTagModel merchantReviewTagModel4 : list7) {
                    if (merchantReviewTagModel4.getMyBillsEntityDataFactory()) {
                        arrayList7.add(merchantReviewTagModel4);
                    }
                    arrayList8.add(Unit.INSTANCE);
                }
                this.MyBillsEntityDataFactory = arrayList7;
            } else {
                List<MerchantReviewTagModel> list8 = list6;
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                for (MerchantReviewTagModel merchantReviewTagModel5 : list8) {
                    List<MerchantReviewTagModel> list9 = this.MyBillsEntityDataFactory;
                    ArrayList arrayList10 = new ArrayList();
                    for (Object obj2 : list9) {
                        if (Intrinsics.areEqual(((MerchantReviewTagModel) obj2).PlaceComponentResult, merchantReviewTagModel5.PlaceComponentResult)) {
                            arrayList10.add(obj2);
                        }
                    }
                    ArrayList<MerchantReviewTagModel> arrayList11 = arrayList10;
                    ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList11, 10));
                    for (MerchantReviewTagModel merchantReviewTagModel6 : arrayList11) {
                        merchantReviewTagModel5.MyBillsEntityDataFactory = true;
                        arrayList12.add(Unit.INSTANCE);
                    }
                    arrayList9.add(arrayList12);
                }
            }
            MerchantReviewTagAdapter merchantReviewTagAdapter4 = this.PlaceComponentResult;
            if (merchantReviewTagAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantReviewTagAdapter4 = null;
            }
            List<MerchantReviewTagModel> list10 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(list10, "");
            ((LinkedList) merchantReviewTagAdapter4.PlaceComponentResult.getValue()).clear();
            ((LinkedList) merchantReviewTagAdapter4.PlaceComponentResult.getValue()).addAll(list10);
        }
        if (z) {
            Context context = getContext();
            if (context != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1900_lambda_getsettingcollection_2_id_dana_data_profilemenu_repository_settingsentityrepository);
                if (appCompatTextView != null) {
                    appCompatTextView.setText(context.getString(R.string.merchant_review_positive_title));
                }
                Unit unit = Unit.INSTANCE;
            }
            emptyList = ((SentimentState.Positive) sentimentState).MyBillsEntityDataFactory;
        } else if (sentimentState instanceof SentimentState.Negative) {
            Context context2 = getContext();
            if (context2 != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a1900_lambda_getsettingcollection_2_id_dana_data_profilemenu_repository_settingsentityrepository);
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setText(context2.getString(R.string.merchant_review_negative_title));
                }
                Unit unit2 = Unit.INSTANCE;
            }
            emptyList = ((SentimentState.Negative) sentimentState).MyBillsEntityDataFactory;
        } else if (!(sentimentState instanceof SentimentState.None)) {
            throw new NoWhenBranchMatchedException();
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        merchantReviewTagAdapter.setItems(emptyList);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sentimentState;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.showPreviewShopData);
        if (recyclerView != null) {
            MerchantReviewTagAdapter merchantReviewTagAdapter5 = this.PlaceComponentResult;
            if (merchantReviewTagAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantReviewTagAdapter2 = merchantReviewTagAdapter5;
            }
            recyclerView.setAdapter(merchantReviewTagAdapter2);
        }
    }

    public final List<MerchantReviewTagModel> getSelectedTags() {
        MerchantReviewTagAdapter merchantReviewTagAdapter = this.PlaceComponentResult;
        if (merchantReviewTagAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewTagAdapter = null;
        }
        return CollectionsKt.toList((LinkedList) merchantReviewTagAdapter.PlaceComponentResult.getValue());
    }
}
