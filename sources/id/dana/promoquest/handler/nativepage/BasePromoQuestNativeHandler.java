package id.dana.promoquest.handler.nativepage;

import android.content.Context;
import android.content.Intent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.promoquest.handler.PromoQuestActionHandler;

/* loaded from: classes5.dex */
public abstract class BasePromoQuestNativeHandler<T> implements PromoQuestActionHandler {
    private Intent MyBillsEntityDataFactory;
    private Context getAuthRequestContext;

    protected Intent MyBillsEntityDataFactory(Intent intent) {
        return intent;
    }

    public void MyBillsEntityDataFactory(T t) {
    }

    protected Class<T> PlaceComponentResult() {
        return null;
    }

    public BasePromoQuestNativeHandler(Context context) {
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = new Intent(context, (Class<?>) PlaceComponentResult());
    }

    public BasePromoQuestNativeHandler(Context context, T t) {
        this.getAuthRequestContext = context;
        MyBillsEntityDataFactory((BasePromoQuestNativeHandler<T>) t);
        this.MyBillsEntityDataFactory = new Intent(context, (Class<?>) PlaceComponentResult());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.putExtra("source", TrackerKey.SourceType.PROMOTION);
        this.getAuthRequestContext.startActivity(MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
