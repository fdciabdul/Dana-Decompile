package id.dana.data.sendmoney;

import id.dana.domain.sendmoney.model.AddPayMethod;
import io.reactivex.Observable;
import java.util.Map;

/* loaded from: classes2.dex */
public interface AddPayMethodConfigEntityData {
    Observable<Map<String, AddPayMethod>> getAddPayMethodConfig();
}
