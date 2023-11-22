package com.iap.ac.android.mpm;

import com.iap.ac.android.biz.common.constants.ACConstants;

/* loaded from: classes3.dex */
public class DecodeParameter {
    public String acDecodeConfigFromServer;
    public String codeValue;
    public String merchantType;
    public String scene = ACConstants.Scene.SOURCE_FROM_SCAN;
    public String sourceAppPackageName;

    public String toString() {
        return String.format("DecodeParameter[code=%s,merchantType=%s,scene=%s,pkg=%s,config=%s]", this.codeValue, this.merchantType, this.scene, this.sourceAppPackageName, this.acDecodeConfigFromServer);
    }
}
