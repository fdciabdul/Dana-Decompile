package com.alibaba.griver.image.capture.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.griver.image.R;

/* loaded from: classes6.dex */
public class CaptureBtn extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Type f6572a;
    public ImageView takePictureBtn;

    /* loaded from: classes6.dex */
    public enum Type {
        NONE,
        VIDEO,
        PICTURE
    }

    public CaptureBtn(Context context) {
        this(context, null, 0);
    }

    public CaptureBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6572a = Type.NONE;
        LayoutInflater.from(context).inflate(R.layout.griver_image_view_capture_btn, (ViewGroup) this, true);
        this.takePictureBtn = (ImageView) findViewById(R.id.takePicture);
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.image.capture.widget.CaptureBtn$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$image$capture$widget$CaptureBtn$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$alibaba$griver$image$capture$widget$CaptureBtn$Type = iArr;
            try {
                iArr[Type.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$image$capture$widget$CaptureBtn$Type[Type.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$image$capture$widget$CaptureBtn$Type[Type.PICTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void a() {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$image$capture$widget$CaptureBtn$Type[this.f6572a.ordinal()];
        if (i == 1) {
            this.takePictureBtn.setVisibility(8);
        } else if (i == 2) {
            this.takePictureBtn.setVisibility(8);
        } else if (i == 3) {
            this.takePictureBtn.setVisibility(0);
        }
    }

    public void setViewType(Type type) {
        this.f6572a = type;
        a();
    }
}
