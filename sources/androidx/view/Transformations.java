package androidx.view;

import androidx.arch.core.util.Function;
import androidx.view.MediatorLiveData;

/* loaded from: classes3.dex */
public class Transformations {
    private Transformations() {
    }

    public static <X, Y> LiveData<Y> getAuthRequestContext(LiveData<X> liveData, final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.getAuthRequestContext(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.view.Observer
            public void onChanged(X x) {
                MediatorLiveData.this.PlaceComponentResult((MediatorLiveData) function.getAuthRequestContext(x));
            }
        });
        return mediatorLiveData;
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2<X> implements Observer<X> {
        final /* synthetic */ MediatorLiveData KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Function MyBillsEntityDataFactory;
        LiveData<Y> PlaceComponentResult;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.view.Observer
        public void onChanged(X x) {
            MediatorLiveData.Source source;
            LiveData<Y> liveData = (LiveData) this.MyBillsEntityDataFactory.getAuthRequestContext(x);
            Object obj = this.PlaceComponentResult;
            if (obj == liveData) {
                return;
            }
            if (obj != null && (source = (MediatorLiveData.Source) this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(obj)) != null) {
                source.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(source);
            }
            this.PlaceComponentResult = liveData;
            if (liveData != 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(liveData, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                    @Override // androidx.view.Observer
                    public void onChanged(Y y) {
                        AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult((MediatorLiveData) y);
                    }
                });
            }
        }
    }

    public static <X> LiveData<X> KClassImpl$Data$declaredNonStaticMembers$2(LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.getAuthRequestContext(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

            @Override // androidx.view.Observer
            public void onChanged(X x) {
                Object obj = MediatorLiveData.this.BuiltInFictitiousFunctionClassFactory;
                if (obj == LiveData.MyBillsEntityDataFactory) {
                    obj = null;
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 || ((obj == null && x != null) || !(obj == null || obj.equals(x)))) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    MediatorLiveData.this.PlaceComponentResult((MediatorLiveData) x);
                }
            }
        });
        return mediatorLiveData;
    }
}
