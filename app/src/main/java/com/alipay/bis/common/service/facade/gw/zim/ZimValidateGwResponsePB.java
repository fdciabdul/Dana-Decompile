package com.alipay.bis.common.service.facade.gw.zim;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class ZimValidateGwResponsePB extends Message {
    public static final String DEFAULT_NEXTPROTOCOL = "";
    public static final String DEFAULT_RETCODESUB = "";
    public static final String DEFAULT_RETMESSAGESUB = "";
    public static final int TAG_EXTPARAMS = 5;
    public static final int TAG_HASNEXT = 3;
    public static final int TAG_NEXTPROTOCOL = 4;
    public static final int TAG_PRODUCTRETCODE = 2;
    public static final int TAG_RETCODESUB = 6;
    public static final int TAG_RETMESSAGESUB = 7;
    public static final int TAG_VALIDATIONRETCODE = 1;
    @ProtoField(tag = 5)
    public MapStringString extParams;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public Boolean hasNext;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public String nextProtocol;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public Integer productRetCode;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public String retCodeSub;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public String retMessageSub;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public Integer validationRetCode;
    public static final Integer DEFAULT_VALIDATIONRETCODE = 0;
    public static final Integer DEFAULT_PRODUCTRETCODE = 0;
    public static final Boolean DEFAULT_HASNEXT = Boolean.FALSE;

    public ZimValidateGwResponsePB(ZimValidateGwResponsePB zimValidateGwResponsePB) {
        super(zimValidateGwResponsePB);
        if (zimValidateGwResponsePB == null) {
            return;
        }
        this.validationRetCode = zimValidateGwResponsePB.validationRetCode;
        this.productRetCode = zimValidateGwResponsePB.productRetCode;
        this.hasNext = zimValidateGwResponsePB.hasNext;
        this.nextProtocol = zimValidateGwResponsePB.nextProtocol;
        this.extParams = zimValidateGwResponsePB.extParams;
        this.retCodeSub = zimValidateGwResponsePB.retCodeSub;
        this.retMessageSub = zimValidateGwResponsePB.retMessageSub;
    }

    public ZimValidateGwResponsePB() {
    }

    public final ZimValidateGwResponsePB fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.validationRetCode = (Integer) obj;
                break;
            case 2:
                this.productRetCode = (Integer) obj;
                break;
            case 3:
                this.hasNext = (Boolean) obj;
                break;
            case 4:
                this.nextProtocol = (String) obj;
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
        if (obj instanceof ZimValidateGwResponsePB) {
            ZimValidateGwResponsePB zimValidateGwResponsePB = (ZimValidateGwResponsePB) obj;
            return equals(this.validationRetCode, zimValidateGwResponsePB.validationRetCode) && equals(this.productRetCode, zimValidateGwResponsePB.productRetCode) && equals(this.hasNext, zimValidateGwResponsePB.hasNext) && equals(this.nextProtocol, zimValidateGwResponsePB.nextProtocol) && equals(this.extParams, zimValidateGwResponsePB.extParams) && equals(this.retCodeSub, zimValidateGwResponsePB.retCodeSub) && equals(this.retMessageSub, zimValidateGwResponsePB.retMessageSub);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.validationRetCode;
            int hashCode = num != null ? num.hashCode() : 0;
            Integer num2 = this.productRetCode;
            int hashCode2 = num2 != null ? num2.hashCode() : 0;
            Boolean bool = this.hasNext;
            int hashCode3 = bool != null ? bool.hashCode() : 0;
            String str = this.nextProtocol;
            int hashCode4 = str != null ? str.hashCode() : 0;
            MapStringString mapStringString = this.extParams;
            int hashCode5 = mapStringString != null ? mapStringString.hashCode() : 0;
            String str2 = this.retCodeSub;
            int hashCode6 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.retMessageSub;
            int hashCode7 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + (str3 != null ? str3.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }
}
