package com.alipay.mobile.security.bio.workspace;

import android.content.Context;
import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alipay.biometrics.common.proguard.INotProguard;
import com.alipay.bis.common.service.facade.gw.pbmodel.common.ClientConfigContentPB;
import com.alipay.mobile.security.bio.api.BioParameter;
import com.alipay.mobile.security.bio.common.statistics.RecordExtAction;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.zoloz.wire.Wire;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class PbBioParameterToBioApp extends BaseBioParameterToBioApp implements INotProguard {
    public PbBioParameterToBioApp(Context context, BioTransfer bioTransfer) {
        super(context, bioTransfer);
    }

    @Override // com.alipay.mobile.security.bio.workspace.BaseBioParameterToBioApp
    public BioAppDescription toBioApp(BioParameter bioParameter) {
        ClientConfigContentPB clientConfigContentPB;
        ProtocolConfig protocolConfig;
        if (bioParameter == null) {
            throw new BioIllegalArgumentException();
        }
        String protocol = bioParameter.getProtocol();
        try {
            String handleFcProtocolByPB = handleFcProtocolByPB(protocol);
            if (!StringUtil.isNullorEmpty(handleFcProtocolByPB)) {
                try {
                    this.bioTransfer.mIDFaceParam = bioParameter;
                    this.bioTransfer.isIDFaceFlag = true;
                } catch (Exception unused) {
                }
                protocol = handleFcProtocolByPB;
            }
        } catch (Exception unused2) {
        }
        BioAppDescription bioAppDescription = new BioAppDescription();
        bioAppDescription.setTag(getUniqueTag());
        bioAppDescription.setRemoteURL(bioParameter.getRemoteURL());
        bioAppDescription.setHeadImageURL(bioParameter.getHeadImageUrl());
        if (!StringUtil.isNullorEmpty(protocol)) {
            try {
                if (this.bioTransfer.isIDFaceFlag) {
                    clientConfigContentPB = fcCardToClientConfigContentPB(protocol);
                } else {
                    clientConfigContentPB = toClientConfigContentPB(protocol);
                }
                if (clientConfigContentPB != null) {
                    String str = clientConfigContentPB.androidcfg;
                    if (StringUtil.isNullorEmpty(str)) {
                        protocolConfig = new ProtocolConfig();
                    } else {
                        protocolConfig = (ProtocolConfig) JSON.parseObject(str, ProtocolConfig.class);
                    }
                    bioAppDescription.setBioType(clientConfigContentPB.type.intValue());
                    if (!str.contains("\"ui\":992")) {
                        bioAppDescription.setBioAction(clientConfigContentPB.sampleMode.intValue());
                        if (clientConfigContentPB.type.intValue() == 100 && protocolConfig != null) {
                            if (protocolConfig.getUi() == 0) {
                                if (protocolConfig.getNavigatepage() != null && protocolConfig.getNavigatepage().isEnable()) {
                                    if (clientConfigContentPB.sampleMode.intValue() == 302) {
                                        bioAppDescription.setBioAction(-302);
                                    } else if (clientConfigContentPB.sampleMode.intValue() == 303) {
                                        bioAppDescription.setBioAction(-303);
                                    }
                                }
                            } else if (protocolConfig.getUi() == 991) {
                                if (clientConfigContentPB.sampleMode.intValue() == 302) {
                                    bioAppDescription.setBioAction(991);
                                } else if (clientConfigContentPB.sampleMode.intValue() == 303) {
                                    bioAppDescription.setBioAction(992);
                                }
                            } else if (protocolConfig.getUi() == 1) {
                                if (clientConfigContentPB.sampleMode.intValue() == 302) {
                                    bioAppDescription.setBioAction(993);
                                } else if (clientConfigContentPB.sampleMode.intValue() == 303) {
                                    bioAppDescription.setBioAction(994);
                                }
                            }
                        } else if (clientConfigContentPB.type.intValue() == 201 && protocolConfig != null && protocolConfig.getUi() == 991) {
                            if (clientConfigContentPB.sampleMode.intValue() == 300) {
                                bioAppDescription.setBioAction(991);
                            } else if (clientConfigContentPB.sampleMode.intValue() == 301) {
                                bioAppDescription.setBioAction(992);
                            }
                        }
                    }
                    bioAppDescription.setCfg(str);
                    bioAppDescription.setBistoken(clientConfigContentPB.token);
                    bioAppDescription.setFcSpecialData(this.bioTransfer.mFcSpecialData);
                    bioAppDescription.setSigned(true);
                    bioAppDescription.setAutoClose(bioParameter.isAutoClose());
                    bioAppDescription.setBundle(bioParameter.getBundle());
                    for (String str2 : bioParameter.getExtProperty().keySet()) {
                        bioAppDescription.addExtProperty(str2, bioParameter.getExtProperty().get(str2));
                    }
                }
            } catch (JSONException | IllegalArgumentException | IllegalStateException | Exception unused3) {
            }
        }
        return bioAppDescription;
    }

    private String handleFcProtocolByPB(String str) {
        JSONObject parseObject;
        ClientConfigContentPB clientConfigContentPB = toClientConfigContentPB(str);
        if (clientConfigContentPB == null || clientConfigContentPB.type.intValue() != 200 || (parseObject = JSONObject.parseObject(clientConfigContentPB.androidcfg)) == null) {
            return "";
        }
        if (this.bioTransfer.fcStep != 0) {
            return this.bioTransfer.fcStep == 1 ? parseFaceProtocol(parseObject, true) : "";
        }
        HashMap hashMap = new HashMap();
        this.bioTransfer.fcToken = clientConfigContentPB.token;
        hashMap.put("fcToken", this.bioTransfer.fcToken);
        this.bioTransfer.mRecordExtService.write(RecordExtAction.RECORD_FC_ENTRY_SDK, hashMap);
        hashMap.put("params", str);
        this.bioTransfer.mRecordExtService.write(RecordExtAction.RECORD_FC_GET_PARAM, hashMap);
        return parseIDProtocol(parseObject, true);
    }

    private ClientConfigContentPB toClientConfigContentPB(String str) {
        byte[] decode;
        ClientConfigContentPB clientConfigContentPB;
        if (str == null || (decode = Base64.decode(str, 8)) == null) {
            return null;
        }
        try {
            clientConfigContentPB = (ClientConfigContentPB) new Wire(new Class[0]).parseFrom(decode, ClientConfigContentPB.class);
        } catch (IOException unused) {
            clientConfigContentPB = null;
        }
        if (clientConfigContentPB == null) {
            return null;
        }
        return clientConfigContentPB;
    }

    private ClientConfigContentPB fcCardToClientConfigContentPB(String str) {
        byte[] decode;
        if (str == null || (decode = Base64.decode(str, 8)) == null) {
            return null;
        }
        try {
            return (ClientConfigContentPB) new Wire(new Class[0]).parseFrom(decode, ClientConfigContentPB.class);
        } catch (IOException unused) {
            return null;
        }
    }
}
