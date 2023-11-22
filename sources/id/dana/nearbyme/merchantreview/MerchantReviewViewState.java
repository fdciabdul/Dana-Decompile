package id.dana.nearbyme.merchantreview;

import androidx.arch.core.util.Function;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import androidx.view.Transformations;
import id.dana.domain.nearbyme.model.Tag;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewDialogDismissState;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.merchantreview.model.SentimentState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0018¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\f\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0012R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\f\u001a\u00020\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\n\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u001b\u0010\u001e\u001a\f\u0012\b\u0012\u0006*\u00020\u00040\u00040\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001c\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u001bX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010 \u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0006¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewViewState;", "", "", "p0", "", "p1", "MyBillsEntityDataFactory", "(ZI)Z", "", "", "PlaceComponentResult", "()Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/Tag;", "", "(Ljava/util/List;Z)V", "Landroidx/lifecycle/MediatorLiveData;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/MediatorLiveData;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewDialogDismissState;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewDialogDismissState;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "scheduleImpl", "Landroidx/lifecycle/MutableLiveData;", "lookAheadTest", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/lifecycle/LiveData;", "Lid/dana/nearbyme/merchantreview/model/SentimentState;", "getErrorConfigVersion", "Landroidx/lifecycle/LiveData;", "<init>", "(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewViewState {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final MediatorLiveData<Boolean> getAuthRequestContext;
    MerchantReviewDialogDismissState KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    MutableLiveData<Boolean> scheduleImpl;
    final MerchantConsultReviewModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    String MyBillsEntityDataFactory;
    final LiveData<SentimentState> getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final MutableLiveData<Integer> lookAheadTest;

    private static boolean MyBillsEntityDataFactory(boolean p0, int p1) {
        return !p0 && p1 > 0;
    }

    public MerchantReviewViewState(MerchantConsultReviewModel merchantConsultReviewModel) {
        Intrinsics.checkNotNullParameter(merchantConsultReviewModel, "");
        this.PlaceComponentResult = merchantConsultReviewModel;
        List<MerchantReviewTagModel> list = merchantConsultReviewModel.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MerchantReviewTagModel merchantReviewTagModel = (MerchantReviewTagModel) next;
            if (!(Intrinsics.areEqual(merchantReviewTagModel.PlaceComponentResult, "4") || Intrinsics.areEqual(merchantReviewTagModel.PlaceComponentResult, "8"))) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, "");
        merchantConsultReviewModel.BuiltInFictitiousFunctionClassFactory = arrayList2;
        MerchantConsultReviewModel merchantConsultReviewModel2 = this.PlaceComponentResult;
        List<MerchantReviewTagModel> list2 = merchantConsultReviewModel2.PlaceComponentResult;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list2) {
            if (!Intrinsics.areEqual(((MerchantReviewTagModel) obj).PlaceComponentResult, "7")) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        Intrinsics.checkNotNullParameter(arrayList4, "");
        merchantConsultReviewModel2.PlaceComponentResult = arrayList4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MerchantReviewDialogDismissState.EMPTY;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this.lookAheadTest = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = mutableLiveData;
        LiveData<SentimentState> authRequestContext = Transformations.getAuthRequestContext(mutableLiveData2, new Function() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewViewState$special$$inlined$map$1
            @Override // androidx.arch.core.util.Function
            public final SentimentState getAuthRequestContext(Integer num) {
                return MerchantReviewViewState.getAuthRequestContext(MerchantReviewViewState.this, num.intValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.getErrorConfigVersion = authRequestContext;
        this.moveToNextValue = "";
        this.scheduleImpl = new MutableLiveData<>(Boolean.FALSE);
        final MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.getAuthRequestContext(mutableLiveData2, new Observer() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewViewState$$ExternalSyntheticLambda0
            @Override // androidx.view.Observer
            public final void onChanged(Object obj2) {
                MerchantReviewViewState.BuiltInFictitiousFunctionClassFactory(MediatorLiveData.this, this, (Integer) obj2);
            }
        });
        mediatorLiveData.getAuthRequestContext(this.scheduleImpl, new Observer() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewViewState$$ExternalSyntheticLambda1
            @Override // androidx.view.Observer
            public final void onChanged(Object obj2) {
                MerchantReviewViewState.PlaceComponentResult(MediatorLiveData.this, this, (Boolean) obj2);
            }
        });
        this.getAuthRequestContext = mediatorLiveData;
    }

    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        List<MerchantReviewTagModel> list = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MerchantReviewTagModel) obj).getMyBillsEntityDataFactory()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((MerchantReviewTagModel) it.next()).BuiltInFictitiousFunctionClassFactory);
        }
        return arrayList3;
    }

    public final List<String> PlaceComponentResult() {
        List<MerchantReviewTagModel> list = this.PlaceComponentResult.PlaceComponentResult;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MerchantReviewTagModel) obj).getMyBillsEntityDataFactory()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((MerchantReviewTagModel) it.next()).BuiltInFictitiousFunctionClassFactory);
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext(List<MerchantReviewTagModel> p0) {
        return CollectionsKt.joinToString$default(p0, ",", null, null, 0, null, new Function1<MerchantReviewTagModel, CharSequence>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewViewState$getSelectedTagForAnalytic$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MerchantReviewTagModel merchantReviewTagModel) {
                Intrinsics.checkNotNullParameter(merchantReviewTagModel, "");
                return merchantReviewTagModel.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }, 30, null);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<Tag> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p1) {
            for (MerchantReviewTagModel merchantReviewTagModel : this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : p0) {
                    if (Intrinsics.areEqual(((Tag) obj).getId(), merchantReviewTagModel.PlaceComponentResult)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<Tag> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (Tag tag : arrayList2) {
                    merchantReviewTagModel.MyBillsEntityDataFactory = true;
                    arrayList3.add(Unit.INSTANCE);
                }
            }
            return;
        }
        for (MerchantReviewTagModel merchantReviewTagModel2 : this.PlaceComponentResult.PlaceComponentResult) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : p0) {
                if (Intrinsics.areEqual(((Tag) obj2).getId(), merchantReviewTagModel2.PlaceComponentResult)) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList<Tag> arrayList5 = arrayList4;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            for (Tag tag2 : arrayList5) {
                merchantReviewTagModel2.MyBillsEntityDataFactory = true;
                arrayList6.add(Unit.INSTANCE);
            }
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MediatorLiveData mediatorLiveData, MerchantReviewViewState merchantReviewViewState, Integer num) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "");
        Intrinsics.checkNotNullParameter(merchantReviewViewState, "");
        Object obj = merchantReviewViewState.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        boolean booleanValue = bool.booleanValue();
        Intrinsics.checkNotNullExpressionValue(num, "");
        mediatorLiveData.PlaceComponentResult((MediatorLiveData) Boolean.valueOf(MyBillsEntityDataFactory(booleanValue, num.intValue())));
    }

    public static /* synthetic */ void PlaceComponentResult(MediatorLiveData mediatorLiveData, MerchantReviewViewState merchantReviewViewState, Boolean bool) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "");
        Intrinsics.checkNotNullParameter(merchantReviewViewState, "");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        boolean booleanValue = bool.booleanValue();
        Object obj = merchantReviewViewState.lookAheadTest.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        int i = (Integer) obj;
        if (i == null) {
            i = 0;
        }
        mediatorLiveData.PlaceComponentResult((MediatorLiveData) Boolean.valueOf(MyBillsEntityDataFactory(booleanValue, i.intValue())));
    }

    public static final /* synthetic */ SentimentState getAuthRequestContext(MerchantReviewViewState merchantReviewViewState, int i) {
        if (i == 4 || i == 5) {
            return new SentimentState.Positive(merchantReviewViewState.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
        return new SentimentState.Negative(merchantReviewViewState.PlaceComponentResult.PlaceComponentResult);
    }
}
