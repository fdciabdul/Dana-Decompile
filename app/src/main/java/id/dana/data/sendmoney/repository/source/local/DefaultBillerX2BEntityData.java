package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.sendmoney.BillerX2BEntityData;
import id.dana.data.sendmoney.model.BillerX2BEntity;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/sendmoney/repository/source/local/DefaultBillerX2BEntityData;", "Lid/dana/data/sendmoney/BillerX2BEntityData;", "Lio/reactivex/Observable;", "", "Lid/dana/data/sendmoney/model/BillerX2BEntity;", "getListBillerX2B", "()Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultBillerX2BEntityData implements BillerX2BEntityData {
    public static final String ALL_BILLER_X2B_DATA = "json/default-x2b-redirect-all-biller-data.json";
    private final Context context;

    @Inject
    public DefaultBillerX2BEntityData(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @Override // id.dana.data.sendmoney.BillerX2BEntityData
    public final Observable<List<BillerX2BEntity>> getListBillerX2B() {
        Observable<List<BillerX2BEntity>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultBillerX2BEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1918getListBillerX2B$lambda0;
                m1918getListBillerX2B$lambda0 = DefaultBillerX2BEntityData.m1918getListBillerX2B$lambda0(DefaultBillerX2BEntityData.this);
                return m1918getListBillerX2B$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListBillerX2B$lambda-0  reason: not valid java name */
    public static final List m1918getListBillerX2B$lambda0(DefaultBillerX2BEntityData defaultBillerX2BEntityData) {
        Intrinsics.checkNotNullParameter(defaultBillerX2BEntityData, "");
        Object obj = null;
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(JsonUtil.PlaceComponentResult(defaultBillerX2BEntityData.context, ALL_BILLER_X2B_DATA), null), (Class<Object>) List.class);
        } catch (Exception unused) {
        }
        List list = (List) obj;
        if (list != null) {
            return list;
        }
        throw new CallableReturnNullError("DefaultBillerX2BEntityData#getListBillerX2B");
    }
}
