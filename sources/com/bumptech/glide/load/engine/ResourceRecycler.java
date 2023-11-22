package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
class ResourceRecycler {
    private final Handler BuiltInFictitiousFunctionClassFactory = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(Resource<?> resource, boolean z) {
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 || z) {
                this.BuiltInFictitiousFunctionClassFactory.obtainMessage(1, resource).sendToTarget();
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                resource.lookAheadTest();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class ResourceRecyclerCallback implements Handler.Callback {
        ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).lookAheadTest();
                return true;
            }
            return false;
        }
    }
}
