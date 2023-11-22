package id.dana.network.base;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.exception.NetworkException;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public class ExceptionParserSingle<T extends BaseRpcResult> implements Function<T, Single<T>> {
    private Context context;
    private String operationType;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
        return apply((ExceptionParserSingle<T>) ((BaseRpcResult) obj));
    }

    public Single<T> apply(T t) throws Exception {
        if (t == null) {
            return Single.getAuthRequestContext(new NoSuchElementException());
        }
        if (!t.success) {
            return Single.getAuthRequestContext(new NetworkException(t));
        }
        return Single.MyBillsEntityDataFactory(t);
    }

    public String getOperationType() {
        return this.operationType;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
