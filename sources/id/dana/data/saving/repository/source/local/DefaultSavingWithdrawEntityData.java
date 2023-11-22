package id.dana.data.saving.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.saving.repository.SavingWithdrawEntityData;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/saving/repository/source/local/DefaultSavingWithdrawEntityData;", "Lid/dana/data/saving/repository/SavingWithdrawEntityData;", "Lio/reactivex/Observable;", "", "", "getWithdrawOption", "()Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultSavingWithdrawEntityData implements SavingWithdrawEntityData {
    private static final String DEFAULT_SAVING_WITHDRAW_OPTION_JSON = "json/amcs-saving-withdraw-option.json";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultSavingWithdrawEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.saving.repository.SavingWithdrawEntityData
    public final Observable<List<String>> getWithdrawOption() {
        List<String> deserializeList = this.serializer.deserializeList(JsonUtil.PlaceComponentResult(this.context, DEFAULT_SAVING_WITHDRAW_OPTION_JSON));
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(deserializeList, "");
        Iterator<T> it = deserializeList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        Observable<List<String>> just = Observable.just(arrayList);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
