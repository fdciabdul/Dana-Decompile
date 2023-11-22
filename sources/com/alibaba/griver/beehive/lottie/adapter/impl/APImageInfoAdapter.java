package com.alibaba.griver.beehive.lottie.adapter.impl;

/* loaded from: classes6.dex */
public class APImageInfoAdapter {
    public int correctHeight;
    public int correctWidth;
    public int height;
    public int orientation;
    public int rotation;
    public String type;
    public int width;

    private int getImageRotation(int i) {
        if (i != 1) {
            if (i != 3) {
                if (i != 6) {
                    return i != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        }
        return 0;
    }

    public APImageInfoAdapter() {
        this.orientation = 1;
        this.type = "";
    }

    public APImageInfoAdapter(int i, int i2, int i3) {
        this.type = "";
        this.width = i;
        this.height = i2;
        this.orientation = i3;
        this.rotation = getImageRotation(i3);
        reviseWidthAndHeight();
    }

    private void reviseWidthAndHeight() {
        int i = this.orientation;
        if (i == 6 || i == 8) {
            this.correctWidth = this.height;
            this.correctHeight = this.width;
            return;
        }
        this.correctWidth = this.width;
        this.correctHeight = this.height;
    }
}
