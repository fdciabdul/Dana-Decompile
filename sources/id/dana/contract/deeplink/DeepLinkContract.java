package id.dana.contract.deeplink;

import android.app.Activity;
import android.content.Intent;
import id.dana.base.AbstractContractKt;
import id.dana.domain.deeplink.model.OauthParams;
import id.dana.model.DeepLinkPayloadModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/deeplink/DeepLinkContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DeepLinkContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/deeplink/DeepLinkContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "PlaceComponentResult", "(Z)V", "Landroid/app/Activity;", "getAuthRequestContext", "(Landroid/app/Activity;)V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(Activity p0);

        void PlaceComponentResult(boolean p0);

        void getAuthRequestContext(Activity p0);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\f\u0010\u000fJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J)\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013JI\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\t\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0017J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0018H&¢\u0006\u0004\b\n\u0010\u0019J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u0005\u0010\u001bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028'X¦\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/deeplink/DeepLinkContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Ljava/util/Map;)V", "Landroid/content/Intent;", "(Ljava/lang/String;Landroid/content/Intent;)V", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Lorg/json/JSONObject;", "p3", "p4", "(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;Ljava/lang/String;)V", "Lid/dana/domain/deeplink/model/OauthParams;", "(Lid/dana/domain/deeplink/model/OauthParams;)V", "Lid/dana/model/DeepLinkPayloadModel;", "(Lid/dana/model/DeepLinkPayloadModel;)V", "()Ljava/lang/String;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String p0, String p1);

        void BuiltInFictitiousFunctionClassFactory(String str, Map<String, String> map, JSONObject jSONObject, String str2);

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        String KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(OauthParams p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, Map<String, String> p1, String p2);

        void MyBillsEntityDataFactory(String p0, Intent p1);

        void MyBillsEntityDataFactory(Map<String, String> p0);

        void PlaceComponentResult(String p0, String p1, String p2);

        void getAuthRequestContext(DeepLinkPayloadModel p0);

        void getAuthRequestContext(String p0);
    }
}
