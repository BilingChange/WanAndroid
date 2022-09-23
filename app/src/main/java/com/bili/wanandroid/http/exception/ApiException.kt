package com.bili.wanandroid.http.exception


class ApiException : RuntimeException {

    private var code: Int? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))

    constructor(message: String, code: Int) : super(Throwable(message)) {
        this.code = code
    }
}