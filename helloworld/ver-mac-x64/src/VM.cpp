#include "KT.h"
#include "VM.h"

VM::VM() : QObject() {
    _mainGreetingText = "TODO-Text";
    _mainIsVisible = false;
}

QString VM::mainGreetingText() const & {
    return _mainGreetingText;
}

bool VM::mainIsVisible() const {
    return _mainIsVisible;
}

void VM::mainSetGreetingText(const QString &value) {
    _mainGreetingText = value;
    emit mainDidChangeGreetingText(value);
}

void VM::mainSetIsVisible(bool value) {
    _mainIsVisible = value;
    emit mainDidChangeIsVisible(value);
}
