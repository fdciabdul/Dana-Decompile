package id.dana.data.sendmoney.repository.source.local;

import id.dana.data.sendmoney.repository.SortingSendMoneyPreferenceEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/sendmoney/repository/source/local/PreferenceSortingSendMoneyEntityData;", "Lid/dana/data/sendmoney/repository/SortingSendMoneyPreferenceEntityData;", "Lio/reactivex/Observable;", "", "getSortingSendMoney", "()Lio/reactivex/Observable;", "sortedBy", "", "saveSortingSendMoney", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/sendmoney/repository/source/local/SortingSendMoneyPreference;", "sortingSendMoneyPreference", "Lid/dana/data/sendmoney/repository/source/local/SortingSendMoneyPreference;", "<init>", "(Lid/dana/data/sendmoney/repository/source/local/SortingSendMoneyPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreferenceSortingSendMoneyEntityData implements SortingSendMoneyPreferenceEntityData {
    private final SortingSendMoneyPreference sortingSendMoneyPreference;

    @Inject
    public PreferenceSortingSendMoneyEntityData(SortingSendMoneyPreference sortingSendMoneyPreference) {
        Intrinsics.checkNotNullParameter(sortingSendMoneyPreference, "");
        this.sortingSendMoneyPreference = sortingSendMoneyPreference;
    }

    @Override // id.dana.data.sendmoney.repository.SortingSendMoneyPreferenceEntityData
    public final Observable<Boolean> saveSortingSendMoney(String sortedBy) {
        Intrinsics.checkNotNullParameter(sortedBy, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sortingSendMoneyPreference.saveSortingSendMoney(sortedBy)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SortingSendMoneyPreferenceEntityData
    public final Observable<String> getSortingSendMoney() {
        Observable<String> just = Observable.just(this.sortingSendMoneyPreference.getSortingSendMoney());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
