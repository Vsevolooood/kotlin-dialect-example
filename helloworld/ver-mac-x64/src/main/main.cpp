#include <any>
#include <cstdio>
#include <vector>

#include "main.h"
#include "ignore.kd.h"

#define CB(code) std::make_any<std::function<void(MainContext)>>([&](MainContext c) { code })
#define VM VM::singleton()

// Forward declarations
void mainLoadTasks();
void mainSaveTasks(MainContext c);
QString formatTasksToString(QVariantList tasks);
QVariantList parseTasksString(QString tasksString);

MainComponent::MainComponent() {
    std::vector<std::any> oneliners = {
            F.isVisible, CB( VM.mainSetIsVisible(c.isVisible()); ),
            F.taskTitle, CB( VM.mainSetTaskTitle(c.taskTitle()); ),
            F.tasks, CB(
                             VM.clearTasks();
                             VM.addAllTasks(c.tasks());
                     ),
            F.loadTasks, CB( mainLoadTasks(); ),
            F.shouldSavaTasks, CB( mainSaveTasks(c); )
    };
    MainEffectRegistry::registerOneliners(KT.mainCtrl(), oneliners);
}

void MainComponent::setup() {
    mainSet(F.didLaunch, true);
}

/*
void mainSaveTasks(MainContext c) {
    try {
        QString tasksString = formatTasksToString(c.tasks());
        SaveManager::saveTasksRaw(tasksString);
    } catch (const std::exception &e) {
        // обработка ошибки
        e.what();
    }
}

void mainLoadTasks() {
    try {
        QString tasksString = SaveManager::loadTasksRaw();
        if (!tasksString.isEmpty()) {
            QVariantList tasks = parseTasksString(tasksString);
            mainSet(F.tasks, tasks);
        }
    } catch (const std::exception &e) {
        // обработка ошибки
        e.what();
    }
}*/
