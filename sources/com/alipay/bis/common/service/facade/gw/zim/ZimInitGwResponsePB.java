package com.alipay.bis.common.service.facade.gw.zim;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class ZimInitGwResponsePB extends Message {
    public static final String DEFAULT_MESSAGE = "";
    public static final String DEFAULT_PROTOCOL = "";
    public static final Integer DEFAULT_RETCODE = 0;
    public static final String DEFAULT_RETCODESUB = "";
    public static final String DEFAULT_RETMESSAGESUB = "";
    public static final String DEFAULT_ZIMID = "";
    public static final int TAG_EXTPARAMS = 5;
    public static final int TAG_MESSAGE = 2;
    public static final int TAG_PROTOCOL = 4;
    public static final int TAG_RETCODE = 1;
    public static final int TAG_RETCODESUB = 6;
    public static final int TAG_RETMESSAGESUB = 7;
    public static final int TAG_ZIMID = 3;
    @ProtoField(tag = 5)
    public MapStringString extParams;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public String message;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String protocol;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public Integer retCode;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String retCodeSub;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public String retMessageSub;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public String zimId;

    public ZimInitGwResponsePB(ZimInitGwResponsePB zimInitGwResponsePB) {
        super(zimInitGwResponsePB);
        if (zimInitGwResponsePB == null) {
            return;
        }
        this.retCode = zimInitGwResponsePB.retCode;
        this.message = zimInitGwResponsePB.message;
        this.zimId = zimInitGwResponsePB.zimId;
        this.protocol = zimInitGwResponsePB.protocol;
        this.extParams = zimInitGwResponsePB.extParams;
        this.retCodeSub = zimInitGwResponsePB.retCodeSub;
        this.retMessageSub = zimInitGwResponsePB.retMessageSub;
    }

    public ZimInitGwResponsePB() {
    }

    public final ZimInitGwResponsePB fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.retCode = (Integer) obj;
                break;
            case 2:
                this.message = (String) obj;
                break;
            case 3:
                this.zimId = (String) obj;
                break;
            case 4:
                this.protocol = (String) obj;
                break;
            case 5:
                this.extParams = (MapStringString) obj;
                break;
            case 6:
                this.retCodeSub = (String) obj;
                break;
            case 7:
                this.retMessageSub = (String) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZimInitGwResponsePB) {
            ZimInitGwResponsePB zimInitGwResponsePB = (ZimInitGwResponsePB) obj;
            return equals(this.retCode, zimInitGwResponsePB.retCode) && equals(this.message, zimInitGwResponsePB.message) && equals(this.zimId, zimInitGwResponsePB.zimId) && equals(this.protocol, zimInitGwResponsePB.protocol) && equals(this.extParams, zimInitGwResponsePB.extParams) && equals(this.retCodeSub, zimInitGwResponsePB.retCodeSub) && equals(this.retMessageSub, zimInitGwResponsePB.retMessageSub);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.retCode;
            int hashCode = num != null ? num.hashCode() : 0;
            String str = this.message;
            int hashCode2 = str != null ? str.hashCode() : 0;
            String str2 = this.zimId;
            int hashCode3 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.protocol;
            int hashCode4 = str3 != null ? str3.hashCode() : 0;
            MapStringString mapStringString = this.extParams;
            int hashCode5 = mapStringString != null ? mapStringString.hashCode() : 0;
            String str4 = this.retCodeSub;
            int hashCode6 = str4 != null ? str4.hashCode() : 0;
            String str5 = this.retMessageSub;
            int hashCode7 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + (str5 != null ? str5.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }
}
