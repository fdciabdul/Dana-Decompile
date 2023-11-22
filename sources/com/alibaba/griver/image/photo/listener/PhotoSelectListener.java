package com.alibaba.griver.image.photo.listener;

import android.os.Bundle;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface PhotoSelectListener {
    void onPhotoSelected(List<PhotoInfo> list, Bundle bundle);

    void onSelectCanceled();
}
