package com.otaliastudios.cameraview.filter;

import android.opengl.GLES20;
import com.otaliastudios.cameraview.internal.GlUtils;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class MultiFilter implements Filter, OneParameterFilter, TwoParameterFilter {
    private float BuiltInFictitiousFunctionClassFactory;
    final List<Filter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Object MyBillsEntityDataFactory;
    private Size NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float PlaceComponentResult;
    final Map<Filter, State> getAuthRequestContext;

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class State {
        boolean BuiltInFictitiousFunctionClassFactory = false;
        boolean getAuthRequestContext = false;
        Size KClassImpl$Data$declaredNonStaticMembers$2 = null;
        private int PlaceComponentResult = -1;
        private int MyBillsEntityDataFactory = -1;
        private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;

        State() {
        }
    }

    private MultiFilter(Filter... filterArr) {
        this(Arrays.asList(filterArr));
    }

    private MultiFilter(Collection<Filter> collection) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.getAuthRequestContext = new HashMap();
        this.MyBillsEntityDataFactory = new Object();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.PlaceComponentResult = 0.0f;
        Iterator<Filter> it = collection.iterator();
        while (it.hasNext()) {
            PlaceComponentResult(it.next());
        }
    }

    private void PlaceComponentResult(Filter filter) {
        if (filter instanceof MultiFilter) {
            Iterator<Filter> it = ((MultiFilter) filter).KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                PlaceComponentResult(it.next());
            }
            return;
        }
        synchronized (this.MyBillsEntityDataFactory) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.contains(filter)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(filter);
                this.getAuthRequestContext.put(filter, new State());
            }
        }
    }

    private void getAuthRequestContext(Filter filter) {
        State state = this.getAuthRequestContext.get(filter);
        Size size = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (size == null || size.equals(state.KClassImpl$Data$declaredNonStaticMembers$2)) {
            return;
        }
        state.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        filter.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String getAuthRequestContext() {
        return new NoFilter().getAuthRequestContext();
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return new NoFilter().NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this.MyBillsEntityDataFactory) {
            for (Filter filter : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                State state = this.getAuthRequestContext.get(filter);
                if (state.getAuthRequestContext) {
                    state.getAuthRequestContext = false;
                    GLES20.glDeleteFramebuffers(1, new int[]{state.MyBillsEntityDataFactory}, 0);
                    state.MyBillsEntityDataFactory = -1;
                    GLES20.glDeleteTextures(1, new int[]{state.NetworkUserEntityData$$ExternalSyntheticLambda0}, 0);
                    state.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
                }
                State state2 = this.getAuthRequestContext.get(filter);
                if (state2.BuiltInFictitiousFunctionClassFactory) {
                    state2.BuiltInFictitiousFunctionClassFactory = false;
                    filter.BuiltInFictitiousFunctionClassFactory();
                    GLES20.glDeleteProgram(state2.PlaceComponentResult);
                    state2.PlaceComponentResult = -1;
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Size(i, i2);
        synchronized (this.MyBillsEntityDataFactory) {
            Iterator<Filter> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                getAuthRequestContext(it.next());
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j, float[] fArr) {
        synchronized (this.MyBillsEntityDataFactory) {
            int i = 0;
            while (i < this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
                boolean z = i == 0;
                boolean z2 = i == this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1;
                Filter filter = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
                State state = this.getAuthRequestContext.get(filter);
                getAuthRequestContext(filter);
                State state2 = this.getAuthRequestContext.get(filter);
                if (!state2.BuiltInFictitiousFunctionClassFactory) {
                    state2.BuiltInFictitiousFunctionClassFactory = true;
                    String NetworkUserEntityData$$ExternalSyntheticLambda0 = filter.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (!z) {
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0.replace("samplerExternalOES ", "sampler2D ");
                    }
                    state2.PlaceComponentResult = GlUtils.MyBillsEntityDataFactory(filter.getAuthRequestContext(), NetworkUserEntityData$$ExternalSyntheticLambda0);
                    filter.BuiltInFictitiousFunctionClassFactory(state2.PlaceComponentResult);
                }
                if (!z2) {
                    State state3 = this.getAuthRequestContext.get(filter);
                    if (!state3.getAuthRequestContext) {
                        state3.getAuthRequestContext = true;
                        int[] iArr = new int[1];
                        int[] iArr2 = new int[1];
                        GLES20.glGenFramebuffers(1, iArr, 0);
                        GLES20.glGenTextures(1, iArr2, 0);
                        state3.MyBillsEntityDataFactory = iArr[0];
                        state3.NetworkUserEntityData$$ExternalSyntheticLambda0 = iArr2[0];
                        GLES20.glBindTexture(3553, state3.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        GLES20.glTexImage2D(3553, 0, 6408, state3.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, state3.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, 0, 6408, 5121, null);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glBindFramebuffer(36160, state3.MyBillsEntityDataFactory);
                        GLES20.glFramebufferTexture2D(36160, 36064, 3553, state3.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
                        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                        if (glCheckFramebufferStatus != 36053) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid framebuffer generation. Error:");
                            sb.append(glCheckFramebufferStatus);
                            throw new RuntimeException(sb.toString());
                        }
                        GLES20.glBindTexture(3553, 0);
                        GLES20.glBindFramebuffer(36160, 0);
                    }
                }
                GLES20.glUseProgram(state.PlaceComponentResult);
                if (!z2) {
                    GLES20.glBindFramebuffer(36160, state.MyBillsEntityDataFactory);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    GLES20.glBindFramebuffer(36160, 0);
                }
                if (z) {
                    filter.KClassImpl$Data$declaredNonStaticMembers$2(j, fArr);
                } else {
                    filter.KClassImpl$Data$declaredNonStaticMembers$2(j, GlUtils.getAuthRequestContext);
                }
                if (!z2) {
                    GLES20.glBindTexture(3553, state.NetworkUserEntityData$$ExternalSyntheticLambda0);
                } else {
                    GLES20.glBindTexture(3553, 0);
                }
                GLES20.glUseProgram(0);
                i++;
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public final Filter PlaceComponentResult() {
        MultiFilter multiFilter;
        synchronized (this.MyBillsEntityDataFactory) {
            multiFilter = new MultiFilter(new Filter[0]);
            Iterator<Filter> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                multiFilter.PlaceComponentResult(it.next().PlaceComponentResult());
            }
        }
        return multiFilter;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final void getAuthRequestContext(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        synchronized (this.MyBillsEntityDataFactory) {
            for (Filter filter : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (filter instanceof OneParameterFilter) {
                    ((OneParameterFilter) filter).getAuthRequestContext(f);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public final void PlaceComponentResult(float f) {
        this.PlaceComponentResult = f;
        synchronized (this.MyBillsEntityDataFactory) {
            for (Filter filter : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (filter instanceof TwoParameterFilter) {
                    ((TwoParameterFilter) filter).PlaceComponentResult(f);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public final float MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }
}
