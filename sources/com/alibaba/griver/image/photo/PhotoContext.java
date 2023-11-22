package com.alibaba.griver.image.photo;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.photo.listener.PhotoBrowseListener;
import com.alibaba.griver.image.photo.listener.PhotoSelectListener;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alibaba.griver.image.photo.meta.PhotoItem;
import com.alibaba.griver.image.photo.meta.PhotoMenu;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.image.photo.utils.ImageHelper;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import com.alipay.multimedia.adjuster.api.APMSandboxProcessor;
import com.alipay.multimedia.adjuster.api.data.APMSaveReq;
import com.alipay.multimedia.adjuster.utils.PathUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PhotoContext {
    public static final String FILE_SCHEME = "file://";
    public static final String TAG = "PhotoContext";
    public static Map<String, PhotoContext> contextMap = new HashMap();
    public String contextIndex;
    public PhotoResolver photoResolver;
    public Map<String, Map<String, Object>> photosExtraInfo;
    public PhotoBrowseListener previewListener;
    public PhotoSelectListener selectListener;
    public List<PhotoItem> photoList = new ArrayList();
    public List<PhotoItem> selectedList = new ArrayList();
    public boolean userOriginPhoto = false;
    public boolean previewPageRunning = false;
    public boolean selectSent = false;
    public boolean gridPageRunning = false;
    public boolean editSent = false;

    private void a(Activity activity, boolean z) {
    }

    public static void remove(String str) {
        if (contextMap.containsKey(str)) {
            contextMap.remove(str);
        }
    }

    public static PhotoContext get(String str) {
        PhotoContext photoContext;
        if (contextMap.containsKey(str)) {
            photoContext = contextMap.get(str);
        } else {
            PhotoContext photoContext2 = new PhotoContext(str);
            contextMap.put(str, photoContext2);
            photoContext = photoContext2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("context map size ");
        sb.append(contextMap.size());
        RVLogger.d(TAG, sb.toString());
        return photoContext;
    }

    private PhotoContext(String str) {
        this.contextIndex = str;
    }

    public void sendDeletedPhoto() {
        if (this.previewListener == null) {
            InstrumentInjector.log_w(TAG, "previewListener is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        Iterator<PhotoItem> it = this.photoList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendDeletePhoto size ");
        sb.append(arrayList.size());
        RVLogger.d(TAG, sb.toString());
        this.previewListener.onPhotoDelete(arrayList, bundle);
    }

    public void sendSelectedPhoto(final Activity activity, final float f, final int i, final Runnable runnable, final boolean z) {
        if (this.selectListener == null) {
            InstrumentInjector.log_w(TAG, "selectListener is null");
            a(runnable);
        } else if (this.selectedList.isEmpty()) {
            RVLogger.d(TAG, "no photo selected!");
            a(runnable);
        } else {
            final Bundle bundle = new Bundle();
            bundle.putBoolean(PhotoParam.USE_ORIGIN_PHOTO, this.userOriginPhoto);
            final List<PhotoInfo> arrayList = new ArrayList<>();
            for (PhotoItem photoItem : this.selectedList) {
                arrayList.add(photoItem);
                a(photoItem);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sendSelectedPhoto size ");
            sb.append(arrayList.size());
            RVLogger.d(TAG, sb.toString());
            if (PhotoUtil.isQCompact()) {
                RVLogger.d(TAG, "QCompact case.");
                a(activity, true);
                GriverExecutors.getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.griver.image.photo.PhotoContext.1
                    {
                        PhotoContext.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        PhotoContext.this.a(arrayList, activity);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Image copy cost = ");
                        sb2.append(System.currentTimeMillis() - currentTimeMillis);
                        RVLogger.d(PhotoContext.TAG, sb2.toString());
                        PhotoContext.this.a(f, activity, runnable, bundle, arrayList, i, z);
                    }
                });
                return;
            }
            a(f, activity, runnable, bundle, arrayList, i, z);
        }
    }

    public void a(List<PhotoInfo> list, Activity activity) {
        String obj;
        RVLogger.d(TAG, "doCopyInQ###");
        for (int i = 0; i < list.size(); i++) {
            PhotoInfo photoInfo = list.get(i);
            if (photoInfo.getMediaType() == 0 && photoInfo.getPhotoPath().startsWith(PathUtils.CONTENT_SCHEMA)) {
                String photoPath = photoInfo.getPhotoPath();
                String a2 = a(photoPath, activity);
                StringBuilder sb = new StringBuilder();
                sb.append(GriverEnv.getApplicationContext().getExternalCacheDir().getAbsolutePath());
                sb.append(File.separator);
                sb.append("griver");
                sb.append(File.separator);
                sb.append("tmp");
                sb.append(File.separator);
                String obj2 = sb.toString();
                if (TextUtils.isEmpty(a2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    obj = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(System.currentTimeMillis());
                    sb3.append(".");
                    sb3.append(getExtension(a2));
                    obj = sb3.toString();
                }
                APMSaveReq.Builder builder = new APMSaveReq.Builder(photoInfo.getPhotoPath(), ImageHelper.getBizType());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj2);
                sb4.append(obj);
                String copyContentUriFile = APMSandboxProcessor.copyContentUriFile(builder.savePath(sb4.toString()).context(activity.getApplicationContext()).build());
                photoInfo.shadowPathInQ = photoInfo.getPhotoPath();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(FILE_SCHEME);
                sb5.append(copyContentUriFile);
                photoInfo.setPhotoPath(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Copy ");
                sb6.append(photoPath);
                sb6.append(" to ");
                sb6.append(copyContentUriFile);
                RVLogger.d(TAG, sb6.toString());
            }
        }
    }

    public static String getExtension(String str) {
        int lastIndexOf;
        if (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(".")) <= 0) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    private String a(String str, Context context) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String[] strArr = {"_display_name"};
        Cursor query = context.getContentResolver().query(Uri.parse(str), strArr, null, null, null);
        if (query != null) {
            query.moveToFirst();
            try {
                str2 = query.getString(query.getColumnIndex(strArr[0]));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("cursor.getString exception ");
                sb.append(e.getMessage());
                GriverLogger.e(TAG, sb.toString());
            }
            try {
                query.close();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cursor.close exception ");
                sb2.append(e2.getMessage());
                GriverLogger.e(TAG, sb2.toString());
            }
        }
        return str2;
    }

    public void a(float f, Activity activity, final Runnable runnable, final Bundle bundle, final List<PhotoInfo> list, int i, boolean z) {
        activity.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.image.photo.PhotoContext.2
            {
                PhotoContext.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                RVLogger.d(PhotoContext.TAG, "No need beauty.");
                PhotoContext.this.selectListener.onPhotoSelected(list, bundle);
                PhotoContext.this.selectSent = true;
                PhotoContext.this.a(runnable);
            }
        });
    }

    private void a(PhotoItem photoItem) {
        Map<String, Map<String, Object>> map = this.photosExtraInfo;
        if (map == null || !map.containsKey(photoItem.getPhotoPath())) {
            return;
        }
        photoItem.extraInfo = this.photosExtraInfo.get(photoItem.getPhotoPath());
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean photoLongPressMenuClick(Activity activity, PhotoInfo photoInfo, PhotoMenu photoMenu) {
        if (this.previewListener == null || photoInfo == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("photoLongPressMenuClick ");
        sb.append(photoMenu.title);
        RVLogger.d(TAG, sb.toString());
        return this.previewListener.onLongPressMenuClick(activity, photoInfo, photoMenu);
    }
}
