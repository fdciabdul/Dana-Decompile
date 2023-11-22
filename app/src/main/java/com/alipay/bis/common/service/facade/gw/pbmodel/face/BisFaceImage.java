package com.alipay.bis.common.service.facade.gw.pbmodel.face;

import com.zoloz.wire.Message;
import com.zoloz.wire.ProtoField;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class BisFaceImage extends Message {
    public static final int TAG_CONTENT = 1;
    public static final int TAG_HEIGHT = 5;
    public static final int TAG_QUALITY = 6;
    public static final int TAG_RECTX = 2;
    public static final int TAG_RECTY = 3;
    public static final int TAG_TASKIDX = 7;
    public static final int TAG_WIDTH = 4;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BYTES)
    public ByteString content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public Integer height;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public Integer quality;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public Integer rectx;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public Integer recty;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.INT32)
    public Integer taskidx;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public Integer width;
    public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;
    public static final Integer DEFAULT_RECTX = 0;
    public static final Integer DEFAULT_RECTY = 0;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Integer DEFAULT_QUALITY = 0;
    public static final Integer DEFAULT_TASKIDX = 0;

    public BisFaceImage(BisFaceImage bisFaceImage) {
        super(bisFaceImage);
        if (bisFaceImage == null) {
            return;
        }
        this.content = bisFaceImage.content;
        this.rectx = bisFaceImage.rectx;
        this.recty = bisFaceImage.recty;
        this.width = bisFaceImage.width;
        this.height = bisFaceImage.height;
        this.quality = bisFaceImage.quality;
        this.taskidx = bisFaceImage.taskidx;
    }

    public BisFaceImage() {
    }

    public final BisFaceImage fillTagValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.content = (ByteString) obj;
                break;
            case 2:
                this.rectx = (Integer) obj;
                break;
            case 3:
                this.recty = (Integer) obj;
                break;
            case 4:
                this.width = (Integer) obj;
                break;
            case 5:
                this.height = (Integer) obj;
                break;
            case 6:
                this.quality = (Integer) obj;
                break;
            case 7:
                this.taskidx = (Integer) obj;
                break;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BisFaceImage) {
            BisFaceImage bisFaceImage = (BisFaceImage) obj;
            return equals(this.content, bisFaceImage.content) && equals(this.rectx, bisFaceImage.rectx) && equals(this.recty, bisFaceImage.recty) && equals(this.width, bisFaceImage.width) && equals(this.height, bisFaceImage.height) && equals(this.quality, bisFaceImage.quality) && equals(this.taskidx, bisFaceImage.taskidx);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ByteString byteString = this.content;
            int hashCode = byteString != null ? byteString.hashCode() : 0;
            Integer num = this.rectx;
            int hashCode2 = num != null ? num.hashCode() : 0;
            Integer num2 = this.recty;
            int hashCode3 = num2 != null ? num2.hashCode() : 0;
            Integer num3 = this.width;
            int hashCode4 = num3 != null ? num3.hashCode() : 0;
            Integer num4 = this.height;
            int hashCode5 = num4 != null ? num4.hashCode() : 0;
            Integer num5 = this.quality;
            int hashCode6 = num5 != null ? num5.hashCode() : 0;
            Integer num6 = this.taskidx;
            int hashCode7 = (((((((((((hashCode * 37) + hashCode2) * 37) + hashCode3) * 37) + hashCode4) * 37) + hashCode5) * 37) + hashCode6) * 37) + (num6 != null ? num6.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }
}
