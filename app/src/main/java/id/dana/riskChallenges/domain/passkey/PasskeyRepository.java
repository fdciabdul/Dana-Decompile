package id.dana.riskChallenges.domain.passkey;

import com.alibaba.fastjson.JSONObject;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\rJ#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00072\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\u0005\u0010\u0010J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000e0\u000b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u0011\u0010\u0015J/\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000e0\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\b\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "", "Lcom/alibaba/fastjson/JSONObject;", "p0", "Lio/reactivex/Completable;", "PlaceComponentResult", "(Lcom/alibaba/fastjson/JSONObject;)Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "(Z)Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "(Lcom/alibaba/fastjson/JSONObject;)Lio/reactivex/Observable;", "p1", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PasskeyRepository {
    Observable<Boolean> MyBillsEntityDataFactory(JSONObject p0);

    Observable<Pair<JSONObject, List<VerificationMethodModel>>> MyBillsEntityDataFactory(String p0, String p1);

    Completable PlaceComponentResult(JSONObject p0);

    Observable<Pair<Boolean, Boolean>> PlaceComponentResult(String p0);

    Observable<List<PasskeyCredential>> PlaceComponentResult(boolean p0);

    Observable<JSONObject> getAuthRequestContext();

    Observable<Pair<String, List<VerificationMethodModel>>> getAuthRequestContext(boolean p0);
}
