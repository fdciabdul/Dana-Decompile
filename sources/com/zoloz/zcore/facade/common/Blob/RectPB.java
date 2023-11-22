package com.zoloz.zcore.facade.common.Blob;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;

/* loaded from: classes2.dex */
public final class RectPB extends Message {
    public static final int TAG_BOTTOM = 4;
    public static final int TAG_LEFT = 1;
    public static final int TAG_RIGHT = 3;
    public static final int TAG_TOP = 2;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public Integer bottom;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public Integer left;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public Integer right;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public Integer top;
    public static final Integer DEFAULT_LEFT = 0;
    public static final Integer DEFAULT_TOP = 0;
    public static final Integer DEFAULT_RIGHT = 0;
    public static final Integer DEFAULT_BOTTOM = 0;

    public RectPB(RectPB rectPB) {
        super(rectPB);
        if (rectPB == null) {
            return;
        }
        this.left = rectPB.left;
        this.top = rectPB.top;
        this.right = rectPB.right;
        this.bottom = rectPB.bottom;
    }

    public RectPB() {
    }

    public final RectPB fillTagValue(int i, Object obj) {
        if (i == 1) {
            this.left = (Integer) obj;
        } else if (i == 2) {
            this.top = (Integer) obj;
        } else if (i == 3) {
            this.right = (Integer) obj;
        } else if (i == 4) {
            this.bottom = (Integer) obj;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RectPB) {
            RectPB rectPB = (RectPB) obj;
            return equals(this.left, rectPB.left) && equals(this.top, rectPB.top) && equals(this.right, rectPB.right) && equals(this.bottom, rectPB.bottom);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.left;
            int hashCode = num != null ? num.hashCode() : 0;
            Integer num2 = this.top;
            int hashCode2 = num2 != null ? num2.hashCode() : 0;
            Integer num3 = this.right;
            int hashCode3 = num3 != null ? num3.hashCode() : 0;
            Integer num4 = this.bottom;
            int hashCode4 = (((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + (num4 != null ? num4.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i;
    }
}
