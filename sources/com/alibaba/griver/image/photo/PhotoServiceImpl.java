package com.alibaba.griver.image.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.image.activity.GriverPhotoPreviewActivity;
import com.alibaba.griver.image.activity.GriverPhotoSelectActivity;
import com.alibaba.griver.image.photo.listener.PhotoBrowseListener;
import com.alibaba.griver.image.photo.listener.PhotoSelectListener;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alibaba.griver.image.photo.meta.PhotoItem;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.image.photo.utils.AnimationUtil;
import com.alibaba.griver.image.photo.utils.ImageHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class PhotoServiceImpl extends PhotoService {
    public static final String EXTRA_SOURCE_APP_ID = "SourceAppId";
    public static final String TAG = "PhotoServiceImpl";
    public static String sCallerAPPId;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f6603a;

    public PhotoServiceImpl() {
        RVLogger.d("beehive-photo", "PhotoServiceImpl initialized");
        this.f6603a = new AtomicInteger(0);
    }

    @Override // com.alibaba.griver.image.photo.PhotoService
    public void selectPhoto(App app, Bundle bundle, PhotoSelectListener photoSelectListener) {
        selectPhoto(app, null, bundle, photoSelectListener);
    }

    private void a(App app, Bundle bundle, Intent intent) {
        bundle.putInt(PhotoParam.VIDEO_SHOW_TYPE, 1);
        WeakReference<Activity> topActivity = GriverEnv.getTopActivity();
        if (topActivity != null) {
            Activity activity = topActivity.get();
            intent.putExtras(bundle);
            if (activity != null) {
                activity.startActivity(intent);
                AnimationUtil.fadeInFadeOut(activity);
            }
        }
    }

    @Override // com.alibaba.griver.image.photo.PhotoService
    public void selectPhoto(App app, List<PhotoInfo> list, Bundle bundle, PhotoSelectListener photoSelectListener) {
        if (photoSelectListener == null || app == null) {
            RVLogger.e(TAG, "invalid selectPhoto parameters!");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        a(app, bundle);
        String a2 = a();
        StringBuilder sb = new StringBuilder();
        sb.append("selectPhoto context index ");
        sb.append(a2);
        RVLogger.d(TAG, sb.toString());
        bundle.putString(PhotoParam.CONTEXT_INDEX, a2);
        bundle.putBoolean(PhotoParam.PHOTO_SELECT, true);
        PhotoContext photoContext = PhotoContext.get(a2);
        photoContext.photoList = null;
        photoContext.selectListener = photoSelectListener;
        Intent intent = new Intent(GriverEnv.getApplicationContext(), bundle.getBoolean(PhotoParam.SELECT_GRID, true) ? GriverPhotoSelectActivity.class : GriverPhotoPreviewActivity.class);
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<PhotoInfo> it = list.iterator();
            while (it.hasNext()) {
                PhotoItem photoItem = new PhotoItem(it.next());
                if (photoItem.getSelected()) {
                    photoContext.selectedList.add(photoItem);
                }
                arrayList.add(photoItem);
            }
            if (!arrayList.isEmpty()) {
                photoContext.photoList = arrayList;
            }
        }
        a(app, bundle, intent);
    }

    @Override // com.alibaba.griver.image.photo.PhotoService
    public void browsePhoto(App app, List<PhotoInfo> list, Bundle bundle, PhotoBrowseListener photoBrowseListener) {
        if (app == null) {
            RVLogger.e(TAG, "invalid browsePhoto parameters!");
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        String a2 = a();
        StringBuilder sb = new StringBuilder();
        sb.append("browsePhoto context index ");
        sb.append(a2);
        RVLogger.d(TAG, sb.toString());
        PhotoContext.get(a2).previewListener = photoBrowseListener;
        if (bundle == null) {
            bundle = new Bundle();
        }
        a(app, bundle);
        bundle.putString(PhotoParam.CONTEXT_INDEX, a2);
        bundle.putString(EXTRA_SOURCE_APP_ID, app.getAppId());
        Intent intent = new Intent(GriverEnv.getApplicationContext(), bundle.getBoolean(PhotoParam.BROWSE_GRID, false) ? GriverPhotoSelectActivity.class : GriverPhotoPreviewActivity.class);
        ArrayList arrayList = new ArrayList();
        PhotoContext photoContext = PhotoContext.get(a2);
        for (int i = 0; i < list.size(); i++) {
            PhotoItem photoItem = new PhotoItem(list.get(i));
            photoItem.setPhotoIndex(i);
            if (photoItem.getSelected()) {
                photoContext.selectedList.add(photoItem);
            }
            arrayList.add(photoItem);
        }
        photoContext.photoList = arrayList;
        bundle.putInt(PhotoParam.VIDEO_SHOW_TYPE, 0);
        intent.putExtras(bundle);
        WeakReference<Activity> topActivity = GriverEnv.getTopActivity();
        if (topActivity != null) {
            Activity activity = topActivity.get();
            intent.putExtras(bundle);
            if (activity != null) {
                activity.startActivity(intent);
                AnimationUtil.fadeInFadeOut(activity);
            }
        }
    }

    private String a() {
        int andIncrement = this.f6603a.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        sb.append("photoSvs");
        sb.append(andIncrement);
        return sb.toString();
    }

    private void a(App app, Bundle bundle) {
        String obj;
        String string = bundle.getString("businessId");
        if (TextUtils.isEmpty(string)) {
            String appId = app.getAppId();
            sCallerAPPId = appId;
            bundle.putString("businessId", appId);
            StringBuilder sb = new StringBuilder();
            sb.append("Caller did not supply BUSINESS_ID,simply take APP_ID,which  = ");
            sb.append(appId);
            obj = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Caller BUSINESS_ID = ");
            sb2.append(string);
            obj = sb2.toString();
        }
        RVLogger.w(TAG, obj);
        ImageHelper.updateBizType(bundle.getString("MULTI_MEDIA_BIZ_TYPE"));
    }
}
