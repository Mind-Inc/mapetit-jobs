package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.cancel;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;

public class CancelRequest {
    private Context context;
    private CancelMessage message;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public CancelMessage getMessage() {
        return message;
    }

    public void setMessage(CancelMessage message) {
        this.message = message;
    }
}
