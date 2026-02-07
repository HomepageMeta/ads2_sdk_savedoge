package com.xn.ads2.ads2_sdk_savedoge

import android.content.Context
import com.monetize.core.MonetizeCoreSdk

object SaveDogeHelper {

    fun saveDogeInit(context: Context) {
        MonetizeCoreSdk.init(context)
    }

    fun saveDogeStart(context: Context) {
        MonetizeCoreSdk.start(context)
    }
}