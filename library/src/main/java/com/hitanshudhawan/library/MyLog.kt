package com.hitanshudhawan.library

import android.util.Log

object MyLog {

    @JvmStatic
    fun v(tag: String, msg: String) = Log.v(tag, msg)

    @JvmStatic
    fun d(tag: String, msg: String) = Log.d(tag, msg)

    @JvmStatic
    fun i(tag: String, msg: String) = Log.i(tag, msg)

    @JvmStatic
    fun w(tag: String, msg: String) = Log.w(tag, msg)

    @JvmStatic
    fun e(tag: String, msg: String) = Log.e(tag, msg)

}
