package id.dana.kyb.data.repository.source.local;

import android.content.Context;
import com.alibaba.fastjson.TypeReference;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.domain.promotion.Space;
import id.dana.kyb.data.KybPreferenceEntityData;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0007\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\u0013J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0003\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u001bX\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u001c"}, d2 = {"Lid/dana/kyb/data/repository/source/local/LocalKybPreferenceEntityData;", "Lid/dana/kyb/data/KybPreferenceEntityData;", "", "MyBillsEntityDataFactory", "()V", "Lio/reactivex/Observable;", "Lid/dana/domain/promotion/Space;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "PlaceComponentResult", "", "p0", "(Ljava/lang/String;)Lio/reactivex/Observable;", "(Lid/dana/domain/promotion/Space;)V", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/kyb/domain/model/KybMerchantInfo;)V", "(Lid/dana/kyb/domain/model/TransactionListQueryInfo;)V", "p1", "", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/kyb/data/repository/source/local/KybPreference;", "Lid/dana/kyb/data/repository/source/local/KybPreference;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "p2", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lid/dana/kyb/data/repository/source/local/KybPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalKybPreferenceEntityData implements KybPreferenceEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final KybPreference MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Serializer getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    @Inject
    public LocalKybPreferenceEntityData(Context context, Serializer serializer, KybPreference kybPreference) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(kybPreference, "");
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = serializer;
        this.MyBillsEntityDataFactory = kybPreference;
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final Observable<Boolean> MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final Observable<String> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KybPreference kybPreference = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = kybPreference.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("kyb_last_transaction_id");
        sb.append(p0);
        String string = preferenceFacade.getString(sb.toString());
        if (string == null) {
            string = "";
        }
        Observable<String> just = Observable.just(string);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final void BuiltInFictitiousFunctionClassFactory(KybMerchantInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String authRequestContext = JsonUtil.getAuthRequestContext(p0);
        KybPreference kybPreference = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        kybPreference.BuiltInFictitiousFunctionClassFactory(authRequestContext);
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final Observable<KybMerchantInfo> KClassImpl$Data$declaredNonStaticMembers$2() {
        KybMerchantInfo kybMerchantInfo = (KybMerchantInfo) JsonUtil.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("kyb_merchant_info"), new TypeReference<KybMerchantInfo>() { // from class: id.dana.kyb.data.repository.source.local.LocalKybPreferenceEntityData$getKybMerchantInfo$model$1
        });
        Observable<KybMerchantInfo> just = kybMerchantInfo != null ? Observable.just(kybMerchantInfo) : null;
        if (just == null) {
            Observable<KybMerchantInfo> error = Observable.error(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        return just;
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final void getAuthRequestContext(TransactionListQueryInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String authRequestContext = JsonUtil.getAuthRequestContext(p0);
        KybPreference kybPreference = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        kybPreference.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final Observable<TransactionListQueryInfo> PlaceComponentResult() {
        TransactionListQueryInfo transactionListQueryInfo = (TransactionListQueryInfo) JsonUtil.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("kyb_transaction_history"), new TypeReference<TransactionListQueryInfo>() { // from class: id.dana.kyb.data.repository.source.local.LocalKybPreferenceEntityData$getKybTransactionHistory$model$1
        });
        Observable<TransactionListQueryInfo> just = transactionListQueryInfo != null ? Observable.just(transactionListQueryInfo) : null;
        if (just == null) {
            Observable<TransactionListQueryInfo> error = Observable.error(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        return just;
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final void MyBillsEntityDataFactory(Space p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String authRequestContext = JsonUtil.getAuthRequestContext(p0);
        KybPreference kybPreference = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        kybPreference.MyBillsEntityDataFactory(authRequestContext);
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final Observable<Space> getAuthRequestContext() {
        Space space = (Space) JsonUtil.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("kyb_banner"), new TypeReference<Space>() { // from class: id.dana.kyb.data.repository.source.local.LocalKybPreferenceEntityData$getKybBanner$model$1
        });
        Observable<Space> just = space != null ? Observable.just(space) : null;
        if (just == null) {
            Observable<Space> error = Observable.error(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        return just;
    }

    @Override // id.dana.kyb.data.KybPreferenceEntityData
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.clearAllData();
    }
}
