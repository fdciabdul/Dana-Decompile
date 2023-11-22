package com.alipay.bis.common.service.facade.gw.pbmodel.common;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class BisBehavTask extends Message {
    public static final String DEFAULT_EXTINFO = "";
    public static final String DEFAULT_IDX = "";
    public static final String DEFAULT_NAME = "";
    public static final int TAG_DUR = 3;
    public static final int TAG_EXTINFO = 5;
    public static final int TAG_IDX = 2;
    public static final int TAG_NAME = 1;
    public static final int TAG_QUALITY = 4;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public Integer dur;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public String extInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public String idx;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public String name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public Integer quality;
    public static final Integer DEFAULT_DUR = 0;
    public static final Integer DEFAULT_QUALITY = 0;

    public BisBehavTask(BisBehavTask bisBehavTask) {
        super(bisBehavTask);
        if (bisBehavTask == null) {
            return;
        }
        this.name = bisBehavTask.name;
        this.idx = bisBehavTask.idx;
        this.dur = bisBehavTask.dur;
        this.quality = bisBehavTask.quality;
        this.extInfo = bisBehavTask.extInfo;
    }

    public BisBehavTask() {
    }

    public final BisBehavTask fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.name = (String) obj;
        } else if (i == 2) {
            this.idx = (String) obj;
        } else if (i == 3) {
            this.dur = (Integer) obj;
        } else if (i == 4) {
            this.quality = (Integer) obj;
        } else if (i == 5) {
            this.extInfo = (String) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisBehavTask) {
            BisBehavTask bisBehavTask = (BisBehavTask) obj;
            return equals(this.name, bisBehavTask.name) && equals(this.idx, bisBehavTask.idx) && equals(this.dur, bisBehavTask.dur) && equals(this.quality, bisBehavTask.quality) && equals(this.extInfo, bisBehavTask.extInfo);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.name;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.idx;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            Integer num = this.dur;
            int hashCode3 = num != null ? num.hashCode() : 0;
            Integer num2 = this.quality;
            int hashCode4 = num2 != null ? num2.hashCode() : 0;
            String str3 = this.extInfo;
            int hashCode5 = (((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + (str3 != null ? str3.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }
}
