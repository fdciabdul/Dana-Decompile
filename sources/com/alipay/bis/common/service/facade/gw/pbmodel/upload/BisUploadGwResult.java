package com.alipay.bis.common.service.facade.gw.pbmodel.upload;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class BisUploadGwResult extends Message {
    public static final String DEFAULT_EXTINFO = "";
    public static final String DEFAULT_RETCODE = "";
    public static final String DEFAULT_RETMESSAGE = "";
    public static final int TAG_EXTINFO = 3;
    public static final int TAG_RETCODE = 1;
    public static final int TAG_RETMESSAGE = 2;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String extInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public String retCode;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String retMessage;

    public BisUploadGwResult(BisUploadGwResult bisUploadGwResult) {
        super(bisUploadGwResult);
        if (bisUploadGwResult == null) {
            return;
        }
        this.retCode = bisUploadGwResult.retCode;
        this.retMessage = bisUploadGwResult.retMessage;
        this.extInfo = bisUploadGwResult.extInfo;
    }

    public BisUploadGwResult() {
    }

    public final BisUploadGwResult fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.retCode = (String) obj;
        } else if (i == 2) {
            this.retMessage = (String) obj;
        } else if (i == 3) {
            this.extInfo = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisUploadGwResult) {
            BisUploadGwResult bisUploadGwResult = (BisUploadGwResult) obj;
            return equals(this.retCode, bisUploadGwResult.retCode) && equals(this.retMessage, bisUploadGwResult.retMessage) && equals(this.extInfo, bisUploadGwResult.extInfo);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.retCode;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.retMessage;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.extInfo;
            int hashCode3 = (((hashCode * 37) + hashCode2) * 37) + (str3 != null ? str3.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i;
    }
}
