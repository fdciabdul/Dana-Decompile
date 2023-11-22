package id.dana.riskChallenges.data.passkey.source.local;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SecurityGuardPreference;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import id.dana.utils.extension.StringExtKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0003\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0005\u0010\u0013J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\n\u0010\u0014J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/account/AccountEntity;", "getAuthRequestContext", "()Lid/dana/data/account/AccountEntity;", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "PlaceComponentResult", "()Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "", "(Ljava/lang/String;)Z", "(Ljava/util/List;)V", "(Ljava/lang/String;)V", "Companion", "Factory", "Impl"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PasskeyPreferenceEntityData {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;

    void BuiltInFictitiousFunctionClassFactory();

    boolean BuiltInFictitiousFunctionClassFactory(String p0);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    String MyBillsEntityDataFactory();

    void MyBillsEntityDataFactory(List<PasskeyCredential> p0);

    String NetworkUserEntityData$$ExternalSyntheticLambda0();

    List<PasskeyCredential> PlaceComponentResult();

    void PlaceComponentResult(String p0);

    AccountEntity getAuthRequestContext();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }

    @RiskChallengesScope
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0003\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0005\u0010\u0013J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\n\u0010\u0014J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0015R\u0014\u0010\n\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Impl;", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/account/AccountEntity;", "getAuthRequestContext", "()Lid/dana/data/account/AccountEntity;", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "PlaceComponentResult", "()Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "", "(Ljava/lang/String;)Z", "(Ljava/util/List;)V", "(Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Impl implements PasskeyPreferenceEntityData {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private SecuredAccountPreferences KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final PreferenceFacade BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final Context MyBillsEntityDataFactory;

        @Inject
        public Impl(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            this.MyBillsEntityDataFactory = context;
            SecuredAccountPreferences securedAccountPreferences = new SecuredAccountPreferences(this.MyBillsEntityDataFactory, null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = securedAccountPreferences;
            securedAccountPreferences.init(CommonUtil.MyBillsEntityDataFactory(new SecurityGuardFacade(this.MyBillsEntityDataFactory), ""));
            SecurityGuardPreference buildSecurityGuardPreference = new LocalStorageFactory.Builder(context).setPreferenceGroup("passkey_prefsproduction").setUseDrutherPreference(true).buildSecurityGuardPreference();
            Intrinsics.checkNotNullExpressionValue(buildSecurityGuardPreference, "");
            this.BuiltInFictitiousFunctionClassFactory = buildSecurityGuardPreference;
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final void PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.BuiltInFictitiousFunctionClassFactory.saveData("key_security_id", p0);
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
            String string = this.BuiltInFictitiousFunctionClassFactory.getString("key_security_id");
            return string == null ? "" : string;
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final String MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.getString("key_credential_id");
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.BuiltInFictitiousFunctionClassFactory.clearData("key_security_id");
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final AccountEntity getAuthRequestContext() {
            SecuredAccountPreferences securedAccountPreferences = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (securedAccountPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                securedAccountPreferences = null;
            }
            AccountEntity account = securedAccountPreferences.getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "");
            return account;
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            PreferenceFacade preferenceFacade = this.BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(StringExtKt.PlaceComponentResult(p0));
            sb.append("_key_passkey_prompt_after_reset_pin");
            Boolean bool = preferenceFacade.getBoolean(sb.toString());
            Intrinsics.checkNotNullExpressionValue(bool, "");
            return bool.booleanValue();
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            PreferenceFacade preferenceFacade = this.BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(StringExtKt.PlaceComponentResult(p0));
            sb.append("_key_passkey_force_prompt");
            Boolean bool = preferenceFacade.getBoolean(sb.toString());
            Intrinsics.checkNotNullExpressionValue(bool, "");
            return bool.booleanValue();
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final void MyBillsEntityDataFactory(List<PasskeyCredential> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.BuiltInFictitiousFunctionClassFactory.saveData("key_passkey_credentials", JSON.toJSONString(p0));
            String credentialId = ((PasskeyCredential) CollectionsKt.first((List) p0)).getCredentialId();
            Intrinsics.checkNotNullParameter(credentialId, "");
            this.BuiltInFictitiousFunctionClassFactory.saveData("key_credential_id", credentialId);
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final List<PasskeyCredential> PlaceComponentResult() {
            List m3179constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Impl impl = this;
                String string = this.BuiltInFictitiousFunctionClassFactory.getString("key_passkey_credentials");
                if (string == null) {
                    string = "[]";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                }
                m3179constructorimpl = Result.m3179constructorimpl(JSON.parseArray(string, PasskeyCredential.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
            List emptyList = CollectionsKt.emptyList();
            if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                m3179constructorimpl = emptyList;
            }
            return (List) m3179constructorimpl;
        }

        @Override // id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.BuiltInFictitiousFunctionClassFactory.clearData("key_passkey_credentials");
            this.BuiltInFictitiousFunctionClassFactory.clearData("key_credential_id");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData;", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Impl;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Impl;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Impl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory extends AbstractEntityDataFactory<PasskeyPreferenceEntityData> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final Impl getAuthRequestContext;

        @Inject
        public Factory(Impl impl) {
            Intrinsics.checkNotNullParameter(impl, "");
            this.getAuthRequestContext = impl;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        @Override // id.dana.data.AbstractEntityDataFactory
        /* renamed from: createData */
        public final /* synthetic */ PasskeyPreferenceEntityData createData2(String str) {
            if (Intrinsics.areEqual(str, "local")) {
                return this.getAuthRequestContext;
            }
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }
    }
}
