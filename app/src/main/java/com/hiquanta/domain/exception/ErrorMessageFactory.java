package com.hiquanta.domain.exception;

import android.content.Context;

import com.hiquanta.domain.R;

/**
 * Created by hiquanta on 2016/9/26.
 */

public class ErrorMessageFactory {
    private ErrorMessageFactory() {

    }
    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);
        return message;
    }
}