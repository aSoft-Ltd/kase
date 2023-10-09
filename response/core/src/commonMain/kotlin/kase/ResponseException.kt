package kase

abstract class ResponseException : RuntimeException() {
    abstract val status: Status
}