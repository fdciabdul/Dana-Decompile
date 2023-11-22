package com.fullstory.instrumentation.frameworks.compose;

import android.graphics.Canvas;

/* loaded from: classes.dex */
public interface FSComposeLayoutNode {
    FSComposeLayoutCoordinates _fsGetCoordinates();

    FSComposeModifier _fsGetModifier();

    FSComposeNodeCoordinator _fsGetOuterCoordinator();

    Object _fsGetOwner();

    FSComposeLayoutNode _fsGetParent();

    FSComposeSemanticsConfiguration _fsGetSemanticsConfiguration(FSComposeSemanticsModifier fSComposeSemanticsModifier);

    int _fsGetSemanticsId();

    boolean _fsIsAttached();

    FSComposeCanvas _fsWrapCanvas(Canvas canvas);
}
