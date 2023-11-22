package id.dana.lib.drawbitmap.style.typeface;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.font.FontTypeFactory;
import id.dana.lib.drawbitmap.style.font.FontTypeVariant;

/* loaded from: classes5.dex */
public class TypeFaceFactory {
    private FontTypeFactory fontTypeFactory;
    private int multiplier;
    private Paint paint;

    public TypeFaceFactory(Context context) {
        this.paint = new Paint();
        this.multiplier = 1;
        this.fontTypeFactory = new FontTypeFactory(context);
    }

    public TypeFaceFactory(Context context, int i) {
        this.paint = new Paint();
        this.multiplier = i;
        this.fontTypeFactory = new FontTypeFactory(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Paint getTypeface(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -2106237344:
                if (str.equals(TypeFaceVariant.TITLE_22_HIGHLIGHT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1815860549:
                if (str.equals(TypeFaceVariant.TITLE_12_NORMAL)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1405172766:
                if (str.equals(TypeFaceVariant.TITLE_14_HIGHLIGHT)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1229340018:
                if (str.equals(TypeFaceVariant.BODY_14_ACTIVE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1104338708:
                if (str.equals(TypeFaceVariant.BODY_14_SECONDARY)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -995050629:
                if (str.equals(TypeFaceVariant.CAPTION_12_INVERTED)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -846135185:
                if (str.equals(TypeFaceVariant.BODY_14_NORMAL)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -704108188:
                if (str.equals(TypeFaceVariant.TITLE_16_HIGHLIGHT)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 417519022:
                if (str.equals(TypeFaceVariant.CAPTION_12_SECONDARY)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1669760121:
                if (str.equals(TypeFaceVariant.TITLE_14_NORMAL)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return toTitle22Highlight();
            case 1:
                return toTitle12Normal();
            case 2:
                return toTitle14Highlight();
            case 3:
                return toBody14Active();
            case 4:
                return toBody14Secondary();
            case 5:
                return toCaption12Inverted();
            case 6:
                return toBody14Normal();
            case 7:
                return toTitle16Highlight();
            case '\b':
                return toCaption12Secondary();
            case '\t':
                return toTitle14Normal();
            default:
                return null;
        }
    }

    private Paint toBody14Active() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.BLUE_50));
        this.paint.setTextSize(this.multiplier * 14);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.SF_PRO_REGULAR));
        return this.paint;
    }

    private Paint toBody14Normal() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.GREY_90));
        this.paint.setTextSize(this.multiplier * 14);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.SF_PRO_REGULAR));
        return this.paint;
    }

    private Paint toBody14Secondary() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.GREY_70));
        this.paint.setTextSize(this.multiplier * 14);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.SF_PRO_REGULAR));
        return this.paint;
    }

    private Paint toCaption12Inverted() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.WHITE));
        this.paint.setTextSize(this.multiplier * 12);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.SF_PRO_REGULAR));
        return this.paint;
    }

    private Paint toCaption12Secondary() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.GREY_70));
        this.paint.setTextSize(this.multiplier * 12);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.SF_PRO_REGULAR));
        return this.paint;
    }

    private Paint toTitle12Normal() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor("#000000"));
        this.paint.setTextSize(this.multiplier * 12);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.OPEN_SANS_SEMIBOLD));
        return this.paint;
    }

    private Paint toTitle14Highlight() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.YELLOW_50));
        this.paint.setTextSize(this.multiplier * 14);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.OPEN_SANS_SEMIBOLD));
        return this.paint;
    }

    private Paint toTitle14Normal() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor("#000000"));
        this.paint.setTextSize(this.multiplier * 14);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.OPEN_SANS_SEMIBOLD));
        return this.paint;
    }

    private Paint toTitle16Highlight() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.YELLOW_50));
        this.paint.setTextSize(this.multiplier * 16);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.OPEN_SANS_SEMIBOLD));
        return this.paint;
    }

    private Paint toTitle22Highlight() {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(Pallette.YELLOW_50));
        this.paint.setTextSize(this.multiplier * 22);
        this.paint.setTypeface(this.fontTypeFactory.getFont(FontTypeVariant.OPEN_SANS_SEMIBOLD));
        return this.paint;
    }

    public Paint getCustomTypeface(int i, String str, String str2) {
        return toCustom(i, str, str2);
    }

    private Paint toCustom(int i, String str, String str2) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.parseColor(str));
        this.paint.setTextSize(i * this.multiplier);
        this.paint.setTypeface(this.fontTypeFactory.getFont(str2));
        return this.paint;
    }
}
