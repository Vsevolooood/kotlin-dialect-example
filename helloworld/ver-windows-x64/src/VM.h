#ifndef HW_VM_H
#define HW_VM_H

#include <QObject>
#include <QVariant>
#include <QVariantList>

class VM : public QObject {
    Q_OBJECT

    Q_PROPERTY(
            bool mainIsVisible
            READ mainIsVisible
            WRITE mainSetIsVisible
            NOTIFY mainDidChangeIsVisible
    )
    Q_PROPERTY(
            QString mainTaskTitle
            READ mainTaskTitle
            WRITE mainSetTaskTitle
            NOTIFY mainDidChangeTaskTitle
    )
    Q_PROPERTY(
            QVariantList tasks
            READ tasks
            WRITE mainSetTasks
            NOTIFY mainDidChangeTasks
    )

private:
    VM();

public:
    VM(VM const &) = delete;
    void operator=(VM const &) = delete;
    virtual ~VM() { }

    static VM &singleton() {
        static VM instance;
        return instance;
    }

    // Getters
    bool mainIsVisible() const { return _mainIsVisible; }
    QString mainTaskTitle() const { return _mainTaskTitle; }
    QVariantList tasks() const { return _tasks; }

    // Метод для доступа к задачам для модификации (аналог Kotlin)
    QVariantList& mutableTasks() { return _tasks; }

public slots:
            void mainSetIsVisible(bool value);
    void mainSetTaskTitle(const QString &value);
    void mainSetTasks(const QVariantList &tasksValue);

    // Методы для работы со списком задач
    void clearTasks();
    void addAllTasks(const QVariantList &tasksValue);

    signals:
            void mainDidChangeIsVisible(bool value);
    void mainDidChangeTaskTitle(const QString &value);
    void mainDidChangeTasks(const QVariantList &tasksValue);

private:
    bool _mainIsVisible = false;
    QString _mainTaskTitle = "";
    QVariantList _tasks;
};

#endif // HW_VM_H