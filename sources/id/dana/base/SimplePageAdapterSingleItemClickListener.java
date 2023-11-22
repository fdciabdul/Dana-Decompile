package id.dana.base;

import id.dana.onboarding.view.SimplePagerAdapter;

/* loaded from: classes4.dex */
public abstract class SimplePageAdapterSingleItemClickListener implements SimplePagerAdapter.OnItemClickListener {
    MultipleClickHandler KClassImpl$Data$declaredNonStaticMembers$2;

    public abstract void getAuthRequestContext(int i);

    public SimplePageAdapterSingleItemClickListener(MultipleClickHandler multipleClickHandler) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = multipleClickHandler;
    }

    @Override // id.dana.onboarding.view.SimplePagerAdapter.OnItemClickListener
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        MultipleClickHandler multipleClickHandler = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (multipleClickHandler == null || !multipleClickHandler.isClickable()) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.disableClick();
        getAuthRequestContext(i);
    }
}
