package com.alipay.mobile.security.bio.service.impl;

import android.os.Handler;
import android.os.Looper;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadCallBack;
import com.alipay.mobile.security.bio.service.BioUploadItem;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.thread.WatchThread;
import com.alipay.mobile.security.bio.workspace.Env;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class BioUploadWatchThread extends WatchThread {
    private List<BioUploadCallBack> mBioUploadCallBacks;
    private BioUploadGW mBioUploadGW;
    private AtomicBoolean mClearUpFlag;
    private BlockingQueue<BioUploadItem> mImageCache;
    public Handler mMainHandle;
    private AtomicBoolean mQuitLaterFlag;

    public void addBioUploadCallBack(BioUploadCallBack bioUploadCallBack) {
        synchronized (this) {
            if (!this.mBioUploadCallBacks.contains(bioUploadCallBack)) {
                this.mBioUploadCallBacks.add(bioUploadCallBack);
            }
        }
    }

    public BioUploadWatchThread(String str, BioServiceManager bioServiceManager) {
        super(str);
        this.mImageCache = new LinkedBlockingQueue(5);
        this.mBioUploadCallBacks = new ArrayList();
        this.mQuitLaterFlag = new AtomicBoolean(false);
        if (bioServiceManager == null) {
            throw new BioIllegalArgumentException("BioServiceManager can't be null.");
        }
        try {
            Constructor<?> constructor = Class.forName(Env.getProtocolFormat(bioServiceManager.getBioApplicationContext()) != 2 ? "com.alipay.mobile.security.bio.service.impl.BioUploadJsonGWImpl" : "com.alipay.mobile.security.bio.service.impl.BioUploadPBGWImpl").getConstructor(BioServiceManager.class);
            constructor.setAccessible(true);
            this.mBioUploadGW = (BioUploadGW) constructor.newInstance(bioServiceManager);
        } catch (Throwable unused) {
        }
        this.mMainHandle = new Handler(Looper.getMainLooper());
    }

    @Override // com.alipay.mobile.security.bio.thread.WatchThread
    public void task() {
        BioUploadItem poll;
        try {
            if (checkAndQuitUpload() || (poll = this.mImageCache.poll(50L, TimeUnit.SECONDS)) == null) {
                return;
            }
            this.mClearUpFlag.set(false);
            final BioUploadResult upload = this.mBioUploadGW.upload(poll);
            if (this.mClearUpFlag.getAndSet(false) || this.mBioUploadCallBacks.isEmpty() || upload == null || this.mMainHandle == null || !poll.isNeedSendResponse) {
                return;
            }
            this.mMainHandle.post(new Runnable() { // from class: com.alipay.mobile.security.bio.service.impl.BioUploadWatchThread.1
                @Override // java.lang.Runnable
                public void run() {
                    BioUploadWatchThread.this.doCallback(upload);
                }
            });
        } catch (Exception unused) {
        }
    }

    public boolean isFulled() {
        return this.mImageCache.size() >= 5;
    }

    public void addBioUploadItem(BioUploadItem bioUploadItem) {
        try {
            if (this.mImageCache.add(bioUploadItem)) {
                return;
            }
            this.mMainHandle.post(new Runnable() { // from class: com.alipay.mobile.security.bio.service.impl.BioUploadWatchThread.2
                @Override // java.lang.Runnable
                public void run() {
                    BioUploadResult bioUploadResult = new BioUploadResult();
                    bioUploadResult.productRetCode = 4001;
                    BioUploadWatchThread.this.doCallback(bioUploadResult);
                }
            });
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(BioUploadResult bioUploadResult) {
        synchronized (this) {
            if (this.mQuitLaterFlag.get()) {
                return;
            }
            boolean z = false;
            Iterator<BioUploadCallBack> it = this.mBioUploadCallBacks.iterator();
            while (it.hasNext() && !z) {
                z = it.next().onResponse(bioUploadResult);
            }
        }
    }

    public void release() {
        this.mBioUploadCallBacks.clear();
        this.mImageCache.clear();
        this.mBioUploadGW = null;
        kill();
    }

    public boolean isEmpty() {
        BlockingQueue<BioUploadItem> blockingQueue = this.mImageCache;
        return blockingQueue == null || blockingQueue.isEmpty();
    }

    public void clearBioUploadCallBacks() {
        synchronized (this) {
            AtomicBoolean atomicBoolean = this.mClearUpFlag;
            if (atomicBoolean == null) {
                this.mClearUpFlag = new AtomicBoolean(false);
            } else {
                atomicBoolean.set(true);
            }
            this.mBioUploadCallBacks.clear();
        }
    }

    public void clearUploadItems() {
        this.mImageCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void quitLater() {
        this.mQuitLaterFlag.set(true);
    }

    private boolean checkAndQuitUpload() {
        if (this.mImageCache.isEmpty() && this.mQuitLaterFlag.get()) {
            release();
            this.mQuitLaterFlag.set(false);
            return true;
        }
        return false;
    }
}
