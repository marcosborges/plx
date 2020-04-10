package plx.base

trait Logger implements ILogger {

    void info (message) {
        _log('info', message)
    }

    void console (message) {
        _log('console', message)
    }

    void error (message) {
        _log('error', message)
    }

    void _log (type, message) {
        println ("${type}: ${message}")
    }
}