package id.dana.danah5.screenshot;

/* loaded from: classes2.dex */
public class ScreenshotBridgeModel {
    private String dataType;
    private String filename;
    private String imageFormat;
    private int maxHeight;
    private int maxWidth;
    private int quality;
    private boolean saveToGallery;

    public ScreenshotBridgeModel(String str, int i, int i2, boolean z, String str2, String str3, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("DANA_");
        sb.append(str);
        this.filename = sb.toString();
        this.maxWidth = i;
        this.maxHeight = i2;
        this.saveToGallery = z;
        this.dataType = str2;
        this.imageFormat = str3;
        this.quality = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFilename() {
        return this.filename;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSaveToGallery() {
        return this.saveToGallery;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDataType() {
        return this.dataType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getImageFormat() {
        return this.imageFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getQuality() {
        return this.quality;
    }
}
