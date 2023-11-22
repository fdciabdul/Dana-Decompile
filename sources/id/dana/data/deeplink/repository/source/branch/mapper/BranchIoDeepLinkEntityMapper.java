package id.dana.data.deeplink.repository.source.branch.mapper;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import id.dana.data.base.BaseMapper;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class BranchIoDeepLinkEntityMapper extends BaseMapper<JSONObject, DeepLinkPayloadEntity> {
    private static final String REPLACE_TARGET = "$android";
    private static final String REPLACE_TO = "android";

    @Inject
    public BranchIoDeepLinkEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public DeepLinkPayloadEntity map(JSONObject jSONObject) {
        try {
            return (DeepLinkPayloadEntity) new GsonBuilder().disableHtmlEscaping().create().fromJson(jSONObject.toString().replace(REPLACE_TARGET, REPLACE_TO), DeepLinkPayloadEntity.class);
        } catch (JsonSyntaxException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DEEPLINK_TAG, "[DeepLink]parsing deepLink payload error", e);
            return null;
        }
    }
}
