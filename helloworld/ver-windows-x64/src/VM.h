#ifndef HW_VM_H
#define HW_VM_H

#include <QObject>

class VM: public QObject {
    Q_OBJECT

    Q_PROPERTY(
        QString mainGreetingText
        READ mainGreetingText
        WRITE mainSetGreetingText
        NOTIFY mainDidChangeGreetingText
    )
    Q_PROPERTY(
        bool mainIsVisible
        READ mainIsVisible
        WRITE mainSetIsVisible
        NOTIFY mainDidChangeIsVisible
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

    public:
        QString mainGreetingText() const &;
        bool mainIsVisible() const;

    public slots:
        void mainSetGreetingText(const QString &value);
        void mainSetIsVisible(bool value);

    signals:
        void mainDidChangeGreetingText(const QString &value);
        void mainDidChangeIsVisible(bool value);

    private:
        QString _mainGreetingText;
        bool _mainIsVisible;
};

#endif // HW_VM_H
