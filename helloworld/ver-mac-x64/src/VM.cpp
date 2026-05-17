#include "VM.h"
#include <QDebug>

VM::VM() : QObject(nullptr) {
    _mainIsVisible = false;
    _mainTaskTitle = "";
}

void VM::mainSetIsVisible(bool value) {
    if (_mainIsVisible != value) {
        _mainIsVisible = value;
        emit mainDidChangeIsVisible(value);
    }
}

void VM::mainSetTaskTitle(const QString &value) {
    if (_mainTaskTitle != value) {
        _mainTaskTitle = value;
        emit mainDidChangeTaskTitle(value);
    }
}

void VM::mainSetTasks(const QVariantList &tasksValue) {
    _tasks = tasksValue;
    emit mainDidChangeTasks(_tasks);
}

void VM::clearTasks() {
    _tasks.clear();
    emit mainDidChangeTasks(_tasks);
}

void VM::addAllTasks(const QVariantList &tasksValue) {
    for (const auto &task : tasksValue) {
        _tasks.append(task);
    }
    emit mainDidChangeTasks(_tasks);
}