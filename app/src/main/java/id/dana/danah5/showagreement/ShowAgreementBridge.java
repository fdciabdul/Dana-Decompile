package id.dana.danah5.showagreement;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.widget.Toast;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.iap.ac.android.acs.plugin.utils.Constants;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.danah5.DanaH5;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.useragreement.interactor.BuildAgreementContent;
import id.dana.domain.useragreement.interactor.BuildIncompleteUserDataContent;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.RecordAgreement;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.miniprogram.provider.OauthServiceProvider;
import id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity;
import id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity;
import id.dana.utils.ContextUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 g2\u00020\u0001:\u0002hgB\u0007¢\u0006\u0004\bf\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\r\u001a\u00020\u00062\u001c\b\u0004\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060\tH\u0082\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0010J%\u0010%\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0010R\"\u0010(\u001a\u00020\u001d8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0016\u0010FR\"\u0010H\u001a\u00020G8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0018\u0010cR\u0016\u0010d\u001a\u00020#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010e"}, d2 = {"Lid/dana/danah5/showagreement/ShowAgreementBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/app/api/Page;", "page", "Lcom/alibaba/fastjson/JSONObject;", "info", "", BridgeName.CONFIRM_USER_INFO, "(Lcom/alibaba/ariver/app/api/Page;Lcom/alibaba/fastjson/JSONObject;)V", "Lkotlin/Function1;", "", "Lid/dana/domain/oauth/model/Agreement;", "onAgreementContentReturned", "getAgreementContentForPost", "(Lkotlin/jvm/functions/Function1;)V", "onInitialized", "()V", "Lid/dana/danah5/showagreement/ShowAgreementBridge$AgreementMessageEvent;", "event", "onReceiveAgreementMessageEvent", "(Lid/dana/danah5/showagreement/ShowAgreementBridge$AgreementMessageEvent;)V", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "consultAgreementResponse", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "service", "onSuccessConsultAgreement", "(Lid/dana/domain/useragreement/model/ConsultAgreementResponse;Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "sendAuthCode", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", BridgeName.SHOW_AGREEMENT, "(Lcom/alibaba/ariver/app/api/Page;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "showEmailUnverifiedDialog", "", "", "incompleteUserData", "showMissingRequiredUserInfoDialog", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;Ljava/util/Set;)V", "showTncServiceDialog", "agreementCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "getAgreementCallback", "()Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "setAgreementCallback", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", "agreementMap", "Ljava/util/Map;", "Lid/dana/domain/useragreement/interactor/BuildAgreementContent;", "buildAgreementContent", "Lid/dana/domain/useragreement/interactor/BuildAgreementContent;", "getBuildAgreementContent", "()Lid/dana/domain/useragreement/interactor/BuildAgreementContent;", "setBuildAgreementContent", "(Lid/dana/domain/useragreement/interactor/BuildAgreementContent;)V", "Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;", "buildIncompleteUserDataContent", "Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;", "getBuildIncompleteUserDataContent", "()Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;", "setBuildIncompleteUserDataContent", "(Lid/dana/domain/useragreement/interactor/BuildIncompleteUserDataContent;)V", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "consultAgreement", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "getConsultAgreement", "()Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "setConsultAgreement", "(Lid/dana/domain/useragreement/interactor/ConsultAgreement;)V", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "Lid/dana/domain/authcode/interactor/GetAuthCode;", Constants.JS_API_GET_AUTH_CODE, "Lid/dana/domain/authcode/interactor/GetAuthCode;", "getGetAuthCode", "()Lid/dana/domain/authcode/interactor/GetAuthCode;", "setGetAuthCode", "(Lid/dana/domain/authcode/interactor/GetAuthCode;)V", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "getEmptyUserInfo", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "getGetEmptyUserInfo", "()Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "setGetEmptyUserInfo", "(Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;)V", "Lid/dana/domain/services/interactor/GetService;", "getService", "Lid/dana/domain/services/interactor/GetService;", "getGetService", "()Lid/dana/domain/services/interactor/GetService;", "setGetService", "(Lid/dana/domain/services/interactor/GetService;)V", "Lid/dana/domain/useragreement/interactor/RecordAgreement;", "recordAgreement", "Lid/dana/domain/useragreement/interactor/RecordAgreement;", "getRecordAgreement", "()Lid/dana/domain/useragreement/interactor/RecordAgreement;", "setRecordAgreement", "(Lid/dana/domain/useragreement/interactor/RecordAgreement;)V", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", DanaH5.SERVICE_KEY, "Ljava/lang/String;", "<init>", "Companion", "AgreementMessageEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShowAgreementBridge extends BaseBridge {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String GENERAL_ERROR = "001";
    public static final String INCOMPLETE_USER_INFO = "003";
    public static final String MERCHANT_PAGE_AGREEMENT_TYPE = "MERCHANT_PAGE";
    public static final String MINI_PROGRAM_PREFIX = "MINIPROGRAM_";
    public static final String UNVERIFIED_EMAIL = "004";
    public static final String USER_DENY = "002";
    private static boolean confirmUserInfo_wasCalled;
    public BridgeCallback agreementCallback;
    @Inject
    public BuildAgreementContent buildAgreementContent;
    @Inject
    public BuildIncompleteUserDataContent buildIncompleteUserDataContent;
    @Inject
    public ConsultAgreement consultAgreement;
    private ConsultAgreementResponse consultAgreementResponse;
    @Inject
    public GetAuthCode getAuthCode;
    @Inject
    public GetEmptyUserInfo getEmptyUserInfo;
    @Inject
    public GetService getService;
    @Inject
    public RecordAgreement recordAgreement;
    private ThirdPartyServiceResponse service;
    private final Map<String, String> agreementMap = new LinkedHashMap();
    private String serviceKey = "";

    @JvmName(name = "getGetService")
    public final GetService getGetService() {
        GetService getService = this.getService;
        if (getService != null) {
            return getService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetService")
    public final void setGetService(GetService getService) {
        Intrinsics.checkNotNullParameter(getService, "");
        this.getService = getService;
    }

    @JvmName(name = "getConsultAgreement")
    public final ConsultAgreement getConsultAgreement() {
        ConsultAgreement consultAgreement = this.consultAgreement;
        if (consultAgreement != null) {
            return consultAgreement;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setConsultAgreement")
    public final void setConsultAgreement(ConsultAgreement consultAgreement) {
        Intrinsics.checkNotNullParameter(consultAgreement, "");
        this.consultAgreement = consultAgreement;
    }

    @JvmName(name = "getRecordAgreement")
    public final RecordAgreement getRecordAgreement() {
        RecordAgreement recordAgreement = this.recordAgreement;
        if (recordAgreement != null) {
            return recordAgreement;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRecordAgreement")
    public final void setRecordAgreement(RecordAgreement recordAgreement) {
        Intrinsics.checkNotNullParameter(recordAgreement, "");
        this.recordAgreement = recordAgreement;
    }

    @JvmName(name = "getGetEmptyUserInfo")
    public final GetEmptyUserInfo getGetEmptyUserInfo() {
        GetEmptyUserInfo getEmptyUserInfo = this.getEmptyUserInfo;
        if (getEmptyUserInfo != null) {
            return getEmptyUserInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetEmptyUserInfo")
    public final void setGetEmptyUserInfo(GetEmptyUserInfo getEmptyUserInfo) {
        Intrinsics.checkNotNullParameter(getEmptyUserInfo, "");
        this.getEmptyUserInfo = getEmptyUserInfo;
    }

    @JvmName(name = "getGetAuthCode")
    public final GetAuthCode getGetAuthCode() {
        GetAuthCode getAuthCode = this.getAuthCode;
        if (getAuthCode != null) {
            return getAuthCode;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetAuthCode")
    public final void setGetAuthCode(GetAuthCode getAuthCode) {
        Intrinsics.checkNotNullParameter(getAuthCode, "");
        this.getAuthCode = getAuthCode;
    }

    @JvmName(name = "getBuildIncompleteUserDataContent")
    public final BuildIncompleteUserDataContent getBuildIncompleteUserDataContent() {
        BuildIncompleteUserDataContent buildIncompleteUserDataContent = this.buildIncompleteUserDataContent;
        if (buildIncompleteUserDataContent != null) {
            return buildIncompleteUserDataContent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBuildIncompleteUserDataContent")
    public final void setBuildIncompleteUserDataContent(BuildIncompleteUserDataContent buildIncompleteUserDataContent) {
        Intrinsics.checkNotNullParameter(buildIncompleteUserDataContent, "");
        this.buildIncompleteUserDataContent = buildIncompleteUserDataContent;
    }

    @JvmName(name = "getBuildAgreementContent")
    public final BuildAgreementContent getBuildAgreementContent() {
        BuildAgreementContent buildAgreementContent = this.buildAgreementContent;
        if (buildAgreementContent != null) {
            return buildAgreementContent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBuildAgreementContent")
    public final void setBuildAgreementContent(BuildAgreementContent buildAgreementContent) {
        Intrinsics.checkNotNullParameter(buildAgreementContent, "");
        this.buildAgreementContent = buildAgreementContent;
    }

    @JvmName(name = "getAgreementCallback")
    public final BridgeCallback getAgreementCallback() {
        BridgeCallback bridgeCallback = this.agreementCallback;
        if (bridgeCallback != null) {
            return bridgeCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAgreementCallback")
    public final void setAgreementCallback(BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.agreementCallback = bridgeCallback;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void showAgreement(@BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback callback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(callback, "");
        this.agreementMap.clear();
        setAgreementCallback(callback);
        String string = page.getStartParams().getString(DanaH5.SERVICE_KEY);
        if (string == null) {
            return;
        }
        this.serviceKey = string;
        getGetService().execute(this.serviceKey, new Function1<ThirdPartyServiceResponse, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                invoke2(thirdPartyServiceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final ThirdPartyServiceResponse thirdPartyServiceResponse) {
                List<String> listOf;
                String str;
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                ShowAgreementBridge.this.service = thirdPartyServiceResponse;
                if (thirdPartyServiceResponse.getNeedConsult()) {
                    if (Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "GET")) {
                        listOf = thirdPartyServiceResponse.getSpaceCodes();
                        if (listOf == null) {
                            listOf = CollectionsKt.emptyList();
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(ShowAgreementBridge.MINI_PROGRAM_PREFIX);
                        sb.append(thirdPartyServiceResponse.getClientId());
                        listOf = CollectionsKt.listOf(sb.toString());
                    }
                    List<String> list = listOf;
                    String str2 = Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "POST") ? ShowAgreementBridge.MERCHANT_PAGE_AGREEMENT_TYPE : null;
                    ConsultAgreement consultAgreement = ShowAgreementBridge.this.getConsultAgreement();
                    str = ShowAgreementBridge.this.serviceKey;
                    String scopes = thirdPartyServiceResponse.getScopes();
                    ConsultAgreement.Params params = new ConsultAgreement.Params(str, list, str2, scopes == null ? "" : scopes, null, false);
                    final ShowAgreementBridge showAgreementBridge = ShowAgreementBridge.this;
                    Function1<ConsultAgreementResponse, Unit> function1 = new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showAgreement$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                            invoke2(consultAgreementResponse);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                            Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                            ShowAgreementBridge.this.consultAgreementResponse = consultAgreementResponse;
                            ShowAgreementBridge.this.onSuccessConsultAgreement(consultAgreementResponse, thirdPartyServiceResponse);
                        }
                    };
                    final BridgeCallback bridgeCallback = callback;
                    consultAgreement.execute(params, function1, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showAgreement$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "");
                            BridgeCallback bridgeCallback2 = BridgeCallback.this;
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = jSONObject;
                            jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                            jSONObject2.put((JSONObject) "error", "001");
                            bridgeCallback2.sendJSONResponse(jSONObject);
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showAgreement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                BridgeCallback bridgeCallback = BridgeCallback.this;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                jSONObject2.put((JSONObject) "error", "001");
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void confirmUserInfo(@BindingNode(Page.class) Page page, @BindingParam(name = {"info"}) JSONObject info) {
        Activity activity;
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(info, "");
        confirmUserInfo_wasCalled = true;
        Boolean bool = info.getBoolean("success");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            if (ContextUtil.BuiltInFictitiousFunctionClassFactory(BridgeExtensionExtKt.getActivity(page)) && (activity = BridgeExtensionExtKt.getActivity(page)) != null) {
                activity.finish();
            }
            if (info.containsKey(DanaH5.SERVICE_KEY)) {
                final String string = info.getString(DanaH5.SERVICE_KEY);
                final String string2 = info.getString("scopes");
                GetService getService = getGetService();
                Intrinsics.checkNotNullExpressionValue(string, "");
                getService.execute(string, new Function1<ThirdPartyServiceResponse, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$confirmUserInfo$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                        invoke2(thirdPartyServiceResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                        Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                        GetEmptyUserInfo getEmptyUserInfo = ShowAgreementBridge.this.getGetEmptyUserInfo();
                        String str = string;
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        String str2 = string2;
                        Intrinsics.checkNotNullExpressionValue(str2, "");
                        GetEmptyUserInfo.Params params = new GetEmptyUserInfo.Params(str, str2, thirdPartyServiceResponse.getClientId(), false);
                        final ShowAgreementBridge showAgreementBridge = ShowAgreementBridge.this;
                        Function1<GetEmptyUserInfo.UserInfo, Unit> function1 = new Function1<GetEmptyUserInfo.UserInfo, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$confirmUserInfo$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(GetEmptyUserInfo.UserInfo userInfo) {
                                invoke2(userInfo);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(GetEmptyUserInfo.UserInfo userInfo) {
                                ConsultAgreementResponse consultAgreementResponse;
                                Intrinsics.checkNotNullParameter(userInfo, "");
                                ThirdPartyServiceResponse thirdPartyServiceResponse2 = null;
                                if (userInfo.getStatus() == GetEmptyUserInfo.Status.INCOMPLETE) {
                                    ShowAgreementBridge showAgreementBridge2 = ShowAgreementBridge.this;
                                    ThirdPartyServiceResponse thirdPartyServiceResponse3 = showAgreementBridge2.service;
                                    if (thirdPartyServiceResponse3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                    } else {
                                        thirdPartyServiceResponse2 = thirdPartyServiceResponse3;
                                    }
                                    showAgreementBridge2.showMissingRequiredUserInfoDialog(thirdPartyServiceResponse2, userInfo.getIncompleteUserData());
                                } else if (userInfo.getStatus() == GetEmptyUserInfo.Status.EMAIL_UNVERIFIED) {
                                    ShowAgreementBridge.this.showEmailUnverifiedDialog();
                                } else if (GContainer.isOpeningH5()) {
                                    consultAgreementResponse = ShowAgreementBridge.this.consultAgreementResponse;
                                    if (consultAgreementResponse == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        consultAgreementResponse = null;
                                    }
                                    if (consultAgreementResponse.getNeedUserAgreement()) {
                                        ShowAgreementBridge.this.showTncServiceDialog();
                                        return;
                                    }
                                    ThirdPartyServiceResponse thirdPartyServiceResponse4 = ShowAgreementBridge.this.service;
                                    if (thirdPartyServiceResponse4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        thirdPartyServiceResponse4 = null;
                                    }
                                    if (Intrinsics.areEqual(thirdPartyServiceResponse4.getAction(), "POST")) {
                                        ShowAgreementBridge showAgreementBridge3 = ShowAgreementBridge.this;
                                        ThirdPartyServiceResponse thirdPartyServiceResponse5 = showAgreementBridge3.service;
                                        if (thirdPartyServiceResponse5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                        } else {
                                            thirdPartyServiceResponse2 = thirdPartyServiceResponse5;
                                        }
                                        showAgreementBridge3.sendAuthCode(thirdPartyServiceResponse2);
                                        return;
                                    }
                                    BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                                    agreementCallback.sendJSONResponse(jSONObject);
                                }
                            }
                        };
                        final ShowAgreementBridge showAgreementBridge2 = ShowAgreementBridge.this;
                        getEmptyUserInfo.execute(params, function1, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$confirmUserInfo$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "");
                                Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                                BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = jSONObject;
                                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                                jSONObject2.put((JSONObject) "error", "001");
                                agreementCallback.sendJSONResponse(jSONObject);
                            }
                        });
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$confirmUserInfo$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                        BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = jSONObject;
                        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                        jSONObject2.put((JSONObject) "error", "001");
                        agreementCallback.sendJSONResponse(jSONObject);
                    }
                });
                return;
            }
            OauthServiceProvider authRequestContext = OauthServiceProvider.INSTANCE.getAuthRequestContext();
            if (authRequestContext != null) {
                String string3 = info.getString("appId");
                Intrinsics.checkNotNullExpressionValue(string3, "");
                String string4 = info.getString("authClientId");
                Intrinsics.checkNotNullExpressionValue(string4, "");
                String string5 = info.getString("merchantId");
                Intrinsics.checkNotNullExpressionValue(string5, "");
                String string6 = info.getString("scopes");
                Intrinsics.checkNotNullExpressionValue(string6, "");
                authRequestContext.MyBillsEntityDataFactory(string3, string4, string5, string6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSuccessConsultAgreement(final ConsultAgreementResponse consultAgreementResponse, final ThirdPartyServiceResponse service) {
        GetEmptyUserInfo getEmptyUserInfo = getGetEmptyUserInfo();
        String str = this.serviceKey;
        String scopes = service.getScopes();
        if (scopes == null) {
            scopes = "";
        }
        getEmptyUserInfo.execute(new GetEmptyUserInfo.Params(str, scopes, service.getClientId(), false), new Function1<GetEmptyUserInfo.UserInfo, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$onSuccessConsultAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GetEmptyUserInfo.UserInfo userInfo) {
                invoke2(userInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GetEmptyUserInfo.UserInfo userInfo) {
                Intrinsics.checkNotNullParameter(userInfo, "");
                if (userInfo.getStatus() == GetEmptyUserInfo.Status.INCOMPLETE) {
                    ShowAgreementBridge.this.showMissingRequiredUserInfoDialog(service, userInfo.getIncompleteUserData());
                } else if (userInfo.getStatus() == GetEmptyUserInfo.Status.EMAIL_UNVERIFIED) {
                    ShowAgreementBridge.this.showEmailUnverifiedDialog();
                } else if (GContainer.isOpeningH5()) {
                    if (consultAgreementResponse.getNeedUserAgreement()) {
                        ShowAgreementBridge.this.showTncServiceDialog();
                    } else if (Intrinsics.areEqual(service.getAction(), "POST")) {
                        ShowAgreementBridge.this.sendAuthCode(service);
                    } else {
                        BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                        agreementCallback.sendJSONResponse(jSONObject);
                    }
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$onSuccessConsultAgreement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                jSONObject2.put((JSONObject) "error", "001");
                agreementCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMissingRequiredUserInfoDialog(final ThirdPartyServiceResponse service, Set<String> incompleteUserData) {
        getBuildIncompleteUserDataContent().execute(new BuildIncompleteUserDataContent.Param(incompleteUserData), new Function1<List<? extends String>, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showMissingRequiredUserInfoDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                String str;
                Intrinsics.checkNotNullParameter(list, "");
                Application applicationContext = GriverEnv.getApplicationContext();
                str = ShowAgreementBridge.this.serviceKey;
                String name = service.getName();
                String str2 = name == null ? "" : name;
                String icon = service.getIcon();
                String str3 = icon == null ? "" : icon;
                String scopes = service.getScopes();
                Intent putExtra = new Intent(applicationContext, MissingRequiredUserInfoDialogActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).putExtra("startParams", new MissingRequiredUserInfoDialogActivity.StartParams(str, str2, str3, scopes == null ? "" : scopes, "", "", false, list));
                Intrinsics.checkNotNullExpressionValue(putExtra, "");
                applicationContext.startActivity(putExtra);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showMissingRequiredUserInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                jSONObject2.put((JSONObject) "error", "001");
                agreementCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTncServiceDialog() {
        final Application applicationContext = GriverEnv.getApplicationContext();
        this.agreementMap.clear();
        ConsultAgreementResponse consultAgreementResponse = this.consultAgreementResponse;
        ThirdPartyServiceResponse thirdPartyServiceResponse = null;
        if (consultAgreementResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            consultAgreementResponse = null;
        }
        List<AgreementInfo> agreementInfos = consultAgreementResponse.getAgreementInfos();
        if (agreementInfos != null) {
            for (AgreementInfo agreementInfo : agreementInfos) {
                String agreementKey = agreementInfo.getAgreementKey();
                if (agreementKey != null) {
                    Map<String, String> map = this.agreementMap;
                    String contentValue = agreementInfo.getContentValue();
                    if (contentValue == null) {
                        contentValue = "";
                    }
                    map.put(agreementKey, contentValue);
                }
            }
        }
        ThirdPartyServiceResponse thirdPartyServiceResponse2 = this.service;
        if (thirdPartyServiceResponse2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            thirdPartyServiceResponse2 = null;
        }
        if (!Intrinsics.areEqual(thirdPartyServiceResponse2.getAction(), "POST")) {
            BuildAgreementContent buildAgreementContent = getBuildAgreementContent();
            ThirdPartyServiceResponse thirdPartyServiceResponse3 = this.service;
            if (thirdPartyServiceResponse3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                thirdPartyServiceResponse3 = null;
            }
            buildAgreementContent.execute(new BuildAgreementContent.Params(String.valueOf(thirdPartyServiceResponse3.getName()), null), new ShowAgreementBridge$showTncServiceDialog$2$1(this, applicationContext), new ShowAgreementBridge$showTncServiceDialog$2$2(this));
            return;
        }
        GetAuthCode getAuthCode = getGetAuthCode();
        GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
        ThirdPartyServiceResponse thirdPartyServiceResponse4 = this.service;
        if (thirdPartyServiceResponse4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            thirdPartyServiceResponse4 = null;
        }
        String redirectUrl = thirdPartyServiceResponse4.getRedirectUrl();
        if (redirectUrl == null) {
            redirectUrl = "";
        }
        ThirdPartyServiceResponse thirdPartyServiceResponse5 = this.service;
        if (thirdPartyServiceResponse5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            thirdPartyServiceResponse5 = null;
        }
        String clientId = thirdPartyServiceResponse5.getClientId();
        if (clientId == null) {
            clientId = "";
        }
        ThirdPartyServiceResponse thirdPartyServiceResponse6 = this.service;
        if (thirdPartyServiceResponse6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            thirdPartyServiceResponse = thirdPartyServiceResponse6;
        }
        String scopes = thirdPartyServiceResponse.getScopes();
        getAuthCode.execute(companion.forGetAuthCode(redirectUrl, clientId, scopes != null ? scopes : "", false), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showTncServiceDialog$$inlined$getAgreementContentForPost$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                invoke2(authCodeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AuthCodeResult authCodeResult) {
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                List<Agreement> agreements = authCodeResult.getAgreements();
                BuildAgreementContent buildAgreementContent2 = ShowAgreementBridge.this.getBuildAgreementContent();
                ThirdPartyServiceResponse thirdPartyServiceResponse7 = ShowAgreementBridge.this.service;
                if (thirdPartyServiceResponse7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    thirdPartyServiceResponse7 = null;
                }
                buildAgreementContent2.execute(new BuildAgreementContent.Params(String.valueOf(thirdPartyServiceResponse7.getName()), agreements), new ShowAgreementBridge$showTncServiceDialog$2$1(ShowAgreementBridge.this, applicationContext), new ShowAgreementBridge$showTncServiceDialog$2$2(ShowAgreementBridge.this));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$showTncServiceDialog$$inlined$getAgreementContentForPost$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                BuildAgreementContent buildAgreementContent2 = ShowAgreementBridge.this.getBuildAgreementContent();
                ThirdPartyServiceResponse thirdPartyServiceResponse7 = ShowAgreementBridge.this.service;
                if (thirdPartyServiceResponse7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    thirdPartyServiceResponse7 = null;
                }
                buildAgreementContent2.execute(new BuildAgreementContent.Params(String.valueOf(thirdPartyServiceResponse7.getName()), null), new ShowAgreementBridge$showTncServiceDialog$2$1(ShowAgreementBridge.this, applicationContext), new ShowAgreementBridge$showTncServiceDialog$2$2(ShowAgreementBridge.this));
            }
        });
    }

    private final void getAgreementContentForPost(final Function1<? super List<? extends Agreement>, Unit> onAgreementContentReturned) {
        ThirdPartyServiceResponse thirdPartyServiceResponse = this.service;
        ThirdPartyServiceResponse thirdPartyServiceResponse2 = null;
        if (thirdPartyServiceResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            thirdPartyServiceResponse = null;
        }
        if (Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "POST")) {
            GetAuthCode getAuthCode = getGetAuthCode();
            GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
            ThirdPartyServiceResponse thirdPartyServiceResponse3 = this.service;
            if (thirdPartyServiceResponse3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                thirdPartyServiceResponse3 = null;
            }
            String redirectUrl = thirdPartyServiceResponse3.getRedirectUrl();
            if (redirectUrl == null) {
                redirectUrl = "";
            }
            ThirdPartyServiceResponse thirdPartyServiceResponse4 = this.service;
            if (thirdPartyServiceResponse4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                thirdPartyServiceResponse4 = null;
            }
            String clientId = thirdPartyServiceResponse4.getClientId();
            if (clientId == null) {
                clientId = "";
            }
            ThirdPartyServiceResponse thirdPartyServiceResponse5 = this.service;
            if (thirdPartyServiceResponse5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                thirdPartyServiceResponse2 = thirdPartyServiceResponse5;
            }
            String scopes = thirdPartyServiceResponse2.getScopes();
            getAuthCode.execute(companion.forGetAuthCode(redirectUrl, clientId, scopes != null ? scopes : "", false), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$getAgreementContentForPost$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                    invoke2(authCodeResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AuthCodeResult authCodeResult) {
                    Intrinsics.checkNotNullParameter(authCodeResult, "");
                    onAgreementContentReturned.invoke(authCodeResult.getAgreements());
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$getAgreementContentForPost$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    onAgreementContentReturned.invoke(null);
                }
            });
            return;
        }
        onAgreementContentReturned.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmailUnverifiedDialog() {
        GriverEnv.getApplicationContext().startActivity(new Intent(GriverEnv.getApplicationContext(), EmailNotVerifiedDialogActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
    }

    @Subscribe
    public final void onReceiveAgreementMessageEvent(AgreementMessageEvent event) {
        String str;
        Intrinsics.checkNotNullParameter(event, "");
        if (event.getAgree()) {
            ThirdPartyServiceResponse thirdPartyServiceResponse = this.service;
            ThirdPartyServiceResponse thirdPartyServiceResponse2 = null;
            if (thirdPartyServiceResponse == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                thirdPartyServiceResponse = null;
            }
            String str2 = Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "POST") ? MERCHANT_PAGE_AGREEMENT_TYPE : null;
            ThirdPartyServiceResponse thirdPartyServiceResponse3 = this.service;
            if (thirdPartyServiceResponse3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                thirdPartyServiceResponse3 = null;
            }
            if (Intrinsics.areEqual(thirdPartyServiceResponse3.getAction(), "POST")) {
                ThirdPartyServiceResponse thirdPartyServiceResponse4 = this.service;
                if (thirdPartyServiceResponse4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    thirdPartyServiceResponse4 = null;
                }
                str = thirdPartyServiceResponse4.getClientId();
            } else {
                str = null;
            }
            RecordAgreement recordAgreement = getRecordAgreement();
            String str3 = this.serviceKey;
            List list = CollectionsKt.toList(this.agreementMap.keySet());
            ThirdPartyServiceResponse thirdPartyServiceResponse5 = this.service;
            if (thirdPartyServiceResponse5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                thirdPartyServiceResponse2 = thirdPartyServiceResponse5;
            }
            String scopes = thirdPartyServiceResponse2.getScopes();
            recordAgreement.execute(new RecordAgreement.Params(str3, list, true, str2, scopes == null ? "" : scopes, str, null, null), new Function1<Unit, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$onReceiveAgreementMessageEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Unit unit) {
                    Intrinsics.checkNotNullParameter(unit, "");
                    ThirdPartyServiceResponse thirdPartyServiceResponse6 = ShowAgreementBridge.this.service;
                    ThirdPartyServiceResponse thirdPartyServiceResponse7 = null;
                    if (thirdPartyServiceResponse6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        thirdPartyServiceResponse6 = null;
                    }
                    if (Intrinsics.areEqual(thirdPartyServiceResponse6.getAction(), "POST")) {
                        ShowAgreementBridge showAgreementBridge = ShowAgreementBridge.this;
                        ThirdPartyServiceResponse thirdPartyServiceResponse8 = showAgreementBridge.service;
                        if (thirdPartyServiceResponse8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            thirdPartyServiceResponse7 = thirdPartyServiceResponse8;
                        }
                        showAgreementBridge.sendAuthCode(thirdPartyServiceResponse7);
                        return;
                    }
                    BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                    agreementCallback.sendJSONResponse(jSONObject);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$onReceiveAgreementMessageEvent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                    BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = jSONObject;
                    jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                    jSONObject2.put((JSONObject) "error", "001");
                    agreementCallback.sendJSONResponse(jSONObject);
                }
            });
            return;
        }
        BridgeCallback agreementCallback = getAgreementCallback();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", event.getErrorCode());
        agreementCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAuthCode(ThirdPartyServiceResponse service) {
        GetAuthCode getAuthCode = getGetAuthCode();
        GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
        String redirectUrl = service.getRedirectUrl();
        if (redirectUrl == null) {
            redirectUrl = "";
        }
        String clientId = service.getClientId();
        if (clientId == null) {
            clientId = "";
        }
        String scopes = service.getScopes();
        getAuthCode.execute(companion.forGetAuthCode(redirectUrl, clientId, scopes != null ? scopes : "", true), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$sendAuthCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                invoke2(authCodeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AuthCodeResult authCodeResult) {
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
                jSONObject2.put((JSONObject) "authCode", authCodeResult.getAuthCode());
                agreementCallback.sendJSONResponse(jSONObject);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.showagreement.ShowAgreementBridge$sendAuthCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Toast.makeText(GContainer.getApplicationContext(), (int) R.string.home_error, 0).show();
                BridgeCallback agreementCallback = ShowAgreementBridge.this.getAgreementCallback();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                jSONObject2.put((JSONObject) "error", "001");
                agreementCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danah5/showagreement/ShowAgreementBridge$AgreementMessageEvent;", "", "", "agree", "Z", "getAgree", "()Z", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class AgreementMessageEvent {
        private final boolean agree;
        private final String errorCode;

        public AgreementMessageEvent(boolean z, String str) {
            this.agree = z;
            this.errorCode = str;
        }

        public /* synthetic */ AgreementMessageEvent(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? "002" : str);
        }

        @JvmName(name = "getAgree")
        public final boolean getAgree() {
            return this.agree;
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\"\u0010\u000b\u001a\u00020\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danah5/showagreement/ShowAgreementBridge$Companion;", "", "", "GENERAL_ERROR", "Ljava/lang/String;", "INCOMPLETE_USER_INFO", "MERCHANT_PAGE_AGREEMENT_TYPE", "MINI_PROGRAM_PREFIX", "UNVERIFIED_EMAIL", "USER_DENY", "", "confirmUserInfo_wasCalled", "Z", "getConfirmUserInfo_wasCalled", "()Z", "setConfirmUserInfo_wasCalled", "(Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getConfirmUserInfo_wasCalled")
        public final boolean getConfirmUserInfo_wasCalled() {
            return ShowAgreementBridge.confirmUserInfo_wasCalled;
        }

        @JvmName(name = "setConfirmUserInfo_wasCalled")
        public final void setConfirmUserInfo_wasCalled(boolean z) {
            ShowAgreementBridge.confirmUserInfo_wasCalled = z;
        }
    }
}
